package DAO;

import Connection.ConnectJDBC;
import Model.AnhSanPham;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AnhSPDAO {
    Connection conn=null;
    PreparedStatement ps =null;
    ResultSet rs = null;

    public List<AnhSanPham> getAnhSPByID(int id)
    {
        List<AnhSanPham> list = new ArrayList<>();
        String query = "Select * From AnhSanPham where MaSP = ?";
        try {
            conn =new ConnectJDBC().getConnection();
            ps =conn.prepareStatement(query);
            ps.setInt(1,id);
            rs =ps.executeQuery();
            while(rs.next())
            {
                list.add(new AnhSanPham(rs.getInt(1),rs.getInt(2),rs.getString(3)));
            }
        }
        catch (Exception e) {
        }
        return list;
    }
    public void addAnhSP(int id, String anh)
    {
        String query = "insert into AnhSanPham(MaSP,Anh) values(?,?)";
        try {
            conn =new ConnectJDBC().getConnection();
            ps =conn.prepareStatement(query);
            ps.setInt(1,id);
            ps.setString(2,anh);
            ps.executeUpdate();
        }
        catch (Exception e) {
        }
    }
    public void deleteAnhSP(int id, String anh)
    {
        String query = "DELETE FROM AnhSanPham WHERE MaSP = ? and Anh=?; ";
        try {
            conn =new ConnectJDBC().getConnection();
            ps =conn.prepareStatement(query);
            ps.setInt(1,id);
            ps.setString(2,anh);
            ps.executeUpdate();
        }
        catch (Exception e) {
        }
    }


    public static void main(String[] args) {
        AnhSPDAO anhSPDAO = new AnhSPDAO();
        List<AnhSanPham> list = anhSPDAO.getAnhSPByID(6);
        for(AnhSanPham o:list){
            System.out.println(o);
        }
    }
}
