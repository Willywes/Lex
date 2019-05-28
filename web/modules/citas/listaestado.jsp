<%-- 
    Document   : listaestado
    Created on : 27-05-2019, 22:00:45
    Author     : claudio
--%>


<%@page import="Models.DTO.CitaDTO"%>
<%@page import="Models.DAO.CitaDAO"%>
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
                           
                        </div>
                    </div>
                    <div class="box-body">
                        <table id="table" class="table table-bordered table-hover">
                            <h3>Estado Citas</h3>
                            <thead>
                                <tr>
                                    <th style="width:1%;white-space: nowrap;">Número de Estado Cita</th>
                                    <th style="width:1%;white-space: nowrap;">Nombre</th>
                                 
                            </thead>
                            <tbody>

                                <c:forEach var="cita" items="${citas}">
                                      
                                    <tr>
                                        <td>${cita.getId_estado_cita()}</td>
                                        <td>${cita.getNombre()}</td>
                                        
                                        <td style="width:1%;white-space: nowrap;">
                                          
                                        </td>
                                    </tr>

                                </c:forEach>
                            </tbody>

                            <tfoot>
                                <tr>
                                    <th>Número de Estado Cita</th>
                                        <th>Nombre</th>
                                   
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



