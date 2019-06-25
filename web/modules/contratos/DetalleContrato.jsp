<%@page import="Models.DTO.ContratoDTO"%>
<%@page import="Models.DAO.ContratoDAO"%>
<%@page import="Models.DTO.ContratoEstadoDTO"%>
<%@page import="Models.DAO.ContratoEstadoDAO"%>
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
                <div class="box box-info">
                    <div class="box-header with-border">
                        <h3>Detalle de Contrato N°  ${contrato.getId_contrato()}</h3>
                    </div>
                    <div class="box-body">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="box-body">
                                    <table id="table" class="table table-bordered table-hover">

                                        <tbody>
                                        <center>
                                            <div>
                                                <form action="/Lex/ModificarContrato" method="POST">

                                                    <div class="row">
                                                        <div class="form-group col-md-4 text-left">
                                                            <label for="FechaInicio">Fecha de Inicio: </label>
                                                            ${contrato.getFecha_inicio()}
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="form-group col-md-4 text-left">
                                                            <label for="FechaTermino">Fecha de Término: </label>
                                                            ${contrato.getFecha_termino()}
                                                        </div>
                                                    </div>
                                                   
                                                        
                                                    <div class="row">
                                                        <div class="form-group col-md-4 text-left">
                                                            <label>Servicios/Monto: </label>
                                                            <c:forEach var="pdetalle" items="${pdetalles}">
                                                            ${pdetalle.servicio}  -  $${pdetalle.monto} </br>
                                                        </c:forEach>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="form-group col-md-4 text-left">
                                                            <label for="estado">Estado: </label>

                                                            <c:forEach var="estado" items="${estados}">
                                                                <c:if test="${estado.id_contrato_estado == contrato.getId_contrato_estado()}">
                                                                    ${estado.nombre}

                                                                </c:if>

                                                            </c:forEach>

                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="form-group col-md-6 text-left">
                                                            <label for="rol_causa">Rol Causa: </label>

                                                            ${contrato.getRol_causa()}

                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="form-group col-md-6 text-left">
                                                            <label for="Presupuesto">N° Presupuesto Asociado: </label>
                                                            <c:forEach var="presupuesto" items="${presupuestos}">
                                                                <c:if test="${contrato.getId_presupuesto() == presupuesto.idPresupuesto}">
                                                                    ${presupuesto.idPresupuesto}
                                                                </c:if>

                                                            </c:forEach>


                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="form-group col-md-6 text-left">
                                                            <label for="Abogado">Abogado: </label>
                                                            <c:forEach var="usuario" items="${usuarios}">
                                                                <c:if test="${usuario.id_rol == 1 or usuario.id_rol == 2}">
                                                                    <c:if test="${contrato.getId_abogado() == usuario.id}">
                                                                        ${usuario.nombres} ${usuario.paterno}
                                                                    </c:if>

                                                                </c:if>
                                                            </c:forEach>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="form-group col-md-6 text-left">
                                                            <label for="Plan">Plan de Pago: </label>
                                                            <c:forEach var="ppago" items="${ppagos}">  
                                                                <c:if test="${contrato.getId_plan_pago() == ppago.id_Plan_Pago}">
                                                                    ${ppago.nombre}
                                                                </c:if>

                                                            </c:forEach>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="form-group col-md-6 text-left">
                                                            <label for="FPago">Forma de Pago: </label>
                                                            <c:if test="${contrato.getId_forma_pago() == '1'}">
                                                                Efectivo
                                                            </c:if>
                                                            <c:if test="${contrato.getId_forma_pago() == '2'}">
                                                                Cheque
                                                            </c:if>
                                                            <c:if test="${contrato.getId_forma_pago() == '3'}">
                                                                Crédito
                                                            </c:if>

                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="form-group text-left">
                                                            <div class="form-check">
                                                                <input class="form-check-input" readonly="readonly" type="checkbox" name="AprobadoCliente" id="AprobadoCliente" ${contrato.getAprobado_cliente() == '1' ? 'checked' : ''}>
                                                                <label class="form-check-label" for="ACliente" >
                                                                    Aprobado por Cliente
                                                                </label>
                                                                <br>
                                                                <input class="form-check-input" readonly="readonly" type="checkbox" name="AprobadoAbogado" id="AprobadoAbogado" ${contrato.getAprobado_abogado() == '1' ? 'checked' : ''}>
                                                                <label class="form-check-label" for="AAbogado">
                                                                    Aprobado por Abogado
                                                                </label>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <input type="hidden"  name="id" value="${contrato.getId_contrato()}"/>

                                                    <input type="hidden" class="btn btn-primary" name="accion" value="Guardar">

                                                    <input type="button" class="btn btn-warning" name="Cancelar" value="Volver" onClick="location.href = '/Lex/contratos'">

                                                </form>
                                            </div>


                                        </center>
                                        </tbody>


                                    </table>
                                </div>
                            </div>
                        </div>
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



