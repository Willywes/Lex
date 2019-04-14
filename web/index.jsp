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
        <title>Abogados Lex</title>

        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="assets/bower_components/bootstrap/dist/css/bootstrap.min.css">

        <link rel="stylesheet" href="assets/bower_components/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/bower_components/Ionicons/css/ionicons.min.css">
        <link rel="stylesheet" href="assets/dist/css/AdminLTE.min.css">
        <link rel="stylesheet" href="assets/dist/css/skins/skin-purple.min.css">
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    </head>

    <body class="hold-transition skin-purple sidebar-mini">
        <div class="wrapper">

            <!-- Main Header -->
            <%@include file="template/header.jsp" %>
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="main-sidebar">

                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">

                    <!-- Sidebar user panel (optional) -->
                    <%@include file="template/profile.jsp" %>

                    <!-- Sidebar Menu -->
                    <%@include file="template/sidebar-menu.jsp" %>

                </section>
                <!-- /.sidebar -->
            </aside>

            <div class="content-wrapper">

                <!-- NO ELIMINAR -->
                <section class="content-header">
                    <h1>
                        Titutlo dinamico
                        <small>Optional titulo dinamico</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
                        <li class="active">Ejemplo</li>
                    </ol>
                </section>


                <section class="content container-fluid">

                    <!--------------------------
                    | Your Page Content Here 
                    -------------------------->

                </section>
            </div>
            <%@include file="template/footer.jsp" %>    


        </div>

        <script src="assets/bower_components/jquery/dist/jquery.min.js"></script>
        <script src="assets/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="assets/dist/js/adminlte.min.js"></script>
    </body>
</html>
