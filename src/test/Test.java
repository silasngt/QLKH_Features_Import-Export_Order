package test;

import javax.swing.UIManager;

import view.GUI;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new GUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
