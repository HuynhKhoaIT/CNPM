
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/" var="root" />
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
		<c:set var="items" value="${listlsp}" scope="request" />
		<jsp:include page="./header2.jsp" />

		<div class="card-body p-0">
			<div class="table-responsive">
				<table class="table m-0">
					<thead>
						<tr>
							<th>ID đặt hàng</th>
							<th>Khách hàng</th>
							<th>Trạng thái</th>
							<th>Ngày đặt</th>
							<th>Chi Tiết</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="i" begin="0" end="${size-1 }">
							<tr>
								<td><a href="admin/invoice.html">${list[i].getMaDH()}</a></td>
								<td>${listName[i]}</td>
								<c:choose>
									<c:when test="${list[i].getMaTrangThai()==1}">
										<td><span class="badge badge-success">Shipped</span></td>
									</c:when>
									<c:otherwise>
										<td><span class="badge badge-success">Shipping</span></td>
									</c:otherwise>
								</c:choose>
								<td>
									<div class="sparkbar" data-color="#00a65a" data-height="20">${list[i].getThoiGian()}</div>
								</td>
								<td><a href="User_OrderDetail?id=${list[i].getMaDH()}"
									class="btn btn-sm btn-secondary ">Chi tiết</a></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a href="<%=request.getContextPath()%>/UserPage"
					class="btn btn-sm btn-secondary ">Back</a>
			</div>
		</div>

	</div>
</body>
</html>