/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Solicitud;

import Models.DAO.SolicitudEstadoDAO;
import Models.DTO.SolicitudEstadoDTO;
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
@WebServlet(name = "SolicitudEstados", urlPatterns = {"/solicitudes/estados"})
public class SolicitudEstados extends HttpServlet {

  private final SolicitudEstadoDAO solicitudTiposDAO = new SolicitudEstadoDAO();
  
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      /* TODO output your page here. You may use following sample code. */
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet SolicitudEstados</title>");      
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet SolicitudEstados at " + request.getContextPath() + "</h1>");
      out.println("</body>");
      out.println("</html>");
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    List<SolicitudEstadoDTO> estados = solicitudTiposDAO.getAll();
    request.setAttribute("estados", estados);        
    request.getRequestDispatcher("/modules/solicitudes/estados.jsp").forward(request, response);
  }
}
