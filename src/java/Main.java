
import Conexion.Conexion;
import Model.DTO.RolDTO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author willywes
 */
public class Main {

    

    public static void main(String[] args) throws SQLException, IOException {
        

        System.out.println("iii");
        
        List<RolDTO> listaRoles;
        listaRoles = readAll();

        listaRoles.forEach((lista) -> {
            lista.toString();
        });
    }

    public static List<RolDTO> readAll() throws SQLException, IOException {
        
        Conexion cone = new Conexion();

        PreparedStatement ps;
        ResultSet rs;
        ArrayList<RolDTO> listaRoles = new ArrayList();

        try {
            String SQL_READALL = "select * from roles";

            cone.open();
            Connection con = cone.getCon();
            
            ps = con.prepareStatement(SQL_READALL);

            rs = ps.executeQuery();

            while (rs.next()) {
                  listaRoles.add(new RolDTO(rs.getInt(1), rs.getString(2), rs.getBoolean(3)));
             
            }
            
            
            
        } catch (SQLException ex) {

        } finally {
            cone.close();
        }

        return listaRoles;
    }

 

}
