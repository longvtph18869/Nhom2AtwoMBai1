<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="w-25 ms-3">
		<form action="${category.id}" method="POST">
			<div class="form-group">
				<label>Code</label> <input type="text" name="code"
					value="${category.code}" class="form-control" required>
			</div>
			<div class="form-group">
				<label>Name</label> <input type="text" name="name"
					value="${category.name}" class="form-control" required>
			</div>
			<div class="form-group">
				<label>Description</label>
				<textarea rows="9" cols="70" name="description" class="form-control"
					required> 	
					${category.description}			
				</textarea>
			</div>
			<button type="submit" class="btn btn-success custom-width">Update</button>
		</form>
	</div>
</body>
</html>