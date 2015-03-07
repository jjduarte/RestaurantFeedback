<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.0/angular.min.js"></script>

<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-theme.min.css">
	

<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>

<title>Restauant List</title>
	<style>
		.panel-heading img {
   		   height: 100%;
		   width: 100%;
		}
	</style>
</head>
<body>
	<ul>
		<c:forEach var="product" items="${productList}">
			<div class="row">
				<div class="col-lg-6 col-md-6 col-xs-6 col-sm-6">
					<div class="panel panel-default">
						<div class="panel-heading">
							<img src="resources/imgs/${product.photo}" alt="${product.name}"
								title="${product.name}">
						</div>
						<div class="panel-heading">${product.restaurant.name}-
							${product.name}</div>
						<div class="panel-body">
							${product.description} <br /> <a href="#">Rate</a>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</ul>
</body>
</html>