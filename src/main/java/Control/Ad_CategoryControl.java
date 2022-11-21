package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.LoaispDAO;
import Model.DanhMuc;
import DAO.SanPhamDAO;
import Model.LoaiSP;
import Model.SanPham;

/**
 * Servlet implementation class SearchControl
 */
@WebServlet(urlPatterns = {"/admin/category"})
public class Ad_CategoryControl extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String maloai=request.getParameter("maloai");
        String madm=request.getParameter("madm");

        SanPhamDAO sanphamdao = new SanPhamDAO();
        LoaispDAO loaispDAO = new LoaispDAO();
        List<LoaiSP> listlsp = loaispDAO.getAllloaisp();
        List<DanhMuc> listdm = sanphamdao.getAlldanhmuc(maloai);
        
        
        request.setAttribute("listlsp", listlsp);
        request.setAttribute("listdm", listdm);

		request.getRequestDispatcher("/admin/category.jsp").forward(request, response);

	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
}
