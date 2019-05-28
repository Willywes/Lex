/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import JDBC.Conexion;
import Models.DTO.PlanPagoDTO;
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
public class PlanPagoDAO {
    //private final String FIND_BY_ID = "{call PKG_CONTRATO.READ_CONTRATO(?)}";
    private final String GET_ALL = "{call LEX.PKG_PPAGO.READ_ALL_PPAGO(?)}";
    //{call LEX.PKG_CONTRATOS.READ_ALL_CONTRATOS(?)}
    //private final String CREATE = "{call PKG_CONTRATO.CREATE_CONTRATO(?,?,?,?,?,?,?,?,?,?,?)}";
    //private final String DELETE = "{call PKG_CONTRATO.DELETE_CONTRATO(?)}" ;

    Conexion con = new Conexion();


    /*public ContratoEstadoDTO findById(int id) {

        ContratoDTO contrato = new ContratoDTO();

        try {
            
            Connection cn = con.open();

            CallableStatement cs = cn.prepareCall(FIND_BY_ID);

            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);

            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(2);

            while (rs.next()) {

                contrato.setId_contrato(rs.getInt("ID_CONTRATO"));
                contrato.setFecha_inicio(rs.getDate("FECHA_INICIO"));
                contrato.setFecha_termino(rs.getDate("FECHA_TERMINO"));
                contrato.setId_contrato_estado(rs.getInt("ID_CONTRATO_ESTADO"));
                contrato.setId_detalle_contrato(rs.getInt("ID_DETALLE_CONTRATO"));
                contrato.setId_presupuesto(rs.getInt("ID_PRESUPUESTO"));
                contrato.setId_abogado(rs.getInt("ID_ABOGADO"));
                contrato.setId_plan_pago(rs.getInt("ID_PLAN_PAGO"));
                contrato.setCreado(rs.getDate("CREADO"));
                contrato.setModificado(rs.getDate("MODIFICADO"));
                contrato.setAprobado_abogado(rs.getInt("APROBADO_ABOGADO"));
                contrato.setAprobado_cliente(rs.getInt("APROBADO_CLIENTE"));
                contrato.setId_forma_pago(rs.getInt("ID_FORMA_PAGO"));
                        
                
               
       
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(ContratoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return contrato;

    }*/

    public List<PlanPagoDTO> getAll() {

        List<PlanPagoDTO> list = new ArrayList<>();

        try {

            Connection cn = con.open();
            CallableStatement cs = cn.prepareCall(GET_ALL);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            //System.out.println("ANtes de EJecutar");
            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(1);
            while (rs.next()) {

                PlanPagoDTO planPago = new PlanPagoDTO();
                planPago.setId_Plan_Pago(rs.getInt("ID_PLAN_PAGO"));
                planPago.setNombre(rs.getString("NOMBRE"));
                
               
                list.add(planPago);
            }


        } catch (SQLException | IOException ex) {
            Logger.getLogger(PlanPagoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
