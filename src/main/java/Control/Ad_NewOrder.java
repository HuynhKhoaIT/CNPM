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
import Model.DonHang;

/**
 * Servlet implementation class Ad_NewOrder
 */
@WebServlet(name = "Ad_NewOrder", value = "/admin/newOrder")
public class Ad_NewOrder extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        List<DonHang> list = new ArrayList<DonHang>();
        DonHangDAO dao = new DonHangDAO();
        list = dao.loadTop10Order();

        request.setAttribute("list", list);
        request.setAttribute("size", list.size());
        request.getRequestDispatcher("/admin/newOrders.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
