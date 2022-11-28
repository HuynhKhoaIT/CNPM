<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 18/10/2022
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="root"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>AdminLTE 3 | DataTables</title>

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback"/>
    <!-- Font Awesome -->
    <link rel="stylesheet"
          href="${root}plugins/fontawesome-free/css/all.min.css"/>
    <!-- DataTables -->
    <link rel="stylesheet"
          href="${root}plugins/datatables-bs4/css/dataTables.bootstrap4.min.css"/>
    <link rel="stylesheet"
          href="${root}plugins/datatables-responsive/css/responsive.bootstrap4.min.css"/>
    <link rel="stylesheet"
          href="${root}plugins/datatables-buttons/css/buttons.bootstrap4.min.css"/>
    <!-- Theme style -->
    <link rel="stylesheet" href="${root}asset/dist/css/adminlte.min.css"/>
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->
    <%@include file="./ad_header.jsp" %>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <%@include file="./sidebar.jsp" %>
    <style>
        /*style mở ra một khu vực để viết mã CSS*/

        .top-cart{
            overflow: hidden;
            border: 1px solid #ccc;
            background-color: #f1f1f1;
            padding-top: 0;
            padding-bottom: 0;
        }

        .order-btn{
            line-height: 47.11px;
            padding: 0 10px;

        }
        .sell-btn{
            line-height: 47.11px;
            padding: 0 10px;

        }

        .sell-btn:hover,
        .order-btn:hover{
            cursor: pointer;
            background-color: #ddd;
        }

    </style>
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
                        <div class="card">
                            <div class="card-header top-cart">

                                <h3 class="card-title order-btn">Tất cả đơn hàng của tháng ${month }</h3>


                                <a href="${root}admin/SellMonthly?month=${month}">
                                    <h3 class="card-title sell-btn">Danh sách sản phẩm bán chạy trong tháng ${month }</h3>
                                </a>

                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <table id="example1" class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <th>Mã Khách Hàng</th>
                                        <th>Loại Khách Hàng</th>
                                        <th>Mã Đơn Hàng</th>
                                        <th>Tổng Tiền</th>
                                        <th>Thời Gian</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:if test="${size>0 }">
                                    <c:forEach var="i" begin="0" end="${size-1 }">
                                        <tr>	
                                            <td>
                                                <a href="Ad_AccountControl?maKH=${list[i].getMaKH()}">${list[i].getMaKH()}</a>
                                            </td>

                                            <c:choose>

                                                <c:when test="${ten[i] == null}">
                                                    <td>Chưa đăng ký</td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td>Thành viên</td>
                                                </c:otherwise>
                                            </c:choose>
                                            <td><a
                                                    href="Ad_invoiceControl?maDH=${list[i].getMaDH()}">${list[i].getMaDH()}</a>
                                            </td>
                                            <td data-type="money">${list[i].getTongTien()}</td>
                                            <td>${list[i].getThoiGian()}</td>
                                        </tr>
                                    </c:forEach>
                                    </c:if>
                                    </tbody>

                                    <tfoot></tfoot>
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
