package model;

import java.io.Serializable;
import java.util.Objects;

public class DonHang implements Serializable {
	private int maDonHang;
	private int maNhaCungCap;
	private nhaCungCap nhaCungCap;
	private String tenSanPham;
	private String ngayNhap;
	public String getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	private int soLuong;
	private float TongTien;
	public DonHang() {
		
	}
	public DonHang(int maDonHang, model.nhaCungCap nhaCungCap, String tenSanPham, String ngayNhap,int soLuong, float tongTien) {
		this.maDonHang = maDonHang;
		this.nhaCungCap = nhaCungCap;
		this.tenSanPham = tenSanPham;
		this.ngayNhap = ngayNhap;
		this.soLuong = soLuong;
		TongTien = tongTien;
	}
	public int getMaDonHang() {
		return maDonHang;
	}
	public void setMaDonHang(int maDonHang) {
		this.maDonHang = maDonHang;
	}
	public nhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}
	public void setNhaCungCap(nhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
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
	public int hashCode() {
		return Objects.hash(TongTien, maDonHang, maNhaCungCap, ngayNhap, nhaCungCap, soLuong, tenSanPham);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DonHang other = (DonHang) obj;
		return Float.floatToIntBits(TongTien) == Float.floatToIntBits(other.TongTien) && maDonHang == other.maDonHang
				&& maNhaCungCap == other.maNhaCungCap && Objects.equals(ngayNhap, other.ngayNhap)
				&& Objects.equals(nhaCungCap, other.nhaCungCap) && soLuong == other.soLuong
				&& Objects.equals(tenSanPham, other.tenSanPham);
	}
	@Override
	public String toString() {
		return "DonHang [maDonHang=" + maDonHang + ", maNhaCungCap=" + maNhaCungCap + ", nhaCungCap=" + nhaCungCap
				+ ", tenSanPham=" + tenSanPham + ", ngayNhap=" + ngayNhap + ", soLuong=" + soLuong + ", TongTien="
				+ TongTien + "]";
	}
	public int getMaNhaCungCap() {
		return maNhaCungCap;
	}
	public void setMaNhaCungCap(int maNhaCungCap) {
		this.maNhaCungCap = maNhaCungCap;
	}
	
	
	
	
}
