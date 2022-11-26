<%--
   Created by IntelliJ IDEA.
   User: admin
   Date: 17/10/2022
   Time: 18:00
   To change this template use File | Settings | File Templates.
   --%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/" var="root" />
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
<link rel="stylesheet"
	href="${root}plugins/fontawesome-free/css/all.min.css">
<!-- DataTables -->
<link rel="stylesheet"
	href="${root}plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet"
	href="${root}plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
<link rel="stylesheet"
	href="${root}plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="${root}asset/dist/css/adminlte.min.css">
<link rel="stylesheet" href="${root}asset/dist/css/style.css">
</head>
<body class="hold-transition sidebar-mini">
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
							<h1>DataTables</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="${root}admin.jsp">Home</a></li>
								<li class="breadcrumb-item active">Danh mục</li>
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
							<div class="card">
								<!-- <div class="card-header">
                              <h3 class="card-title">DataTable with minimal features & hover style</h3>
                              </div> -->
								<!-- /.card-header -->
							</div>
							<!-- /.card -->
							<div class="card">
								<div class="card-header">
									<h3 class="card-title">BÁO CÁO DOANH THU</h3>
								</div>
								<!-- /.card-header -->
								<div class="card-body">
									<div class="tab">
										<button class="tablinks" onclick="openCity(event, 'month')">Tháng</button>
										<button class="tablinks" onclick="openCity(event, 'quarter')">Quý</button>
										<button class="tablinks" onclick="openCity(event, 'year')">Năm</button>
									</div>
									<!-- Doanh thu theo tháng -->
									<div id="month" class="tabcontent">
										<table id="example1"
											class="table table-bordered table-striped table-ip">
											<thead>
												<tr>
													<th>Tháng</th>
													<th>Doanh thu</th>
													<th>Chi phí</th>
													<th>Lợi Nhuận</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="i" begin="0" end="11">
													<tr>
														<td>${i+1}</td>
														<td data-type="money">${doanhThu[i]}VND</td>
														<td data-type="money">${ChiPhi[i]}VND</td>
														<td data-type="money">${doanhThu[i]-ChiPhi[i]}VND</td>
													</tr>
												</c:forEach>
											</tbody>
											<tfoot>
											</tfoot>
										</table>
									</div>
									<!-- Doanh thu theo quý -->
									<div id="quarter" class="tabcontent" style="display: none;">
										<table id="example1"
											class="table table-bordered table-striped table-ipad">
											<thead>
												<tr>
													<th>Quý</th>
													<th>Doanh thu</th>
													<th>Chi phí</th>
													<th>Lợi Nhuận</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="i" begin="0" end="2">
													<tr>
														<td>${i+1}</td>
														<td data-type="money">${doanhThuQuy[i]}VND</td>
														<td data-type="money">${ChiPhiQuy[i]}VND</td>
														<td data-type="money">${doanhThuQuy[i]-ChiPhiQuy[i]}VND</td>
													</tr>
												</c:forEach>

											</tbody>
											<tfoot>
											</tfoot>
										</table>
									</div>
									<!-- Doanh thu theo năm -->
									<div id="year" class="tabcontent" style="display: none;">
										<table id="example1"
											class="table table-bordered table-striped table-mac">
											<thead>
												<tr>
													<th>Năm</th>
													<th>Doanh thu</th>
													<th>Chi phí</th>
													<th>Lợi Nhuận</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="i" begin="0" end="5">
													<tr>
														<td>${year[i]}</td>
														<td data-type="money">${doanhThuNam[i]}VND</td>
														<td data-type="money">${ChiPhiNam[i]}VND</td>
														<td data-type="money">${doanhThuNam[i]-ChiPhiNam[i]}VND</td>
													</tr>
												</c:forEach>
												
											</tbody>
											<tfoot>
											</tfoot>
										</table>
									</div>
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
		<%@include file="./ad_footer.jsp"%>
		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->
	<!-- jQuery -->
	<%@include file="./jqueryScript.jsp"%>
	<!-- js cho danh mục con ne Khoa Dung XOa nha -->
	<script>
		function openCity(evt, cityName) {
			console.log("1");
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablinks");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].className = tablinks[i].className.replace(
						" active", "");
			}
			document.getElementById(cityName).style.display = "block";
			evt.currentTarget.className += " active";
		}
	</script>
</body>
</html>
