package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;

public class addReceptionistToStadium  extends MyInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
	private JComboBox<Integer> RecComboBox = new JComboBox<Integer>(sysData.getRecepIDS());
	private JComboBox<Integer> StadComboBox = new JComboBox<Integer>(sysData.getAllStadiums());
	
	public addReceptionistToStadium(){
		super("Add Receptionist To Stadium");
		
		setBounds(70, 30, 700, 440); 
		
        desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        desktopPane.setBackground(Color.BLACK);
		this.setContentPane(desktopPane);
		
		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
	    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qq3.jpg"))); // NOI18N
	    jLabel1.setBounds(0, 0, this.getWidth(),this.getHeight());
	    desktopPane.add(jLabel1);
		
		
		final JLabel RecepLabel = new JLabel("Receptionist ID:");
		RecepLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		RecepLabel.setBounds(150, 20, 105, 20);
		RecepLabel.setForeground(Color.WHITE);
		jLabel1.add(RecepLabel);

		RecComboBox.setFont(new Font("Dialog", Font.BOLD, 12));
		RecComboBox.setBounds(265, 20, 241, 20);
		jLabel1.add(RecComboBox);
		
		final JLabel StadLabel = new JLabel("Stadium Number:");
		StadLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		StadLabel.setBounds(150, 71, 99, 20);
		StadLabel.setForeground(Color.WHITE);
		jLabel1.add(StadLabel);

		StadComboBox.setFont(new Font("Dialog", Font.BOLD, 12));
		StadComboBox.setBounds(265, 71, 241, 20);
		jLabel1.add(StadComboBox);

		JButton addButton = new JButton("Connect");
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
			else if(arg0.getActionCommand().equals("Connect")){
			if(RecComboBox.getSelectedIndex() == -1) {
				throw new Exception("No Receptionist selected!");
			}
			if(StadComboBox.getSelectedIndex() == -1) {
				throw new Exception("No Stadium selected!");
			}
			int recepID = RecComboBox.getItemAt(RecComboBox.getSelectedIndex());
			int StadNum = StadComboBox.getItemAt(StadComboBox.getSelectedIndex());
				if(sysData.addReceptionistToStadium(recepID, StadNum)) {
					messageBox.showInternalInformationMessage("Receptionist " + recepID +
							"\nhas successfully been added to Stadium " + StadNum);
				}
				else {
					messageBox.showInternalErrorMessage("Failed to add Receptionist " + recepID +
							"\nto Stadium " + StadNum);
				}
		}
		}
		catch(Exception e) {
			messageBox.showInternalErrorMessage(e.getMessage());
		}
		
	}
	
}
