package com.redpois0n.panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.redpois0n.Util;
import com.redpois0n.crypto.Crypto;

@SuppressWarnings("serial")
public class Panel3Encryption extends PanelBase {
	
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public Panel3Encryption() {
		super("Encryption");
		
		JLabel lblMinimumVersion = new JLabel("Minimum Version:");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMinimumVersion)
					.addContainerGap(388, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(76)
					.addComponent(lblMinimumVersion)
					.addContainerGap(87, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		update();
	}

	public String getKey() {
		return chckbxDefaultKey.isSelected() ? null : cbKey.getText().trim();
	}

	public boolean shouldEncryptAll() {
		return rdbtnEncryptResourcesAnd.isSelected();
	}
	
	public void update() {
		
		if (text.length() == Crypto.KEY_LENGTH) {
			cbKey.setBackground(Color.green);
		} else {
			cbKey.setBackground(Color.red);
		}
	}
}
