<%--
  Created by IntelliJ IDEA.
  User: 403
  Date: 2021-11-09
  Time: 오전 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
    <tiles:insertAttribute name="header"/>
    <section class="content">
        <tiles:insertAttribute name="content"/>
    </section>
</body>
</html>
