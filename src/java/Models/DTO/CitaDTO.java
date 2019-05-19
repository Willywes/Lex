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
public class CitaDTO {
    int id_cita;
    String fecha_hora;
    int id_notaria;
    int id_estado_notaria;

    public CitaDTO() {
    }

    public CitaDTO(int id_cita, String fecha_hora, int id_notaria, int id_estado_notaria) {
        this.id_cita = id_cita;
        this.fecha_hora = fecha_hora;
        this.id_notaria = id_notaria;
        this.id_estado_notaria = id_estado_notaria;
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public int getId_notaria() {
        return id_notaria;
    }

    public void setId_notaria(int id_notaria) {
        this.id_notaria = id_notaria;
    }

    public int getId_estado_notaria() {
        return id_estado_notaria;
    }

    public void setId_estado_notaria(int id_estado_notaria) {
        this.id_estado_notaria = id_estado_notaria;
    }

    @Override
    public String toString() {
        return "CitaDTO{" + "id_cita=" + id_cita + ", fecha_hora=" + fecha_hora + ", id_notaria=" + id_notaria + ", id_estado_notaria=" + id_estado_notaria + '}';
    }
    
}
