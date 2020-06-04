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
                                <a href="/club_application/club_application_list" class="nav-link">
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
                                <a href="/activity/activity_list" class="nav-link">
                                    <i class="far nav-icon fa fa-list-alt"></i>
                                    <p>活动列表</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/activity/activity_form" class="nav-link">
                                    <i class="far nav-icon fa fa-plus-square"></i>
                                    <p>申请活动</p>
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li class="nav-item has-treeview menu-open">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa fa-comment"></i>
                            <p>新闻管理
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="/news/my_news_list" class="nav-link">
                                    <i class="far nav-icon fa fa-list-alt"></i>
                                    <p>新闻列表</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/news/getForm" class="nav-link active">
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
                                <a href="/notice/notice_list" class="nav-link">
                                    <i class="far nav-icon fa fa-list-alt"></i>
                                    <p>公告列表</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/notice/notice_form" class="nav-link">
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
                                <a href="/finance/user_finance_form" class="nav-link">
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
                            <li class="breadcrumb-item active">发布新闻</li>
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
                    <div class="col-md-9">
                        <!-- Horizontal Form -->
                        <div class="card card-info">
                            <div class="card-header">
                                <%--这里使用下面返回的modelAttribute属性user,否则不能识别--%>
                                <h3 class="card-title">发布新闻</h3>
                            </div>
                            <!-- /.card-header -->
                            <!-- form start -->
                            <form id="inputForm" class="form-horizontal" action="/admin/save" method="post">
                                <div class="card-body">
                                    <div class="form-group row">
                                        <label class="required col-sm-2 col-form-label">新闻标题：</label>
                                        <div class="col-sm-10">
                                            <input id="newsTitle" name="newsTitle" class="required form-control" placeholder="请输入新闻标题"></input>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="required col-sm-2 col-form-label">内容：</label>
                                        <div class="col-sm-10">
                                            <div id="editor">
                                                <p>欢迎编写新闻，图片最多允许9张</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.card-body -->
                                <div class="card-footer">
                                    <button id="sub" name="sub" type="button" class="btn btn-info">提交</button>
                                    <button type="button" class="btn btn-default float-right" onclick="history.go(-1)">取消</button>
                                </div>
                                <!-- /.card-footer -->
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
<!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
<script type="text/javascript" src="/static/plugins/wangEditor-3.1.1/wangEditor.min.js"></script>
<script type="text/javascript">
    var E = window.wangEditor
    var editor = new E('#editor')
    // 或者 var editor = new E( document.getElementById('editor') )

    // 配置服务器端地址
    editor.customConfig.uploadImgServer = '/upload'
    // 通过 url 参数配置 debug 模式。url 中带有 wangeditor_debug_mode=1 才会开启 debug 模式
    editor.customConfig.debug = location.href.indexOf('wangeditor_debug_mode=1') > 0
    //自定义fileName
    editor.customConfig.uploadFileName = 'wangEditorFile'
    // 限制一次最多上传 5 张图片
    editor.customConfig.uploadImgMaxLength = 9

    //读取html
    document.getElementById('sub').addEventListener('click', function () {
        var newsTitle = $("#newsTitle").val();
        // 读取 html
        var newsContent = editor.txt.html();
        $.ajax({
            "url":"/news/saveNews",
            "type":"POST",
            "dataType":"json",
            "data":{
                "newsTitle":newsTitle,
                "newsContent":newsContent
            }
        });
        // 读取 html
        //alert(editor.txt.html())
        window.location.href="${pageContext.request.contextPath}/news/my_news_list";
    }, false)


    editor.create()
</script>
<style>
    #editor img{
        width: 500px;
    }
</style>
</body>
</html>