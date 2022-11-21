package Control;

import DAO.LoaispDAO;
import DAO.SanPhamDAO;
import Model.Cart;
import Model.Item;
import Model.LoaiSP;
import Model.SanPham;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProcessServlet", value = "/process")
public class ProcessControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // increase decrease
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
        String num_raw = request.getParameter("num");
        String  id_raw = request.getParameter("id");
        int id = Integer.parseInt(id_raw);
        int num = Integer.parseInt(num_raw);
        Cart cart = new Cart(txt,list);
        if(cart.getQuantityById(id)!=0){
            if(num == -1 || num == 1)
            {
                try{
                    SanPham p  = dao.getProductById(id);
                    int numStore = p.getSoLuong();
                    if(num==-1 && (cart.getQuantityById(id) <= 1)){ // chi co 1 san pham trong gio hang
                        cart.removeItem(id);
                    }else {
                        if( num==1 && cart.getQuantityById(id)>=numStore){
                            num = 0; // neu so luong trong kho lon hon so luong can mua khong cho tang nua
                        }
                        int price = p.getGiaKhuyenMai()*2;
                        Item t = new Item(p,num,price);
                        cart.addItem(t);

                    }
                }catch ( NumberFormatException e){
                    System.out.println(e.getMessage());
                }
                List<Item> items = cart.getItems();
                txt="";
                if(items.size()>0){
                    txt=items.get(0).getProduct().getMaSP()+":"+items.get(0).getQuantity();
                    for (int i = 1 ; i<items.size();i++){
                        txt+="#"+items.get(i).getProduct().getMaSP()+":"+items.get(i).getQuantity();
                    }
                }
                Cookie c = new Cookie("cart",txt);
                c.setMaxAge(2*24*60*60);
                response.addCookie(c);
                
                response.sendRedirect("show");
            }
            else if(num == 0)
            {
                //delete
                String [] ids = txt.split("#");
                String out="";
                for(int i = 0; i<ids.length;i++){
                    String [] s = ids[i].split(":");
                    if(!s[0].equals(id_raw)){
                        if(out.isEmpty()){ //
                            out = ids[i]; //
                        }else {
                            out+="#"+ids[i];
                        }
                    }
                }
                if(!out.isEmpty()){
                    Cookie c = new Cookie("cart",out);
                    c.setMaxAge(2*24*60*60);
                    response.addCookie(c);
                }
                cart=new Cart(out,list);
                LoaispDAO loaispDAO = new LoaispDAO();
                List<LoaiSP> listlsp = loaispDAO.getAllloaisp();
                response.sendRedirect("show");
            }
        }
        else
            response.sendRedirect("show");

    }
}
