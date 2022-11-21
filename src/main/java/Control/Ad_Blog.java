package Control;

import DAO.BaiVietDAO;
import Model.BaiViet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Ad_Blog", value = "/admin/Ad_Blog")
public class Ad_Blog extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        BaiVietDAO baiVietDAO = new BaiVietDAO();
        List<BaiViet> listBaiViet = baiVietDAO.getAllBaiViet();
        request.setAttribute("listBaiViet",listBaiViet);
        request.getRequestDispatcher("/admin/blog.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}