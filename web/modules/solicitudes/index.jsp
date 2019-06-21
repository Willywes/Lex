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
        Gestión de Solicitudes
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
                            <a class="btn btn-success" href="/solicitudes/crear"> <!--data-toggle="modal" data-target="#modal-create"--><i
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
                                        <td>${solicitudes.getDescripcion()}</td> 
                                        
                                        <c:set var="tipoName" value="" />
                                        <c:forEach var="solicitudTipo" items="${solicitudTipo}">
                                            <c:if test="${solicitudTipo.id == solicitudes.getId_tipo_solicitud()}">

                                                <c:set var="tipoName" value="${solicitudTipo.nombre}" />

                                            </c:if>
                                        </c:forEach>
                                        <td>${tipoName}</td>
                                        
                                        
                                        <c:set var="estadoName" value="" />
                                        <c:forEach var="solicitudEstado" items="${solicitudEstado}">
                                        <c:if test="${solicitudEstado.id_estado_solicitud == solicitudes.getId_estado_solicitud()}">
                                            
                                            <c:set var="estadoName" value="${solicitudEstado.nombre}" />
                                            
                                        </c:if>
                                    </c:forEach>
                                       
                                        <td> ${estadoName}  </td>

                                        <c:set var="clienteName" value="Test rol no Cliente" />

                                        <c:forEach var="clientes" items="${clientes}">
                                            <c:if test="${clientes.id == solicitudes.getId_cliente()}">
                                                <c:set var="clienteName" value="${clientes.nombres} ${clientes.paterno}" />
                                            </c:if>
                                        </c:forEach>
                                        <td>${clienteName} </td>
                                       
                                        
                                        <c:set var="tecnicoName" value="No Asignado" />

                                        <c:forEach var="tecnico" items="${tecnico}">
                                            <c:if test="${tecnico.id == solicitudes.getId_tecnico()}">
                                                <c:set var="tecnicoName" value="${tecnico.nombres} ${tecnico.paterno} " />

                                            </c:if>
                                        </c:forEach>
                                        

                                        <td>${tecnicoName}</td>
                                        

                                        <td style="white-space: nowrap; width: 1%; vertical-align: middle; ">
                                            
                                            <div style="width: max-content; float: left;">
                                                    <%--VER solicitud --%>
                                                    <a href="versolicitud?id=${solicitudes.getId_solicitud()}">
                                                        <button class="btn btn-sm btn-info" title="Ver"><i class="fa fa-eye"></i></button></a> 
                                                    <input type="hidden" name="id" value="${solicitudes.getId_solicitud()}" />
                                                </div>
                                            <div style="width: max-content; float: left;">
                                                <div style="width: max-content; float: left;">
                                                    <%--<form action="citas/editar" method="POST"> --%>
                                                    <a href="actualizar?id=${solicitudes.getId_solicitud()}">
                                                        <button class="btn btn-warning btn-sm" title="Editar"><i class="fa fa-edit"></i></button></a> 
                                                    <input type="hidden" name="id" value="${solicitudes.getId_solicitud()}" />
                                                </div>
                                                
                                                
                                                <c:if test="${solicitudes.getId_estado_solicitud()==2}">

                                                <div style="width: max-content; float: left;margin-left: 5px;">
                                                    <form action="../presupuestos/crear" method="GET">
                                                        <input type="hidden" name="idSolicitud" value="${solicitudes.getId_solicitud()}" />
                                                        <button class="btn btn-success" title="Presupuesto">Presupuesto<i class="fa fa-dollar"></i></button>
                                                    </form>
                                                </div>
                                                </c:if>
                                                
                                                <c:if test="${solicitudes.getId_estado_solicitud()==1}">

                                                <div style="width: max-content; float: left;margin-left: 5px;">
                                                    <form action="../presupuestos/crear" method="GET">
                                                        <input type="hidden" name="idSolicitud" value="${solicitudes.getId_solicitud()}" />
                                                        <button class="btn btn-success" title="Ver Presupuesto">Ver Presupuesto<i class="fa fa-dollar"></i></button>
                                                    </form>
                                                </div>
                                                </c:if>
                                                
                                                <c:if test="${solicitudes.getId_estado_solicitud()!=3}">
                                              
                                                <div style="width: max-content; float: left; margin-left: 5px">
                                                    <a href="borrar?id=${solicitudes.getId_solicitud()}">
                                                        <button class="btn btn-sm btn-danger" title="Rechazar"><i class="btn btn-sm btn-danger"></i>Rechazar</button></a> 
                                                    <input type="hidden" name="id" value="${solicitudes.getId_solicitud()}" />
                                                    
                                                </div>
                                                 </c:if>
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



