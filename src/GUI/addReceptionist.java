package GUI;

import java.awt.event.ActionEvent;

import Model.Address;
import GUI.addEmployee;

public class addReceptionist extends addEmployee {

	private static final long serialVersionUID = 1L;

	public addReceptionist() {
		super("Add Receptionist");
		addButton.setText("Add Receptionist");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			if(arg0.getActionCommand().equals("Back")){
				this.dispose();
			}
			else if(arg0.getActionCommand().equals("Add Receptionist")){
			if (sysData.addReceptionist(Integer.parseInt(idTextField.getText()), firstNameTextField.getText(), lastNameTextField.getText(),
					getBirthDate(), passwordTextField.getText(), getEmploymentDate(), 
					new Address(cityComboBox.getItemAt(cityComboBox.getSelectedIndex()),
							streetTextField.getText(), Integer.parseInt(houseNumTextField.getText()), new String[] {phoneNumTextField.getText()}))) {
				messageBox.showInternalInformationMessage("Receptionist " + idTextField.getText()
						+ "\nhas successfully been added to the system");
			} else {
				messageBox.showInternalErrorMessage("Failed to ad Receptionist " + idTextField.getText()
						+ "\nto the system");
			}
		}
		}
		catch (Exception e) {
			messageBox.showInternalErrorMessage(e.getMessage());
		}
	}

}
