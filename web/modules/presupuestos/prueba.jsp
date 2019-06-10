<%-- 
    Document   : prueba
    Created on : 28-05-2019, 2:23:59
    Author     : Funny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <ul>
            <c:forEach var="presu" items="${presupuestos}">
                <li><c:out value="${presu.id_presupuesto}"  /></li>
                <li><c:out value="${presu.fecha}"  /></li>
                </c:forEach>

            <c:forEach var="presupuesto" items="${presupuestos}">

                <tr>
                    <td>${presupuesto.id_presupuesto}</td>
                    <td>${presupuesto.getFecha()}</td>
                    <td>Pendiente</td>
                    <td>${presupuesto.getCreado()}</td>
                    <td>${presupuesto.getModificado()}</td>
                    <td>${presupuesto.getId_solicitud()}</td>
                    <td>${presupuesto.getId_tecnico()}</td>
                    <td>${presupuesto.getId_plan_pago()}</td>
                    <td style="width:1%;white-space: nowrap;">
                        <%--<form action="presupuesto/editar" method="POST"> --%>
                        <a href="presupuesto/editar?id=${presupuesto.getId_presupuesto()}">
                            <button class="btn btn-warning btn-sm" title="Editar"><i class="fa fa-edit"></i></button></a>    
                        <form action="presupuesto/borrar" method="POST">
                            <input type="hidden" name="id" value="${presupuesto.getId_presupuesto()}" />
                            <button class="btn btn-danger btn-sm" title="Eliminar" name="accion" value="Eliminar">
                                <i class="fa fa-trash"></i></button>
                        </form>
                    </td>
                </tr>
            </c:forEach>

        </ul>
    </body>
</html>
