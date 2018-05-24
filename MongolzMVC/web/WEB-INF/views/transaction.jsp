<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <%@ include file="header.jsp" %>
    <title>Transaction</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<section class="container">
    <h3>Transfer money</h3>
    <form:form modelAttribute="newTransaction" class="form-horizontal">

        <c:if test="${not empty error}">
            <div class="alert alert-danger">
                ${error}<br/>
            </div>
        </c:if>
        <form:errors path="*" cssClass="alert alert-danger" element="div"/>

        <div class="form-group">
            <label class="control-label col-lg-2" for="fromAccount"><spring:message
                    code="transaction.form.fromAccount.label"/></label>
            <div class="col-lg-4">
                <form:select path="fromAccount.id" cssClass="form-control" id="fromAccount">
                    <c:forEach items="${accounts}" var="account">
                        <form:option value="${account.id}"/>
                    </c:forEach>
                </form:select>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2" for="toAccount"><spring:message
                    code="transaction.form.toAccount.label"/></label>
            <div class="col-lg-4">
                <div class="form:input-prepend">
                    <form:input id="toAccount" path="toAccount.id" type="text" class="form-control"/>
                    <form:errors path="toAccount.id" cssClass="text-danger"/>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2" for="amount"><spring:message
                    code="transaction.form.amount.label"/></label>
            <div class="col-lg-4">
                <div class="form:input-prepend">
                    <form:input id="amount" path="amount" type="text" class="form-control"/>
                    <form:errors path="amount" cssClass="text-danger"/>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2" for="description"><spring:message
                    code="transaction.form.description.label"/></label>
            <div class="col-lg-4">
                <form:input id="description" path="description" type="text" class="form-control"/>
                <form:errors path="description" cssClass="text-danger"/>
            </div>
        </div>


        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-4">
                <input type="submit" id="btnAdd" class="btn btn-primary" value="Submit"/>
            </div>
        </div>
    </form:form>
</section>
</body>
</html>
