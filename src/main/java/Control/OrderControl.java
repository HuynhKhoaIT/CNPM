package Control;

import DAO.DonHangDAO;
import DAO.KhachHangDAO;
import DAO.SanPhamDAO;
import Model.Cart;
import Model.SanPham;
import Model.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderControl", value = "/orderControl")
public class OrderControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        SanPhamDAO dao = new SanPhamDAO();
        List<SanPham> list = dao.getAll();
        Cookie[] arr = request.getCookies();
        String txt="";
        if(arr!=null){
            for(Cookie o: arr){
                if(o.getName().equals("cart")){
                    txt+=o.getValue();
                }
            }
        }
        Cart cart = new Cart(txt,list);
        String name_raw = request.getParameter("name");
        String phone_raw = request.getParameter("phone");
        String email_raw = request.getParameter("email");
        String address_raw = request.getParameter("address");

        KhachHangDAO khachHangDAO = new KhachHangDAO();

        HttpSession session = request.getSession();
        Users users = (Users)session.getAttribute("acc");

        Users khachHang;


        if(users == null)
        {
            if(khachHangDAO.getKhachHangByPhone(phone_raw) == null){
                khachHangDAO.addKhachHang(name_raw,address_raw,phone_raw,email_raw);
            }
            khachHang = khachHangDAO.getKhachHangByPhone(phone_raw);

        }
        else {
            khachHang = users;
        }

        DonHangDAO donHangDAO = new DonHangDAO();
        donHangDAO.addOrder(khachHang,cart,name_raw,phone_raw,email_raw,address_raw);
        Cookie c = new Cookie("cart","");
        c.setMaxAge(0);
        response.addCookie(c);
        response.sendRedirect("show");
    }
}
