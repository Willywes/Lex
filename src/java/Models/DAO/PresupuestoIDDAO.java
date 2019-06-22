/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import JDBC.Conexion;
import Models.DTO.PresupuestoIDDTO;
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
 * @author Tecmar
 */
public class PresupuestoIDDAO {
    private final String FIND_BY_ID = "{call LEX.PKG_PRESUPUESTOS.READ_PRESUPUESTOS(?,?)}";
    private final String GET_ALL = "{call LEX.PKG_PRESUPUESTOS.READ_ALL_PRESUPUESTOS(?)}";
    //{call LEX.PKG_CONTRATOS.READ_ALL_CONTRATOS(?)}
    //private final String CREATE = "{call PKG_CONTRATO.CREATE_CONTRATO(?,?,?,?,?,?,?,?,?,?,?)}";
    //private final String DELETE = "{call PKG_CONTRATO.DELETE_CONTRATO(?)}" ;

    Conexion con = new Conexion();


    public PresupuestoIDDTO findById(int id) {

        PresupuestoIDDTO presupuesto = new PresupuestoIDDTO();

        try {
            
            Connection cn = con.open();

            CallableStatement cs = cn.prepareCall(FIND_BY_ID);

            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);

            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(2);

            while (rs.next()) {

                presupuesto.setIdPresupuesto(rs.getInt("ID_PRESUPUESTO"));
                presupuesto.setFecha(rs.getDate("FECHA"));
                presupuesto.setIdEstado(rs.getInt("ID_ESTADO_PRESUPUESTO"));
                
                presupuesto.setCreado(rs.getDate("CREADO"));
                presupuesto.setModificado(rs.getDate("MODIFICADO"));
                presupuesto.setIdSolicitud(rs.getInt("ID_SOLICITUD"));
                presupuesto.setIdTecnico(rs.getInt("ID_TECNICO"));
                presupuesto.setIdPlanPago(rs.getInt("ID_PLAN_PAGO"));
                        
                
                System.out.println("Objeto presupuesto dao: " + presupuesto);
       
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(ContratoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return presupuesto;

    }

    public List<PresupuestoIDDTO> getAll() {

        List<PresupuestoIDDTO> list = new ArrayList<>();

        try {

            Connection cn = con.open();
            CallableStatement cs = cn.prepareCall(GET_ALL);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            //System.out.println("ANtes de EJecutar");
            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(1);
            while (rs.next()) {

                PresupuestoIDDTO presupuestoID = new PresupuestoIDDTO();
                presupuestoID.setIdPresupuesto(rs.getInt("ID_PRESUPUESTO"));
                presupuestoID.setIdPlanPago(rs.getInt("ID_PLAN_PAGO"));
                
               
                list.add(presupuestoID);
            }


        } catch (SQLException | IOException ex) {
            Logger.getLogger(PresupuestoIDDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return list;
    }
    
    /*public int create (ContratoDTO cita){
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
            System.out.println("ANTES DE EJECUTAR");
            cs.execute();
           // cs.executeUpdate();
            
           

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return cita;

    }*/
    
    
}
