/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.SolicitudTipos;

import Models.DAO.SolicitudTiposDAO;
import Models.DTO.SolicitudTiposDTO;
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
 * @author Claudio 
 */
@WebServlet(name = "SolicitudTipos", urlPatterns = {"/tipos-solicitud"})
public class SolicitudTipos extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private final SolicitudTiposDAO solicitudTiposDAO = new SolicitudTiposDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SolicitudTiposServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SolicitudTiposServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<SolicitudTiposDTO> solicitudes = solicitudTiposDAO.getAll();
        request.setAttribute("solicitudes", solicitudes);        
        request.getRequestDispatcher("/modules/solicitud-tipo/index.jsp").forward(request, response);
    }

}
