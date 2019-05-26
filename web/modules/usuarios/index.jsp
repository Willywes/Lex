<%@page import="Models.DTO.RolDTO"%>
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
                                    <th style="width:1%;white-space: nowrap;">Id</th>
                                    <th>Rut</th>
                                    <th>Paterno</th>
                                    <th>Materno</th>
                                    <th>Nombres</th>
                                    <th>Rol</th>
                                    <th style="width:1%;white-space: nowrap;">Estado</th>
                                    <th style="width:1%;white-space: nowrap;">Acciones</th>
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
                                        <td>${usuario.id}</td>
                                        <td>${usuario.rut}</td>
                                        <td>${usuario.paterno}</td>
                                        <td>${usuario.materno}</td>
                                        <td>${usuario.nombres}</td>
                                        <td>${roleName}</td>
                                        <td style="width:1%;white-space: nowrap;"><span class="badge bg-green">Activado</span></td>
                                        <td style="width:1%;white-space: nowrap;">
                                            <button class="btn btn-warning btn-sm" title="Editar"><i class="fa fa-edit"></i></button>
                                            <button class="btn btn-danger btn-sm" title="Eliminar"><i class="fa fa-trash"></i></button>
                                        </td>
                                    </tr>

                                </c:forEach>


                            </tbody>

                            <tfoot>
                                <tr>
                                    <th>Id</th>
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
    </jsp:attribute>
</t:template>

