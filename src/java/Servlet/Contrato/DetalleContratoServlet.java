/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Contrato;


import Models.DAO.ContratoDAO;
import Models.DAO.ContratoDetalleDAO;
import Models.DAO.ContratoEstadoDAO;
import Models.DAO.FormaPagoDAO;
import Models.DAO.PlanPagoDAO;
import Models.DAO.PresupuestoIDDAO;
import Models.DAO.UsuarioDAO;
import Models.DTO.ContratoDTO;
import Models.DTO.ContratoDetalleDTO;
import Models.DTO.ContratoEstadoDTO;
import Models.DTO.PlanPagoDTO;
import Models.DTO.PresupuestoIDDTO;
import Models.DTO.UsuarioDTO;
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
import javax.servlet.http.HttpSession;


/**
 *
 * @author TECMAR
 */
@WebServlet(name = "DetalleContratoServlet", urlPatterns = {"/DetalleContratoServlet"})
public class DetalleContratoServlet extends HttpServlet {
    private final ContratoDAO contratoDAO = new ContratoDAO();
    private final ContratoEstadoDAO contratoEstadoDAO = new ContratoEstadoDAO();
    //private final ContratoDetalleDAO contratoDetalleDAO = new ContratoDetalleDAO();
    private final PresupuestoIDDAO presupuestoIDDAO = new PresupuestoIDDAO();
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private final PlanPagoDAO planPagoDAO = new PlanPagoDAO();
    private final FormaPagoDAO formaPagoDAO = new FormaPagoDAO();

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
            out.println("<title>Servlet DetalleContratoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DetalleContratoServlet at " + request.getContextPath() + "</h1>");
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
       int id_contrato = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id_contrato", id_contrato);
       
        /*este esta aparte porque aqui mando los datos del contrato
        para no mandarlos por url los traigo mediante el PA findbyid
        */
        ContratoDTO contrato = new ContratoDTO();
        contrato = contratoDAO.findById(id_contrato);
        request.setAttribute("contrato", contrato);
        
        List<ContratoEstadoDTO> estados = contratoEstadoDAO.getAll();
        //List<ContratoDetalleDTO> detalles = contratoDetalleDAO.getAll();
        List<PresupuestoIDDTO> presupuestos = presupuestoIDDAO.getAll();
        List<UsuarioDTO> usuarios = usuarioDAO.getAll();
        List<PlanPagoDTO> ppagos = planPagoDAO.getAll();
        //List<FormaPagoDTO> fpagos = planPagoDAO.getAll();
        
        request.setAttribute("estados", estados);
        //request.setAttribute("detalles", detalles);
        request.setAttribute("presupuestos", presupuestos);
        request.setAttribute("usuarios", usuarios);
        request.setAttribute("ppagos", ppagos);
        request.getRequestDispatcher("/modules/contratos/DetalleContrato.jsp").forward(request, response);
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
        int id_contrato = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id_contrato", id_contrato);
       
        /*este esta aparte porque aqui mando los datos del contrato
        para no mandarlos por url los traigo mediante el PA findbyid
        */
        ContratoDTO contrato = new ContratoDTO();
        contrato = contratoDAO.findById(id_contrato);
        request.setAttribute("contrato", contrato);
        
        List<ContratoEstadoDTO> estados = contratoEstadoDAO.getAll();
        //List<ContratoDetalleDTO> detalles = contratoDetalleDAO.getAll();
        List<PresupuestoIDDTO> presupuestos = presupuestoIDDAO.getAll();
        List<UsuarioDTO> usuarios = usuarioDAO.getAll();
        List<PlanPagoDTO> ppagos = planPagoDAO.getAll();
        //List<FormaPagoDTO> fpagos = planPagoDAO.getAll();
        
        request.setAttribute("estados", estados);
        //request.setAttribute("detalles", detalles);
        request.setAttribute("presupuestos", presupuestos);
        request.setAttribute("usuarios", usuarios);
        request.setAttribute("ppagos", ppagos);
        request.getRequestDispatcher("/modules/contratos/Modificar.jsp").forward(request, response);
        
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
