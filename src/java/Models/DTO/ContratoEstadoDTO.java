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
public class ContratoEstadoDTO {
    private int id_contrato_estado;
    private String nombre;

    public ContratoEstadoDTO() {
    }

    public ContratoEstadoDTO(int id_contrato_estado, String nombre) {
        this.id_contrato_estado = id_contrato_estado;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_contrato_estado() {
        return id_contrato_estado;
    }

    public void setId_contrato_estado(int id_contrato_estado) {
        this.id_contrato_estado = id_contrato_estado;
    }

    @Override
    public String toString() {
        return "ContratoEstadoDTO{" + "id_contrato_estado=" + id_contrato_estado + ", nombre=" + nombre + '}';
    }
    
   
}
