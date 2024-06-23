<%@page import="Dao.ClassProductoImp"%>
<%@page import="model.TblProductocl2"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Productos</title>
</head>
<body bgcolor="#c5dec9">
<h1 align="center">Listado de Productos Registrados en BD</h1>

<a href="RegistroProducto.jsp"><button>Registrar Producto</button></a>
<%ClassProductoImp crud=new ClassProductoImp(); %>

<table border="2" align="center">
<tr>
	<td>Id</td>
	<td>Nombre</td>
	<td>Precio Venta</td>
	<td>Precio Compra</td>
	<td>Estado</td>
	<td>Descripcion</td>
</tr>

<%
	List<TblProductocl2> listadoproducto =crud.ListadoProducto();
	if(listadoproducto!=null){
		for(TblProductocl2 lis:listadoproducto){
			%>
			<tr>
				<td><%=lis.getIdproductocl2()%></td>
				<td><%=lis.getNombrecl2() %></td>
				<td><%=lis.getPrecioventacl2() %></td>
				<td><%=lis.getPreciocompcl2() %></td>
				<td><%=lis.getEstadocl2() %></td>
				<td><%=lis.getDescripcl2() %></td>
			</tr>
		<% 	
		}
		
	}
%>

</table>



</body>
</html>