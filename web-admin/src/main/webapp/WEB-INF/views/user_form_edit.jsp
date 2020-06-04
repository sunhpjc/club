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

        <!-- 右上角导航栏 -->
        <ul class="navbar-nav ml-auto">
            <!-- 右上角信息提示 -->
            <li class="na-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="far fa-comments"></i>
                    <span class="badge badge-danger navbar-badge">3</span>
                </a>
                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                    <a href="#" class="dropdown-item">
                        <!-- 详细信息提示 -->
                        <div class="media">
                            <img src="../static/img/user1-128x128.jpg" alt="User Avatar" class="img-size-50 mr-3 img-circle">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    Brad Diesel
                                    <span class="float-right text-sm text-danger"><i class="fas fa-star"></i></span>
                                </h3>
                                <p class="text-sm">Call me whenever you can...</p>
                                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                            </div>
                        </div>
                        <!-- Message End -->
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <!-- Message Start -->
                        <div class="media">
                            <img src="../static/img/user8-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    John Pierce
                                    <span class="float-right text-sm text-muted"><i class="fas fa-star"></i></span>
                                </h3>
                                <p class="text-sm">I got your message bro</p>
                                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                            </div>
                        </div>
                        <!-- Message End -->
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item dropdown-footer">See All Messages</a>
                </div>
            </li>
        </ul>
    </nav>
    <!-- 左侧菜单 -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <a href="/user_main" class="brand-link">
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
                    <a href="#" class="d-block">${adminUser_session.realName}</a>
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
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa fa-address-card"></i>
                            <p>社团管理
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a onclick="Detail.showDetail('/user_club/user_club_detail?id=${adminUser_session.clubId}')" class="nav-link">
                                    <i class="far nav-icon fa fa-list-alt"></i>
                                    <p>社团信息</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/user_club/user_club_list" class="nav-link">
                                    <i class="far nav-icon fa fa-plus-square"></i>
                                    <p>社团一览</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa fa-address-card"></i>
                            <p>用户管理
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="/user/user_list" class="nav-link">
                                    <i class="far nav-icon fa fa-list-alt"></i>
                                    <p>用户列表</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/user/user_form" class="nav-link">
                                    <i class="far nav-icon fa fa-plus-square"></i>
                                    <p>添加用户</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="far nav-icon fa fa-plus-square"></i>
                                    <p>用户申请</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa fa-users"></i>
                            <p>活动管理
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="far nav-icon fa fa-list-alt"></i>
                                    <p>活动列表</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="far nav-icon fa fa-plus-square"></i>
                                    <p>申请活动</p>
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa fa-comment"></i>
                            <p>新闻管理
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="far nav-icon fa fa-list-alt"></i>
                                    <p>新闻列表</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="far nav-icon fa fa-list-alt"></i>
                                    <p>发表新闻</p>
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa fa-folder-open"></i>
                            <p>公告管理
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="far nav-icon fa fa-list-alt"></i>
                                    <p>公告列表</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="far nav-icon fa fa-list-alt"></i>
                                    <p>发布公告</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-table"></i>
                            <p>财务管理
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="/finance/user_finance_list" class="nav-link">
                                    <i class="far nav-icon fa fa-list-alt"></i>
                                    <p>财务列表</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="far nav-icon fa fa-list-alt"></i>
                                    <p>添加明细</p>
                                </a>
                            </li>
                        </ul>
                    </li>

                </ul>
            </nav>
        </div>
    </aside>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1 class="m-0 text-dark">用户管理</h1>
                        <c:if test="${save!=null}">
                            <div class="alert alert-${save.status==200 ? "success":"danger"} alert-dismissible" style="margin-top: 15px;margin-bottom: -10px">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                    ${save.message}
                            </div>
                        </c:if>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="/user_main">首页</a></li>
                            <li class="breadcrumb-item active">添加用户</li>
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
                                <h3 class="card-title">${user.userId==null ? "新增" : "编辑"}用户</h3>
                            </div>
                            <!-- /.card-header -->
                            <!-- form start -->
                            <form:form id="inputForm" class="form-horizontal" action="/user/save" method="post" modelAttribute="user">
                                <div class="card-body">
                                    <div class="form-group row">
                                        <label for="userEmail" class="col-sm-2 col-form-label">邮箱：</label>
                                        <div class="col-sm-10">
                                            <form:hidden path="userId"></form:hidden>
                                            <form:input path="userEmail" class="required email form-control" placeholder="请输入用户邮箱"></form:input>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="userPhone" class="col-sm-2 col-form-label">电话：</label>
                                        <div class="col-sm-10">
                                            <form:input path="userPhone" class="required form-control" placeholder="请输入用户电话"></form:input>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="userPassword" class="required col-sm-2 col-form-label">密码：</label>
                                        <div class="col-sm-10">
                                            <form:input path="userPassword" type="password" class="required form-control" placeholder="请输入用户密码"></form:input>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="realName" class="required col-sm-2 col-form-label">姓名：</label>
                                        <div class="col-sm-10">
                                            <form:input path="realName" class="required form-control" placeholder="请输入用户姓名"></form:input>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="sex" class="required col-sm-2 col-form-label">性别：</label>
                                        <div class="col-sm-10">
                                            <form:select path="sex" class="required form-control">
                                                <form:option value="男">男</form:option>
                                                <form:option value="女">女</form:option>
                                            </form:select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="college" class="required col-sm-2 col-form-label">学院：</label>
                                        <div class="col-sm-10">
                                            <form:select path="college" class="required form-control">
                                            </form:select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="major" class="required col-sm-2 col-form-label">专业：</label>
                                        <div class="col-sm-10">
                                            <form:select path="major" class="required form-control">
                                            </form:select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="number" class="required col-sm-2 col-form-label">学号：</label>
                                        <div class="col-sm-10">
                                            <form:input path="number" class="required form-control" readonly="true" placeholder="请输入用户学号"></form:input>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.card-body -->
                                <div class="card-footer">
                                    <button type="submit" class="btn btn-info">提交</button>
                                    <button type="button" class="btn btn-default float-right" onclick="history.go(-1)">取消</button>
                                </div>
                                <!-- /.card-footer -->
                            </form:form>
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
<%--自定义js--%>'
<script src="../static/appjs/json.js"></script>
<script>
    //学院、专业选择
    var inits = "<option value=''>请选择</option>"
    var collegeResult = MyJson.college;
    $("#college").append(inits);
    $("#major").append(inits);
    for (var i = 0; i < collegeResult.length; i++) {
        var myCollege = "<option value='"+collegeResult[i].college+"'>"+collegeResult[i].college+"</option>"
        $("#college").append(myCollege);
    }
    //获取当前学院，出发事件
    $("#college").change(function () {
        //清除之前专业选项选取的数据
        $("#major option:gt(0)").remove();
        for (var j = 0; j < collegeResult.length; j++) {
            //判断选取的数据是否和专业匹配
            if($(this).val()==collegeResult[j].college){
                //则循环当前学院的专业
                for (var k = 0; k < collegeResult[j].major.length ; k++) {
                    var myMajor = "<option value='"+collegeResult[j].major[k]+"'>"+collegeResult[j].major[k]+"</option>"
                    $("#major").append(myMajor);
                }
            }
        }
    });
</script>
</body>
</html>