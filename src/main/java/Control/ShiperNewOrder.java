package Control;

import DAO.DonHangDAO;
import Model.DonHang;
import Model.Users;
import jakarta.mail.Session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShiperNewOrder", value = "/ShiperNewOrder")
public class ShiperNewOrder extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<DonHang> list ;
        DonHangDAO dao = new DonHangDAO();

        HttpSession session = request.getSession();

        session.removeAttribute("accad");
        session.removeAttribute("acc");
        if (session.getAttribute("accship") == null) {
            response.sendRedirect("http://localhost:8080/Apple_store/shop/loginship");
        }
        else {
            Users users = (Users) session.getAttribute("accship");
            String title = "";

            String tt = request.getParameter("tt");
            if(tt.equals("2"))
            {
                list = dao.getOrderTheoTrangThai("2");
                title="Đơn hàng mới";

            }else {
                list = dao.getOrderOfShipper(String.valueOf(users.getMaKH()),tt);
                if(tt.equals("3"))
                {
                    title="Đơn đang giao";
                }
                else {
                    title="Đơn đã giao";
                }
            }

            request.setAttribute("title",title);
            request.setAttribute("list",list);
            request.getRequestDispatcher("/Shipper/newOrders.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
    }

}

