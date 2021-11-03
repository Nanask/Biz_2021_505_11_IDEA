<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 403
  Date: 2021-11-03
  Time: 오전 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<C:set var="rootPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${rootPath}/static/css/list.css">
</head>
<style>

</style>
<body>
<%@ include file="home.jsp"%>
    <table class="student_list">
        <tr>
            <th>학번</th>
            <th>이름</th>
            <th>전공</th>
            <th>학년</th>
            <th>주소</th>
            <th>전화번호</th>
        </tr>
        <tr>
            <td>20210001</td>
            <td>홍길동</td>
            <td>컴퓨터공학</td>
            <td>2</td>
            <td>서울시 동대문구</td>
            <td>02-222-1234</td>
        </tr>
        <tr>
            <td>20210002</td>
            <td>성춘향</td>
            <td>전자공학</td>
            <td>3</td>
            <td>전라북도 익산시</td>
            <td>063-111-1234</td>
        </tr>
    </table>
<button class="btn_save">학생정보 추가</button>
</body>
</html>
