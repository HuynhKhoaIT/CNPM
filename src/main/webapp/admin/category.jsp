<%-- Created by IntelliJ IDEA. User: admin Date: 17/10/2022 Time: 18:00 To change this template use File | Settings | File Templates. --%> <%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib prefix="c"
                                                                                                                                                                                                                        uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="root" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>AdminLTE 3 | DataTables</title>
    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback" />
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${root}plugins/fontawesome-free/css/all.min.css" />
    <!-- DataTables -->
    <link rel="stylesheet" href="${root}plugins/datatables-bs4/css/dataTables.bootstrap4.min.css" />
    <link rel="stylesheet" href="${root}plugins/datatables-responsive/css/responsive.bootstrap4.min.css" />
    <link rel="stylesheet" href="${root}plugins/datatables-buttons/css/buttons.bootstrap4.min.css" />
    <!-- Theme style -->
    <link rel="stylesheet" href="${root}asset/dist/css/adminlte.min.css" />
    <link rel="stylesheet" href="${root}asset/dist/css/style.css" />
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->
    <c:set var="items" value="${listlsp}" scope="request" />

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
                                <h3 class="card-title">Tất cả danh mục</h3>
                                <div class="card-add">
                                    <a href="${root}admin/Ad_AddCategory" class="">
                                        <p>Thêm danh mục</p>
                                    </a>
                                </div>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <div class="tab">
                                    <c:forEach items="${listlsp}" var="o">
                                        <a href="?maloai=${o.maLoai}">
                                            <button class="tablinks" onclick="openCity(event, '${o.tenLoai}')">${o.tenLoai}</button>
                                        </a>
                                    </c:forEach>
                                </div>
                                <!-- danh mục con của ip -->

                                <div class="tabcontent">
                                    <table id="example1" class="table table-bordered table-striped table-ip">
                                        <thead>
                                        <tr>
                                            <th>Mã danh mục</th>
                                            <th>Tên danh mục</th>
                                            <th>Sửa</th>
                                            <th>Xóa</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${listdm}" var="o">
                                            <tr>
                                                <td>
                                                        ${o.maDM}
                                                </td>
                                                <td>
                                                        ${o.tenDM}
                                                </td> 
                                                <td><a href="#">Sửa</a></td>
                      							<td><a href="#" style="color: red;">Xóa</a></td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                        <tfoot></tfoot>
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

</body>
</html>