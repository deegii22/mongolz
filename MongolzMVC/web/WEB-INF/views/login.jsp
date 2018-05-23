<%--
  Created by IntelliJ IDEA.
  User: eta
  Date: 5/22/18
  Time: 11:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <%@ include file="header.jsp"%>
    <title>Mongolz Ebank Login</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <div class="logo"></div>
        </div>
    </div>
</section>
<div class="bg">
    <div class="container">
        <div class="row">
            <div class="col-md-4 animated fadeInDown login-form">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Log in</h3>
                    </div>
                    <div class="panel-body">
                        <c:if test="${not empty error}">
                            <div class="alert alert-danger">
                                <spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/><br/>
                            </div>
                        </c:if>
                        <form action="<spring:url value="/postLogin"></spring:url>" method="post">
                            <sec:csrfInput/>
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="User Name" name='username' type="text">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name='password' type="password"
                                           value="">
                                </div>
                                <input class="btn btn-lg btn-success btn-mini" type="submit" value="Login">
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="footer">
    Mongolz, All rights reserved
</div>
</body>
