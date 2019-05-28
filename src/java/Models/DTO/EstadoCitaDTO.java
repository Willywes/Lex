/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DTO;

/**
 *
 * @author claudio
 */
public class EstadoCitaDTO {
    int id_estado_cita;
    String nombre;

    public EstadoCitaDTO() {
    }

    public EstadoCitaDTO(int id_estado_cita, String nombre) {
        this.id_estado_cita = id_estado_cita;
        this.nombre = nombre;
    }

    public int getId_estado_cita() {
        return id_estado_cita;
    }

    public void setId_estado_cita(int id_estado_cita) {
        this.id_estado_cita = id_estado_cita;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "EstadoCitaDTO{" + "id_estado_cita=" + id_estado_cita + ", nombre=" + nombre + '}';
    }
    
}
