<%-- 
    Document   : listaestado
    Created on : 15-06-2019, 14:39:04
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
        Gestión de Citas
    </jsp:attribute>
    <jsp:attribute name="subtitle">
        Buscador
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

                    </div>

                    <form action="/Lex/citas/buscarestado" method="POST">
                        <div class="form-group col-md-6">
                            <label for="Detalle">Estado</label>

                            <select id="selectCliente" name="selectCliente" class="form-control">
                                <option selected>Seleccione...</option>                                                
                                <c:forEach var="estados" items="${estados}">
                                    <option value="${estados.getId_cita_estado()}">${estados.nombre} </option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-6">
                            <input type="submit" name="accion" value="Buscar" class="btn btn-primary">
                        </div>
                    </form>
                    <div class="box-body">
                        <table id="table" class="table table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th style="width:1%;white-space: nowrap;">Nº Solicitud</th>
                                    <th style="width:1%;white-space: nowrap;">Fecha</th>
                                    <th style="width:15%;white-space: nowrap;">Notaria</th>
                                    <th style="width:1%;white-space: nowrap;">Tipo</th>
                                    <th style="width:1%;white-space: nowrap;">Estado</th>
                                    <th style="width:1%;white-space: nowrap;">Cliente</th>
                                    <th style="width:1%;white-space: nowrap;">técnico</th>
                                    <th style="width:1%;white-space: nowrap;">Acciones</th>
                            </thead>
                            <tbody>

                                <c:forEach var="citas" items="${citas}"> 
                                    <tr>
                                        <td>${citas.getId_cita()}</td>
                                        <td>${citas.getFecha_hora()}</td>
                                        <td>${citas.getNotaria().getNombre()}</td>          
                                        <td>${citas.getCitaEstado().getNombre()}</td>
                                       
                                        

                                        <td style="white-space: nowrap; width: 1%; vertical-align: middle; ">
                                            <div style="width: max-content; float: left;">
                                                <div style="width: max-content; float: left;">
                                                    <%--<form action="citas/editar" method="POST"> --%>
                                                    <a href="actualizar?id=${citas.getId_cita()}">
                                                        <button class="btn btn-warning btn-sm" title="Editar"><i class="fa fa-edit"></i></button></a> 
                                                    <input type="hidden" name="id" value="${citas.getId_cita()}" />
                                                </div>
                                                <div style="width: max-content; float: left;margin-left: 5px;">
                                                    <form action="../presupuestos/crear" method="GET">
                                                        <input type="hidden" name="idSolicitud" value="${citas.getId_cita()}" />
                                                        <button class="btn btn-success" title="Cotizar"><i class="fa fa-dollar"></i></button>
                                                    </form>
                                                </div>

                                                <div style="width: max-content; float: left; margin-left: 5px">
                                                    <form action="citas/listastado" method="POST">

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
                                    <th>Notaria</th>
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