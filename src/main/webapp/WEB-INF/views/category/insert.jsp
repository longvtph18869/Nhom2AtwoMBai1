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
				<label>Code</label> <input type="text" name="code"
					class="form-control" required>
			</div>
			<div class="form-group">
				<label>Name</label> <input type="text" name="name"
					class="form-control" required>
			</div>
			<div class="form-group">
				<label>Description</label>
				<textarea rows="9" cols="70" name="description" class="form-control" required> 				
				</textarea>
			</div>
			<button type="submit" class="btn btn-success custom-width">Insert</button>
		</form>
	</div>
</body>
</html>