<%-- 
    Document   : detallepresupuesto
    Created on : 01-07-2019, 23:03:15
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
        Detalle Presupuesto
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
                        <h3 class="box-title">Detalle Presupuesto ${solicitud.cliente.nombres}</h3>
                    </div>
                    <div class="box-body">
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
                                    <select required="" disabled="" class="form-control" name="plan_pago" id="">
                                        <c:forEach  var="planPago" items="${planPagos}">
                                            <option ${presupuesto.id_plan_pago == planPago.getId_Plan_Pago() ? 'selected':''}   value="${planPago.getId_Plan_Pago()}"> ${planPago.getNombre()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label for="">Estado</label>
                                    <select disabled="" required class="form-control" name="estado" id="">
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
                                            <input disabled="" required type="text" value="${detalle.servicio}" class="form-control" name="servicio${cont}" id="servicio">
                                        </div>
                                    </div>   
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="">Monto</label>
                                            <input disabled="" required type="number" value="${detalle.monto}" class="form-control" name="monto${cont}" id="monto">   
                                        </div>
                                    </div>
                                    <input type="hidden" name="detalleService${cont}" value="${detalle.id_detalle_presupuesto}"  />
                                </div>
                            </c:forEach>
                            <input value="${cont}" name="catidadDetalles"  type="hidden" />
                        </div>

                        <div class="row">
                            <div class="col-md-2">
                                <a class="btn btn-primary right" href="/Lex/presupuestos" > Volver</a>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- <div id="main-box"class="col-md-12">
        <div class="box box-primary">
            <div class="box-body">
                <form action="<c:url value = "/presupuestos/modificar"/>" method="POST">
                    <input type="hidden" value="${presupuesto.id_presupuesto}" name="idPresupuesto">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="fecha">Fecha (*)</label>
                                <input required type="date" class="form-control" id="fecha" name="fecha" placeholder="Ingrese Fecha"
                                       value="<c:out value="${inputs['fecha'] ? inputs['fecha'] : presupuesto.fecha}"/>">
                            </div>
                        </div>
                            
                        
                           
                    </div>

                    <div class="row">
                        <div class="col-md-3">
                            <div class="form-group">
                                <label for="solicitud">Solicitud (*)</label>

                                <select required class="form-control" id="id_solicitud" name="solicitud">
    <c:forEach var="solicitud" items="${solicitudes}">
        <option ${presupuesto.id_solicitud == solicitud.id_solicitud ? 'selected':''} value="<c:out value="${solicitud.id_solicitud}" />" ><c:out value="${solicitud.descripcion}" /></option>
    </c:forEach>
</select>
</div>
</div>
<div class="col-md-3">
<div class="form-group">
<label for="servicio">Servicio (*)</label>
<input required type="text" class="form-control" id="servicio" name="servicio" placeholder="Servicio" 
       value="<c:out value="${detalle.servicio}"/>">
</div>
</div>
<div class="col-md-2">
<div class="form-group">
<label for="estado">Estado (*)</label>
<select name="estado" class="form-control">
    <c:forEach var="estado" items="${estadosSolicitud}">
        <option ${presupuesto.id_estado_presupuesto == estado.id_estado_presupuesto ? 'selected':''} value="<c:out value="${estado.id_estado_presupuesto}" />" ><c:out value="${estado.nombre}" /></option>
    </c:forEach>
</select>
</div>
</div>
<div class="col-md-12"><hr></div>
</div>

<div class="row">
<div class="col-md-4">
<div class="form-group">
<label for="plan_pago">Plan Pago (*)</label>
<select required class="form-control" id="plan_pago" name="pago">
    <c:forEach var="planPago" items="${planPagos}">
        <option ${presupuesto.id_plan_pago == planPago.getId_Plan_Pago() ? 'selected':''} value="<c:out value="${planPago.getId_Plan_Pago()}" />" ><c:out value="${planPago.getNombre()}" /></option>
    </c:forEach>
</select>
</div>
</div>

<div class="col-md-4">
<div class="form-group">
<label for="email">Monto (*)</label>
<input required type="number" class="form-control" id="monto" name="monto" placeholder="Ingrese Monto" 
       value="<c:out value="${detalle.monto}"/>">
</div>
</div>

<input type="hidden" name="idDetalle" value="${detalle.id_detalle_presupuesto}" />

</div>
<div class="row">
<div class="col-md-12"><hr>
<button type="submit" class="btn btn-primary">Guardar</button>
</div>
</div>
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