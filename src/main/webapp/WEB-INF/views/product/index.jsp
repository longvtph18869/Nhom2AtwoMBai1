<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<a href="product/add"><button type="button"
			class="btn btn-success custom-width">Insert</button></a>
	<table class="table table-hover table-bordered">
		<thead>
			<tr>
				<th>ID</th>
				<th>Product Name</th>
				<th>Product Amount</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listproduct}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.productName}</td>
					<td>${product.productAmount}</td>
					<td class="text-center"><a href="product/edit/${product.id}"><button
								class="btn btn-primary custom-width">Edit</button></a></td>
					<td class="text-center"><a
						href="product/delete/${product.id}"><button
								class="btn btn-danger custom-width">Remove</button></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>