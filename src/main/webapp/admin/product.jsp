<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 17/10/2022
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="root"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>AdminLTE 3 | DataTables</title>
    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${root}plugins/fontawesome-free/css/all.min.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="${root}plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="${root}plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
    <link rel="stylesheet" href="${root}plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${root}asset/dist/css/adminlte.min.css">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->
    <%@include file="./ad_header.jsp" %>
    <!-- /.navbar -->
    <!-- Main Sidebar Container -->

    <%@include file="./sidebar.jsp" %>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>DataTables</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="../../admin.jsp">Home</a></li>
                            <li class="breadcrumb-item active">Tất cả sản phẩm</li>
                        </ol>
                    </div>
                </div>
            </div>
            <!-- /.container-fluid -->
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <!-- /.card -->
                        <div class="card">
                            <div class="card-header">
                                <h3 class="card-title">Tất cả sản phẩm</h3>
                                <div class="card-add">
                                    <a href="Ad_AddProductControl" class="">
                                        <p>Thêm sản phẩm</p>
                                    </a>
                                </div>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <table id="example1" class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <th>Mã sản phẩm</th>
                                        <th>Tên sản phẩm</th>
                                        <th>Giá bán</th>
                                        <th>Danh mục</th>
                                        <th>Số lượng</th>
                                        <th>Số lượng đã bán</th>
                                        <th>Sửa</th>
                                        <th>Xóa</th>
                                        <!-- <th>Ngày nhập</th> -->
                                    </tr>

                                    </thead>
                                    <tbody>
                                    <c:forEach var="l" items="${listSanPham}">
                                        <tr>
                                            <td>
                                                <a href="http://localhost:8080/Apple_store/ProductDetailControl?maSP=${l.maSP}">${l.maSP}</a>
                                            </td>
                                            <td>${l.tenSP}</td>
                                            <td data-type="money">${l.giaKhuyenMai}</td>
                                            <c:forEach var="d" items="${listDanhMuc}">
                                                <c:if test="${d.maDM == l.maDM}">
                                                    <td>${d.tenDM}</td>
                                                </c:if>
                                            </c:forEach>
                                            <td>${l.soLuong}</td>
                                            <td>${l.soLuongDaBan}</td>
                                            <td><a href="Ad_AddProductControl?maSP=${l.maSP}&action=modify">Sửa</a></td>
                                            <td><a href="Ad_AddProductControl?maSP=${l.maSP}&action=delete"
                                                   style="color: red;">Xóa</a></td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                    <tfoot>
                                    </tfoot>
                                </table>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <%@include file="./ad_footer.jsp" %>
    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->
<%@include file="./jqueryScript.jsp" %>
</body>
</html>