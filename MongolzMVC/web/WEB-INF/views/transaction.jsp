<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<title>Transaction</title>
</head>
<body>
<section>
	<div class="jumbotron">
		<div class="container">
			<h1>Transaction</h1>
			<p>Do transaction</p>
		</div>
	</div>
</section>
<section class="container">
	<form:form  modelAttribute="newTransaction" class="form-horizontal" >
		<fieldset>
			<legend>Do tran</legend>

			<form:errors path="*" cssClass="alert alert-danger" element="div"/>

			<div class="form-group">
				<label class="control-label col-lg-2" for="fromAccount"></label>
				<div class="col-lg-10">
					<form:select path="fromAccount.id" cssClass="" id="fromAccount">
						<c:forEach items="${accounts}" var="account">
							<form:option value="${account.id}" label="${acccount.id + '-' + account.accountName}"/>
						</c:forEach>
					</form:select>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2" for="toAccount"><spring:message code="transaction.form.toAccount.label"/></label>
				<div class="col-lg-10">
					<div class="form:input-prepend">
						<form:input id="toAccount" path="toAccount.id" type="text" class="form:input-large"/>
						<form:errors path="toAccount.id" cssClass="text-danger"/>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2" for="amount"><spring:message code="transaction.form.amount.label"/></label>
				<div class="col-lg-10">
					<div class="form:input-prepend">
						<form:input id="amount" path="amount" type="text" class="form:input-large"/>
						<form:errors path="amount" cssClass="text-danger"/>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2" for="description"><spring:message code="transaction.form.description.label"/></label>
				<div class="col-lg-10">
					<form:input id="description" path="description" type="text" class="form:input-large"/>
					<form:errors path="description" cssClass="text-danger"/>
				</div>
			</div>


			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class="btn btn-primary" value ="Submit"/>
				</div>
			</div>

		</fieldset>
	</form:form>
</section>
</body>
</html>
