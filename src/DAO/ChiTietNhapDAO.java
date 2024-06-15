package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.DonHang;
import model.nhaCungCap;

public class ChiTietNhapDAO {
    private static final Logger LOGGER = Logger.getLogger(ChiTietNhapDAO.class.getName());
    private MyConnect myConnect = new MyConnect();

    public ArrayList<DonHang> getListChiTietNhap() {
        ArrayList<DonHang> list = new ArrayList<>();
        String query = "SELECT * FROM ChiTietNhap";
        if(myConnect.openConnectDB()) {
        	        try (
             PreparedStatement statement = myConnect.conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int maDonHang = resultSet.getInt("maDH");
                int maNhaCungCap = resultSet.getInt("idNhaCungCap");
                String tenSanPham = resultSet.getString("tenSP");
                int soLuong = resultSet.getInt("SoLuong");
                float tongTien = resultSet.getFloat("ThanhTien");

                // Create nhaCungCap object by fetching its details
                nhaCungCap ncc = getNhaCungCapById(maNhaCungCap);

                // Create DonHang object and set its properties
                DonHang donHang = new DonHang();
                donHang.setMaDonHang(maDonHang);
                donHang.setNhaCungCap(ncc);
                donHang.setTenSanPham(tenSanPham);
                donHang.setSoLuong(soLuong);
                donHang.setTongTien(tongTien);

                list.add(donHang);
            }
            LOGGER.log(Level.INFO, "Data retrieval successful");

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error while retrieving data", e);
        }
        }


        return list;
    }

    public nhaCungCap getNhaCungCapById(int maNhaCungCap) {
        nhaCungCap ncc = null;
        String sql = "SELECT idNhaCungCap, tenNCC FROM nhaCungCap WHERE idNhaCungCap = ?";
        if(myConnect.openConnectDB()) {
        	try (
             PreparedStatement statement = myConnect.conn.prepareStatement(sql)) {
            
            statement.setInt(1, maNhaCungCap);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("idNhaCungCap");
                    String name = resultSet.getString("tenNCC");
                    ncc = new nhaCungCap(id, name);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error while retrieving supplier details", e);
        }
       }
        return ncc;
    }
}
