/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Notarias;

import Models.DAO.ComunaDAO;
import Models.DAO.NotariaDAO;
import Models.DAO.AsignadosDAO;
import Models.DAO.RolDAO;
import Models.DAO.UsuarioDAO;
import Models.DTO.ComunaDTO;
import Models.DTO.NotariaDTO;
import Models.DTO.NotariaNota;
import Models.DTO.RolDTO;
import Models.DTO.UsuarioDTO;
import Utilidades.Validator;
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

@WebServlet(name = "NotariasServlet", urlPatterns = {"/modulo/notarias/*"})
public class NotariasServlet extends HttpServlet {

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

        if (route.contains("index")) {
            
            index(request, response);
            
        } else if (route.contains("create")) {
            
            create(request, response);
            
        } else if (route.contains("edit")) {
            
            edit(request, response);
        } else if (route.contains("show")) {
            
            show(request, response);
        } else if(route.contains("listar")){
            listar(request, response);
        }else if (route.contains("asignar")) {
            asignar(request, response);
        }else
{
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
    public void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
       List<RolDTO> roles = new RolDAO().getAll();
        List<UsuarioDTO> usuarios = new UsuarioDAO().getAll();
        
        request.setAttribute("roles", roles);
        request.setAttribute("usuarios", usuarios);
         request.getRequestDispatcher("/modules/notarias/listar.jsp").forward(request, response);
    }
     public void asignar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
         List<NotariaNota> notariausu = new AsignadosDAO().getAll();
         System.out.println("1");
        // List<NotariaNota> usuarios = new AsignadosDAO().getAll();
        
        request.setAttribute("notariasNotas", notariausu);
        //request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("/modules/notarias/asignados.jsp").forward(request, response);
    }
    
    public void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        List<NotariaDTO> notarias = new NotariaDAO().getAll();
        
        request.setAttribute("notarias", notarias);
        
        request.getRequestDispatcher("/modules/notarias/index.jsp").forward(request, response);
    }
    
    public void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<ComunaDTO> comunas = new ComunaDAO().getAll();
        request.setAttribute("comunas", comunas);
        
        request.getRequestDispatcher("/modules/notarias/create.jsp").forward(request, response);
        
    }
    
    public void store(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String redirect = "/modules/notarias/create.jsp";
        
        Validator validator = new Validator();
  
        validator.addRule("nombre", "required|min:4|max:30");
        validator.addRule("direccion", "required|min:4|max:30");
        validator.addRule("razon_social", "required|min:4|max:30");
        validator.addRule("id_comuna", "required");
        
        validator.addMessage("id_comuna.required", "Seleccione una Comuna");
        
        validator.validar(request);
        
        Map<String, String> errors = validator.getErrors();
        
        if (errors.isEmpty()) {
            
            NotariaDTO notaria = new NotariaDTO();            
 
            notaria.setNombre(request.getParameter("nombre").toUpperCase());
            notaria.setRazonSocial(request.getParameter("razon_social").toUpperCase());
            notaria.setDireccion(request.getParameter("direccion").toUpperCase());
            notaria.setTelefono(Integer.parseInt(request.getParameter("telefono")));
            notaria.setIdComuna(Integer.parseInt(request.getParameter("id_comuna")));
            
            NotariaDAO u = new NotariaDAO();
            
            if (u.create(notaria)) {
                
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(1);
                session.setAttribute("success", "Notaria creada correctamente.");
                response.sendRedirect(request.getContextPath() + "/modulo/notarias/index");
                return;
                
            } else {
                
                request.setAttribute("error", "Error al crear la notaría, inténtelo denuevo.");
                
            }
            
        } else {
            
            request.setAttribute("error", "Error de validación");
            request.setAttribute("inputs", validator.getInputs());
            request.setAttribute("errors", errors);
            
            List<ComunaDTO> comunas = new ComunaDAO().getAll();
            request.setAttribute("comunas", comunas);
            
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
                session.setAttribute("warning", "Notaria no encontrada.");
                response.sendRedirect(request.getContextPath() + "/modulo/notarias/index");
                return;
                
            }
            
            NotariaDTO notaria = new NotariaDAO().findById(Integer.parseInt(id));
            
            if (notaria.getId() == 0) {
                
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(1);
                session.setAttribute("warning", "Notaria no encontrada.");
                response.sendRedirect(request.getContextPath() + "/modulo/notarias/index");
                return;
                
            }
            
            List<ComunaDTO> comunas = new ComunaDAO().getAll();
            request.setAttribute("comunas", comunas);
            request.setAttribute("notaria", notaria);
            
            request.getRequestDispatcher("/modules/notarias/update.jsp").forward(request, response);
            
        } catch (Exception e) {
            
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(1);
            session.setAttribute("warning", "Notaria no encontrada.");
            response.sendRedirect(request.getContextPath() + "/modulo/notarias/index");
            return;
        }
    }
    
    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String redirect = "/modules/notarias/update.jsp";
        
        Validator validator = new Validator();

        validator.addRule("nombre", "required|min:4|max:30");
        validator.addRule("direccion", "required|min:4|max:30");
        validator.addRule("razon_social", "required|min:4|max:30");
        validator.addRule("id_comuna", "required");
        
        validator.addMessage("id_comuna.required", "Seleccione una Comuna");
        
        validator.validar(request);
        
        Map<String, String> errors = validator.getErrors();
        
        NotariaDTO notaria = new NotariaDAO().findById(Integer.parseInt(request.getParameter("id")));
        
        if (errors.isEmpty()) {
            
            notaria.setNombre(request.getParameter("nombre").toUpperCase());
            notaria.setRazonSocial(request.getParameter("razon_social").toUpperCase());
            notaria.setDireccion(request.getParameter("direccion").toUpperCase());
            notaria.setTelefono(Integer.parseInt(request.getParameter("telefono")));
            notaria.setIdComuna(Integer.parseInt(request.getParameter("id_comuna")));
            
            NotariaDAO u = new NotariaDAO();
            
            if (u.update(notaria)) {
                
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(1);
                session.setAttribute("success", "Notaria modificado correctamente.");
                response.sendRedirect(request.getContextPath() + "/modulo/notarias/index");
                return;
                
            } else {
                
                request.setAttribute("error", "Error al modificar al notarias, inténtelo denuevo.");
                
            }
            
        } else {
            
            request.setAttribute("error", "Error de validación");
            request.setAttribute("inputs", validator.getInputs());
            request.setAttribute("notaria", notaria);
            request.setAttribute("errors", errors);
            
            List<ComunaDTO> comunas = new ComunaDAO().getAll();
            request.setAttribute("comunas", comunas);
            
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
                session.setAttribute("warning", "Notaria no encontrada.");
                response.sendRedirect(request.getContextPath() + "/modulo/notarias/index");
                return;
            }
            
            NotariaDTO notaria = new NotariaDAO().findById(Integer.parseInt(id));
            
            if (notaria.getId() == 0) {
                
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(1);
                session.setAttribute("warning", "Notaria no encontrada.");
                response.sendRedirect(request.getContextPath() + "/modulo/notarias/index");
                return;
            }
            
            if (new NotariaDAO().delete(notaria)) {
                
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(1);
                session.setAttribute("success", "Estado del notarias cambiado correctamente.");
                response.sendRedirect(request.getContextPath() + "/modulo/notarias/index");
                return;
                
            } else {
                
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(1);
                session.setAttribute("errr", "Error al cambiar el estado del notarias.");
                response.sendRedirect(request.getContextPath() + "/modulo/notarias/index");
                return;
                
            }
            
        } catch (Exception e) {
            
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(1);
            session.setAttribute("warning", "Notaria no encontrada.");
            response.sendRedirect(request.getContextPath() + "/modulo/notarias/index");
            return;
            
        }
        
    }
}
