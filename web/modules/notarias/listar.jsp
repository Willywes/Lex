<%-- 
    Document   : listar
    Created on : 21-06-2019, 16:30:59
    Author     : Depredador
--%>
<%@page import="Models.DTO.RolDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template>
    <jsp:attribute name="title">
        Gestión de Notarios
    </jsp:attribute>
    <jsp:attribute name="subtitle">
        Todos los Notarios
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


            <div id="main-box" class="col-md-12">
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <div  class="btn-group">
                            <a href="asignar" class="btn btn-success"> 
                                <i class="fa fa-plus"></i> Asignar
                            </a>
                        </div>
                    </div>
                    <div class="box-body">
                        <table id="table" class="table table-bordered table-hover">
                            <thead>
                                <tr>

                                    <th>Rut</th>
                                    <th>Apellido Paterno</th>
                                    <th>Apellido Materno</th>
                                    <th>Nombres</th>
                                    <th style="width:1%;white-space: nowrap;">Estado</th>
                            
                            </thead>
                            <tbody>  
                                <c:forEach var="usuario" items="${usuarios}">
                                    <c:if test="${usuario.id_rol == 4}">
                                    <tr>
                                    
                                        <td style="vertical-align: middle;">${usuario.rut}</td>
                                        <td style="vertical-align: middle;">${usuario.paterno}</td>
                                        <td style="vertical-align: middle;">${usuario.materno}</td>
                                        <td style="vertical-align: middle;">${usuario.nombres}</td>
                                        <td style="width:1%;white-space: nowrap;">
                                             <c:choose>
                                                <c:when test="${usuario.activo == true}">
                                                    <span class="badge bg-green">Activo</span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="badge bg-red">Desactivo</span>
                                                </c:otherwise>
                                            </c:choose>

                                         

                                        </td>

                                    </tr>
                                    </c:if>                                    
                                </c:forEach>


                            </tbody>

                            <tfoot>
                                <tr>
                                    <th>Rut</th>
                                    <th>Apellido Paterno</th>
                                    <th>Apellido Materno</th>
                                    <th>Nombres</th>
                                     <th>Estado</th>
                                 
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
