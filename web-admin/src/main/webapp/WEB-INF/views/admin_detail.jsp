<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户管理 | 用户详情</title>
    <jsp:include page="../commons/header.jsp"></jsp:include>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="box-body">
    <table id="dataTable" class="table">
        <tbody>
        <tr>
            <td>姓名</td>
            <td>${adminUser.realName}</td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td>${adminUser.adminEmail}</td>
        </tr>
        <tr>
            <td>电话</td>
            <td>${adminUser.adminPhone}</td>
        </tr>
        <tr>
            <td>性别</td>
            <td>${adminUser.sex}</td>
        </tr>
        <tr>
            <td>学号</td>
            <td>${adminUser.number}</td>
        </tr>
        <tr>
            <td>学院</td>
            <td>${adminUser.college}</td>
        </tr>
        <tr>
            <td>专业</td>
            <td>${adminUser.major}</td>
        </tr>
        <tr>
            <td>所属社团</td>
            <td>${adminUser.clubName}</td>
        </tr>
        <tr>
            <td>职位</td>
            <td>${adminUser.possition}</td>
        </tr>
        </tbody>
    </table>
</div>
<jsp:include page="../commons/footer.jsp"></jsp:include>
</body>
</html>