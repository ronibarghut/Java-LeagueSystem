package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.*;

import Model.User;

public class SplashScreen extends JWindow {
	private static final long serialVersionUID = 1L;
	
    private static JProgressBar progressBar = new JProgressBar();
    @SuppressWarnings("unused")
	private static SplashScreen splashScreen;
    private static int count = 1, TIMER_PAUSE = 25,PROGBAR_MAX=100;
    private static Timer progressBarTimer;
    private User u = null;
    private JFrame f = null;
    ActionListener al = new ActionListener() {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            progressBar.setValue(count);
            if (PROGBAR_MAX == count) {
            	count = 1;
            	
                progressBarTimer.stop();//stop the timer
//                createAndShowFrame();
                MainApplication win = new MainApplication(f,u);
                win.setVisible(true);
                SplashScreen.this.setVisible(false);
            }
            count++;//increase counter

        }
    };

    public SplashScreen(JFrame loginFrame, final User user) {
    	this.u = user;
    	this.f = loginFrame;
        createSplash();
    }

    private void createSplash() {
        Container container = getContentPane();
        JPanel panel = new JPanel();
        container.add(panel, BorderLayout.CENTER);

        JLabel label = new JLabel("Welcome "+this.u.getType()+" "+this.u.getUser()+", Loading information please wait...");
        label.setFont(new Font("Verdana", Font.BOLD, 14));
        panel.add(label);

        progressBar.setMaximum(PROGBAR_MAX);
        progressBar.setForeground(Color.BLACK);
        container.add(progressBar, BorderLayout.SOUTH);


        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        startProgressBar();
      
    }

    private void startProgressBar() {
        progressBarTimer = new Timer(TIMER_PAUSE, al);
        progressBarTimer.start();
    }

//    private void createAndShowFrame() {
//        JFrame frame = new JFrame();
//        frame.setSize(500, 500);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//    }
}