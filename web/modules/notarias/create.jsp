
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
        Crear Notaria
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
                        <form action="<c:url value = "/modulo/notarias/store"/>" method="POST">
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="nombres">Nombre (*)</label>
                                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombres de la Notaria" 
                                               value="<c:out value="${inputs['nombre']}"/>">
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="razon_social">Razón social (*)</label>
                                        <input type="text" class="form-control" id="razon_social" name="razon_social" placeholder="Razón Social de la Notaria" 
                                               value="<c:out value="${inputs['razon_social']}"/>">
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="telefono">Teléfono</label>
                                        <input type="number" min="100000000" max="999999999" class="form-control" id="telefono" name="telefono" placeholder="Teléfono de la Notaria" 
                                               value="<c:out value="${inputs['telefono']}"/>">
                                    </div>
                                </div>
                                <div class="col-md-12"><hr></div>
                            </div>

                            <div class="row">
                                
                                <div class="col-md-8">
                                    <div class="form-group">
                                        <label for="direccion">Dirección (*)</label>
                                        <input type="text" class="form-control" id="direccion" name="direccion" placeholder="Dirección de la Notaria" 
                                               value="<c:out value="${inputs['direccion']}"/>">
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
        
    </jsp:attribute>
</t:template>

