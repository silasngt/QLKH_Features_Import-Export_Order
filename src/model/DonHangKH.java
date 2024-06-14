package model;

import java.io.Serializable;
import java.util.Objects;

public class DonHangKH implements Serializable {
	private int maDonHang;
	private String tenKhachHang;
	private String tenSanPham;
	private int soLuong;
	private float TongTien;
	
	public DonHangKH() {
	}

	public DonHangKH(int maDonHang, String tenKhachHang, String tenSanPham, int soLuong, float tongTien) {
		this.maDonHang = maDonHang;
		this.tenKhachHang = tenKhachHang;
		this.tenSanPham = tenSanPham;
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

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
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
		return "DonHangKH [maDonHang=" + maDonHang + ", tenKhachHang=" + tenKhachHang + ", tenSanPham=" + tenSanPham
				+ ", soLuong=" + soLuong + ", TongTien=" + TongTien + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(TongTien, maDonHang, soLuong, tenKhachHang, tenSanPham);
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
				&& soLuong == other.soLuong && Objects.equals(tenKhachHang, other.tenKhachHang)
				&& Objects.equals(tenSanPham, other.tenSanPham);
	}
	
	
}
