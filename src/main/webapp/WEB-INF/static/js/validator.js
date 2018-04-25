/*只做验证部分*/

/*js没有类 所以他的构造函数不需要在类里面
* 只需要你定义了一个函数 他是构造函数
* 在接下来调用该构造函数时 返回值就是一个对象
* function createStudent(name, age) {
  var obj = new Object();
  obj.name = name;
  obj.age = age;
  return obj;
}

var student1 = createStudent("easy1", 20);
var student2 = createStudent("easy2", 20);
...
var studentn = createStudent("easyn", 20);
*/
/*只想用一个函数input.validator.is_validate来判断 这里的is_validate自动检测*/

$(function () {
    'use strict';                           /*这里的rule传进来应该是个对象*/
                                            /*像rule = {max:100,min:5,maxlength:10}*/
    window.Validator = function (val,rule) { /*这就是构造函数 构造对象时对象里的val和rule不同而不同*/

       this.is_valid = function (new_val) {       /*这就是最重要的一个函数 其它只调用该函数,而这个函数会调用下面所有的验证函数*/
           var key;

           /*为了解决input之前本来有字符
           * 删掉后没了字符还是显示valid的办法*/
           if(new_val!==undefined){
               val= new_val;
           }
        /*如果不是必填项且用户未填写任何内容直接判定合法*/
           if(!rule.nullable && !val) return true;

           for(key in rule){
                if(key ==="nullable") continue;
               /*调用rule中相对应的方法*/
                var r=this['validate_' + key]();

               if(!r){
                   return false; /*如果有一条出错 就结束*/
               }
           }
           return true;
        };

       this.validate_max = function () {
           pre_max_min();
           return val<=rule.max;
       };

       this.validate_min = function () {
           pre_max_min();
           return val>=rule.min;
       };

        this.validate_max_length = function () {
            pre_max_length_min_length();/*他可能输了数字*/
            return val.length<=rule.max_length;
        };

        this.validate_min_length = function () {
            pre_max_length_min_length();/*他可能输了数字*/
            return val.length>=rule.min_length;
        };

        this.validate_numeric = function () {
          return $.isNumeric(val); /*判断是否是数字*/
        };

        this.validate_nullable = function () {
           var real = $.trim(val);  /*trim表示删除两边的空格 如果中间有空格不管*/
            if(!real&&real!==0){
                alert("error");
                return false;
            }
            return true;
        };

        this.validate_pattern = function () {
            var reg = new RegExp(rule.pattern);
            return reg.test(val); /*测试用户输入的值是否匹配*/
        };

        /*用于完成this.validate_max_length或
        * this.validate_min_length的前置工作*/
        function pre_max_min() {
            val = parseInt(val);
        }

        /*用于完成this.validate_max_length或
       * this.validate_min_length的前置工作*/
        function pre_max_length_min_length() {
           val = val.toString();    /*他可能传了个数字哟*/
        }
    }
});