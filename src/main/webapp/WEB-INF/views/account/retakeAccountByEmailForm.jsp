<%--
  Created by IntelliJ IDEA.
  User: maitr
  Date: 1/2/2025
  Time: 1:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Retake Account by Email</title>
</head>
<body>

<h2>Retrieve Account by Email</h2>

<form:form modelAttribute="account" action="${pageContext.request.contextPath}/retakeAccountByEmailFormAction" method="post">
    <div>
        <label for="accountEmail">Email:</label>
        <form:input path="accountEmail" id="accountEmail" type="email" required="true" />
    </div>
    <div>
        <button type="submit">Submit</button>
    </div>
</form:form>




<c:if test="${not empty errorMessage}">
    <div style="color: red;">
        <strong>${errorMessage}</strong>
    </div>
</c:if>


<form action="${pageContext.request.contextPath}/listAccount" method="get">
    <button type="submit">Back to Account List</button>
</form>

</body>
</html>
