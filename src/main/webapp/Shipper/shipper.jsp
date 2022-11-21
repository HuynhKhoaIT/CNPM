<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/" var="root" />
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
	<link rel="stylesheet" href="${root}asset/css/logout.css">
	<link rel="stylesheet"
		  href="${root}plugins/fontawesome-free/css/all.min.css">
	<!-- Ionicons -->
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
	<%@include file="./ad_header.jsp"%>
	<!-- /.navbar -->
	<!-- Main Sidebar Container -->
	<%@include file="./sidebar.jsp"%>
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
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="http://localhost:8080/Apple_store/shipper">Home</a></li>
							<li class="breadcrumb-item active">Dashboard v1</li>
						</ol>
					</div>
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
					<div class="col-lg-6 col-12">
						<!-- small box -->
						<div class="small-box bg-info">
							<div class="inner">
								<h3>${SLCoTheNhanGiao}</h3>
								<p>Đơn hàng mới</p>
							</div>
							<div class="icon">
								<i class="ion ion-bag"></i>
							</div>
							<a href="/Apple_store/ShiperNewOrder?tt=2"
							   class="small-box-footer">Thêm thông tin <i
									class="fas fa-arrow-circle-right"></i></a>
						</div>
					</div>
					<!-- ./col -->
					<div class="col-lg-6 col-12">
						<!-- small box -->
						<div class="small-box bg-warning">
							<div class="inner">
								<h3>${SLDonHangDaGiao}</h3>
								<p>Đơn hàng đã giao</p>
							</div>
							<div class="icon">
								<i class="ion ion-person-add"></i>
							</div>
							<a href="/Apple_store/ShiperNewOrder?tt=4" class="small-box-footer">Thêm
								thông tin <i class="fas fa-arrow-circle-right"></i>
							</a>
						</div>
					</div>
				</div>
				
				

				<div class="row">
					<!-- Left col -->
					<!-- TABLE: LATEST ORDERS -->
					<div class="card col-md-12">
						<div class="card-header border-transparent">
							<h3 class="card-title">Đơn hàng cần giao</h3>

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
						<div class="card-body">
									<table id="example1" class="table table-bordered table-striped">
										<thead>
											<tr>
												<th>Mã đơn hàng</th>
												<th>Tên hách hàng</th>
												<th>Số tiền</th>
												<th>Thời gian</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach items="${listDangGiao}" var="l">
											<tr>


											<td><a href="Ship_invoice?maDH=${l.maDH}">${l.maDH}</a></td>
											<td>${l.tenNguoiNhan}</td>
											<c:choose>
												<c:when test="${l.phuongThucThanhToan== 1}">
													<td><span class="badge badge-success">0</span></td>
												</c:when>
												<c:otherwise>
													<td><span class="badge badge-success">${l.tongTien}</span></td>
												</c:otherwise>
											</c:choose>
											<td>${l.thoiGian}</td>
										</c:forEach>
											</tr>

										</tbody>

										<tfoot></tfoot>
									</table>
								</div>
						<!-- /.card-header -->
						
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
<%@include file="./jqueryScript.jsp"%>
</body>
</html>