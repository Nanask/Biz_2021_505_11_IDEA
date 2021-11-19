<%--
  Created by IntelliJ IDEA.
  User: 403
  Date: 2021-11-17
  Time: 오전 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
    <link href="${rootPath}/static/main.css" rel="stylesheet">
</head>
<body>
<header>
    <h1>READ BOOK 2021</h1>
</header>
<nav>
    <ul>
        <li>Home</li>
        <li>
<%--            inputbox에 값을 입력하면 post 방식으로 값을 전달하라는 의미--%>
        <form method="POST">
            <input name="search" placeholder="검색어를 입력하세요"/>
        </form>
        </li>
    </ul>

</nav>
<section class="main">

</section>
<footer>
    <address>CopyRight &copy; ybhag1005@daum.net</address>
</footer>
</body>
</html>
