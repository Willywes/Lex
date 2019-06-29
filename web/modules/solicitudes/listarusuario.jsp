<%-- 
    Document   : listarusuario
    Created on : 29-06-2019, 9:39:49
    Author     : claudio
--%>

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
        <link rel="stylesheet" href="/Lex/assets/plugins/sweet-alert/sweetalert2.min.css"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.5.6/css/buttons.dataTables.min.css">

    </jsp:attribute>

    <jsp:attribute name="content">
        <div class="row">
            
            <%@include file="/modules/globals/alerts.jsp" %>
            
            <div id="main-box"class="col-md-12">
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <div  class="btn-group">
                            <a class="btn btn-success" href="/Lex/solicitudes/crearusuario"> <!--data-toggle="modal" data-target="#modal-create"--><i
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
                                    <th style="width:15%;white-space: nowrap;">Descripción</th>
                                    <th style="width:1%;white-space: nowrap;">Tipo</th>
                                    <th style="width:1%;white-space: nowrap;">Estado</th>
                                    <th style="width:1%;white-space: nowrap;">Cliente</th>
                                    <th style="width:1%;white-space: nowrap;">Técnico</th>
                                    <th style="width:1%;white-space: nowrap;">Acciones</th>
                            </thead>
                            <tbody>
                                <%--  Usuario usuarioDTO Lectura de datos. --%>
                            
                                <c:forEach var="solicitudes" items="${solicitudes}">
                                     <c:if test="${usuarioDTO.id==solicitudes.getId_cliente()}">
                                    <tr>
                                        
                                        <td>${solicitudes.getId_solicitud()} </td>
                                        
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

                                        <c:set var="clienteName" value="Juan Urra" />

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
                                        <%-- envio de session a servelet --%>
                                        <input type="hidden" name="usuarioSession" value="${usuarioDTO}" />

                                        <td>${tecnicoName}</td>


                                        <td style="white-space: nowrap; width: 1%; vertical-align: middle; ">

                                            <div style="width: max-content; float: left;">
                                                <%--VER solicitud --%>
                                                <a href="versolicitudusuario?id=${solicitudes.getId_solicitud()}">
                                                    <button class="btn btn-sm btn-info" title="Ver"><i class="fa fa-eye"></i></button></a> 
                                                <input type="hidden" name="id" value="${solicitudes.getId_solicitud()}" />
                                            </div>
                                            <div style="width: max-content; float: left;">
                                              
                                                <%-- ACa boton para ver la solicitud del Cliente --%>
                                                <c:if test="${solicitudes.getId_estado_solicitud()==1}">

                                                    <div style="width: max-content; float: left;margin-left: 5px;">
                                                        <form action="../presupuestos/crear" method="GET">
                                                            <input type="hidden" name="idSolicitud" value="${solicitudes.getId_solicitud()}" />
                                                            <button class="btn btn-sm btn-info" title="Ver Presupuesto"><i class="fa fa-eye"></i> Ver Presupuesto</button>
                                                        </form>
                                                    </div>
                                                </c:if>  
   
                                            </div>
                                        </td>
                                    </tr>
                                </c:if> 
                                </c:forEach>
                                  
                            </tbody>

                            <tfoot>
                                <tr>
                                    <th>Nº Solicitud</th>
                                    <th>Fecha</th>
                                    <th>Descripción</th>
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
        <script src="/Lex/assets/plugins/sweet-alert/sweetalert2.min.js"></script>

<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/1.5.6/js/dataTables.buttons.min.js"></script>
	<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/1.5.6/js/buttons.flash.min.js"></script>
	<script type="text/javascript" language="javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
	<script type="text/javascript" language="javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
	<script type="text/javascript" language="javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
	<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/1.5.6/js/buttons.html5.min.js"></script>
	<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/1.5.6/js/buttons.print.min.js"></script>        
        <script>
            $('#table').dataTable( {
                "searching": true,
                dom: 'Bfrtip',
                buttons: [
                    'copy', 'csv', 'excel', 'pdf', 'print'
                ]
              } );
              
              $('.dt-button').addClass('btn btn-primary');
              $('.dt-button').css({'margin-bottom': '10px'});
              $('.dt-button').removeClass('dt-button');

        </script>

        <style>
            
            #table_filter label{
                float:right;
            }
            
            #table_filter label:before{
               /* content : 'Buscar';*/
            }
        </style>
        <script>
           
            
           function removeUser(){
               
               
                swal({
                    title: '¿Estas Seguro?',
                    text: "Si eliminas este usuario, la información será irrecuperable",
                    type: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#43a047',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Si, eliminar!',
                    cancelButtonText: 'No, cancelar!'
                }).then(function (result) {
                    if (result.value) {
                        $('#remove-user').submit();
                    }
                });
           }
        </script>
    </jsp:attribute>
</t:template>



