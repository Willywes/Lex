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
public class CitaEstadoDTO {
    private int id_cita_estado;
    private String nombre;

    public CitaEstadoDTO() {
    }

    public CitaEstadoDTO(int id_cita_estado, String nombre) {
        this.id_cita_estado = id_cita_estado;
        this.nombre = nombre;
    }

    public int getId_cita_estado() {
        return id_cita_estado;
    }

    public void setId_cita_estado(int id_cita_estado) {
        this.id_cita_estado = id_cita_estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "CitaEstadoDTO{" + "id_cita_estado=" + id_cita_estado + ", nombre=" + nombre + '}';
    }
    
    
}
