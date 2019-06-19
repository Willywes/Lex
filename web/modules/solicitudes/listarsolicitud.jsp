<%-- 
    Document   : listarsolicitud
    Created on : 16-06-2019, 17:47:39
    Author     : claudio
--%>

<%@page import="Models.DTO.CitaDTO"%>
<%@page import="Models.DAO.CitaDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template>

    <jsp:attribute name="title">
        Gestión de Solicitudes
    </jsp:attribute>
    <jsp:attribute name="subtitle">
        Ver Solicitud
    </jsp:attribute>


    <jsp:attribute name="styles">
        <link rel="stylesheet" href="/Lex/assets/bootstraptable/dragtable.css">
        <link rel="stylesheet" href="/Lex/assets/bootstraptable/bootstrap-table-reorder-rows.css">
        <link rel="stylesheet" href="/Lex/assets/bootstraptable/bootstrap-table-fixed-columns.css">
        <link rel="stylesheet" href="/Lex/assets/bootstraptable/bootstrap-table.min.css">
    </jsp:attribute>

    <jsp:attribute name="content">
    <form class="form-horizontal" role="form">
            <div class="form-group">
                <label for="inputSolicitud" class="col-sm-2 control-label" >Nº Solicitud</label>
                <div class="col-sm-10">
                    <input  readonly type="text" class="form-control" id="inputEmail3" value="${solicitudes.getId_solicitud()}">
                </div>
            </div>
            <div class="form-group">
                <label for="inputSolicitud" class="col-sm-2 control-label" >Fecha Solicitud</label>
                <div class="col-sm-10">
                    <input  readonly type="text" class="form-control" id="inputFecha" value="${solicitudes.getFecha_hora()}">
                </div>
            </div>
            <div class="form-group">
                <label for="inputSolicitud" class="col-sm-2 control-label" >Descripcion</label>
                <div class="col-sm-10">
                    <textarea readonly class="form-control" rows="3">${solicitudes.getDescripcion()}</textarea>
                </div>
            </div>
            <div class="form-group">
                <label for="inputSolicitud" class="col-sm-2 control-label" >Tipo de Solicitud</label>
                <div class="col-sm-10">
                    <input  readonly type="text" class="form-control" id="inputEmail3" value="${solicitudes.getTipoSolicitud().getNombre()}">
                </div>
            </div>
            <div class="form-group">
                <label for="inputSolicitud" class="col-sm-2 control-label" >Estado de Solicitud</label>
                <div class="col-sm-10">
                    <input  readonly type="text" class="form-control" id="inputEmail3" value="${solicitudes.getEstadoSolicitud().getNombre()}">
                </div>
            </div>
            <div class="form-group">
                <label for="inputSolicitud" class="col-sm-2 control-label" >Cliente</label>
                <div class="col-sm-10">
                    <input  readonly type="text" class="form-control" id="inputEmail3" value="${solicitudes.getCliente().getNombres()} ${solicitudes.getCliente().getPaterno()}">
                </div>
            </div>
            <div class="form-group">
                <label for="inputSolicitud" class="col-sm-2 control-label" >Tecnico</label>
                <div class="col-sm-10">
                    <input  readonly type="text" class="form-control" id="inputEmail3" value="${solicitudes.getTecnico().getNombres()} ${solicitudes.getTecnico().getPaterno()}">
                </div>
            </div>

           <div class="col-md-12 text-rigth">
                <a class="btn btn-warning btn-sm" title="Editar" href="actualizar?id=${solicitudes.getId_solicitud()}">
                    <i class="fa fa-edit"></i> Editar
                </a> 
                <form action="../presupuestos/crear" method="GET">
                    <input type="hidden" name="idSolicitud" value="${solicitudes.getId_solicitud()}" />
                    <button class="btn btn-success btn-sm" title="Cotizar"><i class="fa fa-dollar"></i> Cotizar</button>
                </form>
                <a class="btn btn-danger btn-sm" title="Eliminar" href="borrar?id=${solicitudes.getId_solicitud()}">
                    <i class="fa fa-trash"></i> Eliminar
                </a> 
            </div>
        </form>
    </jsp:attribute>

    <jsp:attribute name="scripts">
        <!-- DataTables -->
        <script src="/Lex/assets/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
        <script src="/Lex/assets/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    </jsp:attribute>
</t:template>