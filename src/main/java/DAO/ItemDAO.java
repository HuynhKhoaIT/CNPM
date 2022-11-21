package DAO;

import Model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Connection.ConnectJDBC;
import Model.SanPham;

public class ItemDAO {
    Connection conn=null;
    PreparedStatement ps =null;
    ResultSet rs = null;

    public List<Item> getAllItemByMaDH(String MaDH)
    {
        List<Item> list = new ArrayList<>();
        String query = "Select * from ChiTietDonHang where MaDH = ?";
        try {
            conn =new ConnectJDBC().getConnection();
            ps =conn.prepareStatement(query);
            ps.setString(1,MaDH);
            rs =ps.executeQuery();
            while(rs.next())
            {
                SanPhamDAO sanPhamDAO = new SanPhamDAO();
                SanPham sanPham = sanPhamDAO.getProductById(rs.getInt(2));

                list.add(new Item(sanPham,rs.getInt(3),rs.getInt(4)));
            }
        }
        catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) {
        ItemDAO itemDAO = new ItemDAO();
        List<Item> listItem = itemDAO.getAllItemByMaDH("1");
        for(Item o: listItem){
            System.out.println(o.getProduct().getTenSP());
            System.out.println(o.getQuantity());
            System.out.println(o.getPrice());
        }
    }
}