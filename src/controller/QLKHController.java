package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import DAO.ChiTietNhapDAO;
import model.DonHang;
import view.GUI;

public class QLKHController implements ActionListener{
	private GUI view;
	ChiTietNhapDAO ctnDAO = new ChiTietNhapDAO();
	
	public QLKHController() {
	
	}


	public QLKHController(GUI view) {
		this.view = view;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
//		JOptionPane.showMessageDialog(view, "Bạn vừa nhấn vào: "+ cm);
		if(cm.equals("Thêm")) {
			this.view.xoaForm();
			this.view.model.setLuaChon("Thêm");
		} else if(cm.equals("Lưu")) {
			try {
				this.view.thucHienThemDonHang();
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		} else if(cm.equals("Sửa")) {
			this.view.hienThiThongTinDonHangDaChon();
		} else if(cm.equals("Xóa")) {
			this.view.thucHienXoa();
		} else if(cm.equals("Hủy Bỏ")) {
			this.view.xoaForm();
		} else if(cm.equals("Tìm")) {
			this.view.thucHienTim();
		} else if(cm.equals("Hủy")) {
			this.view.thucHienTaiLaiDuLieu();
		} else if(cm.equals("Xuất File")) {
			this.view.thucHienXuatFile();
		} else if(cm.equals("Mở File")) {
			this.view.thucHienMoFile();
		}
		
	}
	public ArrayList<DonHang> getListnCCById(int maDH){
		return ctnDAO.getListnCCById(maDH);
	}
	public String getTenNccById(int maNhaCungCap) {
		return ctnDAO.getTenNccById(maNhaCungCap);
	}

}
