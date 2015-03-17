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
	private JTextField txtApp;

	public Panel4Title() {
		super("Title and Dock");
		
		chckbxDock = new JCheckBox("Display in dock (Enable UI Elements)");
		
		JLabel lblTitle = new JLabel("Title:");
		
		txtTitle = new JTextField();
		txtTitle.setText("Java Application");
		txtTitle.setColumns(10);
		
		JLabel lblFileName = new JLabel("File name:");
		
		txtApp = new JTextField();
		txtApp.setText("App");
		txtApp.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxDock)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblTitle)
								.addComponent(lblFileName))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtTitle)
								.addComponent(txtApp, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(198, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(chckbxDock)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTitle))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFileName)
						.addComponent(txtApp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	public String getAppTitle() {
		return txtTitle.getText().trim();
	}
	
	public String getAppName() {
		return txtApp.getText().trim();
	}
	
	public boolean enableUI() {
		return chckbxDock.isSelected();
	}
}
