package GUI;

import java.awt.BorderLayout;
import java.awt.Color; 
import java.awt.Font; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField; 

import Controller.SysData;
import Model.User;

/**
 * Login frame used for logging into the system
 */
public class LoginFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JButton loginButton = new JButton("Login");
	private JButton cancelButton = new JButton("EXIT");
	private JTextField idTextField = new JTextField();
	private JPasswordField passwordTextField = new JPasswordField();
	private SysData sysData;
	private javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
	public LoginFrame() {
		super("Login");
		this.sysData = SysData.getInstance();
		setBounds(200, 200, 960, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBackground(new Color(127, 255, 212));
		

		// define the layout of the frame to be borderLayout
		getContentPane().setLayout(new BorderLayout());

		// panel that contains the user name and password
		JPanel userDetailsPanel = new JPanel();
		userDetailsPanel.setLayout(null);
		userDetailsPanel.setBackground(Color.BLACK);
		
	    jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ucl_ball_bb.jpg"))); // NOI18N
        userDetailsPanel.add(jLabel1);
        jLabel1.setBounds(0, 0, 960, 450);
		
		JLabel idLabel = new JLabel("User ID: ");
		idLabel.setFont(new Font("", Font.BOLD, 12));
		idLabel.setBounds(111, 82, 61, 14);
		idLabel.setForeground(new Color(59, 89, 182));
		userDetailsPanel.add(idLabel);
		idTextField.setBounds(111, 104, 144, 20);
		idTextField.setFont(new Font("", Font.BOLD, 12));
		userDetailsPanel.add(idTextField);

			
		JLabel passwordLabel = new JLabel("Password: ");
		passwordLabel.setFont(new Font("", Font.BOLD, 12));
		passwordLabel.setBounds(111, 138, 74, 14);
		passwordLabel.setForeground(new Color(59, 89, 182));
		userDetailsPanel.add(passwordLabel);
		passwordTextField.setBounds(111, 160, 144, 20);
		passwordTextField.setFont(new Font("", Font.BOLD, 12));
		userDetailsPanel.add(passwordTextField);

		//JPanel buttonsPanel = new JPanel(new FlowLayout());
		loginButton.setFont(new Font("", Font.BOLD, 12));
		loginButton.setBounds(111, 350, 144, 20);
		loginButton.setBackground(new Color(59, 89, 182));
		loginButton.setForeground(Color.WHITE);
		loginButton.setFocusPainted(false);
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		cancelButton.setFont(new Font("", Font.BOLD, 12));
		cancelButton.setBounds(750, 350, 144, 20);
		cancelButton.setBackground(new Color(59, 89, 182));
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setFocusPainted(false);
		cancelButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		//buttonsPanel.add(loginButton);
		/////buttonsPanel.add(cancelButton);
		
		loginButton.addActionListener(this);
		cancelButton.addActionListener(this);
		jLabel1.add(idLabel);
		jLabel1.add(idTextField);
		jLabel1.add(passwordLabel);
		jLabel1.add(passwordTextField);
		jLabel1.add(loginButton);
		jLabel1.add(cancelButton);
		getContentPane().add(userDetailsPanel, BorderLayout.CENTER);

	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		String commandName = ev.getActionCommand();
		if (commandName.equals("Login")) {
			@SuppressWarnings("deprecation")
			User u = sysData.validateUser(idTextField.getText(), passwordTextField.getText());
			if (u != null) {
				SplashScreen win = new SplashScreen(this, u);
				this.dispose();
				this.sysData.isLoaded();
				win.setVisible(true);
				// this.dispose();
			} else {
				JOptionPane.showInternalMessageDialog(this.getContentPane(),
						"Incorrect user name or password\nPlease try again", this.getTitle(),
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (commandName.equals("EXIT")) {
			this.dispose();
		}
	}

	
	
}
