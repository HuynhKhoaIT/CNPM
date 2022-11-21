package Control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ChiTietDonHangDAO;
import DAO.SanPhamDAO;
import Model.ChiTietDonHang;

@WebServlet(name = "User_OrderDetail", value = "/User_OrderDetail")
public class User_OrderDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		int MaDH = Integer.parseInt(request.getParameter("id"));
		List<ChiTietDonHang> list = new ArrayList<ChiTietDonHang>();
		ChiTietDonHangDAO dao = new ChiTietDonHangDAO();
		list = dao.getChiTietSanPhamID(MaDH);

		List<String> listName = new ArrayList<String>();

		for (ChiTietDonHang o : list) {
			SanPhamDAO d = new SanPhamDAO();
			listName.add(d.getProductById(o.getMaSP()).getTenSP());
		}


		request.setAttribute("size", list.size());
		request.setAttribute("listDetail", list);
		request.setAttribute("listName", listName);
		request.getRequestDispatcher("/shop/User_OrderDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
