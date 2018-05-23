<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
	<%@ include file="header.jsp"%>
	<title>Accounts</title>
</head>
<body>
<%@ include file="menu.jsp"%>
	<section class="container">
		<h3>Accounts</h3>
		<div class="row">
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Account Number</th>
						<th>Account Name</th>
						<th>Account Balance</th>
						<th></th>
					</tr>
				</thead>
				<c:forEach items="${accounts}" var="account">
					<tr>
						<td>${account.id}</td>
						<td>${account.accountName}</td>
						<td>${account.balance}</td>
						<td>
							<a href="/transactions/${account.id}" class="btn">View transactions</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</section>
</body>
</html>
