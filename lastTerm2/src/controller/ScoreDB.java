package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.BangDiem;

public class ScoreDB {
	Connection conn ;
	Statement stmt ;
	
	public ScoreDB() {
	}

	public void connect() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=LASTTERM;user=sa;password=342003");
		System.out.println("Connected");
	}
	
	public boolean addScore(BangDiem bd) throws SQLException, ClassNotFoundException
	{
		this.connect();
		String sql ="INSERT INTO [dbo].[BangDiem]([IDSINHVIEN],[JAVA],[CSDL],[TINDC]) values (?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		try{
			ps.setInt(1, bd.getMaSinhVien());
			ps.setFloat(2, bd.getDiemjava());
			ps.setFloat(3, bd.getDiemcsdl());
			ps.setFloat(4, bd.getDiemTinDC());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ps.executeUpdate() > 0 ;
	}
	public boolean updateScore(BangDiem bd) throws ClassNotFoundException, SQLException
	{
		
		this.connect();
		String sql = "UPDATE [dbo].[BangDiem]"
				+ "	SET [JAVA] = ?,[CSDL] = ?,[TINDC] =?"
				+ "	WHERE [IDSINHVIEN] = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		try {
			ps.setFloat(1, bd.getDiemjava());
			ps.setFloat(2, bd.getDiemcsdl());
			ps.setFloat(3, bd.getDiemTinDC());
			ps.setInt(4, bd.getMaSinhVien());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ps.executeUpdate() > 0 ;
		
	}
	public boolean deleteID_from_Score(int id) throws ClassNotFoundException, SQLException
	{
		this.connect();
		String sql = "DELETE FROM BangDiem WHERE [IDSINHVIEN] = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		try {
			ps.setInt(1, id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ps.executeUpdate() > 0 ;
		
	}
	public BangDiem  findByID(int id) throws ClassNotFoundException, SQLException
	{
		this.connect();
		String sql = "SELECT * FROM BangDiem WHERE [IDSINHVIEN] = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				BangDiem bd = new BangDiem();
				bd.setIDBANGDIEM(rs.getInt("IDBANGDIEM"));
				bd.setMaSinhVien(rs.getInt("IDSINHVIEN"));
				bd.setDiemjava(rs.getFloat("JAVA"));
				bd.setDiemcsdl(rs.getFloat("CSDL"));
				bd.setDiemTinDC(rs.getFloat("TINDC"));
				return bd;
			}
			return null;
	}
	public ArrayList<BangDiem> uploadALL() throws ClassNotFoundException, SQLException
	{
		ArrayList<BangDiem> list = new ArrayList<>();
		this.connect();
		String sql = "SELECT * FROM BangDiem";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				BangDiem bd = new BangDiem();
				bd.setIDBANGDIEM(rs.getInt("IDBANGDIEM"));
				bd.setMaSinhVien(rs.getInt("IDSINHVIEN"));
				bd.setDiemjava(rs.getFloat("JAVA"));
				bd.setDiemcsdl(rs.getFloat("CSDL"));
				bd.setDiemTinDC(rs.getFloat("TINDC"));
				list.add(bd);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<BangDiem> timTOP(int top) throws ClassNotFoundException, SQLException
	{
		this.connect();
		ArrayList<BangDiem> list_top = new ArrayList<>();
		String sql = "select top " + top + " * , (JAVA + CSDL + TINDC )/3 as DTB"
				+ " from BangDiem order by dtb desc"; // asc desc
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				BangDiem bd = new BangDiem();
				bd.setIDBANGDIEM(rs.getInt("IDBANGDIEM"));
				bd.setMaSinhVien(rs.getInt("IDSINHVIEN"));
				bd.setDiemjava(rs.getFloat("JAVA"));
				bd.setDiemcsdl(rs.getFloat("CSDL"));
				bd.setDiemTinDC(rs.getFloat("TINDC"));
				list_top.add(bd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list_top;
		
	}
	
	

}
