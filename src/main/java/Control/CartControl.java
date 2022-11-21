package Control;

import DAO.LoaispDAO;
import DAO.SanPhamDAO;
import Model.Cart;
import Model.LoaiSP;
import Model.SanPham;
import Model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletShow", value = "/show")
public class CartControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        HttpSession session = request.getSession();
        Users users = (Users)session.getAttribute("acc");

        SanPhamDAO dao = new SanPhamDAO();
        List<SanPham> list = dao.getAll();
        Cookie[] arr = request.getCookies();
        String txt="";
        if(arr!=null){
            for(Cookie o: arr){
                if(o.getName().equals("cart")){
                    txt+=o.getValue();
                }
            }
        }
        LoaispDAO loaispDAO = new LoaispDAO();
        List<LoaiSP> listlsp = loaispDAO.getAllloaisp();

        request.setAttribute("user",users);

        request.setAttribute("listlsp",listlsp);
        Cart cart = new Cart(txt,list);
        cart.getItems().size();
        request.setAttribute("cart",cart);
        request.getRequestDispatcher("/shop/cart.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
