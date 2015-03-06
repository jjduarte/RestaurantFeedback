<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restauant List</title>
</head>
<body>
	<ul>
		<c:forEach var="restaurant" items="${list}">
			<li>${fornecedor.id} - ${fornecedor.nome} - ${fornecedor.pais.nome} </li>
			<ul>
				<c:forEach var="product" items="${restaurant.dishes}">
					<li>${product.id} -  ${product.name} </li>
				</c:forEach>
			</ul>
		</c:forEach>
	</ul>
</body>
</html>