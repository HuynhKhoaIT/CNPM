<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="root"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>AdminLTE 3 | General Form Elements</title>
    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${root}plugins/fontawesome-free/css/all.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${root}asset/dist/css/adminlte.min.css">
    <link rel="stylesheet" href="${root}asset/dist/css/style.css">
    <script src="https://cdn.tiny.cloud/1/781p7i27bbwdg757ok7m74oq4ml6c276q7hqp1940jb3stfi/tinymce/6/tinymce.min.js"
            referrerpolicy="origin"></script>
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
                        <h1>Thêm sản phẩm mới</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="../../admin.jsp">Home</a></li>
                            <li class="breadcrumb-item active">Thêm sản phẩm</li>
                        </ol>
                    </div>
                </div>
            </div>
            <!-- /.container-fluid -->
        </section>
        <!-- Main content -->
        <section class="content">
            <%--  <form method="get" action="Ad_AddProductControl" id="LoaiSPFrom">
                 <div class="form-group">
                     <label >Danh mục cha</label>
                     <select id="mySelect" onchange="myFunction()" class="form-control select2 select2-hidden-accessible"
                             style="width: 100%;" data-select2-id="1" tabindex="-1" aria-hidden="true" name="maLoai">
                         <c:forEach items="${listLoaiSP}" var="l">
                             <option value="${l.maLoai}" ${l.maLoai == maLoai ? 'selected' : ''}>${l.tenLoai}</option>
                         </c:forEach>
                     </select>
                 </div>
             </form> --%>
            <form method="post" action="Ad_AddProductControl?action=${action}" id="AddProductForm"
                  enctype="multipart/form-data">
                <input type="hidden" value="${maLoai}" name="maLoai">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Thông tin sản phẩm</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- form start -->
                                <%--                <form>--%>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label>Tên sản phẩm</label>
                                        <input type="text" class="form-control" placeholder="Enter name"
                                               name="tensanpham" value="${sanPham.tenSP}">
                                    </div>
                                    <div class="form-group">
                                        <label>Mô tả ngắn</label>
                                        <textarea class="form-control tiny" placeholder="Enter ..."
                                                  name="motangan">${sanPham.moTaNgan}</textarea>
                                    </div>
                                    <div class="form-group">
                                        <label>Mô tả sản phẩm</label>
                                        <textarea class="form-control tiny" placeholder="Enter ..."
                                                  name="motasanpham">${sanPham.moTa}</textarea>
                                    </div>
                                    <script type="text/javascript">
                                        tinymce.init({
                                            entity_encoding: "raw"
                                        });
                                    </script>
                                    <div class="form-group">
                                        <label>Giá gốc</label>
                                        <input type="number" min="0" max="100000000000" step="1" class="form-control"
                                               name="giagoc" value="${sanPham.giaGoc}"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Giá bán thường</label>
                                        <input type="number" min="0" max="100000000000" step="1" class="form-control"
                                               name="giabanthuong" value="${sanPham.giaBanThuong}"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Giá khuyến mãi</label>
                                        <input type="number" min="0" max="100000000000" step="1" class="form-control"
                                               name="giakhuyenmai" value="${sanPham.giaKhuyenMai}"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Số lượng</label>
                                        <input type="number" class="form-control" name="soluong"
                                               value="${sanPham.soLuong}"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Ảnh sản phẩm</label>
                                        <%--                      <form action="/action_page.php">--%>
                                        <form>
                                            <input type="hidden" value="${sanPham.anh}" name="oldImage">
                                            <input type="file" name="multiPartServlet" multiple="multiple"/>
                                            <%--                                            <input type="file" name="image"/><br><br>--%>
                                        </form>
                                    </div>
                                    <div class="form-group">
                                        <label>Danh mục</label>
                                        <select class="form-control select2 select2-hidden-accessible"
                                                style="width: 100%;" data-select2-id="1" tabindex="-1"
                                                aria-hidden="true" name="maDM">
                                            <c:forEach var="o" items="${listDanhMuc}">
                                                <option value="${o.maDM}" ${o.maDM == sanPham.maDM ? 'selected' : ''}>${o.tenDM}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <input type="hidden" value="${sanPham.maSP}" name="maSP"/>
                                </div>
                                <div class="card-footer">
                                    <button type="submit" form="AddProductForm" class="btn btn-primary">Submit</button>
                                </div>
                                <!-- /.card-body -->
                                <%--                  <div class="card-footer">--%>
                                <%--                    <button type="submit" class="btn btn-primary">Submit</button>--%>
                                <%--                  </div>--%>
                                <%--                </form>--%>
                            </div>
                        </div>
                        <!-- begin -->

                        <!-- end -->
                    </div>
                </div>
            </form>
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
<!-- Ajax to Java File Upload Logic -->
<script>
    async function uploadFile() {
        let formData = new FormData();
        formData.append("file", ajaxfile.files[0]);
        await fetch('/admin/Ad_AddProductControl', {
            method: "POST",
            body: formData
        });
        alert('The file upload with Ajax and Java was a success!');
    }
</script>
<!-- ./wrapper -->
<!-- jQuery -->
<script src="${root}plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${root}plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- bs-custom-file-input -->
<script src="${root}plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
<!-- AdminLTE App -->
<script src="${root}asset/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${root}asset/dist/js/demo.js"></script>
<!-- Page specific script -->
<script>
    $(function () {
        bsCustomFileInput.init();
    });
</script>
<!-- active spec -->
<script>
    function myFunction() {
        var x = document.getElementById("mySelect").value;
        spec = document.getElementsByClassName("specifications");
        if (x == "1") {
            // for (i = 0; i < spec.length; i++) {
            //   spec[i].style.display = "none";
            // }
            // spec[0].style.display = "block";
            document.getElementById("LoaiSPFrom").submit();
        } else if (x == "2") {
            // for (i = 0; i < spec.length; i++) {
            //   spec[i].style.display = "none";
            // }
            // spec[1].style.display = "block";
            document.getElementById("LoaiSPFrom").submit();
        } else if (x == "4") {
            // for (i = 0; i < spec.length; i++) {
            //   spec[i].style.display = "none";
            // }
            // spec[2].style.display = "block";
            document.getElementById("LoaiSPFrom").submit();
        } else if (x == "3") {
            // for (i = 0; i < spec.length; i++) {
            //   spec[i].style.display = "none";
            // }
            // spec[3].style.display = "block";
            document.getElementById("LoaiSPFrom").submit();
        } else {
            // for (i = 0; i < spec.length; i++) {
            //   spec[i].style.display = "none";
            document.getElementById("LoaiSPFrom").submit();
        }
    }
</script>
</body>
</html>