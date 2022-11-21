package Model;

public class DanhMuc {
    int MaDM;
    int MaLoai;
    String TenDM;

    public DanhMuc(int maDM, int maLoai, String tenDM) {
        MaDM = maDM;
        MaLoai = maLoai;
        TenDM = tenDM;
    }

    public DanhMuc() {
    }

    public int getMaDM() {
        return MaDM;
    }

    public void setMaDM(int maDM) {
        MaDM = maDM;
    }

    public int getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(int maLoai) {
        MaLoai = maLoai;
    }

    public String getTenDM() {
        return TenDM;
    }

    public void setTenDM(String tenDM) {
        TenDM = tenDM;
    }

    @Override
    public String toString() {
        return "DanhMuc{" +
                "MaDM=" + MaDM +
                ", MaLoai=" + MaLoai +
                ", TenDM='" + TenDM + '\'' +
                '}';
    }
}


