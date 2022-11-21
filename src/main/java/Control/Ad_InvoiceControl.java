package Control;

import DAO.ChiTietDonHangDAO;
import DAO.DonHangDAO;
import DAO.KhachHangDAO;
import DAO.SanPhamDAO;
import Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Ad_invoiceControl", value = "/admin/Ad_invoiceControl")
public class Ad_InvoiceControl extends HttpServlet {
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

		if(donHang.getMaGH()!= 0 )
		{
			Users Shipper = khachHangDAO.getKhachHangByID(Integer.toString(donHang.getMaGH()));
			request.setAttribute("Shipper",Shipper);
		}
		for (ChiTietDonHang o : list) {
			SanPhamDAO d = new SanPhamDAO();
			listSP.add(d.getProductById(o.getMaSP()));
		}

		request.setAttribute("khachHang", khachHang);
		request.setAttribute("donHang", donHang);
		request.setAttribute("size", list.size());
		request.setAttribute("listDetail", list);
		request.setAttribute("listSP", listSP);
		request.getRequestDispatcher("/admin/invoice.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
