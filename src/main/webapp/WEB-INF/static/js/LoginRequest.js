$(function () {
    var submit = $(".layui-this");
    var username = $("#username");
    var password = $("#password");
    submit.on("click", function (event) {
        event.preventDefault();
        $.ajax({
            type: 'POST',
            url: "/login/check",
            data: {
                "username": username,
                "password": password
            },
            success: function (result) {
                var data = JSON.parse(JSON.stringify(result));
                if (data.msg === true) {
                    alert("登陆成功");
                } else if (data.msg === false) {
                    alert("账号密码错误/账号不存在");
                }
            },
            error: function () {
                alert("服务器忙")
            },

        })
    });




});