<%--
  Created by IntelliJ IDEA.
  User: eta
  Date: 5/23/18
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <style>
        .code {
            max-width: 100px;
            max-height: 50px;
            overflow: hidden;
        }
        .code:hover {
            max-width: auto;
            max-height: auto;
        }
    </style>
    <title>Welcome</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1> Mongolz banking REST Services </h1>
        </div>

    </div>
</section>


<div class="jumbotron container">
    <p>Transactions/p>
    <table class="table .table-dark">
        <thead>
        <tr>
            <th scope="col">Method</th>
            <th scope="col">URL</th>
            <th scope="col">Description</th>
            <th scope="col">Body</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">GET</th>
            <td>${base_url}/transaction</td>
            <td>Find all transactions</td>
            <td></td>
        </tr>
        <tr>
            <th scope="row">GET</th>
            <td>${base_url}/transaction/{id}</td>
            <td>Find transaction with specific id</td>
            <td></td>
        </tr>
        <tr>
            <th scope="row">POST</th>
            <td>${base_url}/transaction</td>
            <td>Add new transaction</td>
            <td></td>
        </tr>
        </tbody>
    </table>
</div>

<div class="jumbotron container">
    <p>Messaging</p>
    <table class="table .table-dark">
        <thead>
        <tr>
            <th scope="col">Method</th>
            <th scope="col">URL</th>
            <th scope="col">Description</th>
            <th scope="col">Body</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">GET</th>
            <td>${base_url}/{email}</td>
            <td>{base_url}/{email}</td>
            <td></td>
        </tr>

        </tbody>
    </table>
</div>

</body>
</html>
