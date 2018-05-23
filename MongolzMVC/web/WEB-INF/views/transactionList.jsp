<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
			<form:form modelAttribute="transactionPeriod" class="form-horizontal">
				<div class="form-group">
					<label class="control-label col-lg-2" for="fromDate"><spring:message
							code="transaction.form.accountNumber.label"/></label>
					<div class="col-lg-4">
						${accountId}
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="fromDate"><spring:message
							code="transaction.form.fromDate.label"/></label>
					<div class="col-lg-4">
						<div class="form:input-prepend">
							<form:input id="fromDate" path="fromDate" type="date" class="form-control"/>
							<form:errors path="fromDate" cssClass="text-danger"/>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="toDate"><spring:message
							code="transaction.form.toDate.label"/></label>
					<div class="col-lg-4">
						<div class="form:input-prepend">
							<form:input id="toDate" path="toDate" type="date" class="form-control"/>
							<form:errors path="toDate" cssClass="text-danger"/>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-4">
						<input type="submit" id="btnAdd" class="btn btn-primary" value="Search"/>
					</div>
				</div>
			</form:form>
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
						<td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${transaction.transactionDate}" /></td>
						<td>${transaction.fromAccount.id} - ${transaction.fromAccount.accountName}</td>
						<td>${transaction.toAccount.id} - ${transaction.toAccount.accountName}</td>
						<td align="right">${transaction.amount}</td>
						<td>${transaction.description}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</section>
</body>
</html>
