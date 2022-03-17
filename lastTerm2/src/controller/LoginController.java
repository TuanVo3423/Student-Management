package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import view.Login;

public class LoginController implements ActionListener {
	private Login login ;
	
	public LoginController(Login login) {
		this.login = login;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("LOGIN"))
		{
			try {
				this.login.loginaccount();
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}

}
