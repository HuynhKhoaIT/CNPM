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
import Model.DonHang;

@WebServlet("/admin/OrderQuy")
public class Ad_OrderQuy extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        int quy = Integer.parseInt(request.getParameter("quy"));
        
        List<DonHang> list = new ArrayList<DonHang>();
        DonHangDAO dao = new DonHangDAO();
        list = dao.loadAllOrderByQuy(quy);
        List<String> ten = new ArrayList<String>();
        for (DonHang o : list) {
            KhachHangDAO dao2 = new KhachHangDAO();
            String tenTK = dao2.getKhachHangByMaKH(o.getMaKH()).getTenTK();
            ten.add(tenTK);
        }

        request.setAttribute("ten", ten);
        request.setAttribute("size", list.size());
        request.setAttribute("list", list);
        request.setAttribute("quy", quy);
        request.getRequestDispatcher("/admin/orderByQuy.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

    }

}
