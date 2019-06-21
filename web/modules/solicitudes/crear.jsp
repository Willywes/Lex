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
        <form action="/Lex/solicitudes/crear" method="POST" class="form-horizontal" role="form">
        <!-- Main content -->
        <section class="content container-fluid">

            <!--------------------------
            | usar solo esta parteeeeeee |
            -------------------------->

            <div class="row">
                <div class="col-md-12">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">Nueva Solicitud</h3>
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
                                                <td>${clientes.rut}</td>
                                                <td>${clientes.nombres} ${clientes.paterno}</td>
                                                <td>${clientes.celular}</td>
                                                <td>${clientes.email}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="tipo">Tipo Solicitud</label>

                                        <select id="selectTipoSolicitud" name="selectTipoSolicitud" class="form-control">
                                            <option selected>Seleccione...</option>                                                
                                            <c:forEach var="tipoDeSolicitudes" items="${tipoDeSolicitudes}">
                                                <option value="${tipoDeSolicitudes.getId()}">${tipoDeSolicitudes.nombre}</option>
                                            </c:forEach>
                                        </select>

                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="">Describa lo que sea solicitar</label>
                                        <textarea class="form-control" name="textDescripcion" id="textDescripcion" cols="30" rows="10"></textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <button  type="submit" class="btn btn-primary right" name="accion"><i class="fa fa-save"></i> Guardar</button>
                                    <input type="button" class="btn btn-danger" name="Cancelar" value="Cancelar" onClick="location.href = '/Lex/'">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </section>
        <!-- /.content -->
</form>
    </jsp:attribute>

    <jsp:attribute name="scripts">
        <!-- DataTables -->
        <script src="/Lex/assets/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
        <script src="/Lex/assets/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    </jsp:attribute>
</t:template>

