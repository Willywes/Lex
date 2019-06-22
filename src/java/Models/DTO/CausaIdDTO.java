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
public class CausaIdDTO {
    private int id_causa;
    private String rol;
    private Date fecha;
    private String caratula;
    private int id_tribunal;

    public CausaIdDTO() {
    }

    public CausaIdDTO(int id_causa, String rol, Date fecha, String caratula, int id_tribunal) {
        this.id_causa = id_causa;
        this.rol = rol;
        this.fecha = fecha;
        this.caratula = caratula;
        this.id_tribunal = id_tribunal;
    }

    public int getId_tribunal() {
        return id_tribunal;
    }

    public void setId_tribunal(int id_tribunal) {
        this.id_tribunal = id_tribunal;
    }

    public int getId_causa() {
        return id_causa;
    }

    public void setId_causa(int id_causa) {
        this.id_causa = id_causa;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCaratula() {
        return caratula;
    }

    public void setCaratula(String caratula) {
        this.caratula = caratula;
    }

    @Override
    public String toString() {
        return "CausaIdDTO{" + "id_causa=" + id_causa + ", rol=" + rol + ", fecha=" + fecha + ", caratula=" + caratula + ", id_tribunal=" + id_tribunal + '}';
    }
    
    
}
