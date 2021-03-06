/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DTO;

/**
 *
 * @author TECMAR
 */
public class ContratoDetalleDTO {
    private int id_detalle_contrato;
    private String servicio;
    private int monto;
    private int id_contrato;

    public ContratoDetalleDTO() {
    }

    public ContratoDetalleDTO(int id_detalle_contrato, String servicio, int monto, int id_contrato) {
        this.id_detalle_contrato = id_detalle_contrato;
        this.servicio = servicio;
        this.monto = monto;
        this.id_contrato = id_contrato;
    }

    public int getId_detalle_contrato() {
        return id_detalle_contrato;
    }

    public void setId_detalle_contrato(int id_detalle_contrato) {
        this.id_detalle_contrato = id_detalle_contrato;
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

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    @Override
    public String toString() {
        return "ContratoDetalleDTO{" + "id_detalle_contrato=" + id_detalle_contrato + ", servicio=" + servicio + ", monto=" + monto + ", id_contrato=" + id_contrato + '}';
    }

   
    
}
