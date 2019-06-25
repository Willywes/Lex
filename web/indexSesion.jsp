<%-- 
    Document   : indexSesion
    Created on : 24-06-2019, 22:28:33
    Author     : Depredador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


<html>
    <body style="text-align: center">
 
   
      <form action="<%=request.getContextPath()%>/SesionServlet" method="POST">
          
      Rut <input type="text" name="usuario" /><br/>
      Clave <input type="password" name="clave"/><br/>
      Numero ROl <input type="text" name="rol"/><br/>
      1.- Abogado Administrador<br/>
      2.- Abogado<br/>
      3.- Tecnico Juridico<br/>
      4.- Notaria<br/>
      5.- Cliente<br/>
      
 
    <input type="submit" value="Iniciar" />
   
    </form>
     </body>

</html>

