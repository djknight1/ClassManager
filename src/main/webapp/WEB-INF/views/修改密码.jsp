<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改密码</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/initcss.css">
<script src="${pageContext.request.contextPath}/js/common.js"></script>
<script src="${pageContext.request.contextPath}/js/validate.js"></script>
<body>


<div id="main">
    <h1 class="main-head-text"><img src="${pageContext.request.contextPath}/img/smile.png" alt=""> 您的帐号当前处于安全状态，请放心操作</h1>
    <form id="pwd-form" action="success.jsp" method="post" onsubmit="return validate()">
        <div class="pwd">
            <span class="pwd_size">新的密码：</span>
            <input id="new-pwd" type="password" class="init" onblur="validateNewPwd()">
            <span id="new-pwdMsg"></span>
        </div>

        <div class="pwd">
            <span class="pwd_size">确认密码：</span>
            <input id="conf-pwd" type="password" class="init" onblur="validateConfPwd()">
            <span id="conf-pwdMsg"><!--<img src="./img/1.png" alt="">你的长度合适--></span>
        </div>

        <input id="submit-pwd" type="submit" value="确认修改">
    </form>
</div>

</body>
</html>