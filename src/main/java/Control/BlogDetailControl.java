package Control;

import DAO.BaiVietDAO;
import DAO.LoaispDAO;
import Model.BaiViet;
import Model.LoaiSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BlogDetailControl", value = "/BlogDetailControl")
public class BlogDetailControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String maBV = request.getParameter("maBV");

        BaiVietDAO baiVietDAO = new BaiVietDAO();
        BaiViet baiViet = baiVietDAO.getBaiVietByID(maBV);
        

        LoaispDAO loaispDAO = new LoaispDAO();
        List<LoaiSP> listlsp = loaispDAO.getAllloaisp();

        request.setAttribute("listlsp",listlsp);

        request.setAttribute("baiViet",baiViet);
        request.getRequestDispatcher("/shop/detail_blog.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}