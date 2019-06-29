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
@WebServlet(name = "SolicitudesCrearUsuario", urlPatterns = {"/solicitudes/crearusuario"})
public class SolicitudCrearUsuario extends HttpServlet {
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
            out.println("<title>Servlet SolicitudCrearUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SolicitudCrearUsuario at " + request.getContextPath() + "</h1>");
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
         //Session
       HttpSession misession= (HttpSession) request.getSession();
       UsuarioDTO usuarioDTO= (UsuarioDTO) misession.getAttribute("usuarioDTO");
       request.setAttribute("usuarioDTO", usuarioDTO);
       
    //recuperar lista de todos los involucrados
    List<SolicitudTiposDTO> tipoDeSolicitudes = tipoSolicitudDAO.getAll();
    request.setAttribute("tipoDeSolicitudes", tipoDeSolicitudes);   
    
    List<SolicitudEstadoDTO> estadoSolicitudes = estadoSolicitudDAO.getAll();
    request.setAttribute("estadoSolicitudes", estadoSolicitudes);
    
    
    UsuarioDTO clientes = new UsuarioDTO();
    
    int id=usuarioDTO.getId();
    //id recuperado de  Inicio de sesion 
    clientes = usuarioDAO.findById(id);
    
  
    request.setAttribute("clientes", clientes);
    
    //id tecnico 3 tecnico juridico
  //  List<UsuarioDTO> tecnicos = usuarioDAO.getAllByIdRol(3);
   // request.setAttribute("tecnicos", tecnicos);
    
    request.getRequestDispatcher("/modules/solicitudes/crearusuario.jsp").forward(request, response);
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
    
    SolicitudDTO solicitud = new SolicitudDTO();    
    SolicitudTiposDAO solicitudTiposDAO = new SolicitudTiposDAO();
    SolicitudEstadoDAO solicitudEstadoDAO = new SolicitudEstadoDAO();
    
    java.util.Date utilDate = new java.util.Date();
    java.sql.Date fechaHora = new java.sql.Date(utilDate.getTime());
    String descripcion =request.getParameter("textDescripcion");//listo
    int id_tipo_solicitud = Integer.parseInt(request.getParameter("selectTipoSolicitud"));//listo
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
    UsuarioDTO usuarioDTO = new UsuarioDTO();
    String session3=request.getParameter("usuarioSession");
    int id=Integer.parseInt(session3);
    usuarioDTO=usuarioDAO.findById(id);
    request.setAttribute("usuarioDTO", usuarioDTO);
 
    int id_cliente=Integer.parseInt(session3);// paso ID de clente. 101
    UsuarioDTO cliente = new UsuarioDTO();
    cliente = usuarioDAO.findById(id_cliente);
    solicitud.setCliente(cliente);
    solicitud.setId_cliente(cliente.getId());
    

    solicitud.setCliente(cliente);
    
    
   
    
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
    
    request.setAttribute("usuarioDTO", usuarioDTO);
    
    response.sendRedirect("/Lex/solicitudes/listarcliente");
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
