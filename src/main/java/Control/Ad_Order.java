package Control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DonHangDAO;
import DAO.KhachHangDAO;
import DAO.TrangThaiDAO;
import Model.DonHang;
import Model.TrangThai;

@WebServlet(name = "Ad_AllOrder", value = "/admin/AllOrder")
public class Ad_Order extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        List<DonHang> list = new ArrayList<DonHang>();
        DonHangDAO dao = new DonHangDAO();
        list = dao.loadAllOrder();
        List<String> ten = new ArrayList<String>();
        for (DonHang o : list) {
            KhachHangDAO dao2 = new KhachHangDAO();
            String tenTK = dao2.getKhachHangByMaKH(o.getMaKH()).getTenTK();
            ten.add(tenTK);
        }

        TrangThaiDAO trangThaiDAO = new TrangThaiDAO();
        List<TrangThai> listTrangThai = trangThaiDAO.getAllTrangThai();

        request.setAttribute("listTrangThai", listTrangThai);
        request.setAttribute("ten", ten);
        request.setAttribute("size", list.size());
        request.setAttribute("list", list);
        request.getRequestDispatcher("/admin/order.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

    }

}
