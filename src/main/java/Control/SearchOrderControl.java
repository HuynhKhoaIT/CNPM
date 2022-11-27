package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LoginDAO;
import Model.Users;

/**
 * Servlet implementation class SearchOrderControl
 */
@WebServlet("/shop/searchorder")
public class SearchOrderControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchOrderControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/shop/search_order.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        String email = request.getParameter("email");
        
        HttpSession session = request.getSession();
        
        LoginDAO dao = new LoginDAO();
        
        Users a = dao.CheckUsers(email);
        
        if (a == null) {
        	request.setAttribute("mess", "Email không tồn tại");
            request.getRequestDispatcher("/shop/search_order.jsp").forward(request, response);
        }
        else {
        	session.setAttribute("email", email);
        	response.sendRedirect("/Apple_store/shop/orderStatus");
        }
	}

}
