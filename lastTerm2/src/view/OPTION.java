package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OptionController;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class OPTION extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OPTION frame = new OPTION();
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
	public OPTION() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(OPTION.class.getResource("/view/Very-Basic-Menu-icon.png")));
		setTitle("MENU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		OptionController action = new OptionController(this);
		
		JButton jbuttonQLSV = new JButton("Student information management");
		jbuttonQLSV.setBackground(Color.CYAN);
		jbuttonQLSV.setForeground(Color.BLACK);
		jbuttonQLSV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jbuttonQLSV.addActionListener(action);
		jbuttonQLSV.setBounds(10, 89, 254, 123);
		contentPane.add(jbuttonQLSV);
		
		JButton jbuttonQLDIEM = new JButton("Student score management");
		jbuttonQLDIEM.setBackground(Color.CYAN);
		jbuttonQLDIEM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jbuttonQLDIEM.addActionListener(action);
		jbuttonQLDIEM.setBounds(289, 91, 277, 123);
		contentPane.add(jbuttonQLDIEM);
		
		JLabel jlabeloption = new JLabel("FUNCTION OPTIONS");
		jlabeloption.setIcon(new ImageIcon(OPTION.class.getResource("/view/options-icon.png")));
		jlabeloption.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jlabeloption.setBounds(186, 10, 223, 52);
		contentPane.add(jlabeloption);
	}
	public void chuyenTabQLSV()
	{
		QLSVView qlsv = new QLSVView();
		qlsv.setLocationRelativeTo(null);
		qlsv.setVisible(true);
		this.dispose();
	}
	public void chuyenTabQLSCORE()
	{
		BangDiemView bdv = new BangDiemView();
		bdv.setLocationRelativeTo(null);
		bdv.setVisible(true);
		this.dispose();
	}
}
