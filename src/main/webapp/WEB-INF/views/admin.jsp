<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-icon.css">

    <title>管理 - ZUST Computer Science 16</title>
</head>
<body>
    <div class="view-container">
        <div class="view-body">
            <div class="layui-side layui-bg-black">
                <div class="layui-side-scroll">
                    <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
                    <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                        <li class="layui-nav-item layui-nav-itemed">
                            <a class="" href="javascript:;">所有功能</a>
                            <dl class="layui-nav-child">
                                <dd><a href="javascript:;">批量下载</a></dd>
                                <dd><a href="">浙江科技学院</a></dd>
                            </dl>
                        </li>
                        <li class="layui-nav-item">
                            <a href="javascript:;">解决方案</a>
                            <dl class="layui-nav-child">
                                <dd><a href="javascript:;">列表一</a></dd>
                                <dd><a href="javascript:;">列表二</a></dd>
                                <dd><a href="">超链接</a></dd>
                            </dl>
                        </li>
                    </ul>
                </div>
            </div>





            <div class="main-right-bar">
                <div class="no-use-space"></div>

                <div class="service-container">
                    <div class="service-section">
                        <div class="section-body">
                            <form class="select-container layui-form">

                                <select name="class" class="select-input">
                                    <option value="null" >请选择班级</option>
                                    <option value="1">计算机1班</option>
                                    <option value="2">计算机2班</option>
                                </select>

                                <select name="subject" class="select-input">
                                    <option value="null" >请选择学科</option>
                                    <option value="2">c++</option>
                                    <option value="1">java</option>
                                </select>

                                <select name="city" class="select-input">
                                    <option value="null" >请选择上传时间</option>
                                    <option value="c++">c++</option>
                                    <option value="java">java</option>
                                </select>
                                <button id="download-all" class="layui-btn">批量下载</button>
                            </form>


                            <table id="demo" class="layui-table">


                               <%-- <thead>
                                <tr>
                                    <th class="title-column-3">学号</th>
                                    <th class="title-column-4">姓名</th>
                                    <th class="title-column-1">上传时间</th>
                                    <th class="title-column-2"></th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td class="title-column-3">XXXX</td>
                                    <td class="title-column-4">时间</td>
                                    <td class="title-column-1">类型</td>
                                    <td><button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-normal title-column-2">点击下载</button></td>
                                </tr>
                                </tbody>--%>
                            </table>
                        </div>
                    </div>

                </div>
            </div>
        </div>

    </div>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script>

    </script>
    <script src="${pageContext.request.contextPath}/js/download_all.js"></script>
    <script>
        //JavaScript代码区域
        $(function () {
            var $form = $("form");
            var inputs = [];
            $form.each(function (index,node) {
                inputs.push(new Getsearch_condition(node));
            });
            console.log($form.find("select"));



         layui.use('element', function(){
                        layui.use('table', function(){
                            /*TODO:一定要把这个做的好看点！！！*/
                            var table = layui.table;
                            //第一个实例
                            table.render({
                                elem: '#demo',
                                height: 315,
                                url: '', //数据接口
                                page: true, //开启分页
                                cols: [[ //表头
                                    {field: 'id', title: '学号', width:"25%", sort: true, fixed: 'left'},
                                    {field: 'name', title: '姓名', width:"25%", fixed: 'left'},
                                ]],
                            });
                        });
                });
        })
    </script>
</body>
</html>

