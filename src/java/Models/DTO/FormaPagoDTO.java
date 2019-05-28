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
public class FormaPagoDTO {
    private int id_forma_pago;
    private String nombre;
    private int cantidad_cuotas;

    public FormaPagoDTO() {
    }

    public FormaPagoDTO(int id_forma_pago, String nombre, int cantidad_cuotas) {
        this.id_forma_pago = id_forma_pago;
        this.nombre = nombre;
        this.cantidad_cuotas = cantidad_cuotas;
    }

    public int getCantidad_cuotas() {
        return cantidad_cuotas;
    }

    public void setCantidad_cuotas(int cantidad_cuotas) {
        this.cantidad_cuotas = cantidad_cuotas;
    }

    public int getId_forma_pago() {
        return id_forma_pago;
    }

    public void setId_forma_pago(int id_forma_pago) {
        this.id_forma_pago = id_forma_pago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "FormaPagoDTO{" + "id_forma_pago=" + id_forma_pago + ", nombre=" + nombre + ", cantidad_cuotas=" + cantidad_cuotas + '}';
    }
    
    
}
