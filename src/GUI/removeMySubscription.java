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

public class removeMySubscription extends MyInternalFrame {

	private static final long serialVersionUID = 1L;
	private javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
	private JComboBox<Integer> SubComboBox;
	protected JTextField idTextField = new JTextField();
	private User user;
	
	public removeMySubscription(User u){
		super("Customer Removes a Subscription");
		this.user = u;
		setBounds(70, 30, 700, 440); 

		SubComboBox = new JComboBox<Integer>(sysData.getMySubsToRemove(this.user.getUser()));
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

		
		final JLabel MatchLabel = new JLabel("Subscription ID:");
		MatchLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		MatchLabel.setBounds(150, 71, 99, 20);
		MatchLabel.setForeground(Color.WHITE);
		jLabel1.add(MatchLabel);

		SubComboBox.setFont(new Font("Dialog", Font.BOLD, 12));
		SubComboBox.setBounds(265, 71, 241, 20);
		jLabel1.add(SubComboBox);
		
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
			String CustID = idTextField.getText();
			int matchID = SubComboBox.getItemAt(SubComboBox.getSelectedIndex());
				if(sysData.removeSubscription(matchID)) {
					messageBox.showInternalInformationMessage("Subscription " + matchID +
							"\nhas successfully been removed from Customer " + CustID);
				}
				else {
					messageBox.showInternalErrorMessage("Failed to remove Subscription " + matchID +
							"\nfrom Customer " + CustID);
				}
		}
		}
		catch(Exception e) {
			messageBox.showInternalErrorMessage(e.getMessage());
		}
		
	}
	
	
	
	
}
 