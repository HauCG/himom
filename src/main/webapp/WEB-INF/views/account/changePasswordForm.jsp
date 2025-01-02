<%--
  Created by IntelliJ IDEA.
  User: maitr
  Date: 1/2/2025
  Time: 1:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Change Password</title>
</head>
<body>
<h2>Change Password</h2>

<form:form modelAttribute="account" action="${pageContext.request.contextPath}/updateAccountPasswordAction"
           method="post">
    <!-- Display current username (read-only) -->
    <div>
        <label for="accountName">Account Name:</label>
        <form:input path="accountName" id="accountName" readonly="true"/>
    </div>

    <div>
        <label for="accountPassword">Account Current Password:</label>
        <form:input path="accountPassword" id="accountPassword" readonly="true"/>
    </div>


    <form:hidden path="accountEmail"/>

    <div>
        <label for="newPassword">New Password:</label>
        <input type="password" name="newPassword" id="newPassword" required="true"/>
    </div>

    <div>
        <button type="submit">Submit</button>
    </div>

    <div>
        <a href="${pageContext.request.contextPath}/listAccount">Back to List</a>
    </div>
</form:form>
</body>
</html>
