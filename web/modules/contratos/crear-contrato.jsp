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
                        <h3 class="box-title">Nuevo Contrato</h3>
                    </div>
                    
                    <div class="box-body">
                            <div class="row">
                                <div class="col-md-12">
                                    <table class="table table table-bordered">
                                        <tbody>
                                        <tr>
                                            <th>N° de Presupuesto</th>
                                            <th>Plan de Pago</th>
                                        </tr>
                                        <tr>
                                            <td>${presupuesto.getIdPresupuesto()}</td>
                                            
                                            
                                            <c:forEach var="ppago" items="${ppagos}">
                                                <c:if test="${ppago.id_Plan_Pago == presupuesto.idPlanPago}">
                                                    <td>${ppago.nombre} </td>
                                                </c:if>
                                                
                                            </c:forEach>
                                          
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                    
                    <div class="box-body">
                        <table id="table" class="table table-bordered table-hover">

                            <tbody>
                            <center>
                                

                                <div>
                                    <form action="/Lex/contratos/crear" method="POST">

                                        <div class="row">
                                            <div class="col-md-4">
                                                <div class="form-group text-left" >
                                                    <label for="FechaInicio">Fecha de Inicio</label>
                                                    <input type="Date" max="2019-06-25" class="form-control" id="FechaInicio" name="FechaInicio" placeholder="FechaInicio" required>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-4">
                                                <div class="form-group text-left">
                                                    <label for="FechaTermino">Fecha de Término</label>
                                                    <input type="Date" min="2019-06-26" class="form-control" id="FechaTermino" name="FechaTermino" placeholder="FechaTermino" required>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="form-group col-md-4 text-left">
                                                <label for="Rol_causa">Rol Causa</label>
                                                <input type="text" maxlength="10" class="form-control" id="FechaTermino" name="Rol_causa" placeholder="Rol">
                                            </div>
                                        </div>
                                        <div class="row">
                                        <div class="form-group col-md-4 text-left">
                      
                                                <input type="hidden" id="selectEstados" name="selectEstados" value="1"></input>
                                                
                                            </select>
                                        </div>
                                        </div>
                                       
                                        <div class="row">
                                        <div class="form-group col-md-6">
                                            
                                           
                                            
                                            <input type="hidden" id="selectPresupuesto" name="selectPresupuesto" value="${presupuesto.getIdPresupuesto()}"></input>
                                            
                                       
                                        </div>
                                        </div>
                                            <div class="row">
                                        <div class="form-group col-md-6 text-left">
                                            <label for="Abogado">Abogado</label>
                                            <select id="selectAbogado" name="selectAbogado" class="form-control" required>
                                                <option selected value="">Seleccione...</option>                                                
                                                <c:forEach var="usuario" items="${usuarios}">
                                                    <c:if test="${usuario.id_rol == 1 or usuario.id_rol == 2}">
                                                        <option value="${usuario.id}">${usuario.nombres} ${usuario.paterno}</option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        </div>
                                            <div class="row">
                                        <div class="form-group col-md-6">
                                            <input type="hidden" id="selectPlan" name="selectPlan" value="${presupuesto.getIdPlanPago()}"></input>
                                            
                                        </div>
                                        </div>
                                        
                                            <div class="row">
                                        <div class="form-group col-md-6 text-left">
                                            <label for="FPago">Forma de Pago</label>
                                            <select id="FormaPago" name="FormaPago" class="form-control" required>
                                                <option  selected value="">Seleccione...</option>
                                                <option value="1">Efectivo</option>
                                                <option value="2">Cheque</option>
                                                <option value="3">Crédito</option>
                                            </select>
                                        </div>
                                        </div>
                                            <div class="row">
                                        <div class="form-group">
                                            <div class="form-check text-left">
                                                <input class="form-check-input" type="checkbox" name="AprobadoCliente" id="AprobadoCliente">
                                                <label class="form-check-label" for="ACliente">
                                                    Aprobado por Cliente
                                                </label>
                                                <br>
                                                <input class="form-check-input" type="checkbox" name="AprobadoAbogado" id="AprobadoAbogado">
                                                <label class="form-check-label" for="AAbogado">
                                                    Aprobado por Abogado
                                                </label>
                                            </div>
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



