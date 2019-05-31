/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import JDBC.Conexion;
import Models.DTO.NotariaDTO;
import java.io.IOException;
import java.sql.CallableStatement;
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
 * @author willywes
 */
public class NotariaDAO {

    private final String CREATE = "{call PKG_NOTARIAS.CREATE_NOTARIAS(?,?,?,?,?,?)}";
    private final String UPDATE = "{call PKG_NOTARIAS.UPDATE_NOTARIAS(?,?,?,?,?,?,?)}";
    private final String FIND_BY_ID = "{call PKG_NOTARIAS.READ_NOTARIAS(?,?)}";
    private final String GET_ALL = "{call PKG_NOTARIAS.READ_ALL_NOTARIAS(?)}";
    private final String DELETE = "{call PKG_NOTARIAS.DELETE_NOTARIAS(?,?)}";
    
    Conexion con;

    public boolean create(NotariaDTO notaria) {

        try {

            con = new Conexion();

            CallableStatement cs = con.open().prepareCall(CREATE);

            cs.setString(1, notaria.getNombre());
            cs.setString(2, notaria.getRazonSocial());
            cs.setString(3, notaria.getDireccion());
            cs.setInt(4, notaria.getTelefono());
            cs.setInt(5, notaria.getIdComuna());
        
            cs.registerOutParameter(6, OracleTypes.INTEGER);
            boolean execute = cs.execute();
            return cs.getInt(6) == 1;

        } catch (SQLException | IOException ex) {
            Logger.getLogger(NotariaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return false;
    }

    public boolean update(NotariaDTO notaria) {

        try {

            con = new Conexion();

            CallableStatement cs = con.open().prepareCall(UPDATE);

            cs.setInt(1, notaria.getId());
            cs.setString(2, notaria.getNombre());
            cs.setString(3, notaria.getRazonSocial());
            cs.setString(4, notaria.getDireccion());
            cs.setInt(5, notaria.getTelefono());
            cs.setInt(6, notaria.getIdComuna());

            cs.registerOutParameter(7, OracleTypes.INTEGER);
            boolean execute = cs.execute();

            return cs.getInt(7) == 1;

        } catch (SQLException | IOException ex) {
            Logger.getLogger(NotariaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return false;
    }

    public boolean delete(NotariaDTO notaria) {

        try {

            con = new Conexion();

            CallableStatement cs = con.open().prepareCall(DELETE);

            cs.setInt(1, notaria.getId());
            cs.registerOutParameter(2, OracleTypes.INTEGER);
            
            boolean execute = cs.execute();

            return cs.getInt(2) == 1;

        } catch (SQLException | IOException ex) {
            Logger.getLogger(NotariaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return false;
    }
    
    public NotariaDTO findById(int id) {

        NotariaDTO notaria = new NotariaDTO();

        try {

            con = new Conexion();

            CallableStatement cs = con.open().prepareCall(FIND_BY_ID);

            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);

            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(2);

            while (rs.next()) {

                notaria.setId(rs.getInt("ID_NOTARIA"));
                notaria.setNombre(rs.getString("NOMBRE"));
                notaria.setRazonSocial(rs.getString("RAZON_SOCIAL"));
                notaria.setDireccion(rs.getString("DIRECCION"));
                notaria.setTelefono(rs.getInt("TELEFONO"));
                notaria.setIdComuna(rs.getInt("ID_COMUNA"));
                notaria.setComuna(rs.getString("COMUNA"));
                notaria.setProvincia(rs.getString("PROVINCIA"));
                notaria.setRegion(rs.getString("REGION"));
                notaria.setCreado(rs.getDate("CREADO"));
                notaria.setModificado(rs.getDate("MODIFICADO"));

            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(NotariaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return notaria;

    }

    public List<NotariaDTO> getAll() {

        List<NotariaDTO> list = new ArrayList();

        try {

            con = new Conexion();

            CallableStatement cs = con.open().prepareCall(GET_ALL);

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(1);

            while (rs.next()) {

                NotariaDTO notaria = new NotariaDTO();

                notaria.setId(rs.getInt("ID_NOTARIA"));
                notaria.setNombre(rs.getString("NOMBRE"));
                notaria.setRazonSocial(rs.getString("RAZON_SOCIAL"));
                notaria.setDireccion(rs.getString("DIRECCION"));
                notaria.setTelefono(rs.getInt("TELEFONO"));
                notaria.setIdComuna(rs.getInt("ID_COMUNA"));
                notaria.setComuna(rs.getString("COMUNA"));
                notaria.setProvincia(rs.getString("PROVINCIA"));
                notaria.setRegion(rs.getString("REGION"));
                notaria.setCreado(rs.getDate("CREADO"));
                notaria.setModificado(rs.getDate("MODIFICADO"));

                list.add(notaria);
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(NotariaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return list;
    }
}
