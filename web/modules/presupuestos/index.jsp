<%-- 
    Document   : index
    Created on : 19-04-2019, 20:43:45
    Author     : Funny
--%>

<%@page import="Models.DTO.PresupuestoDTO"%>
<%@page import="Models.DAO.PresupuestoDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template>
    <jsp:attribute name="title">
        Gestión de Presupuestos
    </jsp:attribute>
    <jsp:attribute name="subtitle">
        Listar Presupuesto
    </jsp:attribute>
    <jsp:attribute name="styles">
        <link rel="stylesheet" href="/Lex/assets/bootstraptable/dragtable.css">
        <link rel="stylesheet" href="/Lex/assets/bootstraptable/bootstrap-table-reorder-rows.css">
        <link rel="stylesheet" href="/Lex/assets/bootstraptable/bootstrap-table-fixed-columns.css">
        <link rel="stylesheet" href="/Lex/assets/bootstraptable/bootstrap-table.min.css">

    </jsp:attribute>

    <jsp:attribute name="content">
        <div class="row">

            <div class="row">
                <div class="col-md-12">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">Presupuestos</h3>
                        </div>
                        <div class="box-body">
                            <div class="row">
                                <div class="col-md-12">
                                    <table class="table table table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Nº Presupuesto</th>
                                                <th>Fecha</th>
                                                <th>Cliente</th>
                                                <th>Estado</th>
                                                <th>Técnico</th>
                                                <th>Acciones</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td></td>
                                                <td></td>
                                                <td>${solicitudes.Cliente.Nombres}${solicitudes.Cliente.Paterno}</td>
                                                <td></td>
                                                <td>${solicitudes.Tecnico.Nombres}${solicitudes.Tecnico.Paterno}</td>
                                                <td>
                                                    <button class="btn btn-sm btn-info"><i class="fa fa-eye"></i></button>
                                                    <a href="presupuestos-mofidicar.html" class="btn btn-sm btn-warning"><i class="fa fa-edit"></i></a>
                                                    <button class="btn btn-sm btn-success">Crear Contrato</button>
                                                    <button class="btn btn-sm btn-info">Ver Solicitud</button>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--<div id="main-box"class="col-md-12">
            <div class="<c:out value="${ mensaje == 'get' ? '' : 'alert alert-success'  }" />" >
                <p> <c:out value="${ mensaje == 'get' ? '' : 'Eliminado con exito'  }" /> </p>
            </div>
            <div class="box box-primary">
                <div class="box-header with-border">
                    <div  class="btn-group">
                        <a class="btn btn-success" href="presupuestos/crear"> <!--data-toggle="modal" data-target="#modal-create"-->
        <!--<i class="fa fa-plus"></i> Nuevo Presupuesto
    </a>
</div>
</div>
<div class="box-body">
<table id="table" class="table table-bordered table-hover">
    <thead>
        <tr>
            <th style="width:1%;white-space: nowrap;">N° Presupuesto</th>
            <th style="width:1%;white-space: nowrap;">Nombre Cliente</th>
            <th style="width:1%;white-space: nowrap;">Apellido Cliente</th>
            <th style="width:1%;white-space: nowrap;">Correo Cliente</th>
            <th style="width:1%;white-space: nowrap;">Fecha</th>
            <th style="width:1%;white-space: nowrap;">Solicitud</th>
            <th style="width:1%;white-space: nowrap;">Servicio</th>
            <th style="width:1%;white-space: nowrap;">Estado</th>
            <th style="width:1%;white-space: nowrap;">Plan Pago</th>
            <th style="width:1%;white-space: nowrap;">Monto</th>

            <th style="width:1%;white-space: nowrap;"></th>
        </tr>
    </thead>
    <tbody>

        <c:forEach var="presupuesto" items="${presupuestos}">

            <tr>
                <td>${presupuesto.presupuestoDTO.id_presupuesto}</td>
                <td>${presupuesto.usuario.nombres}</td>
                <td>${presupuesto.usuario.paterno}</td>
                <td>${presupuesto.usuario.email}</td>
                <td>${presupuesto.presupuestoDTO.fecha}</td> 
                <td>${presupuesto.solicitud.descripcion}</td>
                <td>${presupuesto.presupuestoDetalle.servicio}</td>
                <td>${presupuesto.presupuestoEstado.nombre}</td>
                <td>${presupuesto.presupuestoPlanPago.nombre}</td>
                <td>${presupuesto.presupuestoDetalle.monto}</td>


                <td style="width:1%;white-space: nowrap;">


                    <form action="/Lex/presupuestos/modificar" method="get" style="float: left; margin: 1px 1px 1px auto;" >
                        <button type="submit" class="btn btn-warning btn-sm" title="Editar"  >
                            <i class="fa fa-edit"></i>
                        </button>
                        <input type="hidden" name="idPresupuesto" value="${presupuesto.presupuestoDTO.id_presupuesto}"  />
                    </form>

                    <form action="/Lex/presupuestos/eliminar" method="post" style="float: left; margin: 1px 1px 1px auto;">
                        <button type="submit" class="btn btn-danger btn-sm" title="Eliminar"  >
                            <i class="fa fa-trash"></i>
                        </button>
                        <input type="hidden" name="idPresupuesto" value="${presupuesto.presupuestoDTO.id_presupuesto}"  />
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

        <!--Data tables -->
        <script src="/Lex/assets/custom/dataTables.js" type="text/javascript"></script>

    </jsp:attribute>
</t:template>
