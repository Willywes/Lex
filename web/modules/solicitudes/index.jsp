<%-- 
    Document   : cita index
    Created on : 15-05-2019, 22:34:03
    Author     : claudio
--%>

<%@page import="Models.DTO.CitaDTO"%>
<%@page import="Models.DAO.CitaDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template>

    <jsp:attribute name="title">
        Gestión de Notarias
    </jsp:attribute>
    <jsp:attribute name="subtitle">
        Todas las Solicitudes
    </jsp:attribute>


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
                    <div class="box-header with-border">
                        <div  class="btn-group">
                            <a class="btn btn-success" href="solicitudes/crear"> <!--data-toggle="modal" data-target="#modal-create"--><i
                                    class="fa fa-plus"></i> Nueva Solicitud
                            </a>
                        </div>
                    </div>
                    <div class="box-body">
                        <table id="table" class="table table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th style="width:1%;white-space: nowrap;">Nº Solicitud</th>
                                    <th style="width:1%;white-space: nowrap;">Fecha</th>
                                    <th style="width:15%;white-space: nowrap;">Descripcion</th>
                                    <th style="width:1%;white-space: nowrap;">Tipo</th>
                                    <th style="width:1%;white-space: nowrap;">Estado</th>
                                    <th style="width:1%;white-space: nowrap;">Cliente</th>
                                    <th style="width:1%;white-space: nowrap;">técnico</th>
                                    <th style="width:1%;white-space: nowrap;">Acciones</th>
                            </thead>
                            <tbody>

                                <c:forEach var="solicitudes" items="${solicitudes}">
                                   <tr>
                                        <td>${solicitudes.getId_solicitud()}</td>
                                        <td>${solicitudes.getFecha_hora()}</td>
                                        <td>
                                            
                                          nada aca
                                        
                                        </td>
                                        <td>
                                            <%--         <c:choose>
                                                <c:when test="${solicitudes.getEstadoSolicitud() == 1}">
                                                    <span class="badge bg-green">Activado</span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="badge bg-red">Desactivado</span>
                                                </c:otherwise>
                                            </c:choose>  --%>
                                            ${solicitudes.getEstadoSolicitud()}
                                        </td>
                                        <td>${solicitudes.getEstadoSolicitud()}</td>
                                        <td>${solicitudes.getTecnico()}</td>
                                        <td>${solicitudes.getCliente()}</td>

                                        <td style="white-space: nowrap; width: 1%; vertical-align: middle; ">
                                            <div style="width: max-content; float: left;">
                                                <div style="width: max-content; float: left;">
                                                    <%--<form action="citas/editar" method="POST"> --%>
                                                    <a href="citas/editar?id=${solicitudes.getId_solicitud()}">
                                                        <button class="btn btn-warning btn-sm" title="Editar"><i class="fa fa-edit"></i></button></a>    
                                                </div>
                                                <div style="width: max-content; float: left; margin-left: 5px">
                                                    <form action="citas/borrar" method="POST">
                                                        <input type="hidden" name="id" value="${solicitudes.getId_solicitud()}" />
                                                        <button class="btn btn-danger btn-sm" title="Eliminar" name="accion" value="Eliminar">
                                                            <i class="fa fa-trash"></i></button>
                                                    </form>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>

                                </c:forEach>
                            </tbody>

                            <tfoot>
                                <tr>
                                    <th>Nº Solicitud</th>
                                    <th>Fecha</th>
                                    <th>Descripcion</th>
                                    <th>Tipo</th>
                                    <th>Estado</th>
                                    <th>Cliente</th>
                                    <th>Técnico</th>
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



