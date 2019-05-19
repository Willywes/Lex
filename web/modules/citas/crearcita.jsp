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
        <div>
            <h3>Agregar Cita</h3>
        </div>
        <div>
            <form action="CitaServelet" method="POST">
                 Fecha y hora:
                <input type="date" required name="txtfechaHora"><br>
                ID Notaria
                <input type="text" required name="txtidnotaria"><br>
                 ID estado notaria:
                <input type="text" required name="txtestadonotaria"><br>
                
                <input type="submit" name="accion" value="Guardar">
                <input type="button" name="Cancelar" value="Cancelar" onClick="location.href='/Lex/modules/citas'">
                
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



