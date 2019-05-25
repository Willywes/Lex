package Test;


import Models.DAO.CitaDAO;
import Models.DAO.RolDAO;
import Models.DAO.SolicitudEstadoDAO;
import Models.DAO.SolicitudTiposDAO;
import Models.DAO.UsuarioDAO;
import Models.DTO.CitaDTO;
import Models.DTO.RolDTO;
import Models.DTO.SolicitudEstadoDTO;
import Models.DTO.SolicitudTiposDTO;
import Models.DTO.UsuarioDTO;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author willywes
 */
public class Main {

    public static void main(String[] args) throws SQLException, IOException {

        System.out.println("Staring ...");
        System.out.println("");
      //  System.out.println("Un Rol");
        
      //  RolDAO rol = new RolDAO();
        
      //  List<RolDTO> roles = rol.getAll();
        
      //  System.out.println(rol.findById(1).toString());

       // System.out.println("Lista de Roles");
        
       // for (RolDTO role : roles) {

        //         System.out.println(role.getNombre());
        //   }
        
        System.out.println("");

     //   System.out.println("Un Usuario");
        
        
        SolicitudEstadoDAO solicitudEstado = new SolicitudEstadoDAO();
        List<SolicitudEstadoDTO> solicitudesEstados = solicitudEstado.getAll();
        
        for (SolicitudEstadoDTO tipos : solicitudesEstados) {
          System.out.println(tipos.getNombre());
        }
        //}

//        System.out.println(UsuarioDAO.findById(1).toString());
<<<<<<< HEAD
//        
//        System.out.println("Lista de Usuarios");
//
//        for (UsuarioDTO usuario : UsuarioDAO.getAll()) {
//
//            System.out.println(usuario.toString());
//        }
         CitaDAO citaDAO = new CitaDAO();
         CitaDTO citas = new CitaDTO();
         citas = citaDAO.findById(52);
            
               int status= citas.getId_estado_cita();
               status = citaDAO.cambiarStatus(status);
               citas.setId_estado_cita(status);
               citaDAO.update(citas);     

      
      
     //   citas=citaDAO.findById(52);
       
     //   citas.setId_estado_cita(2);
    //    citaDAO.update(citas);
            
=======
        
        System.out.println("Lista de Usuarios");

        new UsuarioDAO().getAll().forEach((usuario) -> {
            System.out.println(usuario.toString());
        });
>>>>>>> claudiodev
        
        
            System.out.println(citas.toString());
        
        
    }
}
