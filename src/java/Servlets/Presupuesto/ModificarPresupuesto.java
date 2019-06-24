/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Presupuesto;

import Models.DAO.PlanPagoDAO;
import Models.DAO.PresupuestoDAO;
import Models.DAO.PresupuestoDetalleDAO;
import Models.DAO.PresupuestoEstadoDAO;
import Models.DAO.SolicitudDAO;
import Models.DTO.PlanPagoDTO;
import Models.DTO.PresupuestoDTO;
import Models.DTO.PresupuestoDetalleDTO;
import Models.DTO.PresupuestoEstadoDTO;
import Models.DTO.PresupuestoTransaction;
import Models.DTO.SolicitudDTO;
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
 * @author Funny
 */
@WebServlet(name = "ModificarPresupuesto", urlPatterns = {"/presupuestos/modificar"})
public class ModificarPresupuesto extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final SolicitudDAO SolicitudTipoDAO = new SolicitudDAO();

    private final PresupuestoDetalleDAO presupuestoDetalle = new PresupuestoDetalleDAO();

    private final PresupuestoDAO presupuesto = new PresupuestoDAO();

    private final PlanPagoDAO planPagoDAO = new PlanPagoDAO();

    private final PresupuestoEstadoDAO PresupuestoEstadoDAO = new PresupuestoEstadoDAO();

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
            out.println("<title>Servlet ModificarPresupuesto</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModificarPresupuesto at " + request.getContextPath() + "</h1>");
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

        int id_presupuesto = Integer.parseInt(request.getParameter("idPresupuesto"));
        int idSolicitud = Integer.parseInt(request.getParameter("idSolicitud"));

        List<PresupuestoDTO> presupuestos = presupuesto.getAll();

        PresupuestoDTO presupuesto = new PresupuestoDTO();

        for (PresupuestoDTO presupuesto1 : presupuestos) {
            if (presupuesto1.getId_presupuesto() == id_presupuesto) {
                presupuesto = presupuesto1;
                break;
            }
        }

        request.setAttribute("presupuesto", presupuesto);

        List<SolicitudDTO> solicitudes = SolicitudTipoDAO.getAll();
        request.setAttribute("solicitudes", solicitudes);

        SolicitudDTO solicitud = new SolicitudDAO().findById(idSolicitud);
        request.setAttribute("solicitud", solicitud);

//        crear el modelo de plan pago para listar en el get 
        List<PlanPagoDTO> planPagos = this.planPagoDAO.getAll();
        request.setAttribute("planPagos", planPagos);

        List<PresupuestoEstadoDTO> solicitudEstado = this.PresupuestoEstadoDAO.getAll();
        request.setAttribute("estadosPresupuestos", solicitudEstado);

        List<PresupuestoDetalleDTO> detalles = this.presupuestoDetalle.getDetallesByIdPresupuesto(id_presupuesto);

        request.setAttribute("detalles", detalles);
        request.getRequestDispatcher("/modules/presupuestos/editpresupuesto.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");

        boolean exito = true;

        String dateString = "";

        try {

            int idPresupuesto = Integer.parseInt(request.getParameter("idPresupuesto"));

            int estado = Integer.parseInt(request.getParameter("estado"));

            int idPlanPago = Integer.parseInt(request.getParameter("plan_pago"));

            PresupuestoDTO presu = new PresupuestoDTO();

            presu.setId_presupuesto(idPresupuesto);
//                presu.setFecha(sqlDate);
            presu.setId_estado_presupuesto(estado);
            presu.setId_plan_pago(idPlanPago);

            int idFilaInsertada = this.presupuesto.updateParcial(presu);

            //1 puede ser resultado exito ???? 
            if (idFilaInsertada == 0) {

                exito = false;

            }

            int cantidadDetalles = Integer.parseInt(request.getParameter("catidadDetalles"));

            if (cantidadDetalles != 0) {
                int cont = 1;
                for (int i = 0; i < cantidadDetalles; i++) {
                    String servicio = request.getParameter("servicio" + cont);
                    int monto = Integer.parseInt(request.getParameter("monto" + cont));
                    int idDetalle = Integer.parseInt(request.getParameter("detalleService" + cont));
                    PresupuestoDetalleDTO detalle = new PresupuestoDetalleDTO();
                    detalle.setId_detalle_presupuesto(idDetalle);
                    detalle.setMonto(monto);
                    detalle.setServicio(servicio);
                    detalle.setId_presupuesto(idPresupuesto);
                    this.presupuestoDetalle.update(detalle);
                    cont++;
                }
            }

            //agregamos los detalles 
            int cantidadDetalleAgregar = Integer.parseInt(request.getParameter("cantidadDetalleAgregar"));

            if (cantidadDetalleAgregar != 0) {
                int contt = 1;
                for (int i = 0; i < cantidadDetalleAgregar; i++) {
                    String servicio = request.getParameter("servicioAgregar" + contt);
                    int monto = Integer.parseInt(request.getParameter("montoAgregar" + contt));
                    PresupuestoDetalleDTO detalle = new PresupuestoDetalleDTO();
                    detalle.setMonto(monto);
                    detalle.setServicio(servicio);
                    detalle.setId_presupuesto(idPresupuesto);
                    this.presupuestoDetalle.create(detalle);
                    contt++;
                }
            }

//            } else {
//                exito = false;
//            }
        } catch (Exception ex) {
            exito = false;
        }

        List<PresupuestoTransaction> presupuestos = presupuesto.getAllPresupuestoDetalle();
        request.setAttribute("presupuestos", presupuestos);
        request.setAttribute("mensaje", "get");
        request.getRequestDispatcher("/modules/presupuestos/index.jsp").forward(request, response);

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
