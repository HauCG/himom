<%--
  Created by IntelliJ IDEA.
  User: maitr
  Date: 1/2/2025
  Time: 12:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Account Details</h2>

<div>
    <label for="accountId">Account ID:</label>
    <span id="accountId">${account.accountId}</span> <!-- Tránh dùng ID trùng lặp với các input khác -->
</div>

<div>
    <label for="accountName">Account Name:</label>
    <span id="accountName">${account.accountName}</span> <!-- Dùng id riêng cho mỗi trường -->
</div>

<div>
    <label for="accountPassword">Account Password:</label>
    <span id="accountPassword">${account.accountPassword}</span> <!-- Dùng id riêng cho mật khẩu -->
</div>

<div>
    <label for="accountEmail">Account Email:</label>
    <span id="accountEmail">${account.accountEmail}</span> <!-- Dùng id riêng cho email -->
</div>

<!-- Nút quay lại danh sách tài khoản -->
<form action="${pageContext.request.contextPath}/listAccount" method="get">
    <button type="submit">Back to Account List</button>
</form>
