/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import JDBC.Conexion;
import Models.DTO.ContratoDTO;
import Models.DTO.PagoClienteDTO;
import Models.DTO.PagoDTO;
import Models.DTO.PagosContratoClienteDTO;
import Models.DTO.PlanPagoDTO;
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
public class PagoDAO {

    private final String CREATE = "{call PKG_PAGOS.CREATE_PAGOS(?,?,?)}";
    private final String FIND_BY_ID = "{call PKG_PAGOS.READ_PAGOS(?,?)}";
    private final String GET_ALL = "{call PKG_PAGOS.READ_ALL_PAGOS(?)}";
    private final String DELETE = "{call PKG_PAGOS.DELETE_PAGOS(?,?)}";
    private final String UPDATE = "{call PKG_PAGOS.UPDATE_PAGOS(?,?,?,?,?,?)}";
    private final String ALL_CONTRATOS = "{call PKG_PAGOS.READ_ALL_PAGOS_CONTRATO(?,?)}";
    private final String FIND_CONTRATO_BY_PAGO = "{call PKG_PAGOS.READ_PAGOS_TRANSACCION(?,?)}";
    private final String READ_PAGOS_USUARIO = "{call PKG_PAGOS.READ_PAGOS_USUARIO(?)}"; 
    

    Conexion con = new Conexion();

    public PagoDTO findById(int id) {

        PagoDTO pago = new PagoDTO();

        try {
            Connection cn = con.open();

            CallableStatement cs = cn.prepareCall(FIND_BY_ID);

            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);

            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(2);

            while (rs.next()) {
                pago.setId_pago(rs.getInt("ID_PAGO"));
                pago.setFecha_hora(rs.getDate("FECHA_HORA"));
                pago.setMonto(rs.getInt("MONTO"));
                pago.setCreado(rs.getDate("CREADO"));
                pago.setModificado(rs.getDate("MODIFICADO"));
                pago.setId_contrato(rs.getInt("ID_CONTRATO"));
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return pago;

    }

    public List<PagoClienteDTO> getAll() {

        List<PagoClienteDTO> list = new ArrayList<>();

        try {

            Connection cn = con.open();
            CallableStatement cs = cn.prepareCall(GET_ALL);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(1);
            while (rs.next()) {

                PagoDTO pago = new PagoDTO();
                pago.setId_pago(rs.getInt("ID_PAGO"));
                pago.setFecha_hora(rs.getDate("FECHA_HORA"));
                pago.setMonto(rs.getInt("MONTO"));
                pago.setCreado(rs.getDate("CREADO"));
                pago.setModificado(rs.getDate("MODIFICADO"));
                pago.setId_contrato(rs.getInt("ID_CONTRATO"));
                
                //cliente 
                UsuarioDTO cliente = new UsuarioDTO();
                cliente.setId(rs.getInt("ID_USUARIO")); 
                cliente.setNombres(rs.getString("NOMBRE_CLIENTE")); 
                cliente.setPaterno(rs.getString("APELLIDO_CLIENTE")); 
                cliente.setEmail(rs.getString("EMAIL_CLIENTE")); 
                
                PagoClienteDTO pagoCliente = new PagoClienteDTO();
                
                pagoCliente.setCliente(cliente); 
                pagoCliente.setPagoDTO(pago); 
                
                list.add(pagoCliente); 
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return list;
    }
    
    
    public List<PagosContratoClienteDTO> getPagosUsuario() {

        List<PagosContratoClienteDTO> list = new ArrayList<>();

        try {

            Connection cn = con.open();
            CallableStatement cs = cn.prepareCall(READ_PAGOS_USUARIO);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(1);
            while (rs.next()) {

                PagosContratoClienteDTO pagosUsuario = new PagosContratoClienteDTO();
                
                PagoDTO pago = new PagoDTO();
                pago.setId_pago(rs.getInt("ID_PAGO"));
                pago.setFecha_hora(rs.getDate("FECHA"));
                pago.setMonto(rs.getInt("MONTO"));
                pago.setId_contrato(rs.getInt("ID_CONTRATO"));
                
                //plan pago 
                PlanPagoDTO planPago = new PlanPagoDTO();
                
                planPago.setNombre(rs.getString("PLAN_PAGO"));  
                
                //cliente 
                UsuarioDTO cliente = new UsuarioDTO();
                cliente.setRut(rs.getString("RUT_USUARIO"));  
                cliente.setNombres(rs.getString("NOMBRE_CLIENTE")); 
                cliente.setPaterno(rs.getString("APELLIDO_CLIENTE")); 
                cliente.setEmail(rs.getString("EMAIL_CLIENTE")); 
                cliente.setTelefono(rs.getInt("TELEFONO")); 
                
                pagosUsuario.setCliente(cliente);
                pagosUsuario.setPago(pago); 
                pagosUsuario.setPlanPago(planPago); 
                 
                
                list.add(pagosUsuario); 
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return list;
    }
    
    
     public PagosContratoClienteDTO getContratoClienteForPago(int id) {

        PagosContratoClienteDTO pagosContrato = new PagosContratoClienteDTO();
                

        try {

            Connection cn = con.open();
            CallableStatement cs = cn.prepareCall(FIND_CONTRATO_BY_PAGO); 
            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(2);
            while (rs.next()) {

                
                ContratoDTO contrato = new ContratoDTO();
                UsuarioDTO cliente = new UsuarioDTO();
                
                //contrato 
                contrato.setId_contrato(rs.getInt("ID_CONTRATO"));
                
                //cliente 
                cliente.setId(rs.getInt("ID_USUARIO"));
                cliente.setNombres(rs.getString("NOMBRE_CLIENTE"));
                cliente.setPaterno(rs.getString("APELLIDO_CLIENTE"));
                cliente.setEmail(rs.getString("EMAIL_CLIENTE"));
                cliente.setTelefono(rs.getInt("TELEFONO"));
                
                
                pagosContrato.setCliente(cliente); 
                pagosContrato.setContrato(contrato); 
                
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return pagosContrato;
    }

    public List<PagoClienteDTO> getAll(int id) {

        List<PagoClienteDTO> list = new ArrayList<>();

        try {

            Connection cn = con.open();
            CallableStatement cs = cn.prepareCall(ALL_CONTRATOS);
            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(2);
            while (rs.next()) {

                PagoDTO pago = new PagoDTO();
                pago.setId_pago(rs.getInt("ID_PAGO"));
                pago.setFecha_hora(rs.getDate("FECHA_HORA"));
                pago.setMonto(rs.getInt("MONTO"));
                pago.setCreado(rs.getDate("CREADO"));
                pago.setModificado(rs.getDate("MODIFICADO"));
                pago.setId_contrato(rs.getInt("ID_CONTRATO"));
                
                   //cliente 
                UsuarioDTO cliente = new UsuarioDTO();
                cliente.setId(rs.getInt("ID_USUARIO")); 
                cliente.setNombres(rs.getString("NOMBRE_CLIENTE")); 
                cliente.setPaterno(rs.getString("APELLIDO_CLIENTE")); 
                cliente.setEmail(rs.getString("EMAIL_CLIENTE")); 
                
                PagoClienteDTO pagoCliente = new PagoClienteDTO();
                
                pagoCliente.setCliente(cliente); 
                pagoCliente.setPagoDTO(pago); 
                
                list.add(pagoCliente); 
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return list;
    }

    public int create(PagoDTO pago) {
        int resultadoOperacion = 0;

        try {
            Connection cn = con.open();
            CallableStatement cs = cn.prepareCall(CREATE);

            cs.setInt(1, pago.getMonto());
            cs.setInt(2, pago.getId_contrato());

            cs.registerOutParameter(3, Types.INTEGER);// salida de parametro 9
            cs.execute();

            resultadoOperacion = cs.getInt(3);

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return resultadoOperacion;
    }

    public PagoDTO delete(int id) {

        PagoDTO pago = new PagoDTO();

        try {

            Connection cn = con.open();

            CallableStatement cs = cn.prepareCall(DELETE);

            cs.setInt(1, id);
            cs.registerOutParameter(2, Types.INTEGER);

            System.out.println("ANTES DE EJECUTAR");
            cs.execute();

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }
        return pago;

    }

    public int update(PagoDTO pago) {
        int resultadoOperacion = 0;
        try {
            Connection cn = con.open();
            CallableStatement cs = cn.prepareCall(UPDATE);

            cs.setInt(1, pago.getId_pago());
            cs.setDate(2, pago.getFecha_hora());
            cs.setInt(3, pago.getMonto());
            cs.setDate(4, pago.getModificado());
            cs.setInt(5, pago.getId_contrato());

            cs.registerOutParameter(6, Types.INTEGER);// salida de parametro 5
            cs.execute();

            resultadoOperacion = cs.getInt(6);

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return resultadoOperacion;
    }

}
