package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Model.Address;
import Model.Customer; 
import Model.Team;
import Model.User;
import utils.E_Cities;
import utils.E_Levels;

public class updateCustomerInfo extends MyInternalFrame {

	private static final long serialVersionUID = 1L;
	protected javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
	private JComboBox<String> CustsComboBox;
	protected JTextField firstNameTextField = new JTextField();
	protected JTextField lastNameTextField = new JTextField();
	protected JPasswordField passwordTextField = new JPasswordField();
	protected JComboBox<E_Cities> cityComboBox = new JComboBox<E_Cities>(E_Cities.values());
	protected JTextField streetTextField = new JTextField();
	protected JTextField houseNumTextField = new JTextField();
	protected JTextField phoneNumTextField = new JTextField();
	protected JComboBox<Integer> TeamsCombo = new JComboBox<Integer>(sysData.getAllTeams());
	protected JComboBox<Integer> dayComboBox = new 
			JComboBox<Integer>(getNumbersInRange(1, 31));
	protected JComboBox<Integer> monthComboBox = new 
			JComboBox<Integer>(getNumbersInRange(1, 12));
	protected JComboBox<Integer> yearComboBox = new 
			JComboBox<Integer>(getNumbersInRangeReverse(1920, 2017));
	
	protected JComboBox<E_Levels> levelComboBox = new JComboBox<E_Levels>(E_Levels.values());
	protected JTextField emailTextField = new JTextField();
	private User user;
	/**
	 * Constructor for AddCustomer class
	 * 
	 */
	public updateCustomerInfo(User u){
		super("Update Player Info");
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
		idLable.setFont(new Font("", Font.BOLD, 16));
		idLable.setBounds(100, 15, 137, 20);
		idLable.setForeground(Color.white);
		jLabel1.add(idLable);

		int RecepID = Integer.parseInt(this.user.getUser());
		
		CustsComboBox = new JComboBox<String>(sysData.getAllMyCusts(RecepID));
		
		CustsComboBox.setFont(new Font("", Font.BOLD, 12));
		CustsComboBox.setBounds(100, 35, 228, 20);
		jLabel1.add(CustsComboBox);
		
		CustsComboBox.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
				  Customer cust = null;
				  String CustID = CustsComboBox.getItemAt(CustsComboBox.getSelectedIndex());
				  cust = sysData.getCustomers().get(CustID);
				  
				  firstNameTextField.setText(cust.getFirstName());
				  lastNameTextField.setText(cust.getLastName());
				  int ar = 0;
				  for(int j = 0 ; j < cityComboBox.getItemCount(); j ++){
					  if(cityComboBox.getItemAt(j).equals(cust.getAddress().getCity())){
						  ar = j;
					  }
				  }
				  cityComboBox.setSelectedIndex(ar);
				  streetTextField.setText(cust.getAddress().getStreet());
				  houseNumTextField.setText(String.valueOf(cust.getAddress().getHouseNumber()));
				  String s = "";
				  for(String str : cust.getAddress().getPhoneNumber()){
					  s = s + str;
				  }
				  phoneNumTextField.setText(s);
				  
				  int ar2 = 0;
				  for(int j2 = 0 ; j2 < levelComboBox.getItemCount(); j2 ++){
					  if(levelComboBox.getItemAt(j2).equals(cust.getLevel())){
						  ar2 = j2;
					  }
				  }
				  
				  int ar3 = 0;
				  for(int j3 = 0 ; j3 < TeamsCombo.getItemCount(); j3 ++){
					  if(TeamsCombo.getItemAt(j3).equals(cust.getFavoriteTeam())){
						  ar3 = j3;
					  }
				  }
				  TeamsCombo.setSelectedIndex(ar3);
				  
				  levelComboBox.setSelectedIndex(ar2);
				  emailTextField.setText(String.valueOf(cust.getEmail()));
				  
		        }
		});
		

		final JLabel firstNameLabel = new JLabel("First Name:");
		firstNameLabel.setFont(new Font("", Font.BOLD, 16));
		firstNameLabel.setBounds(100, 55, 137, 20);
		firstNameLabel.setForeground(Color.WHITE);
		jLabel1.add(firstNameLabel);

		firstNameTextField.setFont(new Font("", Font.BOLD, 12));
		firstNameTextField.setBounds(100, 75, 228, 20);
		jLabel1.add(firstNameTextField);

		final JLabel lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setFont(new Font("", Font.BOLD, 16));
		lastNameLabel.setBounds(100, 100, 137, 20);
		lastNameLabel.setForeground(Color.WHITE);
		jLabel1.add(lastNameLabel);

		lastNameTextField.setFont(new Font("", Font.BOLD, 12));
		lastNameTextField.setBounds(100, 120, 228, 20);
		jLabel1.add(lastNameTextField);

		final JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("", Font.BOLD, 16));
		passwordLabel.setBounds(100, 210, 157, 20);
		passwordLabel.setForeground(Color.WHITE);
		jLabel1.add(passwordLabel);

		passwordTextField.setFont(new Font("", Font.BOLD, 12));
		passwordTextField.setBounds(100, 230, 228, 20);
		jLabel1.add(passwordTextField);

		JLabel cityLabel = new JLabel("City:");
		cityLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		cityLabel.setBounds(100, 255, 177, 16);
		cityLabel.setForeground(Color.WHITE);
		jLabel1.add(cityLabel);

		cityComboBox.setFont(new Font("Dialog", Font.BOLD, 12));
		cityComboBox.setBounds(100, 275, 228, 20);
		jLabel1.add(cityComboBox);
		


		JLabel streetLabel = new JLabel("Street:");
		streetLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		streetLabel.setBounds(100, 300, 177, 20);
		streetLabel.setForeground(Color.WHITE);
		jLabel1.add(streetLabel);

		streetTextField.setFont(new Font("Dialog", Font.BOLD, 12));
		streetTextField.setBounds(100, 320, 228, 20);
		jLabel1.add(streetTextField);

		JLabel houseNumLabel = new JLabel("House number:");
		houseNumLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		houseNumLabel.setBounds(370, 15, 137, 20);
		houseNumLabel.setForeground(Color.WHITE);
		jLabel1.add(houseNumLabel);

		houseNumTextField.setFont(new Font("Dialog", Font.BOLD, 12));
		houseNumTextField.setBounds(370, 35, 228, 20);
		houseNumTextField.setForeground(Color.WHITE);
		jLabel1.add(houseNumTextField);

		JLabel phoneNumLabel = new JLabel("Phone Number:");
		phoneNumLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		phoneNumLabel.setBounds(370, 55, 177, 16);
		phoneNumLabel.setForeground(Color.WHITE);
		jLabel1.add(phoneNumLabel);

		phoneNumTextField.setFont(new Font("Dialog", Font.BOLD, 12));
		phoneNumTextField.setBounds(370, 75, 228, 20);
		jLabel1.add(phoneNumTextField);

		final JLabel birthDateLabel = new JLabel("Birth date:");
		birthDateLabel.setFont(new Font("", Font.BOLD, 16));
		birthDateLabel.setBounds(100, 145, 137, 20);
		birthDateLabel.setForeground(Color.WHITE);
		jLabel1.add(birthDateLabel);

		dayComboBox.setFont(new Font("", Font.BOLD, 12));
		dayComboBox.setBounds(100, 165, 44, 20);
		jLabel1.add(dayComboBox);

		monthComboBox.setFont(new Font("", Font.BOLD, 12));
		monthComboBox.setBounds(160, 165, 44, 20);
		jLabel1.add(monthComboBox);

		yearComboBox.setFont(new Font("", Font.BOLD, 12));
		yearComboBox.setBounds(220, 165, 76, 20);
		jLabel1.add(yearComboBox);
		
		JLabel levelLabel = new JLabel("Level:");
		levelLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		levelLabel.setBounds(370, 100, 197, 16);
		levelLabel.setForeground(Color.WHITE);
		jLabel1.add(levelLabel);

		levelComboBox.setFont(new Font("Dialog", Font.BOLD, 12));
		levelComboBox.setBounds(370, 120, 228, 20);
		jLabel1.add(levelComboBox);
		
		JLabel emailLabel = new JLabel("Email (URL):");
		emailLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		emailLabel.setBounds(370, 145, 137, 20);
		emailLabel.setForeground(Color.WHITE);
		jLabel1.add(emailLabel);

		emailTextField.setFont(new Font("Dialog", Font.BOLD, 12));
		emailTextField.setBounds(370, 165, 228, 20);
		jLabel1.add(emailTextField);

		JLabel TeamLabel = new JLabel("Favourite Team:");
		TeamLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		TeamLabel.setForeground(Color.WHITE);
		TeamLabel.setBounds(370, 210, 137, 20);
		jLabel1.add(TeamLabel);

		TeamsCombo.setFont(new Font("Dialog", Font.BOLD, 12));
		TeamsCombo.setBounds(370, 230, 228, 20);
		jLabel1.add(TeamsCombo);
		
		JButton addButton = new JButton("UpdateInfo");
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
	
	protected Date getBirthDate() throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setTimeZone(TimeZone.getTimeZone("Asia/Jerusalem"));
		String date = dayComboBox.getSelectedItem().toString() + "/" + monthComboBox.getSelectedItem().toString() + "/"
				+ yearComboBox.getSelectedItem().toString();

		return df.parse(date);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			if(arg0.getActionCommand().equals("Back")){
				this.dispose();
			}
			else if(arg0.getActionCommand().equals("UpdateInfo")){
			Customer customer = null;
			String id = CustsComboBox.getItemAt(CustsComboBox.getSelectedIndex());
			customer = sysData.getCustomers().get(id);
			
			String fName = firstNameTextField.getText();
			if(fName != null){
				customer.setFirstName(fName);
			}
			String lName = lastNameTextField.getText();
			if(lName != null){
				customer.setLastName(lName);
			}
			customer.setBirthdate(this.getBirthDate());
			if(passwordTextField.getText() != null){
				customer.setPassword(passwordTextField.getText());
			}
			customer.setAddress(new Address(cityComboBox.getItemAt(cityComboBox.getSelectedIndex()),
							streetTextField.getText(), Integer.parseInt(houseNumTextField.getText()), 
							new String[] {phoneNumTextField.getText()}));
			customer.setLevel(levelComboBox.getItemAt(levelComboBox.getSelectedIndex()));
			Team t = null;
			int tid = TeamsCombo.getItemAt(TeamsCombo.getSelectedIndex());
			t = sysData.getTeams().get(tid);
			if(t != null){
			customer.setFavoriteTeam(t);
			}
			if(emailTextField.getText() != null){
				URL em = null;
				em = new URL(emailTextField.getText());
				customer.setEmail(em);
				}
			
			sysData.getCustomers().put(customer.getId(), customer);
			messageBox.showInternalInformationMessage("Customer Information Succesfully Updated!");
		}
		}
		catch (Exception e) {
			messageBox.showInternalErrorMessage(e.getMessage());
		}
	}

}
