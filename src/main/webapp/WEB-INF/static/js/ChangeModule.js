$(function () {
    'use strict';
    window.Choose_upload = function (selector) {
        let $ele, typeId;
        function init() {
            get_ele();
            set_attr();
        }


        function get_ele() {
            if (selector instanceof $) {
                $ele = selector;
            }
            else {
                $ele = $(selector);
            }
        }

        function set_attr() {
            $(".post-type:first-child").css("background-color", "#c92027");
            $(".post-type:first-child").css("color", "#fff");
            typeId=$(".post-type:first-child").attr('data-flag');
        }

        this.changeColorandType = function() {
            console.log($ele);
            $ele.each(function () {
                $(this).click(function () {
                    $ele.each(function () {
                        $(this).css("background-color", "#fff");
                        $(this).css("color", "#4f4f4f");
                    });
                    $(this).css("background-color", "#c92027");
                    $(this).css("color", "#fff");
                    typeId = $(this).attr('data-flag');
                    console.log(typeId);
                })
        })
            return typeId;
        };

        init();

    };

});