<%-- 
    Document   : genericpage
    Created on : 29-04-2019, 22:27:53
    Author     : willywes
--%>

<%@tag description="template" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="content" fragment="true" %>
<%@attribute name="styles" fragment="true" %>
<%@attribute name="scripts" fragment="true" %>
<%@attribute name="title" fragment="true" %>
<%@attribute name="subtitle" fragment="true" %>


<%-- 
    Document   : index
    Created on : 09-04-2019, 21:43:45
    Author     : willywes
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Abogados Lex | <jsp:invoke fragment="title"/></title>

        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="/Lex/assets/bower_components/bootstrap/dist/css/bootstrap.min.css">

        <link rel="stylesheet" href="/Lex/assets/bower_components/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="/Lex/assets/bower_components/Ionicons/css/ionicons.min.css">
        <link rel="stylesheet" href="/Lex/assets/dist/css/AdminLTE.min.css">
        <link rel="stylesheet" href="/Lex/assets/dist/css/skins/skin-purple.min.css">
        <link rel="stylesheet" href="/Lex/assets/plugins/toastr/toastr.min.css">

        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
        <link rel="stylesheet" href="/Lex/assets/custom/app.css">
        <jsp:invoke fragment="styles"/>
    </head>

    <body class="hold-transition skin-purple sidebar-mini">
        <div class="wrapper">

            <!-- Main Header -->
            <header class="main-header">

                <!-- Logo -->
                <a href="#" class="logo">
                    <!-- mini logo for sidebar mini 50x50 pixels -->
                    <span class="logo-mini"><b>A</b>L</span>
                    <!-- logo for regular state and mobile devices -->
                    <span class="logo-lg"><b>Abogados</b>LEX</span>
                </a>

                <!-- Header Navbar -->
                <nav class="navbar navbar-static-top" role="navigation">
                    <!-- Sidebar toggle button-->
                    <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                        <span class="sr-only">Toggle navigation</span>
                    </a>
                    <!-- Navbar Right Menu -->
                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">

                            <li class="dropdown user user-menu">
                                <!-- Menu Toggle Button -->
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <!-- The user image in the navbar-->

                                    <!-- hidden-xs hides the username on small devices so only the image appears. -->
                                    <span class="hidden-xs">Usuario</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <!-- The user image in the menu -->
                                    <li class="user-header">

                                        <p>
                                            Usuario - Rol
                                            <small>Último accesso</small>
                                        </p>
                                    </li>
                                    <!-- Menu Body -->
                                    <!-- <li class="user-body">
                                         <div class="row">
                                             <div class="col-xs-4 text-center">
                                                 <a href="#">Followers</a>
                                             </div>
                                             <div class="col-xs-4 text-center">
                                                 <a href="#">Sales</a>
                                             </div>
                                             <div class="col-xs-4 text-center">
                                                 <a href="#">Friends</a>
                                             </div>
                                         </div>-->
                                    <!-- /.row -->
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="#" class="btn btn-info btn-flat">Perfil</a>
                                </div>
                                <div class="pull-right">
                                    <a href="#" class="btn btn-danger btn-flat">Salir</a>
                                </div>
                            </li>
                        </ul>
                        </li>


                        </ul>
                    </div>
                </nav>
            </header>
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="main-sidebar">

                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">

                    <div class="user-panel" style="height: 60px;" >
                        <div class="pull-left image">
                            <!--<img src="/images/user-default.png" class="img-circle" alt="User Image">-->
                            <i class="fa fa-user fa-3x text-info"></i>
                        </div>
                        <div class="pull-left info">
                            <p class="adjust-sidebar-text">Usuario</p>
                            <p class="adjust-sidebar-text text-blue">Rol</p>
                        </div>
                    </div>



                    <!-- AQUI VA EL MENÚ-->



                    <ul class="sidebar-menu" data-widget="tree">
                        <li class="header">Gestión de Usuarios</li>
                        <!-- Menus-->
                        
                        <li><a href="<c:url value = "/modulo/usuarios/index"/>"><i class="fa fa-users"></i><span>Usuarios</span></a></li>
                        
                        <li><a href="<c:url value = "/modulo/clientes/index"/>"><i class="fa fa-users"></i><span>Clientes</span></a></li>
                        
                        <li class="header">Gestión de Notarias </li>
                        <li><a href="<c:url value = "/modulo/notarias/index"/>"><i class="fa fa-university"></i><span>Notarias</span></a></li>
                        <li class="treeview">
                            <a href="<c:url value = "/citas"/>"><i class="fa fa-calendar"></i> <span>Citas</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="<c:url value = "/citas"/>">Ver Citas</a></li>
                                <li><a href="<c:url value = "/citas/crear"/>">Crear cita</a></li>
                            </ul>
                        </li>
                        
                        <li class="header">Gestión de Contratos </li>
                        
                        <li class="treeview">
                            <a href="<c:url value = "/contratos"/>"><i class="fa fa-book"></i> <span>Contratos</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="<c:url value = "/contratos"/>">Ver Contratos</a></li>
                                <li><a href="<c:url value = "/contratos/crear"/>">Crear contrato</a></li>
                                <!--<li><a href="">Modificar contrato</a></li>-->
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="<c:url value = "/tipos-solicitud"/>"><i class="fa fa-list-ul"></i> <span>Solicitudes</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="<c:url value = "/solicitudes/listar"/>">Ver solicitudes</a></li>
                                <li><a href="<c:url value = "/solicitudes/tipos"/>">Ver tipos de solicitud</a></li>
                                <li><a href="<c:url value = "/solicitudes/estados"/>">Ver estados de solicitud</a></li>
                                <li><a href="<c:url value = "/solicitudes/crear"/>">Crear solicitud</a></li>
                                <li><a href="<c:url value = "/solicitudes/buscar"/>">Buscar solicitud</a></li>
                                
                            </ul>
                        </li>
                        
                        <li class="header">Gestión de Presupuestos y Pagos </li>
                        
                         <li class="treeview">
                            <a href="<c:url value = "/presupuestos"/>"><i class="fa fa-dollar"></i> <span>Presupuestos</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="<c:url value = "/presupuestos/crear"/>">Crear Presupuestos</a></li>
                                <li><a href="<c:url value = "/presupuestos"/>">Ver Presupuestos</a></li>
                            </ul>
                        </li>
                        
                          <li class="treeview">
                            <a href="<c:url value = "/pagos"/>"><i class="fa fa-dollar"></i> <span>Pagos</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="<c:url value = "/pagos/crear"/>">Crear Pagos</a></li>
                                <li><a href="<c:url value = "/pagos"/>">Ver Pagos</a></li>
                            </ul>
                        </li>
                    </ul>





                </section>
                <!-- /.sidebar -->
            </aside>

            <div class="content-wrapper">

                <!-- NO ELIMINAR -->
                <section class="content-header">
                    <h1>
                        <jsp:invoke fragment="title"/>
                        <small><jsp:invoke fragment="subtitle"/></small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="/Lex"><i class="fa fa-dashboard"></i> Inicio</a></li>
                        
                    </ol>
                </section>


                <section class="content container-fluid">



                    <jsp:invoke fragment="content"/>

                </section>
            </div>
            <footer class="main-footer">
                <!-- To the right -->
                <div class="pull-right hidden-xs">
                    Version 1.0
                </div>
                <!-- Default to the left -->
                <strong>Copyright &copy; 2019 <a href="#">Abogados Lex</a>.</strong> Todos los derechos reservados.
            </footer>  


        </div>

        <script src="/Lex/assets/bower_components/jquery/dist/jquery.min.js"></script>
        <script src="/Lex/assets/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="/Lex/assets/dist/js/adminlte.min.js"></script>
        <script src="/Lex/assets/plugins/toastr/toastr.min.js"></script>
        <script src="/Lex/assets/custom/app.js"></script>

        <%
            session = request.getSession();
            String success = null;

            if (session.getAttribute("success") == null) {
                success = (String) session.getAttribute("success");
            } else {
                session.removeAttribute("success");
            }
        %>

        <%
            session = request.getSession();
            String warning = null;

            if (session.getAttribute("warning") == null) {
                warning = (String) session.getAttribute("warning");
            } else {
                session.removeAttribute("warning");
            }
        %>

        <%
            session = request.getSession();
            String error = null;

            if (session.getAttribute("error") == null) {
                error = (String) session.getAttribute("error");
            } else {
                session.removeAttribute("error");
            }
        %>

        <jsp:invoke fragment="scripts"/>
    </body>
</html>
