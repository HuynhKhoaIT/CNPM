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
    <link rel="stylaesheet"
          href="${root}plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet"
          href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="${root}asset/dist/css/adminlte.min.css">
    <link href="<c:url value="asset/style.css" />" rel="stylesheet">
    <title>Insert title here</title>
</head>
<body>
<div class="main" >
    <c:set var="items" value="${listlsp}" scope="request"/>
    <div class="card-body p-0">
        <div class="table-responsive" style="font-size: 24px;">
            <table class="table m-0">
                <thead>
                <tr class="title_order_stt">
                    <th>ID đơn hàng</th>
                    <th>Sản phẩm</th>
                    <th>Số lượng</th>
                    <th>Tổng tiền</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="i" begin="0" end="${size-1 }">
                    <tr class="content_order_stt">
                        <td>${listDetail[i].getMaDH()}</td>
                        <td>${listName[i]}</td>
                        <td>${listDetail[i].getSoLuong()}</td>
                        <td data-type="money">${listDetail[i].getTongTien()}</td>

                    </tr>
                </c:forEach>

                </tbody>
            </table>

        </div>
        <div class="row" style="margin-top: 20px;
    margin-right: 10px;
    justify-content: flex-end;">
            <a href="${root}">
                <button class="btn-continuel">Tiếp Tục Mua Hàng</button>
            </a>
        </div>
    </div>
</div>
<script>

    document.querySelectorAll('[data-type="money"]').forEach(item => {

        item.innerHTML = new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'vnd'}).format(item.innerHTML);
    })
</script>
</body>
</html>