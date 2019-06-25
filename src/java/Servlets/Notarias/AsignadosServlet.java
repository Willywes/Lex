/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Notarias;

import Models.DAO.AsignadosDAO;
import Models.DAO.UsuarioDAO;
import Models.DTO.NotariaDTO;
import Models.DTO.NotariaNota;
import Models.DTO.UsuarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Depredador
 */
@WebServlet(name = "AsignadosServlet", urlPatterns = {"/AsignadosServlet"})
public class AsignadosServlet extends HttpServlet {
   // private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private final AsignadosDAO AsignadosDAO = new AsignadosDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AsignadosServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AsignadosServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        processRequest(request, response);
        
          List<NotariaNota> notarias =  AsignadosDAO.getAll();
           request.setAttribute("mensaje", "get");
        request.setAttribute("notarias", notarias);
         List<NotariaNota> usuarios =  AsignadosDAO.getAll();
           request.setAttribute("mensaje", "get");
        request.setAttribute("usuarios", usuarios);
        
        request.getRequestDispatcher("/modules/notarias/asignados.jsp").forward(request, response);
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
        processRequest(request, response);
        

//        new UsuarioDAO().getAllByIdRol(4);
        List<NotariaNota> usuarios = new AsignadosDAO().getAll();
        List<NotariaNota> notarias = new AsignadosDAO().getAll();
       
       // request.setAttribute("roles", roles);
       request.setAttribute("usuarios", usuarios);
       request.setAttribute("notarias", notarias);
       
         request.getRequestDispatcher("/modules/notarias/asignados.jsp").forward(request, response);
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
