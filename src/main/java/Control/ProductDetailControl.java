package Control;

import DAO.AnhSPDAO;
import DAO.LoaispDAO;
import DAO.SanPhamDAO;
import Model.AnhSanPham;
import Model.LoaiSP;
import Model.SanPham;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductDetailControl", value = "/ProductDetailControl")
public class ProductDetailControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        AnhSPDAO anhSPDAO = new AnhSPDAO();
        String  id_raw =   request.getParameter("maSP");
        int id = Integer.parseInt(id_raw);
        String maloai = sanPhamDAO.getmaloaibymasp(id_raw);
        String tenloai = sanPhamDAO.gettenloai(maloai);
        String tensp =sanPhamDAO.gettensp(id_raw);
        SanPham sanPham = sanPhamDAO.getProductById(id);
        List<AnhSanPham> listAnhSP= anhSPDAO.getAnhSPByID(id);
        LoaispDAO loaispDAO = new LoaispDAO();
        List<LoaiSP> listlsp = loaispDAO.getAllloaisp();
        List<SanPham>  listsplq= sanPhamDAO.getAllsanphamtop4theodm(maloai);

        request.setAttribute("listlsp",listlsp);
        request.setAttribute("ml",maloai);
        request.setAttribute("tensp",tensp);
        request.setAttribute("tl",tenloai);
        request.setAttribute("listAnhSP",listAnhSP);
        request.setAttribute("listsplq",listsplq);
        request.setAttribute("SanPham",sanPham);
        request.getRequestDispatcher("/shop/detail_product.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
    }
    
}
