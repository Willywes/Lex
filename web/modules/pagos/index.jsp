<%-- 
    Document   : index pagos
    Created on : 08-jun-2019, 22:20:49
    Author     : Funny
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template>
    <jsp:attribute name="title">
        Gestión de Pagos
    </jsp:attribute>
    <jsp:attribute name="subtitle">
        Listar Pagos
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
                <div class="<c:out value="${ mensaje == 'get' ? '' : 'alert alert-success'  }" />" >
                    <p> <c:out value="${ mensaje == 'get' ? '' : 'Eliminado con exito'  }" /> </p>
                </div>

                <div class="box box-primary">
                    <!--
                    <form action="/Lex/pagos" method="get" class="mt-4 ml-4 mr-4 mb-4"  >
                        &nbsp; Contrato: <input  type="number" name="idContrato"  />
                        <button type="submit" class="btn btn-info btn-sm" title="Buscar"  >
                            <i class="fa fa-search"></i>
                        </button>
                    </form>
                    -->
                    <div class="box-body mt-">

                        <table id="table" class="table table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th >N° Pago</th>
                                    <th >Nombre Cliente</th> 
                                    <th >Correo Cliente</th> 
                                    <th >Fecha</th>
                                    <th >Monto</th>
                                    <th >N° Contrato</th> 
                                        <c:if test="${usuarioDTO.id_rol == 3}">
                                        <th >Acciones</th>
                                        </c:if>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach var="pago" items="${pagos}">

                                    <c:if test="${usuarioDTO.id_rol == 5 && pago.cliente.rut == usuarioDTO.rut}">
                                        <tr>
                                            <td>${pago.pago.id_pago}</td>
                                            <td>${pago.cliente.nombres} ${pago.cliente.paterno}</td>
                                            <td>${pago.cliente.email}</td>
                                            <td>${pago.pago.fecha_hora}</td> 
                                            <td>$ ${pago.pago.monto}</td>
                                            <td>${pago.pago.id_contrato}</td>

                                            <c:if test="${usuarioDTO.id_rol == 3}">
                                                <td>
                                                    <form action="/Lex/pagos/modificar" method="get" style="float: left; margin: 1px 1px 1px auto;" >
                                                        <button type="submit" class="btn btn-warning btn-sm" title="Editar"  >
                                                            <i class="fa fa-edit"></i>
                                                        </button>
                                                        <input type="hidden" name="idPago" value="${pago.pago.id_pago}"  />
                                                    </form>

                                                    <form action="/Lex/presupuesto/detalle" method="GET" style="float: left; margin: 1px 1px 1px auto;" >
                                                        <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#modal-danger-${pago.pago.id_pago}" >
                                                            <i class="fa fa-trash"></i> 
                                                        </button>
                                                    </form>
                                                </td>
                                            </c:if>
                                        </tr>
                                    </c:if>

                                    <c:if test="${usuarioDTO.id_rol == 3 || usuarioDTO.id_rol == 1 || usuarioDTO.id_rol == 2}">
                                        <tr>
                                            <td>${pago.pago.id_pago}</td>
                                            <td>${pago.cliente.nombres} ${pago.cliente.paterno}</td>
                                            <td>${pago.cliente.email}</td>
                                            <td>${pago.pago.fecha_hora}</td> 
                                            <td>$ ${pago.pago.monto}</td>
                                            <td>${pago.pago.id_contrato} </td>

                                            <c:if test="${usuarioDTO.id_rol == 3}">
                                                <td>
                                                    <form action="/Lex/pagos/modificar" method="get" style="float: left; margin: 1px 1px 1px auto;" >
                                                        <button type="submit" class="btn btn-warning btn-sm" title="Editar"  >
                                                            <i class="fa fa-edit"></i>
                                                        </button>
                                                        <input type="hidden" name="idPago" value="${pago.pago.id_pago}"  />
                                                    </form>

                                                    <form action="/Lex/presupuesto/detalle" method="GET" style="float: left; margin: 1px 1px 1px auto;" >
                                                        <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#modal-danger-${pago.pago.id_pago}" >
                                                            <i class="fa fa-trash"></i> 
                                                        </button>
                                                    </form>
                                                </td>
                                            </c:if>
                                        </tr>
                                    </c:if>
                                </c:forEach>
                            </tbody>
                        </table>

                        <c:forEach var="pago" items="${pagos}">
                            <c:if test="${usuarioDTO.id_rol == 3}">
                                <div class="modal modal-danger fade" id="modal-danger-${pago.pago.id_pago}" style="display: none;">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">×</span></button>
                                                <h4 class="modal-title">Eliminar El Pago Numero: ${pago.pago.id_pago} </h4>
                                            </div>
                                            <form action="/Lex/pagos" method="post">
                                                <div class="modal-body">
                                                    ¿Seguro que deseas eliminar el Pago?, Los datos serán irrecuperables una vez eliminado el pago. 
                                                </div>

                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-outline pull-left" data-dismiss="modal">Cerrar</button>
                                                    <button type="submit" class="btn btn-outline">Eliminar Pago</button>
                                                </div>
                                                <input type="hidden" name="idPago" value="${pago.pago.id_pago}"  />
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </jsp:attribute>

    <jsp:attribute name="scripts">
        <!-- DataTables -->
        <script src="/Lex/assets/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
        <script src="/Lex/assets/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>

        <!--Data tables --->
        <script src="/Lex/assets/custom/dataTables.js" type="text/javascript"></script>

    </jsp:attribute>
</t:template>
