package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import GUI.addEmployee;
import Model.Address;
import utils.E_Levels;

public class addCoach extends addEmployee {

	private static final long serialVersionUID = 1L;
	
	protected JComboBox<E_Levels> coachLevelComboBox = new JComboBox<E_Levels>(E_Levels.values());
	
	public addCoach() {
		super("Add Coach");
		
		JLabel coachLevelLabel = new JLabel("Level:");
		coachLevelLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		coachLevelLabel.setBounds(370, 145, 137, 20);
		coachLevelLabel.setForeground(Color.WHITE);
		jLabel1.add(coachLevelLabel);

		coachLevelComboBox.setFont(new Font("Dialog", Font.BOLD, 12));
		coachLevelComboBox.setBounds(370, 165, 228, 20);
		jLabel1.add(coachLevelComboBox);
		
		addButton.setText("Add Coach");
		
	}





	public addCoach(String string) {
		super(string);
		JLabel coachLevelLabel = new JLabel("Coach Level:");
		coachLevelLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		coachLevelLabel.setBounds(370, 145, 137, 20);
		coachLevelLabel.setForeground(Color.WHITE);
		jLabel1.add(coachLevelLabel);

		coachLevelComboBox.setFont(new Font("Dialog", Font.BOLD, 12));
		coachLevelComboBox.setBounds(370, 165, 228, 20);
		jLabel1.add(coachLevelComboBox);
		
		addButton.setText("Add Coach");
		
		
		
	}





	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			if(arg0.getActionCommand().equals("Back")){
				this.dispose();
			}
			else if(arg0.getActionCommand().equals("Add Coach")){
			if (sysData.addCoach (Integer.parseInt(idTextField.getText()), firstNameTextField.getText(), lastNameTextField.getText(),
					getBirthDate(), passwordTextField.getText(), getEmploymentDate(),
					coachLevelComboBox.getItemAt(coachLevelComboBox.getSelectedIndex()),
					new Address(cityComboBox.getItemAt(cityComboBox.getSelectedIndex()),
							streetTextField.getText(), Integer.parseInt(houseNumTextField.getText()), 
							new String[] {phoneNumTextField.getText()}))) {
				messageBox.showInternalInformationMessage("Coach " + idTextField.getText()
						+ "\nhas successfully been added to the system");
			} else {
				messageBox.showInternalErrorMessage("Failed to add coach " + idTextField.getText()
						+ "\nto the system");
			}
		}
		}
		catch (Exception e) {
			messageBox.showInternalErrorMessage(e.getMessage());
		}
		
	}
}
