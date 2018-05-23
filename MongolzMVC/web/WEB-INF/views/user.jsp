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
 				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<p>First Name - ${user.firstName}</p>
					<p>Last Name -  ${user.lastName}</p>
					<p>Alert Channel -         ${user.channel}</p>
					<p>Email -       ${user.email} </p>
				</div>
		</div>
	</section>
</body>
</html>
