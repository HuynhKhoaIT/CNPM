package DAO;

import Connection.ConnectJDBC;
import Model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DonHangDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public void addOrder(Users khachHang, Cart cart, String name, String phone, String email, String address) {
		LocalDate curDate = LocalDate.now();
		String date = curDate.toString();
		String query = "Insert into DonHang(MaKH,TongTien,ThoiGian,MaTrangThai,DiaChi,PhuongThucThanhToan,TenNguoiNhan,SoDienThoai,Email) values(?,?,?,?,?,?,?,?,?);";
		try {
			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, khachHang.getMaKH());
			ps.setInt(2, cart.getTotalMoney());
			ps.setString(3, date);
			ps.setInt(4, 1);
			ps.setString(5, address);
			ps.setString(6, "0");
			ps.setString(7, name);
			ps.setString(8, phone);
			ps.setString(9, email);
			ps.executeUpdate();
			// lay id order vua tao ra
			String query1 = "Select top 1 MaDH from DonHang order by MaDH desc";
			PreparedStatement ps1 = conn.prepareStatement(query1);
			ResultSet rs1 = ps1.executeQuery();
			// add bang OrderDetail
			if (rs1.next()) {
				int OrderID = rs1.getInt("MaDH");
				for (Item i : cart.getItems()) {
					String query2 = "Insert into ChiTietDonHang(MaDH,MaSP,SoLuong,TongTien) values(?,?,?,?);";
					PreparedStatement ps2 = conn.prepareStatement(query2);
					ps2.setInt(1, OrderID);
					ps2.setInt(2, i.getProduct().getMaSP());
					ps2.setInt(3, i.getQuantity());
					ps2.setInt(4, (i.getQuantity() * i.getPrice()));
					ps2.executeUpdate();
				}

			}
			// cap nhat lai so luong san pham
			String query3 = "update  SanPham set SoLuong=SoLuong-?,SoLuongDaBan=SoLuongDaBan+? where MaSP =?";
			PreparedStatement ps3 = conn.prepareStatement(query3);
			for (Item i : cart.getItems()) {
				ps3.setInt(1, i.getQuantity());
				ps3.setInt(2, i.getQuantity());
				ps3.setInt(3, i.getProduct().getMaSP());
				ps3.executeUpdate();

			}
		} catch (Exception e) {
		}
	}

	public void addOrderPayPal(Users khachHang, Cart cart, String name, String phone, String email, String address) {
		LocalDate curDate = LocalDate.now();
		String date = curDate.toString();
		String query = "Insert into DonHang(MaKH,TongTien,ThoiGian,MaTrangThai,DiaChi,PhuongThucThanhToan,TenNguoiNhan,SoDienThoai,Email) values(?,?,?,?,?,?,?,?,?);";
		try {
			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, khachHang.getMaKH());
			ps.setInt(2, cart.getTotalMoney());
			ps.setString(3, date);
			ps.setInt(4, 1);
			ps.setString(5, address);
			ps.setString(6, "1");
			ps.setString(7, name);
			ps.setString(8, phone);
			ps.setString(9, email);
			ps.executeUpdate();
			// lay id order vua tao ra
			String query1 = "Select top 1 MaDH from DonHang order by MaDH desc";
			PreparedStatement ps1 = conn.prepareStatement(query1);
			ResultSet rs1 = ps1.executeQuery();
			// add bang OrderDetail
			if (rs1.next()) {
				int OrderID = rs1.getInt("MaDH");
				for (Item i : cart.getItems()) {
					String query2 = "Insert into ChiTietDonHang(MaDH,MaSP,SoLuong,TongTien) values(?,?,?,?);";
					PreparedStatement ps2 = conn.prepareStatement(query2);
					ps2.setInt(1, OrderID);
					ps2.setInt(2, i.getProduct().getMaSP());
					ps2.setInt(3, i.getQuantity());
					ps2.setInt(4, (i.getQuantity() * i.getPrice()));
					ps2.executeUpdate();
				}

			}
			// cap nhat lai so luong san pham
			String query3 = "update  SanPham set SoLuong=SoLuong-?,SoLuongDaBan=SoLuongDaBan+? where MaSP =?";
			PreparedStatement ps3 = conn.prepareStatement(query3);
			for (Item i : cart.getItems()) {
				ps3.setInt(1, i.getQuantity());
				ps3.setInt(2, i.getQuantity());
				ps3.setInt(3, i.getProduct().getMaSP());
				ps3.executeUpdate();

			}
		} catch (Exception e) {
		}
	}

	public List<DonHang> getAllDonHangByMaKH(String id) {
		List<DonHang> list = new ArrayList<>();
		String query = "Select * From DonHang where MaKH = ?";
		try {
			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new DonHang(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7), rs.getDate(8), rs.getInt(9), rs.getString(10), rs.getString(11),
						rs.getString(12)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public DonHang getDonHangByMaDH(String id) {
		String query = "Select * From DonHang where MaDH = ?";
		try {
			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new DonHang(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getInt(6),
						rs.getString(7), rs.getDate(8), rs.getInt(9), rs.getString(10), rs.getString(11),
						rs.getString(12));
			}
		} catch (Exception e) {
		}
		return null;
	}

	public List<DonHang> loadTop10Order() {
		String querry = "select top 10 * from DonHang where MaTrangThai = 1 ";
		List<DonHang> list = new ArrayList<DonHang>();
		try {

			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(querry);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new DonHang(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7), rs.getDate(8), rs.getInt(9), rs.getString(10), rs.getString(11),
						rs.getString(12)));

			}

		} catch (Exception e) {
		}
		return list;
	}

	public List<DonHang> loadOrderByMonth(int month) {
		String querry = "select  * from DonHang where MaTrangThai = 4 and MONTH(ThoiGian)=? ";
		List<DonHang> list = new ArrayList<DonHang>();
		try {

			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(querry);
			ps.setInt(1, month);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new DonHang(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7), rs.getDate(8), rs.getInt(9), rs.getString(10), rs.getString(11),
						rs.getString(12)));

			}

		} catch (Exception e) {
		}
		return list;
	}

	public List<DonHang> loadOrderByQuy(int quy) {
		String querry = "select  * from DonHang where MaTrangThai = 4 and MONTH(ThoiGian)>=8 and MONTH(ThoiGian)<=12";
		List<DonHang> list = new ArrayList<DonHang>();
		try {

			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(querry);
			if (quy == 1) {
				ps.setInt(1, 1);
				ps.setInt(2, 4);
			} else if (quy == 2) {
				ps.setInt(1, 5);
				ps.setInt(2, 8);
			} else {
				ps.setInt(1, 9);
				ps.setInt(2, 12);
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new DonHang(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7), rs.getDate(8), rs.getInt(9), rs.getString(10), rs.getString(11),
						rs.getString(12)));

			}

		} catch (Exception e) {
		}
		return list;
	}

	public List<DonHang> loadOrderByNam(int nam) {
		String querry = "select  * from DonHang where MaTrangThai = 4 and year(ThoiGian)=?";
		List<DonHang> list = new ArrayList<DonHang>();
		try {

			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(querry);
			ps.setInt(1, nam);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new DonHang(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7), rs.getDate(8), rs.getInt(9), rs.getString(10), rs.getString(11),
						rs.getString(12)));

			}

		} catch (Exception e) {
		}
		return list;
	}

	public List<DonHang> loadTopOrderMatt4() {
		String querry = "select  * from DonHang where MaTrangThai = 4 and MONTH(ThoiGian)=MONTH(GETDATE()) ";
		List<DonHang> list = new ArrayList<DonHang>();
		try {

			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(querry);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new DonHang(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7), rs.getDate(8), rs.getInt(9), rs.getString(10), rs.getString(11),
						rs.getString(12)));

			}

		} catch (Exception e) {
		}
		return list;
	}

	public List<DonHang> getOrderTheoTrangThai(String maTT) {
		String querry = "select * from DonHang where MaTrangThai = ? ";
		List<DonHang> list = new ArrayList<DonHang>();
		try {
			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(querry);
			ps.setString(1, maTT);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new DonHang(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7), rs.getDate(8), rs.getInt(9), rs.getString(10), rs.getString(11),
						rs.getString(12)));
			}

		} catch (Exception e) {
		}
		return list;
	}

	public List<DonHang> getOrderOfShipper(String maGH, String maTT) {
		String querry = "select * from DonHang where MaGH = ? and MaTrangThai = ?";
		List<DonHang> list = new ArrayList<DonHang>();
		try {
			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(querry);
			ps.setString(1, maGH);
			ps.setString(2, maTT);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new DonHang(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7), rs.getDate(8), rs.getInt(9), rs.getString(10), rs.getString(11),
						rs.getString(12)));

			}

		} catch (Exception e) {
		}
		return list;
	}

	public List<DonHang> loadAllOrder() {
		String querry = "select * from DonHang";
		List<DonHang> list = new ArrayList<DonHang>();
		try {

			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(querry);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new DonHang(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7), rs.getDate(8), rs.getInt(9), rs.getString(10), rs.getString(11),
						rs.getString(12)));

			}

		} catch (Exception e) {
		}
		return list;
	}

	public void UpdateStatus(int oldStatus, int MaDH) {
		String querry = "update DonHang set MaTrangThai=? where MaDH=?";

		try {

			conn = new ConnectJDBC().getConnection();

			ps = conn.prepareStatement(querry);
			if (oldStatus == 1)
				ps.setInt(1, 2);
			else
				ps.setInt(1, 1);

			ps.setInt(2, MaDH);
			ps.executeUpdate();

			System.out.println("Thanh cong");

		} catch (Exception e) {
		}
	}

	public List<DonHang> loadOrderByMaKH(int MaKH) {
		String querry = "select * from DonHang where MaKH=?";
		List<DonHang> list = new ArrayList<DonHang>();
		try {

			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(querry);
			ps.setInt(1, MaKH);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new DonHang(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5),
						rs.getInt(6), rs.getString(7), rs.getDate(8), rs.getInt(9), rs.getString(10), rs.getString(11),
						rs.getString(12)));

			}

		} catch (Exception e) {
		}
		return list;
	}

	public int totalPriceAllOrderByMonth(int month) {
		String querry = "select * from DonHang where MaTrangThai=4 and MONTH(ThoiGian)=?";
		int total = 0;
		try {

			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(querry);
			ps.setInt(1, month);
			rs = ps.executeQuery();
			while (rs.next()) {
				total = total + rs.getInt(4);

			}

		} catch (Exception e) {
		}
		return total;
	}

	public int totalPriceAllOrderByQuy(int quy) {
		String querry = "select  * from DonHang where MaTrangThai = 4 and MONTH(ThoiGian)>=? and MONTH(ThoiGian)<=?";
		int total = 0;
		try {

			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(querry);
			if (quy == 1) {
				ps.setInt(1, 1);
				ps.setInt(2, 4);
			} else if (quy == 2) {
				ps.setInt(1, 5);
				ps.setInt(2, 8);
			} else {
				ps.setInt(1, 9);
				ps.setInt(2, 12);
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				total = total + rs.getInt(4);

			}

		} catch (Exception e) {
		}
		return total;
	}

	public int totalPriceAllOrderByNam(int nam) {
		String querry = "select  * from DonHang where MaTrangThai = 4 and year(ThoiGian)=?";
		int total = 0;
		try {

			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(querry);
			ps.setInt(1, nam);
			rs = ps.executeQuery();
			while (rs.next()) {
				total = total + rs.getInt(4);

			}

		} catch (Exception e) {
		}
		return total;
	}

	public int totalPriceAllOrder() {
		String querry = "select * from DonHang where MaTrangThai=4 and MONTH(ThoiGian)=MONTH(GETDATE())";
		int total = 0;
		try {

			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(querry);
			rs = ps.executeQuery();
			while (rs.next()) {
				total = total + rs.getInt(4);

			}

		} catch (Exception e) {
		}
		return total;
	}

	public void trangthai(String maDH) {
		String querry = "UPDATE DonHang\r\n" + "SET MaTrangThai = 2\r\n" + "WHERE MaDH = ?; ";
		try {

			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(querry);
			ps.setString(1, maDH);
			ps.executeUpdate();

		} catch (Exception e) {
		}

	}

	public void TrangThaiDangGiao(String maDH, String maGH) {
		String querry = "UPDATE DonHang\r\n" + "SET MaTrangThai = 3, MaGH = ?\r\n" + "WHERE MaDH = ?; ";
		try {

			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(querry);
			ps.setString(1, maGH);
			ps.setString(2, maDH);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public void TrangThaiDaGiao(String maDH) {
		LocalDate curDate = LocalDate.now();
		String date = curDate.toString();
		String querry = "UPDATE DonHang\r\n" + "SET MaTrangThai = 4, NgayNhanHang = ?\r\n" + "WHERE MaDH = ?; ";
		try {

			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(querry);
			ps.setString(1, date);
			ps.setString(2, maDH);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		DonHangDAO donHangDAO = new DonHangDAO();
		System.out.println(donHangDAO.getDonHangByMaDH("1"));
	}
}
