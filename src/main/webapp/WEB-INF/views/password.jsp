<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改密码 - ZUST Computer Science 16</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/initcss.css">
<script src="${pageContext.request.contextPath}/js/common.js"></script>
<script src="${pageContext.request.contextPath}/js/validate.js"></script>
<body>


<div id="main">
    <h1 class="main-head-text"><img src="${pageContext.request.contextPath}/img/smile.png" alt=""> 修改密码
    </h1>
    <form id="pwd-form" action="/ajax/password" method="post" >
        <div class="pwd">
            <span class="pwd_size">用户学号：</span>
            <input id="id" type="text" name="id" class="init">
        </div>
        <div class="pwd">
            <span class="pwd_size">旧的密码：</span>
            <input id="oldpassword" type="password" neme="oldpassword" class="init">
        </div>

        <div class="pwd">
            <span class="pwd_size">新的密码：</span>
            <input id="newpassword" type="password" name="newpassword" class="init">
        </div>

        <input id="submit-pwd" type="submit" value="确认修改">
    </form>
</div>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script>
    $(document).on("click", "#submit-pwd", function (event) {
        event.preventDefault();
        var id = $("#id").val();
        var oldpassword = $("#oldpassword").val();
        var newpassword = $("#newpassword").val();
        $.ajax({
            type: 'POST',
            url: "/ajax/password",
            data: {
                'id': id,
                'oldpassword': oldpassword,
                'newpassword': newpassword
            },
            success: function (result) {
                var data = JSON.parse(JSON.stringify(result));
                if (data.msg === true) {
                    alert("修改成功")
                    window.location.href = "/";
                } else if (data.msg === false) {
                    alert("账号密码错误");
                }
            },//JSON.stringify(data)
            error: function () {
                alert("请求错误！");
            }
        });
    });
</script>
</body>
</html>