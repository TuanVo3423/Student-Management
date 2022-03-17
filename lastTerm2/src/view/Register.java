package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.RegisterController;
import controller.StudentDB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField confirmtext;
	Connection conn;
	Statement stmt ;
	private JPasswordField passwordtext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Register.class.getResource("/view/user-info-icon.png")));
		setTitle("RIGISTER AN ACCOUNT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		RegisterController action = new RegisterController(this);
		
		JLabel jlabelDK = new JLabel("REGISTER AN ACCOUNT");
		jlabelDK.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlabelDK.setBounds(151, 25, 187, 28);
		contentPane.add(jlabelDK);
		
		JLabel jlabelUserDKUSER = new JLabel("User");
		jlabelUserDKUSER.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlabelUserDKUSER.setBounds(26, 76, 84, 28);
		contentPane.add(jlabelUserDKUSER);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(26, 114, 84, 28);
		contentPane.add(lblPassword);
		
		JLabel lblConfirm = new JLabel("Confirm Password");
		lblConfirm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirm.setBounds(23, 152, 119, 28);
		contentPane.add(lblConfirm);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(153, 76, 202, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		 passwordtext = new JPasswordField();
		 passwordtext.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		passwordtext.setBounds(153, 114, 202, 26);
		contentPane.add(passwordtext);
		
		confirmtext = new JPasswordField();
		confirmtext.setFont(new Font("Tahoma", Font.PLAIN, 16));
		confirmtext.setBounds(152, 152, 203, 26);
		contentPane.add(confirmtext);
		
		JButton jbuttonDKLOGIN = new JButton("LOGIN");
		jbuttonDKLOGIN.setIcon(new ImageIcon(Register.class.getResource("/view/Login-icon.png")));
		jbuttonDKLOGIN.addActionListener(action);
		jbuttonDKLOGIN.setBounds(26, 218, 126, 35);
		contentPane.add(jbuttonDKLOGIN);
		
		JButton jbuttonDKREGISTER = new JButton("REGISTER");
		jbuttonDKREGISTER.setIcon(new ImageIcon(Register.class.getResource("/view/register-icon.png")));
		jbuttonDKREGISTER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		jbuttonDKREGISTER.setBounds(218, 218, 137, 35);
		contentPane.add(jbuttonDKREGISTER);
	}
	public void ChuyenTabLogin()
	{
		Login login = new Login();
		login.setLocationRelativeTo(null);
		login.setVisible(true);
		this.dispose();
	}
	public void register()
	{
		
		int dk = JOptionPane.showConfirmDialog(this, "do you want register an account?");
		if(dk!=JOptionPane.YES_OPTION)
		{
			return;
		}
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // load the DRIVER
			// step 2 : create to SQL SEVER 
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=LASTTERM;user=sa;password=342003");
			String sql = "INSERT INTO ACCOUNT values (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			if(passwordtext.getText().equals(confirmtext.getText())==false)
			{
				JOptionPane.showMessageDialog(this, "Confirm password failed!");
			}
			else if(textField.getText().equals("")||passwordtext.getText().equals("")||confirmtext.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "Fill in missing information");
			}
			else
			{
				ps.setString(1,textField.getText());
				ps.setString(2,passwordtext.getText());
				ps.setString(3, confirmtext.getText());
			}
			int n = ps.executeUpdate();		
			if(n!=0)
			{
				JOptionPane.showMessageDialog(this, "Register successfully");
			}
			
			else {
				JOptionPane.showMessageDialog(this, "Register failled");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
