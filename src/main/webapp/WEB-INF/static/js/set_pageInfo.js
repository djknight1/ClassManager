$(function () {
    "use strict";

    /**
     * @return {string}
     */
    function Timestamp_to_Time(timestamp) {
        let date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
        let Y = date.getFullYear() + '-';
        let M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
        let D = date.getDate() + ' ';
        let h = date.getHours() < 10 ? '0' + date.getHours() : date.getHours();
        let m = date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes();
        let s = date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds();
        return Y + M + D + h + ':' + m + ":" + s;

    }


    function getUploadedFile(typeId) {


    };

    $.ajax({
        type: 'POST',
        url: "ajax/upload/data",
        async: false,
        success: function (result) {
            const data = JSON.parse(JSON.stringify(result));
            let tasks = data.tasks;
            let index = 0;
            $(data.types).each(function () {
                let str = `<a class="post-type list-group list-group-item upload" id="type${this.id}"
                       data-flag="${this.id}">${this.subject}</a>
                `;
                $(".post-group").append(str);
            });

            $(".post-type").each(function () {
                let str1 = `
                                    <div class="updated-list">
                                        <div class="top-header clearfix">
                                            <h1>${$(this).html()}</h1>
                                        </div>
                                        <ul class="task-list">
                                            <li>${tasks[index].name}</li>
                                            <li class="end-time">${ Timestamp_to_Time(tasks[index].endTime)}</li>
                                        </ul>
                                    </div>
                                    `;
                $(".right-bar-container").append(str1);
                index++;
            });

            $(".user-name").html(data.user.name);

            $(".user-class .className").html(data.userClass.classname)

        },//JSON.stringify(data)
        error: function () {
            alert("error");
        }
    });
})