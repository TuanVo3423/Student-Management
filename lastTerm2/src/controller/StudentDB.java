package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import model.BangDiem;
import model.ThiSinh;
import model.Tinh;
import view.BangDiemView;
import view.QLSVView;

public class StudentDB {
	
	Connection conn;
	Statement stmt ;
	QLSVView view ;
	ScoreDB score;
	BangDiemView bdv;
	public void connect()
	{ 
		try
		{
			// step1 
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // load the DRIVER
			// step 2 : create to SQL SEVER 
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=LASTTERM;user=sa;password=342003");
			System.out.println("Connected");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public int excuteUpdate(String sql) // change to the data
	{
		int record = 0 ; // number of record have been changed in db
		try {
			connect();
			stmt = conn.createStatement();
			record = stmt.executeUpdate(sql);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(view, "PLEASE REMOVE A STUDENT HAS ID HERE IN BANGDIEM TABLE BEFORE");
		}
		return record;
	}
	public ResultSet SelectDB(String sql) // not change the value (data) into the database
	{
		ResultSet rs = null;
		try {
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	public boolean AddStudent(ThiSinh ts)
	{
		PreparedStatement ps;
		Date day = ts.getNgaySinh();
		java.sql.Date d = new java.sql.Date(day.getTime());
		String gender = ts.isGioiTinh()?"Nam":"Nữ";
		//INSERT INTO NHANVIENBANHANG(IDNVBANHANG, IDNVQUANLY, IDCHU, TEN, DIACHI, SDT, LUONG, SONGAYNGHI)
		//VALUES ('00007', '00004', '00001', 'KHOA PUB', 'QUANG NGAI', '0934523785', 350, 0),
		try {
			ps = conn.prepareStatement("Insert into LiLichSinhVien(ID,Name,Birthday,QueQuan,Gender) values(?,?,?,?,?)");
			ps.setInt(1, ts.getMaThiSinh());
			ps.setString(2, ts.getTenThiSinh());
			ps.setDate(3, d);
			ps.setString(4, ts.getQueQuan().getTenTinh());
			ps.setString(5, gender);
			return ps.executeUpdate() > 0 ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public void UpdateStudent(ThiSinh ts)
	{
		PreparedStatement ps;
		Date day = ts.getNgaySinh();
		java.sql.Date d = new java.sql.Date(day.getTime());
		String gender = ts.isGioiTinh()?"Nam":"Nữ";
		String sql = "update LiLichSinhVien set Name = N'"+ts.getTenThiSinh() +"', Birthday = '"+ts.getNgaySinh().getDate()+"/"+(ts.getNgaySinh().getMonth()+1)+"/"+(ts.getNgaySinh().getYear()+1900)+
				"', QueQuan =N'"+ ts.getQueQuan().getTenTinh()+"' , Gender = N'"+ gender+ "'" + " where ID = '"+ts.getMaThiSinh()+"'";
		this.excuteUpdate(sql);
	}
	public ArrayList<ThiSinh> getListTS()
	{
		this.connect();
		ArrayList<ThiSinh> list = new ArrayList<>();
		String sql = "SELECT * FROM LiLichSinhVien";// chuẩn bị câu lệnh truy vấn tới bảng
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); 
			while(rs.next()) // lấy dữ liệu trong database đến khi hết thì dừng
			{
				ThiSinh ts = new ThiSinh();
				ts.setMaThiSinh(rs.getInt("ID"));
				ts.setTenThiSinh(rs.getString("Name"));
				ts.setNgaySinh(rs.getDate("Birthday"));
				String t = rs.getString("QueQuan");
				Tinh tinh  = Tinh.getTinhByName(t.trim());
				ts.setQueQuan(tinh);
				boolean b = false ;
				String s = rs.getString("Gender");
				String s1 = s.trim();
				if(s1.equals("Nam"))
				{
					b = true;
				}
				else if (s1.equals("Nữ"))
				{
					b = false;
				}
				ts.setGioiTinh(b);
				list.add(ts);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public boolean XoaThiSinhRaKhoiDatabase(ThiSinh ts) throws ClassNotFoundException, SQLException
	{
		PreparedStatement ps ;
		score = new ScoreDB();
		score.deleteID_from_Score(ts.getMaThiSinh()); // xoa ben bang diem truoc
		
		String sql = "Delete from LiLichSinhVien where ID = '"+ts.getMaThiSinh()+"'"; // sau khi xoa ben bang diem thi xoa ben sinh vien
		return this.excuteUpdate(sql) > 0;
	}
	public ThiSinh timlilich(int id)
	{
		PreparedStatement ps ;
		ThiSinh ts = null;
		this.connect();
		String sql = "select*from LiLichSinhVien where ID="+"'"+id+"'";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				ts = new ThiSinh();
				ts.setMaThiSinh(rs.getInt("ID"));
				ts.setTenThiSinh(rs.getString("Name"));
				ts.setNgaySinh(rs.getDate("Birthday"));
				ts.setQueQuan(Tinh.getTinhByName(rs.getString("QueQuan")));
				ts.setGioiTinh(rs.getBoolean("Gender"));
				
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ts;
		
	}
	public ThiSinh test() throws SQLException
	{
//		select * from LiLichSinhVien
//		where ID = (select IDSINHVIEN from BangDiem
//					where JAVA = (select MAX(JAVA) from BangDiem))
		PreparedStatement ps;
		ThiSinh ts = new ThiSinh();
		String sql = "select*from LiLichSinhVien where ID = (select IDSINHVIEN from BangDiem where JAVA = (select MAX(JAVA) from BangDiem))";
		ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			ts.setMaThiSinh(rs.getInt("ID"));
			ts.setTenThiSinh(rs.getString("Name"));
			ts.setNgaySinh(rs.getDate("Birthday"));
			ts.setQueQuan(Tinh.getTinhByName(rs.getString("QueQuan")));
			ts.setGioiTinh(rs.getBoolean("Gender"));
			
		}
		return ts;
	}
	public ArrayList<ThiSinh> test1(String name) throws SQLException
	{
		PreparedStatement ps;
		ArrayList<ThiSinh> list =  new ArrayList<>();
//		select*from LiLichSinhVien
//		 where Name = N'Vo Thi Tinh'
		//String sql = "select*from LiLichSinhVien where Name LIKE 'Nguyen%'";
		//String sql = "select*from LiLichSinhVien where GENDER = N'Nam'";
		String sql = "SELECT*FROM LiLichSinhVien where Name = '"+name+"'";
		ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			ThiSinh ts = new ThiSinh();
			ts.setMaThiSinh(rs.getInt("ID"));
			ts.setTenThiSinh(rs.getString("Name"));
			ts.setNgaySinh(rs.getDate("Birthday"));
			ts.setQueQuan(Tinh.getTinhByName(rs.getString("QueQuan")));
			ts.setGioiTinh(rs.getBoolean("Gender"));
			list.add(ts);
		}
		return list;
	}
	public ThiSinh testdtb(int id) throws ClassNotFoundException, SQLException
	{
		this.connect();
		ThiSinh ts = new ThiSinh();
		PreparedStatement ps;
		String sql = "select*from LiLichSinhVien where ID="+id;
		ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			ts.setMaThiSinh(rs.getInt("ID"));
			ts.setTenThiSinh(rs.getString("Name"));
			ts.setNgaySinh(rs.getDate("Birthday"));
			ts.setQueQuan(Tinh.getTinhByName(rs.getString("QueQuan")));
			ts.setGioiTinh(rs.getBoolean("Gender"));
		}
		return ts;
		
	}
	

}
