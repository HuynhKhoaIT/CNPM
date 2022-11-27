package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.LoaispDAO;
import DAO.SanPhamDAO;
import Model.LoaiSP;
import Model.SanPham;

/**
 * Servlet implementation class SearchControl
 */
@WebServlet(urlPatterns = {"/search"})
public class SearchControl extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String sort_raw = request.getParameter("sort"); //1

        SanPhamDAO sanPhamDAO = new SanPhamDAO();

        List<SanPham> list ;

        int sort = 0;
        if (sort_raw != null) {
            sort = Integer.parseInt(sort_raw);//1
        }

        String txtSearch = request.getParameter("txt");



        if (sort == 0) {
            list = sanPhamDAO.searchByName(txtSearch);
        } else if (sort == 1) {
            list = sanPhamDAO.searchByNameTang(txtSearch);
        } else {
            list = sanPhamDAO.searchByNameGiam(txtSearch);
        }

        LoaispDAO loaispDAO = new LoaispDAO();
        List<LoaiSP> listlsp = loaispDAO.getAllloaisp();

        request.setAttribute("listlsp", listlsp);

        request.setAttribute("sort", sort);


        request.setAttribute("listSearch", list);
        request.setAttribute("txtS", txtSearch);
        request.getRequestDispatcher("/shop/search_product.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);

    }
    /*
     * protected void doGet(HttpServletRequest request, HttpServletResponse
     * response) throws ServletException, IOException { // TODO Auto-generated
     * method stub
     * response.getWriter().append("Served at: ").append(request.getContextPath());
     * }
     */

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     *//*
     * protected void doPost(HttpServletRequest request, HttpServletResponse
     * response) throws ServletException, IOException { // TODO Auto-generated
     * method stub doGet(request, response); }
     */

}
