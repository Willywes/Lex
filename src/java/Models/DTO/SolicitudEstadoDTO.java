/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DTO;

/**
 *
 * @author luisponce
 */
public class SolicitudEstadoDTO {
  private int id_estado_solicitud;
  private String nombre;

  public SolicitudEstadoDTO() {
  }

  public SolicitudEstadoDTO(int id_estado_solicitud, String nombre) {
    this.id_estado_solicitud = id_estado_solicitud;
    this.nombre = nombre;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getId_estado_solicitud() {
    return id_estado_solicitud;
  }

  public void setId_estado_solicitud(int id_estado_solicitud) {
    this.id_estado_solicitud = id_estado_solicitud;
  }

  @Override
  public String toString() {
    return "SolicitudEstadoDTO{" + "id_estado_solicitud=" + id_estado_solicitud + ", nombre=" + nombre + '}';
  }
}
