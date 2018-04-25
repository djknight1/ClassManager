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
        <div class="nav navbar-nav not-ok">
            <li><a href="/">首页</a></li>
            <li><a href="/knowledge">作业</a></li>
            <li><a href="/school">综测</a></li>
        </div>
        <form class="navbar-form navbar-left not-ok">
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
            <li class="not-ok"><a href="/admin">后台</a></li>
        </div>
    </div>
</div>

<div class="main-container">
    <div class="main-wrap clearfix">
        <div id="slide-bar">
            <div class="list-group">
                <div class="list-group-item list-group-title">上传内容</div>
                <div class="post-group">

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
                    <legend>已上传文件(程序员已卒,该功能尚未开发)</legend>
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
                        <h3>你好,<span class="user-name">XXX</span></h3>
                        <div class="user-class">
                            <span class="className">计算机XXX</span>
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
<script src="${pageContext.request.contextPath}/js/set_pageInfo.js"></script>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/js/ChangeModule.js"></script>
<script src="${pageContext.request.contextPath}/js/ChangeModule.js"></script>
<script src="${pageContext.request.contextPath}/js/uploadFile.js"></script>
<script>
    $(function () {
        $(".not-ok a").click(function (event) {
            event.preventDefault();
            alert("该功能未开放 sorry啊")
        })
    })
</script>
</body>
</html>