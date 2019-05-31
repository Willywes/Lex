<%-- 
    Document   : cita modificar
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
                    <div class="box-header with-border">

                    </div>
                    <div class="box-body">
                        <table id="table" class="table table-bordered table-hover">

                            <tbody>
                            <center>
                                <div class="form-group">
                                    <h3>Editar Cita nº ${id_cita} </h3>

                                </div>
                                <div class="form-group">
                                    <form action="editar" method="POST">
                                        Fecha:
                                        <%--  <input type="number" name="txtid" value="${solicitud.getIdSolicitud()}"><br>  --%>
                                        <input type="date" required name="txtfechaHora" value="${cita.getFecha_hora()}"><br>

                                        Hora:

                                        <select name="txthora" required>
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
                                        :
                                        <select name="txtminutos" required>
                                            <option value="00">00</option>
                                            <option value="15">15</option>
                                            <option value="30">30</option>
                                            <option value="45">45</option>
                                        </select>
                                        <br>

                                        número Notaria
                                        <input type="number" required name="txtidnotaria" value="${cita.getId_notaria()}"><br>
                                        número estado notaria:
                                        <input type="number" required name="txtestadonotaria" value="${cita.getId_estado_cita()}"><br>
                                        <input type="hidden" name="id" value="${cita.getId_cita()}" />   
                                        <input type="submit" name="accion" value="Guardar">

                                        <input type="button" name="Cancelar" value="Cancelar" onClick="location.href = '/Lex/citas'">

                                    </form>
                                </div>
                            </center>


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
    </jsp:attribute>
</t:template>



