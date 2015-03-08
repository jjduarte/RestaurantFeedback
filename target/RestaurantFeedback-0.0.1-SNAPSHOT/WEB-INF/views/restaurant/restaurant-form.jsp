<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create new Restaurant</title>
</head>
<body>
	<h3>Adding new Restaurant</h3>
	<form action="insertRestaurant" method="Post">
	
	
		Name: <input type="text" name="name"> <form:errors path="restaurant.name" /><br/>
		
		CNPJ: <input type="text" name="cnpj"> <form:errors path="restaurant.cnpj" /><br/>
		
		Login: <input type="text" name="login"> <form:errors path="restaurant.login" /><br/>
		
		Password: <input type="text" name="password"> <form:errors path="restaurant.password" /><br/>
		
		<input type="submit" value="Add" />
	</form>
</body>
</html>