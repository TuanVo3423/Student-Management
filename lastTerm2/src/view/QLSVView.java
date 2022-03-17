package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import controller.QLTSController;
import controller.StudentDB;
import javax.swing.JRadioButton;
import java.awt.Color;

public class QLSVView extends JFrame {
	public String luaChon = "";
	private int temp = 0 ;
	private JPanel contentPane;
	public QLSVModel model;
	private JTextField jtextfieldMSV;
	public JTable table;
	public JTextField jtextfieldMSV2;
	public JTextField jtextfieldHoVaTen;
	public JTextField jtextfieldNgaySinh;
	public JComboBox jcomboboxQueQuan2;
	public ButtonGroup buttonGroup;
	public JLabel jlabelGioiTinh;
	private JRadioButton radioButtonNam;
	private JRadioButton radioButtonNu;
	private JComboBox comboboxQuequan;
	private JButton Tim;
	ArrayList<ThiSinh> list;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 
					QLSVView frame = new QLSVView();
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
	public QLSVView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(QLSVView.class.getResource("/view/user-info-icon.png")));
		setForeground(Color.CYAN);
		setTitle("QUANLISINHVIEN");
		this.model = new QLSVModel();
		QLTSController action = new QLTSController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		URL urlIcon = QLSVView.class.getResource("student-icon.png");
		Image img = Toolkit.getDefaultToolkit().createImage(urlIcon);
		setBounds(100, 100, 878, 707);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.addActionListener(action);
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuFile);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.setIcon(new ImageIcon(QLSVView.class.getResource("/view/open-file-icon.png")));
		menuOpen.addActionListener(action);
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuOpen);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.setIcon(new ImageIcon(QLSVView.class.getResource("/view/Button-Close-icon.png")));
		menuExit.addActionListener(action);
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuExit);
		
		JMenu menuAbout = new JMenu("About");
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuAbout);
		
		JMenu menuBack = new JMenu("Back");
		menuBack.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuBack);
		
		JMenuItem menuBack_option = new JMenuItem("Back To Option");
		menuBack_option.setIcon(new ImageIcon(QLSVView.class.getResource("/view/Go-back-icon.png")));
		menuBack_option.addActionListener(action);
		
		menuBack.add(menuBack_option);
		
		
		JMenuItem menuAboutMe = new JMenuItem("About Me");
		menuAboutMe.setIcon(new ImageIcon(QLSVView.class.getResource("/view/About-me-icon.png")));
		menuAboutMe.addActionListener(action);
		menuAboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jlabelQueQuan = new JLabel("PLACE OF ORIGIN");
		jlabelQueQuan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlabelQueQuan.setBounds(10, 26, 152, 39);
		contentPane.add(jlabelQueQuan);
		
		JLabel jlabelMSV = new JLabel("ID");
		jlabelMSV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlabelMSV.setBounds(334, 26, 55, 39);
		contentPane.add(jlabelMSV);
		
		jtextfieldMSV = new JTextField();
		jtextfieldMSV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtextfieldMSV.setColumns(10);
		jtextfieldMSV.setBounds(375, 26, 183, 39);
		contentPane.add(jtextfieldMSV);
		
		Tim = new JButton("SEARCH");
		Tim.setIcon(new ImageIcon(QLSVView.class.getResource("/view/search-icon.png")));
		Tim.addActionListener(action);
		Tim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Tim.setBounds(586, 26, 129, 39);
		contentPane.add(Tim);
		
		
		comboboxQuequan = new JComboBox();
		comboboxQuequan.addItem("");
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		for (Tinh tinh : listTinh) {
			comboboxQuequan.addItem(tinh.getTenTinh());
		}
		comboboxQuequan.setBounds(172, 28, 129, 39);
		contentPane.add(comboboxQuequan);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 101, 831, 2);
		contentPane.add(separator_1);
		
		JLabel jlabelDSSV = new JLabel("STUDENT LIST");
		jlabelDSSV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlabelDSSV.setBounds(24, 116, 138, 39);
		contentPane.add(jlabelDSSV);
		
		table = new JTable();
		table.setBackground(Color.CYAN);
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NAME", "DATE OF BIRTH","GENDER","PLACE OF ORIGIN"
			}
		));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 156, 844, 200);
		contentPane.add(scrollPane);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 315, 747, 2);
		contentPane.add(separator_2);
		JLabel jlabelMSV2 = new JLabel("ID");
		jlabelMSV2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlabelMSV2.setBounds(24, 364, 91, 39);
		contentPane.add(jlabelMSV2);
		
		jtextfieldMSV2 = new JTextField();
		jtextfieldMSV2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtextfieldMSV2.setColumns(10);
		jtextfieldMSV2.setBounds(150, 366, 254, 39);
		contentPane.add(jtextfieldMSV2);
		
		JLabel jlabelHoVaten = new JLabel("NAME");
		jlabelHoVaten.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlabelHoVaten.setBounds(489, 364, 91, 39);
		contentPane.add(jlabelHoVaten);
		
		jtextfieldHoVaTen = new JTextField();
		jtextfieldHoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtextfieldHoVaTen.setColumns(10);
		jtextfieldHoVaTen.setBounds(600, 366, 254, 39);
		contentPane.add(jtextfieldHoVaTen);
		
		JLabel jlabelQueQuan2 = new JLabel("PLACE OF ORIGIN");
		jlabelQueQuan2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlabelQueQuan2.setBounds(10, 503, 149, 39);
		contentPane.add(jlabelQueQuan2);
		
		
		jcomboboxQueQuan2 = new JComboBox();
		jcomboboxQueQuan2.setBounds(150, 505, 254, 39);
		contentPane.add(jcomboboxQueQuan2);
		jcomboboxQueQuan2.addItem("");
		ArrayList<Tinh> listTinh2 = Tinh.getDSTinh();
		for (Tinh tinh : listTinh) {
			jcomboboxQueQuan2.addItem(tinh.getTenTinh());
		}
		
		JLabel jlabelNgaySinh = new JLabel("DATE OF BIRTH");
		jlabelNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlabelNgaySinh.setBounds(10, 435, 132, 39);
		contentPane.add(jlabelNgaySinh);
		
		jtextfieldNgaySinh = new JTextField();
		jtextfieldNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtextfieldNgaySinh.setColumns(10);
		jtextfieldNgaySinh.setBounds(152, 437, 252, 39);
		contentPane.add(jtextfieldNgaySinh);
		
		jlabelGioiTinh = new JLabel("GENDER");
		jlabelGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlabelGioiTinh.setBounds(489, 435, 91, 39);
		contentPane.add(jlabelGioiTinh);
		
		buttonGroup = new ButtonGroup();
	    radioButtonNam = new JRadioButton("MALE");
		radioButtonNam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radioButtonNam.setBounds(623, 444, 65, 21);
		
		
		radioButtonNu = new JRadioButton("FEMALE");
		radioButtonNu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radioButtonNu.setBounds(755, 444, 91, 21);
		buttonGroup.add(radioButtonNam);
		buttonGroup.add(radioButtonNu);
		contentPane.add(radioButtonNam);
		contentPane.add(radioButtonNu);
		
		JButton Them = new JButton("ADD");
		Them.setIcon(new ImageIcon(QLSVView.class.getResource("/view/add-contact-icon.png")));
		Them.addActionListener(action);
		Them.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Them.setBounds(10, 583, 132, 39);
		contentPane.add(Them);
		
		JButton Xoa = new JButton("DELETE");
		Xoa.setIcon(new ImageIcon(QLSVView.class.getResource("/view/Button-Close-icon.png")));
		Xoa.addActionListener(action);
		Xoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Xoa.setBounds(172, 583, 149, 39);
		contentPane.add(Xoa);
		
		JButton CapNhat = new JButton("UPDATE");
		CapNhat.setIcon(new ImageIcon(QLSVView.class.getResource("/view/edit-icon.png")));
		CapNhat.addActionListener(action);
		CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		CapNhat.setBounds(344, 583, 149, 39);
		contentPane.add(CapNhat);
		
		JButton Luu = new JButton("SAVE");
		Luu.setIcon(new ImageIcon(QLSVView.class.getResource("/view/Save-icon.png")));
		Luu.addActionListener(action);
		Luu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Luu.setBounds(531, 583, 138, 39);
		contentPane.add(Luu);
		
		JButton HuyBo = new JButton("RESET");
		HuyBo.setIcon(new ImageIcon(QLSVView.class.getResource("/view/Reset-icon.png")));
		HuyBo.addActionListener(action);
		HuyBo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		HuyBo.setBounds(712, 583, 129, 39);
		contentPane.add(HuyBo);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(0, 571, 841, 2);
		contentPane.add(separator_2_1);
		
		JButton huyTim = new JButton("CANCEL");
		huyTim.setIcon(new ImageIcon(QLSVView.class.getResource("/view/cancel.png")));
		huyTim.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		huyTim.addActionListener(action);
		huyTim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		huyTim.setBounds(725, 26, 129, 39);
		contentPane.add(huyTim);	
		
		JButton test = new JButton("test");
		test.addActionListener(action);
		test.setBounds(738, 514, 85, 21);
		contentPane.add(test);
		this.setVisible(true);
	}
	public void xoaForm()
	{
		jtextfieldMSV2.setText("");
		jtextfieldHoVaTen.setText("");
		jtextfieldNgaySinh.setText("");
		jcomboboxQueQuan2.setSelectedIndex(-1);
		buttonGroup.clearSelection();
	}
	public void themThiSinhVaoTable(ThiSinh ts){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { ts.getMaThiSinh() + "",ts.getTenThiSinh()+"",sdf.format(ts.getNgaySinh()),(ts.isGioiTinh() ? "Nam" : "Nữ"),
				ts.getQueQuan().getTenTinh(),
				});
	}
	//ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
	//		+ (ts.getNgaySinh().getYear() + 1900)
	public void themHoacCapNhatThiSinh(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if (!this.model.KiemTraTonTai(ts))//nếu SinhVien bên sql không trùng với list model
		{
			this.model.insert(ts);// insert vào arrayList model
			this.themThiSinhVaoTable(ts); // thêm vào table
			StudentDB s = new StudentDB(); // tạo class chưa hàm connect
			s.connect();   // connect với database
			s.AddStudent(ts); // excute statement sql
		    JOptionPane.showMessageDialog(this, "ADD SUCCESFULLY");
		}
		else//nếu SinhVien bên sql trùng với list model
		{
			JOptionPane.showMessageDialog(this, "UPDATE SUCCESFULLY");
			this.model.update(ts); // update vào ArrayList model
			for (int i = 0 ; i < this.model.getDsThiSinh().size() ; i++)
			{
				System.out.println(this.model.getDsThiSinh().get(i));
			}
			StudentDB db = new StudentDB();
			db.connect();
			db.UpdateStudent(ts); // excute statement update sql 
			 
			int soLuongDong = model_table.getRowCount(); // tính số dòng trong table
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + ""; // lấy ra id của mỗi sinh viên trong table
				if (id.equals(ts.getMaThiSinh() + ""))// nếu mã sinhvien trùng với mã sinh viên trong table
				{
					model_table.setValueAt(ts.getMaThiSinh() + "", i, 0);
					model_table.setValueAt(ts.getTenThiSinh() + "", i, 1);
					model_table.setValueAt(ts.getQueQuan().getTenTinh() + "", i, 4);
					model_table.setValueAt(ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
					+ (ts.getNgaySinh().getYear() + 1900) + "", i, 2);
					model_table.setValueAt((ts.isGioiTinh() ? "Nam" : "Nữ"), i, 3);
				}
			}
		}
	}
	public ThiSinh getThiSinhDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		System.out.println(i_row);
		int maThiSinh = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		//System.out.println(maThiSinh);
		String tenThiSinh = model_table.getValueAt(i_row, 1) + "";
		//System.out.println(tenThiSinh);
		String s_ngaySinh = model_table.getValueAt(i_row, 2) + "";
		Date ngaySinh = new Date(s_ngaySinh);
		//System.out.println(ngaySinh);
		String textGioiTinh = model_table.getValueAt(i_row, 3) + "";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		//System.out.println(gioiTinh);
		System.out.println(model_table.getValueAt(i_row, 4)+"");
		Tinh tinh = Tinh.getTinhByName(model_table.getValueAt(i_row, 4) + "");
		//System.out.println(tinh.getTenTinh());
		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, ngaySinh, gioiTinh, tinh);
		System.out.println(ts); // dung
		return ts;
	}
	public void hienThiThongTinThiSinhDaChon() {
		//System.out.println("hello bug");
		ThiSinh ts = getThiSinhDangChon();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(ts.getMaThiSinh());
		this.jtextfieldMSV2.setText(ts.getMaThiSinh() + "");
		this.jtextfieldHoVaTen.setText(ts.getTenThiSinh() + "");
		System.out.println(ts.getQueQuan().getTenTinh());
		this.jcomboboxQueQuan2.setSelectedItem(ts.getQueQuan().getTenTinh());
		String s_ngaySinh = sdf.format(ts.getNgaySinh());
				//ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
				//		+ (ts.getNgaySinh().getYear() + 1900);
		this.jtextfieldNgaySinh.setText(s_ngaySinh + "");
		if (ts.isGioiTinh()) {
			radioButtonNam.setSelected(true);
		} else {
			radioButtonNu.setSelected(true);
		}
	}
	public void thucHienXoa() throws HeadlessException, ClassNotFoundException, SQLException {
		StudentDB db = new StudentDB();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "DO YOU WANT TO REMOVE THIS?");
	//	int luaChon = JOptionPane.showConfirmDialog(this,"Ban chac chan xoa?");
		if (luaChon == JOptionPane.YES_OPTION) {
			ThiSinh ts = getThiSinhDangChon();
			if(db.XoaThiSinhRaKhoiDatabase(ts))
			{
				int id = ts.getMaThiSinh();
				this.model.deleteByID(id);
				model_table.removeRow(i_row); // xóa khỏi table
				JOptionPane.showMessageDialog(this, "DELETE SUCESSFULLY");
			}
			
			for (ThiSinh thiSinh : this.model.getDsThiSinh()) {
				System.out.println(thiSinh);
			}
		}
	}
	public void thucHienThemThiSinh() {
		// Get du lieu SinhVien tu text field
		int maThiSinh = Integer.valueOf(this.jtextfieldMSV2.getText());
		String tenThiSinh = this.jtextfieldHoVaTen.getText();
		int queQuan = this.jcomboboxQueQuan2.getSelectedIndex() - 1;
		Tinh tinh = Tinh.getTinhById(queQuan);
		Date ngaySinh = new Date(this.jtextfieldNgaySinh.getText());
		boolean gioiTinh = true;
		if (this.radioButtonNam.isSelected()) {
			gioiTinh = true;
		} else if (this.radioButtonNu.isSelected()) {
			gioiTinh = false;
		}
		// get data xong => create the Thi Sinh
		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, ngaySinh, gioiTinh, tinh);
		boolean t = true;
		for (ThiSinh thiSinh : list) {
			if(ts.getMaThiSinh()==thiSinh.getMaThiSinh()&&luaChon.equals("UPDATE")==false)
			{
				JOptionPane.showMessageDialog(this, "SAME ID , PLEASE ADD AGAIN.");
				t = false;
			}
		}
		if(t==true)
		{
			this.themHoacCapNhatThiSinh(ts);
		}
	}

	public void thucHienTim() {
		// Goi ham huy tim kiem
		this.thucHienTaiLaiDuLieu();
		// Thuc hien tim kiem
		int queQuan = this.comboboxQuequan.getSelectedIndex() - 1;
		String maThiSinhTimKiem = this.jtextfieldMSV.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
		Set<Integer> idCuaThiSinhCanXoa = new TreeSet<Integer>();
		if (queQuan >= 0) {
			Tinh tinhDaChon = Tinh.getTinhById(queQuan);
			for (int i = 0; i < soLuongDong; i++) {
				String tenTinh = model_table.getValueAt(i, 4) + "";
				String id = model_table.getValueAt(i, 0) + "";
				if (!tenTinh.equals(tinhDaChon.getTenTinh())) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		if (maThiSinhTimKiem.length() > 0) {
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (!id.equals(maThiSinhTimKiem)) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		for (Integer idCanXoa : idCuaThiSinhCanXoa) {
			System.out.println(idCanXoa);
			soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0) + "";
				System.out.println("idTrongTable: " + idTrongTable);
				if (idTrongTable.equals(idCanXoa.toString())) {
					System.out.println("Đã xóa: " + i);
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

	public void thucHienTaiLaiDuLieu() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();//2
			if(soLuongDong==0)
				break;
			else
				model_table.removeRow(0);
		}
		for (ThiSinh ts : this.model.getDsThiSinh()) {
			this.themThiSinhVaoTable(ts);
		}
	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Student management software ");
	}
	public void ThucHienResetTruocKhiOpen()
	{
		list.clear();
	}

	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(
			    this,
			    "Bạn có muốn thoải khỏi chương trình?",
			    "Exit",
			    JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	public void ThucHienOpen() {
		//list.clear();
		if(temp==0)
		{
			temp++;
			StudentDB db = new StudentDB();
			db.connect();
			list = db.getListTS(); // lấy được 1 list ThiSinh từ sql để up lên table
			for (ThiSinh thiSinh : list) {
				System.out.println(thiSinh);
			}
			for (ThiSinh thiSinh : list) {
				this.themThiSinhVaoTable(thiSinh);  // thêm Thí Sinh vào table
				//this.themHoacCapNhatThiSinh(thiSinh);
				this.model.insert(thiSinh);   // đồng thời insert vào list2
			}
		}
		else
		{
			while (true) {
				DefaultTableModel model_table = (DefaultTableModel) table.getModel();
				int soLuongDong = model_table.getRowCount();//2
				if(soLuongDong==0)
					break;
				else
					model_table.removeRow(0);
			}
			list.clear();
			this.model.getDsThiSinh().clear();
			StudentDB db = new StudentDB();
			db.connect();
			list = db.getListTS(); // lấy được 1 list ThiSinh từ sql để up lên table
			for (ThiSinh thiSinh : list) {
				this.themThiSinhVaoTable(thiSinh);  // thêm Thí Sinh vào table
				//this.themHoacCapNhatThiSinh(thiSinh);
				this.model.insert(thiSinh);   // đồng thời insert vào list2
			}
			
		}
	}
	public void chuyenTabOption()
	{	
		OPTION op = new OPTION();
		op.setLocationRelativeTo(null);
		op.setVisible(true);
		this.dispose();
	}

	public void test() throws SQLException {
		StudentDB sdb = new StudentDB();
		sdb.connect();
		String s = jtextfieldMSV.getText();
		ArrayList<ThiSinh> list = sdb.test1(s);
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();//2
			if(soLuongDong==0)
				break;
			else
				model_table.removeRow(0);
		}
		for (ThiSinh ts : list) {
			this.themThiSinhVaoTable(ts);
		}
		
		
		
		
		
	}
			
}

