<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>社团管理 | 社团详情</title>
    <jsp:include page="../commons/header.jsp"></jsp:include>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="box-body">
    <table id="dataTable" class="table">
        <tbody>
        <tr>
            <td>社团名</td>
            <td>${club.name}</td>
        </tr>
        <tr>
            <td>社团邮箱</td>
            <td>${club.email}</td>
        </tr>
        <tr>
            <td>社团星级</td>
            <td>${club.star}</td>
        </tr>
        <tr>
            <td>社团宣言</td>
            <td>${club.clubDesc}</td>
        </tr>
        </tbody>
    </table>
</div>
<jsp:include page="../commons/footer.jsp"></jsp:include>
</body>
</html>