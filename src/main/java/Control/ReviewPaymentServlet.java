package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.paypal.api.payments.*;
import com.paypal.base.rest.PayPalRESTException;
import DAO.*;
import Model.Cart;
import Model.LoaiSP;
import Model.SanPham;

@WebServlet("/review_payment")
public class ReviewPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReviewPaymentServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String paymentId = request.getParameter("paymentId");
		String payerId = request.getParameter("PayerID");/*
		 * String name_raw = request.getParameter("name_raw");
		 * String phone_raw = request.getParameter("phone_raw");
		 * String address_raw = request.getParameter("address_raw");
		 */


		try {
			PaymentServices paymentServices = new PaymentServices();
			Payment payment = paymentServices.getPaymentDetails(paymentId);

			PayerInfo payerInfo = payment.getPayer().getPayerInfo();
			Transaction transaction = payment.getTransactions().get(0);
			ShippingAddress shippingAddress = transaction.getItemList().getShippingAddress();

			request.setAttribute("payer", payerInfo);
			request.setAttribute("transaction", transaction);
			request.setAttribute("shippingAddress",
					shippingAddress);/*
			 * request.setAttribute("name_raw", name_raw); request.setAttribute("phone_raw",
			 * phone_raw); request.setAttribute("address_raw", address_raw);
			 */
			String url = "/shop/ReviewPage.jsp?paymentId=" + paymentId + "&PayerID=" + payerId;


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
			LoaispDAO loaispDAO = new LoaispDAO();
			List<LoaiSP> listlsp = loaispDAO.getAllloaisp();

			request.setAttribute("listlsp", listlsp);
			System.out.println(txt);
			Cart cart = new Cart(txt, list);
			cart.getItems().size();
			request.setAttribute("cart", cart);
			request.getRequestDispatcher(url).forward(request, response);

		} catch (PayPalRESTException ex) {
			request.setAttribute("errorMessage", ex.getMessage());
			ex.printStackTrace();
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}