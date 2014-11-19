package com.redpois0n.panels;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;


@SuppressWarnings("serial")
public class Panel4Title extends PanelBase {
	
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
