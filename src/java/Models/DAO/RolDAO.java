/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import Conexion.Conexion;
import Models.DTO.RolDTO;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.*;

/**
 *
 * @author willywes
 */
public class RolDAO {

    private final String FIND_BY_ID = "{call PKG_ROLES.FIND_BY_ID(?,?)}";
    private final String GET_ALL = "{call PKG_ROLES.GET_ALL(?)}";

    Conexion con = new Conexion();


    public RolDTO findById(int id) {

        RolDTO rol = new RolDTO();

        try {
            
            Connection cn = con.open();

            CallableStatement cs = cn.prepareCall(FIND_BY_ID);

            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);

            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(2);

            while (rs.next()) {

                rol.setId(rs.getInt("IDROL"));
                rol.setNombre(rs.getString("NOMBRE"));
                rol.setEstado(rs.getBoolean("ESTADO"));
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return rol;

    }

    public List<RolDTO> getAll() {

        List<RolDTO> list = new ArrayList<>();

        try {

            Connection cn = con.open();

            CallableStatement cs = cn.prepareCall(GET_ALL);

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(1);

            while (rs.next()) {

                RolDTO rol = new RolDTO();

                rol.setId(rs.getInt("IDROL"));
                rol.setNombre(rs.getString("NOMBRE"));
                rol.setEstado(rs.getBoolean("ESTADO"));

                list.add(rol);
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return list;
    }
}
