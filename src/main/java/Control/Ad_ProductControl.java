package Control;

import DAO.DanhMucDAO;
import DAO.SanPhamDAO;
import Model.DanhMuc;
import Model.SanPham;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Ad_ProductControl", value = "/admin/Ad_ProductControl")
public class Ad_ProductControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        List<SanPham> listSanPham = sanPhamDAO.getAll();

        DanhMucDAO danhMucDAO = new DanhMucDAO();
        List<DanhMuc> listDanhMuc = danhMucDAO.getAllDanhMuc();

        request.setAttribute("listDanhMuc",listDanhMuc);
        request.setAttribute("listSanPham",listSanPham);
        request.getRequestDispatcher("/admin/product.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

    }
}