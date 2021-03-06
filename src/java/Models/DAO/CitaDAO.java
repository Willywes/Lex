
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
public class CitaDAO {
    private final String FIND_BY_ID = "{call PKG_CITAS.READ_CITA(?,?)}";
    private final String GET_ALL = "{call PKG_CITAS.READ_ALL_CITAS(?)}";
    private final String CREATE = "{call PKG_CITAS.CREATE_CITAS(?,?,?,?,?)}";
    private final String DELETE = "{call PKG_CITAS.DELETE_CITAS(?,?)}" ;
    private final String UPDATE = "{call PKG_CITAS.UPDATE_CITAS(?,?,?,?,?)}";
    private final String BUSCARCITACLIENTE = "{call PKG_CITAS.BUSCAR_CITA_CLIENTE(?,?)}";
    private final String BUSCARCITAESTADO = "{call PKG_CITAS.BUSCAR_CITA_ESTADO(?,?)}";

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
                cita.setFecha_hora(rs.getDate("FECHA_HORA"));
                cita.setId_notaria(rs.getInt("ID_NOTARIA"));
                cita.setId_estado_cita(rs.getInt("ID_ESTADO_CITA"));
               
       
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
            CallableStatement cs = cn.prepareCall(GET_ALL);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(1);
            while (rs.next()) {

                CitaDTO cita = new CitaDTO();
                cita.setId_cita(rs.getInt("ID_CITA"));
                cita.setFecha_hora(rs.getDate("FECHA_HORA"));
                cita.setHora(rs.getTime("FECHA_HORA"));
                cita.setId_notaria(rs.getInt("ID_NOTARIA"));
                cita.setId_estado_cita(rs.getInt("ID_ESTADO_CITA"));
               
                list.add(cita);
            }


        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return list;
    }
    
    public int create (CitaDTO cita){
        int resultadoOperacion = 0;
            
        try {
            Connection cn = con.open();
            CallableStatement cs = cn.prepareCall(CREATE);
            cs.setInt(1,cita.getId_cita());
            cs.setDate(2, cita.getFecha_hora());
            cs.setInt(3, cita.getId_notaria());
            cs.setInt(4,cita.getId_estado_cita());

            cs.registerOutParameter(5, Types.INTEGER);// salida de parametro 5
            cs.execute();
            
            resultadoOperacion = cs.getInt(5);
            
        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }
        
        return resultadoOperacion;
    }
    
    public CitaDTO delete(int id) {

        CitaDTO cita = new CitaDTO();

        
            
        try {
            
            Connection cn = con.open();

            CallableStatement cs = cn.prepareCall(DELETE);
            
            
            int idTest=4;
           // cs.setInt("ID_CITA",cita.getId_cita());
            cs.setInt(1, id);
            cs.registerOutParameter(2, Types.INTEGER);
            //cs.registerOutParameter(2, OracleTypes.CURSOR);
        
            
            cs.execute();
           // cs.executeUpdate();
            
           

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return cita;

    }
    
        public int update (CitaDTO cita){
        int resultadoOperacion = 0;
            
        try {
            Connection cn = con.open();
            CallableStatement cs = cn.prepareCall(UPDATE);
            cs.setInt(1,cita.getId_cita());
            cs.setDate(2, cita.getFecha_hora());
            cs.setInt(3, cita.getId_notaria());
            cs.setInt(4,cita.getId_estado_cita());

            cs.registerOutParameter(5, Types.INTEGER);// salida de parametro 5
            cs.execute();
            
            resultadoOperacion = cs.getInt(5);
            
        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }
        
        return resultadoOperacion;
    }
        // cambiar estado 
             public int cambiarStatus (int estado){
        
                 if (estado == 1) {
                     estado = 2;
                 }else{
                     estado = 1;
                 }
     
     return estado;
    }   
     
    /*         
    public List<CitaDTO> buscarPorCliente(int id) {
        List<CitaDTO> list = new ArrayList<>();

       // NotariaDTO notaria = new NotariaDTO();
        NotariaDAO notariaDAO = new NotariaDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {

            Connection cn = con.open();

            CallableStatement cs = cn.prepareCall(BUSCARCITACLIENTE);

            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);

            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(2);

            while (rs.next()) {
                CitaDTO cita = new CitaDTO();
                
                //ci.id_cita,ci.fecha_hora,ci.ID_ESTADO_CITA,nota.id_notaria,us.id_usuario
                //nota.direccion,us.nombres,us.paterno,us.id_usuario,nota.id_notaria
                cita.setId_cita(rs.getInt("id_cita"));
                cita.setFecha_hora(rs.getDate("fecha_hora"));
                cita.setId_estado_cita(rs.getInt("ID_ESTADO_CITA"));
               // cita.setId_notaria(rs.getInt("ci.id_notaria"));
               // cita.setId_estado_cita(rs.getInt("ci.ID_ESTADO_CITA"));
                /// ACA REVISAR MAÑANA !  NO EXISTE EL ID DE LA NOTERIA!! REVISAR
                NotariaDTO notaria= notariaDAO.findById(rs.getInt("id_notaria"));
                UsuarioDTO cliente = usuarioDAO.findById(rs.getInt("id_usuario"));
                
                cita.setNotaria(notaria);
                cita.setCliente(cliente);
                
                list.add(cita);
               

            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return list;

    }
    
    
    public List<CitaDTO> buscarPorEstado(int id) {
        List<CitaDTO> list = new ArrayList<>();

       // NotariaDTO notaria = new NotariaDTO();
        NotariaDAO notariaDAO = new NotariaDAO();
        CitaEstadoDAO citaEstadoDAO = new CitaEstadoDAO();

        try {

            Connection cn = con.open();

            CallableStatement cs = cn.prepareCall(BUSCARCITAESTADO);

            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);

            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(2);

            while (rs.next()) {
                CitaDTO cita = new CitaDTO();
                
                //ci.id_cita,ci.fecha_hora,ci.ID_ESTADO_CITA,nota.id_notaria,us.id_usuario
                //nota.direccion,us.nombres,us.paterno,us.id_usuario,nota.id_notaria
                
                cita.setId_cita(rs.getInt("ID_CITA"));
                cita.setFecha_hora(rs.getDate("FECHA_HORA"));
                cita.setId_notaria(rs.getInt("ID_NOTARIA"));
                cita.setId_estado_cita(rs.getInt("ID_ESTADO_CITA"));
               // cita.setId_notaria(rs.getInt("ci.id_notaria"));
               // cita.setId_estado_cita(rs.getInt("ci.ID_ESTADO_CITA"));
                /// ACA REVISAR MAÑANA !  NO EXISTE EL ID DE LA NOTERIA!! REVISAR
                NotariaDTO notaria= notariaDAO.findById(rs.getInt("id_notaria"));
                CitaEstadoDTO citaEstado = citaEstadoDAO.findById(rs.getInt("ID_ESTADO_CITA"));
              // UsuarioDTO cliente = usuarioDAO.findById(rs.getInt("id_usuario"));
                //  ID_CITA FECHA_HO ID_NOTARIA ID_ESTADO_CITA
                cita.setNotaria(notaria);
                cita.setCitaEstado(citaEstado);   
                
                list.add(cita);
               

            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return list;

    }

*/
}
