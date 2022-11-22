<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="http://localhost:8080/Apple_store/admin" class="brand-link">
        <img src="${root}asset/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
        <span class="brand-text font-weight-light">Apple Store</span>
    </a>
    <div class="sidebar">
        <nav class="mt-2">
            <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                <!-- Sản phẩm -->
                <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="nav-icon fas fa-table"></i>
                        <p>
                            Sản phẩm
                            <i class="fas fa-angle-left right"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <a href="${root}admin/Ad_ProductControl" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Tất cả sản phẩm</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="${root}admin/Ad_AddProductControl" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Thêm sản phẩm</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="/Apple_store/admin/category" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Danh mục</p>
                            </a>
                        </li>
                    </ul>
                </li>
                <!-- khách hàng -->
                <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="nav-icon fas fa-table"></i>
                        <p>
                            Khách hàng
                            <i class="fas fa-angle-left right"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
	                    <li class="nav-item">
                            <a href="${root}admin/Ad_UserControl?u=2" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Tất cả khách hàng</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="${root}admin/Ad_UserControl?u=1" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Khách hàng thân thiết</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="${root}admin/Ad_UserControl?u=0" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Khách hàng vãng lai</p>
                            </a>
                        </li>
                    </ul>
                </li>
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
                            <a href="${root}admin/AllOrder" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Tất cả đơn hàng</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="${root}admin/newOrder" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Đơn hàng mới</p>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="nav-icon fas fa-table"></i>
                        <p>
                            Bài viết
                            <i class="fas fa-angle-left right"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <a href="${root}admin/Ad_Blog" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Tất cả bài viết</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="${root}admin/Ad_TaoBaiViet" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Tạo bài mới</p>
                            </a>
                        </li>
                        <!-- <li class="nav-item">
                            <a href="#" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Chuyên mục</p>
                            </a>
                        </li> -->
                    </ul>
                </li>
                
                <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="nav-icon fas fa-table"></i>
                        <p>
                            Doanh thu
                            <i class="fas fa-angle-left right"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <a href="${root}admin/doanhthu.jsp" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Tất cả doanh thu</p>
                            </a>
                        </li>
                        <%-- <li class="nav-item">
                            <a href="${root}admin/Ad_TaoBaiViet" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Tạo bài mới</p>
                            </a>
                        </li>
                        <!-- <li class="nav-item">
                            <a href="#" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Chuyên mục</p>
                            </a>
                        </li> --> --%>
                    </ul>
                </li>
            </ul>
        </nav>
    </div>

</aside>