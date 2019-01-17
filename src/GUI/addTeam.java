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

import utils.E_Levels;

public class addTeam extends MyInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
	protected JTextField teamIDTextField = new JTextField();
	protected JTextField teamNameTextField = new JTextField();
	protected JTextField teamValueTextField = new JTextField();
	protected JComboBox<E_Levels> teamLevelComboBox = new JComboBox<E_Levels>(E_Levels.values());
	protected JComboBox<Integer> stadsComboBox = new JComboBox<Integer>(sysData.getAllStadiums());
	
	
	
	
	
	
	
	public addTeam() {
		super("Add Team");
		
		setBounds(70, 30, 700, 440); 
        desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        desktopPane.setBackground(Color.BLACK);
		this.setContentPane(desktopPane);
		
		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
	    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qqq2.jpg"))); // NOI18N
	    jLabel1.setBounds(0, 0, this.getWidth(),this.getHeight());
	    desktopPane.add(jLabel1);
		
	    
		
		
		final JLabel teamIDLabel = new JLabel("Team ID:");
		teamIDLabel.setFont(new Font("", Font.BOLD, 12));
		teamIDLabel.setBounds(200, 15, 137, 20);
		teamIDLabel.setForeground(Color.white);
		jLabel1.add(teamIDLabel);
		
		teamIDTextField.setFont(new Font("", Font.BOLD, 12));
		teamIDTextField.setBounds(200, 35, 228, 20);
		jLabel1.add(teamIDTextField);
		
		final JLabel teamNameLabel = new JLabel("Team Name:");
		teamNameLabel.setFont(new Font("", Font.BOLD, 12));
		teamNameLabel.setBounds(200, 55, 137, 20);
		teamNameLabel.setForeground(Color.WHITE);
		jLabel1.add(teamNameLabel);
		
		teamNameTextField.setFont(new Font("", Font.BOLD, 12));
		teamNameTextField.setBounds(200, 75, 228, 20);
		jLabel1.add(teamNameTextField);
		
		JLabel teamValLabel = new JLabel("Team Value:");
		teamValLabel.setFont(new Font("", Font.BOLD, 12));
		teamValLabel.setBounds(200, 100, 137, 20);
		teamValLabel.setForeground(Color.WHITE);
		jLabel1.add(teamValLabel);

		teamValueTextField.setFont(new Font("", Font.BOLD, 12));
		teamValueTextField.setBounds(200, 120, 228, 20);
		jLabel1.add(teamValueTextField);
		
		JLabel teamLevelLabel = new JLabel("Team Level:");
		teamLevelLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		teamLevelLabel.setBounds(200, 145, 137, 20);
		teamLevelLabel.setForeground(Color.black);
		jLabel1.add(teamLevelLabel);
		
		teamLevelComboBox.setFont(new Font("Dialog", Font.BOLD, 12));
		teamLevelComboBox.setBounds(200, 165, 228, 20);
		jLabel1.add(teamLevelComboBox);
		
		JLabel teamStadLabel = new JLabel("Stadium ID:");
		teamStadLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		teamStadLabel.setBounds(200, 190, 157, 20);
		teamStadLabel.setForeground(Color.WHITE);
		jLabel1.add(teamStadLabel);
		
		stadsComboBox.setFont(new Font("Dialog", Font.BOLD, 12));
		stadsComboBox.setBounds(200, 210, 228, 20);
		jLabel1.add(stadsComboBox);
		
		JButton addButton = new JButton("Add Team");
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
			else if(arg0.getActionCommand().equals("Add Team")){ 
				if (sysData.addTeam(Integer.parseInt(teamIDTextField.getText()), teamNameTextField.getText(),Integer.parseInt(teamValueTextField.getText()),
					teamLevelComboBox.getItemAt(teamLevelComboBox.getSelectedIndex()), stadsComboBox.getItemAt(stadsComboBox.getSelectedIndex()))) {
				messageBox.showInternalInformationMessage("Team " + teamIDTextField.getText()
						+ "\nhas successfully been added to the system");
			} else {
				messageBox.showInternalErrorMessage("Failed to add team " + teamIDTextField.getText()
						+ "\nto the system");
			}
		}
		}
		catch (Exception e) {
			messageBox.showInternalErrorMessage(e.getMessage());
		}
		
	}
	
}
