<%-- 
    Document   : logout
    Created on : 25-06-2019, 1:51:48
    Author     : Depredador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1></h1>
    </body>
</html>
 <% HttpSession misession = request.getSession();
String user_name;
String nivel;

if (misession.getAttribute("usuario")!=null && misession.getAttribute("clave")!=null){
  user_name=misession.getAttribute("usuario").toString();
  nivel=misession.getAttribute("rol").toString();        
  out.print("<a href='login.jsp?cerrar=true' ><h5>Cerrar sesion "+user_name+" </h5></a>");
}else{
    out.print("<script>location.replace('indexSesion.jsp');</script>");

}

%>