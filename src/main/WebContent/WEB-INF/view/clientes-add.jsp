<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Clientes</h1>

       <form action="add" method="post" > 
       
       <input type="hidden" id="idCliente"  name= "idCliente" value="${cliente.idCliente}"  />
       Cedula
       <input type="text" id=cedula" name="cedula" value="${cliente.cedula}"  />
       
       
       
       
       
       </form>


</body>
</html>