package com.redpois0n.panels;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;

import com.redpois0n.ClassSelectEvent;
import com.redpois0n.DialogSelectClass;
import javax.swing.JCheckBox;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class Panel4Title extends PanelBase {
	private DefaultListModel<String> model = new DefaultListModel<String>();
	private JCheckBox chckbxDock;
	private JTextField txtTitle;

	public Panel4Title() {
		super("Title and Dock");
		
		chckbxDock = new JCheckBox("Display in dock (Enable UI Elements)");
		
		JLabel lblTitle = new JLabel("Title:");
		
		txtTitle = new JTextField();
		txtTitle.setText("Java Application");
		txtTitle.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTitle)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTitle))
						.addComponent(chckbxDock))
					.addContainerGap(220, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(chckbxDock)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitle)
						.addComponent(txtTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	public String getTitle() {
		return txtTitle.getText().trim();
	}
	
	public boolean enableUI() {
		return chckbxDock.isSelected();
	}
}
