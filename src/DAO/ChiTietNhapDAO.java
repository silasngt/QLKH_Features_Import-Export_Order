package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.DonHang;
import model.nhaCungCap;

public class ChiTietNhapDAO {
	private MyConnect myConnect = new MyConnect();
	
	public ArrayList<DonHang> getListnCCById(int maDH) {
		ArrayList<DonHang> arr = new ArrayList<DonHang>();
		String sql = "SELECT * FROM ChiTietNhap WHERE idNhaCungCap = ?";
		if(myConnect.openConnectDB()) {
			try {
				PreparedStatement statement = myConnect.conn.prepareStatement(sql);
				statement.setInt(1, maDH);
				ResultSet resultSet = statement.executeQuery();
				while(resultSet.next()) {
					int maDonHang = resultSet.getInt("maDH");
					int maNhaCungCap = resultSet.getInt("idNhaCungCap");
					String tenNhaCungCap = resultSet.getString("tenNCC");
					String tenSanPham = resultSet.getString("tenSP");
					int soLuong = resultSet.getInt("SoLuong");
					float tongTien = resultSet.getFloat("ThanhTien");
					
					DonHang ctn = new DonHang();
					ctn.setMaDonHang(maDonHang);
					ctn.setMaNhaCungCap(maNhaCungCap);
//					ctn.setNhaCungCap(tenNhaCungCap);
					ctn.setTenSanPham(tenSanPham);
					ctn.setSoLuong(soLuong);
					ctn.setTongTien(tongTien);
					
					arr.add(ctn);
				}
				statement.close();
				resultSet.close();
				myConnect.closeConnectDB();
				
				return arr;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public String getTenNccById(int maNhaCungCap) {
		String tenNCC= null;
		String sql = "SELECT tenNCC FROM nhacungcap WHERE idNhaCungCap =?";
		try {
			PreparedStatement statement = myConnect.conn.prepareStatement(sql);
			statement.setInt(1, maNhaCungCap);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				tenNCC = resultSet.getString("tenNCC");
			}
			
            statement.close();
            resultSet.close();
            myConnect.closeConnectDB();
            
            return tenNCC;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
