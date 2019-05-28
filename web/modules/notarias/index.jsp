<%@page import="Models.DTO.RolDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template>
    <jsp:attribute name="title">
        Gestión de Notarias
    </jsp:attribute>
    <jsp:attribute name="subtitle">
        Todas las Notarias
    </jsp:attribute>

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
                                <i class="fa fa-plus"></i> Nueva Notaria
                            </a>
                        </div>
                    </div>
                    <div class="box-body">
                        <table id="table" class="table table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th>Nombre</th>
                                    <th>Razón Social</th>
                                    <th>Teléfono</th>
                                    <th>Dirección</th>
                                    <th>Comuna</th>
                                    <th>Región</th>
                                    <th style="white-space: nowrap;">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach var="notaria" items="${notarias}">
                                    
                                    <tr>
                                        <td style="vertical-align: middle;">${notaria.nombre}</td>
                                        <td style="vertical-align: middle;">${notaria.razonSocial}</td>
                                        <td style="vertical-align: middle;">${notaria.telefono}</td>
                                        <td style="vertical-align: middle;">${notaria.direccion}</td>
                                        <td style="vertical-align: middle;">${notaria.comuna}</td>
                                        <td style="vertical-align: middle;">${notaria.region}</td>
                                       
                                        <td style="white-space: nowrap; width: 1%; vertical-align: middle; ">
                                            <div style="width: max-content; float: left;">
                                                <div style="width: max-content; float: left;">
                                                    <form action="edit" method="get">
                                                        <input type="hidden" name="id" value="${notaria.id}">
                                                        <button type="submit" class="btn btn-warning btn-sm" title="Editar">
                                                            <i class="fa fa-edit"></i>
                                                        </button>
                                                    </form>
                                                </div>
                                                <div style="width: max-content; float: left; margin-left: 5px">
                                                    <form action="change-status" method="post">
                                                        <input type="hidden" name="id" value="${notaria.id}">
                                                        <button type="submit" class="btn btn-danger btn-sm" title="Eliminar">
                                                            <i class="fa fa-times"></i>
                                                        </button>
                                                    </form>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>

                                </c:forEach>


                            </tbody>

                            <tfoot>
                                <tr>
                                    <th>Nombre</th>
                                    <th>Razón Social</th>
                                    <th>Teléfono</th>
                                    <th>Dirección</th>
                                    <th>Comuna</th>
                                    <th>Región</th>
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
        <script>

        </script>
    </jsp:attribute>
</t:template>

