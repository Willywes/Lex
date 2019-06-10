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
public class PresupuestoEstadoDTO {

    protected int id_estado_presupuesto;
    protected String nombre;

    public PresupuestoEstadoDTO() {
    }

    public PresupuestoEstadoDTO(int id_estado_presupuesto, String nombre) {
        this.id_estado_presupuesto = id_estado_presupuesto;
        this.nombre = nombre;
    }

    public int getId_estado_presupuesto() {
        return id_estado_presupuesto;
    }

    public void setId_estado_presupuesto(int id_estado_presupuesto) {
        this.id_estado_presupuesto = id_estado_presupuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "PresupuestoEstadoDTO{" + "id_estado_presupuesto=" + id_estado_presupuesto + ", nombre=" + nombre + '}';
    }

}
