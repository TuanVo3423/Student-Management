package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField usertext;
	private JPasswordField passwordtext;
	Connection conn;
	Statement stmt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/view/user-info-icon.png")));
		setTitle("LOGIN ACCOUNT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		LoginController action = new LoginController(this);
		
		JLabel jlabellogin = new JLabel("");
		jlabellogin.setIcon(new ImageIcon(Login.class.getResource("/view/user-info-icon.png")));
		jlabellogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jlabellogin.setBounds(203, 10, 58, 42);
		contentPane.add(jlabellogin);
		
		JLabel user = new JLabel("USER");
		user.setIcon(new ImageIcon(Login.class.getResource("/view/Person-Male-Light-icon.png")));
		user.setFont(new Font("Tahoma", Font.PLAIN, 14));
		user.setBounds(10, 79, 97, 28);
		contentPane.add(user);
		
		usertext = new JTextField();
		usertext.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usertext.setColumns(10);
		usertext.setBounds(150, 79, 202, 26);
		contentPane.add(usertext);
		
		JLabel password = new JLabel("PASSWORD");
		password.setIcon(new ImageIcon(Login.class.getResource("/view/Apps-password-icon.png")));
		password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		password.setBounds(10, 145, 116, 28);
		contentPane.add(password);
		
		passwordtext = new JPasswordField();
		passwordtext.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordtext.setBounds(150, 145, 202, 26);
		contentPane.add(passwordtext);
		
		JButton jbuttonThemtk = new JButton("REGISTER");
		jbuttonThemtk.setIcon(new ImageIcon(Login.class.getResource("/view/register-icon.png")));
		jbuttonThemtk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chuyenTab();
				Register rgt = new Register();
				rgt.setLocationRelativeTo(null);
				rgt.setVisible(true);
				
			}
		});
		jbuttonThemtk.setBounds(36, 203, 133, 35);
		contentPane.add(jbuttonThemtk);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setIcon(new ImageIcon(Login.class.getResource("/view/Login-icon.png")));
		btnLogin.addActionListener(action);
		btnLogin.setBounds(224, 203, 128, 35);
		contentPane.add(btnLogin);
		
		JLabel add = new JLabel("");
		add.setBounds(141, 203, 45, 35);
		contentPane.add(add);
	}
	public void chuyenTab()
	{
		this.dispose();
	}
	public void loginaccount() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // load the DRIVER
		// step 2 : create to SQL SEVER 
		conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=LASTTERM;user=sa;password=342003");
		String sql = "SELECT*FROM ACCOUNT WHERE USERNAME=? and PASSWORD =? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, usertext.getText());
		ps.setString(2, passwordtext.getText());
		ResultSet rs= ps.executeQuery();
		if(usertext.getText().equals("")||passwordtext.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this, "Fill in missing information");
		}
		else if(rs.next())
		{
			OPTION op = new OPTION();
			op.setLocationRelativeTo(null);
			op.setVisible(true);
			this.dispose();
			JOptionPane.showMessageDialog(this, "Login suscessfully");
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Login failed");
		}	
	}
}
