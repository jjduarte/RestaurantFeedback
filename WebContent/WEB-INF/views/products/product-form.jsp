<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Adding products to this restaurant</h3>
	
	
	<form action="insertProducts" method="Post">
	
	
		Name: <input type="text" name="name"> <form:errors path="product.name" /><br/>
		
		Description: <input type="text" name="description"> <form:errors path="product.description" /><br/>
		
		Available: <input type="text" name="available"> <form:errors path="product.available" /><br/>
		
		Photo: <input type="file" name="photo"> <form:errors path="product.photo" /><br/>
		
		<input type="hidden" name="restaurant" value="${restaurant}">
		
		<input type="submit" value="Add" />
	</form>
</body>
</html>