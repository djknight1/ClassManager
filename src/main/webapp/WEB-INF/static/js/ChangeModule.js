$(function () {
    "use strict";

    window.Choose_upload = function (selector) {
        var $ele,upload_way_of_id,upload_name;

        function init() {
            get_ele();
            get_upload_way();
        }

        function get_ele() {
            if(selector instanceof $) {
                $ele = selector;
            }
            else{
                $ele = $(selector);
            }
        }

        function get_upload_way() {
            console.log($ele);
            upload_name = $ele.data("name");
            console.log(upload_name);
            upload_way_of_id ="#"+upload_name+"-upload";
            console.log($(upload_way_of_id));
        }

        this.open_new_web = function () {
            $(upload_way_of_id).on("click",function () {
                window.open("./"+upload_name+"-submit.html");
            })
        };

        init();
        this.open_new_web();
    };


});