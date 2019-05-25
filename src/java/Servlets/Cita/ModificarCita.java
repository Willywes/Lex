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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    request.setAttribute("id_cita", id_cita); 
    CitaDTO cita = new CitaDTO();
    cita=citaDAO.findById(id_cita);//buscar por un ID
      System.out.println("Fecha servlet "+cita.getFecha_hora());
    request.setAttribute("cita",cita);
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
        
      
        String fechaCita =request.getParameter("txtfechaHora");
        String horaCita = request.getParameter("txthora");
        String minutosCita = request.getParameter("txtminutos");
        String fechaHora = fechaCita+" "+horaCita+":"+minutosCita+":00";
        //System.out.println(fechaHora);
        
        int id=Integer.parseInt(request.getParameter("id"));//enviado por parametro oculto
        int idNotaria=Integer.parseInt(request.getParameter("txtidnotaria"));
        int estadoCita = Integer.parseInt(request.getParameter("txtestadonotaria"));
             
        CitaDTO citaDTO = new CitaDTO();
        
        try {
            
            
            String startDate= fechaHora;
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            java.util.Date date = sdf1.parse(startDate);
            java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
            
            System.out.println(sqlStartDate.toString());
            
            
            System.out.println(fechaHora);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date dateCita = formatter.parse(fechaHora);
            java.sql.Date sqlDate = new java.sql.Date(dateCita.getTime());
            System.out.println(sqlDate.toString());
            
            citaDTO.setId_cita(Integer.parseInt(request.getParameter("id")));
            citaDTO.setFecha_hora(sqlDate);
            citaDTO.setId_estado_cita(estadoCita); 
            citaDTO.setId_notaria(idNotaria);
            
            System.out.println(citaDTO.toString());// test  borrar
            
            int resultadoOperacion = citaDAO.update(citaDTO);
            
            System.out.println(" el valor es "+resultadoOperacion);
            
        } catch (ParseException ex) {
            Logger.getLogger(CitaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }       
        request.getRequestDispatcher("/modules/citas/crear-cita.jsp").forward(request, response);
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
