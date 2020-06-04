<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>社团管理系统 | 用户管理</title>
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
                    <li class="nav-item has-treeview menu-open">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa fa-address-card"></i>
                            <p>用户管理
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="/admin/admin_list" class="nav-link">
                                    <i class="far nav-icon fa fa-list-alt"></i>
                                    <p>用户列表</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/admin/admin_form" class="nav-link active">
                                    <i class="far nav-icon fa fa-plus-square"></i>
                                    <p>添加用户</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa fa-users"></i>
                            <p>社团管理
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="/club/club_list" class="nav-link">
                                    <i class="far nav-icon fa fa-list-alt"></i>
                                    <p>社团列表</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/club/club_form" class="nav-link">
                                    <i class="far nav-icon fa fa-plus-square"></i>
                                    <p>添加社团</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/group/group_application_list" class="nav-link">
                                    <i class="far nav-icon fa fa-envelope"></i>
                                    <p>申请管理</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/user_club/admin_club_list" class="nav-link">
                                    <i class="far nav-icon fa fa-star"></i>
                                    <p>星级评定</p>
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa fa-comment"></i>
                            <p>评论管理
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="/comments/comments_list" class="nav-link">
                                    <i class="far nav-icon fa fa-list-alt"></i>
                                    <p>评论列表</p>
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa fa-folder-open"></i>
                            <p>新闻管理
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="/news/news_list" class="nav-link">
                                    <i class="far nav-icon fa fa-list-alt"></i>
                                    <p>新闻列表</p>
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
                                <a href="/finance/finance_list" class="nav-link">
                                    <i class="far nav-icon fa fa-list-alt"></i>
                                    <p>财务列表</p>
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
                        <%--<h1 class="m-0 text-dark">用户管理</h1>--%>
                        <c:if test="${save!=null}">
                            <div class="alert alert-${save.status==200 ? "success":"danger"} alert-dismissible" style="margin-top: 15px;margin-bottom: -10px">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                    ${save.message}
                            </div>
                        </c:if>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="/main">首页</a></li>
                            <li class="breadcrumb-item active">添加用户</li>
                        </ol>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-6">
                        <!-- Horizontal Form -->
                        <div class="card card-info">
                            <div class="card-header">
                                <%--这里使用下面返回的modelAttribute属性user,否则不能识别--%>
                                <h3 class="card-title">${adminUser.adminId==null ? "新增" : "编辑"}用户</h3>
                            </div>
                            <!-- /.card-header -->
                            <!-- form start -->
                            <form:form id="inputForm" class="form-horizontal" action="/admin/save" method="post" modelAttribute="adminUser">
                                <div class="card-body">
                                    <div class="form-group row">
                                        <label for="clubId" class="col-sm-2 col-form-label">所属社团：</label>
                                        <div class="col-sm-10">
                                            <form:hidden path="adminId"></form:hidden>
                                            <form:select path="clubId" class="required form-control" items="${userList}" itemLabel="clubName" itemValue="clubId">
                                            </form:select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="adminEmail" class="col-sm-2 col-form-label">邮箱：</label>
                                        <div class="col-sm-10">
                                            <form:input path="adminEmail" class="required email form-control" placeholder="请输入用户邮箱"></form:input>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="adminPhone" class="col-sm-2 col-form-label">电话：</label>
                                        <div class="col-sm-10">
                                            <form:input path="adminPhone" class="required mobile form-control" placeholder="请输入用户电话"></form:input>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="adminPassword" class="required col-sm-2 col-form-label">密码：</label>
                                        <div class="col-sm-10">
                                            <form:input path="adminPassword" type="password" class="required form-control" placeholder="请输入用户密码"></form:input>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="realName" class="required col-sm-2 col-form-label">姓名：</label>
                                        <div class="col-sm-10">
                                            <form:input path="realName" class="required form-control" placeholder="请输入用户真实姓名"></form:input>
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
                                        <label for="possition" class="required col-sm-2 col-form-label">职位：</label>
                                        <div class="col-sm-10">
                                            <form:select path="possition" class="required form-control">
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
                                            <form:input path="number" class="required form-control" placeholder="请输入用户学号"></form:input>
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
        <!-- Main content -->

        <!-- /.content -->
    </div>
    <!-- Main Footer -->
    <jsp:include page="../commons/copyright.jsp"></jsp:include>

</div>
<jsp:include page="../commons/footer.jsp"></jsp:include>
<%--自定义js--%>'
<script src="../static/appjs/json.js"></script>
<script>
    //职位选择
    var possitionResult = MyJson.possition;
    var inits = "<option value=''>请选择</option>"
    $("#possition").append(inits);
    for (var i = 0; i <possitionResult.length ; i++) {
        var result = "<option value='"+possitionResult[i]+"'>"+possitionResult[i]+"</option>";
        $("#possition").append(result);
    }
    //学院、专业选择
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