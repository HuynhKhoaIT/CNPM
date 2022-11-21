package DAO;

import Connection.ConnectJDBC;
import Model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SignUpDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public Users CheckUserExist(String username) {
		String query = "select * from KhachHang\r\n"
				+ "where TenTK=?";

		try {
			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();

			while(rs.next()) {
				return new Users(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getInt(9),
						rs.getInt(10),
						rs.getInt(11),
						rs.getInt(12));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	public void signup(String fullname, String username, String email, String phone, String password, String repassword ) {
		String query = "insert into KhachHang\r\n"
				+ "values (?, ?, ?, ?, Null, ?, ?, '1', '1', '0', '0');";
		try {
			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, fullname);
			ps.setString(2, username);
			ps.setString(3, email);
			ps.setString(4, phone);
			ps.setString(5, password);
			ps.setString(6, repassword);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}