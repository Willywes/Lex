/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import JDBC.Conexion;
import Models.DTO.CitaDTO;
import Models.DTO.SolicitudTiposDTO;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author claudio
 */
public class CitaDAO {
    private final String FIND_BY_ID = "{call PKG_CITAS.READ_CITA(?)}";
    private final String GET_ALL = "{call PKG_CITAS.READ_ALL_CITAS(?)}";
    private final String CREATE = "{call PKG_CITAS.CREATE_CITAS(?)}";

    Conexion con = new Conexion();


    public CitaDTO findById(int id) {

        CitaDTO cita = new CitaDTO();

        try {
            
            Connection cn = con.open();

            CallableStatement cs = cn.prepareCall(FIND_BY_ID);

            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);

            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(2);

            while (rs.next()) {

                cita.setId_cita(rs.getInt("ID_CITA"));
                cita.setFecha_hora(rs.getString("FECHA_HORA"));
                cita.setId_notaria(rs.getInt("ID_NOTARIA"));
                cita.setId_estado_notaria(rs.getInt("ID_ESTADO_CITA"));
               
       
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return cita;

    }

    public List<CitaDTO> getAll() {

        List<CitaDTO> list = new ArrayList<>();

        try {

            Connection cn = con.open();

            CallableStatement cs = cn.prepareCall(CREATE);

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(1);

          
           
           
            while (rs.next()) {

                CitaDTO cita = new CitaDTO();
                 
                cita.setId_cita(rs.getInt("ID_CITA"));
                cita.setFecha_hora(rs.getString("FECHA_HORA"));
                cita.setId_notaria(rs.getInt("ID_NOTARIA"));
                cita.setId_estado_notaria(rs.getInt("ID_ESTADO_CITA"));
               
                
                list.add(cita);
            }


        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return list;
    }
    
    public CitaDTO create (CitaDTO cita){
        
        try {

            Connection cn = con.open();

            CallableStatement cs = cn.prepareCall(GET_ALL);
            
            cs.setInt("ID_CITA",cita.getId_cita());
            cs.setString("FECHA_HORA", cita.getFecha_hora());
            cs.setInt("ID_NOTARIA", cita.getId_notaria());
            cs.setInt("ID_ESTADO_NOTARIA",cita.getId_estado_notaria());

            
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeUpdate();

       //     ResultSet rs = (ResultSet) cs.getObject(1);

         

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        
        return cita;
    }
    
    
}
