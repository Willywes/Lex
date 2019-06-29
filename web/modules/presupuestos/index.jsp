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
            <div id="main-box"class="col-md-12">
                <div class="row">
                    <div class="col-md-12">
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">Presupuestos</h3>
                            </div>
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <table id="table" class="table table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>Nº Presupuesto</th>
                                                    <th>Fecha</th>
                                                    <th>Cliente</th>
                                                    <th>Estado</th>
                                                    <th>Técnico</th>
                                                    <c:if test="${usuarioDTO.id_rol == 1 || usuarioDTO.id_rol == 2 || usuarioDTO.id_rol == 3}">
                                                        <th>Acciones</th>
                                                    </c:if>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="presupuesto" items="${presupuestos}">
                                                    <c:if test="${usuarioDTO.id_rol == 1 || usuarioDTO.id_rol == 2|| usuarioDTO.id_rol == 4 || usuarioDTO.id_rol == 5}">
                                                        <c:if test="${presupuesto.usuario.id == presupuesto.solicitud.id_cliente}">
                                                            <tr>
                                                                <td>${presupuesto.presupuestoDTO.id_presupuesto}</td>
                                                                <td>${presupuesto.presupuestoDTO.fecha}</td>
                                                                <td>${presupuesto.usuario.nombres} ${presupuesto.usuario.paterno}</td>
                                                                <td> <span class="badge bg-gray">${presupuesto.presupuestoEstado.nombre}</span> </td>
                                                                <td>${presupuesto.tecnico.nombres}</td>
                                                                <c:if test="${usuarioDTO.id_rol == 1 || usuarioDTO.id_rol == 2 || usuarioDTO.id_rol == 3}">
                                                                    <td>
                                                                        <button type="button" class="btn btn-info btn-sm" style="float: left; margin: 1px 1px 1px auto;" data-toggle="modal" data-target="#modal-info-${presupuesto.presupuestoDTO.id_presupuesto}" ><i class="fa fa-eye"></i></button>

                                                                        <form action="/Lex/presupuestos/modificar" method="get" style="float: left; margin: 1px 1px 1px auto;" >
                                                                            <input type="hidden" name="idSolicitud" value="${presupuesto.solicitud.id_solicitud}" />
                                                                            <button type="submit" class="btn btn-warning btn-sm" title="Editar"  >
                                                                                <i class="fa fa-edit"></i>
                                                                            </button>
                                                                            <input type="hidden" name="idPresupuesto" value="${presupuesto.presupuestoDTO.id_presupuesto}"  />
                                                                        </form>
                                                                        
                                                                        <form action="/Lex/contratos/crear" method="GET" style="float: left; margin: 1px 1px 1px auto;" >
                                                                            <input type="hidden" name="id" value="${presupuesto.presupuestoDTO.id_presupuesto}" />
                                                                            <button type="submit" class="btn btn-sm btn-success">Crear Contrato</button>
                                                                        </form>
                                                                    </td>
                                                                </c:if>
                                                            </tr>
                                                        </c:if>
                                                    </c:if>
                                                    <c:if test="${usuarioDTO.id_rol == 3}">
                                                            <tr>
                                                                <td>${presupuesto.presupuestoDTO.id_presupuesto}</td>
                                                                <td>${presupuesto.presupuestoDTO.fecha}</td>
                                                                <td>${presupuesto.usuario.nombres} ${presupuesto.usuario.paterno}</td>
                                                                <td> <span class="badge bg-gray">${presupuesto.presupuestoEstado.nombre}</span> </td>
                                                                <td>${presupuesto.tecnico.nombres}</td>
                                                                    <td>
                                                                        <button type="button" class="btn btn-info btn-sm" style="float: left; margin: 1px 1px 1px auto;" data-toggle="modal" data-target="#modal-info-${presupuesto.presupuestoDTO.id_presupuesto}" ><i class="fa fa-eye"></i></button>

                                                                        <form action="/Lex/presupuestos/modificar" method="get" style="float: left; margin: 1px 1px 1px auto;" >
                                                                            <input type="hidden" name="idSolicitud" value="${presupuesto.solicitud.id_solicitud}" />
                                                                            <button type="submit" class="btn btn-warning btn-sm" title="Editar"  >
                                                                                <i class="fa fa-edit"></i>
                                                                            </button>
                                                                            <input type="hidden" name="idPresupuesto" value="${presupuesto.presupuestoDTO.id_presupuesto}"  />
                                                                        </form>
                                                                        
                                                                        <form action="/Lex/contratos/crear" method="GET" style="float: left; margin: 1px 1px 1px auto;" >
                                                                            <input type="hidden" name="id" value="${presupuesto.presupuestoDTO.id_presupuesto}" />
                                                                            <button type="submit" class="btn btn-sm btn-success">Crear Contrato</button>
                                                                        </form>
                                                                   </td>
                                                            </tr>
                                                    </c:if>        
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>



        <!-- /.modal-dialog -->
        <c:forEach var="presupuesto" items="${presupuestos}">
            <div class="modal modal-info fade" id="modal-info-${presupuesto.presupuestoDTO.id_presupuesto}"  style="display: none;">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">×</span></button>
                            <h4 class="modal-title">Detalle Presupuesto</h4>
                        </div>
                        <div class="modal-body">
                            <!--presupuesto-->
                            <div class="row" >
                                <div class="col-md-12">
                                    <div class="box box-solid">
                                        <div class="box-header with-border">
                                            <h3 class="box-title">Presupuesto N° ${presupuesto.presupuestoDTO.id_presupuesto} </h3>
                                        </div>
                                        <!-- /.box-header -->
                                        <div class="box-body">
                                            <div class="box-group" id="accordion">
                                                <!-- we are adding the .panel class so bootstrap.js collapse plugin detects it -->
                                                <div class="panel box box-primary">
                                                    <div class="box-header with-border">
                                                        <h4 class="box-title">
                                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse-${presupuesto.presupuestoDTO.id_presupuesto}-1" aria-expanded="false" class="collapsed">
                                                                Ver Presupuesto
                                                            </a>
                                                        </h4>
                                                    </div>
                                                    <div id="collapse-${presupuesto.presupuestoDTO.id_presupuesto}-1" class="panel-collapse collapse text-black" aria-expanded="false" style="height: 0px;">
                                                        <div class="box-body">
                                                            <dl>
                                                                <dt>Identificador de presupuesto</dt>
                                                                <dd>${presupuesto.presupuestoDTO.id_presupuesto}</dd>
                                                                <dt>Fecha</dt>
                                                                <dd>${presupuesto.presupuestoDTO.fecha}</dd>
                                                                <dt>Estado</dt>
                                                                <dd>${presupuesto.presupuestoEstado.nombre}</dd>
                                                            </dl>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="panel box box-danger">
                                                    <div class="box-header with-border">
                                                        <h4 class="box-title">
                                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse-${presupuesto.presupuestoDTO.id_presupuesto}-2" class="collapsed" aria-expanded="false">
                                                                Ver Cliente
                                                            </a>
                                                        </h4>
                                                    </div>
                                                    <div id="collapse-${presupuesto.presupuestoDTO.id_presupuesto}-2" class="panel-collapse collapse text-black" aria-expanded="false" style="height: 0px;">
                                                        <div class="box-body">
                                                            <dl>
                                                                <dt>Rut</dt>
                                                                <dd>${presupuesto.usuario.rut}</dd>
                                                                <dt>Nombre</dt>
                                                                <dd>${presupuesto.usuario.nombres} ${presupuesto.usuario.paterno}</dd>
                                                                <dt>Telefono</dt>
                                                                <dd>${presupuesto.usuario.telefono}</dd>
                                                                <dt>Correo</dt>
                                                                <dd>${presupuesto.usuario.email}</dd>
                                                            </dl>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="panel box box-success">
                                                    <div class="box-header with-border">
                                                        <h4 class="box-title">
                                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse-${presupuesto.presupuestoDTO.id_presupuesto}-3" class="" aria-expanded="true">
                                                                Ver Solicitud y Plan de pago
                                                            </a>
                                                        </h4>
                                                    </div>
                                                    <div id="collapse-${presupuesto.presupuestoDTO.id_presupuesto}-3" class="panel-collapse collapse in text-black " aria-expanded="true" style="">
                                                        <div class="box-body">
                                                            <dl>
                                                                <dt>Tipo de Solicitud</dt>
                                                                <dd>${presupuesto.tipoSolicitud.nombre}</dd>
                                                                <dt>Descripción</dt>
                                                                <dd>${presupuesto.solicitud.descripcion}</dd>
                                                                <dt>Plan de Pago</dt>
                                                                <dd>${presupuesto.presupuestoPlanPago.nombre}</dd>
                                                                <dt>Tecnico</dt>
                                                                <dd>${presupuesto.tecnico.nombres}</dd>
                                                            </dl>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- /.box-body -->
                                    </div>
                                    <!-- /.box -->
                                </div>
                            </div>
                            <!--presupuesto-->

                            <div class="row" >
                                <div class="col-md-12">
                                    <div class="box box-default collapsed-box box-solid">
                                        <div class="box-header with-border">
                                            <h3 class="box-title">Ver Servicios</h3>

                                            <div class="box-tools pull-right">
                                                <button type="button" onclick="detalle(${presupuesto.presupuestoDTO.id_presupuesto})" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i>
                                                </button>
                                            </div>
                                            <!-- /.box-tools -->
                                        </div>
                                        <!-- /.box-header -->
                                        <div class="box-body text-black" id="detallePresupuestoActivo-${presupuesto.presupuestoDTO.id_presupuesto}" >

                                        </div>
                                        <!-- /.box-body -->
                                    </div>
                                    <!-- /.box -->
                                </div>
                            </div>
                            <!--servicios -->
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-outline pull-left" data-dismiss="modal">Cerrar</button>
                        </div>
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.modal-dialog -->
            </div>
        </c:forEach>


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

        <script src="https://unpkg.com/axios/dist/axios.min.js"></script>

        <script type="text/javascript" >
                                                    function detalle(idPresupuesto) {
                                                        document.getElementById("detallePresupuestoActivo-" + idPresupuesto).innerHTML = "";
                                                        axios.get('http://localhost:8080/Lex/PresupuestoDetalleWebService?idPresupuesto=' + idPresupuesto)
                                                                .then(function (response) {
                                                                    if (response.data[0].length != 0) {
                                                                        for (var i = 0; i < response.data[0].length; i++) {
                                                                            $('#detallePresupuestoActivo-' + idPresupuesto).append($('<dt>Nombre del servicio</dt> ' +
                                                                                    ' <dd> ' + response.data[0][i].servicio + ' </dd> ' +
                                                                                    ' <dt>Monto</dt> <dd>' + response.data[0][i].monto + '</dd>  <hr/>'));


                                                                        }
                                                                    } else {
                                                                        $('#detallePresupuestoActivo-' + idPresupuesto).append($('<div class="alert alert-danger" >Sin servicios disponibles</div>'));
                                                                    }
                                                                })
                                                                .catch(function (error) {
                                                                    // handle error
                                                                    console.log(error);
                                                                })
                                                                .finally(function () {
                                                                    // always executed
                                                                });
                                                    }
        </script>

        

    </jsp:attribute>
</t:template>
