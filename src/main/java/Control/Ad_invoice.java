package Control;

import DAO.DonHangDAO;
import DAO.KhachHangDAO;
import Model.DonHang;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Ad_invoice", value = "/Ad_invoice")
public class Ad_invoice extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        DonHangDAO donhangDAO = new DonHangDAO();
        
        String maDH = request.getParameter("maDH");
        
        donhangDAO.trangthai(maDH);
        
        response.sendRedirect("/Apple_store/admin/AllOrder");

    }
}
