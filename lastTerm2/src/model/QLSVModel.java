package model;

import java.util.ArrayList;


public class QLSVModel {
	private ArrayList<ThiSinh> dsThiSinh;
	private String luaChon;

	public QLSVModel() {
		this.dsThiSinh = new ArrayList<ThiSinh>();
		this.luaChon = "";
	}

	public QLSVModel(ArrayList<ThiSinh> dsThiSinh) {
		this.dsThiSinh = dsThiSinh;
	}

	public ArrayList<ThiSinh> getDsThiSinh() {
		return dsThiSinh;
	}

	public void setDsThiSinh(ArrayList<ThiSinh> dsThiSinh) {
		this.dsThiSinh = dsThiSinh;
	}
	// ham insert
	public void insert(ThiSinh thisinh)
	{
		this.dsThiSinh.add(thisinh);
	}
	// delete thi sinh
	public void deleteByID(int id)
	{
		for (int i = 0 ; i < dsThiSinh.size() ; i++)
		{
			if(dsThiSinh.get(i).getMaThiSinh()==id)
			{
				this.dsThiSinh.remove(i);
			}
		}
	}
	public ThiSinh findTSByID(int id)
	{
		ThiSinh ts = new ThiSinh();
		for (int i = 0 ; i < this.dsThiSinh.size() ; i++)
		{
			if(dsThiSinh.get(i).getMaThiSinh()==id)
			{
				ts = dsThiSinh.get(i);
			}
				
		}
		return ts;
	}
	public void xoa(ThiSinh thisinh)
	{
		this.dsThiSinh.remove(thisinh);
		System.out.println("DA XOA :" + thisinh);
	}
	// cap nhat
	public void update(ThiSinh thisinh)
	{
		
		int stt = thisinh.getMaThiSinh(); // 5
		for (int i = 0 ; i < dsThiSinh.size() ; i++)
		{
			if(dsThiSinh.get(i).getMaThiSinh()==stt)
			{
				this.dsThiSinh.remove(i);
			}
		}
		this.dsThiSinh.add(thisinh); // 7
		
		
	}

	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public boolean KiemTraTonTai(ThiSinh ts) {
		for (ThiSinh thiSinh : dsThiSinh) {
			if (thiSinh.getMaThiSinh() ==  ts.getMaThiSinh())
			
				return true;
			
		}
		return false;
	}
	
}
