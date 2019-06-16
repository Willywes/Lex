<%-- 
    Document   : buscarfechas
    Created on : 14-06-2019, 22:04:36
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
        Buscardor
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
                    <form action="/Lex/solicitudes/buscarfechas" method="POST">
                    <div class="form-group col-md-6">
                                           

                                            <div class="form-group col-md-4">
                                                <label for="FechaInicio">Fecha de Inicio</label>
                                                <input type="Date" class="form-control" id="FechaInicio" name="FechaInicio" placeholder="FechaInicio">
                                            </div>
                                        </div>
                     <div class="form-group col-md-6">
                                          

                                            <div class="form-group col-md-4">
                                                <label for="FechaInicio">Fecha de Termino</label>
                                                <input type="Date" class="form-control" id="FechaInicio" name="FechaTermino" placeholder="FechaTermino">
                                            </div>
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
                                    <th style="width:15%;white-space: nowrap;">Descripcion</th>
                                    <th style="width:1%;white-space: nowrap;">Tipo</th>
                                    <th style="width:1%;white-space: nowrap;">Estado</th>
                                    <th style="width:1%;white-space: nowrap;">Cliente</th>
                                    <th style="width:1%;white-space: nowrap;">técnico</th>
                                    <th style="width:1%;white-space: nowrap;">Acciones</th>
                            </thead>
                            <tbody>
                               
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



