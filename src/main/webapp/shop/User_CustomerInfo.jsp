<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/" var="root" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<link rel="stylesheet" href="${root}./asset/payment.css" />
</head>
<body>
	<div class="main">
		<c:set var="items" value="${listlsp}" scope="request" />
		<jsp:include page="./header2.jsp" />
		<form action="Customer" method="post">
			<div id="payment-container">
				<div id="payment-main">

					<div class="payment-info">

						<p class="header ">THÔNG TIN CÁ NHÂN</p>
						<div class="clear"></div>

						<input type="hidden" class="input" value="${kh.getMaTK()}"
							name="MaTK">

						<div class="sub-info2">
							<div class="sub-name">
								<p class="label left">HỌ TÊN</p>
								<input type="text" class="input" value="${kh.getTenKH()}"
									name="name">
							</div>
							<div class="sub-name">
								<p class="label left">GIỚI TÍNH</p>
								<input type="text" class="input" value="${kh.getGioiTinh()}"
									name="sex">
							</div>
						</div>

						<div class="sub-info2">
							<div class="sub-name">
								<p class="label left">NĂM SINH</p>
								<input type="text" class="input" value="${kh.getNamSinh()}"
									name="date">
							</div>
							<div class="sub-name">
								<p class="label left">ĐỊA CHỈ</p>
								<input type="text" class="input" value="${kh.getDiaChi()}"
									name="address">
							</div>
						</div>




						<div class="sub-info">
							<p class="label left">SỐ ĐIỆN THOẠI</p>
							<input type="text" class="input" value="${kh.getSoDT()}"
								name="phoneNumber">

						</div>
						<button type="submit" class="sub-info button">Change</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>