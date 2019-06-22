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
        Gestión de Citas
    </jsp:attribute>
    <jsp:attribute name="subtitle">
        Cambiar Estado
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
  
    <form id="rechaza" class="form-horizontal" action="/Lex/citas/borrar" method="POST"role="form">
            <div class="form-group">
                <label for="inputSolicitud" class="col-sm-2 control-label" >Nº Cita</label>
                <div class="col-sm-10">
                    <input  readonly type="text" class="form-control" id="inputEmail3" value="${cita.getId_cita()}">
                </div>
            </div>
            <div class="form-group">
                <label for="inputSolicitud" class="col-sm-2 control-label" >Fecha cita</label>
                <div class="col-sm-10">
                    <input  readonly type="text" class="form-control" id="inputFecha" value="${cita.getFecha_hora()}">
                </div>
            </div>
   
            <div class="form-group">
                <label for="inputSolicitud" class="col-sm-2 control-label" >Nombre Notaria</label>
                <div class="col-sm-10">
                    <c:set var="notariaName" value="" />
                    <c:set var="notariaRazonSocial" value="" />

                                    <c:forEach var="notaria" items="${notarias}">
                                        <c:if test="${notaria.id == cita.getId_notaria()}">
                                            <c:set var="notariaName" value="${notaria.nombre}" />
                                            <c:set var="notariaRazonSocial" value="${notaria.razonSocial}" />
                                        </c:if>
                                         </c:forEach>
                    <input  readonly type="text" class="form-control" id="inputEmail3" value="${notariaName}">
                </div>
            </div>
            <div class="form-group">
                <label for="inputSolicitud" class="col-sm-2 control-label" >Estado de Solicitud</label>
                <div class="col-sm-10">
                                                 <c:choose>
                                                <c:when test="${cita.getId_estado_cita() == 1}">
                                                    <span class="badge bg-green">Activado</span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="badge bg-red">Desactivado</span>
                                                </c:otherwise>
                                            </c:choose>
                                                    
                   <%-- <input  readonly type="text" class="form-control" id="inputEmail3" value="${cita.getId_estado_cita()}">  --%>
                </div>
            </div>

                 <input type="hidden" name="id" value="${cita.getId_cita()}" />
                
                 <button type="button" class="btn btn-danger btn-sm" title="Rechazar " name="accion" value="Rechazar" onclick="rechazarSolicitud()">
                <i class="fa fa-trash"></i>Rechazar</button>
                <input type="button" class="btn btn-danger" name="Cancelar" value="Cancelar" onClick="location.href = '/Lex/citas/listar'">
                
                
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
                    text: "Rechazara esta cita, el estado cambiara a Rechazado",
                    type: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#43a047',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Si, Rechazar!',
                    cancelButtonText: 'No, cancelar!'
                }).then(function (result) {
                    if (result.value) {
                      $('#rechaza').submit();
                    }
                });
                
           }
        </script>
    </jsp:attribute>
</t:template>


