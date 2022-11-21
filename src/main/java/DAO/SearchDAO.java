package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectJDBC;
import Model.SanPham;

public class SearchDAO 
{
	Connection conn=null;
	PreparedStatement ps =null;
	ResultSet rs = null;
	
	public List<SanPham> searchByName(String txtSearch)
	{
		List<SanPham> list = new ArrayList<>();
		String query = "select *from SanPham \r\n"
				+ "where [TenSP] like ? ";
		try {
				conn =new ConnectJDBC().getConnection();
				ps =conn.prepareStatement(query);
				ps.setString(1, "%"+txtSearch+"%");
				rs =ps.executeQuery();
				while(rs.next())
				{
					list.add(new SanPham(rs.getInt(1),rs.getInt(2),
							rs.getString(3),rs.getString(4),
							rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),
							rs.getString(9), rs.getString(10),
							rs.getInt(11),rs.getInt(12)));
				}
		}
			catch (Exception e) {
			}
		return list;
	}
	public static void main(String[] args) {
		SearchDAO searchdao = new SearchDAO();
		List<SanPham> list = searchdao.searchByName("iPhone");
		for(SanPham o : list) {
			System.out.println(o);
		}
	}
	
}
