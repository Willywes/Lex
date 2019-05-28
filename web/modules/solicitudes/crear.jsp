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
      <div id="main-box"class="col-md-6">
        <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Agregar Solicitud</h3>
            </div>
            <form action="crear" method="POST">
              <div class="box-body">
              
                <!-- hide date en base a conversado  
                  <input type="date" required name="txtfechaHora" min="2019-05-28"><br>

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
                  -->
                
                <div class="form-group">
                  <label for="inputEmail3" class="control-label">Descripción</label>
                  <textarea name="txtDescripcion" class="form-control"></textarea>
                </div>
                <div class="form-group">
                  <label for="" class="control-label">Tipo de solicitud</label>
                  <select name="selectTipoSolicitud" class="form-control" required>
                    <c:forEach var="tipo" items="${tipoDeSolicitudes}">
                      <option value="${tipo.id}">${tipo.nombre}</option>
                    </c:forEach>
                  </select>
                </div>
                  
                <!-- Deshabilitado, ya que en teoría se debería auto cargar con la opción de "en proceso"
                       En espera id = 2
                  <select name="selectEstadoSolicitud" required>
                    <c:forEach var="estado" items="${estadoSolicitudes}">
                      <option value="${estado.id_estado_solicitud}">${estado.nombre}</option>
                    </c:forEach>
                  </select>
                  -->
                  
                <div class="form-group">
                  <label for="" class="control-label">Cliente</label>
                  <select name="selectCliente" class="form-control" required>
                    <c:forEach var="cliente" items="${clientes}">
                      <option value="${cliente.id}">${cliente.rut} | ${cliente.nombres} ${cliente.paterno}</option>
                    </c:forEach>
                  </select>
                </div>
                  
                <div class="form-group">
                  <label for="" class="control-label">Técnico</label>
                  <select name="selectTecnico" class="form-control" required>
                    <c:forEach var="tecnico" items="${tecnicos}">
                      <option value="${tecnico.id}">${tecnico.rut} | ${tecnico.nombres} ${tecnico.paterno}</option>
                    </c:forEach>
                  </select>
                </div>
                
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
                <input type="button" name="Cancelar" value="Cancelar" class="btn btn-default" onClick="location.href = '/Lex/solicitudes'">
                <input type="submit" name="accion" value="Crear" class="btn btn-info pull-right">
              </div>
              <!-- /.box-footer -->
            </form>
          </div>
        
                  
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



