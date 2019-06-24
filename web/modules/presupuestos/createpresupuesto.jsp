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
        Crear Presupuesto
    </jsp:attribute>
    <jsp:attribute name="styles">
        <link rel="stylesheet" href="/Lex/assets/bootstraptable/dragtable.css">
        <link rel="stylesheet" href="/Lex/assets/bootstraptable/bootstrap-table-reorder-rows.css">
        <link rel="stylesheet" href="/Lex/assets/bootstraptable/bootstrap-table-fixed-columns.css">
        <link rel="stylesheet" href="/Lex/assets/bootstraptable/bootstrap-table.min.css">
    </jsp:attribute>

    <jsp:attribute name="content">
        <div class="row">
            <div class="col-md-12">
                <div class="box box-info">
                    <div class="box-header with-border">
                        <h3 class="box-title">Nuevo Presupuesto ${solicitud.cliente.nombres}</h3>
                    </div>
                    <div class="box-body">
                        <div class="<c:out value="${ mensaje == 'get' ? '' : 'alert alert-success'  }" />" >
                            <p> <c:out value="${ mensaje == 'get' ? '' : 'Agregado con Exito'  }" /> </p>
                        </div>
                        <form action="" method="POST" >
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
                                        <select class="form-control" name="plan_pago" id="">
                                            <option value="">Seleccione plan</option>
                                            <c:forEach var="planPago" items="${planPagos}">
                                                <option value="${planPago.getId_Plan_Pago()}"> ${planPago.getNombre()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="">Estado</label>
                                        <select class="form-control" name="estado" id="">
                                            <option value="">Seleccione estado</option>
                                            <c:forEach var="estado" items="${estadosPresupuestos}">
                                                <option  value="${estado.id_estado_presupuesto}"> ${estado.nombre}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-12" id="servicios">
                            </div>
                            <div class="row">
                                <div class="col-md-2">
                                    <button class="btn btn-primary right" type="submit" ><i class="fa fa-save"></i> Guardar</button>
                                </div>
                                <div class="col-md-2">
                                    <button type="button" onclick="addServicio()" class="btn btn-success"><i class="fa fa-plus"></i> Nuevo Servicio</button>
                                </div>
                            </div>
                            <input type="hidden" id="cantidad" value="0"  name="cantidadDetalle" />
                            <input type="hidden"  value="${solicitud.id_solicitud}" name="idSolicitud" />
                            <input type="hidden"  value="${solicitud.tecnico.id}" name="idTecnico" />
                        </form>

                    </div>
                </div>
            </div>
        </div>

        <!--div id="main-box"class="col-md-12">
            <div class="box box-primary">
                <div class="box-body">
                    <div class="<c:out value="${ mensaje == 'get' ? '' : 'alert alert-success'  }" />" >
                        <p> <c:out value="${ mensaje == 'get' ? '' : 'Agregado con Exito'  }" /> </p>
                    </div>
                    <form action="crear" method="POST" name="form" >
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label for="fecha">Fecha (*)</label>
                                    <input required type="date" class="form-control " id="fecha" name="fecha" placeholder="Ingrese Fecha">
                                </div>
                            </div>
                        </div>
                        <br>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="solicitud">Solicitud (*)</label>
                                    <select required name="solicitud" disabled="true" class="form-control">
        <c:forEach  var="solicitud" items="${solicitudes}">
            <option ${ idSolicitud == solicitud.getId_solicitud() ? 'selected' : '' } value="${solicitud.getId_solicitud()}"> ${solicitud.getDescripcion()}</option>
        </c:forEach>
    </select>
    </div>
    </div>
    <div class="col-md-6">
    <div class="form-group">
    <label for="servicio">Servicio (*)</label>
    <input required type="text" class="form-control" name="servicio" placeholder="Ingrese descripción de Servicio">                        
    </div>
    </div>
    
    <div class="col-md-12"><hr></div>
    </div>
    <div class="row">
    <div class="col-md-4">
    <div class="form-group">
    <label for="estado">Estado (*)</label>
    <select required name="estado" class="form-control">
        <option value="">Seleccione una Opción</option>
        <c:forEach var="estado" items="${estadosPresupuestos}">
            <option  value="${estado.id_estado_presupuesto}"> ${estado.nombre}</option>
        </c:forEach>
    </select>                                    
    </div>
    </div>
    <div class="col-md-4">
    <div class="form-group">
    <label for="plan_pago">Plan Pago (*)</label>
    <select required name="plan_pago" class="form-control">
        <option value="" >Seleccione una Opción</option>
        <c:forEach var="planPago" items="${planPagos}">
            <option value="${planPago.getId_Plan_Pago()}"> ${planPago.getNombre()}</option>
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
    <button type="submit" class="btn bt-primary">Crear Presupuesto</button>
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

        <!--Validar datos del form--->
        <!--script src="/Lex/assets/custom/formPresupuesto_Pagos.js" type="text/javascript"></script-->

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
                        document.getElementById("servicio" + t).name = "servicio" + cambio;
                        document.getElementById("servicio" + t).id = "servicio" + cambio;
                        document.getElementById("monto" + t).name = "monto" + cambio;
                        document.getElementById("monto" + t).id = "monto" + cambio;
                        document.getElementById(t).id = cambio;
                        cambio++;
                    }
                    t++;
                }

                cont = cont - 1;

                document.getElementById("cantidad").value = cont

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
                        '                                                <input type="text" class="form-control" name="servicio' + (cont) + '" id="servicio' + (cont) + '">\n' +
                        '                                            </div>\n' +
                        '                                        </div>\n' +
                        '                                        <div class="col-md-2">\n' +
                        '                                            <div class="form-group">\n' +
                        '                                                <label for="">Monto</label>\n' +
                        '                                                <input type="number" class="form-control" name="monto' + (cont) + '" id="monto' + (cont) + '">\n' +
                        '                                            </div>\n' +
                        '                                        </div>\n' +
                        '                                        <div class="col-md-1">\n' +
                        '                                            <button type="button" onclick="deleteElem(this);" style="margin-top: 24px;" class="btn btn-danger removeButton"><i class="fa fa-trash"></i></button>\n' +
                        '                                        </div>\n' +
                        '                                    </div>'));
                document.getElementById("cantidad").value = cont;
            }



        </script>       
    </jsp:attribute>
</t:template>