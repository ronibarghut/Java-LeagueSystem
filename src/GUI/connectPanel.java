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

public class connectPanel  extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
private User user;
private javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
private JDesktopPane desktopPane = new JDesktopPane();
private JButton addcoachToTeam = new JButton("Add Coach To Team");
private JButton addPlayerToTeam = new JButton("Add Player To Team");
private JButton addRecepToStad = new JButton("Add Receptionist To Stadium");
private JButton addSubToCust = new JButton("Add Subscription to Customer");
private JButton addCustToMatch = new JButton("Add Customer To Match");
private JButton addCustomer = new JButton("Add Customer");
private JButton addPlayerToFirstTeamPlayers = new JButton("Add Player To Team First Players");
private JButton BackButton = new JButton();
protected MainApplication win;

public connectPanel(JFrame mainAppMenu, final User user) {
	
	this.user = user;
	this.win  = new MainApplication(mainAppMenu, user);
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
    
    addcoachToTeam.setFont(new Font("", Font.BOLD, 12));
    addcoachToTeam.setBounds(87, 150, 244, 20);
    addcoachToTeam.setBackground(new Color(59, 89, 182));
    addcoachToTeam.setForeground(Color.WHITE);
    addcoachToTeam.setFocusPainted(false);
    addcoachToTeam.setFont(new Font("Tahoma", Font.BOLD, 12));
    addcoachToTeam.addActionListener(this);
    addcoachToTeam.setBorder(new RoundedBorder(10));
    jLabel1.add(addcoachToTeam);
    
    addPlayerToTeam.setFont(new Font("", Font.BOLD, 12));
    addPlayerToTeam.setBounds(87, 200, 244, 20);
    addPlayerToTeam.setBackground(new Color(59, 89, 182));
    addPlayerToTeam.setForeground(Color.WHITE);
    addPlayerToTeam.setFocusPainted(false);
    addPlayerToTeam.setFont(new Font("Tahoma", Font.BOLD, 12));
    addPlayerToTeam.addActionListener(this);
    addPlayerToTeam.setBorder(new RoundedBorder(10));
    jLabel1.add(addPlayerToTeam);
    
    addPlayerToFirstTeamPlayers.setFont(new Font("", Font.BOLD, 12));
    addPlayerToFirstTeamPlayers.setBounds(87, 250, 244, 20);
    addPlayerToFirstTeamPlayers.setBackground(new Color(59, 89, 182));
    addPlayerToFirstTeamPlayers.setForeground(Color.WHITE);
    addPlayerToFirstTeamPlayers.setFocusPainted(false);
    addPlayerToFirstTeamPlayers.setFont(new Font("Tahoma", Font.BOLD, 12));
    addPlayerToFirstTeamPlayers.addActionListener(this);
    addPlayerToFirstTeamPlayers.setBorder(new RoundedBorder(10));
    jLabel1.add(addPlayerToFirstTeamPlayers);
    
    addRecepToStad.setFont(new Font("", Font.BOLD, 12));
    addRecepToStad.setBounds(630, 150, 244, 20);
    addRecepToStad.setBackground(new Color(59, 89, 182));
    addRecepToStad.setForeground(Color.WHITE);
    addRecepToStad.setFocusPainted(false);
    addRecepToStad.setFont(new Font("Tahoma", Font.BOLD, 12));
    addRecepToStad.addActionListener(this);
    addRecepToStad.setBorder(new RoundedBorder(10));
    jLabel1.add(addRecepToStad);
    
    addSubToCust.setFont(new Font("", Font.BOLD, 12));
    addSubToCust.setBounds(630, 200, 244, 20);
    addSubToCust.setBackground(new Color(59, 89, 182));
    addSubToCust.setForeground(Color.WHITE);
    addSubToCust.setFocusPainted(false);
    addSubToCust.setFont(new Font("Tahoma", Font.BOLD, 12));
    addSubToCust.addActionListener(this);
    addSubToCust.setBorder(new RoundedBorder(10));
    jLabel1.add(addSubToCust);
    
    addCustToMatch.setFont(new Font("", Font.BOLD, 12));
    addCustToMatch.setBounds(630, 250, 244, 20);
    addCustToMatch.setBackground(new Color(59, 89, 182));
    addCustToMatch.setForeground(Color.WHITE);
    addCustToMatch.setFocusPainted(false);
    addCustToMatch.setFont(new Font("Tahoma", Font.BOLD, 12));
    addCustToMatch.addActionListener(this);
    addCustToMatch.setBorder(new RoundedBorder(10));
    jLabel1.add(addCustToMatch);
    

    
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
			connectPanel.this.setVisible(false);
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
    
    if(user.getType().equals(TypeOfUser.Customer)){
    	this.addcoachToTeam.setVisible(false);
    	this.addPlayerToFirstTeamPlayers.setVisible(false);
    	this.addPlayerToTeam.setVisible(false);
    	this.addRecepToStad.setVisible(false);
    	this.addSubToCust.setVisible(false);
    	this.addCustomer.setVisible(false);
    	this.addCustToMatch.setVisible(true);
    	this.addCustToMatch.setBounds(87, 150, 244, 20);
    }
    if(this.user.getType().equals(TypeOfUser.Receptionist)){
    	this.addcoachToTeam.setVisible(false);
    	this.addPlayerToFirstTeamPlayers.setVisible(false);
    	this.addPlayerToTeam.setVisible(false);
    	this.addRecepToStad.setVisible(false);
    	this.addCustomer.setVisible(true);
    	this.addCustomer.setBounds(87, 200, 244, 20);
    	this.addSubToCust.setVisible(true);
    	this.addSubToCust.setBounds(87, 150, 244, 20);
    	this.addCustToMatch.setVisible(true);
    	this.addCustToMatch.setBounds(630, 150, 244, 20);
    }
    if(this.user.getType().equals(TypeOfUser.Coach)){
    	this.addcoachToTeam.setVisible(false);
    	this.addPlayerToFirstTeamPlayers.setVisible(true);
    	this.addPlayerToFirstTeamPlayers.setBounds(87, 150, 244, 20);
    	this.addPlayerToTeam.setVisible(true);
    	this.addRecepToStad.setVisible(false);
    	this.addSubToCust.setVisible(false);
    	this.addCustomer.setVisible(false);
    	this.addCustToMatch.setVisible(false);
    }
}



@Override
public void actionPerformed(ActionEvent arg0) {
	String  cmd = arg0.getActionCommand(); 
	@SuppressWarnings("unused")
	String commandName = arg0.getActionCommand();
if(cmd.equals ("Add Coach To Team")) {
	addCoachToTeam ctt = new addCoachToTeam();
		desktopPane.add(ctt);
		ctt.setVisible(true);
	}
else 	if(cmd.equals ("Add Player To Team")) {
	addPlayerToTeam tm = new addPlayerToTeam();
	desktopPane.add(tm);
	tm.setVisible(true);
}
else 	if(cmd.equals ("Add Player To Team First Players")) {
	addPlayerToTeamFirstPlayers tm = new addPlayerToTeamFirstPlayers();
	desktopPane.add(tm);
	tm.setVisible(true);
}
else 	if(cmd.equals ("Add Receptionist To Stadium")) {
	addReceptionistToStadium pl = new addReceptionistToStadium();
	desktopPane.add(pl);
	pl.setVisible(true);
}	
else 	if(cmd.equals ("Add Subscription to Customer")) {
	addSubscriptionToCustomer rp = new addSubscriptionToCustomer();
	desktopPane.add(rp);
	rp.setVisible(true);
}	
else 	if(cmd.equals ("Add Customer To Match")) {
	addCustomerToMatch cr = new addCustomerToMatch();
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

}


}
