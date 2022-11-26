
package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LoginDAO;
import Model.MD5;
import Model.SendMailPass;
import Model.Users;

/**
 * Servlet implementation class SendMailForgetControl
 */
@WebServlet("/shop/email")
public class SendMailForgetControl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMailForgetControl() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/shop/email.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        HttpSession session = request.getSession();

        String email = request.getParameter("email");

        SendMailPass sm = new SendMailPass();

        MD5 lib = new MD5();

        LoginDAO dao = new LoginDAO();
        Users a = dao.CheckUsers(email);

        if (a == null) {
            request.setAttribute("mess", "Email không tồn tại");
            request.getRequestDispatcher("/shop/email.jsp").forward(request, response);
        } else {
            int i = lib.getRandom();
            boolean test = sm.sendMail(email, i, a.getTenKH());
            session.setAttribute("i", i);
            session.setAttribute("MaKH", a.getMaKH());
            response.sendRedirect("http://localhost:8080/Apple_store/shop/verifypass");
        }
    }

}