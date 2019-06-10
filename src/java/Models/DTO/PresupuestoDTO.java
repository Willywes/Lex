/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DTO;

import java.sql.Date;

/**
 *
 * @author Funny
 */
public class PresupuestoDTO {

    protected int id_presupuesto;
    protected Date fecha;
    protected int id_estado_presupuesto;
    protected int id_detalle_presupuesto;
    protected Date creado;
    protected Date modificado;
    protected int id_solicitud;
    protected int id_tecnico;
    protected int id_plan_pago;

    public PresupuestoDTO() {
    }

    public PresupuestoDTO(int id_presupuesto, Date fecha, int id_estado_presupuesto, int id_detalle_presupuesto, Date creado, Date modificado, int id_solicitud, int id_tecnico, int id_plan_pago) {
        this.id_presupuesto = id_presupuesto;
        this.fecha = fecha;
        this.id_estado_presupuesto = id_estado_presupuesto;
        this.id_detalle_presupuesto = id_detalle_presupuesto;
        this.creado = creado;
        this.modificado = modificado;
        this.id_solicitud = id_solicitud;
        this.id_tecnico = id_tecnico;
        this.id_plan_pago = id_plan_pago;
    }

    public int getId_presupuesto() {
        return id_presupuesto;
    }

    public void setId_presupuesto(int id_presupuesto) {
        this.id_presupuesto = id_presupuesto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId_estado_presupuesto() {
        return id_estado_presupuesto;
    }

    public void setId_estado_presupuesto(int id_estado_presupuesto) {
        this.id_estado_presupuesto = id_estado_presupuesto;
    }

    public int getId_detalle_presupuesto() {
        return id_detalle_presupuesto;
    }

    public void setId_detalle_presupuesto(int id_detalle_presupuesto) {
        this.id_detalle_presupuesto = id_detalle_presupuesto;
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

    public int getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(int id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public int getId_tecnico() {
        return id_tecnico;
    }

    public void setId_tecnico(int id_tecnico) {
        this.id_tecnico = id_tecnico;
    }

    public int getId_plan_pago() {
        return id_plan_pago;
    }

    public void setId_plan_pago(int id_plan_pago) {
        this.id_plan_pago = id_plan_pago;
    }

    @Override
    public String toString() {
        return "PresupuestoDTO{" + "id_presupuesto=" + id_presupuesto + ", fecha=" + fecha + ", id_estado_presupuesto=" + id_estado_presupuesto + ", id_detalle_presupuesto=" + id_detalle_presupuesto + ", creado=" + creado + ", modificado=" + modificado + ", id_solicitud=" + id_solicitud + ", id_tecnico=" + id_tecnico + ", id_plan_pago=" + id_plan_pago + '}';
    }

}
