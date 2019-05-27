/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Cita;

import Models.DAO.CitaDAO;
import Models.DTO.CitaDTO;
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
@WebServlet(name = "ActualizarEstadoCita", urlPatterns = {"/citas/cambiar"})
public class ActualizarEstadoCita extends HttpServlet {

    private final CitaDAO citaDAO = new CitaDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ActualizarEstadoCita</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActualizarEstadoCita at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        CitaDTO citaDTO = new CitaDTO();

        citaDTO = citaDAO.findById(id);
        int status = citaDTO.getId_estado_cita();
        status = citaDAO.cambiarStatus(status);
        citaDTO.setId_estado_cita(status);
       citaDAO.update(citaDTO);

       request.getRequestDispatcher("/modules/citas/borrar.jsp").forward(request, response);
       // Aquí tienes que o hacer una redirección al index de las citas o crear una vista nueva y llevar al usuario ahí.
        //request.getRequestDispatcher("/modules/citas/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
