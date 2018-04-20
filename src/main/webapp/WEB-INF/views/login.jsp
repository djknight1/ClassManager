<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>denglu</title>
</head>
<body>
<form>
    <input id="username"type="text" name="username">
    <input id="password"type="password" name="password">
    <input id="submit-btn"type="submit" value="登陆">
</form>

<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<script>
    $(document).on("click", "#submit-btn", function (event) {
        event.preventDefault();
        var username = $("#username").val();
        var password = $("#password").val();
        $.ajax({
            type: 'POST',
            url: "/login/check",
            data: {
                'username': username,
                'password': password,
            },
            success: function (result) {
                var data = JSON.parse(JSON.stringify(result));
                if (data.msg === true) {
                    alert("登陆成功");
                    window.location.href = "/submit";
                } else if (data.msg == false) {
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