<%--
  Created by IntelliJ IDEA.
  User: 403
  Date: 2021-11-12
  Time: 오전 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<script src="${rootPath}/webjars/jquery/dist/jquery.min.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<style>
    form.join_form {
        display: flex;
        flex-direction: column;
    }
    div.input_box {
        display: flex;
        flex-direction: column;
        align-content: center;
        flex-wrap: wrap;
    }
    div.input_box input {
        margin: 10px;
        padding: 15px;
    }
    div.btn_join_button {
        text-align: center;
    }

    div.input_error {
        color: red;
        font-weight: bold;
    }
</style>
<%
/*
form : form tag를 이용한 입력폼 디자인
security 에서 form에 데이터를 입력하고
서버로 전송할 때는 반드시 POST 방식으로 전송해야 한다

GET 방식으로 데이터를 전송할 때는 인증(로그인정보)와 관련된
어떤 기능을 수행할 수 없다
인증과 관련하여 어떤 기능을 수행하려면 모든 것은 POST로 요청해야 한다

또한 POST 방식으로 요청을 할 때는 반드시 _csrf.token 정보를 함께 전송해야 한다
그렇지 않으면 모든 요청에 대해서 서버에서 거부한다

form 으로 만든 입력변수 중에 _csrf.token 값에 서버로부터 전달 받은 실제 token 을 부착하는 코드를 만들어야 한다

이러한 절차가 순수 html 로 만든 form 에서는 상당히 번거로운 일이 된다.
따라서 spring sjp 코드에서는 spring form taglib 를 import 하고
form: form 방식으로 HTML 코드를 작성한다

form: form 방식으로 HTML 코드를 작성하게 되면
자동으로 _csrf.token 과 관련된 코드가 추가된다.

POST는 http의 body에 담겨서 보내지기 때문에 일반적으로 데이터를 볼 수 없다

원래는 http로는 불가하고 https로 만들어야 한대요
그게 정보통신보안법상 문제가 없다고 하네염

*/
%>
<body>
<form:form cssClass="join_form">
<%--    <div class="input_box">--%>
    <div>
        <input  name="username" id="username" placeholder="사용자 이름"/>
    </div>
    <%--        MSG가 null이면 로그인을 하도록 메세지를 보이고, 아니라면 ERROR_MSG를 보이게 하라--%>
    <div class="input_error">
    </div>
    <div>
        <input name="password" id="password" placeholder="비밀번호"/>
    </div>
    <div>
        <input name="re_password" id="re_password" placeholder="비밀번호 확인"/>
    </div>
    <div>
        <input name="email" id="email" placeholder="Email"/>
    </div>
<%--    </div>--%>
    <div class="btn_join_button">
        <button class="btn_join_ok" type="button">회원가입 신청</button>
    </div>
</form:form>
</body>
<script>
    $(function(){

        // 입력박스에서 tab을 누르거나 마우스를 다른 곳으로 클릭했을 때
        // lost focus
        $("input#username").on("blur", function () {
            // ID 중복검사
            // ${rootPath}/member/idcheck=username=nana
            // username이라는 변수에 현재 입력박스에 있는 값을 보내라
            $.ajax({
                url: "${rootPath}/member/idcheck",
                data : {username:$(this).val()}
            })
                .done(function (result) {
                    //서버로 전송된 값이 null이 아니면(값이 들어있다면)
                    if (result) {
                        // alert("이미 사용중인 ID 입니다")
                        $(this).focus()
                        $("div.input_error").text("사용중인 ID입니다.")
                    } else {
                        // alert("사용가능한 ID 입니다")
                        $("div.input_error").text("사용 가능한 ID입니다.").css("color","blue")
                        $("#password").focus()
                    }
                })
        })
        $("button.btn_join_ok").on("click",function (){
            const username = $("#username")
            const password = $("#password")
            const re_password = $("#re_password")

            if(username.val() === "") {
                alert("사용자 이름은 반드시 입력하세요")
                username.focus()
                return false
            }
            if(password.val() === "") {
                alert("비밀번호는 반드시 입력하세요")
                password.focus()
                return false
            }
            if(re_password.val() === "") {
                alert("비밀번호를 한번 더 입력해 주세요")
                re_password.focus()
                return false
            }
            if(password.val() !== re_password.val()) {
                alert("비밀번호와 비밀번호 확인이 일치하지 않습니다")
                password.val("")
                re_password.val("")
                password.focus()
                return false
            }
            $("form.join_form").submit()
        })
    })

</script>
</html>
