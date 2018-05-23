 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 
<html>
<head>
	<%@ include file="header.jsp"%>
<title>User Detail</title>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<section class="container">
		<h3>User Details</h3>
			<div class="row">
				<label class="control-label col-lg-2">First Name:</label>
				<div class="col-lg-10">
					${userDetail.firstName}
				</div>
			</div>
			<div class="row">
				<label class="control-label col-lg-2">Last Name:</label>
				<div class="col-lg-10">
					${userDetail.lastName}
				</div>
			</div>
			<div class="row">
				<label class="control-label col-lg-2">Alert Channel:</label>
				<div class="col-lg-10">
					${userDetail.channel}
				</div>
			</div>
			<div class="row">
				<label class="control-label col-lg-2">Email:</label>
				<div class="col-lg-10">
					${userDetail.email}
				</div>
			</div>
	</section>
</body>
</html>
