<%--
  Created by IntelliJ IDEA.
  User: eta
  Date: 5/23/18
  Time: 11:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <%@ include file="header.jsp"%>
    <title>Users</title>
</head>
<body>
<%@ include file="menu.jsp"%>
<section class="container">
    <h3>Add new user</h3>
    <form:form  modelAttribute="newUser" class="form-horizontal"  >
            <div class="form-group">
                <label class="control-label col-lg-2" for="firstName">First Name</label>
                <div class="col-lg-4">
                    <form:input id="firstName" path="firstName" type="text" class="form-control"/>
                    <form:errors path="firstName" cssClass="text-danger"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="lastName">Last Name</label>
                <div class="col-lg-4">
                    <form:input id="lastName" path="lastName" type="text" class="form-control"/>
                    <form:errors path="lastName" cssClass="text-danger"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="age">Email</label>
                <div class="col-lg-4">
                    <form:input id="age" path="email" type="text" class="form-control"/>
                    <form:errors path="email" cssClass="text-danger"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="title">Channel</label>
                <div class="col-lg-4">
                    <form:input id="title" path="channel" type="text" class="form-control"/>
                    <form:errors path="channel" cssClass="text-danger"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="userName">User Name</label>
                <div class="col-lg-4">
                    <div class="form:input-prepend">
                        <form:input id="username" path="userCredentials.username" type="text" class="form-control"/>
                        <form:errors path="userCredentials.username" cssClass="text-danger"/>
                    </div>
                </div>
            </div>


            <div class="form-group">
                <label class="control-label col-lg-2" for="password">Password</label>
                <div class="col-lg-4">
                    <div class="form:input-prepend">
                        <form:password id="password" path="userCredentials.password"  class="form-control"/>
                        <form:errors path="userCredentials.password" cssClass="text-danger"/>
                    </div>
                </div>
            </div>


            <div class="form-group">
                <label class="control-label col-lg-2">Verify Password</label>
                <div class="col-lg-4">
                    <div class="form:input-prepend">
                        <form:password  path="userCredentials.verifyPassword"  class="form-control"/>
                        <form:errors path="userCredentials.verifyPassword" cssClass="text-danger"/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2">Role</label>
                <div class="col-lg-4">
                    <form:select path="userCredentials.authority[0].authority" cssClass="form-control" id="fromAccount">
                        <option value="ROLE_ADMIN">ROLE_ADMIN</option>
                        <option value="ROLE_TRAN">ROLE_TRAN</option>
                        <option value="ROLE_READ">ROLE_READ</option>
                    </form:select>
                </div>
            </div>

            <form:hidden path="userCredentials.enabled" value="TRUE"  />


            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-4">
                    <input type="submit" id="btnAdd" class="btn btn-primary" value ="Register"/>
                </div>
            </div>

    </form:form>
</section>
</body>
</html>

