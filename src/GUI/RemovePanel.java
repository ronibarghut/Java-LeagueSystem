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

public class RemovePanel extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
private User user;
private javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
private JDesktopPane desktopPane = new JDesktopPane();
private JButton removeStadium = new JButton("Remove Stadium");
private JButton removeTeam = new JButton("Remove Team");
private JButton RemoveCoach = new JButton("Remove Coach");
private JButton RemovePlayer = new JButton("Remove Player");
private JButton RemoveRecep = new JButton("Remove Receptionist");
private JButton RemoveCustomer = new JButton("Remove Customer");
private JButton RemoveCustomerByRecep = new JButton("Remove CustomerByRecep");
private JButton RemoveSubscription = new JButton("Remove Subscription");
private JButton RecepRemoveSubscription = new JButton("Remove SubscriptionByRecep");
private JButton RemoveMatch = new JButton("Remove Match");
private JButton removeMatchFromMe = new JButton("Remove MatchFromMe");
private JButton removeSubscriptionFromMe = new JButton("Remove SubscriptionFromMe");
private JButton removePlayerFromMyTeam = new JButton("Remove PlayerFromMyTeam");
private JButton removePlayerFromMyFirstTeam = new JButton("Remove PlayerFromMyFirstTeam");
private JButton BackButton = new JButton();
protected MainApplication win;

public RemovePanel(JFrame mainAppMenu, final User user) {
	
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

    removePlayerFromMyTeam.setFont(new Font("", Font.BOLD, 12));
    removePlayerFromMyTeam.setBounds(87, 150, 244, 20);
    removePlayerFromMyTeam.setBackground(new Color(59, 89, 182));
    removePlayerFromMyTeam.setForeground(Color.WHITE);
    removePlayerFromMyTeam.setFocusPainted(false);
    removePlayerFromMyTeam.setFont(new Font("Tahoma", Font.BOLD, 12));
    removePlayerFromMyTeam.addActionListener(this);
    removePlayerFromMyTeam.setBorder(new RoundedBorder(10));
    jLabel1.add(removePlayerFromMyTeam);
    removePlayerFromMyTeam.setVisible(false);
    
    removeMatchFromMe.setFont(new Font("", Font.BOLD, 12));
    removeMatchFromMe.setBounds(87, 150, 244, 20);
    removeMatchFromMe.setBackground(new Color(59, 89, 182));
    removeMatchFromMe.setForeground(Color.WHITE);
    removeMatchFromMe.setFocusPainted(false);
    removeMatchFromMe.setFont(new Font("Tahoma", Font.BOLD, 12));
    removeMatchFromMe.addActionListener(this);
    removeMatchFromMe.setBorder(new RoundedBorder(10));
    jLabel1.add(removeMatchFromMe);
    
    removeMatchFromMe.setVisible(false);
    removeStadium.setFont(new Font("", Font.BOLD, 12));
    removeStadium.setBounds(87, 150, 244, 20);
    removeStadium.setBackground(new Color(59, 89, 182));
    removeStadium.setForeground(Color.WHITE);
    removeStadium.setFocusPainted(false);
    removeStadium.setFont(new Font("Tahoma", Font.BOLD, 12));
    removeStadium.addActionListener(this);
    removeStadium.setBorder(new RoundedBorder(10));
    jLabel1.add(removeStadium);
    
    removePlayerFromMyFirstTeam.setFont(new Font("", Font.BOLD, 12));
    removePlayerFromMyFirstTeam.setBounds(87, 200, 244, 20);
    removePlayerFromMyFirstTeam.setBackground(new Color(59, 89, 182));
    removePlayerFromMyFirstTeam.setForeground(Color.WHITE);
    removePlayerFromMyFirstTeam.setFocusPainted(false);
    removePlayerFromMyFirstTeam.setFont(new Font("Tahoma", Font.BOLD, 12));
    removePlayerFromMyFirstTeam.addActionListener(this);
    removePlayerFromMyFirstTeam.setBorder(new RoundedBorder(10));
    jLabel1.add(removePlayerFromMyFirstTeam);
    removePlayerFromMyFirstTeam.setVisible(false);
    
    removeSubscriptionFromMe.setFont(new Font("", Font.BOLD, 12));
    removeSubscriptionFromMe.setBounds(87, 200, 244, 20);
    removeSubscriptionFromMe.setBackground(new Color(59, 89, 182));
    removeSubscriptionFromMe.setForeground(Color.WHITE);
    removeSubscriptionFromMe.setFocusPainted(false);
    removeSubscriptionFromMe.setFont(new Font("Tahoma", Font.BOLD, 12));
    removeSubscriptionFromMe.addActionListener(this);
    jLabel1.add(removeSubscriptionFromMe);
    removeSubscriptionFromMe.setBorder(new RoundedBorder(10));
    removeSubscriptionFromMe.setVisible(false);
    
    removeTeam.setFont(new Font("", Font.BOLD, 12));
    removeTeam.setBounds(87, 200, 244, 20);
    removeTeam.setBackground(new Color(59, 89, 182));
    removeTeam.setForeground(Color.WHITE);
    removeTeam.setFocusPainted(false);
    removeTeam.setFont(new Font("Tahoma", Font.BOLD, 12));
    removeTeam.addActionListener(this);
    removeTeam.setBorder(new RoundedBorder(10));
    jLabel1.add(removeTeam);
    
    RemoveCoach.setFont(new Font("", Font.BOLD, 12));
    RemoveCoach.setBounds(87, 250, 244, 20);
    RemoveCoach.setBackground(new Color(59, 89, 182));
    RemoveCoach.setForeground(Color.WHITE);
    RemoveCoach.setFocusPainted(false);
    RemoveCoach.setFont(new Font("Tahoma", Font.BOLD, 12));
    RemoveCoach.addActionListener(this);
    RemoveCoach.setBorder(new RoundedBorder(10));
    jLabel1.add(RemoveCoach);
    
    RemovePlayer.setFont(new Font("", Font.BOLD, 12));
    RemovePlayer.setBounds(87, 300, 244, 20);
    RemovePlayer.setBackground(new Color(59, 89, 182));
    RemovePlayer.setForeground(Color.WHITE);
    RemovePlayer.setFocusPainted(false);
    RemovePlayer.setFont(new Font("Tahoma", Font.BOLD, 12));
    RemovePlayer.addActionListener(this);
    RemovePlayer.setBorder(new RoundedBorder(10));
    jLabel1.add(RemovePlayer);
    
    RemoveRecep.setFont(new Font("", Font.BOLD, 12));
    RemoveRecep.setBounds(630, 150, 244, 20);
    RemoveRecep.setBackground(new Color(59, 89, 182));
    RemoveRecep.setForeground(Color.WHITE);
    RemoveRecep.setFocusPainted(false);
    RemoveRecep.setFont(new Font("Tahoma", Font.BOLD, 12));
    RemoveRecep.addActionListener(this);
    RemoveRecep.setBorder(new RoundedBorder(10));
    jLabel1.add(RemoveRecep);
    
    RemoveMatch.setFont(new Font("", Font.BOLD, 12));
    RemoveMatch.setBounds(630, 200, 244, 20);
    RemoveMatch.setBackground(new Color(59, 89, 182));
    RemoveMatch.setForeground(Color.WHITE);
    RemoveMatch.setFocusPainted(false);
    RemoveMatch.setFont(new Font("Tahoma", Font.BOLD, 12));
    RemoveMatch.addActionListener(this);
    RemoveMatch.setBorder(new RoundedBorder(10));
    jLabel1.add(RemoveMatch);
    
    RemoveCustomer.setFont(new Font("", Font.BOLD, 12));
    RemoveCustomer.setBounds(630, 250, 244, 20);
    RemoveCustomer.setBackground(new Color(59, 89, 182));
    RemoveCustomer.setForeground(Color.WHITE);
    RemoveCustomer.setFocusPainted(false);
    RemoveCustomer.setFont(new Font("Tahoma", Font.BOLD, 12));
    RemoveCustomer.addActionListener(this);
    RemoveCustomer.setBorder(new RoundedBorder(10));
    jLabel1.add(RemoveCustomer);
    
    RemoveCustomerByRecep.setFont(new Font("", Font.BOLD, 12));
    RemoveCustomerByRecep.setBounds(630, 250, 244, 20);
    RemoveCustomerByRecep.setBackground(new Color(59, 89, 182));
    RemoveCustomerByRecep.setForeground(Color.WHITE);
    RemoveCustomerByRecep.setFocusPainted(false);
    RemoveCustomerByRecep.setFont(new Font("Tahoma", Font.BOLD, 12));
    RemoveCustomerByRecep.addActionListener(this);
    RemoveCustomerByRecep.setBorder(new RoundedBorder(10));
    jLabel1.add(RemoveCustomerByRecep);
    
    RemoveSubscription.setFont(new Font("", Font.BOLD, 12));
    RemoveSubscription.setBounds(630, 300, 244, 20);
    RemoveSubscription.setBackground(new Color(59, 89, 182));
    RemoveSubscription.setForeground(Color.WHITE);
    RemoveSubscription.setFocusPainted(false);
    RemoveSubscription.setFont(new Font("Tahoma", Font.BOLD, 12));
    RemoveSubscription.addActionListener(this);
    RemoveSubscription.setBorder(new RoundedBorder(10));
    jLabel1.add(RemoveSubscription);
    
    RecepRemoveSubscription.setFont(new Font("", Font.BOLD, 12));
    RecepRemoveSubscription.setBounds(630, 300, 244, 20);
    RecepRemoveSubscription.setBackground(new Color(59, 89, 182));
    RecepRemoveSubscription.setForeground(Color.WHITE);
    RecepRemoveSubscription.setFocusPainted(false);
    RecepRemoveSubscription.setFont(new Font("Tahoma", Font.BOLD, 12));
    RecepRemoveSubscription.addActionListener(this);
    RecepRemoveSubscription.setBorder(new RoundedBorder(10));
    jLabel1.add(RecepRemoveSubscription);
    RecepRemoveSubscription.setVisible(false);
    
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
			RemovePanel.this.setVisible(false);
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
    	removeStadium.setVisible(false);
    	removeTeam.setVisible(false);
    	RemoveCoach.setVisible(false);
    	RemovePlayer.setVisible(false);
    	RemoveRecep.setVisible(false);
    	RemoveCustomer.setVisible(false);
    	RemoveSubscription.setVisible(false);
    	RemoveMatch.setVisible(false);
    	removeMatchFromMe.setVisible(false);
    	removeSubscriptionFromMe.setVisible(false);
    	RecepRemoveSubscription.setVisible(false);
    	
    	removePlayerFromMyTeam.setVisible(true);
    	removePlayerFromMyTeam.setBounds(87, 150, 244, 20);
    	removePlayerFromMyFirstTeam.setVisible(true);
    	removePlayerFromMyFirstTeam.setBounds(630, 150, 244, 20);
    	
    }
    if(this.user.getType().equals(TypeOfUser.Customer)){
    	removeStadium.setVisible(false);
    	removeTeam.setVisible(false);
    	RemoveCoach.setVisible(false);
    	RemovePlayer.setVisible(false);
    	RemoveRecep.setVisible(false);
    	RemoveCustomer.setVisible(false);
    	RemoveSubscription.setVisible(false);
    	RemoveMatch.setVisible(false);
    	RecepRemoveSubscription.setVisible(false);
    	removePlayerFromMyTeam.setVisible(false);
    	removePlayerFromMyFirstTeam.setVisible(false);
    	
    	removeMatchFromMe.setVisible(true);
    	removeMatchFromMe.setBounds(87, 150, 244, 20);
    	removeSubscriptionFromMe.setVisible(true);
    	removeSubscriptionFromMe.setBounds(630, 150, 244, 20);
    }
    if(this.user.getType().equals(TypeOfUser.Receptionist)){
    	removeStadium.setVisible(false);
    	removeTeam.setVisible(false);
    	RemoveCoach.setVisible(false);
    	RemovePlayer.setVisible(false);
    	RemoveRecep.setVisible(false);
    	RemoveCustomer.setVisible(false);
    	RemoveCustomerByRecep.setVisible(true);
    	RemoveCustomerByRecep.setBounds(87, 150, 244, 20);
    	
    	RemoveSubscription.setVisible(false);
    	
    	RecepRemoveSubscription.setVisible(true);
    	RecepRemoveSubscription.setBounds(630, 150, 244, 20);
    	
    	RemoveMatch.setVisible(false);
    	removeMatchFromMe.setVisible(false);
    	removeSubscriptionFromMe.setVisible(false);
    	removePlayerFromMyTeam.setVisible(false);
    	removePlayerFromMyFirstTeam.setVisible(false);
    }
    
}



@Override
public void actionPerformed(ActionEvent arg0) {
	String  cmd = arg0.getActionCommand(); 
	@SuppressWarnings("unused")
	String commandName = arg0.getActionCommand();
if(cmd.equals ("Remove Stadium")) {
		RemoveStadium std = new RemoveStadium();
		desktopPane.add(std);
		std.setVisible(true);
	}
else 	if(cmd.equals ("Remove Team")) {
	removeTeam tm = new removeTeam();
	desktopPane.add(tm);
	tm.setVisible(true);
}
else 	if(cmd.equals ("Remove Coach")) {
	removeCoach tm = new removeCoach();
	desktopPane.add(tm);
	tm.setVisible(true);
}
else 	if(cmd.equals ("Remove Player")) {
	RemovePlayer pl = new RemovePlayer();
	desktopPane.add(pl);
	pl.setVisible(true);
}	
else 	if(cmd.equals ("Remove Receptionist")) {
	RemoveReceptionist rp = new RemoveReceptionist();
	desktopPane.add(rp);
	rp.setVisible(true);
}	
else 	if(cmd.equals ("Remove Customer")) {
	removeCustomer cr = new removeCustomer();
	desktopPane.add(cr);
	cr.setVisible(true);
}
else 	if(cmd.equals ("Remove CustomerByRecep")) {
	removeCustByRecep cr = new removeCustByRecep(this.user);
	desktopPane.add(cr);
	cr.setVisible(true);
}
else 	if(cmd.equals ("Remove Subscription")) {
	removeSubscription tr = new removeSubscription();
	desktopPane.add(tr);
	tr.setVisible(true);
}
else 	if(cmd.equals ("Remove Match")) {
	removeMatch m = new removeMatch();
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
else 	if(cmd.equals ("Remove SubscriptionByRecep")) {
	RecepRemoveSub m = new RecepRemoveSub(this.user);
	desktopPane.add(m);
	m.setVisible(true);
}

}


}
