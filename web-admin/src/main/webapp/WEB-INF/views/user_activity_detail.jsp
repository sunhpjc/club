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
            <td>活动时间</td>
            <td>${activity.time}</td>
        </tr>
        <tr>
            <td>活动内容</td>
            <td>
                <textarea style=" background: #ffffff;border: 0px;resize: none;" disabled="disabled" rows="10">${activity.content}</textarea>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<jsp:include page="../commons/footer.jsp"></jsp:include>
</body>
</html>

