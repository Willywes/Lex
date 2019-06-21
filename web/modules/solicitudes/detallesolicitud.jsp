<%-- 
    Document   : detallesolicitud
    Created on : 19-06-2019, 19:27:01
    Author     : claudio
--%>

<%@page import="Models.DTO.SolicitudTiposDTO"%>
<%@page import="Models.DAO.SolicitudTiposDAO"%>
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

  <!-- Main content -->
        <section class="content container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">Detalle Solicitud</h3>
                        </div>
                        <div class="box-body">
                            <div class="row">
                                <div class="col-md-12">
                                    <table class="table table table-bordered">
                                        <tbody>
                                        <tr>
                                            <th>Rut</th>
                                            <th>Nombre</th>
                                            <th>Telefono</th>
                                            <th>Email</th>
                                        </tr>
                                        
                                        <tr>
                                          
                                            <td>${solicitudes.getCliente().getRut()}</td>
                                            <td>${solicitudes.getCliente().getNombres()} ${solicitudes.getCliente().getPaterno()}</td>
                                            <c:set var="celular" value="Sin número registrado." />
                                             <c:if test="${solicitudes.getCliente().getCelular() != 0}">

                                                    <c:set var="celular" value="${solicitudes.getCliente().getCelular()}" />

                                                </c:if>
                                            <td>${celular}</td>
                                            <td>${solicitudes.getCliente().getEmail()}</td>
                                        </tr> 
                                        <tr>
                                            <th colspan="2" style="width: 30%;">Tipo de Solicitud</th>
                                              
                                            <td colspan="2">${solicitudes.getTipoSolicitud().getNombre()}</td>
                                        </tr>
                                        <tr>
                                            <th colspan="2">Descripcion</th>
                                            <td colspan="2">${solicitudes.getDescripcion()}</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="col-md-12">
                                    <button class="btn btn-primary"  onClick="location.href = '/Lex/'">volver</button>
                                    <div style="float: right">
                                         <form action="../presupuestos/crear" method="GET">
                                                        <input type="hidden" name="idSolicitud" value="${solicitudes.getId_solicitud()}" />
                                                        <button class="btn btn-success">Presupuestar</button>
                                                    </form>
                                       
                                        <button class="btn btn-danger">Rechazar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </section>
        <!-- /.content -->

        </jsp:attribute>
         <jsp:attribute name="scripts">
        <!-- DataTables -->
        <script src="/Lex/assets/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
        <script src="/Lex/assets/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    </jsp:attribute>
        </t:template>