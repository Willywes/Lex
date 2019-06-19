/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DTO;

import java.sql.Date;

/**
 *
 * @author willywes
 */
public class NotariaDTO {
    
    private int id;
    private String nombre;
    private String razonSocial;
    private String direccion;
    private int telefono;
    private int idComuna;
    private Date creado;
    private Date modificado;
    private String comuna;
    private String provincia;
    private String Region;

    public NotariaDTO() {
        
    }

    public NotariaDTO(int id, String nombre, String razonSocial, String direccion, int telefono, int idComuna, Date creado, Date modificado) {
        this.id = id;
        this.nombre = nombre;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.idComuna = idComuna;
        this.creado = creado;
        this.modificado = modificado;
    }

    public NotariaDTO(int id, String nombre, String razonSocial, String direccion, int telefono, int idComuna, Date creado, Date modificado, String comuna, String provincia, String Region) {
        this.id = id;
        this.nombre = nombre;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.idComuna = idComuna;
        this.creado = creado;
        this.modificado = modificado;
        this.comuna = comuna;
        this.provincia = provincia;
        this.Region = Region;
    }

    public Date getModificado() {
        return modificado;
    }

    public void setModificado(Date modificado) {
        this.modificado = modificado;
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

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(int idComuna) {
        this.idComuna = idComuna;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    @Override
    public String toString() {
        return "NotariaDTO{" + "id=" + id + ", nombre=" + nombre + ", razonSocial=" + razonSocial + ", direccion=" + direccion + ", telefono=" + telefono + ", idComuna=" + idComuna + ", creado=" + creado + ", modificado=" + modificado + ", comuna=" + comuna + ", provincia=" + provincia + ", Region=" + Region + '}';
    }
    
}
