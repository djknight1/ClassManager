function longEnough(eleName) { //验证指定内容长度
    var obj = document.getElementById(eleName);
    var msg = document.getElementById(eleName + "Msg");
    if ((obj.value).length >= 8) {
        obj.className = "right";
        if(msg != null){
            msg.innerHTML = '<img src="../img/1.png" alt=""><font color="green">你的长度合适</font>';
        }
        return true; //为以后的综合验证准备的。
    } else {
        obj.className = "wrong";
        if(msg != null){
            msg.innerHTML = '<img src="../img/0.png" alt=""><font color="red">你的长度不够</font>';
        }
        return false;
    }
}

function isSame(eleName) { //验证指定是否一致
    var obj = document.getElementById(eleName);
    var newPwd = document.getElementById("new-pwd");
    var msg = document.getElementById(eleName + "Msg");
    if ((obj.value) === (newPwd.value) && (obj.value) != "") {
        obj.className = "right";
        if(msg != null){
            msg.innerHTML = '<img src="../img/1.png" alt=""><font color="green">两次输入一致</font>';
        }
        return true; //为以后的综合验证准备的。
    } else {
        obj.className = "wrong";
        if(msg != null){
            msg.innerHTML = '<img src="../img/0.png" alt=""><font color="red">两次输入不同</font>';
        }
        return false;
    }

}
