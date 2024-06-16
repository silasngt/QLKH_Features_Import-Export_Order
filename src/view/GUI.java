package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import controller.QLKHController;
import controller.QLKHControllerKH;
import model.DonHang;
import model.DonHangKH;
import model.QLKHModel;
import model.nhaCungCap;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textField_ID;
	public JTextField textField_tenSp;
	public JTextField textField_soLuongSp;
	public JTextField textField_tongTien;
	public JTextField textField_TK_madon;
	public JTable table;
	public QLKHModel model;
	public JComboBox comboBox_tencungcap_1;
	public JComboBox comboBox_TK_tencungcap;
	private JTextField textField_xuat_madon;
	private JTextField textField_xuat_tenKH;
	private JTextField textField_xuat_tenSP;
	private JTextField textField_xuat_soLuong;
	private JTextField textField_xuat_thanhTien;
	private JTable table_xuat;
	private JTextField textField_TK_madon_xuat;
	private JTextField textField;
	private JTextField textField_TK_tenKH;
	private QLKHControllerKH ctxcontroller = new QLKHControllerKH();
	private QLKHController ctncontroller = new QLKHController();
	private DefaultTableModel model_table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		this.model = new QLKHModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		ActionListener action = new QLKHController(this);
		ActionListener action2 = new QLKHControllerKH(this);
		

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		RoundedPanel jPanelMenu = new RoundedPanel(50, Color.WHITE);
		jPanelMenu.setLayout(new BorderLayout(0, 0));
		contentPane.add(jPanelMenu, BorderLayout.WEST);
		

//		Phần menuBar chức năng
		JLabel labelHouse = new JLabel("");
		labelHouse.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("House.png")).getImage();
		labelHouse.setIcon(new ImageIcon(img));
		jPanelMenu.add(labelHouse);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
//		RoundedPanel panel = new RoundedPanel(50, Color.WHITE);
//		panel.setBackground(Color.WHITE);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(Box.createVerticalGlue());

		
		JLabel labelDH = new JLabel("Đơn Hàng");
		labelDH.setHorizontalAlignment(SwingConstants.CENTER);
		labelDH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Image imgDH = new ImageIcon(this.getClass().getResource("icon_DonHang.png")).getImage();
		Image sacledImgDH = imgDH.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		labelDH.setIcon(new ImageIcon(sacledImgDH));
		labelDH.setBounds(29, 88, 140, 50);
		panel.add(labelDH);
		
		labelDH.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JLabel labelTK = new JLabel("Tồn Kho");
		labelTK.setHorizontalAlignment(SwingConstants.CENTER);
		labelTK.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Image imgTK = new ImageIcon(this.getClass().getResource("icon_TonKho.png")).getImage();
		Image sacledImgTK = imgTK.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		labelTK.setIcon(new ImageIcon(sacledImgTK));
		labelTK.setBounds(29, 149, 140, 50);
		panel.add(labelTK);
		
		labelTK.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JLabel labelNX = new JLabel("Nhập/Xuất");
		labelNX.setHorizontalAlignment(SwingConstants.CENTER);
		labelNX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Image imgNX = new ImageIcon(this.getClass().getResource("icon_NhapXuat.png")).getImage();
		Image sacledImgNX = imgNX.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		labelNX.setIcon(new ImageIcon(sacledImgNX));
		labelNX.setBounds(29, 197, 140, 50);
		panel.add(labelNX);
		
		labelNX.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JLabel labelVT = new JLabel("Vị Trí Kho");
		labelVT.setHorizontalAlignment(SwingConstants.CENTER);
		labelVT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Image imgVT = new ImageIcon(this.getClass().getResource("icon_ViTri.png")).getImage();
		Image sacledImgVT = imgVT.getScaledInstance(40, 36, Image.SCALE_SMOOTH);
		labelVT.setIcon(new ImageIcon(sacledImgVT));
		labelVT.setBounds(29, 258, 140, 50);
		panel.add(labelVT);
		
		labelVT.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JLabel labelQT = new JLabel("Quản Trị");
		labelQT.setHorizontalAlignment(SwingConstants.CENTER);
		labelQT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Image imgQT = new ImageIcon(this.getClass().getResource("icon_QuanTri.png")).getImage();
		Image sacledImgQT = imgQT.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		labelQT.setIcon(new ImageIcon(sacledImgQT));
		labelQT.setBounds(29, 319, 140, 50);
		panel.add(labelQT);
		
		labelQT.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JLabel labelTKe = new JLabel("Thống kê");
		labelTKe.setHorizontalAlignment(SwingConstants.CENTER);
		labelTKe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Image imgTKe = new ImageIcon(this.getClass().getResource("icon_ThongKe.png")).getImage();
		Image sacledImgTKe = imgTKe.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		labelTKe.setIcon(new ImageIcon(sacledImgTKe));
		labelTKe.setBounds(29, 376, 140, 50);
		panel.add(labelTKe);
		
		labelTKe.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		panel.add(Box.createVerticalStrut(10));
		panel.add(Box.createVerticalGlue());
		
		jPanelMenu.add(labelHouse, BorderLayout.NORTH);
		jPanelMenu.add(panel, BorderLayout.CENTER);
		
		;
		
//		Phần chức năng Nhập/Xuất
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("");
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		Panel panel_1 = new Panel();
		panel_1.setLayout(null);
		tabbedPane.addTab("Quản lý nhập hàng", null, panel_1, null);
		
//		Phần nhập thông tin của chức năng NHẬP
		
		JLabel Label_NhapHang_1 = new JLabel("THÔNG TIN NHẬP HÀNG");
		Label_NhapHang_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		Label_NhapHang_1.setBounds(182, 4, 187, 33);
		panel_1.add(Label_NhapHang_1);
		
		JLabel Label_madon = new JLabel("Mã đơn hàng :");
		Label_madon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Label_madon.setBounds(63, 34, 92, 24);
		panel_1.add(Label_madon);
		
		JLabel Label_tencungcap = new JLabel("Tên nhà cung cấp  :");
		Label_tencungcap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Label_tencungcap.setBounds(31, 58, 120, 24);
		panel_1.add(Label_tencungcap);
		
		JLabel Label_tensp = new JLabel("Tên sản phẩm :");
		Label_tensp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Label_tensp.setBounds(57, 83, 92, 24);
		panel_1.add(Label_tensp);
		
		JLabel Label_soluongsp = new JLabel("Số lượng sản phẩm :");
		Label_soluongsp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Label_soluongsp.setBounds(30, 110, 120, 24);
		panel_1.add(Label_soluongsp);
		
		JLabel Label_tongtien = new JLabel("Tổng tiền :");
		Label_tongtien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Label_tongtien.setBounds(81, 137, 70, 24);
		panel_1.add(Label_tongtien);
		
		textField_ID = new JTextField();
		textField_ID.setColumns(10);
		textField_ID.setBounds(149, 38, 269, 20);
		panel_1.add(textField_ID);
		
		comboBox_tencungcap_1 = new JComboBox();
		ArrayList<nhaCungCap> listNhaCungCap = nhaCungCap.getDSNhaCungCap();
		comboBox_tencungcap_1.addItem("");
		for(nhaCungCap nCC : listNhaCungCap) {
			comboBox_tencungcap_1.addItem(nCC.getTenNhaCungCap());
		};
		
		comboBox_tencungcap_1.setBounds(149, 61, 269, 22);
		panel_1.add(comboBox_tencungcap_1);
		
		
		textField_tenSp = new JTextField();
		textField_tenSp.setColumns(10);
		textField_tenSp.setBounds(149, 86, 269, 20);
		panel_1.add(textField_tenSp);
		
		textField_soLuongSp = new JTextField();
		textField_soLuongSp.setColumns(10);
		textField_soLuongSp.setBounds(149, 112, 269, 20);
		panel_1.add(textField_soLuongSp);
		
		textField_tongTien = new JTextField();
		textField_tongTien.setColumns(10);
		textField_tongTien.setBounds(149, 138, 269, 20);
		panel_1.add(textField_tongTien);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(action);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThem.setBounds(28, 168, 89, 23);
		panel_1.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(action);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoa.setBounds(127, 168, 89, 23);
		panel_1.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(action);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSua.setBounds(229, 168, 89, 23);
		panel_1.add(btnSua);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(action);
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLuu.setBounds(327, 168, 89, 23);
		panel_1.add(btnLuu);
		
		JButton btnHuyBo = new JButton("Hủy Bỏ");
		btnHuyBo.addActionListener(action);
		btnHuyBo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHuyBo.setBounds(424, 168, 89, 23);
		panel_1.add(btnHuyBo);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(9, 200, 520, 2);
		panel_1.add(separator);
		
//		Phần bảng của chức năng NHẬP
		
		
		
		
		JLabel Label_dsDonNhap = new JLabel("Danh sách đơn nhập");
		Label_dsDonNhap.setFont(new Font("Tahoma", Font.BOLD, 13));
		Label_dsDonNhap.setBounds(13, 206, 140, 24);
		panel_1.add(Label_dsDonNhap);
		
		JButton btnXuatFile = new JButton("Xuất File");
		btnXuatFile.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXuatFile.addActionListener(action);
		btnXuatFile.setBounds(420, 204, 100, 23);
		panel_1.add(btnXuatFile);
		
		JButton btnMoFile = new JButton("Mở File");
		btnMoFile.addActionListener(action);
		btnMoFile.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMoFile.setBounds(317, 204, 100, 23);
		panel_1.add(btnMoFile);
		
		
		table = new JTable();
		model_table =new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"M\u00E3 \u0111\u01A1n h\u00E0ng", "T\u00EAn nh\u00E0 cung c\u1EA5p", "T\u00EAn s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng", "T\u1ED5ng ti\u1EC1n"
				}
			);
		table.setModel(model_table);
		loadDataToTableNhap();
		table.setRowHeight(25);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(11, 230, 520, 139);
		panel_1.add(scrollPane);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 381, 520, 2);
		panel_1.add(separator_1);
		
//		Phần chức năng tìm kiếm của chức năng NHẬP
		
		JLabel Label_madon_1 = new JLabel("Mã đơn hàng");
		Label_madon_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		Label_madon_1.setBounds(236, 389, 92, 24);
		panel_1.add(Label_madon_1);
		
		JLabel Label_tencungcap_1 = new JLabel("Tên nhà cung cấp  ");
		Label_tencungcap_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		Label_tencungcap_1.setBounds(10, 389, 119, 24);
		panel_1.add(Label_tencungcap_1);
		
		comboBox_TK_tencungcap = new JComboBox();
		comboBox_TK_tencungcap.addItem("");
		for(nhaCungCap nCC : listNhaCungCap) {
			comboBox_TK_tencungcap.addItem(nCC.getTenNhaCungCap());
		};
		comboBox_TK_tencungcap.setBounds(122, 391, 108, 22);
		panel_1.add(comboBox_TK_tencungcap);
		
		
		textField_TK_madon = new JTextField();
		textField_TK_madon.setColumns(10);
		textField_TK_madon.setBounds(323, 392, 76, 20);
		panel_1.add(textField_TK_madon);
		
		JButton btnTimKiem = new JButton("Tìm");
		btnTimKiem.addActionListener(action);
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTimKiem.setBounds(404, 391, 61, 23);
		panel_1.add(btnTimKiem);
		
		JButton btnHuyTim = new JButton("Hủy");
		btnHuyTim.addActionListener(action);
		btnHuyTim.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnHuyTim.setBounds(468, 391, 61, 23);
		panel_1.add(btnHuyTim);
		
		
//		PHẦN CHỨC NĂNG XUẤT
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Quản lý xuất hàng", null, panel_2, null);
		panel_2.setLayout(null);
		
		
//		Phần nhập thông tin của chức năng XUẤT
		
		JLabel lblNewLabel_thongTinXuat = new JLabel("THÔNG TIN XUẤT HÀNG");
		lblNewLabel_thongTinXuat.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_thongTinXuat.setBounds(182, 4, 187, 33);
		panel_2.add(lblNewLabel_thongTinXuat);
		
		JLabel lblNewLabel_xuat_madon = new JLabel("Mã đơn hàng :");
		lblNewLabel_xuat_madon.setBounds(50, 41, 90, 14);
		lblNewLabel_xuat_madon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2.add(lblNewLabel_xuat_madon);
		
		JLabel lblNewLabel_xuat_tenKH = new JLabel("Tên khách hàng :");
		lblNewLabel_xuat_tenKH.setBounds(32, 66, 112, 14);
		lblNewLabel_xuat_tenKH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2.add(lblNewLabel_xuat_tenKH);
		
		JLabel lblNewLabel_xuat_tenSP = new JLabel("Tên sản phẩm :");
		lblNewLabel_xuat_tenSP.setBounds(42, 92, 90, 14);
		lblNewLabel_xuat_tenSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2.add(lblNewLabel_xuat_tenSP);
		
		JLabel lblNewLabel_xuat_soLuong = new JLabel("Số lượng :");
		lblNewLabel_xuat_soLuong.setBounds(71, 116, 63, 14);
		lblNewLabel_xuat_soLuong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2.add(lblNewLabel_xuat_soLuong);
		
		JLabel lblNewLabel_xuat_thanhTien = new JLabel("Thành Tiền :");
		lblNewLabel_xuat_thanhTien.setBounds(57, 141, 78, 14);
		lblNewLabel_xuat_thanhTien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2.add(lblNewLabel_xuat_thanhTien);
		
		textField_xuat_madon = new JTextField();
		textField_xuat_madon.setBounds(138, 38, 260, 20);
		panel_2.add(textField_xuat_madon);
		textField_xuat_madon.setColumns(10);
		
		textField_xuat_tenKH = new JTextField();
		textField_xuat_tenKH.setBounds(138, 62, 260, 20);
		textField_xuat_tenKH.setColumns(10);
		panel_2.add(textField_xuat_tenKH);
		
		textField_xuat_tenSP = new JTextField();
		textField_xuat_tenSP.setBounds(138, 88, 260, 20);
		textField_xuat_tenSP.setColumns(10);
		panel_2.add(textField_xuat_tenSP);
		
		textField_xuat_soLuong = new JTextField();
		textField_xuat_soLuong.setBounds(138, 113, 260, 20);
		textField_xuat_soLuong.setColumns(10);
		panel_2.add(textField_xuat_soLuong);
		
		textField_xuat_thanhTien = new JTextField();
		textField_xuat_thanhTien.setBounds(138, 138, 260, 20);
		textField_xuat_thanhTien.setColumns(10);
		panel_2.add(textField_xuat_thanhTien);
		
		
		JButton btnThem_xuat = new JButton("Thêm");
		btnThem_xuat.setBounds(28, 168, 89, 23);
		btnThem_xuat.addActionListener(action2);
		btnThem_xuat.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(btnThem_xuat);
		
		JButton btnXoa_xuat = new JButton("Xóa");
		btnXoa_xuat.setBounds(127, 168, 89, 23);
		btnXoa_xuat.addActionListener(action2);
		btnXoa_xuat.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(btnXoa_xuat);
		
		JButton btnSua_xuat = new JButton("Sửa");
		btnSua_xuat.setBounds(229, 168, 89, 23);
		btnSua_xuat.addActionListener(action2);
		btnSua_xuat.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(btnSua_xuat);
		
		JButton btnLuu_xuat = new JButton("Lưu");
		btnLuu_xuat.setBounds(327, 168, 89, 23);
		btnLuu_xuat.addActionListener(action2);
		btnLuu_xuat.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(btnLuu_xuat);
		
		JButton btnHuyBo_xuat = new JButton("Hủy Bỏ");
		btnHuyBo_xuat.setBounds(424, 168, 89, 23);
		btnHuyBo_xuat.addActionListener(action2);
		btnHuyBo_xuat.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(btnHuyBo_xuat);
		
		JSeparator separator_xuat = new JSeparator();
		separator_xuat.setBounds(9, 200, 520, 2);
		panel_2.add(separator_xuat);
		
//		Phần bảng của chức năng XUẤT
		JLabel Label_dsDonXuat = new JLabel("Danh sách đơn xuất");
		Label_dsDonXuat.setBounds(13, 206, 140, 24);
		Label_dsDonXuat.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_2.add(Label_dsDonXuat);
		
		JButton btnXuatFile_xuat = new JButton("Xuất File");
		btnXuatFile_xuat.setBounds(420, 204, 100, 23);
		btnXuatFile_xuat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXuatFile_xuat.addActionListener(action2);
		panel_2.add(btnXuatFile_xuat);
		
		JButton btnMoFile_xuat = new JButton("Mở File");
		btnMoFile_xuat.setBounds(317, 204, 100, 23);
		btnMoFile_xuat.addActionListener(action2);
		btnMoFile_xuat.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(btnMoFile_xuat);
		
		
		table_xuat = new JTable();
		model_table =new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã đơn hàng","Tên khách hàng","Tên sản phẩm","Số lượng","Thành Tiền"
			}
		);
		table_xuat.setModel(model_table);
		loadDatatoTableXuat();
		table.setRowHeight(25);
		
		JScrollPane scrollPane_xuat = new JScrollPane(table_xuat);
		scrollPane_xuat.setBounds(11, 230, 520, 139);
		panel_2.add(scrollPane_xuat);
		
		
		
		JSeparator separator_xuat2 = new JSeparator();
		separator_xuat2.setBounds(10, 381, 520, 2);
		panel_2.add(separator_xuat2);
		
//		Phần tìm kiếm của chức năng XUẤT
		
		JLabel Label_madon_xuat_TK = new JLabel("Mã đơn hàng");
		Label_madon_xuat_TK.setBounds(236, 389, 92, 24);
		Label_madon_xuat_TK.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2.add(Label_madon_xuat_TK);
		
		JLabel Label_tenKhachHang = new JLabel("Tên khách hàng  ");
		Label_tenKhachHang.setBounds(10, 389, 119, 24);
		Label_tenKhachHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2.add(Label_tenKhachHang);
		
		
		
		
		textField_TK_madon_xuat = new JTextField();
		textField_TK_madon_xuat.setBounds(323, 392, 76, 20);
		textField_TK_madon_xuat.setColumns(10);
		panel_2.add(textField_TK_madon_xuat);
		
		JButton btnTimKiem_xuat = new JButton("Tìm");
		btnTimKiem_xuat.setBounds(404, 391, 61, 23);
		btnTimKiem_xuat.addActionListener(action2);
		btnTimKiem_xuat.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_2.add(btnTimKiem_xuat);
		
		JButton btnHuyTim_xuat = new JButton("Hủy");
		btnHuyTim_xuat.setBounds(468, 391, 61, 23);
		btnHuyTim_xuat.addActionListener(action);
		btnHuyTim_xuat.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_2.add(btnHuyTim_xuat);
		
		textField_TK_tenKH = new JTextField();
		textField_TK_tenKH.setBounds(112, 392, 120, 20);
		panel_2.add(textField_TK_tenKH);
		textField_TK_tenKH.setColumns(10);
		

	
		this.setVisible(true);
	}
	// PHẦN CHỨC NĂNG NHẬP
	public void xoaForm() {
		textField_ID.setText("");
		textField_tenSp.setText("");
		textField_soLuongSp.setText("");
		textField_tongTien.setText("");
		comboBox_tencungcap_1.setSelectedIndex(-1);
		
	}
	
	public void themDonHangVaoTable(DonHang dh) {
		DefaultTableModel model_table =(DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] {
				dh.getMaDonHang()+"",
				dh.getNhaCungCap().getTenNhaCungCap(),
				dh.getTenSanPham(),
				dh.getSoLuong()+"",
				dh.getTongTien()+""});
	}
	
	public void themHoacCapNhatDonHang(DonHang dh) {
		DefaultTableModel model_table =(DefaultTableModel) table.getModel();
		if(!this.model.kiemTraTonTai(dh)) {
			this.model.insert(dh);
		
			this.themDonHangVaoTable(dh);
		
		
		} else {
			this.model.update(dh);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0)+""; 
				if(id.equals(dh.getMaDonHang()+"")){
					model_table.setValueAt(dh.getMaDonHang()+"",i,0);
					model_table.setValueAt(dh.getNhaCungCap().getTenNhaCungCap()+"",i,1);
					model_table.setValueAt(dh.getTenSanPham(),i,2);
					model_table.setValueAt(dh.getSoLuong()+"",i,3);
					model_table.setValueAt(dh.getTongTien()+"",i,4);
				}
			}
		}
		
	}
	

	
	public  DonHang getDonHangDaChon() {
		DefaultTableModel model_table =(DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		model_table.getValueAt(i_row, 0);
		int maDonHang = Integer.valueOf(model_table.getValueAt(i_row, 0)+"");
		nhaCungCap nCC_2 = nhaCungCap.getnCCByTen(model_table.getValueAt(i_row, 1)+"");
		String tenSanPham = model_table.getValueAt(i_row, 2)+"";
		int soLuong = Integer.valueOf(model_table.getValueAt(i_row, 3)+"");
		float tongTien = Float.valueOf(model_table.getValueAt(i_row, 4)+"");
		
		DonHang dh = new DonHang(maDonHang, nCC_2, tenSanPham, soLuong, tongTien);
		return dh;
	}
	
	
	public void hienThiThongTinDonHangDaChon() {
		DonHang dh = getDonHangDaChon();
		
		this.textField_ID.setText(dh.getMaDonHang()+"");
		this.comboBox_tencungcap_1.setSelectedItem(dh.getNhaCungCap().getTenNhaCungCap());
		this.textField_tenSp.setText(dh.getTenSanPham()+"");
		this.textField_soLuongSp.setText(dh.getSoLuong()+"");
		this.textField_tongTien.setText(dh.getTongTien()+"");
	}
	

	public void thucHienXoa() {
		DefaultTableModel model_table =(DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this,"Bạn có chắc chắn xóa dòng đã chọn");
		if(luaChon == JOptionPane.YES_OPTION) {
			DonHang dh = getDonHangDaChon();
			this.model.delete(dh);
			model_table.removeRow(i_row);
		}
		
	}
	

	public void thucHienThemDonHang() {
		int maDonHang = Integer.valueOf(this.textField_ID.getText());
		int nhaCungCap_1 = this.comboBox_tencungcap_1.getSelectedIndex()-1;
		nhaCungCap nCC = nhaCungCap.getnCCById(nhaCungCap_1);
		String tenSanPham = this.textField_tenSp.getText();
		int soLuong = Integer.valueOf(this.textField_soLuongSp.getText());
		float tongTien = Float.valueOf(this.textField_tongTien.getText());
		
		DonHang dh = new DonHang(maDonHang, nCC, tenSanPham, soLuong, tongTien);
		this.themHoacCapNhatDonHang(dh);
		
	}
	
	

	public void thucHienTim() {
		
		this.thucHienTaiLaiDuLieu();
		
		int nhaCungCap_1 = this.comboBox_TK_tencungcap.getSelectedIndex()-1;
		String maDonHangTimKiem = this.textField_TK_madon.getText();
		DefaultTableModel model_table =(DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
		
		Set<Integer> idCuaDonHangCanXoa = new TreeSet<Integer>();
		if(nhaCungCap_1 >=0) {
			nhaCungCap nCC_daChon = nhaCungCap.getnCCById(nhaCungCap_1);
			for (int i = 0; i < soLuongDong; i++) {
				String tenNhaCungCap = model_table.getValueAt(i, 1)+"";
				String id = model_table.getValueAt(i, 0)+""; 
				if(!tenNhaCungCap.equals(nCC_daChon.getTenNhaCungCap())){
					idCuaDonHangCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		if(maDonHangTimKiem.length()>0) {
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0)+""; 
				if(!id.equals(maDonHangTimKiem)){
					idCuaDonHangCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		
		for (Integer idCanXoa : idCuaDonHangCanXoa) {
			System.out.println(idCanXoa);
			soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				
				String idTrongTable = model_table.getValueAt(i, 0)+""; 
				System.out.println("idTrongTable: "+idTrongTable);
				if(idTrongTable.equals(idCanXoa.toString())){
					System.out.println("Đã xóa: " + i);
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}
	
	
	public void thucHienTaiLaiDuLieu() {
		while (true) {
			
			DefaultTableModel model_table =(DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if(soLuongDong==0) 
				break;
			else
			{
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		for(DonHang dh : this.model.getDsDonHang()) {
			this.themDonHangVaoTable(dh);
		}
		
	}
	
	public void saveFile(String path) {
		try {
			this.model .setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (DonHang dh: this.model.getDsDonHang()) {
				oos.writeObject(dh);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void thucHienXuatFile() {
		if(this.model.getTenFile().length()>0) {
			saveFile(this.model.getTenFile());
		}else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			  } 
		  }
		
	}
	
	public void openFile(File file) {
		ArrayList<DonHang> ds = new  ArrayList<DonHang>();
		try {
			this.model .setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			DonHang dh = null;
			while((dh= (DonHang) ois.readObject())!=null) {
				ds.add(dh);
			}
			this.model.setDsDonHang(ds);
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDsDonHang(ds);
	}
	
	public void thucHienMoFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienTaiLaiDuLieu();
		  }     
		
	}
	public void loadDataToTableNhap() {
		ArrayList<DonHang> arr = new ArrayList<DonHang>();
		arr = ctncontroller.getListChiTietNhap();
		if (arr != null) {
            for (DonHang donHang : arr) {
                Vector<String> vec = new Vector<>();
                vec.add(String.valueOf(donHang.getMaDonHang()));
                if (donHang.getNhaCungCap() != null) {
                    vec.add(donHang.getNhaCungCap().getTenNhaCungCap());
                } else {
                    vec.add(""); // Hoặc thêm một giá trị mặc định khác nếu không có nhaCungCap
                } // Assuming nhaCungCap has getTenNCC() method
                vec.add(donHang.getTenSanPham());
                vec.add(String.valueOf(donHang.getSoLuong()));
                vec.add(String.valueOf(donHang.getTongTien()));
                model_table.addRow(vec);
            }
        }
    }
	
	
	
	
	//	PHẦN CHỨC NĂNG XUẤT
	public void xoaForm_xuat() {
		textField_xuat_madon.setText("");
		textField_xuat_tenKH.setText("");
		textField_xuat_tenSP.setText("");
		textField_xuat_soLuong.setText("");
		textField_xuat_thanhTien.setText("");
	}
	
	public void themDonHangVaoTable_xuat(DonHangKH dhKH) {
		DefaultTableModel model_table_xuat =(DefaultTableModel) table_xuat.getModel();
		model_table_xuat.addRow(new Object[] {
				dhKH.getMaDonHang()+"",
				dhKH.getTenKhachHang(),
				dhKH.getTenSanPham(),
				dhKH.getSoLuong()+"",
				dhKH.getTongTien()+""});
	}
	
	public void themHoacCapNhatDonHang_xuat(DonHangKH dhKH) {
		DefaultTableModel model_table_xuat =(DefaultTableModel) table_xuat.getModel();
		if(!this.model.kiemTraTonTai_xuat(dhKH)) {
			this.model.insert_xuat(dhKH);
		
			this.themDonHangVaoTable_xuat(dhKH);
		
		
		} else {
			this.model.update_xuat(dhKH);
			int soLuongDong_xuat = model_table_xuat.getRowCount();
			for (int i = 0; i < soLuongDong_xuat; i++) {
				String id = model_table_xuat.getValueAt(i, 0)+""; 
				if(id.equals(dhKH.getMaDonHang()+"")){
					model_table_xuat.setValueAt(dhKH.getMaDonHang()+"",i,0);
					model_table_xuat.setValueAt(dhKH.getTenKhachHang(),i,1);
					model_table_xuat.setValueAt(dhKH.getTenSanPham(),i,2);
					model_table_xuat.setValueAt(dhKH.getSoLuong()+"",i,3);
					model_table_xuat.setValueAt(dhKH.getTongTien()+"",i,4);
				}
			}
		}
		
	}
	
	public  DonHangKH getDonHangDaChon_xuat() {
		DefaultTableModel model_table_xuat =(DefaultTableModel) table_xuat.getModel();
		int i_row = table_xuat.getSelectedRow();
		model_table_xuat.getValueAt(i_row, 0);
		int maDonHang = Integer.valueOf(model_table_xuat.getValueAt(i_row, 0)+"");
		String tenKhachHang = model_table_xuat.getValueAt(i_row, 1)+"";
		String tenSanPham = model_table_xuat.getValueAt(i_row, 2)+"";
		int soLuong = Integer.valueOf(model_table_xuat.getValueAt(i_row, 3)+"");
		float thanhTien = Float.valueOf(model_table_xuat.getValueAt(i_row, 4)+"");
		
		DonHangKH dhKH = new DonHangKH(maDonHang, tenKhachHang, tenSanPham, soLuong, thanhTien);
		return dhKH;
	}
	public void hienThiThongTinDonHangDaChon_xuat() {
		DonHangKH dhKH = getDonHangDaChon_xuat();
		
		this.textField_xuat_madon.setText(dhKH.getMaDonHang()+"");
		this.textField_xuat_tenKH.setText(dhKH.getTenKhachHang()+"");
		this.textField_xuat_tenSP.setText(dhKH.getTenSanPham()+"");
		this.textField_xuat_soLuong.setText(dhKH.getSoLuong()+"");
		this.textField_xuat_thanhTien.setText(dhKH.getTongTien()+"");
	}
	public void thucHienXoa_xuat() {
		DefaultTableModel model_table_xuat =(DefaultTableModel) table_xuat.getModel();
		int i_row = table_xuat.getSelectedRow();
		int luaChon_xuat = JOptionPane.showConfirmDialog(this,"Bạn có chắc chắn xóa dòng đã chọn");
		if(luaChon_xuat == JOptionPane.YES_OPTION) {
			DonHangKH dhKH = getDonHangDaChon_xuat();
			this.model.delete_xuat(dhKH);
			model_table_xuat.removeRow(i_row);
		}
		
	}
	public void thucHienThemDonHang_xuat() {
		int maDonHang_xuat = Integer.valueOf(this.textField_xuat_madon.getText());
		String tenKhachHang_xuat = this.textField_xuat_tenKH.getText();
		String tenSanPham_xuat = this.textField_xuat_tenSP.getText();
		int soLuong_xuat = Integer.valueOf(this.textField_xuat_soLuong.getText());
		float thanhTien_xuat = Float.valueOf(this.textField_xuat_thanhTien.getText());
		
		DonHangKH dhKH = new DonHangKH(maDonHang_xuat, tenKhachHang_xuat, tenSanPham_xuat, soLuong_xuat, thanhTien_xuat);
		this.themHoacCapNhatDonHang_xuat(dhKH);
		
	}
public void thucHienTim_xuat() {
		
		this.thucHienTaiLaiDuLieu_xuat();
	    
	    String tenKhachHangTimKiem = this.textField_TK_tenKH.getText();
	    String maDonHangTimKiem = this.textField_TK_madon.getText();
	    DefaultTableModel model_table = (DefaultTableModel) table.getModel();
	    int soLuongDong = model_table.getRowCount();
	    
	    Set<Integer> idCuaDonHangCanXoa = new TreeSet<Integer>();

	   
	    if (tenKhachHangTimKiem.length()>0) {
	        for (int i = 0; i < soLuongDong; i++) {
	            String tenKhachHang = model_table.getValueAt(i, 1) + "";
	            String id = model_table.getValueAt(i, 0) + "";
	            if (!tenKhachHang.equals(tenKhachHangTimKiem)) {
	                idCuaDonHangCanXoa.add(Integer.valueOf(id));
	            }
	        }
	    }
	 
	    if (maDonHangTimKiem.length()>0) {
	        for (int i = 0; i < soLuongDong; i++) {
	            String id = model_table.getValueAt(i, 0) + "";
	            if (!id.equals(maDonHangTimKiem)) {
	                idCuaDonHangCanXoa.add(Integer.valueOf(id));
	            }
	        }
	    }
		
	    for (Integer idCanXoa : idCuaDonHangCanXoa) {
	        System.out.println(idCanXoa);
	        soLuongDong = model_table.getRowCount();
	        for (int i = 0; i < soLuongDong; i++) {
	            String idTrongTable = model_table.getValueAt(i, 0) + "";
	            System.out.println("idTrongTable: " + idTrongTable);
	            if (idTrongTable.equals(idCanXoa.toString())) {
	                System.out.println("Đã xóa: " + i);
	                try {
	                    model_table.removeRow(i);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	                break;
	            }
	        }
	    }
	}
	public void thucHienTaiLaiDuLieu_xuat() {
		while (true) {
			
			DefaultTableModel model_table_xuat =(DefaultTableModel) table_xuat.getModel();
			int soLuongDong_xuat = model_table_xuat.getRowCount();
			if(soLuongDong_xuat==0) 
				break;
			else
			{
				try {
					model_table_xuat.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		for(DonHangKH dhKH : this.model.getDsDonHangKH()) {
			this.themDonHangVaoTable_xuat(dhKH);
		}
		
	}
	public void saveFile_xuat(String path) {
		try {
			this.model .setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (DonHangKH dhKH: this.model.getDsDonHangKH()) {
				oos.writeObject(dhKH);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void thucHienXuatFile_xuat() {
		if(this.model.getTenFile().length()>0) {
			saveFile_xuat(this.model.getTenFile());
		}else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile_xuat(file.getAbsolutePath());
			  } 
		  }
		
	}
	public void openFile_xuat(File file) {
		ArrayList<DonHangKH> ds = new  ArrayList<DonHangKH>();
		try {
			this.model .setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			DonHangKH dhKH = null;
			while((dhKH= (DonHangKH) ois.readObject())!=null) {
				ds.add(dhKH);
			}
			this.model.setDsDonHangKH(ds);
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDsDonHangKH(ds);
	}
	public void thucHienMoFile_xuat() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile_xuat(file);
			thucHienTaiLaiDuLieu_xuat();
		  } 
		
	}
	
	public void loadDatatoTableXuat() {
		ArrayList<DonHangKH> arr = new ArrayList<>();
		arr = ctxcontroller.getListChiTietXuat();
		if(arr!=null) {
			for (DonHangKH donHangKH : arr) {
				Vector<String> vec = new Vector<String>();
				vec.add(donHangKH.getMaDonHang()+"");
				vec.add(donHangKH.getTenKhachHang());
				vec.add(donHangKH.getTenSanPham());
				vec.add(donHangKH.getSoLuong()+"");
				vec.add(donHangKH.getTongTien()+"");
				
				model_table.addRow(vec);
				
			}
		}
	}
	
	
	
	
	

}
