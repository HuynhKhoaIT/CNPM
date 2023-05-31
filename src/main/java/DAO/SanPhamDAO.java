package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectJDBC;
import Model.DanhMuc;
import Model.LoaiSP;
import Model.SanPham;
import Model.ChiTietDonHang;

public class SanPhamDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<SanPham> getAllsanpham(String madm) {
        List<SanPham> list = new ArrayList<>();
        String query = "select * From SanPham Where MaDM=? and isDeleted =0";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, madm);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
                        rs.getString(9), rs.getString(10),
                        rs.getInt(11), rs.getInt(12)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public String getmaloai(String ml) {

        String maloai = null;
        String query = "select MaLoai From DanhMuc Where MaDM=? ";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, ml);
            rs = ps.executeQuery();
            while (rs.next()) {
                maloai = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return maloai;
    }

    public String getmaloaibymasp(String masp) {

        String maloai = null;
        String query = "select MaLoai From SanPham inner join DanhMuc on SanPham.MaDM=DanhMuc.MaDM Where MaSP=? ";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, masp);
            rs = ps.executeQuery();
            while (rs.next()) {
                maloai = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return maloai;
    }

    public String gettenloai(String maloai) {
        String tenloai = null;
        String query = "select TenLoai From LoaiSP Where MaLoai=? ";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maloai);
            rs = ps.executeQuery();
            while (rs.next()) {
                tenloai = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return tenloai;
    }

    public String gettensp(String masp) {

        String tensp = null;
        String query = "select TensP From SanPham Where MaSP=? ";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, masp);
            rs = ps.executeQuery();
            while (rs.next()) {
                tensp = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return tensp;
    }

    public List<SanPham> getAllsanphamtheodm(String maloai) {
        List<SanPham> list = new ArrayList<>();
        String query = "select * From SanPham inner join DanhMuc on SanPham.MaDM=DanhMuc.MaDM Where MaLoai=? and SanPham.isDeleted=0";


        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maloai);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
                        rs.getString(9), rs.getString(10),
                        rs.getInt(11), rs.getInt(12)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<SanPham> getAllsanphamtop4theodm(String maloai) {

        List<SanPham> list = new ArrayList<>();
        String query = "select top 4 * From SanPham inner join DanhMuc on SanPham.MaDM=DanhMuc.MaDM  Where MaLoai=? and SanPham.isDeleted=0 ";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maloai);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
                        rs.getString(9), rs.getString(10),
                        rs.getInt(11), rs.getInt(12)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<DanhMuc> getAlldanhmuc(String maloai) {
        List<DanhMuc> list = new ArrayList<>();
        String query = "select * From DanhMuc Where MaLoai=? and isDeleted = 0";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maloai);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DanhMuc(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<SanPham> getAll() {
        List<SanPham> list = new ArrayList<>();

        String query = "select *from SanPham WHERE isDeleted=0 ";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
                        rs.getString(9), rs.getString(10),
                        rs.getInt(11), rs.getInt(12)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public SanPham getProductById(int id) {
        String query = "select *from SanPham where MaSP = ? ";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new SanPham(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
                        rs.getString(9), rs.getString(10),
                        rs.getInt(11), rs.getInt(12));

            }

        } catch (Exception e) {

        }
        return null;

    }

    //lọc sản phẩm theo giá tiền
//lọc sản phẩm theo giá tiền
    public List<SanPham> getSortSPTangByDM(String sort) {

        List<SanPham> list = new ArrayList<>();
        String query = "select * From SanPham Where MaDM = ? and isDeleted=0\r\n"
                + "order by GiaBanThuong ASC;\r\n";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, sort);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
                        rs.getString(9), rs.getString(10),
                        rs.getInt(11), rs.getInt(12)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<SanPham> getAllSPByDM(String sort) {

        List<SanPham> list = new ArrayList<>();
        String query = "select * From SanPham Where MaDM = ? and isDeleted=0";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, sort);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
                        rs.getString(9), rs.getString(10),
                        rs.getInt(11), rs.getInt(12)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<SanPham> getSortSPGiamByDM(String sort) {

        List<SanPham> list = new ArrayList<>();
        String query = "select * From SanPham Where MaDM = ? and isDeleted=0\r\n"
                + "order by GiaBanThuong desc;\r\n";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, sort);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
                        rs.getString(9), rs.getString(10),
                        rs.getInt(11), rs.getInt(12)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<SanPham> getSortSPTangByMaLoai(String maLoai) {

        List<SanPham> list = new ArrayList<>();
//		String query = "SELECT SanPham.MaSP, SanPham.MaDM,SanPham.TenSP,SanPham.MoTa,SanPham.GiaGoc,SanPham.GiaBanThuong,SanPham.GiaKhuyenMai,SanPham.SoLuong,SanPham.Anh,SanPham.MoTaNgan,SanPham.isDeleted,SanPham.SoLuongDaBan\n" +
//				"\t\t\t\tFROM SanPham INNER JOIN DanhMuc ON DanhMuc.MaDM = SanPham.MaDM  where MaLoai = ? and isDeleted=0 order by GiaBanThuong asc ";
        String query = "SELECT *" +
                "\t\t\t\tFROM SanPham INNER JOIN DanhMuc ON DanhMuc.MaDM = SanPham.MaDM  where MaLoai = ? and SanPham.isDeleted=0 order by GiaBanThuong asc ";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maLoai);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
                        rs.getString(9), rs.getString(10),
                        rs.getInt(11), rs.getInt(12)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<SanPham> getSortSPGiamTheoMaLoai(String maLoai) {


        List<SanPham> list = new ArrayList<>();
        String query = "SELECT *" +
                "\t\t\t\tFROM SanPham INNER JOIN DanhMuc ON DanhMuc.MaDM = SanPham.MaDM  where MaLoai = ? and SanPham.isDeleted=0 order by GiaBanThuong DESC ";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maLoai);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
                        rs.getString(9), rs.getString(10),
                        rs.getInt(11), rs.getInt(12)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void addSanPham(String MaDM, String TenSP, String MoTa, String GiaGoc, String GiaBanThuong, String GiaKhuyenMai,
                           String SoLuong, String Anh, String MoTaNgan) {
        String query = "insert into SanPham(MaDM,TenSP,MoTa,GiaGoc,GiaBanThuong,GiaKhuyenMai,SoLuong,Anh,isDeleted,MoTaNgan,SoLuongDaBan) Values(?,?,?,?,?,?,?,?,?,?,?);";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, MaDM);
            ps.setString(2, TenSP);
            ps.setString(3, MoTa);
            ps.setString(4, GiaGoc);
            ps.setString(5, GiaBanThuong);
            ps.setString(6, GiaKhuyenMai);
            ps.setString(7, SoLuong);
            ps.setString(8, Anh);
            ps.setString(9, "0");
            ps.setString(10, MoTaNgan);
            ps.setString(11, "0");

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateSanPham(String MaDM, String TenSP, String MoTa, String GiaGoc, String GiaBanThuong, String GiaKhuyenMai,
                              String SoLuong, String Anh, String MoTaNgan, String maSP) {
        String query = "UPDATE SanPham\n" +
                "SET MaDM = ?,TenSP =?, MoTa=?,MoTaNgan=?,GiaGoc=?,GiaBanThuong=?,GiaKhuyenMai=?,SoLuong=?,Anh=?,isDeleted=?\n" +
                "WHERE MaSP = ?;";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, MaDM);
            ps.setString(2, TenSP);
            ps.setString(3, MoTa);
            ps.setString(4, MoTaNgan);
            ps.setString(5, GiaGoc);
            ps.setString(6, GiaBanThuong);
            ps.setString(7, GiaKhuyenMai);
            ps.setString(8, SoLuong);
            ps.setString(9, Anh);
            ps.setString(10, "0");
            ps.setString(11, maSP);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteSP(String maSP) {
        String query = "UPDATE SanPham\n" +
                "SET isDeleted=?\n" +
                "WHERE MaSP = ?;";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, "1");
            ps.setString(2, maSP);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<SanPham> newProduct() {
        List<SanPham> list = new ArrayList<>();
        String query = "select TOP 6  *from SanPham where isDeleted = 0 order by MaSP desc;";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
                        rs.getString(9), rs.getString(10),
                        rs.getInt(11), rs.getInt(12)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<SanPham> searchByName(String txtSearch) {
        List<SanPham> list = new ArrayList<>();
        String query = "select *from SanPham \r\n"
                + "where [TenSP] like ? and SanPham.isDeleted=0 order by MaSP desc ";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
                        rs.getString(9), rs.getString(10),
                        rs.getInt(11), rs.getInt(12)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<SanPham> searchByNameTang(String txtSearch) {
        List<SanPham> list = new ArrayList<>();
        String query = "select *from SanPham \r\n"
                + "where [TenSP] like ? and SanPham.isDeleted=0 order by GiaBanThuong ASC ";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
                        rs.getString(9), rs.getString(10),
                        rs.getInt(11), rs.getInt(12)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<SanPham> searchByNameGiam(String txtSearch) {
        List<SanPham> list = new ArrayList<>();
        String query = "select *from SanPham \r\n"
                + "where [TenSP] like ? and SanPham.isDeleted=0 order by GiaBanThuong desc ";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
                        rs.getString(9), rs.getString(10),
                        rs.getInt(11), rs.getInt(12)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void deleteSPByMaDM(String maDM) {
        String query = "UPDATE SanPham\n" +
                "SET isDeleted=?\n" +
                "WHERE MaDM = ?;";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, "1");
            ps.setString(2, maDM);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public SanPham getNewSP() {
        String query = "Select top 1 * from SanPham where isDeleted=0 order by MaSP desc";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new SanPham(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
                        rs.getString(9), rs.getString(10),
                        rs.getInt(11), rs.getInt(12));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public int TotalChiPhi() {
        List<ChiTietDonHang> list = new ArrayList<ChiTietDonHang>();
        list = new ChiTietDonHangDAO().getAllChiTietDonHang();
        int total = 0;
        for (ChiTietDonHang o : list) {
            String query = "select * From SanPham where MaSP=?";

            try {
                conn = new ConnectJDBC().getConnection();
                ps = conn.prepareStatement(query);
                ps.setInt(1, o.getMaSP());
                rs = ps.executeQuery();
                while (rs.next()) {
                    total = total + rs.getInt(5) * o.getSoLuong();

                }
            } catch (Exception e) {
            }
        }
        return total;
    }
    public static void main(String[] args) {
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        List<SanPham> list = sanPhamDAO.getSortSPGiamTheoMaLoai("1");
        for (SanPham o : list) {
            System.out.println(o);
        }
    }
}