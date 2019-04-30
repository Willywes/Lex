<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

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
                                <div class="box-header">
                                    <div  class="btn-group">
                                        <button class="btn btn-success" onclick="showCreate();"> <!--data-toggle="modal" data-target="#modal-create"--><i
                                                class="fa fa-plus"></i> Nuevo Usuario
                                        </button>
                                    </div>
                                </div>
                                <div class="box-body">
                                    <table id="table" class="table table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th style="width:1%;white-space: nowrap;">Id</th>
                                                <th>Rut</th>
                                                <th>Paterno</th>
                                                <th>Materno</th>
                                                <th>Nombres</th>
                                                <th>Rol</th>
                                                <th style="width:1%;white-space: nowrap;">Estado</th>
                                                <th style="width:1%;white-space: nowrap;">Acciones</th>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>16483941-9</td>
                                                <td>Isla</td>
                                                <td>Carrasco</td>
                                                <td>Alejandro</td>
                                                <td>Administrador</td>
                                                <td style="width:1%;white-space: nowrap;"><span class="badge bg-green">Activado</span></td>
                                                <td style="width:1%;white-space: nowrap;">
                                                    <button class="btn btn-warning btn-sm" title="Editar"><i class="fa fa-edit"></i></button>
                                                    <button class="btn btn-danger btn-sm" title="Eliminar"><i class="fa fa-trash"></i></button>
                                                </td>
                                            </tr>

                                        </tbody>

                                        <tfoot>
                                            <tr>
                                                <th>Id</th>
                                                <th>Rut</th>
                                                <th>Paterno</th>
                                                <th>Materno</th>
                                                <th>Nombres</th>
                                                <th>Rol</th>
                                                <th>Estado</th>
                                                <th>Acciones</th>
                                            </tr>
                                        </tfoot>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
    </jsp:attribute>
    
    <jsp:attribute name="scripts">
    <!-- DataTables -->
    <link rel="stylesheet" href="/Lex/assets/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">

    <script src="/Lex/assets/bower_components/jquery/dist/jquery.min.js"></script>
    <script src="/Lex/assets/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="/Lex/assets/dist/js/adminlte.min.js"></script>

    <!-- DataTables -->
    <script src="/Lex/assets/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="/Lex/assets/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    </jsp:attribute>
</t:template>

