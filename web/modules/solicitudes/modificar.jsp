<%@page import="Models.DTO.SolicitudDTO"%>
<%@page import="Models.DAO.SolicitudDAO"%>
<%@page import="Models.DTO.UsuarioDTO"%>
<%@page import="Models.DAO.UsuarioDAO"%>
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
        Gestión de Solicitudes
    </jsp:attribute>
    <jsp:attribute name="subtitle">
        Modificar Solicitud
    </jsp:attribute>

    <jsp:attribute name="content">
        <form action="/Lex/solicitudes/actualizar" method="POST" class="form-horizontal" role="form">
            <div class="form-group">
                <label for="inputSolicitud" class="col-sm-2 control-label" >Nº Solicitud</label>
                <div class="col-sm-10">
                    <input  readonly type="text" class="form-control" id="id_solicitud" value="${solicitudes.getId_solicitud()}">
                </div>
            </div>
            <div class="form-group">
                <label for="inputSolicitud" class="col-sm-2 control-label" >Fecha Solicitud</label>
                <div class="col-sm-10">
                    <input  readonly type="text" class="form-control" id="fechasolicitud" value="${solicitudes.getFecha_hora()}">
                </div>
            </div>
            <div class="form-group">
                <label readonly for="inputSolicitud" class="col-sm-2 control-label" >Descripcion</label>
                <div class="col-sm-10">
                    <textarea readonly class="form-control" rows="3" id="descripcion">${solicitudes.getDescripcion()}</textarea>
                </div>
            </div>
            <div class="form-group"><%-- cambiar select  --%>


                <label for="inputSolicitud" class="col-sm-2 control-label" >Tipo de Solicitud</label>
                <div class="col-sm-10">
                    <input readonly type="text" class="form-control" id="tipo" value="${solicitudes.getTipoSolicitud().getNombre()}">
                </div>
            </div>
            <div class="form-group">
                <label  for="inputSolicitud" class="col-sm-2 control-label" >Estado de Solicitud</label>
                <div class="col-sm-10">
                    <select id="selectestadoSolicitudes" name="selectestadoSolicitudes" requerid class="form-control">
                        <option selected>Seleccione...</option>                                                
                        <c:forEach var="estadoSolicitudes" items="${estadoSolicitudes}">
                            <option value="${estadoSolicitudes.getId_estado_solicitud()}">${estadoSolicitudes.nombre}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="inputSolicitud" class="col-sm-2 control-label" >Cliente</label>
                <div class="col-sm-10">
                    <input  readonly type="text" class="form-control" id="cliente" value="${solicitudes.getCliente().getNombres()} ${solicitudes.getCliente().getPaterno()}">
                </div>
            </div>
            <div class="form-group">
                <label for="inputSolicitud" class="col-sm-2 control-label" >Tecnico</label>
                <div class="col-sm-10">
                    <input  readonly type="text" class="form-control" id="tecnico" value="${solicitudes.getTecnico().getNombres()} ${solicitudes.getTecnico().getPaterno()}">
                </div>
            </div>

            <div class="col-md-12 text-rigth">
               <input type="submit" class="btn btn-primary" name="accion" value="Guardar">
               <input type="hidden" name="id" value="${solicitudes.getId_solicitud()}"/>

                
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

