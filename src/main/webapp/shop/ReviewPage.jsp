
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/" var="root" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${root}asset/payment.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="execute_payment" name="form" method="post" onsubmit="return validateForm()">
		<div id="payment-container">
			<div id="payment-main">

				<input type="hidden" name="paymentId" value="${param.paymentId}" />
				<input type="hidden" name="PayerID" value="${param.PayerID}" />
				<%-- 
				<input type="text" name="name_raw" value="${name_raw}" />
				<input type="text" name="phone_raw" value="${phone_raw}" />
				<input type="text" name="address_raw" value="${address_raw}" /> --%>


				<div class="payment-info">

					<p class="header">THÔNG TIN HÓA ĐƠN</p>
					<div class="clear"></div>

					<!--Thẻ tên người mua-->
					<div class="sub-info2">
						<div class="sub-name">
							<p class="label left">FIRST NAME</p>
							<input type="text" class="input" name="name" value="${payer.firstName}">
						</div>
						<div class="sub-name">
							<p class="label left">LAST NAME</p>
							<input type="text" class="input" value="${payer.lastName}">
						</div>
					</div>
					
					
					<!--Thẻ tên người mua-->

					<!--Thẻ tên Doanh nghiệp (OFFICE)-->

					<!--Thẻ tên Doanh nghiệp (OFFICE)-->

					<!--Thẻ tên Địa chỉ 1 (Address1)-->
					<div class="sub-info">
						<p class="label left">ADDRESS</p>
						<input type="text" class="input"  name="address" value="${shippingAddress.line1}">

					</div>
					<!--Thẻ tên Địa chỉ 1 (Address1)-->


					<!--Thẻ tên email-->
					<div class="sub-info2">
						<div class="sub-name">
							<p class="label left">EMAIL</p>
							<input type="text" class="input" name="email" value="${payer.getEmail()}">
						</div>
						<div class="sub-name">
							<p class="label left">PHONE</p>
							<input type="text" class="input" name="phone" value="${payer.phone}">
						</div>
					</div>


					<br> <br> <br>

					<!-- Thẻ address -->
					<!-- 	<div class="sub-info">
						<label class="left address"> GIAO HÀNG TỚI ĐỊA CHỈ KHÁC</label> <input
							type="checkbox" class=" input-check-Right" name="" value="">
						<div class="clear"></div>
					</div>
					Thẻ address

					Thẻ comment
					<div class="sub-info">
						<textarea class="input info" placeholder="Ghi chú về ship hàng"></textarea>
					</div>
					Thẻ comment
 -->
					<!--Clear float -->
					<div class="clear"></div>
					<!--Clear float -->

				</div>

				<div class="payment-info">
				<c:set var="o" value="${requestScope.cart}" />
					<p class="header">THÔNG TIN ĐƠN HÀNG</p>
					<div class="clear"></div>

					<table class="table">

						<thead class="block">
							<tr class="cart_item">
								<th class="product-total head"><p>Tên</p></th>
								<th class="product-total  head"><p>Giá</p></th>
								<th class="product-total  head"><p>Số lượng</p></th>
							</tr>
						</thead>

						<tbody class="block">
							
							<c:forEach items="${o.items}" var="i">
								<tr class="cart_item">
									<td class="product-total head1">${i.product.tenSP}</td>
									<td class="product-total head1">${i.product.giaBanThuong}</td>
									<td class="product-total head1">${i.quantity}</td>
								</tr>
							</c:forEach>

						</tbody>

						<tfoot>

							<tr class="cart_item">
								<td class="product-name head"><p class="left">Tạm tính:</p></td>
								<td class="product-total head"><p class="left">${o.getFirstMoney()}</p></td>
							</tr>

							<tr class="cart_item">
								<td class="product-name head"><p class="left">Khuyến mãi:</p></td>
								<td class="product-total head"><p class="left">${o.getTotalMoney() - o.getFirstMoney()}
										 VND</p></td>
							</tr>

							<tr class="cart_item">
								<td class="product-name head"><p class="left">Tổng</p></td>
								<td class="product-total head"><p class="left">${o.getTotalMoney()}</p></td>
							</tr>

						</tfoot>
					</table>

					<button type="submit" class="sub-info button">THANH TOÁN</button>

				</div>

			</div>
		</div>
	</form>

</body>
<script>
function validateForm() {
	  var x = document.forms["form"]["phone"].value;
	  if (x == "") {
	    alert("PhoneNumber    must be filled out");
	    return false;
	  }
	}
</script>
</html>