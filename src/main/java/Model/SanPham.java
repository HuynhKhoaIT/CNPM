package Model;

public class SanPham {
	int MaSP;
	int MaDM;
	String TenSP;
	String MoTa;
	int GiaGoc;
	int GiaBanThuong;
	int GiaKhuyenMai;
	int SoLuong;
	String Anh;

	String MoTaNgan;

	int isDeteted;

	int SoLuongDaBan;

	public SanPham() {
	}

	public SanPham(int maSP, int maDM, String tenSP, String moTa, int giaGoc, int giaBanThuong, int giaKhuyenMai, int soLuong, String anh, String moTaNgan, int isDeteted, int soLuongDaBan) {
		MaSP = maSP;
		MaDM = maDM;
		TenSP = tenSP;
		MoTa = moTa;
		GiaGoc = giaGoc;
		GiaBanThuong = giaBanThuong;
		GiaKhuyenMai = giaKhuyenMai;
		SoLuong = soLuong;
		Anh = anh;
		MoTaNgan = moTaNgan;
		this.isDeteted = isDeteted;
		SoLuongDaBan = soLuongDaBan;
	}

	public int getMaSP() {
		return MaSP;
	}

	public void setMaSP(int maSP) {
		MaSP = maSP;
	}

	public int getMaDM() {
		return MaDM;
	}

	public void setMaDM(int maDM) {
		MaDM = maDM;
	}

	public String getTenSP() {
		return TenSP;
	}

	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}

	public String getMoTa() {
		return MoTa;
	}

	public void setMoTa(String moTa) {
		MoTa = moTa;
	}

	public int getGiaGoc() {
		return GiaGoc;
	}

	public void setGiaGoc(int giaGoc) {
		GiaGoc = giaGoc;
	}

	public int getGiaBanThuong() {
		return GiaBanThuong;
	}

	public void setGiaBanThuong(int giaBanThuong) {
		GiaBanThuong = giaBanThuong;
	}

	public int getGiaKhuyenMai() {
		return GiaKhuyenMai;
	}

	public void setGiaKhuyenMai(int giaKhuyenMai) {
		GiaKhuyenMai = giaKhuyenMai;
	}

	public int getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}

	public String getAnh() {
		return Anh;
	}

	public void setAnh(String anh) {
		Anh = anh;
	}

	public String getMoTaNgan() {
		return MoTaNgan;
	}

	public void setMoTaNgan(String moTaNgan) {
		MoTaNgan = moTaNgan;
	}

	public int getIsDeteted() {
		return isDeteted;
	}

	public void setIsDeteted(int isDeteted) {
		this.isDeteted = isDeteted;
	}

	public int getSoLuongDaBan() {
		return SoLuongDaBan;
	}

	public void setSoLuongDaBan(int soLuongDaBan) {
		SoLuongDaBan = soLuongDaBan;
	}

	@Override
	public String toString() {
		return "SanPham{" +
				"MaSP=" + MaSP +
				", MaDM=" + MaDM +
				", TenSP='" + TenSP + '\'' +
				", MoTa='" + MoTa + '\'' +
				", GiaGoc=" + GiaGoc +
				", GiaBanThuong=" + GiaBanThuong +
				", GiaKhuyenMai=" + GiaKhuyenMai +
				", SoLuong=" + SoLuong +
				", Anh='" + Anh + '\'' +
				", MoTaNgan='" + MoTaNgan + '\'' +
				", isDeteted=" + isDeteted +
				", SoLuongDaBan=" + SoLuongDaBan +
				'}';
	}
}
