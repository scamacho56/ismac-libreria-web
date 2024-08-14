<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1> Productos </h1>

<table>
    <thead>
    <tr> 
    <th>idProductos</th>
     <th>Nombre</th>
     <th>Descripcion</th>
     <th>Precio</th>
     <th>Stock</th>
     
     
     
    </tr>
    </thead>
    <tbody>
	    <c:forEach var="item" items="${productos}">
		    <tr>
			     <td>${item.idProductos}</td>
			     <td>${item.nombre}</td>
			     <td>${item.descripcion}</td>
			     <td>${item.precio}</td>
			     <td>${item.stock}</td>
			 
			     <td>
			     
			     
		    </tr>
	    </c:forEach>
    <tr></tr>
    </tbody>
</table>




</body>
</html>