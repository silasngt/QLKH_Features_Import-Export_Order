package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.DonHangKH;

public class ChiTietXuatDAO {
	private MyConnect myConnect = new MyConnect();
	public ArrayList<DonHangKH> getListChiTietXuat(){
		ArrayList<DonHangKH> list = new ArrayList<DonHangKH>();
		String query = "SELECT * FROM ChiTietXuat";
		
		if(myConnect.openConnectDB()) {
			try {
				PreparedStatement statement = myConnect.conn.prepareStatement(query);
				ResultSet resultSet = statement.executeQuery();
				
				while(resultSet.next()) {
					int maDonHang = resultSet.getInt("maDH");
					String tenKhachHang = resultSet.getString("tenKH");
					String tenSanPham = resultSet.getString("tenSP");
					int soLuong = resultSet.getInt("SoLuong");
					float ThanhTien =resultSet.getFloat("ThanhTien");
					DonHangKH ctx = new DonHangKH();
					ctx.setMaDonHang(maDonHang);
					ctx.setTenKhachHang(tenKhachHang);
					ctx.setTenSanPham(tenSanPham);
					ctx.setSoLuong(soLuong);
					ctx.setTongTien(ThanhTien);
					
					list.add(ctx);
				}
				System.out.println("Yes");
				
				return list;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
