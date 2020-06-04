<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>社团管理系统 | 首页</title>
    <jsp:include page="../commons/header.jsp"></jsp:include>
</head>
<body class="hold-transition sidebar-mini layout-fixed">

<div class="wrapper">
    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <!-- 顶部左导航栏 -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" data-widget="pushmenu" href="#"><i class="fas fa-bars"></i></a>
            </li>
        </ul>
    </nav>
    <!-- 左侧菜单 -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <a href="/main" class="brand-link">
            <img src="../static/img/myImg/swpu_logo.png" alt="swpu_logo" class="brand-image img-circle elevation-3"
                 style="opacity: .8">
            <span class="brand-text font-weight-light">社团管理系统</span>
        </a>
        <!-- Sidebar -->
        <div class="sidebar">
            <!-- Sidebar user panel (optional) 登录用户-->
            <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                <div class="image">
                    <img src="../static/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
                </div>
                <div class="info">
                    <a href="#" class="d-block">${user_session.realName}</a>
                </div>
                <div style="width: 80px"></div>
                <div class="info">
                    <a href="/logout">
                        <button type="button" class="btn btn-block btn-outline-secondary btn-sm" href="/logout">注销</button>
                    </a>
                </div>
            </div>
            <!-- Sidebar Menu 功能菜单-->
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                    <li class="nav-item">
                        <a href="/user/userDetail?id=${user_session.userId}" class="nav-link active">
                            <i class="far nav-icon fa fa-list-alt"></i>
                            <p>个人信息</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="/club/club_list" class="nav-link">
                            <i class="far nav-icon fa fa-list-alt"></i>
                            <p>社团列表</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="/activity/activity_list" class="nav-link">
                            <i class="far nav-icon fa fa-life-ring"></i>
                            <p>活动列表</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="/activity/my_activity_list" class="nav-link">
                            <i class="far nav-icon fa fa-tasks"></i>
                            <p>我的活动</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link">
                            <i class="far nav-icon fa fa-book"></i>
                            <p>新闻列表</p>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </aside>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h5 class="m-0 text-dark">个人信息</h5>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="/main">首页</a></li>
                            <li class="breadcrumb-item active">个人信息</li>
                        </ol>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="box-body col-6">
                    <form:form id="inputForm" class="form-horizontal" action="/user/updateUser" method="post" modelAttribute="user">
                        <div class="card-body">
                            <div class="form-group row">
                                <label for="realName" class="required col-sm-2 col-form-label">姓名：</label>
                                <div class="col-sm-10">
                                    <form:hidden path="userId"></form:hidden>
                                    <form:input path="realName" class="required form-control" disabled="true"></form:input>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="userEmail" class="col-sm-2 col-form-label">邮箱：</label>
                                <div class="col-sm-10">
                                    <form:input path="userEmail" class="required form-control" disabled="true"></form:input>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="userPassword" class="col-sm-2 col-form-label">密码：</label>
                                <div class="col-sm-10">
                                    <form:input path="userPassword" type="password" class="required form-control edit" disabled="true"></form:input>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="userPhone" class="col-sm-2 col-form-label">电话：</label>
                                <div class="col-sm-10">
                                    <form:input path="userPhone" class="required form-control edit" disabled="true"></form:input>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="userName" class="col-sm-2 col-form-label">昵称：</label>
                                <div class="col-sm-10">
                                    <form:input path="userName" class="required form-control edit" disabled="true"></form:input>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="sex" class="col-sm-2 col-form-label">性别：</label>
                                <div class="col-sm-10">
                                    <form:input path="sex" class="required form-control edit" disabled="true"></form:input>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="number" class="col-sm-2 col-form-label">学号：</label>
                                <div class="col-sm-10">
                                    <form:input path="number" class="required form-control" disabled="true"></form:input>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="college" class="col-sm-2 col-form-label">学院：</label>
                                <div class="col-sm-10">
                                    <form:input path="college" class="required form-control" disabled="true"></form:input>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="major" class="col-sm-2 col-form-label">专业：</label>
                                <div class="col-sm-10">
                                    <form:input path="major" class="required form-control" disabled="true"></form:input>
                                </div>
                            </div>

                        </div>
                        <!-- /.card-body -->
                        <div class="card-footer">
                            <button id="edit" type="button" class="btn btn-info">修改</button>&nbsp;&nbsp;&nbsp;
                            <button id="sub" type="submit" class="btn btn-info" hidden="hidden">提交</button>
                            <button type="button" class="btn btn-default float-right" onclick="history.go(-1)">取消</button>
                        </div>
                        <!-- /.card-footer -->
                    </form:form>
                </div>
            </div><!-- /.container-fluid -->
        </section>
        <!-- /.content -->
    </div>

    <!-- Main Footer -->
    <jsp:include page="../commons/copyright.jsp"></jsp:include>

</div>
<jsp:include page="../commons/footer.jsp"></jsp:include>
<script>
    $("#edit").click(function () {
        $(".edit").removeAttr("disabled")
        $("#sub").removeAttr("hidden")
        $("#edit").attr("disabled","disabled")
    })
</script>
</body>
</html>