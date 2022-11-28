package Model;

import java.util.Date;

public class SPBanChay {
	
	@Override
	public String toString() {
		return "SPBanChay [MaSP=" + MaSP + ", TenSP=" + TenSP + ", Soluong=" + Soluong + ", Tongtien=" + Tongtien + "]";
	}
	int MaSP;
    String TenSP;
    int Soluong;
    int Tongtien;
	public int getMaSP() {
		return MaSP;
	}
	public void setMaSP(int maSP) {
		MaSP = maSP;
	}
	public String getTenSP() {
		return TenSP;
	}
	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}
	public int getSoluong() {
		return Soluong;
	}
	public void setSoluong(int soluong) {
		Soluong = soluong;
	}
	public int getTongtien() {
		return Tongtien;
	}
	public void setTongtien(int tongtien) {
		Tongtien = tongtien;
	}
	public SPBanChay() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SPBanChay(int maSP, String tenSP, int soluong, int tongtien) {
		super();
		MaSP = maSP;
		TenSP = tenSP;
		Soluong = soluong;
		Tongtien = tongtien;
	}
    
    
}
