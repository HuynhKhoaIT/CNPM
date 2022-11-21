<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 18/10/2022
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/" var="root" />
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>AdminLTE 3 | DataTables</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet"
        href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback" />
  <!-- Font Awesome -->
  <link rel="stylesheet"
        href="${root}plugins/fontawesome-free/css/all.min.css" />
  <!-- DataTables -->
  <link rel="stylesheet"
        href="${root}plugins/datatables-bs4/css/dataTables.bootstrap4.min.css" />
  <link rel="stylesheet"
        href="${root}plugins/datatables-responsive/css/responsive.bootstrap4.min.css" />
  <link rel="stylesheet"
        href="${root}plugins/datatables-buttons/css/buttons.bootstrap4.min.css" />
  <!-- Theme style -->
  <link rel="stylesheet" href="${root}asset/dist/css/adminlte.min.css" />
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
  <!-- Navbar -->
  <%@include file="./ad_header.jsp"%>


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
              <li class="breadcrumb-item"><a href="../../admin.jsp">Home</a></li>
              <li class="breadcrumb-item active">Tất cả đơn hàng</li>
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
            <!-- Main content -->
            <div class="invoice p-3 mb-3">
              <!-- title row -->
              <div class="row">
                <div class="col-12">
                  <c:if test="${donHang.ngayNhanHang!=null}">
                    <h4><i class="fas fa-globe"></i> Ngày giao: ${donHang.ngayNhanHang}</h4>
                  </c:if>
                </div>
                <!-- /.col -->
              </div>
              <!-- info row -->
              <div class="row invoice-info">
                <div class="col-sm-4 invoice-col">
                  Từ
                  <address>
                    <strong>Admin, Inc.</strong><br> 1 Võ Văn Ngân<br>
                    Quận Thủ Đức<br> Phone: 0869950090<br> Email:
                    info@gmail.com
                  </address>
                </div>
                <!-- /.col -->
                <div class="col-sm-4 invoice-col">
                  Đến
                  <address>
                    <strong>${donHang.tenNguoiNhan}</strong>
                    <br>
                    ${donHang.diaChi}
                    <br>
                    Phone: ${donHang.soDienThoai}<br>
                  </address>
                </div>
                <!-- /.col -->
                <div class="col-sm-4 invoice-col">
                  <b>Hóa Đơn #${donHang.maDH}</b><br> <br> <b>ID
                  đặt hàng:</b> ${khachHang.maKH}<br> <b>Ngày đặt hàng:</b>
                  ${donHang.thoiGian} <br> <b>Tài khoản:</b> ${taikhoan.getTenDN()  }
                </div>
                <!-- /.col -->
              </div>
              <!-- /.row -->

              <!-- Table row -->
              <div class="row">
                <div class="col-12 table-responsive">
                  <table class="table table-striped">
                    <thead>
                    <tr>
                      <th>SL</th>
                      <th>Tên sản phẩm</th>
                      <th>Mã sản phẩm #</th>
                      <th>Thành tiền</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="i" begin="0" end="${size-1}">
                      <tr>
                        <td>${listDetail[i].getSoLuong()}</td>
                        <td>${listSP[i].getTenSP()}</td>
                        <td>${listSP[i].getMaSP()}</td>
                        <td>${listDetail[i].getTongTien()} VND</td>
                      </tr>
                    </c:forEach>

                    </tbody>
                  </table>
                </div>
                <!-- /.col -->
              </div>
              <!-- /.row -->

              <div class="row">
                <div class="col-6">

                  <div class="table-responsive">
                    <table class="table">
                      <tr>
                        <c:if test="${donHang.phuongThucThanhToan == 0}">
                          <th style="width: 50%">Tổng tiền thu:</th>
                          <td>${donHang.getTongTien()} VND</td>
                        </c:if>
                        <c:if test="${donHang.phuongThucThanhToan == 1}">
                          <th style="width: 50%">Tổng tiền thu:</th>
                          <td>0 VND</td>
                          <td> Đã thanh toán online</td>
                        </c:if>

                      </tr>

                    </table>
                  </div>
                </div>
                <!-- /.col -->
              </div>

              <!-- /.row -->

              <!-- this row will not appear when printing -->
              <div class="row no-print">
                <div class="col-12">
<%--                  <a href="invoice-print.jsp" rel="noopener" target="_blank"--%>
<%--                     class="btn btn-default"><i class="fas fa-print"></i>--%>
<%--                    Print</a>--%>
                  <form action="Ship_invoice" method="post">
                    <input type="hidden" value= "${donHang.maDH}" name = "maDH" />
                    <input type="hidden" value="${donHang.maTrangThai}" name="maTT">
                    <button type="submit" class="btn btn-success float-right" id="changeStatus">
                      Nhận giao đơn hàng
                    </button>
                  </form>
                  <script>
                    var check = ${donHang.maTrangThai};
                    if(check == 3)
                    {
                      document.getElementById("changeStatus").innerHTML = "Xác nhận đã giao"
                      document.getElementById("changeStatus").style.background='blue';
                    }
                    if(check == 4)
                    {
                      // document.getElementById("changeStatus").style.visibility= 'hidden';
                      document.getElementById("changeStatus").type ="button";
                      document.getElementById("changeStatus").innerHTML = "Đã giao"
                      document.getElementById("changeStatus").style.background='red ';
                    }
                  </script>
                </div>
              </div>
            </div>
            <!-- /.invoice -->
          </div>
          <!-- /.col -->
        </div>
        <!-- /.row -->
      </div>
      <!-- /.container-fluid -->
    </section>

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
<script src="${root}plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${root}plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- DataTables  & Plugins -->
<script src="${root}plugins/datatables/jquery.dataTables.min.js"></script>
<script
        src="${root}plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script
        src="${root}plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script
        src="${root}plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<script
        src="${root}plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
<script
        src="${root}plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
<script src="${root}plugins/jszip/jszip.min.js"></script>
<script src="${root}plugins/pdfmake/pdfmake.min.js"></script>
<script src="${root}plugins/pdfmake/vfs_fonts.js"></script>
<script src="${root}plugins/datatables-buttons/js/buttons.html5.min.js"></script>
<script src="${root}plugins/datatables-buttons/js/buttons.print.min.js"></script>
<script
        src="${root}plugins/datatables-buttons/js/buttons.colVis.min.js"></script>
<!-- AdminLTE App -->
<script src="${root}asset/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${root}asset/dist/js/demo.js"></script>
<!-- Page specific script -->
<script>
  $(function() {
    $("#example1").DataTable({
      responsive : true,
      lengthChange : false,
      autoWidth : false,
      buttons : [ "copy", "csv", "excel", "pdf", "print", "colvis" ],
    }).buttons().container().appendTo(
            "#example1_wrapper .col-md-6:eq(0)");
    $("#example2").DataTable({
      paging : true,
      lengthChange : false,
      searching : false,
      ordering : true,
      info : true,
      autoWidth : false,
      responsive : true,
    });
  });
</script>
</body>
</html>
