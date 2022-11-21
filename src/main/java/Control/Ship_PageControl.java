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

import DAO.ChiTietDonHangDAO;
import DAO.DonHangDAO;
import DAO.KhachHangDAO;
import DAO.SanPhamDAO;
import Model.ChiTietDonHang;
import Model.DonHang;
import Model.SanPham;
import Model.Users;

@WebServlet(name = "Ship_PageControl", value = "/shipper")
public class Ship_PageControl extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");


		HttpSession session = request.getSession();
		if (session.getAttribute("acc") == null) {
			session.removeAttribute("newrole");
			session.setAttribute("newrole2", 1);
			response.sendRedirect("http://localhost:8080/Apple_store/shop/login");
		}
		else if (Integer.parseInt(session.getAttribute("roleshipper").toString()) == 0){
			session.removeAttribute("acc");
			session.removeAttribute("rolead");
			session.removeAttribute("roleshipper");
			response.sendRedirect("http://localhost:8080/Apple_store/shop/login");
		}
		else {
			Users shipper = (Users)session.getAttribute("acc");
			// don hang dang giao cua shipper :

			DonHangDAO donHangDAO = new DonHangDAO();
			List<DonHang> listDangGiao = donHangDAO.getOrderOfShipper(String.valueOf(shipper.getMaKH()),"3");

			// So luong don hang moi co the xac nhan de giao
			List<DonHang> listCoTheNhanGiao  = donHangDAO.getOrderTheoTrangThai("2");
			int SLCoTheNhanGiao = listCoTheNhanGiao.size();

			// So luong don hang da giao cau Shipper
			List<DonHang> listDonHangDaGiaoCuaShiper = donHangDAO.getOrderOfShipper(String.valueOf(shipper.getMaKH()),"4");
			int SLDonHangDaGiao = listDonHangDaGiaoCuaShiper.size();

			request.setAttribute("listDangGiao",listDangGiao);
			request.setAttribute("SLCoTheNhanGiao",SLCoTheNhanGiao);
			request.setAttribute("SLDonHangDaGiao",SLDonHangDaGiao);


			request.getRequestDispatcher("/Shipper/shipper.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	}

}
