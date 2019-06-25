<%-- 
    Document   : asignados
    Created on : 23-06-2019, 23:33:37
    Author     : Depredador
--%>

<%@page import="java.util.List"%>
<%@page import="Models.DTO.RolDTO"%>
<%@page import="Models.DTO.NotariaNota" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template>
    <jsp:attribute name="title">
        Gestión de Notarias
    </jsp:attribute>
    <jsp:attribute name="subtitle">
       Asignaciones 
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
                           
                        </div>
                    </div>
                    <div class="box-body">
                        <table id="table" class="table table-bordered table-hover">
                            <thead>
                                <tr>

                                    <th>Nombres</th>
                                    <th>Apellido</th>
                                    <th>email</th>
                                    <th>telefono</th>
                                    <th>Nombre Notaria</th>
                                    <th>Razon Social</th>
                                    <th>Direccion</th>
                                    <th>Telefono</th>                                    
                                    <th style="width:1%;white-space: nowrap;">Estado</th>
                                    <th style="white-space: nowrap;">Acciones</th>
                            </thead>
                            <tbody>
                               
                                <c:forEach var="notaria" items="${notariasNotas}">
                                    <c:set var="usuario" value="${notaria.usuario}" />
                                    <c:set var="notaria" value="${notaria.notaria}" />
                                                                             
                                    <tr>                   
                                        <td style="vertical-align: middle;">${usuario.nombres}</td>                                     
                                          <td style="vertical-align: middle;">${usuario.paterno}</td>
                                          <td style="vertical-align: middle;">${usuario.email}</td>
                                          <td style="vertical-align: middle;">${usuario.telefono}</td>
                                          <td style="vertical-align: middle;">${notaria.nombre}</td>
                                         <td style="vertical-align: middle;">${notaria.razonSocial}</td>
                                         <td style="vertical-align: middle;">${notaria.direccion}</td>
                                         <td style="vertical-align: middle;">${notaria.telefono}</td>
                                        <td style="width:1%;white-space: nowrap;">

                                            <c:choose>
                                                <c:when test="${usuario.activo == false}">
                                                    <span class="badge bg-green">Asignado</span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="badge bg-red">Denegado</span>
                                                </c:otherwise>
                                            </c:choose>

                                        </td>
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
                                                        <input type="hidden" name="id" value="${usuario.id}">
                                                        <c:choose>
                                                            <c:when test="${usuario.activo == true}">
                                                                <button type="submit" class="btn btn-danger btn-sm" title="Desactivar">
                                                                    <i class="fa fa-times"></i>
                                                                </button>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <button type="submit" class="btn btn-success btn-sm" title="Activar">
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
                                    <th>Nombres</th>
                                    <th>Apellido</th>
                                    <th>email</th>
                                    <th>telefono</th>
                                    <th>Nombre Notaria</th>
                                    <th>Razon Social</th>
                                    <th>Direccion</th>
                                    <th>Telefono</th>      
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
        <script>

        </script>
    </jsp:attribute>
</t:template>

