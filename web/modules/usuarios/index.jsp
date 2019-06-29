<%@page import="Models.DTO.RolDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template>
    <jsp:attribute name="title">
        Gestión de Usuarios
    </jsp:attribute>
    <jsp:attribute name="subtitle">
        Todos los Usuarios
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
                            <a href="create" class="btn btn-success"> 
                                <i class="fa fa-plus"></i> Nuevo Usuario
                            </a>
                        </div>
                    </div>
                    <div class="box-body">
                        <table id="table" class="table table-bordered table-hover">
                            <thead>
                                <tr>

                                    <th>Rut</th>
                                    <th>Paterno</th>
                                    <th>Materno</th>
                                    <th>Nombres</th>
                                    <th>Rol</th>
                                    <th style="width:1%;white-space: nowrap;">Estado</th>
                                    <th style="white-space: nowrap;">Acciones</th>
                            </thead>
                            <tbody>

                                <c:forEach var="usuario" items="${usuarios}">
                                    <c:set var="roleName" value="" />
                                    <c:forEach var="rol" items="${roles}">
                                        <c:if test="${rol.id == usuario.id_rol}">
                                            <c:set var="roleName" value="${rol.nombre}" />
                                        </c:if>
                                    </c:forEach>
                                    <tr>
                                        <td style="vertical-align: middle;">${usuario.rut}</td>
                                        <td style="vertical-align: middle;">${usuario.paterno}</td>
                                        <td style="vertical-align: middle;">${usuario.materno}</td>
                                        <td style="vertical-align: middle;">${usuario.nombres}</td>
                                        <td style="vertical-align: middle;">${roleName}</td>
                                        <td style="width:1%;white-space: nowrap;">

                                            <c:choose>
                                                <c:when test="${usuario.activo == true}">
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
                                                    <form action="edit" method="get">
                                                        <input type="hidden" name="id" value="${usuario.id}">
                                                        <button type="submit" class="btn btn-warning btn-sm" title="Editar">
                                                            <i class="fa fa-edit"></i>
                                                        </button>
                                                    </form>
                                                </div>
                                                <div style="width: max-content; float: left; margin-left: 5px">
                                                    <form id="cs_${usuario.id}" action="change-status" method="post">
                                                        <input type="hidden" name="id" value="${usuario.id}">
                                                        <c:choose>
                                                            <c:when test="${usuario.activo == true}">
                                                                <button type="button" onclick="removeUser(${usuario.id})" class="btn btn-danger btn-sm" title="Desactivar">
                                                                    <i class="fa fa-times"></i>
                                                                </button>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <button type="button" onclick="removeUser(${usuario.id})" class="btn btn-success btn-sm" title="Activar">
                                                                    <i class="fa fa-check"></i>
                                                                </button>
                                                            </c:otherwise>
                                                        </c:choose>

                                                    </form>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>

                                </c:forEach>


                            </tbody>

                            <tfoot>
                                <tr>
                                    <th>Rut</th>
                                    <th>Paterno</th>
                                    <th>Materno</th>
                                    <th>Nombres</th>
                                    <th>Rol</th>
                                    <th>Estado</th>
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
           
            
           function removeUser(us){
               
               
                swal({
                    title: '¿Estas Seguro?',
                    text: "Que desea cambiar el estado del usuario.",
                    type: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#43a047',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Si, eliminar!',
                    cancelButtonText: 'No, cancelar!'
                }).then(function (result) {
                    if (result.value) {
                        $('#cs_' + us).submit();
                    }
                });
           }
        </script>
        </script>
    </jsp:attribute>
</t:template>

