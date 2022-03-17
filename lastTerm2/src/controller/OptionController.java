package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.OPTION;

public class OptionController implements ActionListener{
	private OPTION option;
	
	public OptionController(OPTION option) {
		this.option = option;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Student information management"))
		{
			this.option.chuyenTabQLSV();
		}
		else if(src.equals("Student score management"))
		{
			this.option.chuyenTabQLSCORE();
		}
		
	}

}
