/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Cita;

import Models.DAO.CitaDAO;
import Models.DAO.NotariaDAO;
import Models.DTO.CitaDTO;
import Models.DTO.NotariaDTO;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author claudio
 */
@WebServlet(name = "CrearCita", urlPatterns = {"/citas/crear"})
public class CrearCita extends HttpServlet {

    private final CitaDAO citaDAO = new CitaDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CrearCita</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CrearCita at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<NotariaDTO> notarias = new NotariaDAO().getAll();
        request.setAttribute("notarias", notarias);
        request.getRequestDispatcher("/modules/citas/crear-cita.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fechaCita = request.getParameter("txtfechaHora");
        String horaCita = request.getParameter("txthora");
        String minutosCita = request.getParameter("txtminutos");
        String fechaHora = fechaCita + " " + horaCita + ":" + minutosCita + ":00";
        System.out.println(fechaHora);

        int idNotaria = Integer.parseInt(request.getParameter("txtidnotaria"));

        CitaDTO citaDTO = new CitaDTO();

        try {

            String startDate = fechaHora;
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            java.util.Date date = sdf1.parse(startDate);
            java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());

            System.out.println(sqlStartDate.toString());

            System.out.println(fechaHora);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date dateCita = formatter.parse(fechaHora);
            java.sql.Date sqlDate = new java.sql.Date(dateCita.getTime());
            System.out.println(sqlDate.toString());
            citaDTO.setFecha_hora(sqlDate);
            citaDTO.setId_estado_cita(1);
            citaDTO.setId_notaria(idNotaria);

            int resultadoOperacion = citaDAO.create(citaDTO);
            if (resultadoOperacion == 1) {
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(1);
                session.setAttribute("success", "Cita creada correctamente.");
                response.sendRedirect(request.getContextPath() + "/citas");
                return;
            }

        } catch (ParseException ex) {
            Logger.getLogger(CitaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
//        
        request.getRequestDispatcher("/modules/citas/crear-cita.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short descript  ion";
    }// </editor-fold>
}
