/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DTO;

/**
 *
 * @author willywes
 */
public class RolDTO {

    private int id;
    private String nombre;
    private boolean estado;
    
    public RolDTO(int id, String nombre, boolean estado) {
        this.id     = id;
        this.nombre = nombre;
        this.estado = estado;
    }
    

    public RolDTO(String nombre, boolean estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "RolDTO{" + "id=" + id + ", nombre=" + nombre + ", estado=" + estado + '}';
    }
    
    
    
    
}
