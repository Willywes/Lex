/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DTO;

import java.util.List;

/**
 *
 * @author Funny
 */
public class PresupuestoTransaction {

    private PresupuestoDTO presupuestoDTO;
    private PresupuestoDetalleDTO presupuestoDetalle;
    private PresupuestoEstadoDTO presupuestoEstado;
    private SolicitudDTO solicitud;
    private PlanPagoDTO presupuestoPlanPago;
    private UsuarioDTO usuario;
    private UsuarioDTO tecnico;
    private SolicitudTiposDTO tipoSolicitud;

    public PresupuestoDTO getPresupuestoDTO() {
        return presupuestoDTO;
    }

    public void setPresupuestoDTO(PresupuestoDTO presupuestoDTO) {
        this.presupuestoDTO = presupuestoDTO;
    }

    public PresupuestoDetalleDTO getPresupuestoDetalle() {
        return presupuestoDetalle;
    }

    public void setPresupuestoDetalle(PresupuestoDetalleDTO presupuestoDetalle) {
        this.presupuestoDetalle = presupuestoDetalle;
    }

    public PresupuestoEstadoDTO getPresupuestoEstado() {
        return presupuestoEstado;
    }

    public void setPresupuestoEstado(PresupuestoEstadoDTO presupuestoEstado) {
        this.presupuestoEstado = presupuestoEstado;
    }

    public SolicitudDTO getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SolicitudDTO solicitud) {
        this.solicitud = solicitud;
    }

    public PlanPagoDTO getPresupuestoPlanPago() {
        return presupuestoPlanPago;
    }

    public void setPresupuestoPlanPago(PlanPagoDTO presupuestoPlanPago) {
        this.presupuestoPlanPago = presupuestoPlanPago;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public UsuarioDTO getTecnico() {
        return tecnico;
    }

    public void setTecnico(UsuarioDTO tecnico) {
        this.tecnico = tecnico;
    }

    public SolicitudTiposDTO getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(SolicitudTiposDTO tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    
    

    
    
    
}
