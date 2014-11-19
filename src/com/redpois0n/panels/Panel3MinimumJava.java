package com.redpois0n.panels;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class Panel3MinimumJava extends PanelBase {
	
	private JComboBox<String> comboBox;

	public Panel3MinimumJava() {
		super("Encryption");
		
		JLabel lblMinimumVersion = new JLabel("Minimum Version:");
		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
	    model.addElement("1.0");
	    model.addElement("1.1");
	    model.addElement("1.2");
	    model.addElement("1.3");
	    model.addElement("1.4");
	    model.addElement("1.5");
	    model.addElement("1.6");
	    model.addElement("1.7");
	    model.addElement("1.8");
		
		comboBox = new JComboBox<String>(model);
		comboBox.setSelectedIndex(6);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMinimumVersion)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(232, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(76)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMinimumVersion)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(87, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	public int getMinimum() {
		return comboBox.getSelectedIndex() + 1;
	}
	
}
