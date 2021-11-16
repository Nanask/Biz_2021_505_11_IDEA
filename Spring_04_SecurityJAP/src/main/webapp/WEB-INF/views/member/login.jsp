<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<link href="${rootPath}/static/css/login.css" rel="stylesheet">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="${rootPath}/webjars/jquery/dist/jquery.min.js"></script>
<script>
    $(function (){
        $("button.btn_join").on("click", function () {
            location.href = `${rootPath}/member/join`
        })
    })
</script>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form:form action="${rootPath}/login" cssClass="login_form" >
    <fieldset>
        <legend>Login</legend>
        <c:if test="${param.error != null}">${AUTHOR}
            <h3>${ERROR_MSG == null ? "로그인을 하세요" : ERROR_MSG}</h3>
        </c:if>

            <%--        <c:forEach items="" ></c:forEach>--%>
        <input placeholder="ID를 입력하세요" name="userId" />
        <input placeholder="비밀번호를 입력하세요" name="password" type="password" />
        <button class="btn btn_login">로그인</button>
        <button class="btn btn_join" type="button">회원가인</button>
    </fieldset>
    <h1>${AUTHOR}</h1>
</form:form>

</body>
</html>