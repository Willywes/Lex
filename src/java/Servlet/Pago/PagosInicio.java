/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Pago;

import Models.DAO.PagoDAO;
import Models.DTO.PagoDTO;
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
 * @author Funny
 */
@WebServlet(name = "PagosInicio", urlPatterns = {"/pagos"})
public class PagosInicio extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final PagoDAO PagoDAO = new PagoDAO();

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
            out.println("<title>Servlet PagosInicio</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PagosInicio at " + request.getContextPath() + "</h1>");
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
        List<PagoDTO> pagos = PagoDAO.getAll();
        try {
            String contrato = request.getParameter("idContrato");

            pagos = PagoDAO.getAll(Integer.parseInt(contrato));

        } catch (Exception ex) {
            pagos = PagoDAO.getAll();
        }

        request.setAttribute("mensaje", "get");
        request.setAttribute("pagos", pagos);
        request.getRequestDispatcher("/modules/pagos/index.jsp").forward(request, response);
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

        try {
            PagoDAO.delete(Integer.parseInt(request.getParameter("idPago")));
        } catch (Exception ex) {

        }

        List<PagoDTO> pagos = PagoDAO.getAll();
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
