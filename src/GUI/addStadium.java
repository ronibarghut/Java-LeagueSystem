package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import GUI.MyInternalFrame;
import utils.E_Cities;

public class addStadium extends MyInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
	
	protected JTextField stadIDTextField = new JTextField();
	protected JTextField stadNameTextField = new JTextField();
	protected JComboBox<E_Cities> cityComboBox = new JComboBox<E_Cities>(E_Cities.values());
	protected JTextField streetTextField = new JTextField();
	protected JTextField houseNumTextField = new JTextField();
	protected JTextField phoneNumTextField = new JTextField();
	protected JTextField stadCapacityTextField = new JTextField();
	
	
	
	public addStadium() {
		super("Add Stadium");
		
		setBounds(70, 30, 700, 440); 
		
        desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        desktopPane.setBackground(Color.BLACK);
		this.setContentPane(desktopPane);
		
		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
	    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qq3.jpg"))); // NOI18N
	    jLabel1.setBounds(0, 0, this.getWidth(),this.getHeight());
	    desktopPane.add(jLabel1);
		
	    
	    
		final JLabel IDLabel = new JLabel("Stadium ID:");
		IDLabel.setFont(new Font("", Font.BOLD, 18));
		IDLabel.setBounds(200, 15, 137, 20);
		IDLabel.setForeground(Color.white);
		jLabel1.add(IDLabel);

		stadIDTextField.setFont(new Font("", Font.BOLD, 12));
		stadIDTextField.setBounds(200, 35, 228, 20);
		jLabel1.add(stadIDTextField);
		
		final JLabel nameLabel = new JLabel("Stadium Name:");
		nameLabel.setFont(new Font("", Font.BOLD, 18));
		nameLabel.setBounds(200, 55, 137, 20);
		nameLabel.setForeground(Color.WHITE);
		jLabel1.add(nameLabel);

		stadNameTextField.setFont(new Font("", Font.BOLD, 12));
		stadNameTextField.setBounds(200, 75, 228, 20);
		jLabel1.add(stadNameTextField);

		JLabel cityLabel = new JLabel("City:");
		cityLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		cityLabel.setBounds(200, 100, 137, 20);
		cityLabel.setForeground(Color.WHITE);
		jLabel1.add(cityLabel);

		cityComboBox.setFont(new Font("Dialog", Font.BOLD, 12));
		cityComboBox.setBounds(200, 120, 228, 20);
		jLabel1.add(cityComboBox);

		JLabel streetLabel = new JLabel("Street:");
		streetLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		streetLabel.setBounds(200, 145, 137, 20);
		jLabel1.add(streetLabel);

		streetTextField.setFont(new Font("Dialog", Font.BOLD, 12));
		streetTextField.setBounds(200, 165, 228, 20);
		jLabel1.add(streetTextField);

		JLabel houseNumLabel = new JLabel("House number:");
		houseNumLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		houseNumLabel.setBounds(200, 190, 157, 20);
		houseNumLabel.setForeground(Color.WHITE);
		jLabel1.add(houseNumLabel);

		houseNumTextField.setFont(new Font("Dialog", Font.BOLD, 12));
		houseNumTextField.setBounds(200, 210, 228, 20);
		jLabel1.add(houseNumTextField);

		JLabel phoneNumLabel = new JLabel("Phone Number:");
		phoneNumLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		phoneNumLabel.setBounds(200, 235, 177, 16);
		phoneNumLabel.setForeground(Color.WHITE);
		jLabel1.add(phoneNumLabel);

		phoneNumTextField.setFont(new Font("Dialog", Font.BOLD, 12));
		phoneNumTextField.setBounds(200, 255, 228, 20);
		jLabel1.add(phoneNumTextField);
		
		
		final JLabel CapLabel = new JLabel("Stadium Capacity:");
		CapLabel.setFont(new Font("", Font.BOLD, 18));
		CapLabel.setBounds(200, 280, 177, 20);
		CapLabel.setForeground(Color.WHITE);
		jLabel1.add(CapLabel);

		stadCapacityTextField.setFont(new Font("", Font.BOLD, 12));
		stadCapacityTextField.setBounds(200, 300, 228, 20);
		jLabel1.add(stadCapacityTextField);
		
		JButton addButton = new JButton("Add Stadium");
		addButton.setFont(new Font("", Font.BOLD, 12));
		addButton.addActionListener(this);
		addButton.setBounds(235, 350, 164, 20);
		addButton.setBackground(new Color(59, 89, 182));
		addButton.setForeground(Color.WHITE);
		addButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		addButton.setFocusPainted(false);
		jLabel1.add(addButton);
		
		JButton cancelButton = new JButton("Back");
		cancelButton.setFont(new Font("", Font.BOLD, 12));
		cancelButton.addActionListener(this);
		cancelButton.setBounds(35, 350, 94, 20);
		cancelButton.setBackground(new Color(59, 89, 182));
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		cancelButton.setFocusPainted(false);
		jLabel1.add(cancelButton);
		
		
	}

	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			if(arg0.getActionCommand().equals("Back")){
				this.dispose();
			}
			else if(arg0.getActionCommand().equals("Add Stadium")){
				if (sysData.addStadium(Integer.parseInt(stadIDTextField.getText()), stadNameTextField.getText(),Integer.parseInt(stadCapacityTextField.getText()),
					cityComboBox.getItemAt(cityComboBox.getSelectedIndex()),
							streetTextField.getText(), Integer.parseInt(houseNumTextField.getText()),
							new String[] {phoneNumTextField.getText()})) {
				messageBox.showInternalInformationMessage("Stadium " + stadIDTextField.getText()
						+ "\nwas successfully added to the system");
			} else {
				messageBox.showInternalErrorMessage("Failed to add Stadium " + stadIDTextField.getText()
						+ "\nto the system");
			}
		}
		}
		catch (Exception e) {
			messageBox.showInternalErrorMessage(e.getMessage());
		}
	}
	

}
