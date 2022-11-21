package Model;

import java.util.Date;

public class DonHang {
    int MaDH;
    int MaKH;
    int MaGH;
    int TongTien;
    Date ThoiGian;
    int MaTrangThai;
    String DiaChi;
    Date NgayNhanHang;
    int PhuongThucThanhToan;
    String TenNguoiNhan;
    String SoDienThoai;
    String Email;

    public DonHang() {
    }

    public String getTenNguoiNhan() {
        return TenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        TenNguoiNhan = tenNguoiNhan;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        SoDienThoai = soDienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public DonHang(int maDH, int maKH, int maGH, int tongTien, Date thoiGian, int maTrangThai, String diaChi, Date ngayNhanHang, int phuongThucThanhToan, String tenNguoiNhan, String soDienThoai, String email) {
        MaDH = maDH;
        MaKH = maKH;
        MaGH = maGH;
        TongTien = tongTien;
        ThoiGian = thoiGian;
        MaTrangThai = maTrangThai;
        DiaChi = diaChi;
        NgayNhanHang = ngayNhanHang;
        PhuongThucThanhToan = phuongThucThanhToan;
        TenNguoiNhan = tenNguoiNhan;
        SoDienThoai = soDienThoai;
        Email = email;
    }

    public int getMaDH() {
        return MaDH;
    }

    public void setMaDH(int maDH) {
        MaDH = maDH;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int maKH) {
        MaKH = maKH;
    }

    public int getMaGH() {
        return MaGH;
    }

    public void setMaGH(int maGH) {
        MaGH = maGH;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int tongTien) {
        TongTien = tongTien;
    }

    public Date getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        ThoiGian = thoiGian;
    }

    public int getMaTrangThai() {
        return MaTrangThai;
    }

    public void setMaTrangThai(int maTrangThai) {
        MaTrangThai = maTrangThai;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public Date getNgayNhanHang() {
        return NgayNhanHang;
    }

    public void setNgayNhanHang(Date ngayNhanHang) {
        NgayNhanHang = ngayNhanHang;
    }

    public int getPhuongThucThanhToan() {
        return PhuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(int phuongThucThanhToan) {
        PhuongThucThanhToan = phuongThucThanhToan;
    }

    @Override
    public String toString() {
        return "DonHang{" +
                "MaDH=" + MaDH +
                ", MaKH=" + MaKH +
                ", MaGH=" + MaGH +
                ", TongTien=" + TongTien +
                ", ThoiGian=" + ThoiGian +
                ", MaTrangThai=" + MaTrangThai +
                ", DiaChi='" + DiaChi + '\'' +
                ", NgayNhanHang=" + NgayNhanHang +
                ", PhuongThucThanhToan=" + PhuongThucThanhToan +
                ", TenNguoiNhan='" + TenNguoiNhan + '\'' +
                ", SoDienThoai='" + SoDienThoai + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
