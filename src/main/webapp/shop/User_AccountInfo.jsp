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
		<form action="Account" method="post">
			<div id="payment-container">
				<div id="payment-main">

					<div class="payment-info">

						<p class="header ">THÔNG TIN TÀI KHOẢN</p>
						<div class="clear"></div>

						<div class="sub-info2">
							<div class="sub-name">
								<p class="label left">MÃ TÀI KHOẢN</p>
								<input type="text" name="maTK" class="input"
									value="${kh.getMaTK()}">
							</div>
							<div class="sub-name">
								<p class="label left">TÊN TÀI KHOẢN</p>
								<input type="text" class="input" value="${kh.getTenDN()}">
							</div>
						</div>

						<div class="sub-info">
							<p class="label left">MẬT KHẨU</p>
							<input type="password" class="input" value="${kh.getMatKhau()}">

						</div>
						<div class="sub-info">
							<p class="label left">GMAIL</p>
							<input type="text" class="input" value="${kh.getGmail()}">

						</div>

					</div>


					<div class="payment-info">

						<p class="header ">Thay đổi mật khẩu</p>
						<div class="clear"></div>


						<div class="sub-info">
							<p class="label left">MẬT KHẨU CŨ</p>
							<input type="password" class="input" name="oldPass">

						</div>
						<div class="sub-info">
							<p class="label left">MẬT KHẨU MỚI</p>
							<input type="password" class="input" name="newPass">
						</div>

						<button type="submit" class="sub-info button">Change</button>
					</div>



				</div>
			</div>
		</form>
	</div>
</body>
</html>