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

@WebServlet(name = "SolicitudModificar", urlPatterns = {"/solicitudes/actualizar"})
public class SolicitudModificar extends HttpServlet {
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
            out.println("<title>Servlet SolicitudModificar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SolicitudModificar at " + request.getContextPath() + "</h1>");
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
        request.setAttribute("id_solicitud", id_solicitud);
        
        SolicitudDTO solicitudes = new SolicitudDTO();
        solicitudes = solicitudDAO.findById(id_solicitud);//buscar por un ID       
        request.setAttribute("solicitudes", solicitudes);
        
        
        ////
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
        ///

        request.getRequestDispatcher("/modules/solicitudes/modificar.jsp").forward(request, response);
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
        
        int respuesta;
        
        
        int id_solicitud = Integer.parseInt(request.getParameter("id"));
        
        
       // System.out.println("ID "+id_solicitud);
        SolicitudDTO solicitudActualizar = new SolicitudDTO();
        
        
        solicitudActualizar = solicitudDAO.findById(id_solicitud);
        
       
        String descripcion = request.getParameter("txtDescripcion");
        
        int id_estado_solicitud = Integer.parseInt(request.getParameter("selectestadoSolicitudes"));
        System.out.println("EL ID ESTADO SOLICITUD ES: "+id_estado_solicitud);
        //int id_tipo_solicitud = Integer.parseInt(request.getParameter("selectTipoSolicitud"));
        
       // int id_cliente = Integer.parseInt(request.getParameter("selectCliente"));
       // int id_tecnico = Integer.parseInt(request.getParameter("selectTecnico"));
        
       // System.out.println("tipo id "+id_tipo_solicitud+ " Cliente id "+id_cliente+" selectTecnico "+id_tecnico);
      //  SolicitudTiposDTO soliTipoDTO = new SolicitudTiposDTO();
        SolicitudEstadoDTO soliEstadoDTO = new SolicitudEstadoDTO();
     //   UsuarioDTO usuarioCliente = new UsuarioDTO();
     //   UsuarioDTO usuarioTecnico = new UsuarioDTO();
        
        
      //  soliTipoDTO=tipoSolicitudDAO.findById(id_tipo_solicitud);
        soliEstadoDTO =estadoSolicitudDAO.findById(id_estado_solicitud);//en espera eso significa 2
        
       //  usuarioCliente=usuarioDAO.findById(id_estado_solicitud);
      //   usuarioTecnico = usuarioDAO.findById(id_tecnico);
        
        //solicitudActualizar.setCliente(usuarioCliente);
        //solicitudActualizar.setTecnico(usuarioTecnico);
        //solicitudActualizar.setDescripcion(descripcion);
        solicitudActualizar.setEstadoSolicitud(soliEstadoDTO);
        //solicitudActualizar.setTipoSolicitud(soliTipoDTO);
      
       
        respuesta=solicitudDAO.update(solicitudActualizar);
        
        request.getRequestDispatcher("/modules/solicitudes/index.jsp").forward(request, response);
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
