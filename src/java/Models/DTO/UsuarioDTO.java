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
public class UsuarioDTO {

    protected int id;
    protected String rut;
    protected String paterno;
    protected String materno;
    protected String nombres;
    protected Date fNac;
    protected String email;
    protected String clave;
    protected int telefono;
    protected int celular;
    protected String direccion;
    protected boolean activo;
    protected Date creado;
    protected Date modificado;
    protected int id_rol;

    public UsuarioDTO() {
    }

    public UsuarioDTO(int id, String rut, String paterno, String materno, String nombres, Date fNac, String email, String clave, int telefono, int celular, String direccion, boolean activo, Date creado, Date modificado, int id_rol) {
        this.id = id;
        this.rut = rut;
        this.paterno = paterno;
        this.materno = materno;
        this.nombres = nombres;
        this.fNac = fNac;
        this.email = email;
        this.clave = clave;
        this.telefono = telefono;
        this.celular = celular;
        this.direccion = direccion;
        this.activo = activo;
        this.creado = creado;
        this.modificado = modificado;
        this.id_rol = id_rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Date getfNac() {
        return fNac;
    }

    public void setfNac(Date fNac) {
        this.fNac = fNac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "id=" + id + ", rut=" + rut + ", paterno=" + paterno + ", materno=" + materno + ", nombres=" + nombres + ", fNac=" + fNac + ", email=" + email + ", clave=" + clave + ", telefono=" + telefono + ", celular=" + celular + ", direccion=" + direccion + ", activo=" + activo + ", creado=" + creado + ", modificado=" + modificado + ", id_rol=" + id_rol + '}';
    }

    
}
