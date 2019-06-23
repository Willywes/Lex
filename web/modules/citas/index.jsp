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
        Todas las Citas
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
                                    <th style="width:1%;white-space: nowrap;">Nº Cita</th>
                                    <th style="width:1%;white-space: nowrap;">Fecha</th>
                                    <th style="width:15%;white-space: nowrap;">Notaria</th>
                                    <th style="width:1%;white-space: nowrap;">Estado</th>
                                    <th style="width:1%;white-space: nowrap;">Acciones</th>
                            </thead>
                            <tbody>

                                <c:forEach var="cita" items="${citas}">
                                    
                                     <c:set var="notariaName" value="" />
                                     <c:set var="notariaRazonSocial" value="" />

                                    <c:forEach var="notaria" items="${notarias}">
                                        <c:if test="${notaria.id == cita.getId_notaria()}">
                                            <c:set var="notariaName" value="${notaria.nombre}" />
                                            <c:set var="notariaRazonSocial" value="${notaria.razonSocial}" />
                                        </c:if>
                                    </c:forEach>

                                    <tr>
                                        <td>${cita.getId_cita()}</td>
                                        <td>${cita.getFecha_hora()}  ${cita.getHora()}</td>
                                        <td>
                                            
                                            ${notariaName} - ${notariaRazonSocial}
                                        
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${cita.getId_estado_cita() == 1}">
                                                    <span class="badge bg-green">Activado</span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="badge bg-red">Desactivado</span>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>

                                        <td style="white-space: nowrap; width: 1%; vertical-align: middle; ">
                                            <div style="width: max-content; float: left;">
                                                <div style="width: max-content; float: left;">
                                                    
                                                    <a href="citas/editar?id=${cita.getId_cita()}">
                                                        <button class="btn btn-warning btn-sm" title="Editar"><i class="fa fa-edit"></i></button></a>    
                                                </div>
                                                <div style="width: max-content; float: left; margin-left: 5px">
                                                    <c:if test="${cita.getId_estado_cita()==1}">
                                                    <form id="rechaza" action="citas/borrar" method="POST"> <%-- GET --%>
                                                        <input type="hidden" name="id" value="${cita.getId_cita()}" />
                                                       
                                                        
                                                            <button type="button" class="btn btn-danger btn-sm" title="Rechazar " name="accion" value="Rechazar" onclick="rechazarCita()">
                                                                <i class="fa fa-trash"></i>Rechazar</button>
                                                            
                                                    </form>
                                                        </c:if>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>

                                </c:forEach>
                            </tbody>

                            <tfoot>
                                <tr>
                                    <th>Nº Cita</th>
                                    <th>Fecha</th>
                                    <th>Notaria</th>
                                    <th>Notaria</th>
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
           
            
            function rechazarCita(){
        
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



