package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectJDBC;
import Model.ChiTietDonHang;;

public class ChiTietDonHangDAO {
	Connection conn=null;
	PreparedStatement ps =null;
	ResultSet rs = null;
	public List<ChiTietDonHang> getChiTietSanPhamID(int MaDH)
	{
		
		List<ChiTietDonHang> list = new ArrayList<ChiTietDonHang>();
		String query = "select * from ChiTietDonHang where MaDH=?";
		try {
				conn =new ConnectJDBC().getConnection();
				ps =conn.prepareStatement(query);
				ps.setInt(1,MaDH);
				rs =ps.executeQuery();
				while(rs.next())
				{
					list.add(new ChiTietDonHang(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4)));
				}
		}
			catch (Exception e) {
			}
		return list;
	}
	
	public List<ChiTietDonHang> getAllChiTietDonHang()
	{
		
		List<ChiTietDonHang> list = new ArrayList<ChiTietDonHang>();
		String query = "select * from ChiTietDonHang";
		try {
				conn =new ConnectJDBC().getConnection();
				ps =conn.prepareStatement(query);
				rs =ps.executeQuery();
				while(rs.next())
				{
					list.add(new ChiTietDonHang(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4)));
				}
		}
			catch (Exception e) {
			}
		return list;
	}

}
