<%@page import="Models.DTO.ContratoDTO"%>
<%@page import="Models.DAO.ContratoDAO"%>
<%@page import="java.util.List"%>
<%@page import="Models.DTO.PagoDTO"%>
<%@page import="Models.DAO.PagoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template>
    <jsp:attribute name="title">
        Gestión de Pago
    </jsp:attribute>
    <jsp:attribute name="subtitle">
        Crear Pago
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
                        <div class="<c:out value="${ mensaje == 'exito' ? 'alert alert-success' : ''  }" />" >
                            <p> <c:out value="${ mensaje == 'exito' ? 'Agregado con Exito' : ''  }" /> </p>
                        </div>
                        <div class="<c:out value="${ mensaje == 'get' ? 'alert alert-danger' : ''  }" />" >
                            <p> <c:out value="${ mensaje == 'get' ? 'Error desconocido' : ''  }" /> </p>
                        </div>


                        <form action="crear" method="POST" name="form" >
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="box box-warning">
                                        <div class="box-header with-border">
                                            <h3 class="box-title">Contrato</h3>

                                            <div class="box-tools pull-right">
                                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                                </button>
                                            </div>
                                            <!-- /.box-tools -->
                                        </div>
                                        <!-- /.box-header -->
                                        <div class="box-body">
                                            <h4> Crear Pago para el Contrato N° ${pago.contrato.id_contrato}</h4>
                                        </div>
                                        <!-- /.box-body -->
                                    </div>
                                    <!-- /.box -->
                                </div>
                            </div>
                            <div class="row" >
                                <div class="col-md-6">
                                    <div class="box box-success box-solid">
                                        <div class="box-header with-border">
                                            <h3 class="box-title">Cliente</h3>
                                            <div class="box-tools pull-right">
                                                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                            </div>
                                            <!-- /.box-tools -->
                                        </div>
                                        <!-- /.box-header -->
                                        <div class="box-body">
                                            <dl>
                                                <dt>Nombre Cliente</dt>
                                                <dd>${pago.cliente.nombres}</dd>
                                                <dt>Email</dt>
                                                <dd>${pago.cliente.email}</dd>
                                                <dt>Telefono</dt>
                                                <dd>${pago.cliente.telefono}</dd>
                                            </dl>
                                        </div>
                                        <!-- /.box-body -->
                                    </div>
                                    <!-- /.box -->
                                </div>
                            </div>
                            <div class="row" >
                                <div class="col-md-6">
                                    <div class="box box-danger">
                                        <div class="box-header with-border">
                                            <h3 class="box-title">Crear Pago</h3>

                                            <div class="box-tools pull-right">
                                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                                </button>
                                            </div>
                                            <!-- /.box-tools -->
                                        </div>
                                        <!-- /.box-header -->
                                        <div class="box-body">

                                            <div class="row" >
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label for="monto">Monto (*)</label>
                                                        <input required type="number" class="form-control" name="monto" placeholder="Ingrese Monto">
                                                    </div>
                                                </div>
                                            </div>


                                            <input type="hidden" name="contrato" value="${pago.contrato.id_contrato}" />

                                            <button type="submit" class="btn bt-primary">Crear Pago</button>

                                        </div>

                                        <!-- /.box-body -->
                                    </div>
                                    <!-- /.box -->
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

        <!--Validar datos del form--->
        <script src="/Lex/assets/custom/formPresupuesto_Pagos.js" type="text/javascript"></script>

    </jsp:attribute>
</t:template>