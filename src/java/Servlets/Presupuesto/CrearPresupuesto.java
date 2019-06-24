/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Presupuesto;

import Models.DAO.PresupuestoDAO;
import Models.DAO.PresupuestoDetalleDAO;
import Models.DAO.SolicitudDAO;
import Models.DTO.PresupuestoDTO;
import Models.DTO.PresupuestoDetalleDTO;
import Models.DTO.SolicitudDTO;
import Models.DAO.PlanPagoDAO;
import Models.DAO.PresupuestoEstadoDAO;
import Models.DTO.PlanPagoDTO;
import Models.DTO.PresupuestoEstadoDTO;
import java.io.IOException;
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
            SolicitudDTO solicitud = new SolicitudDAO().findById(Integer.parseInt(idSolicitud));
            request.setAttribute("solicitud", solicitud);
        } catch (Exception ex) {
            request.setAttribute("idSolicitud", -1);
            request.setAttribute("error", "Solicitud no encontrada");
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

//            String fecha = request.getParameter("fecha");
//            String horaCita = "0";
//            String minutosCita = "00";
//            String fechaHora = fecha + " " + horaCita + ":" + minutosCita + ":00";
            int estado = Integer.parseInt(request.getParameter("estado"));
            //creado en presupuesto creo es automatico 
            //modificado null 
            int idSolicitud = Integer.parseInt(request.getParameter("idSolicitud"));

            int idPlanPago = Integer.parseInt(request.getParameter("plan_pago"));

            int idTecnico = Integer.parseInt(request.getParameter("idTecnico"));

            //de detalle presupuesto 
//            String servicio = request.getParameter("servicio");
//            int monto = Integer.parseInt(request.getParameter("monto"));
//            int id_presupuesto = Integer.parseInt(request.getParameter("id_presupuesto"));
//            PresupuestoDetalleDTO detalle = new PresupuestoDetalleDTO();
//
//            detalle.setId_detalle_presupuesto(20); //nose si el id es auto incrementable  
//            detalle.setMonto(monto);
//            detalle.setServicio(servicio);
//            detalle.setId_presupuesto(id_presupuesto);
            //resultado = al id de la fila insetada en detalle presupuesto 
//            int resultado = this.presupuestoDetalle.create(detalle);
            //creo que 1 es exito en ingresar un detalle o es el id del detalle ?? 
//            if (resultado != 0) {
//                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//                java.util.Date date = sdf1.parse(fechaHora);
//                java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
//                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//                java.util.Date dateCita = formatter.parse(fechaHora);
//                java.sql.Date sqlDate = new java.sql.Date(dateCita.getTime());
//                System.out.println(sqlDate.toString());
            PresupuestoDTO presu = new PresupuestoDTO();

            presu.setId_estado_presupuesto(estado);
            presu.setId_solicitud(idSolicitud);
            presu.setId_tecnico(idTecnico);
            presu.setId_plan_pago(idPlanPago);

            int idFilaInsertada = this.presupuesto.create(presu);

            if (idFilaInsertada != 0) {

                //agregamos los detalles 
                int cantidadDetalles = Integer.parseInt(request.getParameter("cantidadDetalle"));

                if (cantidadDetalles != 0) {
                    int cont = 1;
                    for (int i = 0; i < cantidadDetalles; i++) {
                        String servicio = request.getParameter("servicio" + cont);
                        int monto = Integer.parseInt(request.getParameter("monto" + cont));
                        PresupuestoDetalleDTO detalle = new PresupuestoDetalleDTO();
                        detalle.setMonto(monto);
                        detalle.setServicio(servicio);
                        detalle.setId_presupuesto(idFilaInsertada);
                        this.presupuestoDetalle.create(detalle);
                        cont++;
                    }
                }

            }

            //1 puede ser resultado exito ???? 
            if (idFilaInsertada == 0) {
                exito = false;
            }

            SolicitudDTO solicitud = new SolicitudDAO().findById(idSolicitud);
            request.setAttribute("solicitud", solicitud);

//            } else {
//                exito = false;
//            }
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
