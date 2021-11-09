<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<style>

</style>

<form class="input_form">
    <div class="input_one">
        <input placeholder="ISBN"/>
        <input placeholder="Do It 자바"/>
    </div>
    <div class="input_date">
        <input placeholder="2021-10-27"/>
        <input placeholder="10:12:22"/>
        <input placeholder="12:32:12"/>
    </div>
    <div>
        <input placeholder="생각 중독은 깊은 생각에 빠져 주위를 돌아보지 못하는 것이다."/>
    </div>
    <div>
        <textarea>내용을 입력해주세요</textarea>
    </div>
    <div class="btn_box">
        <button type="submit" class="btn_save">저장</button>
        <button type="reset" class="btn_reset">새로작성</button>
        <button type="button" class="btn_list">리스트보기</button>
    </div>
</form>