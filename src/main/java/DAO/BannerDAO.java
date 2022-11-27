package DAO;

import Model.BaiViet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Connection.ConnectJDBC;
import Model.Banner;

public class BannerDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;


    public Banner getBannerByID(String id) {

        String query = "select * From Banner where MaB = ?";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Banner(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Banner getBannerNewBanner() {

        String query = "SELECT TOP 1 * FROM Banner order by MaB desc";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Banner(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void addBanner(String tieude, String anh) {

        String query = "insert into Banner(TieuDeB,Anh) values(?,?);";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,tieude);
            ps.setString(2,anh);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public void updateBanner(String tieude,  String anh, String maB) {
        String query = "UPDATE Banner SET TieuDeB = ?,Anh=?\n" +
                "                WHERE MaB =?";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tieude);
            ps.setString(2, anh);
            ps.setString(3, maB);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }


    public void deleteBanner(String maBV) {
        String query = "DELETE FROM Banner WHERE MaB=?;;";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maBV);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public List<Banner> getAllBanner() {
        List<Banner> list = new ArrayList<>();
        String query = "select * From Banner";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Banner(rs.getInt(1),
                        rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
        }
        return list;
    }

}
