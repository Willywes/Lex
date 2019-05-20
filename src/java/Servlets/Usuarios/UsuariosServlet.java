/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Usuarios;

import Models.DAO.RolDAO;
import Models.DAO.UsuarioDAO;
import Models.DTO.RolDTO;
import Models.DTO.UsuarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author willywes
 */
@WebServlet(name = "UsuariosServlet", urlPatterns = {"/modulo/usuarios/*"})
public class UsuariosServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String route = request.getPathInfo().substring(1);
        System.out.println(route);

// este metodo ql recibe solo las peticiones get
// index el la venana principal solo la tabla con todos los datos
// create retorna el formulario para crear algo
// edit retorna un formulatio similar al de crear pero con los datos del objeto, ejemplo usuario
// show muestra el detalle del ojbeto, 
// el edit es una mezcla del show y create


        if (route.equals("index")) {

            index(request, response);

        } else if (route.equals("create")) {

            create(request, response);

        } else if (route.equals("edit")) {

            edit(request, response);
        } else if (route.equals("show")) {

            edit(request, response);
        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);;
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

// este metodo ql recibe solo las peticiones POST
// el store guadar todo lo que el create envia
// el upate guarda todo lo que el edit envia
// el delete elimina segun un parametro id por ejemplo. 
// el change status cambia el estado de un ojeto mediante un id


        
        
        String route = (String) request.getParameter("route");

        if (route.equals("store")) {

            store(request, response);

        } else if (route.equals("update")) {

            update(request, response);

        } else if (route.equals("delete")) {

            delete(request, response);

        }else if (route.equals("change-status")) {

            changeStatus(request, response);

        } else {

            request.getRequestDispatcher("/").forward(request, response);;

        }
    }

    public void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<RolDTO> roles = new RolDAO().getAll();
        List<UsuarioDTO> usuarios = new UsuarioDAO().getAll();

        request.setAttribute("roles", roles);
        request.setAttribute("usuarios", usuarios);

        request.getRequestDispatcher("/modules/usuarios/index.jsp").forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<RolDTO> roles = new RolDAO().getAll();
        request.setAttribute("roles", roles);

        request.getRequestDispatcher("/modules/usuarios/create.jsp").forward(request, response);

    }

    public void store(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rut = request.getParameter("rut").toUpperCase();

        String paterno = request.getParameter("paterno").toUpperCase();
        String materno = request.getParameter("materno").toUpperCase();
        String nombres = request.getParameter("nombres").toUpperCase();

        Date f_nac = new Date(request.getParameter("f_nac"));

        String email = request.getParameter("email").toLowerCase();
        String clave = request.getParameter("clave");

        int telefono = Integer.parseInt(request.getParameter("telefono"));
        int celular = Integer.parseInt(request.getParameter("celular"));

        String direccion = request.getParameter("direccion");
        int id_rol = Integer.parseInt(request.getParameter("id_rol"));

    }

    public void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    public void show(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    public void changeStatus(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
