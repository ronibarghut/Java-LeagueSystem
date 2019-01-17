package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;

public class addPlayerToTeam  extends MyInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
	private JComboBox<Integer> playerComboBox = new JComboBox<Integer>(sysData.getPlayersIDS());
	private JComboBox<Integer> teamComboBox = new JComboBox<Integer>(sysData.getTeamNums());
	
	public addPlayerToTeam(){
		super("Add Player To Team");
		
		setBounds(70, 30, 700, 440); 
		
        desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        desktopPane.setBackground(Color.BLACK);
		this.setContentPane(desktopPane);
		
		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
	    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qq3.jpg"))); // NOI18N
	    jLabel1.setBounds(0, 0, this.getWidth(),this.getHeight());
	    desktopPane.add(jLabel1);
		
		final JLabel playerLabel = new JLabel("Player ID:");
		playerLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		playerLabel.setBounds(150, 20, 105, 20);
		playerLabel.setForeground(Color.WHITE);
		jLabel1.add(playerLabel);

		playerComboBox.setFont(new Font("Dialog", Font.BOLD, 12));
		playerComboBox.setBounds(265, 20, 241, 20);
		jLabel1.add(playerComboBox);
		
		final JLabel TeamLabel = new JLabel("Team ID:");
		TeamLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		TeamLabel.setBounds(150, 71, 99, 20);
		TeamLabel.setForeground(Color.WHITE);
		jLabel1.add(TeamLabel);

		teamComboBox.setFont(new Font("Dialog", Font.BOLD, 12));
		teamComboBox.setBounds(265, 71, 241, 20);
		jLabel1.add(teamComboBox);

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
			if(playerComboBox.getSelectedIndex() == -1) {
				throw new Exception("No Player selected!");
			}
			if(teamComboBox.getSelectedIndex() == -1) {
				throw new Exception("No Team selected!");
			}
			int PlayerID = playerComboBox.getItemAt(playerComboBox.getSelectedIndex());
			int TeamNum = teamComboBox.getItemAt(teamComboBox.getSelectedIndex());
				if(sysData.addPlayerToTeam(PlayerID, TeamNum)) {
					messageBox.showInternalInformationMessage("Player " + PlayerID +
							"\nhas successfully been added to team " + TeamNum);
				}
				else {
					messageBox.showInternalErrorMessage("Failed to add Player " + PlayerID +
							"\nto team " + TeamNum);
				}
		}
		}
		catch(Exception e) {
			messageBox.showInternalErrorMessage(e.getMessage());
		}
		
	}
	

}
