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
        <link rel="stylesheet" href="${root}asset/style.css">
    
    <title>Insert title here</title>
</head>
<body>
<div class="main" style="font-size: 24px; margin: 0 15px;">
	<c:set var="items" value="${listlsp}" scope="request"/>
    <div class="content">
           <div class="row" style="justify-content: space-between;">
<%--           	<h3>Khách hàng: ${sessionScope.a.getTenKH()}</h3>--%>
           	<a href="${root}">
            	<button class="btn-continuel">Tiếp Tục Mua Hàng</button>
            </a>
           	<div class="table-responsive">
            <table class="table m-0">
                <thead>
                <tr>
                    <th>Mã đơn hàng</th>
                    <th>Trạng thái</th>
                    <th>Ngày mua</th>
                    <th>Ngày nhận</th>
                    <th>Tổng Tiền</th>
                    <th>Địa chỉ</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items = "${listDonHang }" var="list"> 
	                    <tr>
	                        <td><a href = "/Apple_store/User_OrderDetail?id=${list.getMaDH()}">${list.getMaDH()}</a></td>
	                        <c:forEach items = "${listTrangThai }" var = "o">
	                        	<c:if test="${list.maTrangThai == o.maTrangThai}">
	                        		<td>${o.tenTrangThai}</td>
	                        	</c:if>
	                        </c:forEach>
	                         <td>${list.thoiGian}</td>
                            <td>${list.ngayNhanHang}</td>

	                        <td data-type="money">${list.getTongTien()}</td>
                            <td>${list.diaChi}</td>
	                    </tr>
                	</c:forEach>
                </tbody>
            </table>
           </div>
    	</div>
    	
	</div>
</div>
</body>
<script>

    document.querySelectorAll('[data-type="money"]').forEach(item => {

        item.innerHTML = new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'vnd'}).format(item.innerHTML);
    })
</script>
</html>