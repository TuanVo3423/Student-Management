package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import view.BangDiemView;

public class SCOREController implements ActionListener {
	private BangDiemView bangdiemview ;
	
	
	public SCOREController(BangDiemView bangdiemview) {
		this.bangdiemview = bangdiemview;
	}
	public SCOREController() {
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		System.out.println(src);
		if(src.equals("ADD")) {
			this.bangdiemview.xoaForm();
			
		}
		else if (src.equals("SAVE"))
		{
			this.bangdiemview.themBangDiem();
		}
		else if (src.equals("UPDATE"))
		{
			this.bangdiemview.HienThiBangDiemDangChon();
			//this.bangdiemview.capNhatBangDiem();
		}
		else if (src.equals("Open"))
		{
			try {
				this.bangdiemview.themTatCaVaoTable();
			} catch (ClassNotFoundException e1) {
				
				e1.printStackTrace();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		}
		else if (src.equals("DELETE"))
		{
			this.bangdiemview.xoaBangDiem();
		}
		else if(src.equals("SEARCH"))
		{
			try {
				this.bangdiemview.timkiem();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (src.equals("CANCEL"))
		{
			try {
				this.bangdiemview.thucHienTaiLaiBang();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (src.equals("TOP SCORE"))
		{
			try {
				this.bangdiemview.SapXepDiem();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(src.equals("Back To Menu"))
		{
			this.bangdiemview.chuyentabOption();
		}
		else if(src.equals("About Me"))
		{
			JOptionPane.showMessageDialog(bangdiemview, "This is the Student management software.\n"+ "The program is created by VOTUAN");
		}
		else if(src.equals("Exit"))
		{
			System.exit(0);
		}
		else if(src.equals("searchlilich"))
		{
			this.bangdiemview.timlilich();
		}
		else if (src.equals("test"))
		{
			try {
				this.bangdiemview.test();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(src.equals("testdtb"))
		{
			try {
				this.bangdiemview.testdtb();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
}
