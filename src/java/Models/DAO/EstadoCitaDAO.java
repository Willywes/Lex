/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import JDBC.Conexion;
import Models.DTO.CitaDTO;
import Models.DTO.EstadoCitaDTO;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author claudio
 */
public class EstadoCitaDAO {
    private final String GET_ALL = "{call PKG_CITA_ESTADOS.READ_ALL_CITAS_ESTADOS(?)}";
    
     Conexion con = new Conexion();
     
     public List<EstadoCitaDTO> getAll() {

        List<EstadoCitaDTO> list = new ArrayList<>();

        try {

            Connection cn = con.open();
            CallableStatement cs = cn.prepareCall(GET_ALL);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(1);
            while (rs.next()) {

                EstadoCitaDTO estadoCita = new EstadoCitaDTO();
                estadoCita.setId_estado_cita(rs.getInt("ID_ESTADO_CITA"));
                estadoCita.setNombre(rs.getString("NOMBRE"));
                
               
                list.add(estadoCita);
            }


        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return list;
    }
}
