
import Models.DAO.RolDAO;
import Models.DAO.UsuarioDAO;
import Models.DTO.RolDTO;
import Models.DTO.UsuarioDTO;
import java.io.IOException;
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
        System.out.println("Un Rol");
        
        RolDAO rol = new RolDAO();
        
        List<RolDTO> roles = rol.getAll();
        
        System.out.println(rol.findById(1).toString());

        System.out.println("Lista de Roles");
        
        for (RolDTO role : roles) {

            System.out.println(role.getNombre());
        }
        
        System.out.println("");
        System.out.println("");

        System.out.println("Un Usuario");

//        System.out.println(UsuarioDAO.findById(1).toString());
//        
//        System.out.println("Lista de Usuarios");
//
//        for (UsuarioDTO usuario : UsuarioDAO.getAll()) {
//
//            System.out.println(usuario.toString());
//        }
        
        System.out.println("Finished ...");
    }

}
