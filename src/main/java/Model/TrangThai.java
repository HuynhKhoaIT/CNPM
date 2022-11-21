package Model;

public class TrangThai {
    int MaTrangThai;
    String TenTrangThai;

    public TrangThai(int maTrangThai, String tenTrangThai) {
        MaTrangThai = maTrangThai;
        TenTrangThai = tenTrangThai;
    }

    public TrangThai() {
    }

    public int getMaTrangThai() {
        return MaTrangThai;
    }

    public void setMaTrangThai(int maTrangThai) {
        MaTrangThai = maTrangThai;
    }

    public String getTenTrangThai() {
        return TenTrangThai;
    }

    public void setTenTrangThai(String tenTrangThai) {
        TenTrangThai = tenTrangThai;
    }
}
