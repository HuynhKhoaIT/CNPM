package Model;

public class LoaiSP {
    int MaLoai;
    String TenLoai;

    public LoaiSP() {
    }

    public LoaiSP(int maLoai, String tenLoai) {
        MaLoai = maLoai;
        TenLoai = tenLoai;
    }

    public int getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(int maLoai) {
        MaLoai = maLoai;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public void setTenLoai(String tenLoai) {
        TenLoai = tenLoai;
    }

    @Override
    public String toString() {
        return "LoaiSP{" +
                "MaLoai=" + MaLoai +
                ", TenLoai='" + TenLoai + '\'' +
                '}';
    }
}
