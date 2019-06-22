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
@WebServlet(name = "SolicitudListar", urlPatterns = {"/solicitudes/listar"})
public class SolicitudListar extends HttpServlet {
    private final SolicitudDAO solicitudDAO = new SolicitudDAO();

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
            out.println("<title>Servlet SolicitudListar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SolicitudListar at " + request.getContextPath() + "</h1>");
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
        
        List<SolicitudDTO> solicitudes = solicitudDAO.getAll();

        SolicitudTiposDAO solicitudTiposDAO = new SolicitudTiposDAO();
        List<SolicitudTiposDTO> solicitudTipo = solicitudTiposDAO.getAll();
        request.setAttribute("solicitudTipo", solicitudTipo);
        
        
        
        SolicitudEstadoDAO solicitudEstadoDAO = new SolicitudEstadoDAO();
        List<SolicitudEstadoDTO> solicitudEstado = solicitudEstadoDAO.getAll();
        request.setAttribute("solicitudEstado", solicitudEstado);


        UsuarioDAO clienteDAO = new UsuarioDAO();
        List<UsuarioDTO> clientes= clienteDAO.getAllByIdRol(5);
        request.setAttribute("clientes", clientes);
        
 
         UsuarioDAO tecnicoDAO = new UsuarioDAO();
        List<UsuarioDTO> tecnico= tecnicoDAO.getAllByIdRol(3);
        request.setAttribute("tecnico", tecnico);
        
        request.setAttribute("solicitudes", solicitudes);

        request.getRequestDispatcher("/modules/solicitudes/index.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    @Override
 //   protected void doPost(HttpServletRequest request, HttpServletResponse response)
 //           throws ServletException, IOException {
 //       processRequest(request, response);
  //  }

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
