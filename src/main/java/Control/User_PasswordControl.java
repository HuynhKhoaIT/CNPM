package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.KhachHangDAO;
import DAO.LoginDAO;
import Model.MD5;
import Model.Users;

/**
 * Servlet implementation class User_PasswordControl
 */
@WebServlet("/shop/PasswordChange")
public class User_PasswordControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("acc");
		String oldPass=request.getParameter("oldPass");
		String newPass1=request.getParameter("newPass1");
		String newPass2=request.getParameter("newPass2");
		
		MD5 lib = new MD5(); 
		String passMD5 = lib.md5(oldPass);
		
		 
		LoginDAO dao = new LoginDAO();
		Users a = dao.login(users.getTenTK(), passMD5); 
		
		if(a != null) {
			if(newPass1.equals(newPass2)) {
				MD5 lib2 = new MD5();
				String passMD5_2= lib2.md5(newPass1);
				KhachHangDAO dao2=new KhachHangDAO();
				dao2.ChangePassWord(users.getMaKH(), passMD5_2);
				System.out.println("hello 2");
				session.removeAttribute("acc");
				response.sendRedirect("http://localhost:8080/Apple_store");
			}
			else {
				System.out.println("hello 3");
				response.sendRedirect("UserPage");
			}
		}
		else {
			System.out.println("hello 1");
			response.sendRedirect("UserPage");
			
		}
	}

}
