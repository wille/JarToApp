package com.redpois0n.panels;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URI;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.redpois0n.Build;
import com.redpois0n.Frame;

@SuppressWarnings("serial")
public class Panel6Build extends PanelBase {
	
	private JLabel lblFile;
	private File output;

	public Panel6Build() {
		super("Finished");
		
		lblFile = new JLabel("Loading...");
		
		JButton btnGoToFolder = new JButton("Go to folder");
		btnGoToFolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (output != null) {
					try {
						Desktop.getDesktop().open(new File(output.getParent()));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		JLabel lblHttpredpoisncom = new JLabel("http://redpois0n.com");
		lblHttpredpoisncom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Desktop.getDesktop().browse(new URI("http://redpois0n.com"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		lblHttpredpoisncom.setForeground(Color.BLUE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFile, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
								.addComponent(btnGoToFolder)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(332, Short.MAX_VALUE)
							.addComponent(lblHttpredpoisncom)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(lblFile)
					.addGap(18)
					.addComponent(btnGoToFolder)
					.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
					.addComponent(lblHttpredpoisncom)
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
	
	@Override
	public void opened() {
		try {		
			Panel1SelectJar p1 = (Panel1SelectJar) Frame.panels.get(0);
			Panel2MainClass p2 = (Panel2MainClass) Frame.panels.get(1);
			Panel3MinimumJava p3 = (Panel3MinimumJava) Frame.panels.get(2);
			Panel4Title p4 = (Panel4Title) Frame.panels.get(3);
			Panel5Create p5 = (Panel5Create) Frame.panels.get(4);
			
			File input = p1.getFile();
			File output = p5.getFile();
			File icon = p5.getIcon();
			String mainclass = p2.getMainClass();
			String title = p4.getAppTitle();
			boolean dockIcon = p4.enableUI();
			int minimumJava = p3.getMinimum();
			
			Build.build(input, output, icon, mainclass, title, dockIcon, minimumJava);
			lblFile.setText("File \"" + output.getAbsolutePath() + "\" successfully created.");
			
			this.output = output;
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERROR: " + ex.getClass().getSimpleName() + ": " + ex.getMessage(), "jCrypt", JOptionPane.ERROR_MESSAGE);
			Frame.instance.back();
		}
	}
}
