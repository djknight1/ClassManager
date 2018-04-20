<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form>
    <div>用户名：<input id="username" type="text" name="username"></div>
    <div id="msg"></div>
    <div>
        <button id="check-username">检查用户是否存在</button>
    </div>
    <div>密码：<input id="password" type="password" name="password"></div>
    <div>昵称：<input id="nickname" type="text" name="nickname"></div>
    <div>邮箱: <input id="email" type="text" name="email"></div>
    <div>手机：<input id="mobiephone" type="text" name="mobiephone"></div>
    <div><input id="submit-btn" type="submit"></div>

</form>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>

<script>
    function ajax(username) {
        var ret;
        $.ajax({
            type: 'POST',
            url: "/login/register/username",
            data: {
                'username': username,
            },
            success: function (result) {
                var data = JSON.parse(JSON.stringify(result));
                if (data.msg) {
                    ret = 0;
                } else {
                    ret = 1;
                }
            },//JSON.stringify(data)
            error: function () {
                 return 2;
            }
        });
        return ret;
    }
    $(document).on("click", "#submit-btn", function (event) {
        event.preventDefault();
        var judge = ajax(username);
        var username = $("#username").val();
        var password = $("#password").val();
        var nickname = $("#nickname").val();
        var email = $("#email").val();
        var mobiephone = $("#mobiephone").val();
        if (1 === judge) {
            alert("用户名已存在")
            return;
        } else if (2 === judge) {
            alert("服务器忙，请重试");
        }
    $.ajax({
        type: 'POST',
        url: "/login/register/result",
        data: {
            'username': username,
            'password': password,
            'nicakname': nickname,
            'email':email,
            'mobilephone':mobilephone
        },
        async:false,
        success: function (result) {
            var data = JSON.parse(JSON.stringify(result));
            alert(data.msg);
            window.location.href = "/";
        },//JSON.stringify(data)
        error: function () {
            alert("error");
        }
    });
    })
    ;
    $(document).on("click", "#check-username", function (event) {
        event.preventDefault();
        var username = $("#username").val();
        $.ajax({
            type: 'POST',
            url: "/login/register/username",
            data: {
                'username': username,
            },
            success: function (result) {
                var data = JSON.parse(JSON.stringify(result));
                if (data.msg) {
                    $("#msg").html("用户名可用！");
                } else {
                    $("#msg").html("用户名已经存在!请重新输入。")
                }
            },//JSON.stringify(data)
            error: function () {
                $("#msg").html("服务器忙，请重试！");
            }
        });
    });
</script>
</body>
</html>
