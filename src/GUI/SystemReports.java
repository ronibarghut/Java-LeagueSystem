package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font; 
import java.awt.event.ActionEvent; 
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener; 
import java.util.Set;

import javax.swing.JComboBox; 
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
 
import Model.User; 
import utils.TypeOfUser;
import utils.Utility;


/**
 * Internal frame for viewing reports about the system
 */
public class SystemReports extends MyInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private JTextPane reportTextPane = new JTextPane();
	private JComboBox<Integer> InputComboBox = new JComboBox<Integer>();
	private JComboBox<Integer> InputComboBox2 = new JComboBox<Integer>();
	private JComboBox<String> reportCombobox;
	final JLabel TeamLabel = new JLabel("Team:");
	final JLabel s1Label = new JLabel("Stadium1:");
	final JLabel s2Label = new JLabel("Stadium2:");
	private User user;
	
	/**
	 * Constructor for SystemReports class
	 * @param user 
	 */
	public SystemReports(User user) {
		super("System Reports");
		
		this.user = user;
		
        getContentPane().setLayout(new BorderLayout());
		setBounds(50, 50, 840, 400); 
        JPanel topPanel = new JPanel(new FlowLayout());
       
		String[] adminReportTypes = {"Stadiums","Teams","Players","Coaches", "Receptionists", "Customers",  
				 "Subscriptions","Matches", "Trophies", 
				"getSuperPlayerMaker", "getAllSuperPlayerMakers", "getTheMostPopularPosition",
				"getTheMostFavoredTeam", "getTheMostActiveCity", "getEntityWithMostTrophies", "getTeamWithLargestHomeCrowd",
				"getCustomersStadium1XORStadium2","getFirstPlayersOfBestHomeTeam"};
		
		String[] receptionistReportTypes = {"Customers","MyCustomers","SubsByMe", 
				 "Subscriptions","Matches",
				"getTheMostFavoredTeam", "getTheMostActiveCity","getTeamWithLargestHomeCrowd",
				"getCustomersStadium1XORStadium2"};
		
		String[] CoachReportTypes = {"MyTeamsHistory","MyCurrentTeam","MyCurrentTeamPlayers","MyCurrentTeamFirstPlayers", "MyMatchesHistory", 
				"getSuperPlayerMaker", "getAllSuperPlayerMakers", "getTheMostPopularPosition",
				"getEntityWithMostTrophies","getFirstPlayersOfBestHomeTeam"};
		
		String[] customerReportTypes = {
				 "MySubscriptions","MyMatches" };
		
		final JLabel showLabel = new JLabel("Show:");
		showLabel.setFont(new Font("", Font.BOLD, 12));
		topPanel.add(showLabel);
		if(user.getType().equals(TypeOfUser.Customer)) {
			reportCombobox = new JComboBox<String>(customerReportTypes);
		}
		else if(user.getType().equals(TypeOfUser.Receptionist)) {
			reportCombobox = new JComboBox<String>(receptionistReportTypes);
		}
		else if(user.getType().equals(TypeOfUser.Coach)) {
			reportCombobox = new JComboBox<String>(CoachReportTypes);
		}
		else if(user.getType().equals(TypeOfUser.Admin)) {
			reportCombobox = new JComboBox<String>(adminReportTypes);
		}
		reportCombobox.setFont(new Font("", Font.BOLD, 12));
		reportCombobox.addItemListener(new ItemListener() {
			public void itemStateChanged(final ItemEvent arg0) {
				fillReport();
			}
		}); 
		
		topPanel.add(reportCombobox);

		TeamLabel.setFont(new Font("", Font.BOLD, 12));
		TeamLabel.setVisible(false);
		s1Label.setFont(new Font("", Font.BOLD, 12));
		s1Label.setVisible(false);
		topPanel.add(TeamLabel);
		topPanel.add(s1Label);
		topPanel.add(InputComboBox);
		s2Label.setFont(new Font("", Font.BOLD, 12));
		s2Label.setVisible(false);
		topPanel.add(s2Label);
		topPanel.add(InputComboBox2);
		topPanel.setBackground(Color.lightGray);
		getContentPane().add(topPanel, BorderLayout.NORTH);
		reportTextPane.setFont(new Font("", Font.BOLD, 12));
		reportTextPane.setBorder(new LineBorder(Color.black, 1, false));
		reportTextPane.setEditable(false);
		reportTextPane.setAutoscrolls(true); 
		JScrollPane pane = new JScrollPane(reportTextPane);
		getContentPane().add(pane, BorderLayout.CENTER);
		

		
		
		fillReport();
	}
	
	private void fillReport() {
		String reportType = reportCombobox.getSelectedItem().toString();
		this.InputComboBox.setVisible(false);
		this.InputComboBox2.setVisible(false);
		TeamLabel.setVisible(false);
		s1Label.setVisible(false);
		s2Label.setVisible(false);
		
		switch (reportType) {
		case "Stadiums":
		case "Customers":
		case "Teams":
		case "Coaches":
		case "Receptionists":
		case "Players":
		case "Subscriptions":
		case "Matches":
		case "Trophies":
			reportTextPane.setText(Utility.getResultString(getVlaues(reportType), reportType));
			break;
		case "MyMatchesHistory":
		case "MyCurrentTeamPlayers":
		case "MyCurrentTeamFirstPlayers":
		case "MyCurrentTeam":
		case "MyTeamsHistory":
		case "MyMatches":
		case "MySubscriptions":	
		case "MyCustomers":
		case "SubsByMe":
			reportTextPane.setText(Utility.getResultString(getVlaues(reportType,user.getUser()), reportType));
			break;
		case "getSuperPlayerMaker":
			InputComboBox.removeAllItems();
			Set<Integer> a = sysData.TeamsIDArr();
					  	for(Integer i : a){
					InputComboBox.addItem(i);
				}
				TeamLabel.setVisible(true);
				InputComboBox.setVisible(true);
				
				InputComboBox.addItemListener(new ItemListener() {
				    @Override
				    public void itemStateChanged(ItemEvent e) {
				        if(e.getStateChange() == ItemEvent.SELECTED) {
				        	reportTextPane.setText(Utility.getResultString(getVlaues(reportType,InputComboBox.getItemAt(InputComboBox.getSelectedIndex())), reportType));
				        }
				    }
				});
				
			break;
		case "getAllSuperPlayerMakers":
			reportTextPane.setText(Utility.getResultString(getVlaues(reportType), reportType));
			break;
		case "getTheMostPopularPosition":
			reportTextPane.setText(Utility.getResultString(getVlaues(reportType), reportType));
			break;
		case "getTheMostFavoredTeam":
			reportTextPane.setText(Utility.getResultString(getVlaues(reportType), reportType));
		case "getTheMostActiveCity":
			InputComboBox.removeAllItems();
			Set<Integer> b = sysData.StadiumsIDArr();
					  	for(Integer i : b){
					InputComboBox.addItem(i);
				}
				s1Label.setVisible(true);
				InputComboBox.setVisible(true);
				
				InputComboBox.addItemListener(new ItemListener() {
				    @Override
				    public void itemStateChanged(ItemEvent e) {
				        if(e.getStateChange() == ItemEvent.SELECTED) {
				        	reportTextPane.setText(Utility.getResultString(getVlaues(reportType,InputComboBox.getItemAt(InputComboBox.getSelectedIndex()),InputComboBox2.getItemAt(InputComboBox2.getSelectedIndex())), reportType));
				        }
				    }
				});
				
			break;
		case "getEntityWithMostTrophies":
			reportTextPane.setText(Utility.getResultString(getVlaues(reportType), reportType));
			break;
		case "getTeamWithLargestHomeCrowd":
			reportTextPane.setText(Utility.getResultString(getVlaues(reportType), reportType));
			break;
		case "getCustomersStadium1XORStadium2":
			InputComboBox.removeAllItems();
			InputComboBox2.removeAllItems();
			Set<Integer> c = sysData.StadiumsIDArr();
				for(Integer i : c){
		  		InputComboBox.addItem(i);
		  			}
				for(Integer i : c){
			  		InputComboBox2.addItem(i);
			  			}
				s1Label.setVisible(true);
				s2Label.setVisible(true);
				InputComboBox.setVisible(true);
				InputComboBox2.setVisible(true);
				InputComboBox.addItemListener(new ItemListener() {
				    @Override
				    public void itemStateChanged(ItemEvent e) {
				        if(e.getStateChange() == ItemEvent.SELECTED) {
				        	reportTextPane.setText(Utility.getResultString(getVlaues(reportType,InputComboBox.getItemAt(InputComboBox.getSelectedIndex())), reportType));
				        }
				    }
				});
				break;
			case "getFirstPlayersOfBestHomeTeam":
				reportTextPane.setText(Utility.getResultString(getVlaues(reportType), reportType));
			break;
		default:
			break;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}
	
}