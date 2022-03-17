package controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

import model.ThiSinh;
import model.Tinh;
import view.BangDiemView;
import view.QLSVView;

public class QLTSController implements ActionListener{

	public QLSVView view ;
	public BangDiemView scoreview;
	
	public QLTSController(QLSVView view) {
		this.view = view;
	}
	
	

	public QLTSController(QLSVView view, BangDiemView scoreview) {
		this.view = view;
		this.scoreview = scoreview;
	}



	public QLTSController() {
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		//JOptionPane.showMessageDialog(view, actionCommand);
		if (actionCommand.equals("ADD"))
		{
			this.view.xoaForm();
			//this.view.themThiSinh();
			JOptionPane.showMessageDialog(view, "ADD NOW");
		}
		else if (actionCommand.equals("SAVE"))
		{
			try {
				
				this.view.thucHienThemThiSinh();
				//JOptionPane.showMessageDialog(view, "ADD SUCESSFULLY");
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			}
		}
		else if (actionCommand.equals("UPDATE"))
		{
			// đây là hiển thị trên view
			this.view.luaChon = "UPDATE";
			this.view.hienThiThongTinThiSinhDaChon();
		} 
		else if(actionCommand.equals("DELETE"))
		{
			try {
				this.view.thucHienXoa();
			} catch (HeadlessException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		else if (actionCommand.equals("RESET"))
		{
			this.view.xoaForm();
		}
		else if (actionCommand.equals("SEARCH"))
		{
			this.view.thucHienTim();
		}
		else if (actionCommand.equals("CANCEL"))
		{
			this.view.thucHienTaiLaiDuLieu();
		}
		else if(actionCommand.equals("Open"))
		{
			
			this.view.ThucHienOpen();
			JOptionPane.showMessageDialog(view, "OPEN DATA");
		}
		else if(actionCommand.equals("About Me"))
		{
			JOptionPane.showMessageDialog(view, "This is the Student management software.\n"+ "The program is created by VOTUAN");
		}
		else if(actionCommand.equals("Exit"))
		{
			System.exit(0);
		}
		else if(actionCommand.equals("Back To Option"))
		{
			this.view.chuyenTabOption();
		}
		else if(actionCommand.equals("test"))
		{
			try {
				this.view.test();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	

}
