package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BaiVietDAO;
import DAO.LoaispDAO;
import DAO.SanPhamDAO;
import Model.BaiViet;
import Model.DanhMuc;
import Model.LoaiSP;
import Model.SanPham;

@WebServlet(urlPatterns = {"/blog"})
public class BlogControl extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        BaiVietDAO baivietdao = new BaiVietDAO();
        List<BaiViet> listblog = baivietdao.getAllBaiVietTop4();
        BaiViet baiViet = baivietdao.getBaiViet();
        LoaispDAO loaispDAO = new LoaispDAO();
        List<LoaiSP> listlsp = loaispDAO.getAllloaisp();

        request.setAttribute("listlsp", listlsp);

        request.setAttribute("listblog", listblog);
        request.setAttribute("baiViet", baiViet);
        request.getRequestDispatcher("/shop/blog.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

}