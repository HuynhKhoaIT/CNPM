<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value="/" var="root" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Apple-Store</title>
    <link rel="stylesheet" href="./asset/style.css" />
    <link rel="stylesheet" href="./asset/font/themify-icons/themify-icons.css" />
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" />
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
    <body>
        <div id="main">
            <c:set var="items" value="${listlsp}" scope="request"/>
            <jsp:include page="./header2.jsp" />

            <div id="slider">
                <a href="" class="slider-img">
                    <img src="${root}asset/img/br.webp" alt="" />
                </a>
            </div>

            <div id="content">
                <section id="content-cate">
                    <div class="container">
                        <div class="container-item">
                            <div class="cate-item">
                                <a href="loaisp?maloai=1">
                                    <div class="item-title">iPhone</div>
                                    <div class="item-img">
                                        <img src="${root}asset/img/iphone.webp" alt="" />
                                    </div>
                                    <div class="item-bot">
                                        <span>Khám phá thêm</span>
                                        <i class="ti-angle-right"></i>
                                    </div>
                                </a>
                            </div>
                            <div class="cate-item">
                                <a href="loaisp?maloai=2">
                                    <div class="item-title">iPad</div>
                                    <div class="item-img">
                                        <img src="${root}asset/img/ipad.webp" alt="" />
                                    </div>
                                    <div class="item-bot">
                                        <span>Khám phá thêm</span>
                                        <i class="ti-angle-right"></i>
                                    </div>
                                </a>
                            </div>
                            <div class="cate-item">
                                <a href="loaisp?maloai=4">
                                    <div class="item-title">Mac</div>
                                    <div class="item-img">
                                        <img src="${root}asset/img/mac.webp" alt="" />
                                    </div>
                                    <div class="item-bot">
                                        <span>Khám phá thêm</span>
                                        <i class="ti-angle-right"></i>
                                    </div>
                                </a>
                            </div>
                            <div class="cate-item">
                                <a href="loaisp?maloai=3">
                                    <div class="item-title">Apple Watch</div>
                                    <div class="item-img">
                                        <img src="${root}asset/img/Apple-watch.webp" alt="" />
                                    </div>
                                    <div class="item-bot">
                                        <span>Khám phá thêm</span>
                                        <i class="ti-angle-right"></i>
                                    </div>
                                </a>
                            </div>
                            <div class="cate-item">
                                <a href="loaisp?maloai=5">
                                    <div class="item-title">Phụ Kiện</div>
                                    <div class="item-img">
                                        <img src="${root}asset/img/airtag.webp" alt="" />
                                    </div>
                                    <div class="item-bot">
                                        <span>Khám phá thêm</span>
                                        <i class="ti-angle-right"></i>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </div>
                </section>

                <section id="content-pro">
                    <div class="container pd-bot-48">
                        <div class="container-pro">
                            <div class="pro-title">
                                <h2>Sản phẩm mới</h2>
                            </div>
                            <div class="pro-container">
                                <ul class="pro-list p-0">
                                <c:forEach items="${listNew}" var="o" >
                                    <li>
                                        <a href="ProductDetailControl?maSP=${o.maSP}" class="pro-item">
                                            <div class="item-top">
                                                <div class="pro-img">
                                                    <img src="${o.anh }" alt="" />
                                                </div>
                                                <div class="pro-name">
                                                    <h3>${o.tenSP}</h3>
                                                </div>
                                            </div>
                                            <div class="product-price">
		                                        <div class="text">Giá chỉ: </div>
		                                        <div class="price">${o.giaBanThuong}đ</div>
		                                    </div>
                                            <div class="pro-add">
                                                <span>Xem chi tiết</span>
                                            </div>
                                        </a>
                                    </li>
								</c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                </section>

                <section id="content-blog">
                    <div class="container">
                        <div class="row">
                            <c:forEach var="l" items="${listBaiViet}">
                                <div class="col-md-6 col-sm-12 padding-0-12">
                                    <div class="card">
                                        <div class="card-img">
                                            <img src="${l.anh}" alt="" />
                                            <a href="BlogDetailControl?maBV=${l.maBV}" class="card-btn">
                                                Tin tức
                                            </a>
                                        </div>
                                        <div class="card-content">
                                            <a href="BlogDetailControl?maBV=${l.maBV}">
                                                <div class="card-title line-clamp-2">
                                                    ${l.tieuDeBV}
                                                </div>
                                                <div class="card-info">
                                                    <span>Xem ngay</span>
                                                    <i class="ti-angle-right"></i>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </section>
            </div>

            <%@include file="./footer2.jsp"%>

        <script>
            const element = document.getElementById("js-menu-ticket");
            const sideMenu = document.querySelector(".model");
            const menuClose = document.querySelector(".js-close-menu");

            element.addEventListener("click", showMenuTicket);

            function showMenuTicket() {
                sideMenu.classList.add("open");
            }

            menuClose.addEventListener("click", closeMenuTicket);
            function closeMenuTicket() {
                sideMenu.classList.remove("open");
            }
        </script>
    </body>
</html>
