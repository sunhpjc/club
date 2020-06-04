<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>用户注册</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="../static/plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- icheck bootstrap -->
    <link rel="stylesheet" href="../static/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../static/css/adminlte.min.css">
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <!-- /.login-logo -->
    <div class="card">
        <div class="card-body login-card-body">
            <p class="login-box-msg">用户注册</p>

            <form action="/register/save" method="post" >
                <c:if test="${save!=null}">
                    <div class="alert alert-${save.status==200 ? "success":"danger"} alert-dismissible" style="margin-top: 15px;margin-bottom: -10px">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            ${save.message}
                    </div>
                </c:if>
                <div class="input-group mb-3">
                    <input name="userEmail" type="email" class="form-control" placeholder="邮箱" value="${userEmail}">
                    <div class="input-group-append">
                        <div class="input-group-text">
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input name="userPassword" type="password" class="form-control" placeholder="密码" value="${userPassword}">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <%--<span class="fas fa-lock"></span>--%>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input name="userPhone" type="text" class="form-control" placeholder="电话" value="${userPhone}">
                    <div class="input-group-append">
                        <div class="input-group-text">
                        </div>
                    </div>
                </div>

                <div class="input-group mb-3">
                    <input name="userName" type="text" class="form-control" placeholder="姓名" value="${userName}">
                    <div class="input-group-append">
                        <div class="input-group-text">
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input name="realName" type="text" class="form-control" placeholder="真实姓名" value="${realName}">
                    <div class="input-group-append">
                        <div class="input-group-text">
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input name="sex" type="text" class="form-control" placeholder="性别" value="${sex}">
                    <div class="input-group-append">
                        <div class="input-group-text">
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input name="number" type="text" class="form-control" placeholder="学号" value="${number}">
                    <div class="input-group-append">
                        <div class="input-group-text">
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input name="college" type="text" class="form-control" placeholder="学院" value="${college}">
                    <div class="input-group-append">
                        <div class="input-group-text">
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input name="major" type="text" class="form-control" placeholder="专业" value="${major}">
                    <div class="input-group-append">
                        <div class="input-group-text">
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-12">
                        <div class="">
                            <button type="submit" id="register" class="btn btn-primary btn-block">注册</button>
                        </div>
                    </div>
                    <!-- /.col -->
                </div>
            </form>
        </div>
        <!-- /.login-card-body -->
    </div>
</div>
</div>
<!-- jQuery -->
<script src="../static/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../static/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="../static/js/adminlte.min.js"></script>
</body>
</html>
