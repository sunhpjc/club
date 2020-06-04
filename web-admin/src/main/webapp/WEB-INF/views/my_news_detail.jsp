<%--用于动态生成页面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mews</title>
</head>
<body>
    <div style="text-align: center">
        <h1>${news.newsTitle}</h1>
    </div>
    <div style="width: 40%;padding: 0 550px 0 450px;">
        ${news.newsContent}
    </div>
</body>
</html>
