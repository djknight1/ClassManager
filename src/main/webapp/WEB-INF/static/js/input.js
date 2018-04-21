/*input调用validator 它也是个模块！*/

$(function () {
    "use strict";

    window.Input = function (selector) {/*这个也是构造函数*/
        var $ele,rule=
            {
            nullable:true /*是否必填项*/
            },
        ele_error;
        var me = this;/*指向input*/

        function init() {
            find_ele(); /*找到这个元素之后 要解析input里的验证规则了*/
            get_error_ele();
            parse_rule();/*直接调用 this指向全局变量*/
            me.load_validator();/*不能用this的原因是 他在下面直接调用 this指向全局变量*/
        }
        
       this.get_val= function  (){
            return $ele.val();
        };
        
        /*input调用validator对象,使用validator的方法判断是否正确*/
        this.load_validator=function() {
            var val = me.get_val();
            /*加了this是为了让对象能够在外面调用validator 跟函数加this一样*/
            /*每一个input要有不一样的validator*/
            /*这里的this指向input*/
            this.validator = new Validator(val,rule);
        };

        function listen() {
            $ele.on('blur', function () {
                /*   me.validator.is_valid();这样写传的VAL还是初始化的val*/
                /*所以要传实时变化的值,直接传到is_valid里面去就行*/
                console.log(me.get_val());
                var is_validate = me.validator.is_valid(me.get_val());
                console.log(is_validate);
                if(is_validate){
                    $(".login-button-container .layui-btn-normal").css("background-color", "#1E9FFF");
                    ele_error.hide(); /*这样写会对介绍有bug 当把intro从有到无删除的时候 val不能改变*/
                }
                else{
                    $(".login-button-container .layui-btn-normal").css("background-color", "#eee");
                    ele_error.show();
                }
            });
        }

        function get_error_ele() {
            ele_error = $(get_error_selector());
        }

        function get_error_selector() {
            return "#" +$ele.attr("name")+"-input-error";
            /*出问题时选中*/
        }

        function find_ele() {
            /* instanceof更加精确
         如果selector是$的一个对象
         那就返回true
         var str=new String("antzone");
         console.log(str instanceof String); 返回true
         */
            if(selector instanceof $){
                $ele = selector;
            }
            else{
                $ele = $(selector);
            }
        }

        function parse_rule() {
            /*data是jquery里专门选择以data开头的属性
            * 以字符串形式表示*/
            var rule_str = $ele.data("rule");
            if(!rule_str)    return false;


            /*split把字符串以传进去的参数为分割
            分割成！字符串！数组,
            splice把数组中的数据删除*/
            var rule_arr = rule_str.split("|"); //["min:18","maxlength:10"]
            for(var i=0;i<rule_arr.length;i++){
                var item_str = rule_arr[i];
                var item_arr= item_str.split(":"); //["min","18" ]
                /*键值对*/
                /*解析出来后其实就是rule['min']='18'*/
                /*所以rule={min:18}*/

                /*加个json.parse是为了让字符串解析出来还是一个字符串*/
                /*如果不加json.parse的话 不管传什么值 都是字符串*/
                /*加了的话是数字就会解析出数字,是字符串就会解析出字符串*/
                rule[item_arr[0]] = JSON.parse(item_arr[1]);/*{min:18}*/
            }
            console.log(rule);
        }

        init(); /*直接调用init 指向window*/
        listen();
    };
});