package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ThiSinh implements Serializable {
	private int maThiSinh;
	private String tenThiSinh;
	private Tinh queQuan;
	private Date ngaySinh;
	private boolean gioiTinh;
	private BangDiem diem;
	
	public ThiSinh(int maThiSinh, String tenThiSinh, Date ngaySinh, boolean gioiTinh,Tinh queQuan)
	{
		this.maThiSinh = maThiSinh;
		this.tenThiSinh = tenThiSinh;
		this.queQuan = queQuan;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
	}
	public ThiSinh()
	{
		
	}
	public int getMaThiSinh() {
		return maThiSinh;
	}
	public void setMaThiSinh(int maThiSinh) {
		this.maThiSinh = maThiSinh;
	}
	public String getTenThiSinh() {
		return tenThiSinh;
	}
	public void setTenThiSinh(String tenThiSinh) {
		this.tenThiSinh = tenThiSinh;
	}
	public Tinh getQueQuan() {
		return queQuan;
	}
	public void setQueQuan(Tinh queQuan) {
		this.queQuan = queQuan;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public BangDiem getDiem() {
		return diem;
	}
	public void setDiem(BangDiem diem) {
		this.diem = diem;
	}
	@Override
	public String toString() {
		return "ThiSinh [maThiSinh=" + maThiSinh + ", tenThiSinh=" + tenThiSinh + ", queQuan=" + queQuan + ", ngaySinh="
				+ ngaySinh + ", gioiTinh=" + gioiTinh + ", diem=" + diem + "]";
	}
	
	
	
	
	

}
