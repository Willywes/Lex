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
import Utilidades.Validator;
import Utilidades.Utils;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

// este metodo ql recibe solo las peticiones get
// index el la venana principal solo la tabla con todos los datos
// create retorna el formulario para crear algo
// edit retorna un formulatio similar al de crear pero con los datos del objeto, ejemplo usuario
// show muestra el detalle del ojbeto, 
// el edit es una mezcla del show y create
        if (route.contains("index")) {
            
            index(request, response);
            
        } else if (route.contains("create")) {
            
            create(request, response);
            
        } else if (route.contains("edit")) {
            
            edit(request, response);
        } else if (route.contains("show")) {
            
            show(request, response);
        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
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
        String route = request.getPathInfo().substring(1);
        
        if (route.contains("store")) {
            store(request, response);
            
        } else if (route.contains("update")) {
            
            update(request, response);
            
        } else if (route.contains("delete")) {
            
            delete(request, response);
            
        } else if (route.contains("change-status")) {
            
            changeStatus(request, response);
            
        } else {
            
            request.getRequestDispatcher("/").forward(request, response);
            
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
        
        String redirect = "/modules/usuarios/create.jsp";
        
        Validator validator = new Validator();
        validator.addRule("rut", "required|min:8|max:13");
        validator.addRule("nombres", "required|min:4|max:30");
        validator.addRule("paterno", "required|min:4|max:30");
        validator.addRule("materno", "required|min:4|max:30");
        validator.addRule("email", "required|email|unique:usuarios,email");
        validator.addRule("clave", "required|min:4|max:30");
        validator.addRule("rol_id", "required");
        
        validator.addMessage("rol_id.required", "Seleccione un rol");
        
        validator.validar(request);
        
        Map<String, String> errors = validator.getErrors();
        
        if (errors.isEmpty()) {
            
            UsuarioDTO usuario = new UsuarioDTO();
            
            usuario.setRut(request.getParameter("rut").toUpperCase());
            usuario.setNombres(request.getParameter("nombres").toUpperCase());
            usuario.setPaterno(request.getParameter("paterno").toUpperCase());
            usuario.setMaterno(request.getParameter("materno").toUpperCase());
            usuario.setEmail(request.getParameter("email").toLowerCase());
            
            usuario.setClave(Utils.encriptarMD5(request.getParameter("clave").toUpperCase()));
            usuario.setId_rol(Integer.parseInt(request.getParameter("id_rol")));
            
            UsuarioDAO u = new UsuarioDAO();
            
            if (u.create(usuario)) {
                
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(1);
                session.setAttribute("success", "Usuario creado correctamente.");
                response.sendRedirect(request.getContextPath() + "/modulo/usuarios/index");
                return;
                
            } else {
                
                request.setAttribute("error", "Error al crear al usuario, inténtelo denuevo.");
                
            }
            
        } else {
            
            request.setAttribute("error", "Error de validación");
            request.setAttribute("inputs", validator.getInputs());
            request.setAttribute("errors", errors);
            
            List<RolDTO> roles = new RolDAO().getAll();
            request.setAttribute("roles", roles);
            
        }
        
        request.getRequestDispatcher(redirect).forward(request, response);
        
    }
    
    public void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            
            String id = request.getParameter("id");
            if (id == null) {
                
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(1);
                session.setAttribute("warning", "Usuario no encontrado.");
                response.sendRedirect(request.getContextPath() + "/modulo/usuarios/index");
                return;
                
            }
            
            UsuarioDTO usuario = new UsuarioDAO().findById(Integer.parseInt(id));
            
            if (usuario.getId() == 0) {
                
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(1);
                session.setAttribute("warning", "Usuario no encontrado.");
                response.sendRedirect(request.getContextPath() + "/modulo/usuarios/index");
                return;
                
            }
            
            List<RolDTO> roles = new RolDAO().getAll();
            request.setAttribute("roles", roles);
            request.setAttribute("usuario", usuario);
            
            request.getRequestDispatcher("/modules/usuarios/update.jsp").forward(request, response);
            
        } catch (Exception e) {
            
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(1);
            session.setAttribute("warning", "Usuario no encontrado.");
            response.sendRedirect(request.getContextPath() + "/modulo/usuarios/index");
            return;
        }
    }
    
    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String redirect = "/modules/usuarios/update.jsp";
        
        Validator validator = new Validator();
        validator.addRule("rut", "required|min:8|max:13");
        validator.addRule("nombres", "required|min:4|max:30");
        validator.addRule("paterno", "required|min:4|max:30");
        validator.addRule("materno", "required|min:4|max:30");
        validator.addRule("email", "required|email|unique:usuarios,email");
        validator.addRule("rol_id", "required");
        
        validator.addMessage("rol_id.required", "Seleccione un rol");
        
        validator.validar(request);
        
        Map<String, String> errors = validator.getErrors();
        
        UsuarioDTO usuario = new UsuarioDAO().findById(Integer.parseInt(request.getParameter("id")));
        
        if (errors.isEmpty()) {
            
            usuario.setRut(request.getParameter("rut").toUpperCase());
            usuario.setNombres(request.getParameter("nombres").toUpperCase());
            usuario.setPaterno(request.getParameter("paterno").toUpperCase());
            usuario.setMaterno(request.getParameter("materno").toUpperCase());
            usuario.setEmail(request.getParameter("email").toLowerCase());
            usuario.setId_rol(Integer.parseInt(request.getParameter("id_rol")));
            
            UsuarioDAO u = new UsuarioDAO();
            
            if (u.update(usuario)) {
                
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(1);
                session.setAttribute("success", "Usuario modificado correctamente.");
                response.sendRedirect(request.getContextPath() + "/modulo/usuarios/index");
                return;
                
            } else {
                
                request.setAttribute("error", "Error al modificar al usuario, inténtelo denuevo.");
                
            }
            
        } else {
            
            request.setAttribute("error", "Error de validación");
            request.setAttribute("inputs", validator.getInputs());
            request.setAttribute("usuario", usuario);
            request.setAttribute("errors", errors);
            
            List<RolDTO> roles = new RolDAO().getAll();
            request.setAttribute("roles", roles);
            
        }
        
        request.getRequestDispatcher(redirect).forward(request, response);
        
    }
    
    public void show(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    public void changeStatus(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            
            String id = request.getParameter("id");
            
            if (id == null) {
                
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(1);
                session.setAttribute("warning", "Usuario no encontrado.");
                response.sendRedirect(request.getContextPath() + "/modulo/usuarios/index");
                return;
            }
            
            UsuarioDTO usuario = new UsuarioDAO().findById(Integer.parseInt(id));
            
            if (usuario.getId() == 0) {
                
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(1);
                session.setAttribute("warning", "Usuario no encontrado.");
                response.sendRedirect(request.getContextPath() + "/modulo/usuarios/index");
                return;
            }
            
            if (new UsuarioDAO().changeStatus(usuario)) {
                
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(1);
                session.setAttribute("success", "Estado del usuario cambiado correctamente.");
                response.sendRedirect(request.getContextPath() + "/modulo/usuarios/index");
                return;
                
            } else {
                
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(1);
                session.setAttribute("errr", "Error al cambiar el estado del usuario.");
                response.sendRedirect(request.getContextPath() + "/modulo/usuarios/index");
                return;
                
            }
            
        } catch (Exception e) {
            
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(1);
            session.setAttribute("warning", "Usuario no encontrado.");
            response.sendRedirect(request.getContextPath() + "/modulo/usuarios/index");
            return;
            
        }
        
    }
}
