/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Conexion.Conexion;
import Model.DTO.RolDTO;
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

    private static final String FIND_BY_ID = "{call PKG_ROLES.FIND_BY_ID(?,?)}";
    private static final String GET_ALL = "{call PKG_ROLES.GET_ALL(?)}";

    public static RolDTO findById(int id) {

        RolDTO rol = new RolDTO();

        try {

            CallableStatement cs = Conexion.open().prepareCall(FIND_BY_ID);

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
            Conexion.close();
        }

        return rol;

    }

    public static List<RolDTO> getAll() {

        List<RolDTO> list = new ArrayList();

        try {

            CallableStatement cs = Conexion.open().prepareCall(GET_ALL);

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
            Conexion.close();
        }
        
        return list;
    }
}
