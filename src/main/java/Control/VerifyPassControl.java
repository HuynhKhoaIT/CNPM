
package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class VerifyPassControl
 */
@WebServlet("/shop/verifypass")
public class VerifyPassControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyPassControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/shop/verifypass.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int i = Integer.parseInt(request.getParameter("verify"));
		
		HttpSession session = request.getSession();
		
		int a = Integer.parseInt(session.getAttribute("i").toString());
		
		if(i == a) {
			response.sendRedirect("/Apple_store/shop/changepass");
		}
		else {
			request.setAttribute("mess", "Sai mã xác nhận");
			request.getRequestDispatcher("/shop/verifypass.jsp").forward(request, response);
		}
	}

}