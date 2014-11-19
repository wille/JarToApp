package com.redpois0n;

import javax.swing.UIManager;

public class Main {
	
	public static final String getVersion() {
		return "1.4";
	}

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		System.setProperty("line.separator", "\n");

		Frame frame = new Frame();
		
		frame.setVisible(true);
	}

}
