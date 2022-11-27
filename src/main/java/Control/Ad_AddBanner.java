package Control;

import DAO.BaiVietDAO;
import DAO.BannerDAO;
import Model.BaiViet;
import Model.Banner;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@WebServlet(name = "Ad_AddBanner", value = "/admin/Ad_AddBanner")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
public class Ad_AddBanner extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String title;

        Banner banner;
        String maB = "";
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        if (action.equals("delete")) {
            maB = request.getParameter("maB");
            BannerDAO bannerDAO = new BannerDAO();
            bannerDAO.deleteBanner(maB);

            String mess ="Xóa thành công";
            HttpSession session = request.getSession();
            session.setAttribute("getAlert",mess);

            response.sendRedirect("Ad_Banner");
//            thong bao
        } else {
            if (action.equals("modify")) {
                maB = request.getParameter("maB");
                BannerDAO bannerDAO = new BannerDAO();
                banner = bannerDAO.getBannerByID(maB);
                title = "Sửa bài viết";

            } else {
                banner = new Banner();
                title = "Thêm bài viết mới";
            }
            request.setAttribute("title",title);
            request.setAttribute("banner", banner);
            request.getRequestDispatcher("/admin/add_banner.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String title;

        String maB = request.getParameter("maB");
        String tieude = request.getParameter("tieude");
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
        BannerDAO bannerDAO = new BannerDAO();
        if (maB.equals("") || maB == null || maB.equals("0")) {
            bannerDAO.addBanner(tieude, anh);
            mess ="thêm thành công";
        } else {
            bannerDAO.updateBanner(tieude, anh, maB);
            mess = "sửa thành công";
        }
        HttpSession session = request.getSession();
        session.setAttribute("getAlert",mess);
        response.sendRedirect("Ad_Banner");

    }
}
