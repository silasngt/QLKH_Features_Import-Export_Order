package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.ChiTietXuatDAO;
import model.DonHangKH;
import view.GUI;

public class QLKHControllerKH implements ActionListener {
	
	private GUI view2;
	private ChiTietXuatDAO ctxDAO = new ChiTietXuatDAO();
	
	
	public QLKHControllerKH() {
		
	}

	public QLKHControllerKH(GUI view2) {
		this.view2 = view2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		JOptionPane.showMessageDialog(view2, "Bạn vừa nhấn vào: "+ cm);
		if(cm.equals("Thêm")) {
			this.view2.xoaForm_xuat();
			this.view2.model.setLuaChon("Thêm");
		} else if(cm.equals("Lưu")) {
			try {
				this.view2.thucHienThemDonHang_xuat();
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		} else if(cm.equals("Sửa")) {
			this.view2.hienThiThongTinDonHangDaChon_xuat();
		} else if(cm.equals("Xóa")) {
			this.view2.thucHienXoa_xuat();
		} else if(cm.equals("Hủy Bỏ")) {
			this.view2.xoaForm_xuat();
		} else if(cm.equals("Tìm")) {
			this.view2.thucHienTim_xuat();
		} else if(cm.equals("Hủy")) {
			this.view2.thucHienTaiLaiDuLieu_xuat();
		} else if(cm.equals("Xuất File")) {
			this.view2.thucHienXuatFile_xuat();
		} else if(cm.equals("Mở File")) {
			this.view2.thucHienMoFile_xuat();
		}
		
	}
//	Hàm giúp lấy dữ liệu để connect với database
	public ArrayList<DonHangKH> getListChiTietXuat(){
		return ctxDAO.getListChiTietXuat();
	}

}
