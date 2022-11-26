package DAO;

import Model.DanhMuc;
import Model.LoaiSP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectJDBC;

public class DanhMucDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<DanhMuc> getAllDanhMuc() {
        List<DanhMuc> list = new ArrayList<>();
        String query = "select * From DanhMuc where isDeleted = 0";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DanhMuc(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<DanhMuc> getDanhMucByMaLoai(String maLoai) {
        List<DanhMuc> list = new ArrayList<>();
        String query = "select * From DanhMuc where MaLoai = ? and isDeleted = 0";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maLoai);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DanhMuc(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public DanhMuc getDanhMucByID(String maDM) {
        List<DanhMuc> list = new ArrayList<>();
        String query = "select * From DanhMuc where MaDM = ? and isDeleted = 0";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maDM);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new DanhMuc(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void addDanhMuc(String MaLoai, String TenDM) {
        String query = "insert into DanhMuc(MaLoai,TenDM,isDeleted) Values(?,?,?);";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, MaLoai);
            ps.setString(2, TenDM);
            ps.setString(3, "0");
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateDanhMuc(String MaLoai, String TenDM, String maDM) {
        String query = "UPDATE DanhMuc set MaLoai= ?,TenDM =? where MaDM = ?";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, MaLoai);
            ps.setString(2, TenDM);
            ps.setString(3, maDM);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteDanhMuc(String maDM) {
        String query = "UPDATE DanhMuc set isDeleted= ? where MaDM = ?";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, "1");
            ps.setString(2, maDM);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        DanhMucDAO danhMucDAO = new DanhMucDAO();
        System.out.println(danhMucDAO.getDanhMucByID("1"));
    }
}