package Model;

public class DanhMuc {
    int MaDM;
    int MaLoai;
    String TenDM;

    int isDeleted;

    public DanhMuc() {
    }

    public DanhMuc(int maDM, int maLoai, String tenDM, int isDeleted) {
        MaDM = maDM;
        MaLoai = maLoai;
        TenDM = tenDM;
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "DanhMuc{" +
                "MaDM=" + MaDM +
                ", MaLoai=" + MaLoai +
                ", TenDM='" + TenDM + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
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

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}


