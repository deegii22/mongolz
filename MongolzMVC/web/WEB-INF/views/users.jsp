<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
	<%@ include file="header.jsp"%>
	<title>Users</title>
</head>
<body>
<%@ include file="menu.jsp"%>
	<section class="container">
		<h3>Users</h3>
		<div class="row">
			<a href="/users/add" class="btn btn-primary">Register</a>
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>User ID</th>
						<th>User First Name</th>
						<th>User Last Name</th>
						<th>Username</th>
						<th>User enabled</th>
						<th>Alert channel</th>
						<th>Email</th>
					</tr>
				</thead>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.id}</td>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.userCredentials.username}</td>
						<td>${user.userCredentials.enabled}</td>
						<td>${user.channel}</td>
						<td>${user.email}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</section>
</body>
</html>
