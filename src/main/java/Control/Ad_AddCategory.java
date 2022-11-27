
package Control;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.BaiVietDAO;
import DAO.LoaispDAO;
import DAO.DanhMucDAO;
import DAO.SanPhamDAO;
import Model.BaiViet;
import Model.DanhMuc;
import Model.LoaiSP;
import Model.SanPham;

/**
 * Servlet implementation class SearchControl
 */
@WebServlet(name = "Ad_AddCategory", value = "/admin/Ad_AddCategory")
public class Ad_AddCategory extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        DanhMuc danhMuc;
        String maDM = "";
        String action = request.getParameter("action");
        DanhMucDAO danhMucDAO = new DanhMucDAO();
        LoaispDAO loaispDAO = new LoaispDAO();
        List<LoaiSP> listlsp = loaispDAO.getAllloaisp();

        String note;

        if (action == null) {
            action = "";
        }
        if (action.equals("delete")) {
            maDM = request.getParameter("maDM");
            danhMucDAO.deleteDanhMuc(maDM);
            SanPhamDAO sanPhamDAO = new SanPhamDAO();
            sanPhamDAO.deleteSPByMaDM(maDM);
            response.sendRedirect("http://localhost:8080/Apple_store/admin/category");
        } else {
            if (action.equals("modify")) {
                maDM = request.getParameter("maDM");

                danhMuc = danhMucDAO.getDanhMucByID(maDM);
                note = "Lưu";
            } else {
                danhMuc = new DanhMuc();
                note = "Tạo";
            }
            request.setAttribute("listlsp", listlsp);
            request.setAttribute("note", note);
            request.setAttribute("danhMuc", danhMuc);
            request.getRequestDispatcher("/admin/add_category.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        DanhMucDAO danhMucDAO = new DanhMucDAO();
        System.out.println("Da goi duoc");

        String maDM = request.getParameter("maDM");
        String maLoai = request.getParameter("maLoai");
        String tenDM = request.getParameter("tendanhmuc");

        if (maDM.equals("") || maDM == null || maDM.equals("0")) {
            danhMucDAO.addDanhMuc(maLoai, tenDM);
        } else {
            danhMucDAO.updateDanhMuc(maLoai, tenDM, maDM);
        }
        response.sendRedirect("http://localhost:8080/Apple_store/admin/category");
        // thong bao
    }

}
