<%@page import="Models.DTO.ContratoDTO"%>
<%@page import="Models.DAO.ContratoDAO"%>
<%@page import="Models.DAO.ContratoEstadoDAO"%>
<%@page import="Models.DTO.ContratoEstadoDTO"%>
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
                            <a class="btn btn-success" href="contratos/crear"> <!--data-toggle="modal" data-target="#modal-create"--><i
                                    class="fa fa-plus"></i> Nuevo Contrato
                            </a>
                        </div>
                    </div>
                   
                    <div class="box-body">
                        <table id="table" class="table table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th style="width:1%;white-space: nowrap;">Número de Contrato</th>
                                    <th style="width:1%;white-space: nowrap;">Fecha de inicio</th>
                                    <th style="width:1%;white-space: nowrap;">Fecha de término</th>
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
                                    
                                    <td>${estadoNombre}</td>
                                    <td style="width:1%;white-space: nowrap;">
                                        
                                        <form action="contratos/borrar" method="POST"> 
                                        <button class="btn btn-warning btn-sm" title="Editar"><i class="fa fa-edit"></i></button>
                                        <input type="hidden" name="id" value="${contrato.getId_contrato()}" />
                                        <button class="btn btn-danger btn-sm" title="Eliminar" name="accion" value="Eliminar"><i class="fa fa-trash"></i></button>
                 
                                 
                                        </td>
                                </tr>
                             </form>

                                </c:forEach>
                            </tbody>

                            <tfoot>
                                <tr>
                                    <th>Número de Contrato</th>
                                    <th>Fecha de inicio</th>
                                    <th>Fecha de término</th>
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
    </jsp:attribute>
</t:template>



