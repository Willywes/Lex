<%-- 
    Document   : cita modificar
    Created on : 15-05-2019, 22:34:03
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


    <jsp:attribute name="title">
        Gestión de Citas
    </jsp:attribute>
    <jsp:attribute name="subtitle">
        Modificar Cita
    </jsp:attribute>

    <jsp:attribute name="content">
        <form action="/Lex/citas/editar" method="POST" class="form-horizontal" role="form">
            <div class="form-group">
                <label for="inputSolicitud" class="col-sm-2 control-label" >Nº Cita</label>
                <div class="col-sm-10">
                    <input  readonly type="text" class="form-control" id="id_solicitud" value="${cita.getId_cita()}">
                </div>
            </div>
            <div class="form-group">
                <label for="inputSolicitud" class="col-sm-2 control-label" >Fecha Cita</label>
                <div class="col-sm-10">
                    <input  readonly type="text" class="form-control" id="fechasolicitud" value="${cita.getFecha_hora()} ${cita.getHora()}">
                </div>
            </div>
      
            <div class="form-group">
                <label readonly for="inputSolicitud" class="col-sm-2 control-label" >Notaria</label>
                <div class="col-sm-10">

                    <c:set var="notariaName" value="" />
                    <c:set var="notariaRazonSocial" value="" />

                    <c:forEach var="notarias" items="${notarias}">
                        <c:if test="${notarias.id == cita.getId_notaria()}">
                            <c:set var="notariaName" value="${notarias.nombre}" />
                            <c:set var="notariaRazonSocial" value="${notarias.razonSocial}" />
                        </c:if>
                    </c:forEach>

                    <input readonly type="text" class="form-control"  id="idnotaria" value="${notariaName} - ${notariaRazonSocial}"></textarea>
                </div>
            </div>

            <div class="form-group">
                <label  for="inputSolicitud" class="col-sm-2 control-label" >Direccion</label>
                <div class="col-sm-10">

                    <c:set var="Direccion" value="" />
                    <c:set var="Fono" value="" />


                    <c:forEach var="notarias" items="${notarias}">
                    <c:if test="${notarias.id == cita.getId_notaria()}">
                        <c:set var="Direccion" value="${notarias.direccion}" />
                        <c:set var="Fono" value="${notarias.telefono}" />
                    </c:if>
                    </c:forEach>

                    <input  readonly type="text" class="form-control" id="fechasolicitud" value="${Direccion}">
                </div>
            </div>
                
                <div class="form-group">
                <label for="inputSolicitud" class="col-sm-2 control-label" >Telefono</label>
                <div class="col-sm-10">
                    <input  readonly type="text" class="form-control" id="fechasolicitud" value="${Fono}">
                </div>
            </div>

             <div class="form-group">
                <label  for="inputSolicitud" class="col-sm-2 control-label" >Estado de cita</label>
                <div class="col-sm-10">

                    <c:set var="EstadoCita" value="Aceptada" />


                    <c:if test="${cita.getId_estado_cita()==2}">
                        <c:set var="EstadoCita" value="Denegada" />

                    </c:if>


                    <input  readonly type="text" class="form-control" id="fechasolicitud" value="${EstadoCita}">
                </div>
            </div>    
                

            <div class="col-md-12 text-rigth">
                <input type="submit" class="btn btn-primary" name="accion" value="Cambiar Estado">
                <input type="hidden" name="id" value="${cita.getId_cita()}"/>


                <input type="button" class="btn btn-danger" name="Cancelar" value="Cancelar" onClick="location.href = '/Lex/citas'">
            </div>
        </form>
    </jsp:attribute>

    <jsp:attribute name="scripts">
        <!-- DataTables -->
        <script src="/Lex/assets/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
        <script src="/Lex/assets/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    </jsp:attribute>
</t:template>



