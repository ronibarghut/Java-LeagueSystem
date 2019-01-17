package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Model.Address;
import utils.E_Position;

public class addPlayer extends addCoach {

	private static final long serialVersionUID = 1L;
	
	protected JComboBox<E_Position> playerPosComboBox = new JComboBox<E_Position>(E_Position.values());
	protected JCheckBox cc = new JCheckBox("Is Right Leg Kicker?"); 
	protected JTextField ValueTextField = new JTextField();
	
	public addPlayer(){
		super("Add Player");
		
		JLabel ppLabel = new JLabel("Player Position:");
		ppLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		ppLabel.setBounds(370, 200, 137, 20);
		ppLabel.setForeground(Color.WHITE);
		jLabel1.add(ppLabel);

		playerPosComboBox.setFont(new Font("Dialog", Font.BOLD, 12));
		playerPosComboBox.setBounds(370, 220, 228, 20);
		jLabel1.add(playerPosComboBox);

		cc.setBounds(370, 260, 228, 20);
		cc.setForeground(Color.BLACK);
		cc.setFont(new Font("Dialog", Font.BOLD,18));
	    cc.setMnemonic(KeyEvent.VK_C); 
	    cc.setSelected(false);
	    cc.setBackground(null);
	    jLabel1.add(cc);
		
		final JLabel valLable = new JLabel("Player Value:");
		valLable.setFont(new Font("", Font.BOLD, 16));
		valLable.setBounds(370, 300, 137, 20);
		valLable.setForeground(Color.WHITE);
		jLabel1.add(valLable);

		ValueTextField.setFont(new Font("", Font.BOLD, 12));
		ValueTextField.setBounds(370, 320, 228, 20);
		jLabel1.add(ValueTextField);
		
		addButton.setText("Add Player");
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			if(arg0.getActionCommand().equals("Back")){
				this.dispose();
			}
			else if(arg0.getActionCommand().equals("Add Player")){
			Boolean a = false;
			
			if(cc.isSelected()){
				a = true;
			}
			
			if (sysData.addPlayer (Integer.parseInt(idTextField.getText()), firstNameTextField.getText(), lastNameTextField.getText(),
					getBirthDate(), passwordTextField.getText(), getEmploymentDate(),
					coachLevelComboBox.getItemAt(coachLevelComboBox.getSelectedIndex()),
					Long.parseLong(ValueTextField.getText()),a,playerPosComboBox.getItemAt(playerPosComboBox.getSelectedIndex()) , 
					new Address(cityComboBox.getItemAt(cityComboBox.getSelectedIndex()),
							streetTextField.getText(), Integer.parseInt(houseNumTextField.getText()), 
							new String[] {phoneNumTextField.getText()}))) {
				messageBox.showInternalInformationMessage("Player " + idTextField.getText()
						+ "\nhas successfully been added to the system");
			} else {
				messageBox.showInternalErrorMessage("Failed to add Player " + idTextField.getText()
						+ "\nto the system");
			}
		}
		}
		catch (Exception e) {
			messageBox.showInternalErrorMessage(e.getMessage());
		}
		
	}
	
	
}
