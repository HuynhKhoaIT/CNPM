package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.paypal.api.payments.*;
import com.paypal.base.rest.PayPalRESTException;
import DAO.*;
import Model.Cart;
import Model.Users;
import Model.SanPham;

@WebServlet("/execute_payment")
public class ExecutePaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ExecutePaymentServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        response.setContentType("text/html; charset=UTF-8");
        String paymentId = request.getParameter("paymentId");
        String payerId = request.getParameter("PayerID");
        String email = request.getParameter("email");
        String name_raw = request.getParameter("name");
        String phone_raw = request.getParameter("phone");
        String address_raw = request.getParameter("address");
        System.out.println(name_raw);
        try {
            PaymentServices paymentServices = new PaymentServices();
            Payment payment = paymentServices.executePayment(paymentId, payerId);

            PayerInfo payerInfo = payment.getPayer().getPayerInfo();
            Transaction transaction = payment.getTransactions().get(0);

            request.setAttribute("payer", payerInfo);
            request.setAttribute("transaction", transaction);

//		        HttpSession session = request.getSession();
//		        KhachHang khachHang = (KhachHang) session.getAttribute("account");

            SanPhamDAO dao = new SanPhamDAO();
            List<SanPham> list = dao.getAll();
            Cookie[] arr = request.getCookies();
            String txt = "";
            if (arr != null) {
                for (Cookie o : arr) {
                    if (o.getName().equals("cart")) {
                        txt += o.getValue();
                    }
                }
            }
            Cart cart = new Cart(txt, list);

            KhachHangDAO khachHangDAO = new KhachHangDAO();
            HttpSession session = request.getSession();
            Users users = (Users) session.getAttribute("acc");

            Users khachHang;

            if (users == null) {
                if (khachHangDAO.getKhachHangByPhone(phone_raw) == null) {
                    khachHangDAO.addKhachHang(name_raw, address_raw, phone_raw, email);
                }
                khachHang = khachHangDAO.getKhachHangByPhone(phone_raw);

            } else {
                khachHang = users;
            }

            DonHangDAO donHangDAO = new DonHangDAO();
            donHangDAO.addOrderPayPal(khachHang, cart, name_raw, phone_raw, email, address_raw);
            Cookie c = new Cookie("cart", "");
            c.setMaxAge(0);
            response.addCookie(c);
            response.sendRedirect("show");

        } catch (PayPalRESTException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            ex.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

}
