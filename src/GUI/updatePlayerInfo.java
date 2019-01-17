package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat; 
import java.util.Date; 
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Model.Address;
import Model.Player;
import Model.User;
import utils.E_Cities;
import utils.E_Levels;
import utils.E_Position; 

public class updatePlayerInfo extends MyInternalFrame {

	private static final long serialVersionUID = 1L;
	
	protected JTextField id2TextField = new JTextField();
	protected JTextField firstNameTextField = new JTextField();
	protected JTextField lastNameTextField = new JTextField();
	
	protected JComboBox<Integer> dayComboBox = new // JComboBox<Integer>();
	JComboBox<Integer>(getNumbersInRange(1, 31));
	protected JComboBox<Integer> monthComboBox = new // JComboBox<Integer>();
	JComboBox<Integer>(getNumbersInRange(1, 12));
	protected JComboBox<Integer> yearComboBox = new // JComboBox<Integer>();
	JComboBox<Integer>(getNumbersInRangeReverse(1920, 2017));
	
	protected JPasswordField passwordTextField = new JPasswordField();
	
	protected JComboBox<Integer> day1ComboBox = new // JComboBox<Integer>();
	JComboBox<Integer>(getNumbersInRange(1, 31));
	protected JComboBox<Integer> month1ComboBox = new // JComboBox<Integer>();
	JComboBox<Integer>(getNumbersInRange(1, 12));
	protected JComboBox<Integer> year1ComboBox = new // JComboBox<Integer>();
	JComboBox<Integer>(getNumbersInRangeReverse(1920, 2017));
	
	protected JComboBox<E_Cities> cityComboBox = new JComboBox<E_Cities>(E_Cities.values());
	protected JTextField streetTextField = new JTextField();
	protected JTextField houseNumTextField = new JTextField();
	protected JTextField phoneNumTextField = new JTextField();
	protected JButton addButton = new JButton("Add");
	protected JComboBox<E_Levels> coachLevelComboBox = new JComboBox<E_Levels>(E_Levels.values());
	
	protected JComboBox<E_Position> playerPosComboBox = new JComboBox<E_Position>(E_Position.values());
	protected JCheckBox cc = new JCheckBox("Is Right Leg Kicker?"); 
	protected JTextField ValueTextField = new JTextField();
	
	private javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
	private JComboBox<Integer> PlayersComboBox;
	protected JTextField idTextField = new JTextField();
	private User user;
	
	public updatePlayerInfo(User u){
		super("Update Player Info");
		this.user = u;
		setBounds(70, 30, 700, 440); 
		int coachID = Integer.parseInt(this.user.getUser());
		int teamID = sysData.getMyTeam(coachID);
		@SuppressWarnings("unused")
		String strI = String.valueOf(teamID);
		PlayersComboBox = new JComboBox<Integer>(sysData.getTeamPlayers(coachID));
        desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        desktopPane.setBackground(Color.BLACK);
		this.setContentPane(desktopPane);
		
		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
	    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qq3.jpg"))); // NOI18N
	    jLabel1.setBounds(0, 0, this.getWidth(),this.getHeight());
	    desktopPane.add(jLabel1);
		
	    PlayersComboBox = new JComboBox<Integer>(sysData.getTeamPlayers(coachID));
	    
		final JLabel MatchLabel = new JLabel("Player ID:");
		MatchLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		MatchLabel.setBounds(100, 15, 137, 20);
		MatchLabel.setForeground(Color.WHITE);
		jLabel1.add(MatchLabel);

		PlayersComboBox.setFont(new Font("Dialog", Font.BOLD, 12));
		PlayersComboBox.setBounds(100, 35, 228, 20);
		jLabel1.add(PlayersComboBox);
		
		PlayersComboBox.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
				  Player P = null;
				  int i = PlayersComboBox.getItemAt(PlayersComboBox.getSelectedIndex());
				  P = sysData.getPlayers().get(i);
				  firstNameTextField.setText(P.getFirstName());
				  lastNameTextField.setText(P.getLastName());
				  int ar = 0;
				  for(int j = 0 ; j < cityComboBox.getItemCount(); j ++){
					  if(cityComboBox.getItemAt(j).equals(P.getAddress().getCity())){
						  ar = j;
					  }
				  }
				  cityComboBox.setSelectedIndex(ar);
				  streetTextField.setText(P.getAddress().getStreet());
				  houseNumTextField.setText(String.valueOf(P.getAddress().getHouseNumber()));
				  String s = "";
				  for(String str : P.getAddress().getPhoneNumber()){
					  s = s + str;
				  }
				  phoneNumTextField.setText(s);
				  
				  int ar2 = 0;
				  for(int j2 = 0 ; j2 < coachLevelComboBox.getItemCount(); j2 ++){
					  if(coachLevelComboBox.getItemAt(j2).equals(P.getLevel())){
						  ar2 = j2;
					  }
				  }
				  coachLevelComboBox.setSelectedIndex(ar2);
				  
				  int ar3 = 0;
				  for(int j3 = 0 ; j3 < playerPosComboBox.getItemCount(); j3 ++){
					  if(playerPosComboBox.getItemAt(j3).equals(P.getPosition())){
						  ar3 = j3;
					  }
				  }
				  playerPosComboBox.setSelectedIndex(ar3);
				  
				  if(P.isRightLegKicker()){
					  cc.setSelected(true);
				  }
				  else{
					  cc.setSelected(false);
				  }
				  
				  ValueTextField.setText(String.valueOf(P.getValue()));
				  
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
		jLabel1.add(houseNumTextField);

		JLabel phoneNumLabel = new JLabel("Phone Number:");
		phoneNumLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		phoneNumLabel.setBounds(370, 55, 177, 16);
		phoneNumLabel.setForeground(Color.WHITE);
		jLabel1.add(phoneNumLabel);

		phoneNumTextField.setFont(new Font("Dialog", Font.BOLD, 12));
		phoneNumTextField.setBounds(370, 75, 228, 20);
		jLabel1.add(phoneNumTextField);
		
		final JLabel startWorkingDateLabel = new JLabel("Start Working Date:");
		startWorkingDateLabel.setFont(new Font("", Font.BOLD, 16));
		startWorkingDateLabel.setBounds(370, 100, 197, 16);
		startWorkingDateLabel.setForeground(Color.WHITE);
		jLabel1.add(startWorkingDateLabel);

		day1ComboBox.setFont(new Font("", Font.BOLD, 12));
		day1ComboBox.setBounds(370, 120, 59, 20);
		jLabel1.add(day1ComboBox);

		month1ComboBox.setFont(new Font("", Font.BOLD, 12));
		month1ComboBox.setBounds(445, 120, 59, 20);
		jLabel1.add(month1ComboBox);

		year1ComboBox.setFont(new Font("", Font.BOLD, 12));
		year1ComboBox.setBounds(520, 120, 76, 20);
		jLabel1.add(year1ComboBox);

		
		JLabel coachLevelLabel = new JLabel("Level:");
		coachLevelLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		coachLevelLabel.setBounds(370, 145, 137, 20);
		coachLevelLabel.setForeground(Color.WHITE);
		jLabel1.add(coachLevelLabel);

		coachLevelComboBox.setFont(new Font("Dialog", Font.BOLD, 12));
		coachLevelComboBox.setBounds(370, 165, 228, 20);
		jLabel1.add(coachLevelComboBox);
		
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

	protected Date getEmploymentDate() throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setTimeZone(TimeZone.getTimeZone("Asia/Jerusalem"));
		String date = day1ComboBox.getSelectedItem().toString() + "/" + month1ComboBox.getSelectedItem().toString()
				+ "/" + year1ComboBox.getSelectedItem().toString();

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
			if(PlayersComboBox.getSelectedIndex() == -1) {
				throw new Exception("No Player selected!");
			}
			 Player P = null;
			  int i = PlayersComboBox.getItemAt(PlayersComboBox.getSelectedIndex());
			  P = sysData.getPlayers().get(i);
			
			String fName = firstNameTextField.getText();
			if(fName != null){
			P.setFirstName(fName);
			}
			String lName = lastNameTextField.getText();
			if(lName != null){
			P.setLastName(lName);
			}
			P.setBirthdate(this.getBirthDate());
			P.setStartWorkingDate(this.getEmploymentDate());
			if(passwordTextField.getText() != null){
			P.setPassword(passwordTextField.getText());
			}
			P.setAddress(new Address(cityComboBox.getItemAt(cityComboBox.getSelectedIndex()),
							streetTextField.getText(), Integer.parseInt(houseNumTextField.getText()), 
							new String[] {phoneNumTextField.getText()}));
			P.setLevel(coachLevelComboBox.getItemAt(coachLevelComboBox.getSelectedIndex()));
			P.setPosition(playerPosComboBox.getItemAt(playerPosComboBox.getSelectedIndex()));
			P.setValue(Long.parseLong(ValueTextField.getText()));
			if(cc.isSelected()){
			P.setRightLegKicker(true);
			}
			else{
				P.setRightLegKicker(false);
			}
				sysData.getPlayers().put(P.getId(), P);
					messageBox.showInternalInformationMessage("Player Information Succesfully Updated!");
				
		}
		}
		catch(Exception e) {
			messageBox.showInternalErrorMessage(e.getMessage());
		}
		
	}
	
	
	
	
}
