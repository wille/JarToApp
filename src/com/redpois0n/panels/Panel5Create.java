package com.redpois0n.panels;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.redpois0n.Util;


@SuppressWarnings("serial")
public class Panel5Create extends PanelBase {
	
	private JComboBox<Object> cbPath;
	private JComboBox<Object> cbIconPath;

	public Panel5Create() {
		super("Create .jar file");
		
		JLabel lblFilePathOf = new JLabel("File path of .jar to export");
		
		cbPath = new JComboBox<Object>();
		cbPath.setEditable(true);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = Util.showSaveDialog();
				if (file != null) {
					cbPath.setSelectedItem(file.getAbsolutePath() + ".app");
				}
			}
		});
		
		JLabel lblIconLocationicns = new JLabel("Icon location (.icns)");
		
		cbIconPath = new JComboBox<Object>();
		cbIconPath.setEditable(true);
		
		JButton btnBrowseIcon = new JButton("Browse");
		btnBrowseIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = Util.showSaveDialog();
				if (file != null) {
					cbIconPath.setSelectedItem(file.getAbsolutePath());
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(cbIconPath, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBrowseIcon, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblIconLocationicns)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(cbPath, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBrowse))
						.addComponent(lblFilePathOf))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(lblFilePathOf)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBrowse))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblIconLocationicns)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbIconPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBrowseIcon))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	public File getFile() {
		return new File(cbPath.getSelectedItem().toString());
	}
	
	public File getIcon() {
		if (cbIconPath.getSelectedItem() == null) {
			return null;
		}
		return new File(cbIconPath.getSelectedItem().toString());
	}
}
