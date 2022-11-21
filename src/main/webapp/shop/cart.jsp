<%-- Created by IntelliJ IDEA. User: lelon Date: 21/10/2022 Time: 00:53 To change this template use File | Settings | File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/" var="root" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Apple-Store</title>
<link rel="stylesheet" href="${root}asset/style.css">
<link rel="stylesheet"
	href="${root}asset/font/themify-icons/themify-icons.css">
<link rel="stylesheet" href="${root}asset/css/cart.css?version=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="main">
		<c:set var="items" value="${listlsp}" scope="request" />
		<jsp:include page="./header2.jsp" />
		<div class="content">
			<div class="subcontainer" id="cart-not-empty">
				<div class="subheading">
					<h3 class="inline-block">
						GIỎ HÀNG CỦA BẠN
						<!-- <span>(1 sản phẩm)</span>-->
					</h3>
					<a href="http://localhost:8080/Apple_store"
						class="float-right home-link">Mua thêm sản phẩm khác</a>
				</div>
				<div class="container">
					<div class="list-items">
						<c:set var="o" value="${requestScope.cart}" />
						<c:set var="tt" value="0" />
						<c:forEach items="${o.items}" var="i">
							<c:set var="tt" value="${tt+1}" />
							<div class="items col-md-12 col-sm-12 col-12">
								<div class="pic col-md-2 com-sm-3 col-2">
									<img id="items-pic" src="${i.product.anh}" alt="Sản phẩm" />
								</div>
								<div class="col-md-9 com-sm-8 col-9">
									<div class="items-type">
										<h3 class="items-name">${i.product.tenSP}</h3>
										<%--                                        <div class="colors">--%>
										<%--                                            <span>Màu</span>--%>
										<%--                                            <ul class="ordercolorful"></ul>--%>
										<%--                                        </div>--%>
									</div>
									<div class="items-price">
										<p class="end-price">
											<span>${i.product.giaKhuyenMai}</span> <sup>đ</sup>
										</p>
										<p class="price">
											<span>${i.product.giaBanThuong}</span> <sup>đ</sup>
										</p>
										<p class="discount inline-block">Giảm
											${i.product.giaKhuyenMai - i.product.giaBanThuong}</p>
									</div>
									<div class="items-amount">
										<div class="wrapper">
											<span>
												<form action="process" method="POST">
													<input type="hidden" name="id" value="${i.product.maSP}" />
													<input type="hidden" name="num" value="-1" /> <a href="#"
														onclick="this.parentNode.submit()"class="p-2">-</a>
												</form>
											</span> <span class="inline-block">${i.quantity}</span> <span>
												<form action="process" method="POST">
													<input type="hidden" name="id" value="${i.product.maSP}" />
													<input type="hidden" name="num" value="1" /> <a href="#"
														onclick="this.parentNode.submit()" class="p-2">+</a>
												</form>
											</span>
											<%--                           <span><a href="process?num=-1&id=${i.product.maSP}">-</a></span>--%>
											<%--                           <span class="inline-block">${i.quantity}</span>--%>
											<%--                           <span><a href="process?num=1&id=${i.product.maSP}">+</a></span>--%>
										</div>
									</div>
								</div>
								<div class="remove_item col-md-1 com-sm-1 col-1">
									<form action="process" method="POST">
										<input type="hidden" name="id" value="${i.product.maSP}" /> <input
											type="hidden" name="num" value="0" /> <a href="#"
											onclick="this.parentNode.submit()"> <i
											class="close-icon ti-close"> </i></a>
									</form>
									<div class="clear"></div>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="bill-total">
						<!-- <div class="voucher inline-block">
                  <p class="">Sử dụng mã giảm giá:</p>
                  <div class="voucher-code">
                      <input type="text" placeholder="Nhập mã giảm giá" class="input voucher-input">
                      <button id="check-voucher">Áp dụng</button>
                  </div>
                 </div> -->
						<div class="price float-right">
							<ul class="bill-detal">
								<li class="temp-price"><label>Tạm tính:</label>
									<p>
										<span>${o.getFirstMoney()}</span><sup>đ</sup>
									</p></li>
								<li class="promo-price"><label>Khuyến mãi:</label>
									<p>
										<span>${o.getTotalMoney() - o.getFirstMoney()}</span><sup>đ</sup>
									</p></li>
								<li class="last-price"><label>Tổng tiền:</label>
									<p>
										<span>${o.getTotalMoney()}</span><sup>đ</sup>
									</p></li>
							</ul>
						</div>
					</div>
					<form action="paypal" class="cus-form thong-tin" id="form-order"
						 method="post">
						<p class="sub-title">Thông tin khách hàng</p>
						<ul class="form">
							<li class="row">
								<p class="title-2 col-md-4">
									Họ và tên: <sup>*</sup>
								</p>
								<div class="col-md-8">
									<input class="input" type="text" placeholder="Nhập họ và tên"
										id="name" onblur="checkName()" name="name"
										value="${user.tenKH}" /> <small id="name_empty"></small>
								</div>
								<div class="clear"></div>
							</li>
							<li class="row">
								<p class="title-2 col-md-4">
									Số điện thoại: <sup>*</sup>
								</p>
								<div class="col-md-8 ">
									<input class="input" type="text" placeholder="Số điện thoại"
										id="phone" onblur="checkPhone()" name="phone"
										value="${user.phone}" /> <small id="phone_empty"></small>
								</div>
								<div class="clear"></div>
							</li>
							<li class="row" class="email">
								<p class="title-2 col-md-4">
									Email: <span class="inline-block">(không bắt buộc)</span>
								</p>
								<div class="col-md-8">
									<input class="input" type="email" placeholder="Email"
										class="email" id="email" onblur="checkEmail()" name="email"
										value="${user.email}" /> <small id="email_empty"></small>
								</div>
								<div class="clear"></div>
							</li>
							<li class="row" class="email">
								<p class="title-2 col-md-4">
									Địa chỉ: <sup>*</sup>
								</p>
								<div class="col-md-8">
									<input class="input" type="text"
										placeholder="Địa chỉ nhận hàng" class="address" id="address"
										onblur="checkAddress()" name="address" value="${user.diaChi}" />
									<small id="address_empty"></small>
								</div>
								<div class="clear"></div>
							</li>
							<li class="row">
								<div class="col-md-4"></div>
								<div class="btn-container col-md-8">
									<div>
										<button type="button" class="btn" id="next-step"
											onclick="formvalidate()">
											<strong>Đặt Hàng</strong> <span>(Thanh Toán Tiền Mặt)</span>
										</button>
									</div>

									<div id="or">
										<p>Hoặc</p>
									</div>


									<input type="hidden" name="total" value="${o.getFirstMoney()}" />

									<c:forEach items="${o.items}" var="i">

										<input type="hidden" name="nameSP" value="${i.product.tenSP}" />
										<input type="hidden" name="totalPrice"
											value="${i.product.giaBanThuong}" />
										<input type="hidden" name="quantity" value="${i.quantity}" />

									</c:forEach>
									<div>
										<button type="submit" class="btn" id="next-step"
											style="background-color: #ffffff;">

											<img src="${root}asset/img/paypal.webp" alt=""
												style="max-width: 100%; max-height: 100%; background-color: #ffffff;" />
										</button>

									</div>
									<!-- <div id="or">
                           <p>Hoặc</p>
                        </div> -->
									<!-- <div>
                           <button type="button" class="btn" id="order-fast" onclick="callServlet('POST')">
                              <strong>Đặt hàng luôn</strong>
                              <span>FPT Shop sẽ gọi cho quý khách</span>
                           </button>
                        </div> -->
								</div>
							</li>
						</ul>
					</form>
				</div>
			</div>
			<div class="subcontainer" id="cart-empty" style="display: none">
				<div class="container no-products">
					<div class="row">
						<div>
							<img
								src="https://cdn-icons-png.flaticon.com/512/4233/4233830.png"
								alt="" style="width: 100%;">
						</div>
					</div>
				</div>
				<div class="row title-content" style="text-align: center;">
					<div class="title-2 mg" style="margin: 10px 0;">
						<h2>Không có sản phẩm nào!</h2>
					</div>
					<a href="${root}">
						<button class="btn-cart" style="margin: 10px 0;">Tiếp
							Tục Mua Hàng</button>
					</a>
				</div>

			</div>
		</div>
		<script>
			var check = document.getElementsByClassName('items').length
			if (check == 0) {
				document.getElementById('cart-not-empty').style.display = "none";
				document.getElementById('cart-empty').style.display = "block"
			}
		</script>
	</div>
	</div>
	<script src="${root}asset/js/cart.js"></script>
</body>
</html>
