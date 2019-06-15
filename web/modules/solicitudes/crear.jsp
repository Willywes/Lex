<%@page import="Models.DTO.SolicitudDTO"%>
<%@page import="Models.DAO.SolicitudDAO"%>
<%@page import="Models.DTO.UsuarioDTO"%>
<%@page import="Models.DAO.UsuarioDAO"%>
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

                    </div>
                    <div class="box-body">
                        <table id="table" class="table table-bordered table-hover">

                            <tbody>
                            <center>
                                <div>
                                    <h3>Crear Solicitud</h3>
                                </div>

                                <div>
                                    <form action="/Lex/solicitudes/crear" method="POST">

                                        <div class="form-row">
                                            <div class="form-group col-md-4">
                                                <label for="FechaInicio">Fecha de Inicio</label>
                                                <input type="Date" class="form-control" id="FechaInicio" name="FechaInicio" placeholder="FechaInicio">
                                            </div>

                                            <label for="Descripcion">Descripcion</label>
                                            <div class="form-group col-md-4">
                                                <textarea name="txtDescripcion" rows="4" cols="50">Escriba aquí tus comentarios</textarea>      
                                            </div>
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="tipo">Tipo Solicitud</label>

                                            <select id="selectTipoSolicitud" name="selectTipoSolicitud" class="form-control">
                                                <option selected>Seleccione...</option>                                                
                                                <c:forEach var="tipoDeSolicitudes" items="${tipoDeSolicitudes}">
                                                    <option value="${tipoDeSolicitudes.getId()}">${tipoDeSolicitudes.nombre}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="Detalle">Cliente</label>

                                            <select id="selectCliente" name="selectCliente" class="form-control">
                                                <option selected>Seleccione...</option>                                                
                                                <c:forEach var="clientes" items="${clientes}">
                                                    <option value="${clientes.getId()}">${clientes.nombres}  ${clientes.paterno} </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="Detalle">Tecnico</label>

                                            <select id="selectTecnico" name="selectTecnico" class="form-control">
                                                <option selected>Seleccione...</option>                                                
                                                <c:forEach var="tecnicos" items="${tecnicos}">
                                                    <option value="${tecnicos.getId()}">${tecnicos.nombres}  ${tecnicos.paterno} </option>
                                                </c:forEach>
                                            </select>
                                        </div>


                                        <div class="form-group col-md-12">
                                            <input type="submit" class="btn btn-primary" name="accion" value="Guardar">

                                            <input type="button" class="btn btn-danger" name="Cancelar" value="Cancelar" onClick="location.href = '/Lex/contratos'">
                                        </div>
                                    </form>
                                </div>
                            </center>
                            </tbody>


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

