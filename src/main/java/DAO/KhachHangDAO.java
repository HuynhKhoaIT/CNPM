package DAO;

import Connection.ConnectJDBC;
import Model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KhachHangDAO {
	Connection conn=null;
	PreparedStatement ps =null;
	ResultSet rs = null;

	public List<Users> getAllKhachHang()
	{
		List<Users> list = new ArrayList<>();
		String query = "Select * From KhachHang where (IsAdmin = 0 and IsShiper = 0 )";
		try {
			conn =new ConnectJDBC().getConnection();
			ps =conn.prepareStatement(query);
			rs =ps.executeQuery();
			while(rs.next())
			{
				list.add(new Users(rs.getInt(1),
						rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),
						rs.getInt(9),rs.getInt(10), rs.getInt(11),rs.getInt(12)));
			}
		}
		catch (Exception e) {
		}
		return list;
	}
	public List<Users> getAllKhachHangQuen()
	{
		List<Users> list = new ArrayList<>();
		String query = "Select * From KhachHang where (IsAdmin = 0 and IsShiper = 0 and IsUser = 1)";
		try {
			conn =new ConnectJDBC().getConnection();
			ps =conn.prepareStatement(query);
			rs =ps.executeQuery();
			while(rs.next())
			{
				list.add(new Users(rs.getInt(1),
						rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),
						rs.getInt(9),rs.getInt(10), rs.getInt(11),rs.getInt(12)));
			}
		}
		catch (Exception e) {
		}
		return list;
	}
	public List<Users> getAllKhachHangLa()
	{
		List<Users> list = new ArrayList<>();
		String query = "Select * From KhachHang where (IsAdmin = 0 and IsShiper = 0 and IsUser = 0)";
		try {
			conn =new ConnectJDBC().getConnection();
			ps =conn.prepareStatement(query);
			rs =ps.executeQuery();
			while(rs.next())
			{
				list.add(new Users(rs.getInt(1),
						rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),
						rs.getInt(9),rs.getInt(10), rs.getInt(11),rs.getInt(12)));
			}
		}
		catch (Exception e) {
		}
		return list;
	}

	public Users getKhachHangByID(String id){
		String query = "Select * From KhachHang where MaKH = ?";
		try {
			conn =new ConnectJDBC().getConnection();
			ps =conn.prepareStatement(query);
			ps.setString(1,id);
			rs =ps.executeQuery();
			while(rs.next())
			{
				return new Users(rs.getInt(1),
						rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),
						rs.getInt(9),rs.getInt(10), rs.getInt(11),rs.getInt(12));
			}
		}
		catch (Exception e) {
		}
		return null;
	}
	public Users getKhachHangByPhone(String sdt){
		String query = "Select * From KhachHang where Phone = ?";
		try {
			conn =new ConnectJDBC().getConnection();
			ps =conn.prepareStatement(query);
			ps.setString(1,sdt);
			rs =ps.executeQuery();
			while(rs.next())
			{
				return new Users(rs.getInt(1),
						rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),
						rs.getInt(9),rs.getInt(10), rs.getInt(11),rs.getInt(12));
			}
		}
		catch (Exception e) {
		}
		return null;

	}
	public void addKhachHang(String tenKH, String DiaChi,String SoDT,String Email){
		String query = "INSERT INTO KhachHang (TenKH, DiaChi,Phone,Email,isUser,IsAdmin,IsShiper)\n" +
				"VALUES (?,?,?,?,?,?,?);";
		try {
			conn =new ConnectJDBC().getConnection();
			ps =conn.prepareStatement(query);
			ps.setString(1,tenKH);
			ps.setString(2,DiaChi);
			ps.setString(3,SoDT);
			ps.setString(4,Email);
			ps.setString(5,"0");
			ps.setString(6,"0");
			ps.setString(7,"0");
			ps.executeUpdate();
		}
		catch (Exception e) {
		}
	}


	public Users getKhachHangByMaKH(int MaKH){
		String query = "Select * From KhachHang where MaKH = ?";
		try {
			conn =new ConnectJDBC().getConnection();
			ps =conn.prepareStatement(query);
			ps.setInt(1,MaKH);
			rs =ps.executeQuery();
			while(rs.next())
			{
				return new Users(rs.getInt(1),
						rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),
						rs.getInt(9),rs.getInt(10), rs.getInt(11),rs.getInt(12));
			}
		}
		catch (Exception e) {
		}
		return null;

	}
	public Users getKhachHangByMaTK(int MaTK){
		String query = "Select * From KhachHang where MaTK = ?";
		try {
			conn =new ConnectJDBC().getConnection();
			ps =conn.prepareStatement(query);
			ps.setInt(1,MaTK);
			rs =ps.executeQuery();
			while(rs.next())
			{
				return new Users(rs.getInt(1),
						rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),
						rs.getInt(9),rs.getInt(10), rs.getInt(11),rs.getInt(12));
			}
		}
		catch (Exception e) {
		}
		return null;

	}
	public void UpdateCustomerInfo(int MaKH, String TenKH, String Phone, String Email, String DiaChi) {

		String querry = "update KhachHang set TenKH=?,Phone=?,Email=?,DiaChi=? where MaKH=?";
		try {

			conn = new ConnectJDBC().getConnection();

			ps = conn.prepareStatement(querry);

			ps.setString(1, TenKH);
			ps.setString(2, Phone);
			ps.setString(3, Email);
			ps.setString(4, DiaChi);
			ps.setInt(5, MaKH);
			System.out.println("Thanh cong");
			ps.executeUpdate();

		} catch (Exception e) {
		}
	}
	public void ChangePassWord(int id, String newPass) {
		String querry = "update KhachHang set MK=? where MaKH=?";
		try {

			conn = new ConnectJDBC().getConnection();

			ps = conn.prepareStatement(querry);
			ps.setString(1, newPass);
			ps.setInt(2, id);
			ps.executeUpdate();

		} catch (Exception e) {
		}
	}
	public static void main(String[] args) {
		KhachHangDAO khachHangDAO = new KhachHangDAO();
		Users KhachHang = khachHangDAO.getKhachHangByID("1");
		System.out.println(KhachHang);
	}



}
