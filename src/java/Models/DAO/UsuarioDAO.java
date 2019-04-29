/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import Conexion.Conexion;
import Models.DTO.UsuarioDTO;
import java.io.IOException;
import java.sql.CallableStatement;
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
public class UsuarioDAO {

    private static final String FIND_BY_ID = "{call PKG_USUARIOS.FIND_BY_ID(?,?)}";
    private static final String GET_ALL = "{call PKG_USUARIOS.GET_ALL(?)}";

    public static UsuarioDTO findById(int id) {

        UsuarioDTO user = new UsuarioDTO();

        try {

            CallableStatement cs = Conexion.open().prepareCall(FIND_BY_ID);

            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);

            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(2);

            while (rs.next()) {

                user.setId(rs.getInt("IDUSER"));
                user.setNombres(rs.getString("NOMBRES"));
                user.setEstado(rs.getBoolean("ESTADO"));
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close();
        }

        return user;

    }

    public static List<UsuarioDTO> getAll() {

        List<UsuarioDTO> list = new ArrayList();

        try {

            CallableStatement cs = Conexion.open().prepareCall(GET_ALL);

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(1);

            while (rs.next()) {

                UsuarioDTO user = new UsuarioDTO();

                user.setId(rs.getInt("IDROL"));
                user.setNombres(rs.getString("NOMBRES"));
                user.setEstado(rs.getBoolean("ESTADO"));

                list.add(user);
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close();
        }
        
        return list;
    }
}
