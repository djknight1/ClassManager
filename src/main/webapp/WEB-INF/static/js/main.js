/*选中页面所有的input[data-rule]*/

/*解析每一个input的验证规则*/

/*验证*/
$(function () {
    "use strict";
    var $form = $(".layui-tab-content");
    var $inputs = $("[data-rule]");
   var inputs = []; /*用于存放Input实例化后的对象*/
    $inputs.each(function (index,node) {/*key是每一个的索引,val就是每个input*/
       /*解析input的rule内容*/
        inputs.push(new Input($(node))); /*把实例化的对象传到inputs里面去*/
  });

    /*避免提交后整页刷新*/
    $form.on("submit",function (e) {

       /* 提交后全部触发一遍看看哪里错了
       * 让用户知道哪里错了*/
       $inputs.trigger("blur"); /*全部触发事件*/

        e.preventDefault();      /*事件对象*/
        /*提交后触发每一个input的blur看看是否有错
        * 没错就直接提交 有错不能提交且要报错*/
        for(var i=0;i<inputs.length;i++){
            var item = inputs[i];
            /*每一个input都验证,如果有一条出错就报错*/
            var r = item.validator.is_valid();
            if(!r){
                alert("error!");
                return;
            }
        }

    })
});

/*  使用new操作符调用构造函数时，会经历
    (1)创建一个新对象；
    (2)将构造函数作用域赋给新对象（使this指向该新对象）；
    所以如果你在构造函数里面没有this的函数是私有函数 没有暴露到外面去
    (3)执行构造函数代码
    (4)返回新对象；4个阶段。
*/