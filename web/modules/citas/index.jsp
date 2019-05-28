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
                            <a class="btn btn-success" href="citas/crear"> <!--data-toggle="modal" data-target="#modal-create"--><i
                                    class="fa fa-plus"></i> Nueva Cita
                            </a>
                        </div>
                    </div>
                    <div class="box-body">
                        <table id="table" class="table table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th style="width:1%;white-space: nowrap;">Número de Cita</th>
                                    <th style="width:1%;white-space: nowrap;">Fecha y hora</th>
                                 <%--   <th style="width:1%;white-space: nowrap;"> hora</th> --%>
                                    <th style="width:1%;white-space: nowrap;">Número notaria</th>
                                    <th style="width:1%;white-space: nowrap;">Estado cita</th>
                                    <th style="width:1%;white-space: nowrap;">Acciones</th>
                            </thead>
                            <tbody>

                                <c:forEach var="cita" items="${citas}">
                                      
                                    <tr>
                                        <td>${cita.getId_cita()}</td>
                                        <td>${cita.getFecha_hora()} ${cita.getHora()}</td>
                                        <td>${cita.getId_notaria()}</td>
                                        <c:set var="estado" value=""/>
                                        <c:if test="${cita.getId_estado_cita()==1}">
                                            <c:set var="estado" value="Aceptada"/>
                                            </c:if>
                                        <c:if test="${cita.getId_estado_cita()==2}">
                                            <c:set var="estado" value="Denegado"/>
                                            </c:if>
                                        <%--<td>${cita.getId_estado_cita()}</td>--%>
                                        <td>${estado}</td>
                                        <td style="width:1%;white-space: nowrap;">
                                            <%--<form action="citas/editar" method="POST"> --%>
                                            <a href="citas/editar?id=${cita.getId_cita()}">
                                              <button class="btn btn-warning btn-sm" title="Editar"><i class="fa fa-edit"></i></button></a>
                                              
                                              <a href="citas/cambiar?id=${cita.getId_cita()}">
                                              <button class="btn btn-success" title="Cambiar Status"><i class="fa fa-toggle-on"></i></button></a>
                                           
                                              <form action="citas/borrar" method="POST">
                                                <input type="hidden" name="id" value="${cita.getId_cita()}" />
                                                <button class="btn btn-danger btn-sm" title="Eliminar" name="accion" value="Eliminar">
                                                  <i class="fa fa-trash"></i></button>
                                            </form>
                                        </td>
                                    </tr>

                                </c:forEach>
                            </tbody>

                            <tfoot>
                                <tr>
                                    <th>Número de Cita</th>
                                    <th>Fecha y hora</th>
                                    <th>Número notaria</th>
                                    <th>Estado Cita</th>
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



