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
		<div class="row">
 				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
 						<div class="caption">
							<h3>First Name - ${user.firstName}</h3>
							<h3>Last Name -  ${user.lastName}</h3>
							<p>Alert Channel -         ${user.channel}</p>
							<p>Email -       ${user.email} </p>

						</div>
					</div>
				</div>
 
		</div>
	</section>
</body>
</html>
