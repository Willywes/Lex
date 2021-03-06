/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import JDBC.Conexion;
import Models.DTO.PlanPagoDTO;
import Models.DTO.PresupuestoDTO;
import Models.DTO.PresupuestoDetalleDTO;
import Models.DTO.PresupuestoEstadoDTO;
import Models.DTO.PresupuestoTransaction;
import Models.DTO.SolicitudDTO;
import Models.DTO.SolicitudTiposDTO;
import Models.DTO.UsuarioDTO;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.*;

/**
 *
 * @author Funny
 */
public class PresupuestoDAO {

    private final String CREATE = "{call PKG_PRESUPUESTOS.CREATE_PRESUPUESTOS(?,?,?,?,?)}";
    private final String FIND_BY_ID = "{call PKG_PRESUPUESTOS.READ_PRESUPUESTOS(?)}";
    private final String GET_ALL = "{call PKG_PRESUPUESTOS.READ_ALL_PRESUPUESTOS(?)}";
    private final String DELETE = "{call PKG_PRESUPUESTOS.DELETE_PRESUPUESTOS(?,?)}";
    private final String UPDATE = "{call PKG_PRESUPUESTOS.UPDATE_PRESUPUESTOS(?,?,?,?,?,?,?)}";
    private final String GET_ALL_TRANSACCION = "{call PKG_PRESUPUESTOS.READ_PRESUPUESTOS_TRANSACCION(?)}";
    private final String READ_PRESUPUESTOS_DETAIL = "{call PKG_PRESUPUESTOS.READ_PRESUPUESTOS_DETAIL(?)}";
    private final String UPDATE_PRESUPUESTOS_PARCIAL = "{call PKG_PRESUPUESTOS.UPDATE_PRESUPUESTOS_PARCIAL(?,?,?,?)}";
    private final String READ_CANTIDAD_PRESUPUESTO = "{call PKG_CONTRATOS.READ_CANTIDAD_PRESUPUESTO(?,?)}";

    Conexion con = new Conexion();

    public PresupuestoDTO findById(int id) {

        PresupuestoDTO presupuesto = new PresupuestoDTO();

        try {
            Connection cn = con.open();

            CallableStatement cs = cn.prepareCall(FIND_BY_ID);

            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);

            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(2);

            while (rs.next()) {
                presupuesto.setId_presupuesto(rs.getInt("ID_PRESUPUESTO"));
                presupuesto.setFecha(rs.getDate("FECHA"));
                presupuesto.setId_estado_presupuesto(rs.getInt("ID_ESTADO_PRESUPUESTO"));
                presupuesto.setCreado(rs.getDate("CREADO"));
                presupuesto.setModificado(rs.getDate("MODIFICADO"));
                presupuesto.setId_solicitud(rs.getInt("ID_SOLICITUD"));
                presupuesto.setId_tecnico(rs.getInt("ID_TECNICO"));
                presupuesto.setId_plan_pago(rs.getInt("ID_PLAN_PAGO"));
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return presupuesto;

    }

    public List<PresupuestoDTO> getAll() {

        List<PresupuestoDTO> list = new ArrayList<>();

        try {

            Connection cn = con.open();
            CallableStatement cs = cn.prepareCall(GET_ALL);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(1);
            while (rs.next()) {

                PresupuestoDTO presupuesto = new PresupuestoDTO();
                presupuesto.setId_presupuesto(rs.getInt("ID_PRESUPUESTO"));
                presupuesto.setFecha(rs.getDate("FECHA"));
                presupuesto.setId_estado_presupuesto(rs.getInt("ID_ESTADO_PRESUPUESTO"));
                presupuesto.setCreado(rs.getDate("CREADO"));
                presupuesto.setModificado(rs.getDate("MODIFICADO"));
                presupuesto.setId_solicitud(rs.getInt("ID_SOLICITUD"));
                presupuesto.setId_tecnico(rs.getInt("ID_TECNICO"));
                presupuesto.setId_plan_pago(rs.getInt("ID_PLAN_PAGO"));

                list.add(presupuesto);
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return list;
    }

    public int create(PresupuestoDTO presupuesto) {
        int resultadoOperacion = 0;

        try {
            Connection cn = con.open();
            CallableStatement cs = cn.prepareCall(CREATE);

            cs.setInt(1, presupuesto.getId_estado_presupuesto());
            cs.setInt(2, presupuesto.getId_solicitud());
            cs.setInt(3, presupuesto.getId_tecnico());
            cs.setInt(4, presupuesto.getId_plan_pago());

            cs.registerOutParameter(5, Types.INTEGER);// salida de parametro 9

            cs.execute();

            resultadoOperacion = cs.getInt(5);

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return resultadoOperacion;
    }

    public PresupuestoDTO delete(int id) {

        PresupuestoDTO presupuesto = new PresupuestoDTO();

        try {

            Connection cn = con.open();

            CallableStatement cs = cn.prepareCall(DELETE);

            int idTest = 4;
            // cs.setInt("ID_PRESUPUESTO",presupuesto.getId_presupuesto());
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
        return presupuesto;

    }

    public int update(PresupuestoDTO presupuesto) {
        int resultadoOperacion = 0;
        try {
            Connection cn = con.open();
            CallableStatement cs = cn.prepareCall(UPDATE);

            cs.setInt(1, presupuesto.getId_presupuesto());
            cs.setDate(2, presupuesto.getFecha());
            cs.setInt(3, presupuesto.getId_estado_presupuesto());
            cs.setInt(4, presupuesto.getId_solicitud());
            cs.setInt(5, presupuesto.getId_tecnico());
            cs.setInt(6, presupuesto.getId_plan_pago());

            cs.registerOutParameter(7, Types.INTEGER);// salida de parametro 5
            cs.execute();

            resultadoOperacion = cs.getInt(8);

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return resultadoOperacion;
    }

    public int updateParcial(PresupuestoDTO presupuesto) {
        int resultadoOperacion = 0;
        try {
            Connection cn = con.open();
            CallableStatement cs = cn.prepareCall(UPDATE_PRESUPUESTOS_PARCIAL);

            cs.setInt(1, presupuesto.getId_presupuesto());
            cs.setInt(2, presupuesto.getId_estado_presupuesto());
            cs.setInt(3, presupuesto.getId_plan_pago());

            cs.registerOutParameter(4, Types.INTEGER);// salida de parametro 5
            cs.execute();

            resultadoOperacion = cs.getInt(4);

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return resultadoOperacion;
    }

    public List<PresupuestoTransaction> getAllTransaccion() {

        List<PresupuestoTransaction> list = new ArrayList<>();

        try {

            Connection cn = con.open();
            CallableStatement cs = cn.prepareCall(GET_ALL_TRANSACCION);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(1);
            while (rs.next()) {

                PresupuestoTransaction presupuestoTransaccion = new PresupuestoTransaction();

                PresupuestoDTO presupuesto = new PresupuestoDTO();
                PresupuestoDetalleDTO detalle = new PresupuestoDetalleDTO();
                PresupuestoEstadoDTO estado = new PresupuestoEstadoDTO();
                SolicitudDTO solicitud = new SolicitudDTO();
                PlanPagoDTO PlanPago = new PlanPagoDTO();
                UsuarioDTO usuario = new UsuarioDTO();

                //presupuestos 
                presupuesto.setId_presupuesto(rs.getInt("ID_PRESUPUESTO"));
                presupuesto.setFecha(rs.getDate("FECHA"));
                presupuesto.setCreado(rs.getDate("CREADO"));
                presupuesto.setModificado(rs.getDate("MODIFICADO"));

                //detalles 
                detalle.setMonto(rs.getInt("MONTO"));
                detalle.setServicio(rs.getString("NOMBRE_SERVICIO"));

                //estado 
                estado.setNombre(rs.getString("NOMBRE_ESTADO"));

                //SOLICITUD 
                solicitud.setDescripcion(rs.getString("NOMBRE_SOLICITUD"));

                //PLAN PAGO 
                PlanPago.setNombre(rs.getString("NOMBRE_PAGO"));

                //usuario 
                usuario.setRut(rs.getString("RUT"));
                usuario.setNombres(rs.getString("NOMBRE_USUARIO"));
                usuario.setPaterno(rs.getString("APELLIDO_USUARIO"));
                usuario.setTelefono(rs.getInt("TELEFONO"));
                usuario.setEmail(rs.getString("EMAIL"));

                presupuestoTransaccion.setPresupuestoDTO(presupuesto);
                presupuestoTransaccion.setPresupuestoDetalle(detalle);
                presupuestoTransaccion.setPresupuestoEstado(estado);
                presupuestoTransaccion.setPresupuestoPlanPago(PlanPago);
                presupuestoTransaccion.setSolicitud(solicitud);
                presupuestoTransaccion.setUsuario(usuario);

                list.add(presupuestoTransaccion);
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return list;
    }

    public List<PresupuestoTransaction> getAllPresupuestoDetalle() {

        List<PresupuestoTransaction> list = new ArrayList<>();

        try {

            Connection cn = con.open();
            CallableStatement cs = cn.prepareCall(READ_PRESUPUESTOS_DETAIL);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(1);
            while (rs.next()) {

                PresupuestoTransaction presupuestoTransaccion = new PresupuestoTransaction();

                PresupuestoDTO presupuesto = new PresupuestoDTO();
                PresupuestoDetalleDTO detalle = new PresupuestoDetalleDTO();
                PresupuestoEstadoDTO estado = new PresupuestoEstadoDTO();
                SolicitudDTO solicitud = new SolicitudDTO();
                PlanPagoDTO PlanPago = new PlanPagoDTO();
                UsuarioDTO usuario = new UsuarioDTO();
                UsuarioDTO tecnico = new UsuarioDTO();
                SolicitudTiposDTO tiposSolicitud = new SolicitudTiposDTO();

                //presupuestos 
                presupuesto.setId_presupuesto(rs.getInt("ID_PRESUPUESTO"));
                presupuesto.setFecha(rs.getDate("FECHA"));
                presupuesto.setCreado(rs.getDate("CREADO"));
                presupuesto.setModificado(rs.getDate("MODIFICADO"));

                //estado 
                estado.setNombre(rs.getString("ESTADO_PRESUPUESTO"));

                //cliente
                usuario.setRut(rs.getString("RUT"));
                usuario.setNombres(rs.getString("NOMBRE_USUARIO"));
                usuario.setPaterno(rs.getString("APELLIDO_USUARIO"));
                usuario.setTelefono(rs.getInt("TELEFONO"));
                usuario.setEmail(rs.getString("CORREO_USUARIO"));

                //tipo de solicitud 
                tiposSolicitud.setNombre(rs.getString("NOMBRE_SOLICITUD_TIPO"));

                //SOLICITUD  
                solicitud.setId_solicitud(rs.getInt("ID_SOLICITUD"));
                solicitud.setDescripcion(rs.getString("DESCRIPCION_SOLICITUD"));

                //PLAN PAGO 
                PlanPago.setNombre(rs.getString("NOMBRE_PAGO"));

                //tecnico
                tecnico.setNombres(rs.getString("NOMBRE_TECNICO"));

                presupuestoTransaccion.setPresupuestoDTO(presupuesto);
                presupuestoTransaccion.setPresupuestoEstado(estado);
                presupuestoTransaccion.setPresupuestoPlanPago(PlanPago);
                presupuestoTransaccion.setSolicitud(solicitud);
                presupuestoTransaccion.setUsuario(usuario);
                presupuestoTransaccion.setTipoSolicitud(tiposSolicitud);
                presupuestoTransaccion.setTecnico(tecnico);

                list.add(presupuestoTransaccion);
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return list;
    }

    public int get_count_contratos_presupuesto(int idPresupuesto) {
        int resultadoOperacion = 0;

        try {
            Connection cn = con.open();
            CallableStatement cs = cn.prepareCall(READ_CANTIDAD_PRESUPUESTO);

            cs.setInt(1, idPresupuesto);

            cs.registerOutParameter(2, Types.INTEGER);// salida de parametro 9

            cs.execute();

            resultadoOperacion = cs.getInt(2);

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return resultadoOperacion;
    }

}
