/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import JDBC.Conexion;
import Models.DTO.CitaDTO;
import Models.DTO.SolicitudDTO;
import Models.DTO.SolicitudEstadoDTO;
import Models.DTO.SolicitudTiposDTO;
import Models.DTO.UsuarioDTO;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author claudio
 */
public class SolicitudDAO {

  private final String FIND_BY_ID = "{call PKG_SOLICITUDES.READ_SOLICITUD(?,?)}";
  private final String GET_ALL = "{call PKG_SOLICITUDES.READ_ALL_SOLICITUDES(?)}";
  private final String CREATE = "{call PKG_SOLICITUDES.CREATE_SOLICITUD(?,?,?,?,?,?,?,?,?,?)}";
  private final String DELETE = "{call PKG_SOLICITUDES.DELETE_SOLICITUD(?,?)}";
  private final String UPDATE = "{call PKG_SOLICITUDES.UPDATE_SOLICITUD(?,?,?,?,?,?,?,?,?,?)}";
  private final String BUSCAR = "{call PKG_SOLICITUDES.BUSCAR_SOLICITUD_CLIENTE(?,?)}";
  private final String BUSCARFECHAS = "{call PKG_SOLICITUDES.BUSCAR_SOLICITUD_FECHAS(?,?,?)}";
  private final String BUSCARTIPO = "{call PKG_SOLICITUDES.BUSCAR_SOLICITUD_TIPO(?,?)}";
  private final String BUSCARESTADO = "{call PKG_SOLICITUDES.BUSCAR_SOLICITUD_ESTADO(?,?)}";

  
  Conexion con = new Conexion();

  public SolicitudDTO findById(int id) {
    
    SolicitudDTO solicitud = new SolicitudDTO();
    SolicitudTiposDAO solicitudTiposDAO = new SolicitudTiposDAO();
    SolicitudEstadoDAO solicitudEstadoDAO = new SolicitudEstadoDAO();
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    try {
      Connection cn = con.open();
      CallableStatement cs = cn.prepareCall(FIND_BY_ID);
      
      
      cs.setInt(1, id);
      cs.registerOutParameter(2, OracleTypes.CURSOR);
      cs.executeUpdate();

      ResultSet rs = (ResultSet) cs.getObject(2);
      while (rs.next()) {
        solicitud.setId_solicitud(rs.getInt("ID_SOLICITUD"));
        solicitud.setFecha_hora(rs.getDate("FECHA_HORA"));
        solicitud.setDescripcion(rs.getString("DESCRIPCION"));
        
        SolicitudTiposDTO solicitudTiposDTO = solicitudTiposDAO.findById(rs.getInt("ID_TIPO_SOLICITUD"));
        solicitud.setTipoSolicitud(solicitudTiposDTO);
        
        
        SolicitudEstadoDTO solicitudEstadoDTO = solicitudEstadoDAO.findById(rs.getInt("ID_ESTADO_SOLICITUD"));
        solicitud.setEstadoSolicitud(solicitudEstadoDTO);
        
        UsuarioDTO cliente = usuarioDAO.findById(rs.getInt("ID_CLIENTE"));
        solicitud.setCliente(cliente);
        
        UsuarioDTO tecnico = usuarioDAO.findById(rs.getInt("ID_TECNICO"));
        solicitud.setTecnico(tecnico);
//        solicitud.setId_tipo_solicitud(rs.getInt("ID_TIPO_SOLICITUD"));
//        solicitud.setId_estado_solicitud(rs.getInt("ID_ESTADO_SOLICITUD"));
        solicitud.setCreado(rs.getDate("CREADO"));
        solicitud.setModificado(rs.getDate("MODIFICADO"));
//        solicitud.setId_cliente(rs.getInt("ID_CLIENTE"));
//        solicitud.setId_tecnico(rs.getInt("ID_TECNICO"));
      }

    } catch (SQLException | IOException ex) {
      Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      con.close();
    }

    return solicitud;

  }
  ////   Buscar todos!
  public List<SolicitudDTO> getAll() {

    List<SolicitudDTO> list = new ArrayList<>();
    
    SolicitudTiposDAO solicitudTiposDAO = new SolicitudTiposDAO();
    SolicitudEstadoDAO solicitudEstadoDAO = new SolicitudEstadoDAO();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    List<SolicitudTiposDTO> listTipos = new ArrayList<>();
    
    try {

      Connection cn = con.open();
      CallableStatement cs = cn.prepareCall(GET_ALL);
      cs.registerOutParameter(1, OracleTypes.CURSOR);
      cs.executeUpdate();

      ResultSet rs = (ResultSet) cs.getObject(1);
      while (rs.next()) {

        SolicitudDTO solicitud = new SolicitudDTO();
        solicitud.setId_solicitud(rs.getInt("ID_SOLICITUD"));
        solicitud.setFecha_hora(rs.getDate("FECHA_HORA"));
        solicitud.setDescripcion(rs.getString("DESCRIPCION"));
        solicitud.setId_tipo_solicitud(rs.getInt("ID_TIPO_SOLICITUD"));
        
      //  SolicitudTiposDTO solicitudTiposDTO = solicitudTiposDAO.findById(rs.getInt("ID_TIPO_SOLICITUD"));
       //   solicitud.setTipoSolicitud(solicitudTiposDTO);
       solicitud.setId_estado_solicitud(rs.getInt("ID_ESTADO_SOLICITUD"));
       
        solicitud.setId_estado_solicitud(rs.getInt("ID_ESTADO_SOLICITUD"));
    ///    solicitud.setEstadoSolicitud(solicitudEstadoDTO);
        
    
        solicitud.setCreado(rs.getDate("CREADO"));
        solicitud.setModificado(rs.getDate("MODIFICADO"));
        
 //      UsuarioDTO cliente = usuarioDAO.findById(rs.getInt("ID_CLIENTE"));
         solicitud.setId_cliente(rs.getInt("ID_CLIENTE"));
        
 //    UsuarioDTO tecnico = usuarioDAO.findById(rs.getInt("ID_TECNICO"));
        solicitud.setId_tecnico(rs.getInt("ID_TECNICO"));

        list.add(solicitud);
      }
         

    } catch (SQLException | IOException ex) {
      Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      con.close();
      
      /*
      SolicitudDTO solicitud = new SolicitudDTO();
        System.out.println("listo para entrar al for");
        for (SolicitudTiposDTO lista : listTipos) {
            
            if (list.) {
                
            }
            System.out.println(" id tipos dto "+lista.getId());
        }   
*/
    }
  

    return list;
  }

  public int create(SolicitudDTO solicitud) {
    int resultadoOperacion = 0;

    try {
      Connection cn = con.open();
      CallableStatement cs = cn.prepareCall(CREATE);
      cs.setInt(1, solicitud.getId_solicitud());//no null
      cs.setDate(2, solicitud.getFecha_hora());//no null si
      cs.setString(3, solicitud.getDescripcion());//no null si
      cs.setInt(4, solicitud.getTipoSolicitud().getId());//no null si
      cs.setInt(5, solicitud.getEstadoSolicitud().getId_estado_solicitud());//no null si
      cs.setDate(6, solicitud.getCreado());//no null
      cs.setDate(7, solicitud.getModificado());// null
      cs.setInt(8, solicitud.getCliente().getId());//no null
      cs.setInt(9, solicitud.getTecnico().getId());//null
      
      cs.registerOutParameter(10, Types.INTEGER);
      cs.execute();

      resultadoOperacion = cs.getInt(10);

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

      int idTest = 4;
      // cs.setInt("ID_CITA",cita.getId_cita());
      cs.setInt(1, id);
      cs.registerOutParameter(2, Types.INTEGER);
      //cs.registerOutParameter(2, OracleTypes.CURSOR);
      System.out.println("ANTES DE EJECUTAR");
      cs.execute();
      // cs.executeUpdate();

    } catch (SQLException | IOException ex) {
      Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      con.close();
    }

    return cita;

  }

  public int update(SolicitudDTO solicitud) {
    int resultadoOperacion = 0;

    try {
      Connection cn = con.open();
      CallableStatement cs = cn.prepareCall(UPDATE);
      cs.setInt(1, solicitud.getId_solicitud());//no null
      cs.setDate(2, solicitud.getFecha_hora());//no null si
      cs.setString(3, solicitud.getDescripcion());//no null si
      cs.setInt(4, solicitud.getTipoSolicitud().getId());//no null si
      cs.setInt(5, solicitud.getEstadoSolicitud().getId_estado_solicitud());//no null si
      cs.setDate(6, solicitud.getCreado());//no null
      cs.setDate(7, solicitud.getModificado());// null
      cs.setInt(8, solicitud.getCliente().getId());//no null
      cs.setInt(9, solicitud.getTecnico().getId());//null

      cs.registerOutParameter(10, Types.INTEGER);// salida de parametro 10
      cs.execute();

      resultadoOperacion = cs.getInt(10);

    } catch (SQLException | IOException ex) {
      Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      con.close();
    }

    return resultadoOperacion;
  }
  // cambiar estado 

  public int cambiarStatus(int estado) {

    if (estado == 1) {
      estado = 2;
    } else {
      estado = 1;
    }

    return estado;
  }
  // buscar por id
  public List<SolicitudDTO> buscarPorCliente(int id) { //Id de Cliente.
    
    List<SolicitudDTO> list = new ArrayList<>();
    SolicitudTiposDAO solicitudTiposDAO = new SolicitudTiposDAO();
    SolicitudEstadoDAO solicitudEstadoDAO = new SolicitudEstadoDAO();
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    try {
      Connection cn = con.open();
      CallableStatement cs = cn.prepareCall(BUSCAR);
      
      
      cs.setInt(1, id);
      cs.registerOutParameter(2, OracleTypes.CURSOR);
      cs.executeUpdate();

      ResultSet rs = (ResultSet) cs.getObject(2);
      while (rs.next()) {
        SolicitudDTO solicitud = new SolicitudDTO();
        solicitud.setId_solicitud(rs.getInt("ID_SOLICITUD"));
        solicitud.setFecha_hora(rs.getDate("FECHA_HORA"));
        solicitud.setDescripcion(rs.getString("DESCRIPCION"));

        SolicitudTiposDTO solicitudTiposDTO = solicitudTiposDAO.findById(rs.getInt("ID_TIPO_SOLICITUD"));
        
        solicitud.setTipoSolicitud(solicitudTiposDTO);
        
        SolicitudEstadoDTO solicitudEstadoDTO = solicitudEstadoDAO.findById(rs.getInt("ID_ESTADO_SOLICITUD"));
        solicitud.setEstadoSolicitud(solicitudEstadoDTO);
        
        solicitud.setCreado(rs.getDate("CREADO"));
        solicitud.setModificado(rs.getDate("MODIFICADO"));
        
        UsuarioDTO cliente = usuarioDAO.findById(rs.getInt("ID_CLIENTE"));
        solicitud.setCliente(cliente);
        
        UsuarioDTO tecnico = usuarioDAO.findById(rs.getInt("ID_TECNICO"));
        solicitud.setTecnico(tecnico);

        list.add(solicitud);
      }

    } catch (SQLException | IOException ex) {
      Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      con.close();
    }

    return list;

  }
  
  
 
}
