/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DTO;

/**
 *
 * @author Funny
 */
public class PresupuestoDetalleDTO {

    protected int id_detalle_presupuesto;
    protected String servicio;
    protected int monto;
    protected int id_presupuesto;

    public PresupuestoDetalleDTO() {
    }

    public PresupuestoDetalleDTO(int id_detalle_presupuesto, String servicio, int monto, int id_presupuesto) {
        this.id_detalle_presupuesto = id_detalle_presupuesto;
        this.servicio = servicio;
        this.monto = monto;
        this.id_presupuesto = id_presupuesto;
    }

    public int getId_detalle_presupuesto() {
        return id_detalle_presupuesto;
    }

    public void setId_detalle_presupuesto(int id_detalle_presupuesto) {
        this.id_detalle_presupuesto = id_detalle_presupuesto;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getId_presupuesto() {
        return id_presupuesto;
    }

    public void setId_presupuesto(int id_presupuesto) {
        this.id_presupuesto = id_presupuesto;
    }

    @Override
    public String toString() {
        return "PresupuestoDetalleDTO{" + "id_detalle_presupuesto=" + id_detalle_presupuesto + ", servicio=" + servicio + ", monto=" + monto + "id_presupuesto=" + id_presupuesto + '}';
    }

}
