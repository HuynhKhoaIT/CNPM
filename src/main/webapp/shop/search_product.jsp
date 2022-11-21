<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="root" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Apple-Store</title>
    <link rel="stylesheet" href="${root}asset/style.css">
    <link rel="stylesheet" href="${root}asset/font/themify-icons/themify-icons.css">
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css"
    />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div id="main">
    <c:set var="items" value="${listlsp}" scope="request"/>
    <jsp:include page="./header2.jsp" />

    <div id="category">
        <div class="container">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="../../index.jsp">Trang chủ</a>
                </li>
                <li class="breadcrumb-item">${txtS }</li>
            </ol>
            <div class="title-h2">
            	<h2>Bạn đang tìm từ khóa: ${txtS }</h2>
            </div>
             <div class="actions">
                 <div class="sort">
                     <div class="content-sort">
                         <div class="text">Sắp xếp theo:</div>
                         <div class="dropdown">
                             <button class="btn btn-outline" type="button" data-toggle="dropdown">Bán chạy nhất
                                 <span class="caret"></span></button>
                             <ul class="dropdown-menu">
                                 <li><a href="#">Bán chạy nhất</a></li>
                                 <li><a href="#">Giá thấp đến cao</a></li>
                                 <li><a href="#">Giá cao đến thấp</a></li>
                             </ul>
                         </div>
                     </div>
                 </div>
             </div>
            <div class="products">
                <div class="products-body">
                    <div class="tab-pane">
                        <div class="product-list">
                            <c:forEach items="${listSearch}" var="o" >
                                <div class="product">
                                    <div class="product-img">
                                        <a href="" class="img-a">
                                            <img src="${o.anh }" alt="">
                                        </a>
                                    </div>
                                    <div class="product-info">
                                        <div class="product-color">
                                            <span style="background-color:#51504E"></span>
                                            <span style="background-color:#F1F3F2"></span>
                                            <span style="background-color:#F4E8CE"></span>
                                            <span style="background-color:#675E6F"></span>
                                        </div>
                                        <h3 class="product-name">
                                            <div class="text">${o.tenSP}</div>
                                        </h3>
                                        <div class="product-memory js-select">
                                            <div class="product-memory-item item btnchangegroup btnchangegroup-267 active" data-group="267" data-product="42725" data-cate="iphone">
                                                <strong>128GB</strong>
                                             </div>
                                            <div class="product-memory-item item btnchangegroup btnchangegroup-267 " data-group="267" data-product="42726" data-cate="iphone">
                                                <strong>256GB</strong>
                                            </div>
                                            <div class="product-memory-item item btnchangegroup btnchangegroup-267 " data-group="267" data-product="42727" data-cate="iphone">
                                                <strong>512GB</strong>
                                            </div>
                                            <div class="product-memory-item item btnchangegroup btnchangegroup-267 " data-group="267" data-product="42728" data-cate="iphone">
                                                <strong>1TB</strong>
                                            </div>
                                        </div>
                                        <div class="product-price">
                                            <div class="text">Giá chỉ: </div>
                                            <div class="price">${o.giaBanThuong}đ</div>
                                        </div>
                                    </div>
                                    <div class="product-detai">
                                       <a href="ProductDetailControl?maSP=${o.maSP}">
                                        <button  class="btn btn-outline-grayscale" type="button">XEM CHI TIÊT</button>
                                    </a>
                                    </div>
									
                                </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>

    <%@include file="./footer2.jsp"%>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>

<!-- Initialize Swiper -->
<script>
    var swiper = new Swiper(".mySwiper", {
        slidesPerView: 6,
        spaceBetween: 0,
        slidesPerGroup: 3,
        loop: false,
        loopFillGroupWithBlank: true,
        pagination: {
            el: ".swiper-pagination",
            clickable: true,
        },
        navigation: {
            nextEl: ".swiper-button-next",
            prevEl: ".swiper-button-prev",
        },
    });
</script>
</body>
</html>