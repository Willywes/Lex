/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Contrato;

import Models.DAO.ContratoDAO;
import Models.DAO.ContratoDetalleDAO;
import Models.DTO.ContratoDTO;
import Models.DAO.ContratoEstadoDAO;
import Models.DAO.FormaPagoDAO;
import Models.DAO.PlanPagoDAO;
import Models.DAO.PresupuestoIDDAO;
import Models.DAO.UsuarioDAO;
import Models.DTO.ContratoDetalleDTO;
import Models.DTO.ContratoEstadoDTO;
import Models.DTO.FormaPagoDTO;
import Models.DTO.PlanPagoDTO;
import Models.DTO.PresupuestoIDDTO;
import Models.DTO.UsuarioDTO;
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
@WebServlet(name = "GuardarContratoServlet", urlPatterns = {"/contratos/guardar"})
public class GuardarContratoServlet extends HttpServlet {
    
    private final ContratoDAO contratoDAO = new ContratoDAO();
    private final ContratoEstadoDAO contratoEstadoDAO = new ContratoEstadoDAO();
    private final ContratoDetalleDAO contratoDetalleDAO = new ContratoDetalleDAO();
    private final PresupuestoIDDAO presupuestoIDDAO = new PresupuestoIDDAO();
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private final PlanPagoDAO planPagoDAO = new PlanPagoDAO();
    private final FormaPagoDAO formaPagoDAO = new FormaPagoDAO();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CrearContrato</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CrearContrato at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
            String  FechaInicio = request.getParameter("FechaInicio");
            String FechaTermino = request.getParameter("FechaTermino");
            int Estado = Integer.parseInt(request.getParameter("selectEstados"));
            int Detalle = Integer.parseInt(request.getParameter("selectDetalle"));
            int Presupuesto = Integer.parseInt(request.getParameter("selectPresupuesto"));
            int Abogado = Integer.parseInt(request.getParameter("selectAbogado"));
            int PlanPago = Integer.parseInt(request.getParameter("selectPlan"));
            String AprobadoCliente = request.getParameter("AprobadoCliente");
            String AprobadoAbogado = request.getParameter("AprobadoAbogado");
            String FormaPago = request.getParameter("FormaPago");
            
            ContratoDTO contratoDTO = new ContratoDTO();
            
            
            int fpago=999;
            fpago = Integer.parseInt(FormaPago);
            System.out.println("FechaInicio: " + FechaInicio);
            System.out.println("variable fpago" +fpago);
            int  cliente;
            int abogado;
            if (AprobadoCliente==null) {
                cliente =0;
                
            } else {
                cliente=1;
                
            }
            if (AprobadoAbogado==null) {
                abogado=0;
            } else {
                abogado=1;
            }
            
            java.sql.Date mysqldate=null;
            java.sql.Date mysqldate2=null;
        try {
            java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("FechaInicio"));
            mysqldate = new java.sql.Date(date.getTime());
            System.out.println(mysqldate);
            
            java.util.Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("FechaTermino"));
            mysqldate2 = new java.sql.Date(date.getTime());
            System.out.println(mysqldate2);
        } catch (ParseException ex) {
            Logger.getLogger(GuardarContratoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
            contratoDTO.setFecha_inicio (mysqldate);
            contratoDTO.setFecha_termino(mysqldate2);
            contratoDTO.setId_contrato_estado(Estado);
         //   contratoDTO.setId_detalle_contrato(Detalle);
            contratoDTO.setId_presupuesto(Presupuesto);
            contratoDTO.setId_abogado(Abogado);
            contratoDTO.setId_plan_pago(PlanPago);
            contratoDTO.setId_forma_pago(fpago);
            contratoDTO.setAprobado_cliente(cliente);
            contratoDTO.setAprobado_abogado(abogado);
            int resultadoOperacion = contratoDAO.create(contratoDTO);
            
            if (resultadoOperacion == 0) {
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(1);
                session.setAttribute("success", "Contrato creada correctamente.");
                response.sendRedirect(request.getContextPath() + "/contratos");
                return;
            }
            request.getRequestDispatcher("/modules/contratos/index.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short descript  ion";
    }// </editor-fold>
}
