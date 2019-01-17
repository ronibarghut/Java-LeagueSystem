package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent; 
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame; 
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Controller.SysData;
import Model.User;
import utils.MyFileLogWriter;
import utils.TypeOfUser; 
import utils.Utility;


/**
 * This class is the main application frame of the system
 */
public class MainApplication extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JDesktopPane desktopPane = new JDesktopPane();
	
	private SysData sysData = SysData.getInstance();
	private javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
	
	private JButton addButton = new JButton("AddMenu");
	private JButton connectButton = new JButton("ConnectMenu");
	private JButton repButton = new JButton("SysRepMenu");
	private JButton RemoveButton = new JButton("RemoveMenu");
	private JButton BackButton = new JButton();
	private JButton muteButton = new JButton();
	private User user;
	public static boolean playing = false;
	public static boolean playing2 = false;
	/**
	 * Constructor of the class MainApplication
	 * @param loginFrame 
	 * @param user
	 */
	@SuppressWarnings("static-access")
	public MainApplication(JFrame loginFrame, final User user) {
		super(buildTitle(user));
		
		this.user = user;
		
		loginFrame.dispose();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 150, 960, 540); 
		
        desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        desktopPane.setBackground(Color.BLACK);
		this.setContentPane(desktopPane);
		
		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
	    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageC.jpg"))); // NOI18N
	    jLabel1.setBounds(0, 0, this.getWidth(),this.getHeight());
	    desktopPane.add(jLabel1);
		
	    
	    addButton.setFont(new Font("", Font.BOLD, 12));
	    addButton.setBounds(111, 50, 244, 20);
	    addButton.setBackground(new Color(59, 89, 182));
	    addButton.setForeground(Color.WHITE);
	    addButton.setFocusPainted(false);
	    addButton.setBorder(new RoundedBorder(10));
	    addButton.setFont(new Font("Tahoma", Font.BOLD, 12));
	    
	    addButton.addActionListener(this);
	    jLabel1.add(addButton);
		
	    connectButton.setFont(new Font("", Font.BOLD, 12));
	    connectButton.setBounds(111, 150, 244, 20);
	    connectButton.setBackground(new Color(59, 89, 182));
	    connectButton.setForeground(Color.WHITE);
	    connectButton.setFocusPainted(false);
	    connectButton.setBorder(new RoundedBorder(10));
	    connectButton.setFont(new Font("Tahoma", Font.BOLD, 12));
	    
	    connectButton.addActionListener(this);
	    jLabel1.add(connectButton);
	    
	    repButton.setFont(new Font("", Font.BOLD, 12));
	    repButton.setBounds(111, 350, 244, 20);
	    repButton.setBackground(new Color(59, 89, 182));
	    repButton.setForeground(Color.WHITE);
	    repButton.setFocusPainted(false);
	    repButton.setBorder(new RoundedBorder(10));
	    repButton.setFont(new Font("Tahoma", Font.BOLD, 12));
	    
	    repButton.addActionListener(this);
	    jLabel1.add(repButton);
	    
	    RemoveButton.setFont(new Font("", Font.BOLD, 12));
	    RemoveButton.setBounds(111, 250, 244, 20);
	    RemoveButton.setBackground(new Color(59, 89, 182));
	    RemoveButton.setForeground(Color.WHITE);
	    RemoveButton.setFocusPainted(false);
	    RemoveButton.setBorder(new RoundedBorder(10));
	    RemoveButton.setFont(new Font("Tahoma", Font.BOLD, 12));
	    
	    RemoveButton.addActionListener(this);
	    jLabel1.add(RemoveButton);
	    
		BackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logout.png")));
	    BackButton.setBounds(785, 360, 56, 56);
	    BackButton.setFont(new Font("", Font.BOLD, 12));
	    BackButton.setBackground(new Color(59, 89, 182));
	    BackButton.setBorder(new RoundedBorder(10));
	    BackButton.setForeground(Color.WHITE);
	    BackButton.setFocusPainted(false);
	    BackButton.setFont(new Font("Tahoma", Font.BOLD, 12));
	    
	    BackButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
						if(JOptionPane.showInternalConfirmDialog(desktopPane, 
								"Are you sure you would like to log out?", getTitle(),
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
							if(JOptionPane.showInternalConfirmDialog(desktopPane, 
									"Some files has been changes, would you like to save changes?", getTitle(),
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
								sysData.save();
							}
							MyFileLogWriter.saveLogFile();
							Utility.playSound("wav/notify.wav");
							try {
								Thread.sleep(1000);
							} catch (InterruptedException ye) {
								ye.printStackTrace();
							}
							LoginFrame frm = new LoginFrame();
							frm.setVisible(true);
							MainApplication.this.setVisible(false);
						}
						
			}
	});
	    jLabel1.add(BackButton);
	    
	    muteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/s2.png")));
	    muteButton.setBounds(785, 160, 56, 56);
	    muteButton.setFont(new Font("", Font.BOLD, 12));
	    muteButton.setBackground(new Color(59, 89, 182));
	    muteButton.setBorder(new RoundedBorder(10));
	    muteButton.setForeground(Color.WHITE);
	    muteButton.setFocusPainted(false);
	    muteButton.setFont(new Font("Tahoma", Font.BOLD, 12));
	    
	    muteButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(playing2 == true){
				Utility.StopSound("wav/music.wav");
				muteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/s1.png")));
				playing2 = false;
				}
				else{
				muteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/s2.png")));
					Utility.playSound("wav/music.wav");
					playing2 = true;	
				}
			}
	});
	    jLabel1.add(muteButton);
	    
	    
		if(user != null) {
			setJMenuBar(createMenuBar(user));
		}
		if(!this.playing){
		Utility.playSound("wav/music.wav");
		this.playing = true;
		this.playing2 = true;
		}
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(final WindowEvent arg0) {
				if(JOptionPane.showInternalConfirmDialog(desktopPane, 
						"Do you want to save the changes?", getTitle(),
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					sysData.save();
				}
				MyFileLogWriter.saveLogFile();
				Utility.playSound("wav/notify.wav");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				dispose();
			}
		});

		if(this.user.getType().equals(TypeOfUser.Customer)){
			connectButton.setVisible(false);
		}
	}

	private static String buildTitle(User user) {
		String title = "League System"; 
		if(user != null) {
			title += " (Logged in user: " + user.getUser() + " as " + user.getType() + ")";
		}
		return title;
	}

	private JMenuBar createMenuBar(User user) {		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		
		JMenuItem saveMenuItem = new JMenuItem("Save");
		saveMenuItem.addActionListener(this);
		fileMenu.add(saveMenuItem);

		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(this);
		fileMenu.add(exitMenuItem);
		
		menuBar.add(fileMenu);
		
		JMenu addMenu = new JMenu("Add");
		
		if(user.getType().equals(TypeOfUser.Admin)) {
			JMenuItem addStadiumMenuItem = new JMenuItem("Add Stadium");
			addStadiumMenuItem.addActionListener(this);
			addMenu.add(addStadiumMenuItem);
			
			
			JMenuItem addTeamMenuItem = new JMenuItem("Add Team");
			addTeamMenuItem.addActionListener(this);
			addMenu.add(addTeamMenuItem);
			
			JMenuItem addReceptionistMenuItem = new JMenuItem("Add Receptionist");
			addReceptionistMenuItem.addActionListener(this);
			addMenu.add(addReceptionistMenuItem);
			
			JMenuItem addCoachMenuItem = new JMenuItem("Add Coach");
			addCoachMenuItem.addActionListener(this);
			addMenu.add(addCoachMenuItem);
			
			JMenuItem addPlayerMenuItem = new JMenuItem("Add Player");
			addPlayerMenuItem.addActionListener(this);
			addMenu.add(addPlayerMenuItem);
			
			JMenuItem addMatchMenuItem = new JMenuItem("Add Match");
			addMatchMenuItem.addActionListener(this);
			addMenu.add(addMatchMenuItem);
			
			JMenuItem addTrophyMenuItem = new JMenuItem("Add Trophy");
			addTrophyMenuItem.addActionListener(this);
			addMenu.add(addTrophyMenuItem);
			
			JMenuItem addCustomerMenuItem = new JMenuItem("Add Customer");
			addCustomerMenuItem.addActionListener(this);
			addMenu.add(addCustomerMenuItem);
						
			menuBar.add(addMenu);
			
		
		}
		if(user.getType().equals(TypeOfUser.Receptionist)) {
			JMenuItem addCustomerMenuItem = new JMenuItem("Add Customer");
			addCustomerMenuItem.addActionListener(this);
			addMenu.add(addCustomerMenuItem);
						
			menuBar.add(addMenu);
		}
		
		if(user.getType().equals(TypeOfUser.Coach)) {
			JMenuItem addPlayerToMyTeamMenuItem = new JMenuItem("Add PlayerToMyTeam");
			addPlayerToMyTeamMenuItem.addActionListener(this);
			addMenu.add(addPlayerToMyTeamMenuItem);
			JMenuItem addFirstPlayerToMyTeamMenuItem = new JMenuItem("Add FirstPlayerToMyTeam");
			addFirstPlayerToMyTeamMenuItem.addActionListener(this);
			addMenu.add(addFirstPlayerToMyTeamMenuItem);
			menuBar.add(addMenu);
		}
		
		if(user.getType().equals(TypeOfUser.Customer)) {
			JMenuItem addMatchToMeMenuItem = new JMenuItem("Add MatchToMe");
			addMatchToMeMenuItem.addActionListener(this);
			addMenu.add(addMatchToMeMenuItem);
			menuBar.add(addMenu);
		}
		
		JMenu removeMenu = new JMenu("Remove");
		if(user.getType().equals(TypeOfUser.Admin)) {
			JMenuItem removeCoachMenuItem = new JMenuItem("Remove Coach");
			removeCoachMenuItem.addActionListener(this);
			removeMenu.add(removeCoachMenuItem);

			JMenuItem removeCustomerMenuItem = new JMenuItem("Remove Customer");
			removeCustomerMenuItem.addActionListener(this);
			removeMenu.add(removeCustomerMenuItem);

			JMenuItem removeMatchMenuItem = new JMenuItem("Remove Match");
			removeMatchMenuItem.addActionListener(this);
			removeMenu.add(removeMatchMenuItem);
			
			JMenuItem removePlayerMenuItem = new JMenuItem("Remove Player");
			removePlayerMenuItem.addActionListener(this);
			removeMenu.add(removePlayerMenuItem);
			
			JMenuItem removeReceptionistMenuItem = new JMenuItem("Remove Receptionist");
			removeReceptionistMenuItem.addActionListener(this);
			removeMenu.add(removeReceptionistMenuItem);
			
			JMenuItem removeStadiumMenuItem = new JMenuItem("Remove Stadium");
			removeStadiumMenuItem.addActionListener(this);
			removeMenu.add(removeStadiumMenuItem);
			menuBar.add(removeMenu);
			
			JMenuItem removeSubscriptionMenuItem = new JMenuItem("Remove Subscription");
			removeSubscriptionMenuItem.addActionListener(this);
			removeMenu.add(removeSubscriptionMenuItem);
			menuBar.add(removeMenu);
		}
		if(user.getType().equals(TypeOfUser.Receptionist)) {
			JMenuItem removeCustomerByRecepMenuItem = new JMenuItem("Remove CustomerByRecep");
			removeCustomerByRecepMenuItem.addActionListener(this);
			removeMenu.add(removeCustomerByRecepMenuItem);
			
			JMenuItem removeSubscriptionByRecepMenuItem = new JMenuItem("Remove SubscriptionByRecep");
			removeSubscriptionByRecepMenuItem.addActionListener(this);
			removeMenu.add(removeSubscriptionByRecepMenuItem);
			menuBar.add(removeMenu);
		}
		
		if(user.getType().equals(TypeOfUser.Coach)) {
			
			JMenuItem removeMatchMenuItem = new JMenuItem("Remove PlayerFromMyTeam");
			removeMatchMenuItem.addActionListener(this);
			removeMenu.add(removeMatchMenuItem);
			JMenuItem removeSubscriptionMenuItem = new JMenuItem("Remove PlayerFromMyFirstTeam");
			removeSubscriptionMenuItem.addActionListener(this);
			removeMenu.add(removeSubscriptionMenuItem);
			menuBar.add(removeMenu);
		}
		if(user.getType().equals(TypeOfUser.Customer)) {
			JMenuItem removeMatchMenuItem = new JMenuItem("Remove MatchFromMe");
			removeMatchMenuItem.addActionListener(this);
			removeMenu.add(removeMatchMenuItem);
			JMenuItem removeSubscriptionMenuItem = new JMenuItem("Remove SubscriptionFromMe");
			removeSubscriptionMenuItem.addActionListener(this);
			removeMenu.add(removeSubscriptionMenuItem);
			menuBar.add(removeMenu);
		}
		
		
		JMenu connectMenu = new JMenu("Connect");
		
		if(user.getType().equals(TypeOfUser.Admin)) {
			JMenuItem addCoachToTeamMenuItem = new JMenuItem("Add Coach To Team");
			addCoachToTeamMenuItem.addActionListener(this);
			connectMenu.add(addCoachToTeamMenuItem);
			
			JMenuItem addPlayerToTeamMenuItem = new JMenuItem("Add Player To Team");
			addPlayerToTeamMenuItem.addActionListener(this);
			connectMenu.add(addPlayerToTeamMenuItem);
			
			JMenuItem addPlayerToTeamfirstplayerMenuItem = new JMenuItem("Add Player To Team First Players");
			addPlayerToTeamfirstplayerMenuItem.addActionListener(this);
			connectMenu.add(addPlayerToTeamfirstplayerMenuItem);
			
			JMenuItem addReceptionistToStadiumMenuItem = new JMenuItem("Add Receptionist To Stadium");
			addReceptionistToStadiumMenuItem.addActionListener(this);
			connectMenu.add(addReceptionistToStadiumMenuItem);
			
			JMenuItem addCustomerToMatchMenuItem = new JMenuItem("Add Customer To Match");
			addCustomerToMatchMenuItem.addActionListener(this);
			connectMenu.add(addCustomerToMatchMenuItem);
			
			JMenuItem addSubToCustomerMenuItem = new JMenuItem("Add Subscription to Customer");
			addSubToCustomerMenuItem.addActionListener(this);
			connectMenu.add(addSubToCustomerMenuItem);
			
			menuBar.add(connectMenu);
		}
		if(user.getType().equals(TypeOfUser.Receptionist)) {
			JMenuItem addCustomerToMatchMenuItem = new JMenuItem("Add Customer To Match");
			addCustomerToMatchMenuItem.addActionListener(this);
			connectMenu.add(addCustomerToMatchMenuItem);
			
			JMenuItem addSubToCustomerMenuItem = new JMenuItem("Add Subscription to Customer");
			addSubToCustomerMenuItem.addActionListener(this);
			connectMenu.add(addSubToCustomerMenuItem);
			
			menuBar.add(connectMenu);
		}
		
		if(user.getType().equals(TypeOfUser.Coach)) {
			JMenuItem addPlayerToTeamMenuItem = new JMenuItem("Add Player To Team");
			addPlayerToTeamMenuItem.addActionListener(this);
			connectMenu.add(addPlayerToTeamMenuItem);
			
			JMenuItem addPlayerToTeamfirstplayerMenuItem = new JMenuItem("Add Player To Team First Players");
			addPlayerToTeamfirstplayerMenuItem.addActionListener(this);
			connectMenu.add(addPlayerToTeamfirstplayerMenuItem);
			menuBar.add(connectMenu);
		}
		
		JMenu actionsMenu = new JMenu("Actions");
		
		JMenuItem systemReportMenuItem = new JMenuItem("System Reports");
		systemReportMenuItem.addActionListener(this);
		actionsMenu.add(systemReportMenuItem);
		
		menuBar.add(actionsMenu);
		
		return menuBar;
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		String  cmd = ev.getActionCommand(); 
		String commandName = ev.getActionCommand();
		if (commandName.equals("AddMenu")) {
				addPanel win = new addPanel(this,user);
				win.setVisible(true);
				// this.dispose();
			
		}
		if (commandName.equals("ConnectMenu")) {
			connectPanel win = new connectPanel(this,user);
			win.setVisible(true);
			// this.dispose();
		
	}
		if (commandName.equals("RemoveMenu")) {
			RemovePanel win = new RemovePanel(this,user);
			win.setVisible(true);
			// this.dispose();
		
	}
		if (commandName.equals("SysRepMenu")) {
			SystemReports dlg = new SystemReports(user);
			desktopPane.add(dlg);
			dlg.setVisible(true);
		
	}
		else if(cmd.equals ("Save")) {
			sysData.save();
		}
		else if(cmd.equals ("Exit")) {
			int res = JOptionPane.showInternalConfirmDialog(desktopPane, "Do you want to save the changes?", getTitle(),
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(res == JOptionPane.YES_OPTION) {
				sysData.save();
			}
			if(res != JOptionPane.CANCEL_OPTION) {
				MyFileLogWriter.saveLogFile();
				Utility.playSound("wav/notify.wav");
				dispose();
			}
		}
		else if(cmd.equals ("Add Stadium")) {
			addStadium std = new addStadium();
			desktopPane.add(std);
			std.setVisible(true);
		}
		else if(cmd.equals ("Add Team")) {
			addTeam team = new addTeam();
			desktopPane.add(team);
			team.setVisible(true);
		}
		else if(cmd.equals ("Add Coach")) {
			addCoach dlg = new addCoach();
			desktopPane.add(dlg);
			dlg.setVisible(true);
		}
		else if(cmd.equals ("Add Player")) {
			addPlayer dlg = new addPlayer();
			desktopPane.add(dlg);
			dlg.setVisible(true);
		}
		else if(cmd.equals ("Add Customer")) {
			addCustomer dlg = new addCustomer();
			desktopPane.add(dlg);
			dlg.setVisible(true);
		}
		else if(cmd.equals ("Add Receptionist")) {
			addReceptionist dlg = new addReceptionist();
			desktopPane.add(dlg);
			dlg.setVisible(true);
		}
		else if(cmd.equals ("Add Match")) {
			addMatch dlg = new addMatch();
			desktopPane.add(dlg);
			dlg.setVisible(true);
		}
		else if(cmd.equals ("Add Customer To Match")) {
			addCustomerToMatch dlg = new addCustomerToMatch();
			desktopPane.add(dlg);
			dlg.setVisible(true);
		}
//		else if(cmd.equals ("Add Subscription To Customer")) {
//			AddSubscriptionToCustomer dlg = new AddSubscriptionToCustomer(user);
//			desktopPane.add(dlg);
//			dlg.setVisible(true);
//		}
		else if(cmd.equals ("Add Coach To Team")) {
			addCoachToTeam dlg = new addCoachToTeam();
			desktopPane.add(dlg);
			dlg.setVisible(true);
		}
		else if(cmd.equals("Add Player To Team")) {
			addPlayerToTeam dlg = new addPlayerToTeam();
			desktopPane.add(dlg);
			dlg.setVisible(true);
		}
		else if(cmd.equals("Add Player To Team First Players")) {
			addPlayerToTeamFirstPlayers dlg = new addPlayerToTeamFirstPlayers();
			desktopPane.add(dlg);
			dlg.setVisible(true);
		}
		
		else if(cmd.equals("Add Receptionist To Stadium")) {
			addReceptionistToStadium dlg = new addReceptionistToStadium();
			desktopPane.add(dlg);
			dlg.setVisible(true);
		}
		
		else if(cmd.equals("Add Subscription to Customer")) {
			addSubscriptionToCustomer dlg = new addSubscriptionToCustomer();
			desktopPane.add(dlg);
			dlg.setVisible(true);
		}
		
		else if(cmd.equals("Add Trophy")) {
			addTrophy dlg = new addTrophy();
			desktopPane.add(dlg);
			dlg.setVisible(true);
		}
		else if(cmd.equals ("Remove Subscription")) {
			removeSubscription dlg = new removeSubscription();
			desktopPane.add(dlg);
			dlg.setVisible(true);
		}
		else if(cmd.equals ("Remove Coach")) {
			removeCoach dlg = new removeCoach();
			desktopPane.add(dlg);
			dlg.setVisible(true);
		}
		else if(cmd.equals ("Remove Match")) {
			removeMatch dlg = new removeMatch();
			desktopPane.add(dlg);
			dlg.setVisible(true);
		}
		else if(cmd.equals ("Remove Customer")) {
			removeCustomer dlg = new removeCustomer();
			desktopPane.add(dlg);
			dlg.setVisible(true);
		}
		else if(cmd.equals ("Remove Player")) {
			RemovePlayer dlg = new RemovePlayer();
			desktopPane.add(dlg);
			dlg.setVisible(true);
		}
		else if(cmd.equals ("Remove Receptionist")) {
			RemoveReceptionist dlg = new RemoveReceptionist();
			desktopPane.add(dlg);
			dlg.setVisible(true);
		}
		else if(cmd.equals ("Remove Team")) {
			removeTeam dlg = new removeTeam();
			desktopPane.add(dlg);
			dlg.setVisible(true);
		}
		else if(cmd.equals ("Remove Stadium")) {
			RemoveStadium dlg = new RemoveStadium();
			desktopPane.add(dlg);
			dlg.setVisible(true);
		}
		else if(cmd.equals ("System Reports")) {
			SystemReports dlg = new SystemReports(user);
			desktopPane.add(dlg);
			dlg.setVisible(true);
		}
		else 	if(cmd.equals ("Remove SubscriptionByRecep")) {
			RecepRemoveSub m = new RecepRemoveSub(this.user);
			desktopPane.add(m);
			m.setVisible(true);
		}
		else 	if(cmd.equals ("Remove CustomerByRecep")) {
			removeCustByRecep cr = new removeCustByRecep(this.user);
			desktopPane.add(cr);
			cr.setVisible(true);
		}
		else 	if(cmd.equals ("Add MatchToMe")) {
			CustomerAddMatch m = new CustomerAddMatch(this.user);
			desktopPane.add(m);
			m.setVisible(true);
		}
		else 	if(cmd.equals ("Remove MatchFromMe")) {
			removeCustomersMatch m = new removeCustomersMatch(this.user);
			desktopPane.add(m);
			m.setVisible(true);
		}
		else 	if(cmd.equals ("Remove SubscriptionFromMe")) {
			removeMySubscription m = new removeMySubscription(this.user);
			desktopPane.add(m);
			m.setVisible(true);
		}
		else 	if(cmd.equals ("Add PlayerToMyTeam")) {
			addPlayerToMyTeam m = new addPlayerToMyTeam(this.user);
			desktopPane.add(m);
			m.setVisible(true);
		}
		else 	if(cmd.equals ("Add FirstPlayerToMyTeam")) {
			addFirstPlayerToMyTeam m = new addFirstPlayerToMyTeam(this.user);
			desktopPane.add(m);
			m.setVisible(true);
		}
		else 	if(cmd.equals ("Remove PlayerFromMyTeam")) {
			removePlayerFromTeam m = new removePlayerFromTeam(this.user);
			desktopPane.add(m);
			m.setVisible(true);
		}
		else 	if(cmd.equals ("Remove PlayerFromMyFirstTeam")) {
			removePlayerFromFirstTeam m = new removePlayerFromFirstTeam(this.user);
			desktopPane.add(m);
			m.setVisible(true);
		}
		
	}
	
}
