<%@page import="Models.DTO.ContratoDTO"%>
<%@page import="Models.DAO.ContratoDAO"%>
<%@page import="Models.DAO.ContratoEstadoDAO"%>
<%@page import="Models.DTO.ContratoEstadoDTO"%>
<%@page import="Models.DTO.CausaIdDTO"%>
<%@page import="Models.DAO.CausaIdDAO"%>
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
        <link rel="stylesheet" href="/Lex/assets/plugins/sweet-alert/sweetalert2.min.css"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.5.6/css/buttons.dataTables.min.css">
    </jsp:attribute>

    <jsp:attribute name="content">
        <div class="row">
            <%@include file="/modules/globals/alerts.jsp" %>
            <div id="main-box" class="col-md-12">
                <div class="box box-info">
                    <div class="box-header with-border">
                        <h3 class="box-title">Gestión de Contratos</h3>

                    </div>

                    <div class="box-body">
                        <div class="row">
                            <div class="col-md-12">
                                <table id="table" class="table table-bordered table">
                                    <thead>
                                        <tr>
                                   
                                            <th style="width:1%;white-space: nowrap;">Número de Contrato</th>
                                            <th style="width:1%;white-space: nowrap;">Fecha de inicio</th>
                                            <th style="width:1%;white-space: nowrap;">Fecha de término</th>
                                            <th style="width:1%;white-space: nowrap;">Rol de Causa</th>
                                            <th style="width:1%;white-space: nowrap;">Estado</th>
                                            <th style="width:1%;white-space: nowrap;">Acciones</th>
                                    </thead>
                                    <tbody>

                                        <c:forEach var="contrato" items="${contratos}">


                                            <c:set var="estadoNombre" value="" />
                                            <c:forEach var="estado" items="${estados}">
                                                <c:if test="${estado.id_contrato_estado == contrato.getId_contrato_estado()}">
                                                    <c:set var="estadoNombre" value="${estado.nombre}" />
                                                </c:if>
                                            </c:forEach>



                                            <tr>
                                                <td>${contrato.getId_contrato()}</td>
                                                <td>${contrato.getFecha_inicio()}</td>
                                                <td>${contrato.getFecha_termino()}</td>

                                                <td>${contrato.rol_causa}</td>
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${estadoNombre == 'VIGENTE'}">
                                                            <span class="badge bg-green">Vigente</span>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <span class="badge bg-red">Vencido</span>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>

                                                <td style="width:1%;white-space: nowrap;">


                                                    <a href="DetalleContratoServlet?id=${contrato.getId_contrato()}&idp=${contrato.getId_presupuesto()}">
                                                        <button class="btn btn-sm btn-info"><i class="fa fa-eye"></i></button></a>



                                                    <a href="ModificarContrato?id=${contrato.getId_contrato()}">
                                                        <button class="btn btn-warning btn-sm" title="Editar"><i class="fa fa-edit"></i></button></a>


                                                    <!--<form action="contratos/borrar" method="POST"> 

                                                        <input type="hidden" name="id" value="${contrato.getId_contrato()}" />
                                                        <button class="btn btn-danger btn-sm" title="Eliminar" name="accion" value="Eliminar"><i class="fa fa-trash"></i></button>
                                                    </form>-->                                                  

                                                    <form action="pagos/crear" method="GET"> 

                                                        <input type="hidden" name="idContrato" value="${contrato.getId_contrato()}" />
                                                        <button class="btn btn-success btn-sm" type="submit"><i class="fa fa-dollar"></i></button>
                                                    </form>



                                                </td>
                                            </tr>


                                        </c:forEach>
                                    </tbody>

                                    <tfoot>
                                        <tr>
                                            <th>Número de Contrato</th>
                                            <th>Fecha de inicio</th>
                                            <th>Fecha de término</th>
                                            <th>Rol de Causa</th>
                                            <th>Estado</th>
                                            <th>Acciones</th>
                                        </tr>
                                    </tfoot>
                                </table>

                            </div>
                        </div>
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
            $('#table').dataTable({
                "searching": true,
                dom: 'Bfrtip',
                buttons: [
                    'copy', 'csv', 'excel', 'pdf', 'print'
                ]
            });

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
    </jsp:attribute>
</t:template>



