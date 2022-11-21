package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectJDBC;
import Model.SanPham;

public class NewProductDAO 
{
	Connection conn=null;
	PreparedStatement ps =null;
	ResultSet rs = null;
	
	public List<SanPham> newProduct()
	{
		List<SanPham> list = new ArrayList<>();
		String query = "select TOP 6  *from SanPham where isDeleted = 0 order by MaSP desc;";
		try {
				conn =new ConnectJDBC().getConnection();
				ps =conn.prepareStatement(query);
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
		NewProductDAO newproducdao = new NewProductDAO();
		List<SanPham> list = newproducdao.newProduct();
		for(SanPham o : list) {
			System.out.println(o);
		}
	}
	
}
