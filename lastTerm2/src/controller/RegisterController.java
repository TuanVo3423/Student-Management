package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Register;

public class RegisterController implements ActionListener {
	private Register register;
	
	public RegisterController(Register register) {
		this.register = register;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("LOGIN"))
		{
			this.register.ChuyenTabLogin();
		}
		
	}

}
