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
import DAO.LoaispDAO;
import DAO.LoginDAO;
import DAO.TrangThaiDAO;
import Model.DonHang;
import Model.LoaiSP;
import Model.TrangThai;
import Model.Users;

/**
 * Servlet implementation class OrderStatusControl
 */
@WebServlet("/shop/orderStatus")
public class OrderStatusControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderStatusControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        HttpSession session = request.getSession();
        String email = session.getAttribute("email").toString();
        
        DonHangDAO dao = new DonHangDAO();
        
        List<DonHang> listDonHang = dao.loadOrderByEmail(email);
        
        request.setAttribute("listDonHang", listDonHang);
		
        LoginDAO dao2 = new LoginDAO();
        
        Users a = dao2.CheckUsers(email);
        
        session.setAttribute("a", a);
        
        TrangThaiDAO dao3 = new TrangThaiDAO();
        
        List<TrangThai> listTrangThai = dao3.getAllTrangThai();
        request.setAttribute("listTrangThai", listTrangThai);
        
        
		request.getRequestDispatcher("/shop/order_Status.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
