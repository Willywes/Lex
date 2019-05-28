/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DTO;

import java.sql.Date;

/**
 *
 * @author TECMAR
 */
public class PresupuestoIDDTO {
     private int idPresupuesto;
     private Date fecha;
     private int idEstado;
     private int idDetalle;
     private Date creado;
     private Date modificado;
     private int idSolicitud;
     private int idTecnico;
     private int idPlanPago;

    public PresupuestoIDDTO() {
    }

    public PresupuestoIDDTO(int idPresupuesto, Date fecha, int idEstado, int idDetalle, Date creado, Date modificado, int idSolicitud, int idTecnico, int idPlanPago) {
        this.idPresupuesto = idPresupuesto;
        this.fecha = fecha;
        this.idEstado = idEstado;
        this.idDetalle = idDetalle;
        this.creado = creado;
        this.modificado = modificado;
        this.idSolicitud = idSolicitud;
        this.idTecnico = idTecnico;
        this.idPlanPago = idPlanPago;
    }

    public int getIdPlanPago() {
        return idPlanPago;
    }

    public void setIdPlanPago(int idPlanPago) {
        this.idPlanPago = idPlanPago;
    }

    public int getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(int idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public Date getModificado() {
        return modificado;
    }

    public void setModificado(Date modificado) {
        this.modificado = modificado;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    @Override
    public String toString() {
        return "PresupuestoIDDTO{" + "idPresupuesto=" + idPresupuesto + ", fecha=" + fecha + ", idEstado=" + idEstado + ", idDetalle=" + idDetalle + ", creado=" + creado + ", modificado=" + modificado + ", idSolicitud=" + idSolicitud + ", idTecnico=" + idTecnico + ", idPlanPago=" + idPlanPago + '}';
    }
     
     

    
    
    
}
