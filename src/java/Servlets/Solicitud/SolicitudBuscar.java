/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Solicitud;

import Models.DAO.NotariaDAO;
import Models.DAO.SolicitudDAO;
import Models.DAO.SolicitudEstadoDAO;
import Models.DAO.SolicitudTiposDAO;
import Models.DAO.UsuarioDAO;
import Models.DTO.SolicitudDTO;
import Models.DTO.UsuarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author claudio
 */ 
@WebServlet(name = "SolicitudBuscar", urlPatterns = {"/solicitudes/buscar"})
public class SolicitudBuscar extends HttpServlet {
    
    private final SolicitudTiposDAO tipoSolicitudDAO = new SolicitudTiposDAO();
    private final SolicitudEstadoDAO estadoSolicitudDAO = new SolicitudEstadoDAO();
    private final SolicitudDAO solicitudDAO = new SolicitudDAO();
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
  

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SolicitudBuscar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SolicitudBuscar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //id clientes 5 cliente
        List<UsuarioDTO> clientes = usuarioDAO.getAllByIdRol(5);
        request.setAttribute("clientes", clientes);
        
        request.getRequestDispatcher("/modules/solicitudes/buscartipos.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        //id clientes 5 cliente
        
        List<UsuarioDTO> clientes = usuarioDAO.getAllByIdRol(5);
        request.setAttribute("clientes", clientes);
        
        
         int id_cliente = Integer.parseInt(request.getParameter("selectCliente"));
        request.setAttribute("id_cliente", id_cliente);
        
       // SolicitudDTO solicitudes = new SolicitudDTO();
        List<SolicitudDTO> solicitudes = solicitudDAO.buscarPorCliente(id_cliente);
       // solicitudes = solicitudDAO.//buscar por un ID    
        
        request.setAttribute("solicitudes", solicitudes);
        
        request.getRequestDispatcher("/modules/solicitudes/lista.jsp").forward(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
