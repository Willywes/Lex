/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DTO;

import Servlets.Solicitud.SolicitudTipos;
import java.sql.Date;

/**
 *
 * @author claudio
 */
public class SolicitudDTO {
  private int id_solicitud;
  private Date fecha_hora;
  private String descripcion;
  private SolicitudTiposDTO tipoSolicitud;
  private SolicitudEstadoDTO estadoSolicitud;
  private Date creado;
  private Date modificado;
  private UsuarioDTO cliente;
  private UsuarioDTO tecnico;

  public SolicitudDTO() {
  }

  public SolicitudDTO(int id_solicitud, Date fecha_hora, String descripcion, SolicitudTiposDTO tipoSolicitud, SolicitudEstadoDTO estadoSolicitud, Date creado, Date modificado, UsuarioDTO cliente, UsuarioDTO tecnico) {
    this.id_solicitud = id_solicitud;
    this.fecha_hora = fecha_hora;
    this.descripcion = descripcion;
    this.tipoSolicitud = tipoSolicitud;
    this.estadoSolicitud = estadoSolicitud;
    this.creado = creado;
    this.modificado = modificado;
    this.cliente = cliente;
    this.tecnico = tecnico;
  }

  public UsuarioDTO getTecnico() {
    return tecnico;
  }

  public void setTecnico(UsuarioDTO tecnico) {
    this.tecnico = tecnico;
  }

  public int getId_solicitud() {
    return id_solicitud;
  }

  public void setId_solicitud(int id_solicitud) {
    this.id_solicitud = id_solicitud;
  }

  public Date getFecha_hora() {
    return fecha_hora;
  }

  public void setFecha_hora(Date fecha_hora) {
    this.fecha_hora = fecha_hora;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public SolicitudTiposDTO getTipoSolicitud() {
    return tipoSolicitud;
  }

  public void setTipoSolicitud(SolicitudTiposDTO tipoSolicitud) {
    this.tipoSolicitud = tipoSolicitud;
  }

  public SolicitudEstadoDTO getEstadoSolicitud() {
    return estadoSolicitud;
  }

  public void setEstadoSolicitud(SolicitudEstadoDTO estadoSolicitud) {
    this.estadoSolicitud = estadoSolicitud;
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

  public UsuarioDTO getCliente() {
    return cliente;
  }

  public void setCliente(UsuarioDTO cliente) {
    this.cliente = cliente;
  }

  @Override
  public String toString() {
    return "SolicitudDTO{" + "id_solicitud=" + id_solicitud + ", fecha_hora=" + fecha_hora + ", descripcion=" + descripcion + ", tipoSolicitud=" + tipoSolicitud + ", estadoSolicitud=" + estadoSolicitud + ", creado=" + creado + ", modificado=" + modificado + ", cliente=" + cliente + ", tecnico=" + tecnico + '}';
  }
}
