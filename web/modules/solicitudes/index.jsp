<%@page import="Models.DTO.SolicitudTiposDTO"%>
<%@page import="Models.DAO.SolicitudTiposDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template>
  <jsp:attribute name="styles">
    <link rel="stylesheet" href="/Lex/assets/bootstraptable/dragtable.css">
    <link rel="stylesheet" href="/Lex/assets/bootstraptable/bootstrap-table-reorder-rows.css">
    <link rel="stylesheet" href="/Lex/assets/bootstraptable/bootstrap-table-fixed-columns.css">
    <link rel="stylesheet" href="/Lex/assets/bootstraptable/bootstrap-table.min.css">
  </jsp:attribute>

  <jsp:attribute name="content">
    <div class="row">
      <div id="main-box"class="col-md-12">
        <div class="box box-primary">
          <div class="box-body">
            <table id="table" class="table table-bordered table-hover">
              <thead>
                <tr>
                  <th style="width:1%;white-space: nowrap;">Nº de solicitud</th>
                  <th>Fecha</th>
                  <th>Descripción</th>
                  <th>Tipo de solicitud</th>
                  <th>Estado</th>
                  <th>Fecha de creación</th>
                  <th>Cliente</th>
                  <th>Técnico</th>
              </thead>
              <tbody>
                <c:forEach var="solicitud" items="${solicitudes}">
                  <tr>
                    <td>${solicitud.id_solicitud}</td>
                    <td>${solicitud.fecha_hora}</td>
                    <td>${solicitud.descripcion}</td>
                    <td>${solicitud.tipoSolicitud.nombre}</td>
                    <td>${solicitud.estadoSolicitud.nombre}</td>
                    <td>${solicitud.creado}</td>
                    <td>${solicitud.cliente.rut} | ${solicitud.cliente.nombres} ${solicitud.cliente.paterno}</td>
                    <td>${solicitud.tecnico.rut} | ${solicitud.tecnico.nombres} ${solicitud.tecnico.paterno}</td>
                    <td style="width:1%;white-space: nowrap;">
                                            <%--<form action="citas/editar" method="POST"> --%>
                                            <a href="solicitudes/editar?id=${solicitud.id_solicitud}">
                                              <button class="btn btn-warning btn-sm" title="Editar"><i class="fa fa-edit"></i></button></a>
                                              
                                              <a href="citas/cambiar?id=${solicitud.id_solicitud}">
                                              <button class="btn btn-success" title="Cambiar Status"><i class="fa fa-toggle-on"></i></button></a>
                                           
                                              <form action="solicitudes/borrar" method="POST">
                                                <input type="hidden" name="id" value="${solicitud.id_solicitud}" />
                                                <button class="btn btn-danger btn-sm" title="Eliminar" name="accion" value="Eliminar">
                                                  <i class="fa fa-trash"></i></button>
                                            </form>
                                        </td>
                  </tr>
                </c:forEach>
              </tbody>
              <tfoot>
                <tr>
                  <th style="width:1%;white-space: nowrap;">Nº de solicitud</th>
                  <th>Fecha</th>
                  <th>Descripción</th>
                  <th>Tipo de solicitud</th>
                  <th>Estado</th>
                  <th>Fecha de creación</th>
                  <th>Cliente</th>
                  <th>Técnico</th>
                </tr>
              </tfoot>
            </table>
          </div>
        </div>
      </div>
    </div>
  </jsp:attribute>

  <jsp:attribute name="scripts">
    <!-- DataTables -->
    <script src="/Lex/assets/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="/Lex/assets/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
  </jsp:attribute>
</t:template>

