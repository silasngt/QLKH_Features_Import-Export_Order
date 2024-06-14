package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class nhaCungCap implements Serializable {
	private int maNhaCungCap;
	private String tenNhaCungCap;
	
	public nhaCungCap(int maNhaCungCap, String tenNhaCungCap) {
		this.maNhaCungCap = maNhaCungCap;
		this.tenNhaCungCap = tenNhaCungCap;
	}

	public int getMaNhaCungCap() {
		return maNhaCungCap;
	}

	public void setMaNhaCungCap(int maNhaCungCap) {
		this.maNhaCungCap = maNhaCungCap;
	}

	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}

	public void setTenNhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
	}

	@Override
	public String toString() {
		return "nhaCungCap [maNhaCungCap=" + maNhaCungCap + ", tenNhaCungCap=" + tenNhaCungCap + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNhaCungCap, tenNhaCungCap);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		nhaCungCap other = (nhaCungCap) obj;
		return maNhaCungCap == other.maNhaCungCap && Objects.equals(tenNhaCungCap, other.tenNhaCungCap);
	}
	public static ArrayList<nhaCungCap> getDSNhaCungCap(){
		String[] arr_nhaCungCap = {
				"Công Ty A",
				"Công Ty B",
				"Công Ty C",
				"Công Ty D",
				"Công Ty E",
				"Công Ty F",
				"Công Ty H",
				"Công Ty G",
				"Công Ty I",
				"Công Ty J",
				"Công Ty K"
		};
		ArrayList<nhaCungCap> listNhaCungCap = new ArrayList<nhaCungCap>();
		int i = 0;
		for (String tenNhaCungCap : arr_nhaCungCap) {
			nhaCungCap nCC = new nhaCungCap(i, tenNhaCungCap);
			listNhaCungCap.add(nCC);
		}
		return listNhaCungCap;
	}

	public static nhaCungCap getnCCById(int nhaCungCap_1) {
		
		return nhaCungCap.getDSNhaCungCap().get(nhaCungCap_1);
	}

	public static nhaCungCap getnCCByTen(String nhaCungCap_1) {
		ArrayList<nhaCungCap> listNhaCungCap = nhaCungCap.getDSNhaCungCap();
		for (nhaCungCap nhaCungCap2 : listNhaCungCap) {
			if(nhaCungCap2.tenNhaCungCap.equals(nhaCungCap_1)) {
				return nhaCungCap2;
			}
		}
		return null;
	}
	
	
}
