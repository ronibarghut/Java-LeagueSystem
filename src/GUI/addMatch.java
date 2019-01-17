package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class addMatch extends MyInternalFrame {

	private static final long serialVersionUID = 1L;
	private javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
	protected JTextField matchIDTextField = new JTextField();
	protected JTextField extraTimeTextField = new JTextField();
	protected JTextField teamAScoreTextField = new JTextField();
	protected JTextField teamBScoreTextField = new JTextField();
	private JComboBox<Integer> TeamAComboBox = new JComboBox<Integer>(sysData.getTeamNums());
	private JComboBox<Integer> TeamBComboBox = new JComboBox<Integer>(sysData.getTeamNums());
	
	protected JComboBox<Integer> dayComboBox = new // JComboBox<Integer>();
	JComboBox<Integer>(getNumbersInRange(1, 31));
	protected JComboBox<Integer> monthComboBox = new // JComboBox<Integer>();
	JComboBox<Integer>(getNumbersInRange(1, 12));
	protected JComboBox<Integer> yearComboBox = new // JComboBox<Integer>();
	JComboBox<Integer>(getNumbersInRangeReverse(1920, 2017));
	
	
	public addMatch(){
		super("add Match");

		setBounds(70, 30, 700, 440); 
		
        desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        desktopPane.setBackground(Color.BLACK);
		this.setContentPane(desktopPane);
		
		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
	    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qq2.jpg"))); // NOI18N
	    jLabel1.setBounds(0, 0, this.getWidth(),this.getHeight());
	    desktopPane.add(jLabel1);
		
		final JLabel matchIDLable = new JLabel("Match ID:");
		matchIDLable.setFont(new Font("", Font.BOLD, 12));
		matchIDLable.setBounds(200, 15, 137, 20);
		matchIDLable.setForeground(Color.white);
		jLabel1.add(matchIDLable);


		matchIDTextField.setFont(new Font("", Font.BOLD, 12));
		matchIDTextField.setBounds(200, 35, 228, 20);
		jLabel1.add(matchIDTextField);
		
		final JLabel extraTimeLabel = new JLabel("Extra Time:");
		extraTimeLabel.setFont(new Font("", Font.BOLD, 12));
		extraTimeLabel.setBounds(200, 55, 137, 20);
		extraTimeLabel.setForeground(Color.WHITE);
		jLabel1.add(extraTimeLabel);

		extraTimeTextField.setFont(new Font("", Font.BOLD, 12));
		extraTimeTextField.setBounds(200, 75, 228, 20);
		jLabel1.add(extraTimeTextField);
		
		final JLabel HomeTeamLabel = new JLabel("HomeTeam ID:");
		HomeTeamLabel.setFont(new Font("", Font.BOLD, 12));
		HomeTeamLabel.setBounds(200, 100, 137, 20);
		HomeTeamLabel.setForeground(Color.WHITE);
		jLabel1.add(HomeTeamLabel);

		TeamAComboBox.setFont(new Font("", Font.BOLD, 12));
		TeamAComboBox.setBounds(200, 120, 228, 20);
		jLabel1.add(TeamAComboBox);
		
		final JLabel awayTeamLabel = new JLabel("AwayTeam ID:");
		awayTeamLabel.setFont(new Font("", Font.BOLD, 12));
		awayTeamLabel.setBounds(200, 145, 137, 20);
		awayTeamLabel.setForeground(Color.black);
		jLabel1.add(awayTeamLabel);


		TeamBComboBox.setFont(new Font("", Font.BOLD, 12));
		TeamBComboBox.setBounds(200, 165, 228, 20);
		jLabel1.add(TeamBComboBox);
		
		JLabel HTScoreLabel = new JLabel("HomeTeam Score:");
		HTScoreLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		HTScoreLabel.setBounds(200, 190, 157, 20);
		HTScoreLabel.setForeground(Color.WHITE);
		jLabel1.add(HTScoreLabel);

		teamAScoreTextField.setFont(new Font("Dialog", Font.BOLD, 12));
		teamAScoreTextField.setBounds(200, 210, 228, 20);
		jLabel1.add(teamAScoreTextField);
		
		JLabel ATScoreLabel = new JLabel("AwayTeam Score:");
		ATScoreLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		ATScoreLabel.setBounds(200, 235, 177, 16);
		ATScoreLabel.setForeground(Color.WHITE);
		jLabel1.add(ATScoreLabel);

		teamBScoreTextField.setFont(new Font("Dialog", Font.BOLD, 12));
		teamBScoreTextField.setBounds(200, 255, 228, 20);
		jLabel1.add(teamBScoreTextField);
		
		final JLabel MatchDateLabel = new JLabel("Match Date:");
		MatchDateLabel.setFont(new Font("", Font.BOLD, 12));
		MatchDateLabel.setBounds(200, 280, 177, 20);
		MatchDateLabel.setForeground(Color.WHITE);
		jLabel1.add(MatchDateLabel);

		dayComboBox.setFont(new Font("", Font.BOLD, 12));
		dayComboBox.setBounds(200, 300, 59, 20);
		jLabel1.add(dayComboBox);

		monthComboBox.setFont(new Font("", Font.BOLD, 12));
		monthComboBox.setBounds(260, 300, 59, 20);
		jLabel1.add(monthComboBox);

		yearComboBox.setFont(new Font("", Font.BOLD, 12));
		yearComboBox.setBounds(320, 300, 79, 20);
		jLabel1.add(yearComboBox);

		JButton addButton = new JButton("Add Match");
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
			else if(arg0.getActionCommand().equals("Add Match")){
			if (sysData.addMatch(Integer.parseInt(matchIDTextField.getText()),getMatchDate(),Integer.parseInt(extraTimeTextField.getText()),
					TeamAComboBox.getItemAt(TeamAComboBox.getSelectedIndex()),TeamBComboBox.getItemAt(TeamBComboBox.getSelectedIndex()),
					Integer.parseInt(teamAScoreTextField.getText()),Integer.parseInt(teamBScoreTextField.getText()))) {
				messageBox.showInternalInformationMessage("MATCH " + matchIDTextField.getText()
						+ "\nhas successfully been added to the system");
			} else {
				messageBox.showInternalErrorMessage("FAILED to add" + matchIDTextField.getText()
						+ "\nto the system");
			}
		}
		}
		catch (Exception e) {
			messageBox.showInternalErrorMessage(e.getMessage());
		}
	}
	
	protected Date getMatchDate() throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setTimeZone(TimeZone.getTimeZone("Asia/Jerusalem"));
		String date = dayComboBox.getSelectedItem().toString() + "/" + monthComboBox.getSelectedItem().toString() + "/"
				+ yearComboBox.getSelectedItem().toString();

		return df.parse(date);
	}
}
