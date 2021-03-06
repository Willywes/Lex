<%-- 
    Document   : editpresupuesto
    Created on : 26-05-2019, 21:04:18
    Author     : Funny
--%>
<%!  int cont = 1;%>

<%@page import="Models.DTO.PresupuestoDTO"%>
<%@page import="Models.DAO.PresupuestoDAO"%>
<%@page import="Models.DTO.PresupuestoDetalleDTO"%>
<%@page import="Models.DAO.PresupuestoDetalleDAO"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template>
    <jsp:attribute name="title">
        Gestión de Presupuestos
    </jsp:attribute>
    <jsp:attribute name="subtitle">
        Actualizar Presupuesto
    </jsp:attribute>
    <jsp:attribute name="styles">
        <link rel="stylesheet" href="/Lex/assets/bootstraptable/dragtable.css">
        <link rel="stylesheet" href="/Lex/assets/bootstraptable/bootstrap-table-reorder-rows.css">
        <link rel="stylesheet" href="/Lex/assets/bootstraptable/bootstrap-table-fixed-columns.css">
        <link rel="stylesheet" href="/Lex/assets/bootstraptable/bootstrap-table.min.css">
    </jsp:attribute>

    <jsp:attribute name="content">

        <%@include file="/modules/globals/alerts.jsp" %>


        <div class="row">
            <div class="col-md-12">
                <div class="box box-info">
                    <div class="box-header with-border">
                        <h3 class="box-title">Nuevo Presupuesto ${solicitud.cliente.nombres}</h3>
                    </div>
                    <div class="box-body">
                        <form action="<c:url value = "/presupuestos/modificar"/>" method="POST" >
                            <div class="row">
                                <div class="col-md-12">
                                    <table class="table table table-bordered">
                                        <tbody>
                                            <tr>
                                                <th>Rut</th>
                                                <th>Nombre</th>
                                                <th>Telefono</th>
                                                <th>Email</th>
                                            </tr>
                                            <tr>
                                                <td>${solicitud.cliente.rut}</td>
                                                <td>${solicitud.cliente.nombres}${solicitud.cliente.paterno}</td>
                                                <td>${solicitud.cliente.telefono}</td>
                                                <td>${solicitud.cliente.email}</td>
                                            </tr>
                                            <tr>
                                                <th colspan="2" style="width: 30%;">Tipo de Solicitud</th>
                                                <td>${solicitud.tipoSolicitud.nombre}</td>
                                            </tr>
                                            <tr>
                                                <th colspan="2">Descripcion</th>
                                                <td>
                                                    ${solicitud.descripcion}
                                                </td>
                                            </tr>
                                            <tr>
                                                <th colspan="2" style="width: 30%;">Técnico</th>
                                                <td>${solicitud.tecnico.nombres} ${solicitud.tecnico.paterno}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="">Plan de pago</label>
                                        <select required="" class="form-control" name="plan_pago" id="">
                                            <c:forEach  var="planPago" items="${planPagos}">
                                                <option ${presupuesto.id_plan_pago == planPago.getId_Plan_Pago() ? 'selected':''}   value="${planPago.getId_Plan_Pago()}"> ${planPago.getNombre()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="">Estado</label>
                                        <select required class="form-control" name="estado" id="">
                                            <c:forEach var="estado" items="${estadosPresupuestos}">
                                                <option ${presupuesto.id_estado_presupuesto == estado.id_estado_presupuesto ? 'selected':''} ${estado.id_estado_presupuesto == 1 ? 'disabled':''}    value="${estado.id_estado_presupuesto}"> ${estado.nombre}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-12" id="servicios">

                                <c:forEach var="detalle" items="${detalles}" >

                                    <div id="" class="row" ${(cont = cont+1)} >
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="">Servicio</label>
                                                <input required type="text" value="${detalle.servicio}" class="form-control" name="servicio${cont}" id="servicio">
                                            </div>
                                        </div>   
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label for="">Monto</label>
                                                <input required type="number" value="${detalle.monto}" class="form-control" name="monto${cont}" id="monto">   
                                            </div>
                                        </div>
                                        <input type="hidden" name="detalleService${cont}" value="${detalle.id_detalle_presupuesto}"  />
                                    </div>
                                </c:forEach>
                                <input value="${cont}" name="catidadDetalles"  type="hidden" />
                            </div>

                            <div class="row">
                                <div class="col-md-2">
                                    <button class="btn btn-primary" type="submit" ><i class="fa fa-save"></i> Guardar</button>
                                </div>
                                <div class="col-md-2">
                                    <button type="button" onclick="addServicio()" class="btn btn-success"><i class="fa fa-plus"></i> Nuevo Servicio</button>
                                </div>
                                <div class="col-md-1">
                                    <a class="btn btn-primary" href="/Lex/presupuestos" > Volver</a>
                                </div>
                            </div>

                            <input type="hidden" id="cantidad" value="0"  name="cantidadDetalle" />
                            <input type="hidden"  value="${solicitud.id_solicitud}" name="idSolicitud" />
                            <input type="hidden" value="${presupuesto.id_presupuesto}" name="idPresupuesto">
                            <input type="hidden"  value="${solicitud.tecnico.id}" name="idTecnico" />
                            <input type="hidden" id="cantidadDetalleAgregar" value="0"  name="cantidadDetalleAgregar" />
                        </form>
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
    <script src="/Lex/assets/custom/rut.js"></script>

    <script type="text/javascript" >
                                        var cont = 0;
    </script>
    <script>



        $(document).ready(function () {
            /* $('.removeButton').on('click', function(){
             
             console.log($(this).parent());
             $(this).parent().remove();
             }); */
        })

        function deleteElem(elem) {
            var elimiando = $(elem).closest('.row')[0].id;
            var t = 1;
            var cambio = 1;
            for (var i = 0; i < cont; i++) {
                if (elimiando != t) {
                    document.getElementById("servicioAgregar" + t).name = "servicioAgregar" + cambio;
                    document.getElementById("servicioAgregar" + t).id = "servicioAgregar" + cambio;
                    document.getElementById("montoAgregar" + t).name = "montoAgregar" + cambio;
                    document.getElementById("montoAgregar" + t).id = "montoAgregar" + cambio;
                    document.getElementById(t).id = cambio;
                    cambio++;
                }
                t++;
            }

            cont = cont - 1;

            document.getElementById("cantidadDetalleAgregar").value = cont

            $(elem).closest('.row').remove();

            //var d = 1;
            //for (var i = 0; i < cont; i++) {
            //  console.log(document.getElementById("servicio" + d));
            // d++;
            //}



            //console.log(elimiando);



            //document.getElementById("cantidad").value = cont;
        }
        function addServicio() {
            cont++;
            $('#servicios').append($('<div id="' + cont + '" class="row">\n' +
                    '                                        <div class="col-md-9">\n' +
                    '                                            <div class="form-group">\n' +
                    '                                                <label for="">Servicio</label>\n' +
                    '                                                <input type="text" required class="form-control" name="servicioAgregar' + (cont) + '" id="servicioAgregar' + (cont) + '">\n' +
                    '                                            </div>\n' +
                    '                                        </div>\n' +
                    '                                        <div class="col-md-2">\n' +
                    '                                            <div class="form-group">\n' +
                    '                                                <label for="">Monto</label>\n' +
                    '                                                <input required type="number" class="form-control" name="montoAgregar' + (cont) + '" id="montoAgregar' + (cont) + '">\n' +
                    '                                            </div>\n' +
                    '                                        </div>\n' +
                    '                                        <div class="col-md-1">\n' +
                    '                                            <button type="button" onclick="deleteElem(this);" style="margin-top: 24px;" class="btn btn-danger removeButton"><i class="fa fa-trash"></i></button>\n' +
                    '                                        </div>\n' +
                    '                                    </div>'));
            document.getElementById("cantidadDetalleAgregar").value = cont;
        }



    </script>  


</jsp:attribute>
</t:template>