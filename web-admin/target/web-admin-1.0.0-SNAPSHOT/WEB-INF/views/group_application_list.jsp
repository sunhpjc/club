<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys"%>

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
                                <a href="/admin/admin_form" class="nav-link">
                                    <i class="far nav-icon fa fa-plus-square"></i>
                                    <p>添加用户</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item has-treeview menu-open">
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
                                <a href="/group/group_application_list" class="nav-link active">
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
                                <a href="#" class="nav-link">
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
                                <a href="#" class="nav-link">
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
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <%--<h1 class="m-0 text-dark">申请管理</h1>--%>
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
                            <li class="breadcrumb-item active">申请列表</li>
                        </ol>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->
        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <%--搜索框--%>
                <div class="row my_search" style="display: none">
                    <div class="col-md-12">
                        <div class="card card-info">
                            <%--搜索功能--%>
                            <div class="card-body">
                                <div class="form-group row">
                                    <div class="col-sm-3">
                                        <input id="clubName" class="form-control" placeholder="请输入社团名称"></input>
                                    </div>
                                    <div class="input-group-append">
                                        <button type="button" class="btn btn-default" onclick="dataTableSearch()"><i class="fas fa-search"></i></button>&nbsp;&nbsp;&nbsp;
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.card -->
                    </div>
                </div>

                <div class="content">
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-header">
                                    <h3 class="card-title">申请列表</h3>
                                    <div style="padding-top: 30px">
                                        <button onclick="DataTables.deleteMulti('/club/delete')" type="button" class="btn btn-danger btn-xs"><i class="fas fa-plus"></i>删除</button>&nbsp;&nbsp;&nbsp;
                                        <button type="button" class="btn btn-primary btn-xs text-white" onclick="$('.my_search').css('display')=='none' ? $('.my_search').show('fast') : $('.my_search').hide('fast')"><i class="fas fa-search"></i>搜索</button>
                                    </div>
                                </div>
                                <!-- /.card-header -->
                                <div class="card-body table-responsive p-0">
                                    <table id="dataTable" class="table table-hover">
                                        <thead>
                                        <tr>
                                            <th></th>
                                            <th>申请ID</th>
                                            <th>社团名</th>
                                            <th>活动名</th>
                                            <th>活动时间</th>
                                            <th>活动地点</th>
                                            <th>活动场所</th>
                                            <th>申请时间</th>
                                            <th>审批状态</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- /.card-body -->
                            </div>
                            <!-- /.card -->
                        </div>
                    </div>
                    <!-- /.row -->
                </div>
            </div><!-- /.container-fluid -->
        </section>
        <!-- /.content -->
    </div>

    <!-- Main Footer -->
    <jsp:include page="../commons/copyright.jsp"></jsp:include>

</div>
<jsp:include page="../commons/footer.jsp"></jsp:include>
<%--自定义对话框需要jquery，放在footer下面或者在对话框种引入jquery--%>
<sys:myModel></sys:myModel>
<script>
    //成员变量，因为搜索方法需要使用变量，必须暴露出来
    var dataTable;
    $(function () {
        var columns = [
            {"data":function ( row, type, val, meta ) {
                    return '<input type="checkbox" class="check check_one" id="'+row.groupApplicationId+'">'
                }
            },
            { "data": "groupApplicationId" },
            { "data": "clubName" },
            { "data": "activityName" },
            { "data":function (row, type, val, meta) {
                    return DateTime.format(row.activityTime,"yy-MM-dd");
                }},
            { "data":"activityPlace"},
            { "data":"placeName"},
            { "data":function (row, type, val, meta) {
                    return DateTime.format(row.gcreatetime,"yy-MM-dd");
                }},
            { "data":function (row, type, val, meta) {
                var statusUI=row.groupApplicationStatus;
                if(statusUI==2){
                    return'<Button type="button" class="btn btn-info btn-xs">待审批</Button>'
                }
                else if(statusUI==1){
                    return'<Button type="button" class="btn btn-success btn-xs">已通过</Button>'
                }
                else if(statusUI==0){
                    return'<Button type="button" class="btn btn-danger btn-xs">已拒绝</Button>'
                }
                }},
            {"data":function ( row, type, val, meta ) {
                    var statusUI=row.groupApplicationStatus;
                    var showDetailUrl = "/group/group_application_detail?id="+row.groupApplicationId;
                    if(statusUI==2){
                        return '<Button onclick="Detail.showDetail(\''+showDetailUrl+'\')" type="button" class="btn btn-default btn-xs"><i class="fas fa-search"></i>查看</Button>&nbsp;&nbsp;&nbsp;'+
                            '<button onclick="applicationPass(\'/group/applicationPass\',\''+row.groupApplicationId+'\')" type="button" class="btn btn-primary btn-xs text-white"><i class="fas fa fa-check"></i>同意</button>&nbsp;&nbsp;&nbsp;'+
                            '<Button onclick="applicationRefuse(\'/group/applicationRefuse\',\''+row.groupApplicationId+'\')" type="button" class="btn btn-danger btn-xs text-white"><i class="fas fa fa-times"></i>拒绝</Button>'
                    }
                    else{
                        return '<Button onclick="Detail.showDetail(\''+showDetailUrl+'\')" type="button" class="btn btn-default btn-xs"><i class="fas fa-search"></i>查看</Button>'
                    }
                }
            },
        ];
        dataTable=DataTables.initDataTable("/group/page",columns);
    });
    //搜索方法
    function dataTableSearch() {
        var clubName = $("#clubName").val();
        var param = {
            "clubName":clubName,
        };
        dataTable.settings()[0].ajax.data = param;
        dataTable.ajax.reload();
    }
    //同意申请
    function applicationPass(url,id) {
        $.ajax({
            "url":url,
            "type":"POST",
            "data":{"id":id.toString()},
            "dataType":"JSON",
            "success":function (data) {
                window.location.reload();
            }
        });
    }
    //拒绝申请
    function applicationRefuse(url,id) {
        $.ajax({
            "url":url,
            "type":"POST",
            "data":{"id":id.toString()},
            "dataType":"JSON",
            "success":function (data) {
                window.location.reload();
            }
        });
    }
</script>
</body>
</html>
