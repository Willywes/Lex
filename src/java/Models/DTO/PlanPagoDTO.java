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
public class PlanPagoDTO {
    private int id_Plan_Pago;
    private String nombre;
    

    public PlanPagoDTO() {
    }

    public PlanPagoDTO(int id_Plan_Pago, String nombre) {
        this.id_Plan_Pago = id_Plan_Pago;
        this.nombre = nombre;
        
    }

    

    public int getId_Plan_Pago() {
        return id_Plan_Pago;
    }

    public void setId_Plan_Pago(int id_Plan_Pago) {
        this.id_Plan_Pago = id_Plan_Pago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "PlanPagoDTO{" + "id_Plan_Pago=" + id_Plan_Pago + ", nombre=" + nombre + '}';
    }

}
