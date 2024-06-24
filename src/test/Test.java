package test;

import javax.swing.SwingUtilities;

import controller.OrderController;
import view.OrderForm;

public class Test {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                OrderForm orderForm = new OrderForm();
                new OrderController(orderForm);
                orderForm.setVisible(true);
            }
        });
    }
}
