<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>上传 - ZUST Computer Science 16</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/submit-main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/java-submit.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar.css">

</head>
<body>


<div class="navbar navbar-default">
    <div class="container ">
        <div class="navbar-header clearfix">
            <a href="#" class="navbar-brand"><img src="/img/logo.png"></a>
        </div>
        <div class="nav navbar-nav">
            <li><a href="/">首页</a></li>
            <li><a href="/knowledge">作业</a></li>
            <li><a href="/school">综测</a></li>
        </div>
        <form class="navbar-form navbar-left">
            <div class="serachTags">
                <a href="#">你想搜啥子</a>
            </div>
            <div class="form-group serach-area">
                <input type="text" class="search-input">
            </div>
            <div class="search-inco"></div>
        </form>
        <div class="nav navbar-nav navbar-right">
            <li><a href="/exit">退出登录</a></li>
            <li><a href="/admin">后台</a></li>
        </div>
    </div>
</div>

<div class="main-container">
    <div class="main-wrap clearfix">
        <div id="slide-bar">
            <div class="list-group">
                <div class="list-group-item list-group-title">上传内容</div>
                <div class="post-group">
                <c:forEach items="${types}" var="type">
                    <a class="post-type list-group list-group-item upload" id="type${type.id}"
                       data-flag="${type.id}">${type.subject}</a>
                </c:forEach>
                </div>
            </div>
        </div>

        <div class="edit-container clearfix">
            <form class="upload-component-container" method="post" enctype="multipart/form-data">
                <fieldset class="layui-elem-field layui-field-title">
                    <legend>文档上传</legend>
                </fieldset>
                <div class="layui-upload-drag" id="upload_main" name="file">
                    <i class="layui-icon"></i>
                    <p>点击上传，或将文件拖拽到此处</p>
                </div>
                <hr>
                <hr style="margin-top: 30px;">

                <div class="layui-upload">
                    <div class="layui-upload-list">
                        <table class="layui-table">
                            <thead>
                            <tr>
                                <th>文件名</th>
                                <th>大小</th>
                                <th>状态</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody id="demoList"></tbody>
                        </table>
                    </div>
                    <button type="button" class="layui-btn" id="testListAction">开始上传</button>
                </div>
            </form>

            <div class="uploaded-task-container">
                <fieldset class="layui-elem-field layui-field-title">
                    <legend>已上传文件</legend>
                </fieldset>

                <table class="layui-table">
                    <thead>
                    <tr>
                        <th>文件名</th>
                        <th>上传状态</th>
                        <th>上传时间</th>
                    </tr>
                    </thead>
                    <tbody id="demoList"></tbody>
                </table>

            </div>



        </div>

        <div id="slide-right-bar">
            <div class="right-bar-container">
                <%--用户信息--%>
                <div class="user-info">
                    <div class="user-status">
                        <h3>你好:<span class="user-name">XXX</span></h3>
                        <div class="user-class">
                            你的班级是<span>计算机XXX</span>
                        </div>
                    </div>
                </div>
                <%--用户近期发布--%>
                <div class="user-task-info"><!--加一个用户星级-->
                    <ul>
                        <li>当前任务</li>
                    </ul>
                </div>

            </div>
        </div>
    </div>
</div>


<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/js/ChangeModule.js"></script>
<script src="${pageContext.request.contextPath}/js/submit-main.js"></script>
<script src="${pageContext.request.contextPath}/js/ChangeModule.js"></script>

<script>
    $(function () {
        let typeId = 1;
        const choose = new Choose_upload($(".post-type"));
        typeId = choose.changeColorandType();
        layui.use('upload', function () {
        var $ = layui.jquery
            , upload = layui.upload;
        var demoListView = $('#demoList')
            , uploadListIns = upload.render({
            elem: '#upload_main'
            , url: '/ajax/upload/'
            , accept: 'file'
            , multiple: true
            , before: function (obj) {
                this.data.params = typeId;
                console.log(this.data.params);
            }
            , drag: true
            , auto: false
            , method: "POST"
            , bindAction: '#testListAction'
            , choose: function (obj) {
                var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
                //读取本地文件
                obj.preview(function (index, file, result) {
                    var tr = $(['<tr id="upload-' + index + '">'
                        , '<td>' + file.name + '</td>'
                        , '<td>' + (file.size / 1014).toFixed(1) + 'kb</td>'
                        , '<td>等待上传</td>'
                        , '<td>'
                        , '<button class="layui-btn layui-btn-mini demo-reload layui-hide">重传</button>'
                        , '<button class="layui-btn layui-btn-mini layui-btn-danger demo-delete">删除</button>'
                        , '</td>'
                        , '</tr>'].join(''));

                    //单个重传
                    tr.find('.demo-reload').on('click', function () {
                        obj.upload(index, file);
                    });

                    //删除
                    tr.find('.demo-delete').on('click', function () {
                        delete files[index]; //删除对应的文件
                        tr.remove();
                        uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
                    });

                    demoListView.append(tr);
                });
            }
            , done: function (res, index, upload) {
                if (res.code == 1) { //上传成功
                    var tr = demoListView.find('tr#upload-' + index)
                        , tds = tr.children();
                    tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
                    tds.eq(3).html(''); //清空操作





                    return delete this.files[index]; //删除文件队列已经上传成功的文件
                } else {
                    alert("上传失败")
                }
            }
            , error: function (index, upload) {
                var tr = demoListView.find('tr#upload-' + index)
                    , tds = tr.children();
                tds.eq(2).html('<span style="color: #FF5722;">服务器忙，请刷新</span>');
                tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
            }
        });
    })
    })
</script>
</body>
</html>