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
                        <a href="/user/userDetail?id=${user_session.userId}" class="nav-link">
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
                        <a href="/news/queryNews" class="nav-link">
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
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="/main">首页</a></li>
                            <li class="breadcrumb-item active">控制面板</li>
                        </ol>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-6">
                        <!-- Horizontal Form -->
                        <div class="card card-info">
                            <div class="card-header">
                                <%--这里使用下面返回的modelAttribute属性user,否则不能识别--%>
                                <h4 class="card-title">请填写申请原因</h4>
                            </div>
                            <!-- /.card-header -->
                            <!-- form start -->
                            <form id="join" class="form-horizontal" action="/club/saveApplication" method="post">
                                <div class="card-body">
                                    <div class="form-group row">
                                        <label for="clubApplicationDesc" class="col-sm-2 col-form-label">申请描述：</label>
                                        <div class="col-sm-10">
                                            <input type="hidden" id="userId" name="userId" value="${userId}">
                                            <input type="hidden" id="clubId" name="clubId" value="${clubId}">
                                            <textarea rows="5" id="clubApplicationDesc" name="clubApplicationDesc" class="required email form-control"></textarea>
                                        </div>
                                    </div>
                                    <div class="card-footer">
                                        <button type="submit" class="btn btn-info">提交</button>
                                        <button type="button" class="btn btn-default float-right" onclick="history.go(-1)">取消</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <!-- /.card -->
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>
        <!-- /.content -->
    </div>

    <!-- Main Footer -->
    <jsp:include page="../commons/copyright.jsp"></jsp:include>

</div>
<jsp:include page="../commons/footer.jsp"></jsp:include>
</body>
</html>