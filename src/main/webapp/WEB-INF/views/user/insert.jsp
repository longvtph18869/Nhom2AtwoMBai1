<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<form action="insert" method="POST">
			<div class="form-group">
				<label>FullName</label> <input type="text" name="fullName"
					class="form-control" required>
			</div>
			<div class="form-group">
				<label>Gender</label>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="gender" value="1" checked>
					<label class="form-check-label"> Nam</label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="gender" value="0">
					<label class="form-check-label"> Nữ</label>
				</div>
			</div>
			<div class="form-group">
				<label>Birthday</label> <input type="date" name="birthDay"
					class="form-control" required>
			</div>
			<button type="submit" class="btn btn-success custom-width">Insert</button>
		</form>
	</div>
</body>
</html>