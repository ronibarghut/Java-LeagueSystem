package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;
import Controller.SysData;
import Model.Customer;
import Model.Player;

/**
 * General internal frame (abstract class)
 */
public abstract class MyInternalFrame extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
		
	protected JDesktopPane desktopPane = new JDesktopPane();
	protected MyInternalMessageBox messageBox;
	
	protected SysData sysData = SysData.getInstance();
	
	/**
	 * Constructor for the class MyInternalFrame 
	 * @param title
	 */
	public MyInternalFrame(String title) {
		super(title,true,true,true,true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 960, 540); 
		this.setResizable(false);
	    desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
	    desktopPane.setBackground(Color.BLACK);
		this.setContentPane(desktopPane);
		messageBox = new MyInternalMessageBox(this);
		
		this.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		this.setContentPane(desktopPane);
		
		desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
		desktopPane.setBorder(new LineBorder(Color.black, 1, false));
		desktopPane.setBackground(new Color(127, 255, 212));
		desktopPane.setAutoscrolls(true);
		
        Dimension screenSize = getToolkit().getScreenSize();
        setBounds(50, 50, screenSize.width  - 600, screenSize.height - 240);
	}
	
	protected  Integer[] getNumbersInRange(int left, int right) {
		Integer[] arr = new Integer[right-left+1];
		for(int i=left; i<=right; ++i) {
			arr[i-left] = i;
		}
		return arr;
	}
	
	protected  Integer[] getNumbersInRangeReverse(int left, int right) {
		Integer[] arr = new Integer[right-left+1];
		for(int i=right; i>=left; --i) {
			arr[right-i] = i;
		}
		return arr;
	}
	
	protected Collection<?> getVlaues(String type) {
		switch (type) {
		case "Stadiums":
			return sysData.getStadiums().values();
		case "Teams":
			return sysData.getTeams().values();
		case "Customers":
			return sysData.getCustomers().values();
		case "Receptionists":
			return sysData.getReceptionists().values();
		case "Coaches":
			return sysData.getCoachs().values();
		case "Players":
			return sysData.getPlayers().values();
		case "Subscriptions":
			return sysData.getSubs();
		case "Matches":
			return sysData.getMatchs().values();
		case "Trophies":
			return sysData.getTrophies();
		case "getAllSuperPlayerMakers":
			return sysData.getAllSuperPlayerMakers();
		case "getTheMostPopularPosition":
			return Arrays.asList(sysData.getTheMostPopularPosition());
		case "getTheMostFavoredTeam":
			return Arrays.asList(sysData.getTheMostFavoredTeam());
		case "getEntityWithMostTrophies":
			return Arrays.asList(sysData.getEntityWithMostTrophies());
		case "getTeamWithLargestHomeCrowd":
			return Arrays.asList(sysData.getTeamWithLargestHomeCrowd());
		case "getFirstPlayersOfBestHomeTeam":
			return Arrays.asList(sysData.getFirstPlayersOfBestHomeTeam());
		default:
			return null;
		}
	}

	protected Collection<?> getVlaues(String type , Integer r) {
		switch (type) {
		case "getSuperPlayerMaker":
			ArrayList<Player> a = new ArrayList<Player>();
			a.add(sysData.getSuperPlayerMaker(r));
			return a;
		case "getTheMostActiveCity":
			return Arrays.asList(sysData.getTheMostActiveCity(r));

			
		default:
			return null;
		}
	}

	protected Collection<?> getVlaues(String type , String r) {
		switch (type) {
		case "MySubscriptions":
			return sysData.getMySubs(r);
		case "MyMatches":
			return sysData.getMyMatches(r);
		case "MyTeamsHistory":
			int foo = Integer.parseInt(r);
			return sysData.getMyTeamsHist(foo);
		case "MyCurrentTeam":
			int foo2 = Integer.parseInt(r);
			return sysData.getMyCurrentTeam(foo2);
		case "MyCurrentTeamPlayers":
			int foo3 = Integer.parseInt(r);
			return sysData.getCoachsPlayers(foo3);
		case "MyCurrentTeamFirstPlayers":
			int foo4 = Integer.parseInt(r);
			return sysData.getCoachsFirstPlayers(foo4);
		case "MyMatchesHistory":
			int foo5 = Integer.parseInt(r);
			return sysData.getCoachsMatches(foo5);
		case "MyCustomers":
			int a = Integer.parseInt(r);
			return sysData.getAllMyCustomers(a);
			
		case "SubsByMe":
			int a2 = Integer.parseInt(r);
			return sysData.getAllSubsByMe(a2);
			
		default:
			return null;
		}
	}
	
	protected Collection<?> getVlaues(String type , Integer r , Integer r2) {
		switch (type) {
		case "getCustomersStadium1XORStadium2":
			ArrayList<Customer> a = sysData.getCustomersStadium1XORStadium2(r,r2);
			return a;

			
		default:
			return null;
		}
	}
	
	
}
