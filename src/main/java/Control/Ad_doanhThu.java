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
import DAO.DonHangDAO;
import DAO.SanPhamDAO;
import Model.ChiTietDonHang;
import Model.DonHang;
import Model.SanPham;

/**
 * Servlet implementation class Ad_doanhThu
 */
@WebServlet("/Ad_doanhThu")
public class Ad_doanhThu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Integer> ChiPhi = new ArrayList<Integer>();
		List<Integer> doanhThu = new ArrayList<Integer>();
		for (int j = 1; j <= 12; j++) {

			List<DonHang> list2 = new ArrayList<DonHang>();
			DonHangDAO dao2 = new DonHangDAO();
			list2 = dao2.loadOrderByMonth(j);
			List<ChiTietDonHang> chititet = new ArrayList<ChiTietDonHang>();
			int totalChiPhi = 0;
			for (DonHang o : list2) {

				ChiTietDonHangDAO d = new ChiTietDonHangDAO();
				chititet = d.getChiTietSanPhamID(o.getMaDH());
				for (ChiTietDonHang i : chititet) {
					SanPham SP = new SanPham();
					SanPhamDAO a = new SanPhamDAO();
					SP = a.getProductById(i.getMaSP());
					totalChiPhi = totalChiPhi + i.getSoLuong() * SP.getGiaGoc();
				}
			}

			int total = new DonHangDAO().totalPriceAllOrderByMonth(j);
			ChiPhi.add(totalChiPhi);
			doanhThu.add(total);

		}
		
		List<Integer> ChiPhiQuy = new ArrayList<Integer>();
		List<Integer> doanhThuQuy = new ArrayList<Integer>();
		for (int j = 1; j <= 3; j++) {

			List<DonHang> list2 = new ArrayList<DonHang>();
			DonHangDAO dao2 = new DonHangDAO();
			list2 = dao2.loadOrderByQuy(j);
			List<ChiTietDonHang> chititet = new ArrayList<ChiTietDonHang>();
			int totalChiPhi = 0;
			for (DonHang o : list2) {

				ChiTietDonHangDAO d = new ChiTietDonHangDAO();
				chititet = d.getChiTietSanPhamID(o.getMaDH());
				for (ChiTietDonHang i : chititet) {
					SanPham SP = new SanPham();
					SanPhamDAO a = new SanPhamDAO();
					SP = a.getProductById(i.getMaSP());
					totalChiPhi = totalChiPhi + i.getSoLuong() * SP.getGiaGoc();
				}
			}

			int total = new DonHangDAO().totalPriceAllOrderByQuy(j);
			ChiPhiQuy.add(totalChiPhi);
			doanhThuQuy.add(total);

		}

		request.setAttribute("ChiPhi", ChiPhi);
		request.setAttribute("doanhThu", doanhThu);
		request.setAttribute("ChiPhiQuy", ChiPhiQuy);
		request.setAttribute("doanhThuQuy", doanhThuQuy);
		request.setAttribute("size", doanhThu.size());
		request.getRequestDispatcher("/admin/doanhthu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
