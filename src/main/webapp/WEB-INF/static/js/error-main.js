window.onload = function () {
    for (var i = 0; i < 3; i++) {
        var imgList = document.getElementById("imgList");
        var allLis = imgList.children;
        for(var j = 0; j < allLis.length; j ++){
            allLis[j].style.left = j*200 + "px";
            allLis[j].style.top = 0 + "px";
            allLis[j].style.animationDelay = (Math.random() * 1.5) + "s";
        }

    }
    jump();
    progress();
}

