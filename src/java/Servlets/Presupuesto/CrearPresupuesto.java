/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Presupuesto;

import Models.DAO.PresupuestoDAO;
import Models.DAO.PresupuestoDetalleDAO;
import Models.DAO.SolicitudDAO;
import Models.DAO.SolicitudTiposDAO;
import Models.DTO.PresupuestoDTO;
import Models.DTO.PresupuestoDetalleDTO;
import Models.DTO.SolicitudDTO;
import Models.DTO.SolicitudTiposDTO;
import Models.DAO.PlanPagoDAO;
import Models.DAO.PresupuestoEstadoDAO;
import Models.DAO.SolicitudEstadoDAO;
import Models.DTO.PlanPagoDTO;
import Models.DTO.PresupuestoEstadoDTO;
import Models.DTO.SolicitudEstadoDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.sql.Date;
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
@WebServlet(name = "CrearPresupuesto", urlPatterns = {"/presupuestos/crear"})
public class CrearPresupuesto extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final SolicitudDAO SolicitudTipoDAO = new SolicitudDAO();

    private final PresupuestoDetalleDAO presupuestoDetalle = new PresupuestoDetalleDAO();

    private final PresupuestoDAO presupuesto = new PresupuestoDAO();

    private final PlanPagoDAO planPagoDAO = new PlanPagoDAO();

    private final PresupuestoEstadoDAO PresupuestoEstadoDAO = new PresupuestoEstadoDAO();

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

        String idSolicitud = "";

        try {

            idSolicitud = request.getParameter("idSolicitud");

            request.setAttribute("idSolicitud", idSolicitud);

        } catch (Exception ex) {
            request.setAttribute("idSolicitud", -1);
        }

        List<SolicitudDTO> solicitudes = SolicitudTipoDAO.getAll();
        request.setAttribute("solicitudes", solicitudes);

//        crear el modelo de plan pago para listar en el get 
        List<PlanPagoDTO> planPagos = this.planPagoDAO.getAll();
        request.setAttribute("planPagos", planPagos);

        List<PresupuestoEstadoDTO> solicitudEstado = this.PresupuestoEstadoDAO.getAll();
        request.setAttribute("estadosPresupuestos", solicitudEstado);

//          usar el de estado para listar los estados
        //List<UsuariosDTO> usuarios = this.planPagoDAO.getAll();
        //  request.setAttribute("usuarios", usuarios);
        request.setAttribute("fecha", "");

        request.setAttribute("mensaje", "get");

        request.getRequestDispatcher("/modules/presupuestos/createpresupuesto.jsp").forward(request, response);

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

            int idPlanPago = Integer.parseInt(request.getParameter("plan_pago"));

            int idTecnico = 1; //creo que es 1 siempre

            //de detalle prosupuesto 
            String servicio = request.getParameter("servicio");
            int monto = Integer.parseInt(request.getParameter("monto"));

            PresupuestoDetalleDTO detalle = new PresupuestoDetalleDTO();

            detalle.setId_detalle_presupuesto(20); //nose si el id es auto incrementable  
            detalle.setMonto(monto);
            detalle.setServicio(servicio);

            //resultado = al id de la fila insetada en detalle presupuesto 
            int resultado = this.presupuestoDetalle.create(detalle);

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

                presu.setFecha(sqlDate);
                presu.setId_estado_presupuesto(estado);
                presu.setId_detalle_presupuesto(resultado);
                presu.setCreado(sqlDate); //no si esta fecha es auto 
                presu.setId_solicitud(idSolicitud);
                presu.setId_tecnico(idTecnico);
                presu.setId_plan_pago(idPlanPago);

                int idFilaInsertada = this.presupuesto.create(presu);

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

        request.setAttribute("mensaje", "exito");

        List<SolicitudDTO> solicitudes = SolicitudTipoDAO.getAll();
        request.setAttribute("solicitudes", solicitudes);

//        crear el modelo de plan pago para listar en el get 
        List<PlanPagoDTO> planPagos = this.planPagoDAO.getAll();
        request.setAttribute("planPagos", planPagos);

        List<PresupuestoEstadoDTO> solicitudEstado = this.PresupuestoEstadoDAO.getAll();
        request.setAttribute("estadosPresupuestos", solicitudEstado);

        request.getRequestDispatcher(
                "/modules/presupuestos/createpresupuesto.jsp").forward(request, response);

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
