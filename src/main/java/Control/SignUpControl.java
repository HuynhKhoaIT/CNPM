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

        boolean isStrong = isPasswordStrong(password);

        if (isStrong) {
            System.out.println("Mật khẩu đủ mạnh");
        } else {
            System.out.println("Mật khẩu không đủ mạnh. Vui lòng nhập mật khẩu khác.");
            request.setAttribute("mess", "Mật khẩu không đủ mạnh. Vui lòng nhập mật khẩu khác." +
                    "mật khẩu có tối thiểu 12 ký tự bao gồm ký tự in hoa, ký tự thường, và 1 ký tự đặc biệt");
            request.getRequestDispatcher("/shop/signup.jsp").forward(request, response);
        }

        MD5 lib = new MD5();
        String passMD5 = lib.md5(password);
        String repassMD5 = lib.md5(repassword);

        SignUpDAO dao = new SignUpDAO();
        Users a = dao.CheckUserExist(username);
        if (a == null) {

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

            if (test == false) {
                request.setAttribute("mess", "Email không chính xác");
                request.getRequestDispatcher("/shop/signup.jsp").forward(request, response);
            } else {
                response.sendRedirect("/Apple_store/shop/verify.jsp");
            }
        } else {
            request.setAttribute("mess", "Tài khoản đã tồn tại");
            request.getRequestDispatcher("/shop/signup.jsp").forward(request, response);
        }
    }
    public static boolean isPasswordStrong(String password) {
        // Kiểm tra độ dài
        if (password.length() < 12) {
            return false;
        }

        // Kiểm tra chữ hoa, chữ thường, số và ký hiệu
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else {
                // Kiểm tra ký tự đặc biệt (bạn có thể thay đổi danh sách ký hiệu tùy ý)
                String specialChars = "!@#$%^&*()_+{}:\"<>?|[];',./~`-=";
                if (specialChars.contains(String.valueOf(c))) {
                    hasSpecialChar = true;
                }
            }
        }

        // Kiểm tra xem có đủ các yêu cầu không
        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
    }
}