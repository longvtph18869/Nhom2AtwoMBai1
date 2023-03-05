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
	<a href="/users/insert"><button type="button"
			class="btn btn-success custom-width">Insert</button></a>
	<table class="table table-hover table-bordered">
		<thead>
			<tr>
				<th>ID</th>
				<th>FullName</th>
				<th>Gender</th>
				<th>Birthday</th>
				<th>Edit</th>
				<th>Remove</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.fullName}</td>
					<td>${user.gender == 1 ? 'Nam' :'Nữ'}</td>
					<fmt:formatDate value="${user.birthDay}" var="birthday"
						pattern="dd-MM-yyyy" />
					<td>${birthday}</td>
					<td class="text-center"><a href="/users/edit/${user.id}"><button
								class="btn btn-primary custom-width">Edit</button></a></td>
					<td class="text-center"><a
						href="/users/delete/${user.id}"><button
								class="btn btn-danger custom-width">Remove</button></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>