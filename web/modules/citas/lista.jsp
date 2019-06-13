<%-- 
    Document   : lista
    Created on : 11-06-2019, 22:23:31
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

                    <form action="/Lex/citas/buscar" method="POST">
                    <div class="form-group col-md-6">
                                            <label for="Detalle">Cliente</label>

                                            <select id="selectCliente" name="selectCliente" class="form-control">
                                                <option selected>Seleccione...</option>                                                
                                                <c:forEach var="clientes" items="${clientes}">
                                                    <option value="${clientes.getId()}">${clientes.nombres}  ${clientes.paterno} </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                    <div class="col-md-6">
                                                <input type="submit" name="accion" value="Buscar" class="btn btn-primary">
                                            </div>
                        </form>
                    <div class="box-body">
                        <table id="table" class="table table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th style="width:1%;white-space: nowrap;">Nº Cita</th>
                                    <th style="width:1%;white-space: nowrap;">Fecha</th>
                                    <th style="width:15%;white-space: nowrap;">Nombre Notaria</th>
                                    <th style="width:1%;white-space: nowrap;">Direccion</th>
                                    <th style="width:1%;white-space: nowrap;">Cliente</th>
                                  
                            </thead>
                            <tbody>

                        <c:forEach var="cita" items="${cita}"> 
                                   <tr>
                                        <td>${cita.getId_cita()}</td>
                                        <td>${cita.getFecha_hora()} ${cita.getHora()}</td>
                                        <td>${cita.getNotaria().getNombre()}</td>          
                                        <td>${cita.getNotaria().getDireccion()}
                                            <%--         <c:choose>
                                                <c:when test="${solicitudes.getEstadoSolicitud() == 1}">
                                                    <span class="badge bg-green">Activado</span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="badge bg-red">Desactivado</span>
                                                </c:otherwise>
                                            </c:choose>  --%>
                                       <%--       ${cita.getNotaria().getNombre().getRazonSocial()}no entrega valor, null --%>
                                        </td>
                                    <%--  
                                    <td>${cita.getNotaria().getNombre().getDireccion()}</td>  --%>
                                       
                                        <td>${cita.getCliente().getNombres()} ${cita.getCliente().getPaterno()}</td>
                                        <%--       <td>${cita.getTecnico().getNombres()} ${solicitudes.getTecnico().getPaterno()}</td>  --%>

                                     
                                    </tr>

                         </c:forEach>  
                            </tbody>

                            <tfoot>
                                <tr>
                                    <th>Nº Cita</th>
                                    <th>Fecha</th>
                                    <th>Nombre Notaria</th>
                                    <th>Direccion</th>
                                    <th>Cliente</th>
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
