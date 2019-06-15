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
import Models.DAO.SolicitudEstadoDAO;
import Models.DTO.PlanPagoDTO;
import Models.DTO.PresupuestoDTO;
import Models.DTO.PresupuestoDetalleDTO;
import Models.DTO.PresupuestoEstadoDTO;
import Models.DTO.PresupuestoTransaction;
import Models.DTO.SolicitudDTO;
import Models.DTO.SolicitudEstadoDTO;
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

//        crear el modelo de plan pago para listar en el get 
        List<PlanPagoDTO> planPagos = this.planPagoDAO.getAll();
        request.setAttribute("planPagos", planPagos);

        List<PresupuestoEstadoDTO> solicitudEstado = this.PresupuestoEstadoDAO.getAll();
        request.setAttribute("estadosSolicitud", solicitudEstado);

        List<PresupuestoDetalleDTO> detalles = this.presupuestoDetalle.getAll();

        PresupuestoDetalleDTO detalle = new PresupuestoDetalleDTO();

        for (PresupuestoDetalleDTO presupuestoDetalleDTO : detalles) {
            if (presupuestoDetalleDTO.getId_detalle_presupuesto() == presupuesto.getId_detalle_presupuesto()) {
                detalle = presupuestoDetalleDTO;
            }
        }

        request.setAttribute("detalle", detalle);
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

            String fecha = request.getParameter("fecha");
            String horaCita = "0";
            String minutosCita = "00";
            String fechaHora = fecha + " " + horaCita + ":" + minutosCita + ":00";

            int estado = Integer.parseInt(request.getParameter("estado"));
            //creado en presupuesto creo es automatico 
            //modificado null 
            int idSolicitud = Integer.parseInt(request.getParameter("solicitud"));

            int idPresupuesto = Integer.parseInt(request.getParameter("idPresupuesto"));

            int idPlanPago = Integer.parseInt(request.getParameter("pago"));

            int idTecnico = 1; //creo que es 1 siempre

            //de detalle prosupuesto 
            String servicio = request.getParameter("servicio");

            int monto = Integer.parseInt(request.getParameter("monto"));

            int idDetallePresupuesto = Integer.parseInt(request.getParameter("idDetalle"));

            PresupuestoDetalleDTO detalle = new PresupuestoDetalleDTO();

            detalle.setId_detalle_presupuesto(idDetallePresupuesto); //nose si el id es auto incrementable  
            detalle.setMonto(monto);
            detalle.setServicio(servicio);

            //resultado = al id de la fila insetada en detalle presupuesto 
            int resultado = this.presupuestoDetalle.update(detalle);

            //creo que 1 es exito en ingresar un detalle o es el id del detalle ??
            if (resultado != 0) {

                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                java.util.Date date = sdf1.parse(fechaHora);
                java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());

                System.out.println(sqlStartDate.toString());

                System.out.println(fechaHora);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                java.util.Date dateCita = formatter.parse(fechaHora);
                java.sql.Date sqlDate = new java.sql.Date(dateCita.getTime());
                System.out.println(sqlDate.toString());

                PresupuestoDTO presu = new PresupuestoDTO();

                presu.setId_presupuesto(idPresupuesto);
                presu.setFecha(sqlDate);
                presu.setId_estado_presupuesto(estado);
                presu.setId_detalle_presupuesto(idDetallePresupuesto);
                presu.setId_solicitud(idSolicitud);
                presu.setId_tecnico(idTecnico);
                presu.setId_plan_pago(idPlanPago);

                int idFilaInsertada = this.presupuesto.update(presu);

                //1 puede ser resultado exito ???? 
                if (idFilaInsertada == 0) {

                    exito = false;

                }

            } else {
                exito = false;
            }

        } catch (Exception ex) {
            exito = false;
        }

        List<PresupuestoTransaction> presupuestos = presupuesto.getAllTransaccion();
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
