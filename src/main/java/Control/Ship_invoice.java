package Control;

import DAO.ChiTietDonHangDAO;
import DAO.DonHangDAO;
import DAO.KhachHangDAO;
import DAO.SanPhamDAO;
import Model.ChiTietDonHang;
import Model.DonHang;
import Model.SanPham;
import Model.Users;
import jakarta.mail.Session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Ship_invoice", value = "/Ship_invoice")
public class Ship_invoice extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        response.setContentType("text/html;charset=UTF-8");
        List<SanPham> listSP = new ArrayList<SanPham>();
        String maDH = request.getParameter("maDH");

        DonHangDAO donHangDAO = new DonHangDAO();
        DonHang donHang = donHangDAO.getDonHangByMaDH(maDH);

        KhachHangDAO khachHangDAO = new KhachHangDAO();
        Users khachHang = khachHangDAO.getKhachHangByID(Integer.toString(donHang.getMaKH()));

        ChiTietDonHangDAO dao = new ChiTietDonHangDAO();
        List<ChiTietDonHang> list = dao.getChiTietSanPhamID(Integer.parseInt(maDH));


        for (ChiTietDonHang o : list) {
            SanPhamDAO d = new SanPhamDAO();
            listSP.add(d.getProductById(o.getMaSP()));
        }
//		request.setAttribute("taikhoan", taiKhoan);
        request.setAttribute("khachHang", khachHang);
        request.setAttribute("donHang", donHang);
        request.setAttribute("size", list.size());
        request.setAttribute("listDetail", list);
        request.setAttribute("listSP", listSP);
        request.getRequestDispatcher("/Shipper/invoices.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        HttpSession session = request.getSession();
        session.removeAttribute("accad");
        session.removeAttribute("acc");
        if (session.getAttribute("accship") == null) {
            response.sendRedirect("http://localhost:8080/Apple_store/shop/loginship");
        } else {
            String maDH = request.getParameter("maDH");
            String maTT = request.getParameter("maTT");

            DonHangDAO donhangDAO = new DonHangDAO();
            Users users = (Users) session.getAttribute("accship");

            if (maTT.equals("2")) {
                donhangDAO.TrangThaiDangGiao(maDH, String.valueOf(users.getMaKH()));
            } else {
                donhangDAO.TrangThaiDaGiao(maDH);
            }
            response.sendRedirect("/Apple_store/Ship_invoice?maDH=" + maDH);
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
        }
    }
}
