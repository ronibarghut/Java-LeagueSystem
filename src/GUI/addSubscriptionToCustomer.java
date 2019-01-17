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
 
import utils.E_Periods; 

public class addSubscriptionToCustomer extends MyInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
	protected JTextField SubIDTextField = new JTextField();
	private JComboBox<Integer> RecComboBox = new JComboBox<Integer>(sysData.getRecepIDS());
	private JComboBox<String> CustComboBox = new JComboBox<String>(sysData.getCustomersIDS());
	protected JComboBox<E_Periods> PeriodComboBox = new JComboBox<E_Periods>(E_Periods.values());
	
	protected JComboBox<Integer> dayComboBox = new // JComboBox<Integer>();
	JComboBox<Integer>(getNumbersInRange(1, 31));
	protected JComboBox<Integer> monthComboBox = new // JComboBox<Integer>();
	JComboBox<Integer>(getNumbersInRange(1, 12));
	protected JComboBox<Integer> yearComboBox = new // JComboBox<Integer>();
	JComboBox<Integer>(getNumbersInRangeReverse(1920, 2017));
	
	public addSubscriptionToCustomer(){
		super("Add Subscription to Customer");
		
		setBounds(70, 30, 700, 440); 
		
        desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        desktopPane.setBackground(Color.BLACK);
		this.setContentPane(desktopPane);
		
		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
	    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qq3.jpg"))); // NOI18N
	    jLabel1.setBounds(0, 0, this.getWidth(),this.getHeight());
	    desktopPane.add(jLabel1);
		
		final JLabel SubIDLable = new JLabel("Subscription ID:");
		SubIDLable.setFont(new Font("", Font.BOLD, 12));
		SubIDLable.setBounds(150, 20, 105, 20);
		SubIDLable.setForeground(Color.WHITE);
		jLabel1.add(SubIDLable);

		SubIDTextField.setFont(new Font("", Font.BOLD, 12));
		SubIDTextField.setBounds(265, 20, 241, 20);
		jLabel1.add(SubIDTextField);
		
		final JLabel CustLabel = new JLabel("Customer ID:");
		CustLabel.setFont(new Font("", Font.BOLD, 12));
		CustLabel.setBounds(150, 71, 99, 20);
		CustLabel.setForeground(Color.WHITE);
		jLabel1.add(CustLabel);

		CustComboBox.setFont(new Font("", Font.BOLD, 12));
		CustComboBox.setBounds(265, 71, 241, 20);
		jLabel1.add(CustComboBox);
		
		final JLabel recepIDLabel = new JLabel("Receptionist ID:");
		recepIDLabel.setFont(new Font("", Font.BOLD, 12));
		recepIDLabel.setBounds(150, 125, 137, 20);
		recepIDLabel.setForeground(Color.WHITE);
		jLabel1.add(recepIDLabel);

		RecComboBox.setFont(new Font("", Font.BOLD, 12));
		RecComboBox.setBounds(265, 125, 241, 20);
		jLabel1.add(RecComboBox);
		
		
		final JLabel birthDateLabel = new JLabel("Start Date:");
		birthDateLabel.setFont(new Font("", Font.BOLD, 12));
		birthDateLabel.setBounds(150, 180, 137, 16);
		birthDateLabel.setForeground(Color.WHITE);
		jLabel1.add(birthDateLabel);

		dayComboBox.setFont(new Font("", Font.BOLD, 12));
		dayComboBox.setBounds(265, 180, 59, 20);
		jLabel1.add(dayComboBox);

		monthComboBox.setFont(new Font("", Font.BOLD, 12));
		monthComboBox.setBounds(340, 180, 59, 20);
		jLabel1.add(monthComboBox);

		yearComboBox.setFont(new Font("", Font.BOLD, 12));
		yearComboBox.setBounds(420, 180, 76, 20);
		jLabel1.add(yearComboBox);
		
		final JLabel periodLabel = new JLabel("Period:");
		periodLabel.setFont(new Font("", Font.BOLD, 12));
		periodLabel.setBounds(150, 240, 137, 20);
		periodLabel.setForeground(Color.WHITE);
		jLabel1.add(periodLabel);

		PeriodComboBox.setFont(new Font("", Font.BOLD, 12));
		PeriodComboBox.setBounds(265, 240, 241, 20);
		jLabel1.add(PeriodComboBox);
		
		JButton addButton = new JButton("Connect");
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
	
	
	
	
	protected Date getStartDate() throws ParseException {
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
			else if(arg0.getActionCommand().equals("Connect")){
			if(RecComboBox.getSelectedIndex() == -1) {
				throw new Exception("No Receptionist selected!");
			}
			if(CustComboBox.getSelectedIndex() == -1) {
				throw new Exception("No Customer selected!");
			}
			int recepID = RecComboBox.getItemAt(RecComboBox.getSelectedIndex());
			String CustID = CustComboBox.getItemAt(CustComboBox.getSelectedIndex());
				if(sysData.addSubscriptionToCustomer(Integer.parseInt(SubIDTextField.getText()), CustID,
						recepID, PeriodComboBox.getItemAt(PeriodComboBox.getSelectedIndex()), this.getStartDate())) {
					messageBox.showInternalInformationMessage("Receptionist " + recepID +
							"\nhas successfully added new subscription to Customer " + CustID);
				}
				else {
					messageBox.showInternalErrorMessage("Receptionist " + recepID +
							"\nFailed to add a new subscription to Customer  " + CustID);
					
				}
		}
		}
		catch(Exception e) {
			messageBox.showInternalErrorMessage(e.getMessage());
		}
		
	}
	
	
}
