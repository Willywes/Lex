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
import Servlets.Cita.CitaServlet;
import static com.sun.xml.bind.util.CalendarConv.formatter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "SolicitudBuscar", urlPatterns = {"/solicitudes/buscarfechas"})
public class SolicitudBuscarFechas extends HttpServlet {
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
            out.println("<title>Servlet SolicitudBuscarFechas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SolicitudBuscarFechas at " + request.getContextPath() + "</h1>");
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
        
        request.getRequestDispatcher("/modules/solicitudes/buscarfechas.jsp").forward(request, response);
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
    //    java.util.Date utilDate = new java.util.Date();
   //     java.sql.Date fechaInicio = new java.sql.Date(utilDate.getTime());
    //    java.sql.Date fechaTermino = new java.sql.Date(utilDate.getTime());
        
        //recuperacion de datos de JSP
        String fechaInicio = request.getParameter("FechaInicio");
        String fechaTermino = request.getParameter("FechaTermino");
        
        System.out.println("fecha inicio "+fechaInicio);
        
       // cambiar formato de la fecha String
       
        String[] parts = fechaInicio.split("-");
        String part1 = parts[0]; // 
        String part2 = parts[1]; // 
        String part3 = parts[2];
        
        fechaInicio=part3+"-"+part2+"-"+part1;
        
        String[] parts1 = fechaTermino.split("-");
        String part11 = parts1[0]; // 
        String part22 = parts1[1]; // 
        String part33 = parts1[2];
        
        fechaTermino=part33+"-"+part22+"-"+part11;
      
       
       //
 //           java.util.Date utilDate = new java.util.Date();
//            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
    
            
 //            try{
                 
                 // el que parsea
 //                SimpleDateFormat parseador = new SimpleDateFormat("dd-MM-yy");
// el que formatea
//                 SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yy");

        //         Date fecha = parseador.parse("31-03-2016");
        //         System.out.println(formateador.format(date));

                 
//            SimpleDateFormat sdf1 = new SimpleDateFormat("DD-MM-YYYY");
            
//            java.util.Date date = sdf1.parse(fechaInicio);
//            java.sql.Date dateFechaInicio = new java.sql.Date(date.getTime());
             
            
//            java.util.Date date1 = sdf1.parse(fechaTermino);
//            java.sql.Date dateFechaTermino = new java.sql.Date(date1.getTime());
             
 //           fechaInicio =dateFechaInicio.toString();
 //           fechaTermino=dateFechaTermino.toString();
             
            
             
   //     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
   //     java.util.Date dateFechaInicio = formatter.parse(fechaInicio);
   //     java.util.Date dateFechaTermino = formatter.parse(fechaTermino);
        
       //falta convertir 
       List<SolicitudDTO> solicitudes = solicitudDAO.buscarPorFecha(fechaInicio, fechaTermino);
        
        System.out.println("fechaInicio "+fechaInicio);
       
       request.setAttribute("solicitudes", solicitudes);
       
     
       request.getRequestDispatcher("/modules/solicitudes/listarfechas.jsp").forward(request, response);
       
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
