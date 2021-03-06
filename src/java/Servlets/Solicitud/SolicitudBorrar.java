/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Solicitud;

import Models.DAO.SolicitudDAO;
import Models.DAO.SolicitudEstadoDAO;
import Models.DAO.SolicitudTiposDAO;
import Models.DAO.UsuarioDAO;
import Models.DTO.SolicitudDTO;
import Models.DTO.SolicitudEstadoDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author claudio
 */
@WebServlet(name = "SolicitudBorrar", urlPatterns = {"/solicitudes/borrar"})
public class SolicitudBorrar extends HttpServlet {
private final SolicitudTiposDAO tipoSolicitudDAO = new SolicitudTiposDAO();
  private final SolicitudEstadoDAO estadoSolicitudDAO = new SolicitudEstadoDAO();
  private final SolicitudDAO solicitudDAO = new SolicitudDAO();
  private final UsuarioDAO usuarioDAO = new UsuarioDAO();
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
            out.println("<title>Servlet SolicitudBorrar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SolicitudBorrar at " + request.getContextPath() + "</h1>");
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
       
        int id_solicitud = Integer.parseInt(request.getParameter("id"));
        SolicitudDTO solicitudes=solicitudDAO.findById(id_solicitud);
        
           
        request.setAttribute("solicitudes", solicitudes);      
        
        request.getRequestDispatcher("/modules/solicitudes/confirmarborrar.jsp").forward(request, response);
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
        
        int id_solicitud = Integer.parseInt(request.getParameter("idSolicitud"));
             
        
      // 3 es rechazado o cancelado
        SolicitudDTO solicitudActualizar = new SolicitudDTO();
        solicitudActualizar =solicitudDAO.findById(id_solicitud);
        
        SolicitudEstadoDTO solicitudEstadoDTO =new SolicitudEstadoDTO();
        solicitudEstadoDTO =estadoSolicitudDAO.findById(3);
        
        solicitudActualizar.setEstadoSolicitud(solicitudEstadoDTO);
        solicitudActualizar.setId_estado_solicitud(3);
        
      
        
        //solicitudDAO.delete(id_solicitud);
        solicitudDAO.update(solicitudActualizar);
        
        response.sendRedirect("/Lex/solicitudes/listar");
        //request.getRequestDispatcher("/solicitudes/listar").forward(request, response);
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
