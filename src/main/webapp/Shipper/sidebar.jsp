<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${root}asset/css/logout.css">
<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="http://localhost:8080/Apple_store/shipper" class="brand-link">
        <img src="${root}asset/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
             style="opacity: .8">
        <span class="brand-text font-weight-light">Apple Store</span>
    </a>
    <div class="sidebar">
        <nav class="mt-2">
            <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">

                <!-- Đơn hàng -->
                <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="nav-icon fas fa-table"></i>
                        <p>
                            Đơn hàng
                            <i class="fas fa-angle-left right"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <a href="/Apple_store/ShiperNewOrder?tt=2" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Đơn hàng mới</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="/Apple_store/ShiperNewOrder?tt=3" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Đơn hàng đang giao</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="/Apple_store/ShiperNewOrder?tt=4" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Đơn hàng đã giao</p>
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </nav>
    </div>

</aside>