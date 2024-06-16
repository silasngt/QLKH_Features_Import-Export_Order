package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class DonHangKH implements Serializable {
	private int maDonHang;
	private String tenKhachHang;
	private String ngayXuat;
	private int soLuong;
	private float TongTien;
	
	public DonHangKH() {
	}

	public DonHangKH(int maDonHang, String tenKhachHang, String ngayXuat, int soLuong, float tongTien) {
		this.maDonHang = maDonHang;
		this.tenKhachHang = tenKhachHang;
		this.ngayXuat = ngayXuat;
		this.soLuong = soLuong;
		TongTien = tongTien;
	}

	public int getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(int maDonHang) {
		this.maDonHang = maDonHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}


	

	public String getNgayXuat() {
		return ngayXuat;
	}

	public void setNgayXuat(String ngayXuat) {
		this.ngayXuat = ngayXuat;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public float getTongTien() {
		return TongTien;
	}

	public void setTongTien(float tongTien) {
		TongTien = tongTien;
	}

	@Override
	public String toString() {
		return "DonHangKH [maDonHang=" + maDonHang + ", tenKhachHang=" + tenKhachHang + ", ngayXuat=" + ngayXuat
				+ ", soLuong=" + soLuong + ", TongTien=" + TongTien + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(TongTien, maDonHang, ngayXuat, soLuong, tenKhachHang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DonHangKH other = (DonHangKH) obj;
		return Float.floatToIntBits(TongTien) == Float.floatToIntBits(other.TongTien) && maDonHang == other.maDonHang
				&& Objects.equals(ngayXuat, other.ngayXuat) && soLuong == other.soLuong
				&& Objects.equals(tenKhachHang, other.tenKhachHang);
	}

	
}
