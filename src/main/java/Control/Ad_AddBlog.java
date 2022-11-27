package Control;

import DAO.*;
import Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@WebServlet(name = "Ad_TaoBaiViet", value = "/admin/Ad_TaoBaiViet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)

public class Ad_AddBlog extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String title;

        BaiViet baiViet;
        String maBV = "";
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        if (action.equals("delete")) {
            maBV = request.getParameter("maBV");
            BaiVietDAO baiVietDAO = new BaiVietDAO();
            baiVietDAO.deleteBaiViet(maBV);

            String mess ="Xóa thành công";
            HttpSession session = request.getSession();
            session.setAttribute("getAlert",mess);

            response.sendRedirect("Ad_Blog");
//            thong bao
        } else {
            if (action.equals("modify")) {
                maBV = request.getParameter("maBV");
                BaiVietDAO baiVietDAO = new BaiVietDAO();
                baiViet = baiVietDAO.getBaiVietByID(maBV);
                title = "Sửa bài viết";

            } else {
                baiViet = new BaiViet();
                title = "Thêm bài viết mới";
            }
            request.setAttribute("title",title);
            request.setAttribute("baiViet", baiViet);
            request.getRequestDispatcher("/admin/add_blog.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String title;

        String maBV = request.getParameter("maBV");
        String tieude = request.getParameter("tieude");
        String chitiet = request.getParameter("chitiet");
        String oldImage = request.getParameter("oldImage");
        Part part = request.getPart("image");
        String mess;
        String anh;
        if (part.getSubmittedFileName() == null || part.getSubmittedFileName().equals("")) {
            anh = oldImage;
        } else {
            String realPath = request.getServletContext().getRealPath("/uploads");
            String filename
                    = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            if (!Files.exists(Paths.get(realPath))) {
                Files.createDirectories(Paths.get(realPath));
            }
            part.write(realPath + "/" + filename);
            anh = "uploads/" + filename;
        }
        BaiVietDAO baiVietDAO = new BaiVietDAO();
        if (maBV.equals("") || maBV == null || maBV.equals("0")) {
            baiVietDAO.addBaiViet(tieude, chitiet, anh);
            mess ="thêm thành công";
        } else {
            baiVietDAO.updateBaiViet(tieude, chitiet, anh, maBV);
            mess = "sửa thành công";
        }

        HttpSession session = request.getSession();
        session.setAttribute("getAlert",mess);
        response.sendRedirect("Ad_Blog");
    }
}