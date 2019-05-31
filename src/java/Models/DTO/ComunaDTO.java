/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DTO;

/**
 *
 * @author willywes
 */
public class ComunaDTO {
    
    private int id;
    private String nombre;
    private int idProvincia;
    
    public ComunaDTO(){
    }

    public ComunaDTO(int id, String nombre, int idProvincia) {
        this.id = id;
        this.nombre = nombre;
        this.idProvincia = idProvincia;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "ComunaDTO{" + "id=" + id + ", nombre=" + nombre + ", idProvincia=" + idProvincia + '}';
    }
    
    
    
    
}
