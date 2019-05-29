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
                <div class="box box-primary">
                    <div class="box-header with-border">

                    </div>
                    <div class="box-body">
                        <table id="table" class="table table-bordered table-hover">

                            <tbody>
                            <center>
                                <div>
                                    <h3>Agregar Contrato</h3>
                                </div>

                                <div>
                                    <form action="/Lex/contratos/guardar" method="POST">

                                        <div class="form-row">
                                            <div class="form-group col-md-4">
                                                <label for="FechaInicio">Fecha de Inicio</label>
                                                <input type="Date" class="form-control" id="FechaInicio" name="FechaInicio" placeholder="FechaInicio">
                                            </div>
                                            <div class="form-group col-md-4">
                                                <label for="FechaTermino">Fecha de Término</label>
                                                <input type="Date" class="form-control" id="FechaTermino" name="FechaTermino" placeholder="FechaTermino">
                                            </div>
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="estado">Estado</label>
                                            
                                            <select id="selectEstados" name="selectEstados" class="form-control">
                                                <option selected>Seleccione...</option>                                                
                                                <c:forEach var="estado" items="${estados}">
                                                <option value="${estado.id_contrato_estado}">${estado.nombre}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="Detalle">Detalle Servicio</label>
                                            
                                            <select id="selectDetalle" name="selectDetalle" class="form-control">
                                                <option selected>Seleccione...</option>                                                
                                                <c:forEach var="detalle" items="${detalles}">
                                                <option value="${detalle.id_detalle_contrato}">${detalle.servicio}   Valor:${detalle.monto}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="Presupuesto">N° Presupuesto Asociado</label>
                                            
                                            <select id="selectPresupuesto" name="selectPresupuesto" class="form-control">
                                                <option selected>Seleccione...</option>                                                
                                                <c:forEach var="presupuesto" items="${presupuestos}">
                                                <option value="${presupuesto.idPresupuesto}">${presupuesto.idPresupuesto}</option>
                                                </c:forEach>
                                            </select>
                                            
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="Abogado">Abogado</label>
                                            <select id="selectAbogado" name="selectAbogado" class="form-control">
                                                <option selected>Seleccione...</option>                                                
                                                <c:forEach var="usuario" items="${usuarios}">
                                                    <c:if test="${usuario.id_rol == 1 or usuario.id_rol == 2}">
                                                        <option value="${usuario.id}">${usuario.nombres} ${usuario.paterno}</option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                         
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="Plan">Plan de Pago</label>
                                            <select id="selectPlan" name="selectPlan" class="form-control">
                                                <option selected>Seleccione...</option>                                                
                                                <c:forEach var="ppago" items="${ppagos}">                                                    
                                                    <option value="${ppago.id_Plan_Pago}">${ppago.nombre}</option>                      
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="FPago">Forma de Pago</label>
                                            <select id="FormaPago" name="FormaPago" class="form-control">
                                                <option  selected>Seleccione...</option>
                                                <option value="1">Efectivo</option>
                                                <option value="2">Cheque</option>
                                                <option value="3">Crédito</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" id="AprobadoCliente">
                                                <label class="form-check-label" for="ACliente">
                                                    Aprobado por Cliente
                                                </label>
                                                <br>
                                                <input class="form-check-input" type="checkbox" id="AprobadoAbogado">
                                                <label class="form-check-label" for="AAbogado">
                                                    Aprobado por Abogado
                                                </label>
                                            </div>
                                        </div>
                                        
                                        

                                        <input type="submit" class="btn btn-primary" name="accion" value="Guardar">

                                        <input type="button" class="btn btn-danger" name="Cancelar" value="Cancelar" onClick="location.href = '/Lex/contratos'">

                                    </form>
                                </div>
                            </center>


                            </tbody>


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


