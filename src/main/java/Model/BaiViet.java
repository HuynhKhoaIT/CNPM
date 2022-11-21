package Model;

import java.util.Date;

public class BaiViet {
    private int maBV;
    private String tieuDeBV;
    private String noiDung;
    private String anh;
    private Date ngayTao;
    private Date ngayCapNhat;

    public BaiViet(int maBV, String tieuDeBV, String noiDung, String anh, Date ngayTao, Date ngayCapNhat) {
        this.maBV = maBV;
        this.tieuDeBV = tieuDeBV;
        this.noiDung = noiDung;
        this.anh = anh;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
    }

    public BaiViet() {
    }

    public int getMaBV() {
        return maBV;
    }

    public void setMaBV(int maBV) {
        this.maBV = maBV;
    }

    public String getTieuDeBV() {
        return tieuDeBV;
    }

    public void setTieuDeBV(String tieuDeBV) {
        this.tieuDeBV = tieuDeBV;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(Date ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    @Override
    public String toString() {
        return "BaiViet{" +
                "maBV=" + maBV +
                ", tieuDeBV='" + tieuDeBV + '\'' +
                ", noiDung='" + noiDung + '\'' +
                ", anh='" + anh + '\'' +
                ", ngayTao=" + ngayTao +
                ", ngayCapNhat=" + ngayCapNhat +
                '}';
    }
}