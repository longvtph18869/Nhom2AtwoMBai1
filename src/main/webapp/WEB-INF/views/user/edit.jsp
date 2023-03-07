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
		<form action="${user.id}" method="POST">
			<div class="form-group">
				<label>FullName</label> <input type="text" name="fullName"
					class="form-control" value="${user.fullName}" required>
			</div>
			<div class="form-group">
				<label>Gender</label>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="gender"
						value="1" ${user.gender == 1 ? 'checked' : ''}> <label
						class="form-check-label"> Nam</label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="gender"
						value="0" ${user.gender == 0 ? 'checked' : ''}> <label
						class="form-check-label"> Nữ</label>
				</div>
			</div>
			<div class="form-group">
				<fmt:formatDate value="${user.birthDay}" var="birthday"
					pattern="yyyy-MM-dd" />
				<label>Birthday</label> <input type="date" name="birthDay"
					class="form-control" value="${birthday}" required>
			</div>
			<button type="submit" class="btn btn-success custom-width">Update</button>
		</form>
	</div>
</body>
</html>