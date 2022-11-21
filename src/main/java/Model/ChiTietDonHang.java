package Model;

public class ChiTietDonHang {
    int MaDH;
    int MaSP;
    int SoLuong;
    int TongTien;

    public ChiTietDonHang(int maDH, int maSP, int soLuong, int tongTien) {
        MaDH = maDH;
        MaSP = maSP;
        SoLuong = soLuong;
        TongTien = tongTien;
    }

    public ChiTietDonHang() {
    }

    public int getMaDH() {
        return MaDH;
    }

    public void setMaDH(int maDH) {
        MaDH = maDH;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int maSP) {
        MaSP = maSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int tongTien) {
        TongTien = tongTien;
    }

    @Override
    public String toString() {
        return "ChiTietDonHang{" +
                "MaDH=" + MaDH +
                ", MaSP=" + MaSP +
                ", SoLuong=" + SoLuong +
                ", TongTien=" + TongTien +
                '}';
    }
}
