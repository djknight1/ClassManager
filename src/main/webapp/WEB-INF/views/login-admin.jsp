<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理 - ZUST Computer Science 16</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Login-main.css">

</head>
<body>
<div class="main-body">
    <div id="login-container">
        <div class="pic-container">
            <img src="logo.png">
            <div class="pic-title">
                管理员登陆
            </div>
        </div>
        <div class="layui-tab">
            <ul class="layui-tab-title">
                <li class="layui-this">登陆</li>
            </ul>
            <form class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <div class="user-name-input-container">
                        <span  id="username-input-error" style="display: none;">账号格式错误！</span>
                        <input  class="layui-input login-item login-name" id="username" type="text" name="username" required
                               lay-verify="required" placeholder="用户名" autocomplete="off">
                    </div>
                    <div class="password-input-container">
                        <input class="layui-input login-item login-password" id="password" type="password"
                               name="password" required lay-verify="required" placeholder="密码" autocomplete="off">
                        <a class="change-visiable " href="javascript:void(0);">
                            <i class="iconfont visiable-icon">&#xe6a5;</i>
                            <i class="iconfont notvisiable-icon" style="display: none;">&#xe6a2;</i>
                        </a>
                    </div>
                    <div class="login-option clearfix">
                        <input type="button" class="button-control" id="forget-password" value="忘记密码请找开发者">
                    </div>
                </div>
                <div class="login-button-container">
                    <button id="submit-btn" class="layui-btn layui-btn-lg layui-btn-radius layui-btn-normal" type="submit">登陆</button>
                </div>
            </form>

        </div>
    </div>
    <footer class="footer-main">
        <div class="footer-line footer-line1">
            <a href="#">XXXX</a>
            <a href="#">XXXX</a>
            <a href="#">XXXX</a>
            <a href="#">XXXX</a>
            <a href="#">XXXX</a>
        </div>
        <div class="footer-line footer-line2">
            <a href="#">XXXX</a>
            <a href="#">XXXX</a>
            <a href="#">XXXXX</a>
            <a href="#">XXXX</a>
            <a href="#">XXXX</a>
        </div>
        <div class="footer-line footer-line3">
            <a href="#">XXXX</a>
            <a href="#">XXXX</a>
            <a href="#">XXXX</a>
            <a href="#">XXXX</a>
            <a href="#">XXXXXXXXXXXXX</a>
        </div>
    </footer>
</div>



<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script src="${pageContext.request.contextPath}//layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/js/login-layui.js"></script>
<script src="${pageContext.request.contextPath}/js/login-main.js"></script>
<script src="${pageContext.request.contextPath}/js/validator.js"></script>
<script src="${pageContext.request.contextPath}/js/input.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script>
<script>

    $(document).on("click", "#submit-btn", function (event) {
        event.preventDefault();
        var username = $("#username").val();
        var password = $("#password").val();
        $.ajax({
            type: 'POST',
            url: "/ajax/adminCheck",
            data: {
                'username': username,
                'password': password,
            },
            success: function (result) {
                var data = JSON.parse(JSON.stringify(result));
                if (data.msg === true) {
                    alert("登陆成功");
                    window.location.href = "/admin";
                } else if (data.msg === false) {
                    alert("账号密码错误/账号不存在");
                }

            },//JSON.stringify(data)
            error: function () {
                alert("error");
            }
        });
    });

</script>
</body>
</html>