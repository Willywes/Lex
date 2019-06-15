<%-- 
    Document   : index pagos
    Created on : 08-jun-2019, 22:20:49
    Author     : Funny
--%>


<%@page import="Models.DTO.PagoDTO"%>
<%@page import="Models.DAO.PagoDAO"%>
<%@page import="java.util.List"%>
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
                    <div class="box-header with-border">
                        <div  class="btn-group">
                            <a class="btn btn-success" href="presupuestos/crear"> <!--data-toggle="modal" data-target="#modal-create"--><i
                                    class="fa fa-plus"></i> Nuevo Pago
                            </a>
                        </div>
                    </div>
                    <div class="box-body">
                        <form action="/Lex/pagos" method="get" style="float: left; margin: 1px 1px 1px auto;" >
                            Contrato: <input  type="number" name="idContrato"  />
                            <button type="submit" class="btn btn-info btn-sm" title="Buscar"  >
                                <i class="fa fa-search"></i>
                            </button>
                        </form>
                        <table id="table" class="table table-bordered table-hover">
                            <thead>

                                <tr>
                                    <th style="width:1%;white-space: nowrap;">N° Pago</th>
                                    <th style="width:1%;white-space: nowrap;">Fecha</th>
                                    <th style="width:1%;white-space: nowrap;">Monto</th>
                                    <th style="width:1%;white-space: nowrap;">Contrato</th> 
                                    <th style="width:1%;white-space: nowrap;"></th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach var="pago" items="${pagos}">

                                    <tr>
                                        <td>${pago.id_pago}</td>
                                        <td>${pago.fecha_hora}</td> 
                                        <td>${pago.monto}</td>
                                        <td>${pago.id_contrato}</td>

                                        <td style="width:1%;white-space: nowrap;">


                                            <form action="/Lex/pagos/modificar" method="get" style="float: left; margin: 1px 1px 1px auto;" >
                                                <button type="submit" class="btn btn-warning btn-sm" title="Editar"  >
                                                    <i class="fa fa-edit"></i>
                                                </button>
                                                <input type="hidden" name="idPago" value="${pago.id_pago}"  />
                                            </form>

                                            <form action="/Lex/pagos" method="post" style="float: left; margin: 1px 1px 1px auto;">
                                                <button type="submit" class="btn btn-danger btn-sm" title="Eliminar"  >
                                                    <i class="fa fa-trash"></i>
                                                </button>
                                                <input type="hidden" name="idPago" value="${pago.id_pago}"  />
                                            </form>

                                        </td>
                                    </tr>
                                </c:forEach>
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
