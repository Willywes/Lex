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
  private int id_estado_solicitud;
  private SolicitudTiposDTO tipoSolicitud;
  private int id_tipo_solicitud;
  private SolicitudEstadoDTO estadoSolicitud;
  private Date creado;
  private Date modificado;
  private int id_cliente;
  private UsuarioDTO cliente;
  private int id_tecnico;
  private UsuarioDTO tecnico;

  public SolicitudDTO() {
  }

    public SolicitudDTO(int id_solicitud, Date fecha_hora, String descripcion, int id_estado_solicitud, SolicitudTiposDTO tipoSolicitud, int id_tipo_solicitud, SolicitudEstadoDTO estadoSolicitud, Date creado, Date modificado, int id_cliente, UsuarioDTO cliente, int id_tecnico, UsuarioDTO tecnico) {
        this.id_solicitud = id_solicitud;
        this.fecha_hora = fecha_hora;
        this.descripcion = descripcion;
        this.id_estado_solicitud = id_estado_solicitud;
        this.tipoSolicitud = tipoSolicitud;
        this.id_tipo_solicitud = id_tipo_solicitud;
        this.estadoSolicitud = estadoSolicitud;
        this.creado = creado;
        this.modificado = modificado;
        this.id_cliente = id_cliente;
        this.cliente = cliente;
        this.id_tecnico = id_tecnico;
        this.tecnico = tecnico;
    }

    public int getId_estado_solicitud() {
        return id_estado_solicitud;
    }

    public void setId_estado_solicitud(int id_estado_solicitud) {
        this.id_estado_solicitud = id_estado_solicitud;
    }

    public int getId_tipo_solicitud() {
        return id_tipo_solicitud;
    }

    public void setId_tipo_solicitud(int id_tipo_solicitud) {
        this.id_tipo_solicitud = id_tipo_solicitud;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_tecnico() {
        return id_tecnico;
    }

    public void setId_tecnico(int id_tecnico) {
        this.id_tecnico = id_tecnico;
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
        return "SolicitudDTO{" + "id_solicitud=" + id_solicitud + ", fecha_hora=" + fecha_hora + ", descripcion=" + descripcion + ", id_estado_solicitud=" + id_estado_solicitud + ", tipoSolicitud=" + tipoSolicitud + ", id_tipo_solicitud=" + id_tipo_solicitud + ", estadoSolicitud=" + estadoSolicitud + ", creado=" + creado + ", modificado=" + modificado + ", id_cliente=" + id_cliente + ", cliente=" + cliente + ", id_tecnico=" + id_tecnico + ", tecnico=" + tecnico + '}';
    }


}
