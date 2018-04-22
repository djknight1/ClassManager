<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/submit-main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/java-submit.css">
</head>
<body>

<div class="main-container">
    <div class="main-wrap clearfix" >
        <div id="slide-bar">
            <div class="list-group">
                <div class="list-group-item list-group-title">上传内容</div>
                <a style="background-color: #c92027; color: #fff;" class="list-group list-group-item upload" id="java-upload" data-name="java">Java</a>
                <a class="list-group list-group-item upload" id="c-upload" data-name="c">C++</a>
            </div>
        </div>

        <div class="edit-container clearfix">
            <div class="upload-component-container">
                <fieldset class="layui-elem-field layui-field-title">
                    <legend>文档上传</legend>
                </fieldset>
                <div class="layui-upload-drag" id="upload_main">
                    <i class="layui-icon"></i>
                    <p>点击上传，或将文件拖拽到此处</p>
                </div>
                <hr>
                <hr style="margin-top: 30px;">

                <div class="layui-upload">
                    <div class="layui-upload-list">
                        <table class="layui-table">
                            <thead>
                            <tr><th>文件名</th>
                                <th>大小</th>
                                <th>状态</th>
                                <th>操作</th>
                            </tr></thead>
                            <tbody id="demoList"></tbody>
                        </table>
                    </div>
                    <button type="button" class="layui-btn" id="testListAction">开始上传</button>
                </div>
            </div>

        </div>
    </div>
</div>


<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/js/ChangeModule.js"></script>
<script src="${pageContext.request.contextPath}/js/submit-main.js"></script>

<script>
    layui.use('upload',function () {
        var $ = layui.jquery
            ,upload = layui.upload;

        var demoListView = $('#demoList')
            ,uploadListIns = upload.render({
            elem: '#upload_main'
            ,url: '/upload/'
            ,accept: 'file'
            ,multiple: true
            ,drag:true
            ,auto: false
            ,bindAction: '#testListAction'
            ,choose: function(obj){
                var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
                //读取本地文件
                obj.preview(function(index, file, result){
                    var tr = $(['<tr id="upload-'+ index +'">'
                        ,'<td>'+ file.name +'</td>'
                        ,'<td>'+ (file.size/1014).toFixed(1) +'kb</td>'
                        ,'<td>等待上传</td>'
                        ,'<td>'
                        ,'<button class="layui-btn layui-btn-mini demo-reload layui-hide">重传</button>'
                        ,'<button class="layui-btn layui-btn-mini layui-btn-danger demo-delete">删除</button>'
                        ,'</td>'
                        ,'</tr>'].join(''));

                    //单个重传
                    tr.find('.demo-reload').on('click', function(){
                        obj.upload(index, file);
                    });

                    //删除
                    tr.find('.demo-delete').on('click', function(){
                        delete files[index]; //删除对应的文件
                        tr.remove();
                        uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
                    });

                    demoListView.append(tr);
                });
            }
            ,done: function(res, index, upload){
                if(res.code == 0){ //上传成功
                    var tr = demoListView.find('tr#upload-'+ index)
                        ,tds = tr.children();
                    tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
                    tds.eq(3).html(''); //清空操作
                    return delete this.files[index]; //删除文件队列已经上传成功的文件
                }
                this.error(index, upload);
            }
            ,error: function(index, upload){
                var tr = demoListView.find('tr#upload-'+ index)
                    ,tds = tr.children();
                tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
                tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
            }
        });
    })
</script>
</body>
</html>