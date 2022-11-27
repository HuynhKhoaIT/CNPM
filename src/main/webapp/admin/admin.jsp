<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="root"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Apple_Store | Admin</title>
    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet"
          href="${root}plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="${root}asset/css/logout.css">
    <link rel="stylesheet"
          href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="${root}asset/dist/css/adminlte.min.css">
    <%-- <link rel="stylesheet" href="${root}asset/css/adminlte.min.css"> --%>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">
    <!-- Preloader -->
    <div
            class="preloader flex-column justify-content-center align-items-center">
        <img class="animation__shake"
             src="${root}asset/dist/img/AdminLTELogo.png" alt="AdminLTELogo"
             height="60" width="60">
    </div>
    <!-- Navbar -->
    <%@include file="./ad_header.jsp" %>
    <!-- /.navbar -->
    <!-- Main Sidebar Container -->
    <%@include file="./sidebar.jsp" %>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1 class="m-0">Dashboard</h1>
                    </div>
                    <!-- /.col -->
                    <!-- <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">Dashboard v1</li>
                        </ol>
                    </div> -->
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->
        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <!-- Small boxes (Stat box) -->
                <div class="row">
                    <div class="col-lg-6 col-6">
                        <!-- small box -->
                        <div class="small-box bg-info">
                            <div class="inner">
                                <h3>${size}</h3>
                                <p>Đơn hàng mới</p>
                            </div>
                            <div class="icon">
                                <i class="ion ion-bag"></i>
                            </div>
                            <a href="http://localhost:8080/Apple_store/admin/newOrder"
                               class="small-box-footer">Thêm thông tin <i
                                    class="fas fa-arrow-circle-right"></i></a>
                        </div>
                    </div>
                    <!-- ./col -->
                    <div class="col-lg-6 col-6">
                        <!-- small box -->
                        <div class="small-box bg-warning">
                            <div class="inner">
                                <h3>${khachhangAmount}</h3>
                                <p>Danh sách khách hàng</p>
                            </div>
                            <div class="icon">
                                <i class="ion ion-person-add"></i>
                            </div>
                            <a href="http://localhost:8080/Apple_store/admin/Ad_UserControl?u=2"
                               class="small-box-footer">Thêm
                                thông tin <i class="fas fa-arrow-circle-right"></i>
                            </a>
                        </div>
                    </div>
                </div>
                <!-- /.row -->

                <!-- <div class="row">
                    <div class="col-12 col-sm-6 col-md-3">
                        <div class="info-box">
                                <span class="info-box-icon bg-info elevation-1"><i
                                        class="fas fa-cog"></i></span>

                            <div class="info-box-content">
                                <span class="info-box-text">CPU Traffic</span> <span
                                    class="info-box-number"> 10 <small>%</small>
                                    </span>
                            </div>
                            /.info-box-content
                        </div>
                        /.info-box
                    </div>
                    /.col
                    <div class="col-12 col-sm-6 col-md-3">
                        <div class="info-box mb-3">
                                <span class="info-box-icon bg-danger elevation-1"><i
                                        class="fas fa-thumbs-up"></i></span>

                            <div class="info-box-content">
                                <span class="info-box-text">Likes</span> <span
                                    class="info-box-number">41,410</span>
                            </div>
                            /.info-box-content
                        </div>
                        /.info-box
                    </div>
                    /.col

                    fix for small devices only
                    <div class="clearfix hidden-md-up"></div>

                    <div class="col-12 col-sm-6 col-md-3">
                        <div class="info-box mb-3">
                                <span class="info-box-icon bg-success elevation-1"><i
                                        class="fas fa-shopping-cart"></i></span>


                            <div class="info-box-content">
                                <span class="info-box-text">Sales</span> <span
                                    class="info-box-number">760</span>
                            </div>
                            /.info-box-content
                        </div>
                        /.info-box
                    </div>
                    /.col
                    <div class="col-12 col-sm-6 col-md-3">
                        <div class="info-box mb-3">
                                <span class="info-box-icon bg-warning elevation-1"><i
                                        class="fas fa-users"></i></span>

                            <div class="info-box-content">
                                <span class="info-box-text">New Members</span> <span
                                    class="info-box-number">2,000</span>
                            </div>
                            /.info-box-content
                        </div>
                        /.info-box
                    </div>
                    /.col
                </div> -->
                <!-- /.row -->

                

                <div class="row">
                    <!-- Left col -->
                    <!-- TABLE: LATEST ORDERS -->
                    <div class="card col-md-12">
                        <div class="card-header border-transparent">
                            <h3 class="card-title">Đơn đặt hàng mới nhất</h3>

                            <div class="card-tools">
                                <button type="button" class="btn btn-tool"
                                        data-card-widget="collapse">
                                    <i class="fas fa-minus"></i>
                                </button>
                                <button type="button" class="btn btn-tool"
                                        data-card-widget="remove">
                                    <i class="fas fa-times"></i>
                                </button>
                            </div>
                        </div>
                        <!-- /.card-header -->
                        <div class="card-body p-0">
                            <div class="table-responsive">
                                <table class="table m-0">
                                    <thead>
                                    <tr>
                                        <th>ID đặt hàng</th>
                                        <th>Khách hàng</th>
                                        <th>Trạng thái</th>
                                        <th>Thời gian</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="i" begin="0" end="${size-1 }">
                                        <tr>
                                            <td>
                                                <a href="admin/Ad_invoiceControl?maDH=${list[i].getMaDH()}">${list[i].getMaDH()}</a>
                                            </td>
                                            <td>${listName[i]}</td>
                                            <c:choose>
                                                <c:when test="${list[i].getMaTrangThai()==1}">
                                                    <td><span class="badge badge-success">Chưa Xác Nhận</span></td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td><span class="badge badge-success">Đã Xác Nhận</span></td>
                                                </c:otherwise>
                                            </c:choose>
                                            <td>
                                                <div class="sparkbar" data-color="#00a65a"
                                                     data-height="20">${list[i].getThoiGian()}</div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.card-body -->
                        <div class="card-footer clearfix">
                            <a
                                    href="http://localhost:8080/Apple_store/admin/AllOrder"
                                    class="btn btn-sm btn-secondary float-right">Xem tất cả</a>
                        </div>
                        <!-- /.card-footer -->
                    </div>
                    <!-- /.card -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.container-fluid -->
        </section>
        <!-- /.content -->
    </div>
    <!-- <aside class="control-sidebar control-sidebar-dark"> -->
    <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->
<!-- jQuery -->
<script src="${root}plugins/jquery/jquery.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button)
</script>
<script src="${root}asset/dist/js/adminlte.js"></script>
</body>
</html>
