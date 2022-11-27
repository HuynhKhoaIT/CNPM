package Control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DonHangDAO;
import DAO.KhachHangDAO;
import DAO.LoaispDAO;
import Model.DonHang;
import Model.LoaiSP;
import Model.Users;

/**
 * Servlet implementation class UserPageControl
 */
@WebServlet(name = "User_PageControl", value = "/shop/UserPage")
public class User_PageControl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();

        if (session.getAttribute("acc") == null) {
            response.sendRedirect("http://localhost:8080/Apple_store/shop/login");
        } else {
            LoaispDAO loaispDAO = new LoaispDAO();
            List<LoaiSP> listlsp = loaispDAO.getAllloaisp();

            request.setAttribute("listlsp", listlsp);
            Users users = (Users) session.getAttribute("acc");
            List<DonHang> allOrderDonHangs = new ArrayList<DonHang>();
            allOrderDonHangs = new DonHangDAO().loadOrderByMaKH(users.getMaKH());

            request.setAttribute("allOrderDonHangs", allOrderDonHangs);
            request.getRequestDispatcher("/shop/user.jsp").forward(request, response);
        }
        //request.getRequestDispatcher("/shop/user.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();

        Users users = (Users) session.getAttribute("acc");

        request.setAttribute("users", users);

        int MaKH = Integer.parseInt(request.getParameter("MaKH"));

        String TenKH = request.getParameter("TenKH");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String DiaChi = request.getParameter("DiaChi");


        users.setTenKH(TenKH);
        users.setPhone(phone);
        users.setEmail(email);
        users.setDiaChi(DiaChi);

        KhachHangDAO dao = new KhachHangDAO();
        dao.UpdateCustomerInfo(MaKH, TenKH, phone, email, DiaChi);
        response.sendRedirect("UserPage");
    }

}
