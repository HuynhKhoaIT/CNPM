package Control;

import DAO.BaiVietDAO;
import DAO.BannerDAO;
import DAO.LoaispDAO;
import DAO.SanPhamDAO;
import Model.BaiViet;
import Model.Banner;
import Model.DanhMuc;
import Model.LoaiSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Ad_Banner", value = "/admin/Ad_Banner")
public class Ad_Banner extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        BaiVietDAO baiVDAO = new BaiVietDAO();
        BannerDAO bannerDAO = new BannerDAO();
        List<Banner> listBaner = bannerDAO.getAllBanner();
        request.setAttribute("listBaner", listBaner);
        request.getRequestDispatcher("/admin/banner.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
