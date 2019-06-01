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
import Models.DTO.SolicitudTiposDTO;
import Models.DTO.UsuarioDTO;
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
 * @author claudio
 */
@WebServlet(name = "SolicitudesCrear", urlPatterns = {"/solicitudes/crear"})
public class SolicitudesCrear extends HttpServlet {

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
      out.println("<title>Servlet SolicitudesCrear</title>");      
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet SolicitudesCrear at " + request.getContextPath() + "</h1>");
      out.println("</body>");
      out.println("</html>");
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    //recuperar lista de todos los involucrados
    List<SolicitudTiposDTO> tipoDeSolicitudes = tipoSolicitudDAO.getAll();
    request.setAttribute("tipoDeSolicitudes", tipoDeSolicitudes);   
    
    List<SolicitudEstadoDTO> estadoSolicitudes = estadoSolicitudDAO.getAll();
    request.setAttribute("estadoSolicitudes", estadoSolicitudes);
    
    //id clientes 5 cliente
    List<UsuarioDTO> clientes = usuarioDAO.getAllByIdRol(5);
    request.setAttribute("clientes", clientes);
    
    //id tecnico 3 tecnico juridico
    List<UsuarioDTO> tecnicos = usuarioDAO.getAllByIdRol(3);
    request.setAttribute("tecnicos", tecnicos);
    
    request.getRequestDispatcher("/modules/solicitudes/crear.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
    SolicitudDTO solicitud = new SolicitudDTO();    
    SolicitudTiposDAO solicitudTiposDAO = new SolicitudTiposDAO();
    SolicitudEstadoDAO solicitudEstadoDAO = new SolicitudEstadoDAO();
    
    java.util.Date utilDate = new java.util.Date();
    java.sql.Date fechaHora = new java.sql.Date(utilDate.getTime());
    String descripcion =request.getParameter("txtDescripcion");
    int id_tipo_solicitud = Integer.parseInt(request.getParameter("selectTipoSolicitud"));
    int id_estado_solicitud = 2;
    Date creado = fechaHora;
    Date modificado = fechaHora;
    int id_cliente = Integer.parseInt(request.getParameter("selectCliente"));
    int id_tecnico = Integer.parseInt(request.getParameter("selectTecnico"));    
   
    solicitud.setId_solicitud(10);//test
    solicitud.setFecha_hora(fechaHora);
    solicitud.setDescripcion(descripcion);
    SolicitudTiposDTO solicitudTiposDTO = solicitudTiposDAO.findById(id_tipo_solicitud);
    solicitud.setTipoSolicitud(solicitudTiposDTO);
    SolicitudEstadoDTO solicitudEstadoDTO = solicitudEstadoDAO.findById(id_estado_solicitud);
    solicitud.setEstadoSolicitud(solicitudEstadoDTO);
    solicitud.setCreado(creado);
    solicitud.setModificado(modificado);
    UsuarioDTO cliente = usuarioDAO.findById(id_cliente);
    solicitud.setCliente(cliente);
    UsuarioDTO tecnico = usuarioDAO.findById(id_tecnico);
    solicitud.setTecnico(tecnico);
    
    int resultadoOperacion = solicitudDAO.create(solicitud);
    
    
    List<SolicitudTiposDTO> tipoDeSolicitudes = tipoSolicitudDAO.getAll();
    request.setAttribute("tipoDeSolicitudes", tipoDeSolicitudes);   
    
    List<SolicitudEstadoDTO> estadoSolicitudes = estadoSolicitudDAO.getAll();
    request.setAttribute("estadoSolicitudes", estadoSolicitudes);
    
    //id clientes 5
    List<UsuarioDTO> clientes = usuarioDAO.getAllByIdRol(5);
    request.setAttribute("clientes", clientes);
    
    //id tecnico 3
    List<UsuarioDTO> tecnicos = usuarioDAO.getAllByIdRol(3);
    request.setAttribute("tecnicos", tecnicos);
    request.getRequestDispatcher("/modules/solicitudes/crear.jsp").forward(request, response);
    
  }

  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
