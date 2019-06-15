/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;
import JDBC.Conexion;
import Models.DTO.SolicitudEstadoDTO;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;
/**
 *
 * @author claudio
 */
public class SolicitudEstadoDAO {

    private final String FIND_BY_ID = "{call PKG_SOLICITUD_ESTADOS.READ_SESTADO(?,?)}";
    private final String GET_ALL = "{call PKG_SOLICITUD_ESTADOS.READ_ALL_SESTADOS(?)}";

    Conexion con = new Conexion();


    public SolicitudEstadoDTO findById(int id) {

        SolicitudEstadoDTO solicitudEstado = new SolicitudEstadoDTO();

        try {
            
            Connection cn = con.open();
            CallableStatement cs = cn.prepareCall(FIND_BY_ID);

            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);

            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(2);

            while (rs.next()) {

                solicitudEstado.setId_estado_solicitud(rs.getInt("ID_ESTADO_SOLICITUD"));
                solicitudEstado.setNombre(rs.getString("NOMBRE"));
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }
        return solicitudEstado;

    }

    public List<SolicitudEstadoDTO> getAll() {

        List<SolicitudEstadoDTO> list = new ArrayList<>();

        try {

            Connection cn = con.open();

            CallableStatement cs = cn.prepareCall(GET_ALL);

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(1);

            while (rs.next()) {

                SolicitudEstadoDTO solicitudEstado = new SolicitudEstadoDTO();

                solicitudEstado.setId_estado_solicitud(rs.getInt("ID_ESTADO_SOLICITUD"));
                solicitudEstado.setNombre(rs.getString("NOMBRE"));

                list.add(solicitudEstado);
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return list;
    }
}