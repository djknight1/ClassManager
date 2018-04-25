$(function () {
    "use strict";
    let str;
    $.ajax({
        type: 'POST',
        url: "ajax/upload/data",
        async:false,
        success: function (result) {
            const data = JSON.parse(JSON.stringify(result));
            $(data.types).each(function () {
               str = `<a class="post-type list-group list-group-item upload" id="type${this.id}"
                       data-flag="${this.id}">${this.subject}</a>
                `;
               $(".post-group").append(str);
            });
        },//JSON.stringify(data)
        error: function () {
            alert("error");
        }
    });
})