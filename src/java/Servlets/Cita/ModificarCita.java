/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Cita;

import Models.DAO.CitaDAO;
import Models.DAO.CitaEstadoDAO;
import Models.DAO.NotariaDAO;
import Models.DTO.CitaDTO;
import Models.DTO.CitaEstadoDTO;
import Models.DTO.NotariaDTO;
import Models.DTO.SolicitudEstadoDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author claudio
 */
@WebServlet(name = "ModificarCita", urlPatterns = {"/citas/editar"})
public class ModificarCita extends HttpServlet {

    private final CitaDAO citaDAO = new CitaDAO();

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
            out.println("<title>Servlet ModificarCita</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModificarCita at " + request.getContextPath() + "</h1>");
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

        int id_cita = Integer.parseInt(request.getParameter("id"));

        CitaDTO cita = new CitaDTO();
        cita = citaDAO.findById(id_cita);//buscar por un ID

        CitaEstadoDAO citaEstadoDAO = new CitaEstadoDAO();
        List<CitaEstadoDTO> citaEstado = citaEstadoDAO.getAll();
        request.setAttribute("citaEstado", citaEstado);

        NotariaDAO notariaDAO = new NotariaDAO();
        List<NotariaDTO> notarias = notariaDAO.getAll();
        
        request.setAttribute("notarias", notarias);

        request.setAttribute("cita", cita);
        request.getRequestDispatcher("/modules/citas/modificar.jsp").forward(request, response);
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


       
        int id_cita = Integer.parseInt(request.getParameter("id"));//enviado por parametro oculto
        
       

        CitaDTO citaDTO = new CitaDTO();

        citaDTO = citaDAO.findById(id_cita);

        CitaEstadoDTO citaEstado = new CitaEstadoDTO();
        CitaEstadoDAO citaEstadoDAO = new CitaEstadoDAO();

        if (citaDTO.getId_estado_cita() == 1) {
            citaDTO.setId_estado_cita(2);

            citaEstado = citaEstadoDAO.findById(2);
            citaDTO.setCitaEstado(citaEstado);
        } else {
            citaDTO.setId_estado_cita(1);
            citaEstado = citaEstadoDAO.findById(1);
            citaDTO.setCitaEstado(citaEstado);
        }

 

        int resultadoOperacion = citaDAO.update(citaDTO);

        response.sendRedirect("/Lex/citas");
       
 
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
