package DAO;

import Model.DanhMuc;
import Model.TrangThai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Connection.ConnectJDBC;

public class TrangThaiDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<TrangThai> getAllTrangThai()
    {
        List<TrangThai> list = new ArrayList<>();
        String query = "select * From TrangThai";
        try {
            conn =new ConnectJDBC().getConnection();
            ps =conn.prepareStatement(query);
            rs =ps.executeQuery();
            while(rs.next())
            {
                list.add(new TrangThai(rs.getInt(1),rs.getString(2)));
            }
        }
        catch (Exception e) {
        }
        return list;
    }
}
