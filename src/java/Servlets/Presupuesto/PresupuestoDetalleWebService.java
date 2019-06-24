/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Presupuesto;

import Models.DAO.PresupuestoDetalleDAO;
import Models.DTO.PresupuestoDetalleDTO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

/**
 *
 * @author jean
 */
@WebServlet(name = "PresupuestoDetalleWebService", urlPatterns = {"/PresupuestoDetalleWebService"})
public class PresupuestoDetalleWebService extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final PresupuestoDetalleDAO presupuestoDetalle = new PresupuestoDetalleDAO();

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
            out.println("<title>Servlet PresupuestoDetalleWebService</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PresupuestoDetalleWebService at " + request.getContextPath() + "</h1>");
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

        int idPresupuesto = Integer.parseInt(request.getParameter("idPresupuesto"));

        List<JSONObject> jsons = new ArrayList<JSONObject>();
        
        List<PresupuestoDetalleDTO> detalle = this.presupuestoDetalle.getDetallesByIdPresupuesto(idPresupuesto);
        try (PrintWriter out = response.getWriter()) {
            for (PresupuestoDetalleDTO presupuestoDetalleDTO : detalle) {
                JSONObject json = new JSONObject();
                json.put("id_detalle", presupuestoDetalleDTO.getId_detalle_presupuesto());
                json.put("id_presupuesto", presupuestoDetalleDTO.getId_presupuesto());
                json.put("monto", presupuestoDetalleDTO.getMonto());
                json.put("servicio", presupuestoDetalleDTO.getServicio());
                jsons.add(json);
            }
            out.print("[" + jsons.toString() + "]");
        }

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
