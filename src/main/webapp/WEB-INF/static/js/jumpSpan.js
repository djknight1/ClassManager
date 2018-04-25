function jump() {
    var jumpSpan_span = document.getElementById("jumpSpan_span");

    var timer = null;
    var index = 4;
    timer = setInterval(function () {
        jumpSpan_span.innerText = "正在跳转至主页，请等待"+ index +"秒...";
        index --;
        if(index == 0){
            clearInterval(timer);
        }
    }, 1000)
}

function progress() {
    var pro = document.getElementById("progress");

    var timer = null;
    timer = setInterval(function () {
        var screenW = document.documentElement.clientWidth;
        var speed = screenW/100;

        if(pro.offsetWidth >= screenW-4){
            clearInterval(timer);
            window.location.href="/";
        } else {
            pro.style.width = pro.offsetWidth + speed + 'px';
        }
    },50)
}