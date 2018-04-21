
function Change_visiable() {
    var type = $(".login-password").attr("type");
    if(type ==="password"){
        $(".login-password").attr("type","text");
        $(".visiable-icon").css("display","none");
        $(".notvisiable-icon").css("display","block");
    }
    else {
        $(".login-password").attr("type","password");
        $(".notvisiable-icon").css("display","none");
        $(".visiable-icon").css("display","block");
    }
}
$(".change-visiable").click(function () {
    Change_visiable();
});