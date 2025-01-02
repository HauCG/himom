<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Account</title>
</head>
<body>
<h2>Create New Account</h2>

<form:form method="POST" action="${pageContext.request.contextPath}/registerAction" modelAttribute="account">
    <div>
        <label for="accountName">Account Name:</label>
        <form:input path="accountName" id="accountName" required="true"/>
    </div>
    <div>
        <label for="accountPassword">Account Password:</label>
        <form:password path="accountPassword" id="accountPassword" required="true"/>
    </div>
    <div>
        <label for="accountEmail">Account Email:</label>
        <form:password path="accountEmail" id="accountEmail" required="true"/>
    </div>
    <div>
        <button type="submit">Register</button>
    </div>
</form:form>

<form action="${pageContext.request.contextPath}/listAccount" method="get">
    <button type="submit">Back to Account List</button>
</form>
</body>
</html>
