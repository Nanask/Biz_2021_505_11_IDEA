<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 403
  Date: 2021-11-03
  Time: 오전 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <link href="${rootPath}/static/css/main.css" rel="stylesheet">
</head>
<body>
<header class="main_header">
    <h1>고려 고교 학사관리 2021 V1</h1>
</header>
    <nav class="main_nav">
        <ul>
            <li>Home</li>
            <li>학생정보</li>
            <li>성적알림표</li>
            <li>로그인</li>
        </ul>
    </nav>
</body>
<script>
    document.querySelector("nav").addEventListener("click", (e)=> {
        let tagName = e.target.tagName;
        if(tagName === "LI") {
            if(e.target.textContent === "학생정보") {
                location.href="http://localhost:8080/student/stu/list"
            }
        }
    })
</script>
</html>
