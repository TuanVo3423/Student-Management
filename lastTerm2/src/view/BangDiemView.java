package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.MenuBar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;

import controller.SCOREController;
import controller.ScoreDB;
import controller.StudentDB;
import model.BangDiem;
import model.BangDiemModel;
import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class BangDiemView extends JFrame {
	QLSVView qlsvview ;
	private JPanel contentPane;
	public JTextField textfieldID;
	private JTextField textfieldJava;
	private JTextField textfieldcsdl;
	private JTextField textfieldtindc;
	private JTextField textfieldidsearch;
	JTable table;
	ArrayList<BangDiem> list = new ArrayList<>();
	BangDiemModel bangdiemmodel ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BangDiemView frame = new BangDiemView();
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
	public BangDiemView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(BangDiemView.class.getResource("/view/Student-3-icon.png")));
		setTitle("BANGDIEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 707);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		SCOREController action = new SCOREController(this);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuFile);
		
		JLabel labelname = new JLabel("");
		labelname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelname.setBounds(586, 338, 246, 35);
		contentPane.add(labelname);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);
		menuOpen.setIcon(new ImageIcon(QLSVView.class.getResource("/view/open-file-icon.png")));
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuOpen);
		
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(action);
		menuExit.setIcon(new ImageIcon(QLSVView.class.getResource("/view/Button-Close-icon.png")));
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuExit);
		
		JMenu menuAbout = new JMenu("About");
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuAbout);
		
		JMenuItem menuAboutMe = new JMenuItem("About Me");
		menuAboutMe.addActionListener(action);
		menuAboutMe.setIcon(new ImageIcon(QLSVView.class.getResource("/view/About-me-icon.png")));
		menuAboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuAbout.add(menuAboutMe);
		
		JMenu menuBack = new JMenu("Back");
		menuBack.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuBack);
		
		JMenuItem menuBack_option = new JMenuItem("Back To Menu");
		menuBack_option.setIcon(new ImageIcon(BangDiemView.class.getResource("/view/Go-back-icon.png")));
		menuBack_option.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBack.add(menuBack_option);
		menuBack_option.addActionListener(action);
		
		table = new JTable();
		table.setBackground(Color.CYAN);
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID_STUDENT","JAVA","CSDL","TINDC","GPA"
			}
		));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 90, 830, 199);
		contentPane.add(scrollPane);
		
		JLabel jlabelID = new JLabel("ID OF STUDENT");
		jlabelID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlabelID.setBounds(10, 328, 137, 58);
		contentPane.add(jlabelID);
		
		JLabel jlabelJAVA = new JLabel("SCORE OF JAVA");
		jlabelJAVA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlabelJAVA.setBounds(10, 410, 137, 58);
		contentPane.add(jlabelJAVA);
		
		JLabel jlabelName = new JLabel("NAME");
		jlabelName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlabelName.setBounds(487, 328, 137, 58);
		contentPane.add(jlabelName);
		
		textfieldID = new JTextField();
		textfieldID.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					StudentDB db = new StudentDB();
					ThiSinh ts = new ThiSinh();
					QLSVModel qlsv = new QLSVModel();
					qlsv.setDsThiSinh(db.getListTS());
					ts = qlsv.findTSByID(Integer.parseInt(textfieldID.getText()));
					if(ts!=null)
					{
						labelname.setText(ts.getTenThiSinh());
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		textfieldID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textfieldID.setColumns(10);
		textfieldID.setBounds(157, 338, 254, 39);
		contentPane.add(textfieldID);
		
		textfieldJava = new JTextField();
		textfieldJava.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textfieldJava.setColumns(10);
		textfieldJava.setBounds(157, 420, 254, 39);
		contentPane.add(textfieldJava);
		
		JLabel jlabelCSDL = new JLabel("SCORE OF CSDL");
		jlabelCSDL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlabelCSDL.setBounds(439, 410, 137, 58);
		contentPane.add(jlabelCSDL);
		
		textfieldcsdl = new JTextField();
		textfieldcsdl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textfieldcsdl.setColumns(10);
		textfieldcsdl.setBounds(586, 420, 254, 39);
		contentPane.add(textfieldcsdl);
		
		JLabel jlabelTINDC = new JLabel("SCORE OF TINDC");
		jlabelTINDC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlabelTINDC.setBounds(10, 478, 137, 58);
		contentPane.add(jlabelTINDC);
		
		textfieldtindc = new JTextField();
		textfieldtindc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textfieldtindc.setColumns(10);
		textfieldtindc.setBounds(157, 488, 254, 39);
		contentPane.add(textfieldtindc);
		
		JButton Them = new JButton("ADD");
		Them.setIcon(new ImageIcon(BangDiemView.class.getResource("/view/add-contact-icon.png")));
		Them.addActionListener(action);
		
		Them.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Them.setBounds(10, 569, 137, 39);
		contentPane.add(Them);
		
		JButton Xoa = new JButton("DELETE");
		Xoa.setIcon(new ImageIcon(BangDiemView.class.getResource("/view/Button-Close-icon.png")));
		Xoa.addActionListener(action);
		Xoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Xoa.setBounds(173, 569, 129, 39);
		contentPane.add(Xoa);
		
		JButton CapNhat = new JButton("UPDATE");
		CapNhat.setIcon(new ImageIcon(BangDiemView.class.getResource("/view/edit-icon.png")));
		CapNhat.addActionListener(action);
		CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		CapNhat.setBounds(331, 569, 137, 39);
		contentPane.add(CapNhat);
		
		JButton Luu = new JButton("SAVE");
		Luu.setIcon(new ImageIcon(BangDiemView.class.getResource("/view/Save-icon.png")));
		Luu.addActionListener(action);
		Luu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Luu.setBounds(507, 569, 137, 39);
		contentPane.add(Luu);
		
		JButton sapxep = new JButton("TOP SCORE");
		sapxep.setIcon(new ImageIcon(BangDiemView.class.getResource("/view/Rank-History-icon.png")));
		sapxep.addActionListener(action);
		sapxep.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sapxep.setBounds(678, 569, 162, 39);
		contentPane.add(sapxep);
		
		JLabel idtimkiem = new JLabel("ID OF STUDENT");
		idtimkiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		idtimkiem.setBounds(32, 10, 137, 58);
		contentPane.add(idtimkiem);
		
		textfieldidsearch = new JTextField();
		textfieldidsearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textfieldidsearch.setColumns(10);
		textfieldidsearch.setBounds(184, 20, 284, 39);
		contentPane.add(textfieldidsearch);
		
		JButton timkiem = new JButton("SEARCH");
		timkiem.setIcon(new ImageIcon(BangDiemView.class.getResource("/view/search-icon.png")));
		timkiem.addActionListener(action);
		timkiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		timkiem.setBounds(501, 20, 162, 39);
		contentPane.add(timkiem);
		
		JButton huytim = new JButton("CANCEL");
		huytim.setIcon(new ImageIcon(BangDiemView.class.getResource("/view/cancel.png")));
		huytim.addActionListener(action);
		huytim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		huytim.setBounds(683, 20, 157, 39);
		contentPane.add(huytim);
		
//		JButton searchname = new JButton("searchlilich");
//		searchname.addActionListener(action);
//		searchname.setBounds(734, 499, 98, 21);
//		contentPane.add(searchname);
		
//		JButton test = new JButton("test");
//		test.addActionListener(action);
//		test.setBounds(622, 499, 85, 21);
//		contentPane.add(test);
//		
//		JButton testdtb = new JButton("testdtb");
//		testdtb.addActionListener(action);
//		testdtb.setBounds(747, 499, 85, 21);
//		contentPane.add(testdtb);
		
		
	}
	public void xoaForm()
	{
		JOptionPane.showMessageDialog(this, "ADDING NOW");
		this.textfieldID.setText("");
		this.textfieldcsdl.setText("");
		this.textfieldJava.setText("");
		this.textfieldtindc.setText("");
		this.textfieldtindc.setText("");
	}
	public void themBangDiem()
	{
		BangDiem bd = new BangDiem();
		if(textfieldID.getText().equals("")||textfieldcsdl.getText().equals("")||textfieldJava.getText().equals("")||textfieldtindc.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this, "PLEASE FILL ALL INFORMATION");
		}
		else 
		{
			bd.setMaSinhVien(Integer.parseInt(textfieldID.getText()));
			bd.setDiemjava(Float.parseFloat(textfieldJava.getText()));
			bd.setDiemcsdl(Float.parseFloat(textfieldcsdl.getText()));
			bd.setDiemTinDC(Float.parseFloat(textfieldtindc.getText()));
			// da co bangdiem
		   try {
			   ScoreDB sdb = new ScoreDB();
			   if (sdb.findByID(Integer.parseInt(this.textfieldID.getText()))!=null) // ton tai
			   {
				   
				   if(sdb.updateScore(bd))
				   {
					   System.out.println("done");
					   this.capNhatBangDiem(bd);
					   JOptionPane.showMessageDialog(this, "UPDATE SUCESSFULLY");
				   }
				   else
				   {
					   JOptionPane.showMessageDialog(this, "UPDATE FAILED");
				   }
			   }
			   else
			   {
				   boolean b = sdb.addScore(bd);
				   this.themBangDiemVaotable(bd);
				   if(b)
				   {
						   JOptionPane.showMessageDialog(this, "ADD SCORE SUCESSFULLY");
				   }
				   else
				   {
						   JOptionPane.showMessageDialog(this, "ADD SCORE FAILED");
				   }
			   }
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "STUDENT DON'T EXIST ON SINH VIEN TABLE");
			//JOptionPane.showMessageDialog(this, e.getMessage());
		}
		}
	}
	public void themBangDiemVaotable(BangDiem bd)
	{
		Float dtb = (bd.getDiemcsdl()+bd.getDiemjava()+bd.getDiemTinDC())/3;
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] {bd.getMaSinhVien()+"",bd.getDiemjava()+"",bd.getDiemcsdl()+"",bd.getDiemTinDC()+"",dtb+""
				});
	}
	public void themTatCaVaoTable() throws ClassNotFoundException, SQLException
	{
		bangdiemmodel = new BangDiemModel();
		ScoreDB sdb = new ScoreDB();
		ArrayList<BangDiem> list = sdb.uploadALL();
		for (BangDiem bangDiem : list) {
			themBangDiemVaotable(bangDiem);
			Float dtb = (bangDiem.getDiemcsdl()+bangDiem.getDiemTinDC()+bangDiem.getDiemjava())/3;
			bangDiem.setDiemTrungBinh(dtb);
			this.bangdiemmodel.add_new_score(bangDiem);
		}
		for (BangDiem bangDiem : list) {
			System.out.println(bangDiem);
		}
		
		
	}
	public void capNhatBangDiem(BangDiem bd)
	{
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		//BangDiem bdchon = this.getBangDiemDangChon();
		int soLuongDong = model_table.getRowCount(); // tính số dòng trong table
		for (int i = 0; i < soLuongDong; i++) {
			String idSV = model_table.getValueAt(i, 0) + ""; // lấy ra id của mỗi sinh viên trong table
			System.out.println(idSV+"---"+bd.getMaSinhVien());
			if (idSV.equals(bd.getMaSinhVien() + ""))// nếu mã sinhvien trùng với mã sinh viên trong table
			{
				System.out.println("hehehe");
				float dtb = (bd.getDiemcsdl()+bd.getDiemjava()+bd.getDiemTinDC())/3;
				bd.setDiemTrungBinh(dtb);
				list.add(bd);
				model_table.setValueAt(bd.getMaSinhVien() + "", i, 0);
				model_table.setValueAt(bd.getDiemjava()+ "", i, 1);
				model_table.setValueAt(bd.getDiemcsdl() + "", i, 2);
				model_table.setValueAt(bd.getDiemTinDC() + "", i, 3);
				model_table.setValueAt(dtb + "", i, 4);
			}
		}
	}
	public BangDiem getBangDiemDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		System.out.println(i_row);
		int maSV = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		//System.out.println(maThiSinh);
		float java = Float.valueOf(model_table.getValueAt(i_row, 1)+"");
		//System.out.println(tenThiSinh);
		float csdl = Float.valueOf(model_table.getValueAt(i_row, 2)+"");
		float tindc = Float.valueOf(model_table.getValueAt(i_row, 3)+"");
		float dtb = Float.valueOf(model_table.getValueAt(i_row, 4)+"");
		BangDiem bd = new BangDiem(maSV, java, csdl, tindc, dtb);
		return bd;
	}
	public void HienThiBangDiemDangChon()
	{
		BangDiem bd = this.getBangDiemDangChon();
		this.textfieldID.setText(bd.getMaSinhVien()+"");
		this.textfieldJava.setText(bd.getDiemjava()+"");
		this.textfieldcsdl.setText(bd.getDiemcsdl()+"");
		this.textfieldtindc.setText(bd.getDiemTinDC()+"");
	}
	public void xoaBangDiem()
	{
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		BangDiem bd = this.getBangDiemDangChon();
		int id = bd.getMaSinhVien();
		ScoreDB sdb = new ScoreDB();
		try {
			int luaChon = JOptionPane.showConfirmDialog(this, "DO YOU WANT TO REMOVE THIS?");
				if (luaChon == JOptionPane.YES_OPTION)
				{
					sdb.deleteID_from_Score(id);
					model_table.removeRow(i_row);
					JOptionPane.showMessageDialog(this, "DELETE SUCESSFULLY");
				}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void xoaBang() throws ClassNotFoundException, SQLException {
		ScoreDB sbd = new ScoreDB();
		ArrayList<BangDiem> list  = sbd.uploadALL();
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();//2
			if(soLuongDong==0)
				break;
			else
				model_table.removeRow(0);
		}
//		for (BangDiem bangDiem : list) {
//			this.themBangDiemVaotable(bangDiem);
//		}
		
	}
	public void thucHienTaiLaiBang() throws ClassNotFoundException, SQLException {
		ScoreDB sbd = new ScoreDB();
		ArrayList<BangDiem> list  = sbd.uploadALL();
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();//2
			if(soLuongDong==0)
				break;
			else
				model_table.removeRow(0);
		}
		for (BangDiem bangDiem : list) {
			this.themBangDiemVaotable(bangDiem);
		}
		
	}
	public void timkiem() throws ClassNotFoundException, SQLException
	{
		this.xoaBang();
		ScoreDB sbd = new ScoreDB();
		BangDiem bd = new BangDiem();
		try {
			sbd.connect();
			bd = sbd.findByID(Integer.parseInt(textfieldidsearch.getText()));
			if(bd!=null)
			{
				this.themBangDiemVaotable(bd);
				// set vao table
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void SapXepDiem() throws ClassNotFoundException, SQLException 
	{
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
		ScoreDB sdb = new ScoreDB();
		String m = JOptionPane.showInputDialog("ENTER TOP SCORE YOU WANT TO SELECT");
		int choice = Integer.parseInt(m);
		if(choice<=soLuongDong)
		{
			this.xoaBang();
	        ArrayList<BangDiem> list_top = sdb.timTOP(choice); // da co list top
	        for (BangDiem bangDiem : list_top) {
				this.themBangDiemVaotable(bangDiem);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(this, "PLEASE ENTER THE NUMBER OF TOP <= THE NUMBER OF STUDENT.");
		}
	}
	public void chuyentabOption()
	{
		OPTION op = new OPTION();
		op.setLocationRelativeTo(null);
		op.setVisible(true);
		this.dispose();
	}

	public void timlilich() {
		StudentDB sdb = new StudentDB();
		String m = JOptionPane.showInputDialog("ENTER ID YOU WANT TO FIND");
		int choice = Integer.parseInt(m);
		ThiSinh ts = sdb.timlilich(choice);
		String lilich = ts.getMaThiSinh()+"-"+ts.getTenThiSinh()+"-"+(ts.isGioiTinh()?"Nam":"Nữ") +"-"+ts.getQueQuan().getTenTinh();
		JOptionPane.showMessageDialog(this, lilich );
		
		
	}

	public void test() throws SQLException {
		int soluong ;
		StudentDB sdb = new StudentDB();
		sdb.connect();
		ScoreDB score = new ScoreDB();
		ThiSinh ts = sdb.test();
		String lilich = ts.getMaThiSinh()+"-"+ts.getTenThiSinh()+"-"+(ts.isGioiTinh()?"Nam":"Nữ") +"-"+ts.getQueQuan().getTenTinh();
		JOptionPane.showMessageDialog(this, lilich );
		
		
		
	}

	public void testdtb() throws ClassNotFoundException, SQLException {
		StudentDB sdb = new StudentDB();
		BangDiem bd = this.bangdiemmodel.findmax();
		System.out.println(bd);
		int id = bd.getMaSinhVien();
		System.out.println(id);
		//-----------
		ThiSinh ts = sdb.testdtb(id);
		String lilich = ts.getMaThiSinh()+"-"+ts.getTenThiSinh()+"-"+(ts.isGioiTinh()?"Nam":"Nữ") +"-"+ts.getQueQuan().getTenTinh();
		JOptionPane.showMessageDialog(this, lilich);
		
		
		
	}
}
