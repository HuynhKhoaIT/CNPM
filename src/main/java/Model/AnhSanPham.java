package Model;

public class AnhSanPham {
    int MaAnhSP;
    int MaSP;
    String Anh;

    public int getMaAnhSP() {
        return MaAnhSP;
    }

    public void setMaAnhSP(int maAnhSP) {
        MaAnhSP = maAnhSP;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int maSP) {
        MaSP = maSP;
    }

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String anh) {
        Anh = anh;
    }

    public AnhSanPham() {
    }

    public AnhSanPham(int maAnhSP, int maSP, String anh) {
        MaAnhSP = maAnhSP;
        MaSP = maSP;
        Anh = anh;
    }

    @Override
    public String toString() {
        return "AnhSanPham{" +
                "MaAnhSP=" + MaAnhSP +
                ", MaSP=" + MaSP +
                ", Anh='" + Anh + '\'' +
                '}';
    }
}
