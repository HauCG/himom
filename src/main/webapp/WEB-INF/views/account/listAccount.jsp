<%--
  Created by IntelliJ IDEA.
  User: maitr
  Date: 1/1/2025
  Time: 11:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    table {
        border: 1px solid #000;
    }

    th, td {
        border: 1px dotted #555;
    }
</style>
There are ${requestScope.allAccount.size()} account(s) in list.

<table>
    <caption>Account List</caption>
    <thead>
    <tr>
        <th>Account Name</th>
        <th>Account Email</th>
        <th>Account Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${requestScope.allAccount}">
        <tr>
            <td>
                <c:out value="${c.accountName}"/>
            </td>
            <td>
                <c:out value="${c.accountEmail}"/>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/updateAccountForm/${c.accountId}" method="get"
                      style="display:inline;">
                    <button type="submit">Update</button>
                </form>
                <form action="${pageContext.request.contextPath}/deleteAccountForm/${c.accountId}" method="get"
                      style="display:inline;">
                    <button type="submit">Delete</button>
                </form>
                <form action="${pageContext.request.contextPath}/detailsAccountForm/${c.accountId}" method="get"
                      style="display:inline;">
                    <button type="submit">Details</button>
                </form>

                <form action="${pageContext.request.contextPath}/retakeAccountByEmailForm/" method="get"
                      style="display:inline;">
                    <button type="submit">retake</button>
                </form>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<form action="${pageContext.request.contextPath}/registerAccountForm" method="get">
    <button type="submit">Register New Account</button>
</form>

