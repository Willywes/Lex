/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import JDBC.Conexion;
import Models.DTO.PresupuestoDetalleDTO;
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
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Funny
 */
public class PresupuestoDetalleDAO {

    private final String CREATE = "{call PKG_PRESUPUESTO_DETALLES.CREATE_PRESUPUESTO_DETALLES(?,?,?)}";
    private final String FIND_BY_ID = "{call PKG_PRESUPUESTO_DETALLES.READ_PRESUPUESTO_DETALLES(?)}";
    private final String GET_ALL = "{call PKG_PRESUPUESTO_DETALLES.READ_ALL_PRESUPUESTO_DETALLES(?)}";
    private final String DELETE = "{call PKG_PRESUPUESTO_DETALLES.DELETE_PRESUPUESTO_DETALLES(?,?)}";
    private final String UPDATE = "{call PKG_PRESUPUESTO_DETALLES.UPDATE_PRESUPUESTO_DETALLES(?,?,?)}";
    private final String FIND_BY_ID_PRE = "{call LEX.PKG_PRESUPUESTO_DETALLES.READ_PRESUPUESTO_ID_PRESUPUESTO(?, ?)}";

    Conexion con = new Conexion();

    
    public List<PresupuestoDetalleDTO> FIND_BY_ID_PRE(int id) {

        List<PresupuestoDetalleDTO> list = new ArrayList<>();

        try {
            Connection cn = con.open();

            CallableStatement cs = cn.prepareCall(FIND_BY_ID_PRE);

            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);

            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(2);

            while (rs.next()) {
                PresupuestoDetalleDTO presupuesto_detalle = new PresupuestoDetalleDTO();
                presupuesto_detalle.setId_detalle_presupuesto(rs.getInt("ID_DETALLE_PRESUPUESTO"));
                presupuesto_detalle.setServicio(rs.getString("SERVICIO"));
                presupuesto_detalle.setMonto(rs.getInt("MONTO"));
                presupuesto_detalle.setId_presupuesto(rs.getInt("ID_PRESUPUESTO"));
                
                list.add(presupuesto_detalle);
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return list;

    }
    
    public PresupuestoDetalleDTO findById(int id) {

        PresupuestoDetalleDTO presupuesto_detalle = new PresupuestoDetalleDTO();

        try {
            Connection cn = con.open();

            CallableStatement cs = cn.prepareCall(FIND_BY_ID);

            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);

            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(2);

            while (rs.next()) {
                presupuesto_detalle.setId_detalle_presupuesto(rs.getInt("ID_DETALLE_PRESUPUESTO"));
                presupuesto_detalle.setServicio(rs.getString("SERVICIO"));
                presupuesto_detalle.setMonto(rs.getInt("MONTO"));
                presupuesto_detalle.setId_presupuesto(rs.getInt("ID_PRESUPUESTO"));
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return presupuesto_detalle;

    }

    public List<PresupuestoDetalleDTO> getAll() {

        List<PresupuestoDetalleDTO> list = new ArrayList<>();

        try {

            Connection cn = con.open();
            CallableStatement cs = cn.prepareCall(GET_ALL);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(1);
            while (rs.next()) {

                PresupuestoDetalleDTO presupuesto_detalle = new PresupuestoDetalleDTO();
                presupuesto_detalle.setId_detalle_presupuesto(rs.getInt("ID_DETALLE_PRESUPUESTO"));
                presupuesto_detalle.setServicio(rs.getString("SERVICIO"));
                presupuesto_detalle.setMonto(rs.getInt("MONTO"));
                presupuesto_detalle.setId_presupuesto(rs.getInt("ID_PRESUPUESTO"));

                list.add(presupuesto_detalle);
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return list;
    }

    public int create(PresupuestoDetalleDTO presupuesto_detalle) {
        int resultadoOperacion = 0;

        try {
            Connection cn = con.open();
            CallableStatement cs = cn.prepareCall(CREATE);
            cs.setString(1, presupuesto_detalle.getServicio());
            cs.setInt(2, presupuesto_detalle.getMonto());
            cs.setInt(3, presupuesto_detalle.getId_presupuesto());

            cs.registerOutParameter(4, Types.INTEGER);// salida de parametro 9
            cs.execute();

            resultadoOperacion = cs.getInt(4);

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return resultadoOperacion;
    }

    public PresupuestoDetalleDTO delete(int id) {

        PresupuestoDetalleDTO presupuesto_detalle = new PresupuestoDetalleDTO();

        try {

            Connection cn = con.open();

            CallableStatement cs = cn.prepareCall(DELETE);

            int idTest = 4;
            // cs.setInt("ID_PRESUPUESTO_DETALLE",presupuesto_detalle.getId_detalle_presupuesto());
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
        return presupuesto_detalle;

    }

    public int update(PresupuestoDetalleDTO detallePresupuesto) {
        int resultadoOperacion = 0;

        try {
            Connection cn = con.open();
            CallableStatement cs = cn.prepareCall(UPDATE);
            cs.setInt(1, detallePresupuesto.getId_detalle_presupuesto());
            cs.setString(2, detallePresupuesto.getServicio());
            cs.setInt(3, detallePresupuesto.getMonto());
            cs.setInt(4, detallePresupuesto.getId_presupuesto());

            cs.registerOutParameter(5, Types.INTEGER);// salida de parametro 5
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
