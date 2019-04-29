
import Conexion.Conexion;
import Model.DAO.RolDAO;
import Model.DTO.RolDTO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

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

        
        System.out.println(RolDAO.findById(1).toString());
        
        System.out.println("Staring ...");
        
    

        for (RolDTO rol : RolDAO.getAll()) {

            System.out.println(rol.toString());
        }

        System.out.println("Finished ...");
    }

}
