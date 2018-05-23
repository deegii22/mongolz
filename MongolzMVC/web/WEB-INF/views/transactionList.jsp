<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
	<%@ include file="header.jsp"%>
	<title>Transaction List</title>
</head>
<body>
<%@ include file="menu.jsp"%>
	<section class="container">
		<h3>Transaction List</h3>
		<div class="row">
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Transaction Number</th>
						<th>Transaction Date</th>
						<th>From Account</th>
						<th>To Account</th>
						<th>Transaction Amount</th>
						<th>Transaction Desc</th>
					</tr>
				</thead>
				<c:forEach items="${transactions}" var="transaction">
					<tr>
						<td>${transaction.id}</td>
						<td>${transaction.transactionDate}</td>
						<td>${transaction.fromAccount.id}</td>
						<td>${transaction.toAccount.id}</td>
						<td align="right">${transaction.amount}</td>
						<td>${transaction.description}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</section>
</body>
</html>
