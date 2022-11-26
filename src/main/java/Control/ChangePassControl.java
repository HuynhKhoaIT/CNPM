
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

/**
 * Servlet implementation class ChangePassControl
 */
@WebServlet("/shop/changepass")
public class ChangePassControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/shop/changepass.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String pass = request.getParameter("password");
		
		MD5 lib = new MD5();
		
		String passMD5 = lib.md5(pass);
		
		HttpSession session = request.getSession();
		
		int id = Integer.parseInt(session.getAttribute("MaKH").toString());
		
		LoginDAO dao = new LoginDAO();
		
		dao.ChangePass(id, passMD5);
		
		session.removeAttribute("MaKH");
		session.removeAttribute("i");
		
		response.sendRedirect("http://localhost:8080/Apple_store");
	}

}