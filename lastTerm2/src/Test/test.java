package Test;

import javax.swing.UIManager;

import view.Login;
import view.QLSVView;
import view.Register;

public class test {
	public static void main(String[] args) {
		try {
//			com.sun.java.swing.plaf.gtk.GTKLookAndFeel
//			com.sun.java.swing.plaf.motif.MotifLookAndFeel
//			com.sun.java.swing.plaf.windows.WindowsLookAndFeel
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
//		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			Login login = new Login();
			login.setLocationRelativeTo(null);
			login.setVisible(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}	
		

	}

}
