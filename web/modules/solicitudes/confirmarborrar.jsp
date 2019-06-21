<%-- 
    Document   : confirmarborrar
    Created on : 16-06-2019, 22:55:41
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
        Confirmar Rechazar Solicitud
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
  
    <form class="form-horizontal" action="/Lex/solicitudes/borrar" method="POST"role="form">
            <div class="form-group">
                <label for="inputSolicitud" class="col-sm-2 control-label" >Nº Solicitud</label>
                <div class="col-sm-10">
                    <input  readonly type="text" class="form-control" id="inputEmail3" value="${solicitudes.getId_solicitud()}">
                </div>
            </div>
            <div class="form-group">
                <label for="inputSolicitud" class="col-sm-2 control-label" >Fecha Solicitud</label>
                <div class="col-sm-10">
                    <input  readonly type="text" class="form-control" id="inputFecha" value="${solicitudes.getFecha_hora()}">
                </div>
            </div>
            <div class="form-group">
                <label for="inputSolicitud" class="col-sm-2 control-label" >Descripcion</label>
                <div class="col-sm-10">
                    <textarea readonly class="form-control" rows="3">${solicitudes.getDescripcion()}</textarea>
                </div>
            </div>
            <div class="form-group">
                <label for="inputSolicitud" class="col-sm-2 control-label" >Tipo de Solicitud</label>
                <div class="col-sm-10">
                    <input  readonly type="text" class="form-control" id="inputEmail3" value="${solicitudes.getTipoSolicitud().getNombre()}">
                </div>
            </div>
            <div class="form-group">
                <label for="inputSolicitud" class="col-sm-2 control-label" >Estado de Solicitud</label>
                <div class="col-sm-10">
                    <input  readonly type="text" class="form-control" id="inputEmail3" value="${solicitudes.getEstadoSolicitud().getNombre()}">
                </div>
            </div>
            <div class="form-group">
                <label for="inputSolicitud" class="col-sm-2 control-label" >Cliente</label>
                <div class="col-sm-10">
                    <input  readonly type="text" class="form-control" id="inputEmail3" value="${solicitudes.getCliente().getNombres()} ${solicitudes.getCliente().getPaterno()}">
                </div>
            </div>
            <div class="form-group">
                <label for="inputSolicitud" class="col-sm-2 control-label" >Tecnico</label>
                <div class="col-sm-10">
                    <input  readonly type="text" class="form-control" id="inputEmail3" value="${solicitudes.getTecnico().getNombres()} ${solicitudes.getTecnico().getPaterno()}">
                </div>
            </div>
<%--
           <div class="col-md-12 text-rigth">
                <a class="btn btn-warning btn-sm" title="Editar" href="actualizar?id=${solicitudes.getId_solicitud()}">
                    <i class="fa fa-edit"></i> Editar
                </a> 
                    --%>
                <button class="btn btn-danger btn-sm" title="Rechazar " name="accion" value="Rechazar" onclick="rechazarSolicitud();">
                <i class="fa fa-trash"></i>Rechazar</button>
               <%--  <input type="hidden" name="idSolicitud" value="${solicitudes.getId_solicitud()}" /> --%>
                
            </div>
        </form>
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
        
        <style>
            
            #table_filter label{
                float:right;
            }
            
            #table_filter label:before{
               /* content : 'Buscar';*/
            }
        </style>
        <script>
           
            
            function rechazarSolicitud(){
               
               
                swal({
                    title: '¿Estas Seguro?',
                    text: "Rechazara este solicitud, el estado cambiara a Rechazado",
                    type: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#43a047',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Si, Rechazar!',
                    cancelButtonText: 'No, cancelar!'
                }).then(function (result) {
                    if (result.value) {
                        //$('borrar?idSolicitud=${solicitudes.getId_solicitud()}').submit();
                        $('<input type="hidden" name="idSolicitud" value="${solicitudes.getId_solicitud()}"/>').submit();
                    }
                });
           }
        </script>
    </jsp:attribute>
</t:template>