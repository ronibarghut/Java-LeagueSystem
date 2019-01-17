package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Model.Subscription;
import Model.User;

public class RecepRemoveSub extends MyInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
	private JComboBox<Integer> SubComboBox;
	protected JTextField idTextField = new JTextField();
	private User user;
	
	
	
	public RecepRemoveSub(User u){
		super("Remove Subscription");
		this.user = u;
		setBounds(70, 30, 700, 440); 
        desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        desktopPane.setBackground(Color.BLACK);
		this.setContentPane(desktopPane);
		
		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
	    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qq3.jpg"))); // NOI18N
	    jLabel1.setBounds(0, 0, this.getWidth(),this.getHeight());
	    desktopPane.add(jLabel1);
	    
		final JLabel idLable = new JLabel("Customer ID:");
		idLable.setFont(new Font("", Font.BOLD, 12));
		idLable.setBounds(150, 110, 137, 20);
		idLable.setForeground(Color.white);
		jLabel1.add(idLable);
		
		idTextField.setFont(new Font("", Font.BOLD, 12));
		idTextField.setBounds(265, 110, 241, 20);
		jLabel1.add(idTextField);
		

		int RecepID = Integer.parseInt(this.user.getUser());
		Vector<Integer> vec = new Vector<Integer>();
		for(Subscription s : sysData.getAllSubsByMe(RecepID)){
			if(!vec.contains(s.getId())){
				vec.add(s.getId());
			}
		}
		SubComboBox = new JComboBox<Integer>(vec);
		
		
	    final JLabel StadLabel = new JLabel("Subscription Number:");
		StadLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		StadLabel.setBounds(150, 25, 99, 20);
		StadLabel.setForeground(Color.WHITE);
		jLabel1.add(StadLabel);

		SubComboBox.setFont(new Font("Dialog", Font.BOLD, 12));
		SubComboBox.setBounds(265, 25, 241, 20);
		jLabel1.add(SubComboBox);
	    
		SubComboBox.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
				  Subscription s = null;
				  ArrayList<Subscription> subs = sysData.getAllSubsByMe(RecepID);
				  int i = SubComboBox.getItemAt(SubComboBox.getSelectedIndex());
				  for(Subscription ss : subs){
					  if(ss.getId() == i){
						  s = ss;
					  }
				  }
				  idTextField.setText(s.getCustomer().getId());
				  idTextField.setEditable(false);
				  
				  
		        }
		});
		
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
