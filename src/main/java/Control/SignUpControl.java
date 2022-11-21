package Control;

import DAO.SignUpDAO;
import Model.MD5;
import Model.SendMail;
import Model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class SignUpControl
 */
@WebServlet("/shop/signup")
public class SignUpControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/shop/signup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String fullname = request.getParameter("fullname");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");

		MD5 lib = new MD5();
		String passMD5 = lib.md5(password);
		String repassMD5 = lib.md5(repassword);

		SignUpDAO dao = new SignUpDAO();
		Users a = dao.CheckUserExist(username);
		if(a==null) {

			int veri = lib.getRandom();

			HttpSession session = request.getSession();
			session.setAttribute("fullname", fullname);
			session.setAttribute("username", username);
			session.setAttribute("email", email);
			session.setAttribute("phone", phone);
			session.setAttribute("password", passMD5);
			session.setAttribute("repassword", repassMD5);
			session.setAttribute("verify", veri);


			SendMail sm = new SendMail();
			Boolean test = sm.sendMail(email, veri, fullname);

			if(test == false) {
				request.setAttribute("mess", "Email không chính xác");
				request.getRequestDispatcher("/shop/signup.jsp").forward(request, response);
			}
			else {
				response.sendRedirect("/Apple_store/shop/verify.jsp");
			}
		}
		else {
			request.setAttribute("mess", "Tài khoản đã tồn tại");
			request.getRequestDispatcher("/shop/signup.jsp").forward(request, response);
		}
	}

}