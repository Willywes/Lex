/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import JDBC.Conexion;
import Models.DTO.UsuarioDTO;
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
public class UsuarioDAO {

    private final String CREATE = "{call PKG_USUARIOS.CREATE_USUARIO(?,?,?,?,?,?,?,?,?,?,?,?)}";
    private final String UPDATE = "{call PKG_USUARIOS.UPDATE_USUARIO(?,?,?,?,?,?,?,?,?,?,?,?)}";
    private final String CHANGE_STATUS = "{call PKG_USUARIOS.CHANGE_STATUS_USUARIO(?,?)}";
    private final String FIND_BY_ID = "{call PKG_USUARIOS.READ_USUARIO(?,?)}";
    private final String GET_ALL = "{call PKG_USUARIOS.READ_ALL_USUARIOS(?)}";
    private final String GET_ALL_CLIENTS = "{call PKG_USUARIOS.READ_ALL_CLIENTES(?)}";
    
    Conexion con;

    public boolean create(UsuarioDTO usuario) {

        try {

            con = new Conexion();

            CallableStatement cs = con.open().prepareCall(CREATE);

            cs.setString(1, usuario.getRut());
            cs.setString(2, usuario.getPaterno());
            cs.setString(3, usuario.getMaterno());
            cs.setString(4, usuario.getNombres());
            cs.setDate(5, usuario.getfNac());
            cs.setString(6, usuario.getEmail());
            cs.setString(7, usuario.getClave());
            cs.setInt(8, usuario.getCelular());
            cs.setInt(9, usuario.getTelefono());
            cs.setString(10, usuario.getDireccion());
            cs.setInt(11, usuario.getId_rol());

            cs.registerOutParameter(12, OracleTypes.INTEGER);
            boolean execute = cs.execute();

            return cs.getInt(12) == 1;

        } catch (SQLException | IOException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return false;
    }

    public boolean update(UsuarioDTO usuario) {

        try {

            con = new Conexion();

            CallableStatement cs = con.open().prepareCall(UPDATE);

            cs.setInt(1, usuario.getId());
            cs.setString(2, usuario.getRut());
            cs.setString(3, usuario.getPaterno());
            cs.setString(4, usuario.getMaterno());
            cs.setString(5, usuario.getNombres());
            cs.setDate(6, usuario.getfNac());
            cs.setString(7, usuario.getEmail());
            cs.setInt(8, usuario.getCelular());
            cs.setInt(9, usuario.getTelefono());
            cs.setString(10, usuario.getDireccion());
            cs.setInt(11, usuario.getId_rol());

            cs.registerOutParameter(12, OracleTypes.INTEGER);
            boolean execute = cs.execute();

            return cs.getInt(12) == 1;

        } catch (SQLException | IOException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return false;
    }

    public boolean changeStatus(UsuarioDTO usuario) {

        try {

            con = new Conexion();

            CallableStatement cs = con.open().prepareCall(CHANGE_STATUS);

            cs.setInt(1, usuario.getId());
            cs.registerOutParameter(2, OracleTypes.INTEGER);
            
            boolean execute = cs.execute();

            return cs.getInt(2) == 1;

        } catch (SQLException | IOException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return false;
    }
    
    public UsuarioDTO findById(int id) {

        UsuarioDTO user = new UsuarioDTO();

        try {

            con = new Conexion();

            CallableStatement cs = con.open().prepareCall(FIND_BY_ID);

            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);

            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(2);

            while (rs.next()) {

                user.setId(rs.getInt("ID_USUARIO"));
                user.setNombres(rs.getString("NOMBRES"));
                user.setPaterno(rs.getString("PATERNO"));
                user.setMaterno(rs.getString("MATERNO"));
                user.setRut(rs.getString("RUT"));
                user.setfNac(rs.getDate("F_NAC"));
                user.setEmail(rs.getString("EMAIL"));
                user.setCelular(rs.getInt("CELULAR"));
                user.setTelefono(rs.getInt("TELEFONO"));
                user.setDireccion(rs.getString("DIRECCION"));
                user.setActivo(rs.getBoolean("ACTIVO"));
                user.setId_rol(rs.getInt("ID_ROL"));
                user.setCreado(rs.getDate("CREADO"));
                user.setModificado(rs.getDate("MODIFICADO"));

            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return user;

    }

    public List<UsuarioDTO> getAll() {

        List<UsuarioDTO> list = new ArrayList();

        try {

            con = new Conexion();

            CallableStatement cs = con.open().prepareCall(GET_ALL);

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(1);

            while (rs.next()) {

                UsuarioDTO user = new UsuarioDTO();

                user.setId(rs.getInt("ID_USUARIO"));
                user.setNombres(rs.getString("NOMBRES"));
                user.setPaterno(rs.getString("PATERNO"));
                user.setMaterno(rs.getString("MATERNO"));
                user.setRut(rs.getString("RUT"));
                user.setfNac(rs.getDate("F_NAC"));
                user.setEmail(rs.getString("EMAIL"));
                user.setCelular(rs.getInt("CELULAR"));
                user.setTelefono(rs.getInt("TELEFONO"));
                user.setDireccion(rs.getString("DIRECCION"));
                user.setActivo(rs.getBoolean("ACTIVO"));
                user.setId_rol(rs.getInt("ID_ROL"));
                user.setCreado(rs.getDate("CREADO"));
                user.setModificado(rs.getDate("MODIFICADO"));

                list.add(user);
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return list;
    }
    
    public List<UsuarioDTO> getAllClients() {

        List<UsuarioDTO> list = new ArrayList();

        try {

            con = new Conexion();

            CallableStatement cs = con.open().prepareCall(GET_ALL_CLIENTS);

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(1);

            while (rs.next()) {

                UsuarioDTO user = new UsuarioDTO();

                user.setId(rs.getInt("ID_USUARIO"));
                user.setNombres(rs.getString("NOMBRES"));
                user.setPaterno(rs.getString("PATERNO"));
                user.setMaterno(rs.getString("MATERNO"));
                user.setRut(rs.getString("RUT"));
                user.setfNac(rs.getDate("F_NAC"));
                user.setEmail(rs.getString("EMAIL"));
                user.setCelular(rs.getInt("CELULAR"));
                user.setTelefono(rs.getInt("TELEFONO"));
                user.setDireccion(rs.getString("DIRECCION"));
                user.setActivo(rs.getBoolean("ACTIVO"));
                user.setId_rol(rs.getInt("ID_ROL"));
                user.setCreado(rs.getDate("CREADO"));
                user.setModificado(rs.getDate("MODIFICADO"));

                list.add(user);
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return list;
    }
}
