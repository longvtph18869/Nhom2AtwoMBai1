<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="w-25 ms-3">
		<form action="${product.id}" method="POST">
			<div class="form-group">
				<label>Product Name</label> <input type="text" name="productName"
					class="form-control" value="${product.productName}" required>
			</div>
			<div class="form-group">
				<label>Product Amount</label> <input type="number" name="productAmount"
					class="form-control" value="${product.productAmount}" required>
			</div>
			<button type="submit" class="btn btn-success custom-width">Update</button>
		</form>
	</div>
</body>
</html>