/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DTO;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author claudio
 */
public class CitaDTO {
    int id_cita;
    Date fecha_hora; 
    int id_notaria;
    int id_estado_cita;
    Time hora;

    public CitaDTO() {
    }

    public CitaDTO(int id_cita, Date fecha_hora, int id_notaria, int id_estado_cita,Time hora) {
        this.id_cita = id_cita;
        this.fecha_hora = fecha_hora;
        this.id_notaria = id_notaria;
        this.id_estado_cita = id_estado_cita;
        this.hora=hora;
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public int getId_notaria() {
        return id_notaria;
    }

    public void setId_notaria(int id_notaria) {
        this.id_notaria = id_notaria;
    }

    public int getId_estado_cita() {
        return id_estado_cita;
    }

    public void setId_estado_cita(int id_estado_cita) {
        this.id_estado_cita = id_estado_cita;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "CitaDTO{" + "id_cita=" + id_cita + ", fecha_hora=" + fecha_hora + ", id_notaria=" + id_notaria + ", id_estado_notaria=" + id_estado_cita + '}';
    }
    
}
