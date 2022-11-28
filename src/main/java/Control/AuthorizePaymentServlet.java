package Control;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Model.Item;
import DAO.*;
import com.paypal.base.rest.PayPalRESTException;

@WebServlet("/paypal")
public class AuthorizePaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AuthorizePaymentServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String nameSP[] = request.getParameterValues("nameSP");
        String quantity[] = request.getParameterValues("quantity");
        String totalPrice[] = request.getParameterValues("totalPrice");
        int totalString = Integer.parseInt(request.getParameter("total")) / 23000;


        List<Item> items = new ArrayList<Item>();
        int tong = 0;
        for (int i = 0; i < nameSP.length; i++) {
            items.add(new Item(nameSP[i], Integer.parseInt(quantity[i]), Integer.parseInt(totalPrice[i]) / 23000));
            tong = tong + (Integer.parseInt(totalPrice[i])/23000)*Integer.parseInt(quantity[i]) ;
        }
        System.out.println(tong);
        System.out.println(totalString);
        try {
            PaymentServices paymentServices = new PaymentServices();
            String approvalLink = paymentServices.authorizePayment(Integer.toString(totalString - (totalString - tong)), items);

            response.sendRedirect(approvalLink);

        } catch (PayPalRESTException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            ex.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

}