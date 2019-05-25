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
                  <th style="width:1%;white-space: nowrap;">Número de tipo</th>
                  <th>Nombre de tipo de solicitud</th>
                  <th style="width:1%;white-space: nowrap;">Acciones</th>
              </thead>
              <tbody>
                <c:forEach var="solicitud" items="${solicitudes}">
                  <tr>
                    <td>${solicitud.id}</td>
                    <td>${solicitud.nombre}</td>
                    <td style="width:1%;white-space: nowrap;">
                      <button class="btn btn-warning btn-sm" title="Editar"><i class="fa fa-edit"></i></button>
                      <button class="btn btn-danger btn-sm" title="Eliminar"><i class="fa fa-trash"></i></button>
                    </td>
                  </tr>
                </c:forEach>


              </tbody>

              <tfoot>
                <tr>
                  <th>Número de tipo</th>
                  <th>Nombre de tipo de solicitud</th>
                  <th>Acciones</th>
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

