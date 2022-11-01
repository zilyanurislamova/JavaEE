<%--
  Created by IntelliJ IDEA.
  User: bllizard
  Date: 01.11.2022
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Testing cart</title>
</head>
<body>
    <h1>Cart</h1>

    <%@ page import="logic.Cart" %>

    <% Cart cart = (Cart) session.getAttribute("cart"); %>

    <p> <%= "Продукт: " + cart.getProduct() %> </p>
    <p> <%= "Количество: " + cart.getQuantity() %> </p>
</body>
</html>
