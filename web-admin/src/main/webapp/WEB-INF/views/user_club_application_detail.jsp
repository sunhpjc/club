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
            <td>用户邮箱:</td>
            <td>${clubApplications.userEmail}</td>
        </tr>
        <tr>
            <td>用户电话:</td>
            <td>${clubApplications.userPhone}</td>
        </tr>
        <tr>
            <td>用户性别:</td>
            <td>${clubApplications.sex}</td>
        </tr>
        <tr>
            <td>学院:</td>
            <td>${clubApplications.college}</td>
        </tr>
        <tr>
            <td>专业:</td>
            <td>${clubApplications.major}</td>
        </tr>
        <tr>
            <td>学号:</td>
            <td>${clubApplications.number}</td>
        </tr>
        </tbody>
    </table>
</div>
<jsp:include page="../commons/footer.jsp"></jsp:include>
</body>
</html>
