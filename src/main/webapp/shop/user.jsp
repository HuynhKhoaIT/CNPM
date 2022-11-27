<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/" var="root"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${root}asset/css/cart.css"/>
    <link rel="stylesheet" href="${root}asset/style.css">
    <link rel="stylesheet"
          href="${root}asset/font/themify-icons/themify-icons.css"/>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
            rel="stylesheet">
    <link rel="stylesheet" href="${root}asset/dist/css/adminlte.min.css">
    <!-- Latest compiled JavaScript -->
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
    <title>Document</title>
</head>
<body>
<div class="main">
    <c:set var="items" value="${listlsp}" scope="request"/>
    <jsp:include page="./header2.jsp"/>

    <!-- /.row -->
    <div class="content">
        <div class="container">
            <div class="row" style="width: 100%;">
                <div class="subnav col-md-3 col-3">
                    <div class="avatar-user navcard">
                        <img style="width: 100%;"
                                src="${root}asset/dist/img/user1-128x128.jpg"
                                alt="User">
                    </div>
                    <form action="${root}logout" method="POST">
                        <ul style="padding-left: 0px;">
                            <li class="js-content-btn font-bold"><a>Thông tin cá
                                nhân</a></li>
                            <li class="js-password-btn"><a>Thay đổi mật khẩu</a></li>
                            <li class="js-orders-btn"><a>Đơn hàng</a></li>
                            <form action="logout" method="POST">
                                <li class="js-logout-btn">
                                    <button type="submit" class="logout-shop">
                                        Đăng xuất
                                    </button>
                                </li>
                            </form>

                        </ul>
                    </form>

                </div>
                <div class="tab-content js-content-tab col-md-9 col-9">


                    <form action="UserPage" class="cus-form" method="post">
                        <input class="input" type="hidden" name="MaKH"
                               value="${sessionScope.acc.getMaKH()}">

                        <ul class="form">


                            <li class="row"><label class="label">Họ và Tên</label>
                                <div class="float-right">
                                    <input class="input" type="text" name="TenKH"
                                           value="${sessionScope.acc.getTenKH()}">
                                </div>
                            </li>
                            <li class="row"><label class="label">Số điện thoại
                            </label>
                                <div class="float-right">
                                    <input class="input" type="text" name="phone"
                                           value="${sessionScope.acc.getPhone()}">
                                    <div class="note">Vui lòng nhập đúng</div>
                                </div>
                                <div class="clear"></div>
                            </li>
                            <li class="row" id="email"><label class="label">Email
                            </label>
                                <div class="float-right">
                                    <input class="input" type="email" name="email"
                                           value="${sessionScope.acc.getEmail()}">
                                </div>
                                <div class="clear"></div>
                            </li>
                            <li class="row"><label class="label">Địa chỉ</label>
                                <div class="float-right">
                                    <input class="input" type="text" name="DiaChi"
                                           value="${sessionScope.acc.getDiaChi()}">
                                </div>
                            </li>
                        </ul>
                        <div class="pro-btn-container">
                            <button type="submit" class="save">Lưu thông tin</button>
                            <button class="cancel">Hủy</button>
                        </div>
                    </form>

                </div>
                <div class="tab-password display-off js-password-tab col-md-9 col-9">
                    <form action="PasswordChange" class="cus-form" method="post">
                        <ul class="form">
                            <li class="row"><label class="label">Mật khẩu hiện
                                tại</label>
                                <div class="float-right">
                                    <input class="input password" type="password" name="oldPass">
                                </div>
                                <div class="clear"></div>
                            </li>
                            <li class="row"><label class="label ">Mật khẩu mới</label>
                                <div class="float-right">
                                    <input class="input  password" type="password" name="newPass1">
                                    <div class="note-text js-password-info">Long đây</div>
                                </div>
                                <div class="clear"></div>
                            </li>
                            <li class="row"><label class="label">Nhập lại mật
                                khẩu mới</label>
                                <div class="float-right">
                                    <input class="input password" type="password" name="newPass2">
                                    <div class="note">Vui lòng nhập đúng</div>
                                </div>
                                <div class="clear"></div>
                            </li>
                        </ul>

                        <!-- <div class="show-password">
                            <input type="checkbox" onclick="show_password()">
                            <p>Hiện mật khẩu</p>
                        </div> -->
                        <div class="pro-btn-container">
                            <button type="submit" class="save">Save changes</button>
                            <button class="cancel">Cancel</button>
                        </div>
                    </form>

                </div>
                <div class="tab-orders display-off js-orders-tab col-md-9 col-9">
                <div class="row title-order">
	                 <div class="items-info col-md-3 col-4 ">
	                      Mã đơn hàng
	                 </div>
                    <div class="items-type col-md-3 col-4">
                        Trạng thái
                    </div>
                    <div class="items-price col-md-3 col-4">
                        Tổng tiền
                    </div>
                    <div class="items-amount col-md-3">
                        Thời gian
                    </div>
            	</div>
            	 <div class="row detail-order">
	                 <c:forEach items="${allOrderDonHangs}" var="i">
                        <div class="items">
                            <div class="items-info row" >
	                            <div class="items-info col-md-3 col-4">
	                               <a href="${root}User_OrderDetail?id=${i.getMaDH()}">${i.getMaDH()}</a>
	                            </div>
                                <div class="items-type col-md-3 col-4">
                                    <c:choose>
                                        <c:when test="${i.getMaTrangThai()==1}">
                                            <h3 class="items-name">Chưa xác nhận</h3>
                                        </c:when>
                                        <c:when test="${i.getMaTrangThai()==2}">
                                            <h3 class="items-name">Đã xác nhận</h3>
                                        </c:when>
                                        <c:when test="${i.getMaTrangThai()==3}">
                                            <h3 class="items-name">Đang giao</h3>
                                        </c:when>
                                        <c:otherwise>
                                            <h3 class="items-name">Đã nhận</h3>
                                        </c:otherwise>
                                    </c:choose>
                                </div>

                                <div class="items-price col-md-3 col-4">
                                    <p class="end-price" data-type="money">${i.getTongTien()}</p>
                                </div>
                                <div class="items-amount col-md-3">
                                    <p>${i.getThoiGian()}</p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
            	</div>
                    
                    

                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="./footer2.jsp" %>
</div>
<script>
    const content_tab = document.querySelector('.js-content-tab')
    const password_tab = document.querySelector('.js-password-tab')
    const orders_tab = document.querySelector('.js-orders-tab')
    const btn_content = document.querySelector('.js-content-btn')
    const btn_password = document.querySelector('.js-password-btn')
    const btn_order = document.querySelector('.js-orders-btn')

    function show_content() {
        btn_content.classList.add('font-bold')
        btn_password.classList.remove('font-bold')
        btn_order.classList.remove('font-bold')
        content_tab.classList.remove('display-off')
        password_tab.classList.add('display-off')
        orders_tab.classList.add('display-off')
    }

    function show_password() {
        btn_password.classList.add('font-bold')
        btn_content.classList.remove('font-bold')
        btn_order.classList.remove('font-bold')
        password_tab.classList.remove('display-off')
        content_tab.classList.add('display-off')
        orders_tab.classList.add('display-off')
    }

    function show_orders() {
        btn_order.classList.add('font-bold')
        btn_password.classList.remove('font-bold')
        btn_content.classList.remove('font-bold')
        orders_tab.classList.remove('display-off')
        password_tab.classList.add('display-off')
        content_tab.classList.add('display-off')
    }

    btn_content.addEventListener('click', show_content)
    btn_password.addEventListener('click', show_password)
    btn_order.addEventListener('click', show_orders)
</script>
<script src="./assets/js/main.js"></script>
</body>
</html>
