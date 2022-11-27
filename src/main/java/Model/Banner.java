package Model;

public class Banner {
    private int maB;
    private String tieuDeB;
    private String anh;

    public Banner() {
    }

    public Banner(int maB, String tieuDeB, String anh) {
        this.maB = maB;
        this.tieuDeB = tieuDeB;
        this.anh = anh;
    }

    public int getMaB() {
        return maB;
    }

    public void setMaB(int maB) {
        this.maB = maB;
    }

    public String getTieuDeB() {
        return tieuDeB;
    }

    public void setTieuDeB(String tieuDeB) {
        this.tieuDeB = tieuDeB;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "maB=" + maB +
                ", tieuDeB='" + tieuDeB + '\'' +
                ", anh='" + anh + '\'' +
                '}';
    }
}
