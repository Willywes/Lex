
<%@page import="Models.DTO.RolDTO"%>
<%@page import="Models.DAO.RolDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template>
    <jsp:attribute name="title">
        Gestión de Notarias
    </jsp:attribute>
    <jsp:attribute name="subtitle">
        Actualizar Notaria
    </jsp:attribute>
        
    <jsp:attribute name="styles">
        <link rel="stylesheet" href="/Lex/assets/bootstraptable/dragtable.css">
        <link rel="stylesheet" href="/Lex/assets/bootstraptable/bootstrap-table-reorder-rows.css">
        <link rel="stylesheet" href="/Lex/assets/bootstraptable/bootstrap-table-fixed-columns.css">
        <link rel="stylesheet" href="/Lex/assets/bootstraptable/bootstrap-table.min.css">
    </jsp:attribute>

    <jsp:attribute name="content">
        <div class="row">
            
            <%@include file="/modules/globals/alerts.jsp" %>
            
            <div id="main-box"class="col-md-12">
                <div class="box box-primary">
                    <div class="box-body">
                        <form action="<c:url value = "/modulo/notarias/update"/>" method="POST">
                            <input type="hidden" value="${notaria.id}" name="id">
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="nombres">Nombre (*)</label>
                                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombres de la Notaria" 
                                               value="<c:out value="${inputs['nombre'] ? inputs['nombre'] : notaria.nombre}"/>">
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="razon_social">Razón social (*)</label>
                                        <input type="text" class="form-control" id="razon_social" name="razon_social" placeholder="Razón Social de la Notaria" 
                                               value="<c:out value="${inputs['razon_social'] ? inputs['razon_social'] : notaria.razonSocial}"/>">
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="telefono">Teléfono</label>
                                        <input type="number" min="100000000" max="999999999" class="form-control" id="telefono" name="telefono" placeholder="Teléfono de la Notaria" 
                                               value="<c:out value="${inputs['telefono'] ? inputs['telefono'] : notaria.telefono}"/>">
                                    </div>
                                </div>
                                <div class="col-md-12"><hr></div>
                            </div>

                            <div class="row">
                                
                                <div class="col-md-8">
                                    <div class="form-group">
                                        <label for="direccion">Dirección (*)</label>
                                        <input type="text" class="form-control" id="direccion" name="direccion" placeholder="Dirección de la Notaria" 
                                               value="<c:out value="${inputs['direccion'] ? inputs['direccion'] : notaria.direccion}"/>">
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="id-comuna">Comuna (*)</label>
                                        <select class="form-control" id="id_comuna" name="id_comuna">
                                            <option value="">(Seleccione Comuna)</option>
                                            <c:forEach var="comuna" items="${comunas}">
                                                <option value="${comuna.id}" ${inputs['id_comuna'] == comuna.id ? "selected" : "" }>${comuna.nombre}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

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

        <script>
            function validandoRut(componente) {
                componente.Rut({
                    on_error: function () {
                        showToastError('El rut ingresado no es correcto, por favor vuelva a intentarlo.');
                        componente.val('');
                        componente.focus();
                    }
                })
            }

            function formateaRut(rut) {
                var actual = rut.replace(/^0+/, "");
                if (actual != '' && actual.length > 0) {
                    var sinPuntos = actual.replace(/\./g, "");
                    var actualLimpio;
                    if (actual != '' && actual.length >= 1) {
                        actualLimpio = sinPuntos.replace(/-/g, "");
                    }
                    try {
                        var inicio = (actualLimpio != 'undefined') ? actualLimpio.substring(0, actualLimpio.length - 1) : '';
                        var rutPuntos = "";
                        var i = 0;
                        var j = 1;
                        for (i = inicio.length - 1; i >= 0; i--) {
                            var letra = inicio.charAt(i);
                            rutPuntos = letra + rutPuntos;
                            if (j % 3 == 0 && j <= inicio.length - 1) {
                                rutPuntos = "." + rutPuntos;
                            }
                            j++;
                        }
                        var dv = actualLimpio.substring(actualLimpio.length - 1);
                        rutPuntos = rutPuntos + (rutPuntos.length > 2 ? "-" : "") + dv;
                    } catch (err) {
                        // console.log(err)
                    }
                }

                return rutPuntos;
            }

            function formarteandoRut(componente) {
                componente.val(formateaRut(componente.val().toUpperCase()));
            }
        </script>
    </jsp:attribute>
</t:template>

