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
    <div id="detail">
        <div class="detail-heading">
            <div class="detail-breadcrumb">
                <div class="container">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="../../index.jsp">Trang chủ</a>
                        </li>
                        <li class="breadcrumb-item">
                            <a href="loaisp?maloai=${ml}">${tl}</a>
                        </li>
                        <li class="breadcrumb-item">${tensp}</li>
                    </ol>
                </div>
            </div>
            <div class="detail-gallery">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 col-sm-6 col-12 padding-0-12">
                            <div class="slider-gallery">
                                <div
                                        style="--swiper-navigation-color: #fff; --swiper-pagination-color: #fff"
                                        class="swiper mySwiper2">
                                    <c:set var="p" value="${SanPham}"/>
                                    <div class="swiper-wrapper">
                                        <c:forEach var="a" items="${listAnhSP}">
                                            <div class="swiper-slide">
                                                <img src="${a.anh}" />
                                            </div>
                                        </c:forEach>
                                        <%--                                      o day ne kiem dau the--%>
                                    </div>
                                    <div class="swiper-button-next"></div>
                                    <div class="swiper-button-prev"></div>
                                    <div class="swiper-pagination"></div>
                                </div>
                                <div thumbsSlider="" class="swiper mySwiper">
                                    <div class="swiper-wrapper">
                                        <c:forEach var="a" items="${listAnhSP}">
                                            <div class="swiper-slide">
                                                <img src="${a.anh}" />
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-sm-6 col-12 padding-0-12">
                            <div class="wrapper">
                                <h1 class="h1 name">${p.tenSP}</h1>
                                <div class="price">
                                    <div class="text text-primary txtprice" data-type="money">${p.giaKhuyenMai}</div>
                                    <!-- <div class="sub">
                                    <div class="text">Trả góp chỉ từ</div>
                                    <div class="text"> <strong>2.030.000đ</strong>/tháng</div>
                                    </div> -->
                                </div>
                                <!-- <div class="types choose-group-dt">
                                    <a class="item active" href="/iphone/iphone-13?dung-luong=128gb">
                                        <div class="radio" style="pointer-events:none">
                                            <input type="radio" value="0" name="group-0">
                                            <label>128GB</label>
                                        </div>
                                        <p>18.990.000</p>
                                    </a>
                                    <a class="item " href="/iphone/iphone-13?dung-luong=256gb">
                                        <div class="radio" style="pointer-events:none">
                                            <input type="radio" value="0" name="group-0">
                                            <label>256GB</label>
                                        </div>
                                        <p>21.490.000</p>
                                    </a>
                                    <a class="item " href="/iphone/iphone-13?dung-luong=512gb">
                                        <div class="radio" style="pointer-events:none">
                                            <input type="radio" value="0" name="group-0">
                                            <label>512GB</label>
                                        </div>
                                        <p>26.490.000</p>
                                    </a>
                                </div> -->
                                <input hidden="" type="text" name="idproduct" id="id-product" value="36690">
                                <input hidden="" type="text" name="product-variant" id="product-variant" value="641711">
                                <input hidden="" type="text" name="product-sku" id="product-sku" value="00773146">
                                <input hidden="" type="text" name="product-url" id="product-url" value="iphone-13-128gb">
                                <input hidden="" type="text" name="nameproduct" id="name-product" value="iPhone 13 128GB">
                                <!--  <div class="">
                                     <div class="item active" data-price="18990000.0000" data-pricemarket="24990000.0000" data-stock="1639" data-id="641711" data-urlbuy="/gio-hang-v2/them-vao-don-hang?product=36690_1_641711" data-urltragop="https://fptshop.com.vn/dien-thoai/iphone-13-128gb/641711/tra-gop" data-sku="00773146" data-varian="641711" data-productid="36690" ,="" data-productname="iPhone 13 128GB" data-catenameascii="iphone" data-isbusiness="False" data-isnerverbusiness="False" data-iscommingsoon="False" data-ispreorder="False" data-isinstallment="True" data-stockquantity="1639" data-priceonline="18990000.0000" data-producturl="iphone-13-128gb">
                                         <span style="background-color:#FADDD7"></span>
                                         <div>Hồng</div>
                                     </div>
                                     <div class="item " data-price="18990000.0000" data-pricemarket="24990000.0000" data-stock="1583" data-id="663983" data-urlbuy="/gio-hang-v2/them-vao-don-hang?product=36690_1_663983" data-urltragop="https://fptshop.com.vn/dien-thoai/iphone-13-128gb/663983/tra-gop" data-sku="00800302" data-varian="663983" data-productid="36690" ,="" data-productname="iPhone 13 128GB" data-catenameascii="iphone" data-isbusiness="False" data-isnerverbusiness="False" data-iscommingsoon="False" data-ispreorder="False" data-isinstallment="True" data-stockquantity="1583" data-priceonline="18990000.0000" data-producturl="iphone-13-128gb">
                                         <span style="background-color:#394C38"></span>
                                         <div>Xanh lá</div>
                                     </div>
                                     <div class="item" data-price="18990000.0000" data-pricemarket="24990000.0000" data-stock="774" data-id="641706" data-urlbuy="/gio-hang-v2/them-vao-don-hang?product=36690_1_641706" data-urltragop="https://fptshop.com.vn/dien-thoai/iphone-13-128gb/641706/tra-gop" data-sku="00773149" data-varian="641706" data-productid="36690" ,="" data-productname="iPhone 13 128GB" data-catenameascii="iphone" data-isbusiness="False" data-isnerverbusiness="False" data-iscommingsoon="False" data-ispreorder="False" data-isinstallment="True" data-stockquantity="774" data-priceonline="18990000.0000" data-producturl="iphone-13-128gb">
                                         <span style="background-color:#276787"></span>
                                         <div>Xanh</div>
                                     </div>
                                     <div class="item" data-price="18990000.0000" data-pricemarket="24990000.0000" data-stock="548" data-id="629153" data-urlbuy="/gio-hang-v2/them-vao-don-hang?product=36690_1_629153" data-urltragop="https://fptshop.com.vn/dien-thoai/iphone-13-128gb/629153/tra-gop" data-sku="00773147" data-varian="629153" data-productid="36690" ,="" data-productname="iPhone 13 128GB" data-catenameascii="iphone" data-isbusiness="False" data-isnerverbusiness="False" data-iscommingsoon="False" data-ispreorder="False" data-isinstallment="True" data-stockquantity="548" data-priceonline="18990000.0000" data-producturl="iphone-13-128gb">
                                         <span style="background-color:#232A31"></span>
                                         <div>Đen</div>
                                     </div>
                                     <div class="item" data-price="18990000.0000" data-pricemarket="24990000.0000" data-stock="286" data-id="641705" data-urlbuy="/gio-hang-v2/them-vao-don-hang?product=36690_1_641705" data-urltragop="https://fptshop.com.vn/dien-thoai/iphone-13-128gb/641705/tra-gop" data-sku="00773148" data-varian="641705" data-productid="36690" ,="" data-productname="iPhone 13 128GB" data-catenameascii="iphone" data-isbusiness="False" data-isnerverbusiness="False" data-iscommingsoon="False" data-ispreorder="False" data-isinstallment="True" data-stockquantity="286" data-priceonline="18990000.0000" data-producturl="iphone-13-128gb">
                                         <span style="background-color:#f0142d"></span>
                                         <div>Đỏ</div>
                                     </div>
                                     <div class="item" data-price="18990000.0000" data-pricemarket="24990000.0000" data-stock="225" data-id="641704" data-urlbuy="/gio-hang-v2/them-vao-don-hang?product=36690_1_641704" data-urltragop="https://fptshop.com.vn/dien-thoai/iphone-13-128gb/641704/tra-gop" data-sku="00773150" data-varian="641704" data-productid="36690" ,="" data-productname="iPhone 13 128GB" data-catenameascii="iphone" data-isbusiness="False" data-isnerverbusiness="False" data-iscommingsoon="False" data-ispreorder="False" data-isinstallment="True" data-stockquantity="225" data-priceonline="18990000.0000" data-producturl="iphone-13-128gb">
                                         <span style="background-color:#FAF6F2"></span>
                                         <div>Trắng</div>
                                     </div>
                                 </div> -->

                                <div class="thong-so">
                                    <div class="container">
                                        <div class="row">
                                            <h3>Thông số kỹ thuật</h3>
                                            <div class="detail-tskt">
                                                ${p.moTaNgan }
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="renderboxbtn">
                                    <div class="action" style="display:flex">
                                        <form action="buy" method="post" class="btn btn-link btn-xl btn-buy col-12">
                                            <input type="hidden" name = "id" value="${p.maSP}"/>
                                            <input type="hidden" name = "num" value="1"/>
                                            <input type="hidden" name = "check" value="0"/>
                                            <input type="submit" class="detailbtn" value="Thêm vào giỏ hàng" >
                                        </form>
                                        <form action="buy" method="post" class="btn btn-link btn-xl btn-buy col-12">
                                            <input type="hidden" name = "id" value="${p.maSP}"/>
                                            <input type="hidden" name = "num" value="1"/>
                                            <input type="hidden" name = "check" value="1"/>
                                            <input class="detailbtn" type="submit" value="Mua ngay" >
                                        </form>
                                    </div>
                                </div>
                                <div class="f-s-ui-14 text-center">
                                    Gọi <a class="medium text-primary" href="tel:18006601">
                                    1800 6601
                                </a> để được tư vấn mua hàng (Miễn phí)
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="detail-content">
            <div class="other-products">
                <div class="container">
                    <div class="row">
                        <div class="card-body">
                            <div class="row no-gutter title">
                                <span>Sản phẩm khác</span>
                            </div>
                            <div class="row no-gutter pro-list">
                                <c:forEach items="${listsplq}" var="o" >
                                    <div class="col-md-3 col-6">
                                        <a href="ProductDetailControl?maSP=${o.maSP}" class="product-item">
                                            <div class="product-img">
                                                <img src="${o.anh}" alt="">
                                            </div>
                                            <div class="product-info">
                                                <div class="product-name">${o.tenSP}</div>
                                                <div class="product-price">${o.giaBanThuong}đ</div>
                                            </div>
                                        </a>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%-- <div class="detail-properties">
                <div class="container">
                    <div class="properties-detail">
                        <div class="row no-gutter">
                            <div class="col-12">
                                <div class="row no-gutter properties-title">
                                    <div class="text">
                                        <span>Thông số kỹ thuật</span>
                                    </div>
                                </div>
                                <div class="row no-gutter properties-content">
                                    <div class="properties">
                                        <table class="table-box">
                                        <c:forEach items="${listtskt}" var="o" >
                                            <tr>
                                                <td class="td-name">${o.maTSKT }</td>
                                                <td class="td-content">${o.mota}</td>
                                            </tr>
                                           </c:forEach>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div> --%>
            <div class="detail-post">
                <div class="container">
                    <div class="post-text">
                        <div class="row no-gutter">
                            <div class="col-9">
                                <div class="content">
                                    ${p.moTa}
                                </div>
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
        loop: false,
        spaceBetween: 10,
        slidesPerView: 3,
        freeMode: true,
        watchSlidesProgress: true,
    });
    var swiper2 = new Swiper(".mySwiper2", {
        loop: true,
        spaceBetween: 10,
        navigation: {
            nextEl: ".swiper-button-next",
            prevEl: ".swiper-button-prev",
        },
        thumbs: {
            swiper: swiper,
        },
        pagination: {
            el: ".swiper-pagination",
            clickable: true,
        },
    });
</script>
</body>
</html>