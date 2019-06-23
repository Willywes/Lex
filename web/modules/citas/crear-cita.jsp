<%-- 
    Document   : cita index
    Created on : 15-05-2019, 22:34:03
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
        Gestión de Notarias
    </jsp:attribute>
    <jsp:attribute name="subtitle">
        Crear Cita
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
                <div class="box box-primary">

                    <div class="box-body">
                        <div class="row">
                            <div class="col-md-12">
                                <div>
                                    <form action="crear" method="POST">

                                        <div class="row">
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <label for="txtfechaHora">Fecha </label>
                                                    <input type="date" required name="txtfechaHora"  min="${fechaHoy}"  class="form-control">
                                                </div>

                                            </div>


                                            <div class="col-md-3">

                                                <div class="form-group">
                                                    <label for="">Hora</label>
                                                    <div class="row">
                                                        <div class="col-md-8">
                                                            <select name="txthora" class="form-control" required>
                                                                <option value="8">8</option>
                                                                <option value="9">9</option>
                                                                <option value="10">10</option>
                                                                <option value="11">11</option>
                                                                <option value="12">12</option>
                                                                <option value="13">13</option>
                                                                <option value="15">15</option>
                                                                <option value="16">16</option>
                                                                <option value="17">17</option>
                                                            </select> 
                                                        </div>
                                                        <div class="col-md-4">
                                                            <select name="txtminutos" class="form-control" required>
                                                                <option value="00">00</option>
                                                                <option value="15">15</option>
                                                                <option value="30">30</option>
                                                                <option value="45">45</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>

                                        <div class="row">

                                            <div class="col-md-8">
                                                <div class="form-group">
                                                    <label for="txtidnotaria">Notaria</label>
                                                    <select name="txtidnotaria" class="form-control" required>
                                                        <option value="">(Seleccion Notaria)</option>
                                                        <c:forEach var="notaria" items="${notarias}">
                                                            <option value="${notaria.id}">${notaria.nombre} | ${notaria.razonSocial}</option>


                                                        </c:forEach>


                                                    </select> 
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-6">
                                                <input type="submit" name="accion" value="Guardar" class="btn btn-primary">
                                            </div>
                                            <div class="col-md-6">
                                                <input type="button" name="Cancelar" value="Cancelar" class="btn btn-danger" onClick="location.href = '/Lex/citas'">
                                            </div>
                                        </div>

                                    </form>
                                </div>
                            </div>
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
    </jsp:attribute>
</t:template>



