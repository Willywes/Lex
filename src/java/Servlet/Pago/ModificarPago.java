/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Pago;

import Models.DAO.ContratoDAO;
import Models.DAO.PagoDAO;
import Models.DTO.ContratoDTO;
import Models.DTO.PagoClienteDTO;
import Models.DTO.PagoDTO;
import Models.DTO.PagosContratoClienteDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jean
 */
@WebServlet(name = "ModificarPago", urlPatterns = {"/pagos/modificar"})
public class ModificarPago extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final PagoDAO PagoDAO = new PagoDAO();
    private final ContratoDAO ContratoDAO = new ContratoDAO();

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
            out.println("<title>Servlet ModificarPago</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModificarPago at " + request.getContextPath() + "</h1>");
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
        String idPago = request.getParameter("idPago");

        try {

            List<ContratoDTO> contratos = this.ContratoDAO.getAll();
            request.setAttribute("contratos", contratos);

            PagoDTO pago = new PagoDTO();

            pago = PagoDAO.findById(Integer.parseInt(idPago));

            request.setAttribute("pago", pago);

            request.getRequestDispatcher("/modules/pagos/editarPagos.jsp").forward(request, response);

        } catch (Exception ex) {

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
        String fecha = request.getParameter("fecha");
        String horaCita = "0";
        String minutosCita = "00";
        String fechaHora = fecha + " " + horaCita + ":" + minutosCita + ":00";

        //contrato
        //monto
        String contrato = request.getParameter("contrato");
        String monto = request.getParameter("monto");
        String idPago = request.getParameter("idPago");

        boolean exito = false;

        try {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            java.util.Date dateCita = formatter.parse(fechaHora);
            java.sql.Date sqlDate = new java.sql.Date(dateCita.getTime());

            PagoDTO pago = new PagoDTO();

            pago.setId_pago(Integer.parseInt(idPago));
            pago.setFecha_hora(sqlDate);
            pago.setMonto(Integer.parseInt(monto));
            pago.setId_contrato(Integer.parseInt(contrato));
            pago.setCreado(sqlDate);
            pago.setModificado(sqlDate);

            int resultado = PagoDAO.update(pago);

            if (resultado == 1) {
                exito = true;
            }

        } catch (Exception ex) {

        }

        List<PagosContratoClienteDTO> pagos = PagoDAO.getPagosUsuario();
        request.setAttribute("mensaje", "get");
        request.setAttribute("pagos", pagos);
        request.getRequestDispatcher("/modules/pagos/index.jsp").forward(request, response);
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
