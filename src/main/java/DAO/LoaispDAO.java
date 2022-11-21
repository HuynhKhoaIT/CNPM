package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectJDBC;
import Model.LoaiSP;

public class LoaispDAO {
	Connection conn=null;
	PreparedStatement ps =null;
	ResultSet rs = null;
	public List<LoaiSP> getAllloaisp()
	{
		List<LoaiSP> list = new ArrayList<>();
		String query = "select * From LoaiSP";
		try {
				conn =new ConnectJDBC().getConnection();
				ps =conn.prepareStatement(query);
				rs =ps.executeQuery();
				while(rs.next())
				{
					list.add(new LoaiSP(rs.getInt(1),rs.getString(2)));
				}
		}
			catch (Exception e) {
			}
		return list;
	}
	public static void main(String[] args) {
		LoaispDAO iphonedao = new LoaispDAO();
        List<LoaiSP> list = iphonedao.getAllloaisp();

        for(LoaiSP o : list) {
			System.out.println(o);
		}
    }
}
