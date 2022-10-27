<%--
  Created by IntelliJ IDEA.
  User: bllizard
  Date: 25.10.2022
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First JSP</title>
</head>
<body>
    <h1>Testing JSP</h1>
    <p>
        <%@ page import="java.util.Date, logic.MyClass" %>

        <% MyClass myClass = new MyClass(); %>

        <%= myClass.getMessage() %>
    </p>
</body>
</html>
