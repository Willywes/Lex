/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Solicitud;

import Models.DAO.SolicitudDAO;
import Models.DAO.SolicitudTiposDAO;
import Models.DTO.SolicitudDTO;
import Models.DTO.SolicitudTiposDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
@WebServlet(name = "Solicitudes", urlPatterns = {"/solicitudes"})
public class Solicitudes extends HttpServlet {

  private final SolicitudDAO solicitudDAO = new SolicitudDAO();
  
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      /* TODO output your page here. You may use following sample code. */
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet Solicitudes</title>");      
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet Solicitudes at " + request.getContextPath() + "</h1>");
      out.println("</body>");
      out.println("</html>");
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    List<SolicitudDTO> solicitudes = solicitudDAO.getAll();
    request.setAttribute("solicitudes", solicitudes);        
    request.getRequestDispatcher("/modules/solicitudes/index.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
    
    
  }

  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
