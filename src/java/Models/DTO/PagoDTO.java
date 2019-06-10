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
public class PagoDTO {

    protected int id_pago;
    protected Date fecha_hora;
    protected int monto;
    protected Date creado;
    protected Date modificado;
    protected int id_contrato;

    public PagoDTO() {
    }

    public PagoDTO(int id_pago, Date fecha_hora, int monto, Date creado, Date modificado, int id_contrato) {
        this.id_pago = id_pago;
        this.fecha_hora = fecha_hora;
        this.monto = monto;
        this.creado = creado;
        this.modificado = modificado;
        this.id_contrato = id_contrato;
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
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

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

   
}
