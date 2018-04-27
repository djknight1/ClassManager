$(function () {
    window.Getsearch_condition = function (selector) {
        let $ele, values = [];

        function init() {
            find_ele();
        }

        function find_ele() {
            if (selector instanceof $) {
                $ele = selector;
            }
            else {
                $ele = $(selector);
            }
            console.log($ele);
        }

        function find_condition() {
            layui.use('form', function () {
                let form = layui.form;
                form.on('select', function (data) {
                    /*把form select里面的选择值转化成json对象*/
                    var params = $("form").serializeArray();
                    /*获取对象的长度 转换成数组的长度*/
                    let arr = Object.keys(params);
                    values.length = arr.length;

                    console.log(params);
                    for (let i in params) {
                        console.log(values[i]);
                        console.log(params[i]);
                        values[i] =params[i].value;
                    }
                })
            });
        }

        function download_all() {
            $("#download-all").click(function (event) {
                /*傻逼js我操你吗*/
                event.preventDefault();
                if (values.length<3) alert("oh!no!你有尚未选择项目！");
                $(values).each(function (index, item) {
                    if (item ==="null") {
                       alert("你有尚未选择项目！");
                       return false;
                   } else{
                       console.log(values);
                   }
                });
            });
        }


        init();
        find_condition();
        download_all();
    }


})