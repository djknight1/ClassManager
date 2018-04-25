<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/error-main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/initcss.css">
</head>
<body>
    <div id="progress"></div>
    <div id="container">
        <div id="errorImg">
            <ul id="imgList">
                <li><img src="${pageContext.request.contextPath}/img/error-4.png" alt=""></li>
                <li><img src="${pageContext.request.contextPath}/img/error-0.png" alt=""></li>
                <li><img src="${pageContext.request.contextPath}/img/error-4.png" alt=""></li>
            </ul>
        </div>

        <div id="errorMsg">
            <span>Not Found!</span>
        </div>
        <div id="jumpSpan">
            <span id="jumpSpan_span">正在跳转至主页，请等待5秒...</span>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/js/error-main.js"></script>
    <script src="${pageContext.request.contextPath}/js/jumpSpan.js"></script>

</body>
</html>