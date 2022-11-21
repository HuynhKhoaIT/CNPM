<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 18/10/2022
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="root" />
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Contacts</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${root}plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${root}asset/dist/css/adminlte.min.css">
</head>
<body class="hold-transition sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">
  <!-- Navbar -->

<%@include file="./ad_header.jsp"%>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <%@include file="./sidebar.jsp"%>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Thành viên</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="${root}admin/admin.jsp">Home</a></li>
              <li class="breadcrumb-item active">Contacts</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="card card-solid">
        <div class="card-body pb-0">
          <div class="row">
            <div class="col-12 col-sm-12 col-md-12 d-flex align-items-stretch flex-column">
              <div class="card bg-light d-flex flex-fill">
                <div class="card-body pt-0">
                  <div class="row">
                    <div class="col-3 text-center">
                      <img src="${root}asset/dist/img/user1-128x128.jpg" alt="user-avatar" class="img-circle img-fluid">
                    </div>
                    <div class="col-9">
                      <h2 class="lead"><b>${khachHang.tenKH}</b></h2>
                      <ul class="ml-4 mb-0 fa-ul text-muted">
                        <li class="small"><span class="fa-li"><i class="fas fa-lg fa-building"></i></span> Địa chỉ: ${khachHang.diaChi}</li>
                        <li class="small"><span class="fa-li"><i class="fas fa-lg fa-phone"></i></span> SDT: ${khachHang.phone}</li>
                        <li class="small"><span class="fa-li"><i class="fas fa-lg fa-gmail"></i></span> Email: ${khachHang.email}</li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <table id="example1" class="table table-bordered table-striped">
            <thead>
            <tr>
              <th>Mã Đơn Hàng</th>
              <th>Tổng Tiền</th>
              <th>Thời Gian</th>
              <th>Tình Trạng</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="l" items="${listDonHang}">
              <tr>
                <td>
                  <a href="Ad_invoiceControl?maDH=${l.maDH}">
                    ${l.maDH}
                  </a>
                </td>
                <td> ${l.tongTien} </td>
                <td> ${l.thoiGian} </td>
                  <c:forEach var="tt" items="${listTrangThai}">
                    <c:if test="${tt.maTrangThai == l.maTrangThai}">
                      <td>${tt.tenTrangThai}</td>
                    </c:if>
                  </c:forEach>
              </tr>
            </c:forEach>

            </tbody>
            <tfoot>
            </tfoot>
          </table>
        </div>
      </div>
    </section>
  <!-- /.content -->
  </div>
<!-- /.content-wrapper -->

<!-- Control Sidebar -->
<aside class="control-sidebar control-sidebar-dark">
  <!-- Control sidebar content goes here -->
</aside>
<!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="${root}plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${root}plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="${root}asset/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${root}asset/dist/js/demo.js"></script>
</body>
</html>
