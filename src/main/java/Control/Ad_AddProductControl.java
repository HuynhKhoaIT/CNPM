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
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.LocalDateTime;  // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;  // Import the DateTimeFormatter class

@WebServlet(name = "Ad_AddProductControl", value = "/admin/Ad_AddProductControl")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
public class Ad_AddProductControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String maLoai = request.getParameter("maLoai");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        String maSP;
        SanPham sanPham;
        int maDM;

        if (action.equals("delete")) {
            maSP = request.getParameter("maSP");
            SanPhamDAO sanPhamDAO = new SanPhamDAO();
            sanPhamDAO.deleteSP(maSP);
            response.sendRedirect("Ad_ProductControl");
        } else {
            if (action.equals("modify")) {
                maSP = request.getParameter("maSP");
                SanPhamDAO sanPhamDAO = new SanPhamDAO();
                sanPham = sanPhamDAO.getProductById(Integer.parseInt(maSP));
            } else {
                sanPham = new SanPham();
                if (maLoai == null || maLoai.equals("")) {
                    maLoai = "1";
                }
            }
            LoaispDAO loaispDAO = new LoaispDAO();
            List<LoaiSP> listLoaiSP = loaispDAO.getAllloaisp();
            DanhMucDAO danhMucDAO = new DanhMucDAO();
//            List<DanhMuc> listDanhMuc = danhMucDAO.getDanhMucByMaLoai(maLoai);
            List<DanhMuc> listDanhMuc = danhMucDAO.getAllDanhMuc();

            request.setAttribute("sanPham", sanPham);
            request.setAttribute("maLoai", maLoai);
            request.setAttribute("listDanhMuc", listDanhMuc);
            request.setAttribute("listLoaiSP", listLoaiSP);
            request.getRequestDispatcher("/admin/add_product.jsp").forward(request, response);
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
        String anh;

        // get images
        Collection<Part> fileParts = request.getParts();
        int index = 0;
        for (int i = index; i < fileParts.size(); i++) {
            Part part = (Part) fileParts.toArray()[i];
            if (!part.getName().equals("multiPartServlet")) {
                System.out.println(part.getName());
                fileParts.remove(part);
                i = index - 1;
            }
        }

        // create a folder containing images
        LoaispDAO loaispDAO = new LoaispDAO();
        String tenLoai = loaispDAO.getLoaispByMaDM(maDM).trim().replace("/", "");
        ;

        DanhMucDAO danhMucDAO = new DanhMucDAO();
        String tenDM = danhMucDAO.getDanhMucByID(maDM).getTenDM().trim().replace("/", "");
        ;

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HHmmss");

        String formattedDate = myDateObj.format(myFormatObj);

        String path = "uploads" + "/" + tenLoai + "/" + tenDM + "/" + "date " + formattedDate;

        List<String> images = new ArrayList<>();
        if (!fileParts.isEmpty()) {

            String realPath = request.getServletContext().getRealPath("/" + path);
            if (!Files.exists(Paths.get(realPath))) {
                Files.createDirectories(Paths.get(realPath));
            } // tao folder

            for (Part part : fileParts) {
//                String fileName = part.getSubmittedFileName();
                String filename
                        = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                part.write(realPath + "/" + filename);
                images.add(path + "/" + filename);
            }
            anh = images.get(0);
        } else {
            anh = oldImage;
        }
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        if (maSP.equals("") || maSP == null || maSP.equals("0")) {
            sanPhamDAO.addSanPham(maDM, tensanpham, motasanpham, giagoc, giabanthuong, giakhuyenmai, soluong, anh, motangan);
            SanPham sanPham = sanPhamDAO.getNewSP();
            AnhSPDAO anhSPDAO = new AnhSPDAO();
            for (String image : images) {
                anhSPDAO.addAnhSP(sanPham.getMaSP(), image);
            }
            System.out.println(sanPham.getAnh());

        } else {
            sanPhamDAO.updateSanPham(maDM, tensanpham, motasanpham, giagoc, giabanthuong, giakhuyenmai, soluong, anh, motangan, maSP);
            SanPham sanPham = sanPhamDAO.getProductById(Integer.parseInt(maSP));
            AnhSPDAO anhSPDAO = new AnhSPDAO();
            anhSPDAO.deleteAnhSP(sanPham.getMaSP());
            for (String image : images) {
                anhSPDAO.addAnhSP(sanPham.getMaSP(), image);
            }
        }
        response.sendRedirect("Ad_ProductControl");
    }
}
