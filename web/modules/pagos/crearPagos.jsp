<%@page import="Models.DTO.ContratoDTO"%>
<%@page import="Models.DAO.ContratoDAO"%>
<%@page import="java.util.List"%>
<%@page import="Models.DTO.PagoDTO"%>
<%@page import="Models.DAO.PagoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template>
    <jsp:attribute name="title">
        Gestión de Pago
    </jsp:attribute>
    <jsp:attribute name="subtitle">
        Crear Pago
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
                    <div class="box-body">
                        <div class="<c:out value="${ mensaje == 'exito' ? 'alert alert-success' : ''  }" />" >
                            <p> <c:out value="${ mensaje == 'exito' ? 'Agregado con Exito' : ''  }" /> </p>
                        </div>
                        <div class="<c:out value="${ mensaje == 'get' ? 'alert alert-danger' : ''  }" />" >
                            <p> <c:out value="${ mensaje == 'get' ? 'Error desconocido' : ''  }" /> </p>
                        </div>
                        
                       
                        <form action="crear" method="POST" >
                           

                            <div class="row">
                                
                                 <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="fecha">Fecha (*)</label>
                                        <input required type="date" class="form-control" id="fecha" name="fecha" placeholder="Ingrese Fecha">
                                    </div>
                                </div>
                                
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="contrato">Contrato (*)</label>
                                        <select required name="contrato" class="form-control">
                                            <option value="" >Seleccione una Opción</option>
                                            <c:forEach var="contrato" items="${contratos}">
                                                <option value="${contrato.id_contrato}"> ${contrato.id_contrato}</option>
                                            </c:forEach>
                                        </select>                                    
                                    </div>
                                </div>


                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="monto">Monto (*)</label>
                                        <input required type="number" class="form-control" name="monto" placeholder="Ingrese Monto">
                                    </div>
                                </div>

                                <div class="col-md-12"><hr></div>
                            </div>
                            
                            
                            <button type="submit" class="btn bt-primary">Crear Pago</button>
                        </form>
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