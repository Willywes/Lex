<%-- 
    Document   : index
    Created on : 09-04-2019, 21:43:45
    Author     : willywes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Abogados Lex | Usuarios</title>

        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="/Lex/assets/bower_components/bootstrap/dist/css/bootstrap.min.css">

        <link rel="stylesheet" href="/Lex/assets/bower_components/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="/Lex/assets/bower_components/Ionicons/css/ionicons.min.css">
        <link rel="stylesheet" href="/Lex/assets/dist/css/AdminLTE.min.css">
        <link rel="stylesheet" href="/Lex/assets/dist/css/skins/skin-purple.min.css">
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">

        <link rel="stylesheet" href="/Lex/assets/bootstraptable/dragtable.css">
        <link rel="stylesheet" href="/Lex/assets/bootstraptable/bootstrap-table-reorder-rows.css">
        <link rel="stylesheet" href="/Lex/assets/bootstraptable/bootstrap-table-fixed-columns.css">
        <link rel="stylesheet" href="/Lex/assets/bootstraptable/bootstrap-table.min.css">
    </head>

    <body class="hold-transition skin-purple sidebar-mini">
        <div class="wrapper">

            <!-- Main Header -->
            <%@include file="/template/header.jsp" %>
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="main-sidebar">

                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">

                    <!-- Sidebar user panel (optional) -->
                    <%@include file="/template/profile.jsp" %>

                    <!-- Sidebar Menu -->
                    <%@include file="/template/sidebar-menu.jsp" %>

                </section>
                <!-- /.sidebar -->
            </aside>

            <div class="content-wrapper">

                <!-- NO ELIMINAR -->
                <section class="content-header">
                    <h1>
                        Gestión de Usuarios
                        <small></small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
                        <li class="active">Ejemplo</li>
                    </ol>
                </section>

                <section class="content">
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
                        <div id="create-section" class="col-md-4" style="display:none;">
                            <div class="box box-primary">
                                <div class="box-header">
                                    <h3 class="box-title">Crear Usuario</h3>
                                    <div class="box-tools pull-right">
                                        <button onclick="hideCreate();" type="button" class="btn btn-box-tool"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>
                                <div class="box-body">
                                    <form id="form-create">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Rut</label>
                                                    <input
                                                        id="rut"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="11.111.111-K"/>
                                                </div>
                                            </div>
                                        </div>   
                                        
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Ap. Paterno</label>
                                                    <input
                                                        id="paterno"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Ingrese Apellido Paterno"/>
                                                </div>
                                            </div>
                                            
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Ap. Materno</label>
                                                    <input
                                                        id="materno"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Ingrese Apellido Materno"/>
                                                </div>
                                            </div>
                                            
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label>Nombres</label>
                                                    <input
                                                        id="nombres"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Ingrese Nombres"/>
                                                </div>
                                            </div>
                                            
                                            
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label>Rol</label>
                                                    <select id="roles"
                                                            class="form-control">
                                                        <option disabled selected>Seleccione Rol</option>
                                                        <option value="1">Administrador</option>
                                                        <option value="2">Abogado</option>
                                                        <option value="3">Técnico Jurídico</option>
                                                        
                                                  
                                                    </select>
                                                </div>
                                            </div>
                                            
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <button type="button" onclick="hideCreate();" class="btn btn-default btn-block"> Cancelar </button>
                                            </div>
                                            <div class="col-md-6">
                                                <button type="submit" class="btn btn-primary btn-block"><i class="fa fa-save"></i>Guardar</button>
                                            </div>
                                        </div>



                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>




            </div>
        </div>


        <%@include file="/template/footer.jsp" %>    


    </div>

    <!-- DataTables -->
    <link rel="stylesheet" href="/Lex/assets/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">

    <script src="/Lex/assets/bower_components/jquery/dist/jquery.min.js"></script>
    <script src="/Lex/assets/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="/Lex/assets/dist/js/adminlte.min.js"></script>

    <!-- DataTables -->
    <script src="/Lex/assets/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="/Lex/assets/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    <script>
                                            $(function () {

                                                $('#table').DataTable({
                                                    'paging': true,
                                                    'lengthChange': false,
                                                    'searching': false,
                                                    'ordering': true,
                                                    'info': true,
                                                    'autoWidth': false
                                                })
                                            })

                                            function showCreate() {
                                                $('#main-box').removeClass('col-md-12');
                                                $('#main-box').addClass('col-md-8');
                                                $('#create-section').fadeIn();
                                            }

                                            function hideCreate() {
                                                $('#main-box').removeClass('col-md-8').fadeIn();
                                                $('#main-box').addClass('col-md-12').fadeIn();
                                                $('#create-section').hide();
                                                $('#form-create')[0].reset();
                                            }
    </script>
</body>
</html>
