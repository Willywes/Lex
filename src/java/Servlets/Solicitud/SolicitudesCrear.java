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
import javax.servlet.http.HttpSession;

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
      //Session
       HttpSession misession= (HttpSession) request.getSession();
       UsuarioDTO usuarioDTO= (UsuarioDTO) misession.getAttribute("usuarioDTO");
       request.setAttribute("usuarioDTO", usuarioDTO);
       
    //recuperar lista de todos los involucrados
    List<SolicitudTiposDTO> tipoDeSolicitudes = tipoSolicitudDAO.getAll();
    request.setAttribute("tipoDeSolicitudes", tipoDeSolicitudes);   
    
    List<SolicitudEstadoDTO> estadoSolicitudes = estadoSolicitudDAO.getAll();
    request.setAttribute("estadoSolicitudes", estadoSolicitudes);
    
    
   // UsuarioDTO clientes = new UsuarioDTO();
    
   // int id=usuarioDTO.getId();
       //id recuperado de  Inicio de sesion 
   // clientes = usuarioDAO.findById(id);
    List <UsuarioDTO> clientes= usuarioDAO.getAllClients();
    
  
    request.setAttribute("clientes", clientes);
    
    //id tecnico 3 tecnico juridico
  //  List<UsuarioDTO> tecnicos = usuarioDAO.getAllByIdRol(3);
   // request.setAttribute("tecnicos", tecnicos);
    
    request.getRequestDispatcher("/modules/solicitudes/crear.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    //session
    //HttpSession misession= (HttpSession) request.getSession();
    //UsuarioDTO usuarioDTO= (UsuarioDTO) misession.getAttribute("usuarioDTO");
      
      
    SolicitudDTO solicitud = new SolicitudDTO();    
    SolicitudTiposDAO solicitudTiposDAO = new SolicitudTiposDAO();
    SolicitudEstadoDAO solicitudEstadoDAO = new SolicitudEstadoDAO();
    
    java.util.Date utilDate = new java.util.Date();
    java.sql.Date fechaHora = new java.sql.Date(utilDate.getTime());
    String descripcion =request.getParameter("textDescripcion");//listo
    int id_tipo_solicitud = Integer.parseInt(request.getParameter("selectTipoSolicitud"));//listo
    int id_cliente = Integer.parseInt(request.getParameter("selectCliente"));//
    UsuarioDTO cliente = usuarioDAO.findById(id_cliente);
    
    int id_estado_solicitud = 2;// 2 es en espera
    Date creado = fechaHora;

     int id_solicitud = 1000;
     solicitud.setId_solicitud(id_solicitud);
    
    //id tecnico null
    int id_tecnico=999;
    solicitud.setId_tecnico(id_tecnico);
    UsuarioDTO tecnico = new UsuarioDTO();
    //tecnico=usuarioDAO.getAllByIdRol(3);
    tecnico = usuarioDAO.findById(1);
    
    solicitud.setTecnico(tecnico);
    
   // solicitud.setId_solicitud(10);//test
    solicitud.setFecha_hora(fechaHora);
    solicitud.setDescripcion(descripcion);
    
    
    
    solicitud.setId_tipo_solicitud(id_tipo_solicitud);
    SolicitudTiposDTO solicitudTiposDTO = solicitudTiposDAO.findById(id_tipo_solicitud);//listo
    solicitud.setTipoSolicitud(solicitudTiposDTO);
    
    solicitud.setId_estado_solicitud(id_estado_solicitud);
    SolicitudEstadoDTO solicitudEstadoDTO = solicitudEstadoDAO.findById(id_estado_solicitud);
    solicitud.setEstadoSolicitud(solicitudEstadoDTO);
    
    solicitud.setCreado(creado);
   
    //recuperar parametro session
    UsuarioDTO session = new UsuarioDTO();
    String session3=request.getParameter("usuarioSession");
      System.out.println("  session3 "+session3);
    //id recuperado de  Inicio de sesion 141  5 rol de clinete
   // <c:if test="${usuarioDTO.id_rol == 1 || usuarioDTO.id_rol == 2 || usuarioDTO.id_rol == 3}">
    // </c:if>
    //      if (usuarioDTO.id_rol==5) {
              
     //     }
     
             
    //int id_cliente=101;
   // UsuarioDTO cliente = new UsuarioDTO();
   
   // datos el cliente
    cliente = usuarioDAO.findById(id_cliente);
    solicitud.setCliente(cliente);
    solicitud.setId_cliente(cliente.getId());
    

  
    
      System.out.println("Id Clinete "+id_cliente+ "Solicitud "+solicitud );
   
    
   //Tecnico null
   // UsuarioDTO tecnico = usuarioDAO.findById(id_tecnico);
   // solicitud.setTecnico(tecnico);
    
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
    
    response.sendRedirect("/Lex/solicitudes/listar");
   
  
    
  }

  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
