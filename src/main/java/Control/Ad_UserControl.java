package Control;

import DAO.KhachHangDAO;
import DAO.LoaispDAO;
import Model.LoaiSP;
import Model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Ad_UserControl", value = "/admin/Ad_UserControl")
public class Ad_UserControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        KhachHangDAO khachHangDAO = new KhachHangDAO();
        String u = request.getParameter("u");
        List<Users> listKH;
        if (u.equals("1")) {
            listKH = khachHangDAO.getAllKhachHangQuen();
        } else if (u.equals("2")) {
            listKH = khachHangDAO.getAllKhachHang();
        } else {
            listKH = khachHangDAO.getAllKhachHangLa();
        }


        LoaispDAO loaispDAO = new LoaispDAO();
        List<LoaiSP> listlsp = loaispDAO.getAllloaisp();

        request.setAttribute("listlsp", listlsp);

        request.setAttribute("listKhachHang", listKH);

        request.getRequestDispatcher("/admin/user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
