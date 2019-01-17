package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Model.User;

public class removeCustomersMatch extends MyInternalFrame {

	private static final long serialVersionUID = 1L;
	private javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
	private JComboBox<Integer> MatchComboBox = new JComboBox<Integer>(sysData.getMatchIDS());
	protected JTextField idTextField = new JTextField();
	private User user;
	
	public removeCustomersMatch(User u){
		super("Customer Removes a Match");
		this.user = u;
		setBounds(70, 30, 700, 440); 
		
        desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        desktopPane.setBackground(Color.BLACK);
		this.setContentPane(desktopPane);
		
		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
	    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qq3.jpg"))); // NOI18N
	    jLabel1.setBounds(0, 0, this.getWidth(),this.getHeight());
	    desktopPane.add(jLabel1);
		
		final JLabel customerIDLabel = new JLabel("Customer ID:");
		customerIDLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		customerIDLabel.setBounds(150, 20, 105, 20);
		customerIDLabel.setForeground(Color.WHITE);
		jLabel1.add(customerIDLabel);

		idTextField.setFont(new Font("Dialog", Font.BOLD, 12));
		idTextField.setBounds(265, 20, 241, 20);
		idTextField.setText(this.user.getUser());
		idTextField.setEditable(false);
		jLabel1.add(idTextField);

		
		final JLabel MatchLabel = new JLabel("Match ID:");
		MatchLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		MatchLabel.setBounds(150, 71, 99, 20);
		MatchLabel.setForeground(Color.WHITE);
		jLabel1.add(MatchLabel);

		MatchComboBox.setFont(new Font("Dialog", Font.BOLD, 12));
		MatchComboBox.setBounds(265, 71, 241, 20);
		jLabel1.add(MatchComboBox);

		JButton addButton = new JButton("Remove");
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
			else if(arg0.getActionCommand().equals("Remove")){
			if(MatchComboBox.getSelectedIndex() == -1) {
				throw new Exception("No Match selected!");
			}
			String CustID = idTextField.getText();
			int matchID = MatchComboBox.getItemAt(MatchComboBox.getSelectedIndex());
				if(sysData.RemoveCustomerFromMatch(CustID, matchID)) {
					messageBox.showInternalInformationMessage("Customer " + CustID +
							"\nhas successfully been removed from Match " + matchID);
				}
				else {
					messageBox.showInternalErrorMessage("Failed to remove Customer " + CustID +
							"\nfrom Match " + matchID);
				}
		}
		}
		catch(Exception e) {
			messageBox.showInternalErrorMessage(e.getMessage());
		}
		
	}
	
	
	
	
}
