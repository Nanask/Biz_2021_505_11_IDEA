<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${rootPath}/static/css/main.css?ver=2021-11-09" rel="stylesheet">
    <link href="${rootPath}/static/css/write.css?ver=2021-11-09" rel="stylesheet">
    <title>Title</title>
</head>
<body>
    <header>
        <h1>READ BOOK</h1>
        <p>하루 한 장 부터 시작하기!</p>
    </header>
    <section class="content">
        <tiles:insertAttribute name="content"/>
    </section>
    <footer>
        <address>CoPyRight &copy; ybhag1005@daum.net</address>
    </footer>
</body>
</html>
