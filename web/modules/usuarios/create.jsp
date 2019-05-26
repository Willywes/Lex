
<%@page import="Models.DTO.RolDTO"%>
<%@page import="Models.DAO.RolDAO"%>
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

    <jsp:attribute name="content">
        <div class="row">
            
            <%@include file="/modules/globals/alerts.jsp" %>
            
            
            <div id="main-box"class="col-md-12">
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">Crear Usuarios ${hola}</h3>
                    </div>
                    <div class="box-body">
                        <form action="<c:url value = "/modulo/usuarios/store"/>" method="POST">
                            <div class="row">
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label for="rut">RUT</label>
                                        <input type="text" class="form-control" id="rut" name="rut" placeholder="11.222.333-K" value="<c:out value="${inputs['rut']}"/>">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="nombres">Nombres (*)</label>
                                        <input type="text" class="form-control" id="nombres" name="nombres" placeholder="Nombres del Usuario" value="<c:out value="${inputs['nombres']}"/>">
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label for="paterno">Apellido Paterno (*)</label>
                                        <input type="text" class="form-control" id="paterno" name="paterno" placeholder="Apellido Paterno del Usuario" value="<c:out value="${inputs['paterno']}"/>">
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label for="materno">Apellido Materno</label>
                                        <input type="text" class="form-control" id="materno" name="materno" placeholder="Apellido Materno del Usuario" value="<c:out value="${inputs['materno']}"/>">
                                    </div>
                                </div>
                                <div class="col-md-12"><hr></div>
                            </div>

                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">

                                        <label for="rol">Rol (*)</label>
                                        
                                        <select class="form-control" id="id_rol" name="id_rol">
                                            <option value="">(Seleccione Rol)</option>
                                            <c:forEach var="rol" items="${roles}">
                                                <option value="${rol.id}" ${inputs['id_rol'] == rol.id ? "selected" : "" }>${rol.nombre}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="email">Email (*)</label>
                                        <input type="text" class="form-control" id="email" name="email" placeholder="Email del Usuario" value="<c:out value="${inputs['email']}"/>">
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="clave">Contraseña (*)</label>
                                        <input type="text" class="form-control" id="clave" name="clave" placeholder="Clave del Usuario">
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

