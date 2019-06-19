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
                    <input  readonly type="text" class="form-control" id="fechasolicitud" value="${cita.getFecha_hora()}">
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
                <label  for="inputSolicitud" class="col-sm-2 control-label" >Estado de cita</label>
                <div class="col-sm-10">
                    <select id="selectestadoCita" name="selectestadoCita" requerid class="form-control">
                        <option selected>Seleccione...</option>                                                
                        <c:forEach var="citaEstado" items="${citaEstado}">
                            <option value="${citaEstado.getId_cita_estado()}">${citaEstado.nombre}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            

            <div class="col-md-12 text-rigth">
               <input type="submit" class="btn btn-primary" name="accion" value="Guardar">
               <input type="hidden" name="id" value="${cita.getId_cita()}"/>

                
               <input type="button" class="btn btn-danger" name="Cancelar" value="Cancelar" onClick="location.href = '/Lex/'">
            </div>
        </form>
    </jsp:attribute>

    <jsp:attribute name="scripts">
        <!-- DataTables -->
        <script src="/Lex/assets/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
        <script src="/Lex/assets/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    </jsp:attribute>
</t:template>



