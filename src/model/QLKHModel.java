package model;

import java.util.ArrayList;

public class QLKHModel {
	private ArrayList<DonHang> dsDonHang;
	private ArrayList<DonHangKH> dsDonHangKH;
	private String luaChon;
	private String tenFile;

	public QLKHModel() {
		this.dsDonHang = new ArrayList<DonHang>();
		this.dsDonHangKH = new ArrayList<DonHangKH>();
		this.luaChon ="";
		this.tenFile ="";
	}

	public QLKHModel(ArrayList<DonHang> dsDonHang) {
		this.dsDonHang = dsDonHang;
		this.dsDonHangKH = dsDonHangKH;
	}

	public ArrayList<DonHang> getDsDonHang() {
		return dsDonHang;
	}

	public void setDsDonHang(ArrayList<DonHang> dsDonHang) {
		this.dsDonHang = dsDonHang;
	}
	
	public void insert(DonHang donHang) {
		this.dsDonHang.add(donHang);
	}
	public void delete(DonHang donHang) {
		this.dsDonHang.remove(donHang);
	}
	public void update(DonHang donHang) {
		this.dsDonHang .remove(donHang);
		this.dsDonHang.add(donHang);
	}
	public void insert_xuat(DonHangKH donHangKH) {
		this.dsDonHangKH.add(donHangKH);
	}
	public void delete_xuat(DonHangKH donHangKH) {
		this.dsDonHangKH.remove(donHangKH);
	}
	public void update_xuat(DonHangKH donHangKH) {
		this.dsDonHangKH .remove(donHangKH);
		this.dsDonHangKH.add(donHangKH);
	}

	public ArrayList<DonHangKH> getDsDonHangKH() {
		return dsDonHangKH;
	}

	public void setDsDonHangKH(ArrayList<DonHangKH> dsDonHangKH) {
		this.dsDonHangKH = dsDonHangKH;
	}

	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public boolean kiemTraTonTai(DonHang dh) {
		for (DonHang donHang : dsDonHang) {
			if(donHang.getMaDonHang() == dh.getMaDonHang()) {
				return true;
			}
		}
		return false;
	}
	public boolean kiemTraTonTai_xuat(DonHangKH dhKH) {
		for (DonHangKH donHangKH : dsDonHangKH) {
			if(donHangKH.getMaDonHang() == dhKH.getMaDonHang()) {
				return true;
			}
		}
		return false;
	}
	

	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}
	
}
