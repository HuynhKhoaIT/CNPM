package Control;

import DAO.SanPhamDAO;
import Model.SanPham;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BuyServlet", value = "/buy")
public class AddToCartControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        SanPhamDAO dao = new SanPhamDAO();
        List<SanPham> list = dao.getAll();
        Cookie[] arr = request.getCookies();
        String txt="";
        if(arr!=null){
            for(Cookie o: arr){
                if(o.getName().equals("cart")){
                    txt+=o.getValue();
                    o.setMaxAge(0);
                    response.addCookie(o);
                }
            }
        }
        String check_raw =  request.getParameter("check");
        int check = Integer.parseInt(check_raw);
        String num = request.getParameter("num");
        String id = request.getParameter("id");
        if(txt.isEmpty()){
            txt=id+":"+num;
        }else {
            txt=txt+"#"+id+":"+num;
        }
        Cookie c = new Cookie("cart",txt);
        c.setMaxAge(2*24*60*60);
        response.addCookie(c);
//        request.setAttribute("maSP",id);
        if(check == 0){
            response.sendRedirect("ProductDetailControl?maSP=" + id);
        }
//        request.getRequestDispatcher("shop").forward(request,response);
        else {
            response.sendRedirect("show");
        }
    }
}