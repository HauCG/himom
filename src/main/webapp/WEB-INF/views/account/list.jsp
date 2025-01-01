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


<%--private String accountId;--%>
<%--private String accountName;--%>
<%--private String accountPassword;--%>

<table>
    <caption>Account List</caption>
    <thead>
    <tr>
        <th>Account Id</th>
        <th>Account Name</th>
        <th>Account Password</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${requestScope.allAccount}">
        <tr>
            <td>
                <c:out value="${c.accountId}"/>
            </td>
            <td>
                <c:out value="${c.accountName}"/>
            </td>
            <td>
                <c:out value="${c.accountPassword}"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>