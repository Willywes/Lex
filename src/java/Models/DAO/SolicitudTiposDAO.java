/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import JDBC.Conexion;
import Models.DTO.SolicitudTiposDTO;
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
 * @author claudio
 */
public class SolicitudTiposDAO {

    private final String FIND_BY_ID = "{call PKG_SOLICITUD_TIPOS.READ_SOLICITUD_TIPOS(?,?)}";
    private final String GET_ALL = "{call PKG_SOLICITUD_TIPOS.READ_ALL_SOLICITUDES_TIPOS(?)}";

    Conexion con = new Conexion();


    public SolicitudTiposDTO findById(int id) {

        SolicitudTiposDTO solicitudTipos = new SolicitudTiposDTO();

        try {
            
            Connection cn = con.open();

            CallableStatement cs = cn.prepareCall(FIND_BY_ID);

            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);

            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(2);

            while (rs.next()) {

                solicitudTipos.setId(rs.getInt("ID_TIPO_SOLICITUD"));
                solicitudTipos.setNombre(rs.getString("NOMBRE"));
       
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return solicitudTipos;

    }

    
     
    public List<SolicitudTiposDTO> getAll() {

        List<SolicitudTiposDTO> list = new ArrayList<>();

        try {

            Connection cn = con.open();

            CallableStatement cs = cn.prepareCall(GET_ALL);

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(1);

            while (rs.next()) {

                SolicitudTiposDTO solicitudTipos = new SolicitudTiposDTO();

                solicitudTipos.setId(rs.getInt("ID_TIPO_SOLICITUD"));
                solicitudTipos.setNombre(rs.getString("NOMBRE"));

                list.add(solicitudTipos);
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return list;
    }
}
