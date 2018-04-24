$(function () {
    "use strict";
    console.log($(".post-type"));
    $(".post-type").each(function () {
        let str =`<div class="updated-list">
                    <div class="top-header clearfix">
                        <h1>${$(this).html()}已上传文件</h1>
                    </div>
                    <ul class="article-list">
                        <li><a href="#">XXXXX</a></li>
                    </ul>
                </div>
`
        $(".right-bar-container").append(str);
    })
});