<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Account</title>
</head>
<body>
<h2>Update Account</h2>

<form:form method="POST" action="${pageContext.request.contextPath}/updateAccountAction" modelAttribute="account">


    <form:input type="hidden" path="accountId" id="accountId"/>


    <div>
        <label for="accountName">Account Name:</label>
        <form:input path="accountName" id="accountName"/>
    </div>


    <div>
        <label for="accountPassword">Account Password:</label>
        <form:input type="password" path="accountPassword" id="accountPassword" value="${account.accountPassword}"/>
    </div>


    <div>
        <label for="accountEmail">Account Email:</label>
        <form:input path="accountEmail" id="accountEmail"/>
    </div>

    <div>
        <button type="submit">Update Account</button>
    </div>

</form:form>

<!-- Nút quay lại danh sách tài khoản -->
<form action="${pageContext.request.contextPath}/listAccount" method="get">
    <button type="submit">Back to Account List</button>
</form>
</body>
</html>
