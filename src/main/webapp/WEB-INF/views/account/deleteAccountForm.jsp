<%--
  Created by IntelliJ IDEA.
  User: maitr
  Date: 1/2/2025
  Time: 12:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Are you sure you want to delete this account?</h2>

<div>
    <label for="accountId">Account ID:</label>
    <span id="accountId">${account.accountId}</span>
</div>

<div>
    <label for="accountName">Account Name:</label>
    <span id="accountName">${account.accountName}</span>
</div>

<div>
    <label for="accountEmail">Account Email:</label>
    <span id="accountEmail">${account.accountEmail}</span>
</div>

<form action="${pageContext.request.contextPath}/deleteAccountAction/${account.accountId}" method="post">
    <button type="submit">Yes, Delete Account</button>
</form>

<form action="${pageContext.request.contextPath}/listAccount" method="get">
    <button type="submit">Cancel</button>
</form>
