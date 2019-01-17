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
import javax.swing.JOptionPane;

import Controller.SysData;
import Model.User;
import utils.MyFileLogWriter;
import utils.TypeOfUser;
import utils.Utility;

public class addPanel extends JFrame implements ActionListener {

		private static final long serialVersionUID = 1L;
	private User user;
	private javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
	private JDesktopPane desktopPane = new JDesktopPane();
	private JButton addStadium = new JButton("Add Stadium");
	private JButton addTeam = new JButton("Add Team");
	private JButton addCoach = new JButton("Add Coach");
	private JButton addPlayer = new JButton("Add Player");
	private JButton addRecep = new JButton("Add Receptionist");
	private JButton addCustomer = new JButton("Add Customer");
	private JButton addTrophy = new JButton("Add Trophy");
	private JButton addMatch = new JButton("Add Match");
	private JButton addMatchToMe = new JButton("Add MatchToMe");
	private JButton addPlayerToMe = new JButton("Add PlayerToMyTeam");
	private JButton addFirstPlayerToMe = new JButton("Add FirstPlayerToMyTeam");
	private JButton UpdatePlayer = new JButton("Update PlayerInfo");
	private JButton UpdateCustomer = new JButton("Update CustomerInfo");
	private JButton BackButton = new JButton();
	protected MainApplication win;
	
	public addPanel(JFrame mainAppMenu, final User user) {
		
		this.user = user;
		this.win = new MainApplication(mainAppMenu, user);
		mainAppMenu.dispose();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 960, 540); 
		this.setResizable(false);
        desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        desktopPane.setBackground(Color.BLACK);
		this.setContentPane(desktopPane);
		
		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
	    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageC.jpg"))); // NOI18N
	    jLabel1.setBounds(0, 0, this.getWidth(),this.getHeight());
	    desktopPane.add(jLabel1);

	    addMatchToMe.setFont(new Font("", Font.BOLD, 12));
	    addMatchToMe.setBounds(135, 150, 244, 20);
	    addMatchToMe.setBackground(new Color(59, 89, 182));
	    addMatchToMe.setForeground(Color.WHITE);
	    addMatchToMe.setFocusPainted(false);
	    addMatchToMe.setFont(new Font("Tahoma", Font.BOLD, 12));
	    addMatchToMe.addActionListener(this);
	    addMatchToMe.setBorder(new RoundedBorder(10));
	    jLabel1.add(addMatchToMe);
	    addMatchToMe.setVisible(false);
	    
	    addStadium.setFont(new Font("", Font.BOLD, 12));
	    addStadium.setBounds(135, 150, 244, 20);
	    addStadium.setBackground(new Color(59, 89, 182));
	    addStadium.setForeground(Color.WHITE);
	    addStadium.setFocusPainted(false);
	    addStadium.setFont(new Font("Tahoma", Font.BOLD, 12));
	    addStadium.addActionListener(this);
	    addStadium.setBorder(new RoundedBorder(10));
	    jLabel1.add(addStadium);
	    
	    addPlayerToMe.setFont(new Font("", Font.BOLD, 12));
	    addPlayerToMe.setBounds(135, 150, 244, 20);
	    addPlayerToMe.setBackground(new Color(59, 89, 182));
	    addPlayerToMe.setForeground(Color.WHITE);
	    addPlayerToMe.setFocusPainted(false);
	    addPlayerToMe.setFont(new Font("Tahoma", Font.BOLD, 12));
	    addPlayerToMe.addActionListener(this);
	    addPlayerToMe.setBorder(new RoundedBorder(10));
	    jLabel1.add(addPlayerToMe);
	    addPlayerToMe.setVisible(false);
	    
	    addFirstPlayerToMe.setFont(new Font("", Font.BOLD, 12));
	    addFirstPlayerToMe.setBounds(135, 200, 244, 20);
	    addFirstPlayerToMe.setBackground(new Color(59, 89, 182));
	    addFirstPlayerToMe.setForeground(Color.WHITE);
	    addFirstPlayerToMe.setFocusPainted(false);
	    addFirstPlayerToMe.setFont(new Font("Tahoma", Font.BOLD, 12));
	    addFirstPlayerToMe.addActionListener(this);
	    addFirstPlayerToMe.setBorder(new RoundedBorder(10));
	    jLabel1.add(addFirstPlayerToMe);
	    addFirstPlayerToMe.setVisible(false);
	    
	    addTeam.setFont(new Font("", Font.BOLD, 12));
	    addTeam.setBounds(135, 200, 244, 20);
	    addTeam.setBackground(new Color(59, 89, 182));
	    addTeam.setForeground(Color.WHITE);
	    addTeam.setFocusPainted(false);
	    addTeam.setFont(new Font("Tahoma", Font.BOLD, 12));
	    addTeam.addActionListener(this);
	    addTeam.setBorder(new RoundedBorder(10));
	    jLabel1.add(addTeam);
	    
	    
	    UpdatePlayer.setFont(new Font("", Font.BOLD, 12));
	    UpdatePlayer.setBounds(135, 250, 244, 20);
	    UpdatePlayer.setBackground(new Color(59, 89, 182));
	    UpdatePlayer.setForeground(Color.WHITE);
	    UpdatePlayer.setFocusPainted(false);
	    UpdatePlayer.setFont(new Font("Tahoma", Font.BOLD, 12));
	    UpdatePlayer.addActionListener(this);
	    UpdatePlayer.setBorder(new RoundedBorder(10));
	    jLabel1.add(UpdatePlayer);
	    UpdatePlayer.setVisible(false);
	    
	    UpdateCustomer.setFont(new Font("", Font.BOLD, 12));
	    UpdateCustomer.setBounds(135, 250, 244, 20);
	    UpdateCustomer.setBackground(new Color(59, 89, 182));
	    UpdateCustomer.setForeground(Color.WHITE);
	    UpdateCustomer.setFocusPainted(false);
	    UpdateCustomer.setFont(new Font("Tahoma", Font.BOLD, 12));
	    UpdateCustomer.setBorder(new RoundedBorder(10));
	    UpdateCustomer.addActionListener(this);
	    jLabel1.add(UpdateCustomer);
	    UpdateCustomer.setVisible(false);
	    
	    addCoach.setFont(new Font("", Font.BOLD, 12));
	    addCoach.setBounds(135, 250, 244, 20);
	    addCoach.setBackground(new Color(59, 89, 182));
	    addCoach.setForeground(Color.WHITE);
	    addCoach.setFocusPainted(false);
	    addCoach.setFont(new Font("Tahoma", Font.BOLD, 12));
	    addCoach.addActionListener(this);
	    addCoach.setBorder(new RoundedBorder(10));
	    jLabel1.add(addCoach);
	    
	    addPlayer.setFont(new Font("", Font.BOLD, 12));
	    addPlayer.setBounds(135, 300, 244, 20);
	    addPlayer.setBackground(new Color(59, 89, 182));
	    addPlayer.setForeground(Color.WHITE);
	    addPlayer.setFocusPainted(false);
	    addPlayer.setFont(new Font("Tahoma", Font.BOLD, 12));
	    addPlayer.addActionListener(this);
	    addPlayer.setBorder(new RoundedBorder(10));
	    jLabel1.add(addPlayer);
	    
	    addRecep.setFont(new Font("", Font.BOLD, 12));
	    addRecep.setBounds(630, 150, 244, 20);
	    addRecep.setBackground(new Color(59, 89, 182));
	    addRecep.setForeground(Color.WHITE);
	    addRecep.setFocusPainted(false);
	    addRecep.setFont(new Font("Tahoma", Font.BOLD, 12));
	    addRecep.addActionListener(this);
	    addRecep.setBorder(new RoundedBorder(10));
	    jLabel1.add(addRecep);
	    
	    addMatch.setFont(new Font("", Font.BOLD, 12));
	    addMatch.setBounds(630, 200, 244, 20);
	    addMatch.setBackground(new Color(59, 89, 182));
	    addMatch.setForeground(Color.WHITE);
	    addMatch.setFocusPainted(false);
	    addMatch.setFont(new Font("Tahoma", Font.BOLD, 12));
	    addMatch.addActionListener(this);
	    addMatch.setBorder(new RoundedBorder(10));
	    jLabel1.add(addMatch);
	    
	    addCustomer.setFont(new Font("", Font.BOLD, 12));
	    addCustomer.setBounds(630, 250, 244, 20);
	    addCustomer.setBackground(new Color(59, 89, 182));
	    addCustomer.setForeground(Color.WHITE);
	    addCustomer.setFocusPainted(false);
	    addCustomer.setBorder(new RoundedBorder(10));
	    addCustomer.setFont(new Font("Tahoma", Font.BOLD, 12));
	    addCustomer.addActionListener(this);
	    jLabel1.add(addCustomer);
	    
	    addTrophy.setFont(new Font("", Font.BOLD, 12));
	    addTrophy.setBounds(630, 300, 244, 20);
	    addTrophy.setBackground(new Color(59, 89, 182));
	    addTrophy.setForeground(Color.WHITE);
	    addTrophy.setFocusPainted(false);
	    addTrophy.setFont(new Font("Tahoma", Font.BOLD, 12));
	    addTrophy.addActionListener(this);
	    addTrophy.setBorder(new RoundedBorder(10));
	    jLabel1.add(addTrophy);
	    

	    
		BackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bb1.png")));
	    BackButton.setBounds(85, 420, 56, 56);
	    BackButton.setFont(new Font("", Font.BOLD, 12));
	    BackButton.setBackground(new Color(59, 89, 182));
	    BackButton.setBorder(new RoundedBorder(10));
	    BackButton.setForeground(Color.WHITE);
	    BackButton.setFocusPainted(false);
	    BackButton.setFont(new Font("Tahoma", Font.BOLD, 12));
	    
	    BackButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				win.setVisible(true);
				addPanel.this.setVisible(false);
			}
	});
	    jLabel1.add(BackButton);
		
		
	    this.addWindowListener(new WindowAdapter() {
			public void windowClosing(final WindowEvent arg0) {
				if(JOptionPane.showInternalConfirmDialog(desktopPane, 
						"Do you want to save the changes?", getTitle(),
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					SysData.getInstance().save();
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
	    if(this.user.getType().equals(TypeOfUser.Coach)){
	    	addStadium.setVisible(false);
	    	addTeam.setVisible(false);
	    	addCoach.setVisible(false);
	    	addPlayer.setVisible(false);
	    	addRecep.setVisible(false);
	    	addCustomer.setVisible(false);
	    	addTrophy.setVisible(false);
	    	addMatch.setVisible(false);
	    	addMatchToMe.setVisible(false);
	    	addPlayerToMe.setVisible(true);
	    	addPlayerToMe.setBounds(87, 150, 244, 20);
	    	addFirstPlayerToMe.setVisible(true);
	    	addFirstPlayerToMe.setBounds(630, 150, 244, 20);
	    	UpdatePlayer.setVisible(true);
	    	UpdatePlayer.setBounds(135, 200, 244, 20);
	    }
	    if(this.user.getType().equals(TypeOfUser.Customer)){
	    	addStadium.setVisible(false);
	    	addTeam.setVisible(false);
	    	addCoach.setVisible(false);
	    	addPlayer.setVisible(false);
	    	addRecep.setVisible(false);
	    	addCustomer.setVisible(false);
	    	addTrophy.setVisible(false);
	    	addMatch.setVisible(false);
	    	
	    	addMatchToMe.setVisible(true);
	    	addMatchToMe.setBounds(135, 150, 244, 20);
	    	addPlayerToMe.setVisible(false);
	    	addPlayerToMe.setBounds(135, 630, 244, 20);
	    	addFirstPlayerToMe.setVisible(false);
	    	addFirstPlayerToMe.setBounds(135, 200, 244, 20);
	    	UpdatePlayer.setVisible(false);
	    	UpdatePlayer.setBounds(630, 200, 244, 20);
	    }
	    if(this.user.getType().equals(TypeOfUser.Receptionist)){
	    	addStadium.setVisible(false);
	    	addTeam.setVisible(false);
	    	addCoach.setVisible(false);
	    	addPlayer.setVisible(false);
	    	addRecep.setVisible(false);
	    	addCustomer.setVisible(true);
	    	addCustomer.setBounds(135, 150, 244, 20);
	    	addTrophy.setVisible(false);
	    	addMatch.setVisible(false);
	    	addMatchToMe.setVisible(false);
	    	addPlayerToMe.setVisible(false);
	    	addFirstPlayerToMe.setVisible(false);
	    	UpdatePlayer.setVisible(false);
	    	UpdateCustomer.setVisible(true);
	    	UpdateCustomer.setBounds(135, 630, 244, 20);
	    }
	    
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		String  cmd = arg0.getActionCommand(); 
		@SuppressWarnings("unused")
		String commandName = arg0.getActionCommand();
	if(cmd.equals ("Add Stadium")) {
			addStadium std = new addStadium();
			desktopPane.add(std);
			std.setVisible(true);
		}
	else 	if(cmd.equals ("Add Team")) {
		addTeam tm = new addTeam();
		desktopPane.add(tm);
		tm.setVisible(true);
	}
	else 	if(cmd.equals ("Add Coach")) {
		addCoach tm = new addCoach();
		desktopPane.add(tm);
		tm.setVisible(true);
	}
	else 	if(cmd.equals ("Add Player")) {
		addPlayer pl = new addPlayer();
		desktopPane.add(pl);
		pl.setVisible(true);
	}	
	else 	if(cmd.equals ("Add Receptionist")) {
		addReceptionist rp = new addReceptionist();
		desktopPane.add(rp);
		rp.setVisible(true);
	}	
	else 	if(cmd.equals ("Add Customer")) {
		addCustomer cr = new addCustomer();
		desktopPane.add(cr);
		cr.setVisible(true);
	}
	else 	if(cmd.equals ("Add Trophy")) {
		addTrophy tr = new addTrophy();
		desktopPane.add(tr);
		tr.setVisible(true);
	}
	else 	if(cmd.equals ("Add Match")) {
		addMatch m = new addMatch();
		desktopPane.add(m);
		m.setVisible(true);
	}
	else 	if(cmd.equals ("Add MatchToMe")) {
		CustomerAddMatch m = new CustomerAddMatch(this.user);
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
	else 	if(cmd.equals ("Update PlayerInfo")) {
		updatePlayerInfo m = new updatePlayerInfo(this.user);
		desktopPane.add(m);
		m.setVisible(true);
	}
	else 	if(cmd.equals ("Update CustomerInfo")) {
		updateCustomerInfo m = new updateCustomerInfo(this.user);
		desktopPane.add(m);
		m.setVisible(true);
	}
	}
	
	
}
