<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="root" />
<div id="header">
    <div id="header-top">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-md-3 col-sm-12">
                    <div class="row top-header">
                        <div class="col-1">
                            <a id="js-menu-ticket" class="menu ">
                                <div class="sec-icon menu">
                                    <i class="ti-menu"></i>
                                </div>
                            </a>
                        </div>
                        <div class="col-md-12 col-6">
                            <a href="http://localhost:8080/Apple_store" class="logo">
                                <img src="${root}asset/img/logoPNG.png" alt="logo" class="max-width">
                            </a>
                        </div>
                        <div class="col-1">
                            <a href="${root}cart.jsp" class="cart-1">
                                <div class="sec-icon cart">
                                    <i class="ti-shopping-cart"></i>
                                </div>
                            </a>
                        </div>
                        <div class="col-1">
                            <a href="${root}user.jsp" class="user-1">
                                <div class="sec-icon user">
                                    <i class="ti-user"></i>
                                </div>
                            </a>
                        </div>

                    </div>
                </div>

                <div class="header-search col-md-5 col-sm-12">
                    <form action="search" method="get">
                        <div class="form-search">
                            <i class="ti-search"></i>
                            <input name="txt" type="text" class="search-input" placeholder="Bạn đang tìm sản phẩm, tin tức, ...">
                        </div>
                    </form>
                </div>

                <div class="header-cart col-md-2">
                    <a href="${root}show" class="cart">
                        <div class="sec-icon align-items-center">
                            <i class="ti-shopping-cart"></i>
                            <div class="icon-text">Giỏ hàng</div>
                        </div>
                    </a>
                </div>

                <div class="header-user col-md-2">
                    <c:if test="${sessionScope.acc != null}">
                        <a href="/Apple_store/shop/UserPage" class="user">
                            <div class="sec-icon">
                                <i class="ti-user"></i>
                                <div class="icon-text">${sessionScope.acc.tenKH}</div>
                            </div>
                        </a>
                    </c:if>
                    <c:if test="${sessionScope.acc == null}">
                        <a href="/Apple_store/shop/login" class="user">
                            <div class="sec-icon">
                                <i class="ti-user"></i>
                                <div class="icon-text">Tài Khoản</div>
                            </div>
                        </a>
                    </c:if>
                </div>
            </div>
        </div>
    </div>

    <div id="header-bot">
        <div class="container">
            <div class="header-nav">
                <div class="header-item">
                    <ul>
                        <c:forEach items="${requestScope.items}" var="o">
                            <li><a href="http://localhost:8080/Apple_store/loaisp?maloai=${o.maLoai}" class="nav-sub">${o.tenLoai}</a></li>
                        </c:forEach>
                        <li><a href="${root}blog" class="nav-sub">Tin Tức</a></li>
                    </ul>
                    <div class="header-call">
                        <div class="call-btn">
                            <a href="tel:0869950090">
                                <i class="ti-mobile"></i>
                                <span>0869950090</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="model">
    <div class="side-menu show">
        <div class="mn-content">
            <div class="mn-top flex flex-between">
                <div class="mn-logo">
                    <a href="/"><img src="${root}asset/img/logo-fstu.webp" alt="logo-fstu" /> </a>
                </div>
                <span class="js-close-menu">
                   <i class="ti-close"> </i>
               </span>
            </div>
            <c:set var="danhmuc" value="${maDM}"/>
            <div class="mn-body">
                <ul>
                    <c:forEach items="${listlsp}" var="o" >
                        <li><a class="b-b-600" href="loaisp?maloai=${o.maLoai}" class="nav-sub">${o.tenLoai}</a></li>
                    </c:forEach>
                    <li class="b-b-600"><a href="${root}blog">Tin tức</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>

<script>
    const element = document.getElementById("js-menu-ticket");
    const sideMenu = document.querySelector('.model')
    const menuClose = document.querySelector('.js-close-menu')

    element.addEventListener("click", showMenuTicket);

    function showMenuTicket() {
        sideMenu.classList.add('open')
    }

    menuClose.addEventListener("click", closeMenuTicket);
    function closeMenuTicket() {
        sideMenu.classList.remove('open')
    }

</script>