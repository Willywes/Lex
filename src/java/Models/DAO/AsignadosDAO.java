/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

/**
 *
 * @author Depredador
 */
import JDBC.Conexion;
import Models.DTO.CausaIdDTO;
import Models.DTO.NotariaDTO;
import Models.DTO.NotariaNota;
import Models.DTO.UsuarioDTO;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;
public class AsignadosDAO {
      private final String READ_ALL_NOTASX = "{call LEX.PKG_NOTAX.READ_ALL_NOTASX(?)}";
        Conexion con = new Conexion();
  

        public List<NotariaNota> getAll() {
          List<NotariaNota> list = new ArrayList<>();
          
       // List<NotariaDTO> list = new ArrayList<>();
        
        //List<UsuarioDTO> lista = new ArrayList<>();

        try {

            Connection cn = con.open();
            CallableStatement cs = cn.prepareCall(READ_ALL_NOTASX);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeUpdate();

            ResultSet rs = (ResultSet) cs.getObject(1);
            while (rs.next()) {
                

//                  PresupuestoTransaction presupuestoTransaccion = new PresupuestoTransaction();
              
               // NotariaDTO notita = new NotariaDTO();
               // UsuarioDTO usuario = new UsuarioDTO();
                   //notarias
                NotariaDTO notita = new NotariaDTO();
                notita.setId(rs.getInt("ID_NOTARIA"));
                notita.setNombre(rs.getString("NOMBRE"));
                notita.setRazonSocial(rs.getString("RAZON_SOCIAL"));
                notita.setDireccion(rs.getString("DIRECCION"));
                notita.setTelefono(rs.getInt("TELEFONO"));
                // usuarios notarios
               UsuarioDTO usuario = new UsuarioDTO();
                usuario.setId(rs.getInt("ID_USUARIO"));
                usuario.setNombres(rs.getString("NOMBRES")); 
                usuario.setPaterno(rs.getString("PATERNO")); 
               usuario.setEmail(rs.getString("EMAIL")); 
                
                NotariaNota ultimo = new NotariaNota();
                ultimo.setNotaria(notita);
                ultimo.setUsuario(usuario);
                System.out.println("datos"+ultimo);
                System.out.println(ultimo.toString());

                list.add(ultimo);
            }


        } catch (SQLException | IOException ex) {
            Logger.getLogger(SolicitudTiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }
         

        return list;
    }
    
}
