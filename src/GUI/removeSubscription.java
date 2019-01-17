package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent; 
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel; 

public class removeSubscription  extends MyInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
	private JComboBox<Integer> SubComboBox = new JComboBox<Integer>(sysData.getSubsKeys());

	
	
	
	public removeSubscription() {
		super("Remove Subscription");
		
		setBounds(70, 30, 700, 440); 
		
        desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        desktopPane.setBackground(Color.BLACK);
		this.setContentPane(desktopPane);
		
		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
	    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qq3.jpg"))); // NOI18N
	    jLabel1.setBounds(0, 0, this.getWidth(),this.getHeight());
	    desktopPane.add(jLabel1);
		
	    final JLabel StadLabel = new JLabel("Subscription Number:");
		StadLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		StadLabel.setBounds(150, 71, 99, 20);
		StadLabel.setForeground(Color.WHITE);
		jLabel1.add(StadLabel);

		SubComboBox.setFont(new Font("Dialog", Font.BOLD, 12));
		SubComboBox.setBounds(265, 71, 241, 20);
		jLabel1.add(SubComboBox);
	    
		
		
		JButton RemoveButton = new JButton("Remove Subscription");
		RemoveButton.setFont(new Font("", Font.BOLD, 12));
		RemoveButton.addActionListener(this);
		RemoveButton.setBounds(235, 350, 164, 20);
		RemoveButton.setBackground(new Color(59, 89, 182));
		RemoveButton.setForeground(Color.WHITE);
		RemoveButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		RemoveButton.setFocusPainted(false);
		jLabel1.add(RemoveButton);
		
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
			else if(arg0.getActionCommand().equals("Remove Subscription")){
			if(SubComboBox.getSelectedIndex() == -1) {
				throw new Exception("No Subscription selected!");
			}
			int subscriptionId = SubComboBox.getItemAt(SubComboBox.getSelectedIndex());
				if(sysData.removeSubscription(subscriptionId)) {
					messageBox.showInternalInformationMessage("Subscription" + subscriptionId +
							"\nhas successfully been removed " );
				}
				else {
					messageBox.showInternalErrorMessage("Failed to Remove Subscription " + subscriptionId  );
				}
		
		}
		}
		catch(Exception e) {
			messageBox.showInternalErrorMessage(e.getMessage());
		}
		
	}
	
}
