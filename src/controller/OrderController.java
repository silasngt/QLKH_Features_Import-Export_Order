package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Order;
import model.OrderDetail;
import view.OrderForm;
import view.ProductForm;

public class OrderController {
    private OrderForm hoaDon;
    private Map<String, ProductForm> chiTietHoaDonMap;
    private Map<String, Order> hoaDonMap;
    private int hoaDonCounter;

    public OrderController(OrderForm orderForm) {
        this.hoaDon = orderForm;
        this.chiTietHoaDonMap = new HashMap<>();
        this.hoaDonMap = new HashMap<>();
        this.hoaDonCounter = 1;

        this.hoaDon.getButton_TaoHoaDon().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createOrder();
            }
        });

        this.hoaDon.get_Button_ThemSanPham().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showProductForm();
            }
        });

        this.hoaDon.get_Button_XemChiTiet().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewOrderDetails();
            }
        });

        this.hoaDon.get_Button_HuyDon().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteOrder();
            }
        });
    }

    private void createOrder() {
        String orderId = hoaDon.getMaHoaDon().getText();
        String customerName = hoaDon.getTenKhachHang().getText();
        String exportDateString = hoaDon.getNgayXuat().getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date exportDate = null;
        try {
            exportDate = dateFormat.parse(exportDateString);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(hoaDon, "Sai định dạng ngày xuất. Hãy nhập đúng định dạng dd/MM/yyyy.");
            return;
        }

        String detailId = String.valueOf(hoaDonCounter);
        hoaDonCounter++;

        Order order = new Order(orderId, customerName, exportDate, detailId);
        hoaDonMap.put(orderId, order);
        hoaDon.getTableModel().addRow(new Object[]{orderId, customerName, dateFormat.format(exportDate), 0.0});
        ProductForm productForm = new ProductForm();
        chiTietHoaDonMap.put(orderId, productForm);

        productForm.get_Button_themSanPham().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProduct(productForm);
            }
        });

        productForm.getButton_xacNhanDon().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmOrder(productForm);
            }
        });

        JOptionPane.showMessageDialog(hoaDon, "Tạo hóa đơn thành công");
        resetOrderFormFields();
    }

    private void showProductForm() {
        int selectedRow = hoaDon.getOrderTable().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(hoaDon, "Hãy chọn 1 hóa đơn để thêm sản phẩm");
            return;
        }

        String orderId = (String) hoaDon.getTableModel().getValueAt(selectedRow, 0);
        ProductForm productForm = chiTietHoaDonMap.get(orderId);
        Order order = hoaDonMap.get(orderId);

        productForm.setChiTietHoaDon(orderId, order.getMaChiTietDonHang()); // Use the unique detail ID for the order
        productForm.setVisible(true);
    }

    private void addProduct(ProductForm productForm) {
        String orderId = productForm.get_Field_maHoaDon().getText();
        Order order = hoaDonMap.get(orderId);

        if (order == null) {
            JOptionPane.showMessageDialog(productForm, "Tạo một đơn hàng để thêm sản phẩm");
            return;
        }

        String detailId = productForm.get_Field_maChiTietDonHang().getText();
        String productId = productForm.get_Field_maSanPham().getText();
        String productName = productForm.get_Field_tenSanPham().getText();
        int quantity = Integer.parseInt(productForm.get_Field_soLuong().getText());
        double price = Double.parseDouble(productForm.get_Field_gia().getText());

        OrderDetail orderDetail = new OrderDetail(detailId, productId, productName, quantity, price);
        order.themChiTietHD(orderDetail);
        productForm.getTableModel().addRow(new Object[]{detailId, productId, productName, quantity, price});

        resetProductFormFields(productForm);
    }

    private void confirmOrder(ProductForm productForm) {
        String orderId = productForm.get_Field_maHoaDon().getText();
        Order order = hoaDonMap.get(orderId);
        if (order == null) {
            JOptionPane.showMessageDialog(productForm, "Không tìm thấy hóa đơn");
            return;
        }

        order.TinhToanTongTien();
        for (int i = 0; i < hoaDon.getTableModel().getRowCount(); i++) {
            if (hoaDon.getTableModel().getValueAt(i, 0).equals(orderId)) {
                hoaDon.getTableModel().setValueAt(order.getTongTien(), i, 3);
                break;
            }
        }

        JOptionPane.showMessageDialog(productForm, "Hóa đơn được xác nhận thành công");
        productForm.setVisible(false);
    }

    private void viewOrderDetails() {
        int selectedRow = hoaDon.getOrderTable().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(hoaDon, "Chọn một hóa đơn để xem chi tiết");
            return;
        }

        String orderId = (String) hoaDon.getTableModel().getValueAt(selectedRow, 0);
        Order order = hoaDonMap.get(orderId);
        ProductForm productForm = chiTietHoaDonMap.get(orderId);

        if (order == null || productForm == null) {
            JOptionPane.showMessageDialog(hoaDon, "Không tìm thấy chi tiết đơn hàng");
            return;
        }

        DefaultTableModel productTableModel = productForm.getTableModel();
        productTableModel.setRowCount(0);  // Clear existing rows
        for (OrderDetail detail : order.getChiTietHoaDon()) {
            productTableModel.addRow(new Object[]{
                detail.getmaChiTietDonHang(),
                detail.getmaSanPham(),
                detail.gettenSanPham(),
                detail.getsoLuong(),
                detail.getgiaSanPham()
            });
        }

        productForm.setVisible(true);
    }

    private void deleteOrder() {
        int selectedRow = hoaDon.getOrderTable().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(hoaDon, "Chọn một hóa đơn để xóa");
            return;
        }

        String orderId = (String) hoaDon.getTableModel().getValueAt(selectedRow, 0);
        hoaDonMap.remove(orderId);
        chiTietHoaDonMap.remove(orderId);
        hoaDon.getTableModel().removeRow(selectedRow);
        JOptionPane.showMessageDialog(hoaDon, "Hóa đơn được xóa thành công");
    }

    private void resetOrderFormFields() {
        hoaDon.getMaHoaDon().setText("");
        hoaDon.getTenKhachHang().setText("");
        hoaDon.getNgayXuat().setText("");
    }

    private void resetProductFormFields(ProductForm productForm) {
        productForm.get_Field_maSanPham().setText("");
        productForm.get_Field_tenSanPham().setText("");
        productForm.get_Field_soLuong().setText("");
        productForm.get_Field_gia().setText("");
    }
}
