/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import JDBC.Conexion;
import Models.DTO.CitaDTO;
import Models.DTO.CitaEstadoDTO;
import Models.DTO.NotariaDTO;
import Models.DTO.SolicitudTiposDTO;
import Models.DTO.UsuarioDTO;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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
public class CitaEstadoDAO {
    
    private final String FIND_BY_ID = "{call PKG_CITA_ESTADOS.READ_CITA_ESTADO(?,?)}";
    private final String GET_ALL = "{call PKG_CITA_ESTADOS.READ_ALL_CITAS_ESTADOS(?)}";
   
    
      Conexion con = new Conexion();
      
      public CitaEstadoDTO findById(int id) {

        CitaEstadoDTO citaEstado = new CitaEstadoDTO();

        try {
            
            Connection cn = con.open();

            CallableStatement cs = cn.prepareCall(FIND_BY_ID);

            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);

            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(2);

            while (rs.next()) {

                citaEstado.setId_cita_estado(rs.getInt("ID_ESTADO_CITA"));
                citaEstado.setNombre(rs.getString("NOMBRE"));
                
               
       
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return citaEstado;

    }

    public List<CitaEstadoDTO> getAll() {

        List<CitaEstadoDTO> list = new ArrayList<>();

        try {

            Connection cn = con.open();
            CallableStatement cs = cn.prepareCall(GET_ALL);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(1);
            while (rs.next()) {

                CitaEstadoDTO citaEstado = new CitaEstadoDTO();
                citaEstado.setId_cita_estado(rs.getInt("ID_ESTADO_CITA"));
                citaEstado.setNombre(rs.getString("NOMBRE"));
                
             
               
                list.add(citaEstado);
            }


        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return list;
    }
    

}
