package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectJDBC;
import Model.BaiViet;
import Model.Cart;
import Model.DanhMuc;

public class BaiVietDAO {
    Connection conn=null;
    PreparedStatement ps =null;
    ResultSet rs = null;

    public void addBaiViet(String tieude, String chitiet, String anh) {
        LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        String query = "insert into BaiViet(TieuDeBV,NoiDung,NgayTao,Anh) values(?,?,?,?);";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tieude);
            ps.setString(2, chitiet);
            ps.setString(3, date);
            ps.setString(4,anh);
            ps.executeUpdate();
        }catch (Exception e)
        {

        }
    }
    public void updateBaiViet(String tieude, String chitiet, String anh,String maBV) {
        LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        String query = "UPDATE BaiViet\n" +
                "SET TieuDeBV = ?,NoiDung=?,Anh=?,NgayCapNhat=?\n" +
                "WHERE MaBV =?;";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tieude);
            ps.setString(2, chitiet);
            ps.setString(3, anh);
            ps.setString(4,date);
            ps.setString(5,maBV);
            ps.executeUpdate();
        }catch (Exception e)
        {
        }
    }
    public void deleteBaiViet(String maBV){
        String query = "DELETE FROM BaiViet WHERE MaBV=?;;";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maBV);
            ps.executeUpdate();
        }catch (Exception e)
        {
        }
    }
    public List<BaiViet> getAllBaiViet() {
        List<BaiViet> list = new ArrayList<>();
        String query = "select * From BaiViet";
        try {
            conn =new ConnectJDBC().getConnection();
            ps =conn.prepareStatement(query);
            rs =ps.executeQuery();
            while(rs.next())
            {
                list.add(new BaiViet(rs.getInt(1),
                        rs.getString(2),rs.getString(3), rs.getString(4),
                        rs.getDate(5),rs.getDate(6)));
            }
        }
        catch (Exception e) {
        }
        return list;
    }
    public List<BaiViet> getAllBaiVietTop4() {
        List<BaiViet> list = new ArrayList<>();
        String query = "select top 4 * From BaiViet order  by MaBV desc";
        try {
            conn =new ConnectJDBC().getConnection();
            ps =conn.prepareStatement(query);
            rs =ps.executeQuery();
            while(rs.next())
            {
                list.add(new BaiViet(rs.getInt(1),
                        rs.getString(2),rs.getString(3), rs.getString(4),
                        rs.getDate(5),rs.getDate(6)));
            }
        }
        catch (Exception e) {
        }
        return list;
    }
    public BaiViet getBaiVietByID(String id){

        String query = "select * From BaiViet where MaBV = ?";
        try {
            conn =new ConnectJDBC().getConnection();
            ps =conn.prepareStatement(query);
            ps.setString(1,id);
            rs =ps.executeQuery();

            while(rs.next())
            {
               return new BaiViet(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)
               ,rs.getDate(5),rs.getDate(6));
            }
        }
        catch (Exception e) {
        }
        return null;
    }
    public BaiViet getBaiViet(){

        String query = "select top 1 * From BaiViet order by MaBV desc";
        try {
            conn =new ConnectJDBC().getConnection();
            ps =conn.prepareStatement(query);
            rs =ps.executeQuery();

            while(rs.next())
            {
               return new BaiViet(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)
               ,rs.getDate(5),rs.getDate(6));
            }
        }
        catch (Exception e) {
        }
        return null;
    }


    public static void main(String[] args) {
        BaiVietDAO baiVietDAO = new BaiVietDAO();
        BaiViet list = baiVietDAO.getBaiViet();
        //for(BaiViet b: list)
        //{
            System.out.println(list);
        //}
    }

}