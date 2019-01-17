package GUI;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import utils.Utility;


public class MyInternalMessageBox {
	
	private JInternalFrame frm;
	
	public MyInternalMessageBox(JInternalFrame frm) {
		this.frm = frm;
	}

	public int showInternalConfirmDialog(String msg) {
		return JOptionPane.showInternalConfirmDialog(frm.getContentPane(), msg, frm.getTitle(),
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
	}
	
	public void showInternalErrorMessage(String msg) {
		Utility.playSound("wav/error.wav");
		JOptionPane.showInternalMessageDialog(frm.getContentPane(), msg, frm.getTitle(), JOptionPane.ERROR_MESSAGE);
	}
	
	public void showInternalInformationMessage(String msg) {
		Utility.playSound("wav/information.wav");
		JOptionPane.showInternalMessageDialog(frm.getContentPane(), msg, frm.getTitle(), JOptionPane.INFORMATION_MESSAGE);
	}
	
}
