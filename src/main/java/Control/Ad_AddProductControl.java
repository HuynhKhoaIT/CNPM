package Control;

import DAO.*;
import Model.DanhMuc;
import Model.LoaiSP;
import Model.SanPham;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
@WebServlet(name = "Ad_AddProductControl", value = "/admin/Ad_AddProductControl")
@MultipartConfig(fileSizeThreshold = 1024*1024*2,
        maxFileSize = 1024*1024*10,
        maxRequestSize = 1024*1024*50)
public class Ad_AddProductControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String maLoai = request.getParameter("maLoai");
        String action = request.getParameter("action");
        if(action == null)
        {
            action ="";
        }
        String maSP;
        SanPham sanPham;
        int maDM;

        if(action.equals("delete"))
        {
            maSP = request.getParameter("maSP");
            SanPhamDAO sanPhamDAO = new SanPhamDAO();
            sanPhamDAO.deleteSP(maSP);
            response.sendRedirect("Ad_ProductControl");
        }
        else {
            if(action.equals("modify"))
            {
                maSP = request.getParameter("maSP");
                SanPhamDAO sanPhamDAO = new SanPhamDAO();
                sanPham = sanPhamDAO.getProductById(Integer.parseInt(maSP));
            }
            else
            {
                sanPham = new SanPham();
                if(maLoai==null || maLoai.equals(""))
                {
                    maLoai = "1";
                }
            }
            LoaispDAO loaispDAO = new LoaispDAO();
            List<LoaiSP> listLoaiSP = loaispDAO.getAllloaisp();
            DanhMucDAO danhMucDAO = new DanhMucDAO();
//            List<DanhMuc> listDanhMuc = danhMucDAO.getDanhMucByMaLoai(maLoai);
            List<DanhMuc> listDanhMuc = danhMucDAO.getAllDanhMuc();

            request.setAttribute("sanPham",sanPham);
            request.setAttribute("maLoai",maLoai);
            request.setAttribute("listDanhMuc",listDanhMuc);
            request.setAttribute("listLoaiSP",listLoaiSP);
            request.getRequestDispatcher("/admin/add_product.jsp").forward(request,response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        //common
        String maSP = request.getParameter("maSP");
        String maLoai = request.getParameter("maLoai");
        String maDM = request.getParameter("maDM");
        String tensanpham = request.getParameter("tensanpham");
        String motasanpham = request.getParameter("motasanpham");
        String giagoc = request.getParameter("giagoc");
        String giabanthuong = request.getParameter("giabanthuong");
        String giakhuyenmai = request.getParameter("giakhuyenmai");
        String soluong = request.getParameter("soluong");
        String oldImage = request.getParameter("oldImage");
        String motangan = request.getParameter("motangan");
        Part part = request.getPart("image");
        String mess="";
        String anh;
        if(part.getSubmittedFileName()==null || part.getSubmittedFileName().equals("")){
            anh = oldImage;
        }else{
            String realPath = request.getServletContext().getRealPath("/uploads");
            String filename
                    = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            if(!Files.exists(Paths.get(realPath))){
                Files.createDirectories(Paths.get(realPath));
            }
            part.write(realPath+"/"+filename);
            anh = "uploads/"+filename;
        }
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        if(maSP.equals("") || maSP == null || maSP.equals("0"))
        {
            sanPhamDAO.addSanPham(maDM,tensanpham,motasanpham,giagoc,giabanthuong,giakhuyenmai,soluong,anh,motangan);
            SanPham sanPham = sanPhamDAO.getNewSP();
            AnhSPDAO anhSPDAO = new AnhSPDAO();
            anhSPDAO.addAnhSP(sanPham.getMaSP(),anh);
        }
        else {
            sanPhamDAO.updateSanPham(maDM,tensanpham,motasanpham,giagoc,giabanthuong,giakhuyenmai,soluong,anh,motangan,maSP);
            SanPham sanPham = sanPhamDAO.getProductById(Integer.parseInt(maSP));
            AnhSPDAO anhSPDAO = new AnhSPDAO();
            anhSPDAO.deleteAnhSP(sanPham.getMaSP(),oldImage);
            anhSPDAO.addAnhSP(sanPham.getMaSP(),anh);
        }
        response.sendRedirect("Ad_ProductControl");
    }
}
