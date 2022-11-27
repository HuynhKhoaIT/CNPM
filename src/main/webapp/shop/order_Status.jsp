<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="root"/>
<!DOCTYPE html>
<html>
<head>
     <meta charset="ISO-8859-1">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet"
          href="${root}plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet"
          href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="${root}asset/dist/css/adminlte.min.css">
    <link href="<c:url value="asset/style.css" />" rel="stylesheet">
    <title>Insert title here</title>
</head>
<body>
<div class="main">
    <div class="content">
           <div class="row">
           	<h3>Khách hàng: Nguyễn Huỳnh Khoa</h3>
           	<div class="table-responsive">
            <table class="table m-0">
                <thead>
                <tr>
                    <th>Mã đơn hàng</th>
                    <th>Trạng thái</th>
                    <th>Tổng Tiền</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><a href="#">1</a></td>
                        <td>Đã Xác nhận</td>
                        <td>1300000</td>
                    </tr>
                    <tr>
                        <td><a href="#">2</a></td>
                        <td>Đã Giao</td>
                        <td>1500000</td>
                    </tr>
                </tbody>
            </table>
           </div>
    </div>

</div>
</body>
</html>