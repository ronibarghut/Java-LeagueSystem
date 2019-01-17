package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;

import Model.Coach;
import Model.Player;
import Model.Stadium;
import Model.Team;
import utils.E_Trophy; 
public class addTrophy extends MyInternalFrame {

	private static final long serialVersionUID = 1L;
	
	
	private javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
	
	private JComboBox<E_Trophy> TrophyComboBox = new JComboBox<E_Trophy>(E_Trophy.values());
	private JComboBox<Integer> userIDComboBox = new JComboBox<Integer>();
	
	protected JComboBox<Integer> dayComboBox = new 
			JComboBox<Integer>(getNumbersInRange(1, 31));
	protected JComboBox<Integer> monthComboBox = new 
			JComboBox<Integer>(getNumbersInRange(1, 12));
	protected JComboBox<Integer> yearComboBox = new 
			JComboBox<Integer>(getNumbersInRangeReverse(1920, 2017));
	
	public E_Trophy owner;
	
	public addTrophy(){
		super("Add Trophy");
		
		setBounds(70, 30, 700, 440); 
		
        desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        desktopPane.setBackground(Color.BLACK);
		this.setContentPane(desktopPane);
		
		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
	    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qqq2.jpg"))); // NOI18N
	    jLabel1.setBounds(0, 0, this.getWidth(),this.getHeight());
	    desktopPane.add(jLabel1);
		
		final JLabel trophyLabel = new JLabel("Trophy :");
		trophyLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		trophyLabel.setBounds(200, 15, 105, 20);
		trophyLabel.setForeground(Color.white);
		jLabel1.add(trophyLabel);

		TrophyComboBox.setFont(new Font("Dialog", Font.BOLD, 12));
		TrophyComboBox.setBounds(200, 45, 241, 20);
		jLabel1.add(TrophyComboBox);
		
		
		TrophyComboBox.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) {

				  owner = TrophyComboBox.getItemAt(TrophyComboBox.getSelectedIndex());
					if(owner == E_Trophy.STADIUM_OF_THE_YEAR){
						userIDComboBox.removeAllItems();
						for(Integer i : sysData.getAllStadiums()){
						userIDComboBox.addItem(i);
						}
					}
					else if(owner == E_Trophy.PLAYER_OF_THE_YEAR){
						userIDComboBox.removeAllItems();
						for(Integer i : sysData.getPlayersIDS()){
						userIDComboBox.addItem(i);
						}
					}
					else if(owner == E_Trophy.COACH_OF_THE_YEAR){
						userIDComboBox.removeAllItems();
						for(Integer i : sysData.getCoachesIDS()){
						userIDComboBox.addItem(i);
						}
					}
					else if(owner == E_Trophy.TEAM_OF_THE_YEAR){
						userIDComboBox.removeAllItems();
						for(Integer i : sysData.getTeamNums()){
						userIDComboBox.addItem(i);
						}
					}
		        }
		});
		
	
		
		final JLabel IDLabel = new JLabel("User ID :");
		IDLabel.setFont(new Font("", Font.BOLD, 18));
		IDLabel.setBounds(200, 65, 137, 20);
		IDLabel.setForeground(Color.white);
		jLabel1.add(IDLabel);

		userIDComboBox.setFont(new Font("", Font.BOLD, 12));
		userIDComboBox.setBounds(200, 85, 241, 20);
		jLabel1.add(userIDComboBox);
	
		final JLabel birthDateLabel = new JLabel("Winning Date:");
		birthDateLabel.setFont(new Font("", Font.BOLD, 18));
		birthDateLabel.setBounds(200, 120, 137, 16);
		birthDateLabel.setForeground(Color.white);
		jLabel1.add(birthDateLabel);

		dayComboBox.setFont(new Font("", Font.BOLD, 12));
		dayComboBox.setBounds(200, 140, 49, 20);
		jLabel1.add(dayComboBox);

		monthComboBox.setFont(new Font("", Font.BOLD, 12));
		monthComboBox.setBounds(280, 140, 49, 20);
		jLabel1.add(monthComboBox);

		yearComboBox.setFont(new Font("", Font.BOLD, 12));
		yearComboBox.setBounds(385, 140, 66, 20);
		jLabel1.add(yearComboBox);
		
		JButton addButton = new JButton("Add Trophy");
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
	
	
	protected Date getWinDate() throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setTimeZone(TimeZone.getTimeZone("Asia/Jerusalem"));
		String date = dayComboBox.getSelectedItem().toString() + "/" + monthComboBox.getSelectedItem().toString() + "/"
				+ yearComboBox.getSelectedItem().toString();

		return df.parse(date);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			if(arg0.getActionCommand().equals("Back")){
				this.dispose();
			}
			else if(arg0.getActionCommand().equals("Add Trophy")){
			if(TrophyComboBox.getSelectedIndex() == -1) {
				throw new Exception("No Trophy selected!");
			}
			if(userIDComboBox.getSelectedIndex() == -1) {
				throw new Exception("No UserID selected!");
			}
			E_Trophy T = TrophyComboBox.getItemAt(TrophyComboBox.getSelectedIndex());
			int id = userIDComboBox.getItemAt(userIDComboBox.getSelectedIndex());
			Player p = null;
			Coach  c = null;
			Team t = null;
			Stadium s = null;
			if(owner.equals(E_Trophy.PLAYER_OF_THE_YEAR)){
				p = sysData.getPlayers().get(id);
				
				if(sysData.addTrophy( T, p , getWinDate())) {
					messageBox.showInternalInformationMessage("Trophy " + T +
							"\nhas successfully been added to Player " + id);
				}
				else {
					messageBox.showInternalErrorMessage("Failed to add Trophy " + T +
							"\nto Player " + id);
				}
			}
			else if(owner.equals(E_Trophy.COACH_OF_THE_YEAR)){
				c = sysData.getCoachs().get(id);
				if(sysData.addTrophy( T, c , getWinDate())) {
					messageBox.showInternalInformationMessage("Trophy " + T +
							"\nhas successfully been added to Coach " + id);
				}
				else {
					messageBox.showInternalErrorMessage("Failed to add Trophy " + T +
							"\nto Coach " + id);
				}
			}
			else if(owner.equals(E_Trophy.STADIUM_OF_THE_YEAR)){
				s = sysData.getStadiums().get(id);
				if(sysData.addTrophy( T, s , getWinDate())) {
					messageBox.showInternalInformationMessage("Trophy " + T +
							"\nhas successfully been added to Stadium " + id);
				}
				else {
					messageBox.showInternalErrorMessage("Failed to add Trophy " + T +
							"\nto Stadium " + id);
				}
			}
			else if(owner.equals(E_Trophy.TEAM_OF_THE_YEAR)){
				t = sysData.getTeams().get(id);
				if(sysData.addTrophy( T, t , getWinDate())) {
					messageBox.showInternalInformationMessage("Trophy " + T +
							"\nhas successfully been added to Team " + id);
				}
				else {
					messageBox.showInternalErrorMessage("Failed to add Trophy " + T +
							"\nto Team " + id);
				}
			}
		}
		}
		catch(Exception e) {
			messageBox.showInternalErrorMessage(e.getMessage());
		}
	}

}
