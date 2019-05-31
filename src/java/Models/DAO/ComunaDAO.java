/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import JDBC.Conexion;
import Models.DTO.ComunaDTO;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author willywes
 */
public class ComunaDAO {
    
    private final String GET_ALL = "{call PKG_COMUNAS.READ_ALL_COMUNAS(?)}";
    private final String FIND_BY_ID = "{call PKG_COMUNAS.READ_COMUNAS(?,?)}";
    
    Conexion con;
    
    public ComunaDTO findById(int id) {

        ComunaDTO comuna = new ComunaDTO();

        try {

            con = new Conexion();

            CallableStatement cs = con.open().prepareCall(FIND_BY_ID);

            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);

            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(2);

            while (rs.next()) {

                comuna.setId(rs.getInt("ID_COMUNA"));
                comuna.setNombre(rs.getString("NOMBRE"));
                comuna.setIdProvincia(rs.getInt("ID_PROVINCIA"));    

            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(ComunaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return comuna;

    }

    public List<ComunaDTO> getAll() {

        List<ComunaDTO> list = new ArrayList();

        try {

            con = new Conexion();

            CallableStatement cs = con.open().prepareCall(GET_ALL);

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(1);

            while (rs.next()) {

                ComunaDTO comuna = new ComunaDTO();

               
                comuna.setId(rs.getInt("ID_COMUNA"));
                comuna.setNombre(rs.getString("NOMBRE"));
                comuna.setIdProvincia(rs.getInt("ID_PROVINCIA"));   

                list.add(comuna);
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(ComunaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return list;
    }
    
}
