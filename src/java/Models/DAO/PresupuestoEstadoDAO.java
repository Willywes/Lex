/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import JDBC.Conexion;
import Models.DTO.PresupuestoEstadoDTO;
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
 * @author Funny
 */
public class PresupuestoEstadoDAO {

    private final String FIND_BY_ID = "{call PKG_PRESUPUESTO_ESTADO.READ_PRESUPUESTO_ESTADO(?)}";
    private final String GET_ALL = "{call PKG_PRESUPUESTO_ESTADOS.READ_ALL_PRESUPUESTO_ESTADOS(?)}";

    Conexion con = new Conexion();

    public PresupuestoEstadoDTO findById(int id) {

        PresupuestoEstadoDTO presupuesto_estado = new PresupuestoEstadoDTO();

        try {

            Connection cn = con.open();

            CallableStatement cs = cn.prepareCall(FIND_BY_ID);

            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);

            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(2);

            while (rs.next()) {

                presupuesto_estado.setId_estado_presupuesto(rs.getInt("ID_ESTADO_PRESUPUESTO"));
                presupuesto_estado.setNombre(rs.getString("NOMBRE"));

            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return presupuesto_estado;

    }

    public List<PresupuestoEstadoDTO> getAll() {

        List<PresupuestoEstadoDTO> list = new ArrayList<>();

        try {

            Connection cn = con.open();

            CallableStatement cs = cn.prepareCall(GET_ALL);

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(1);

            while (rs.next()) {

                PresupuestoEstadoDTO presupuesto_estado = new PresupuestoEstadoDTO();

                presupuesto_estado.setId_estado_presupuesto(rs.getInt("ID_ESTADO_PRESUPUESTO"));
                presupuesto_estado.setNombre(rs.getString("NOMBRE"));

                list.add(presupuesto_estado);
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return list;
    }

}
