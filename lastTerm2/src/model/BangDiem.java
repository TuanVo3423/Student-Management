package model;

public class BangDiem {
	private int IDBANGDIEM;
	private int maSinhVien;
	private float Diemjava;
	private float Diemcsdl;
	private float DiemTinDC;
	float diemTrungBinh;
	
	
	public BangDiem(int iDBANGDIEM, int maSinhVien, float diemjava, float diemcsdl, float diemTinDC,float diemTrungBinh) {
		this.IDBANGDIEM = iDBANGDIEM;
		this.maSinhVien = maSinhVien;
		this.Diemjava = diemjava;
		this.Diemcsdl = diemcsdl;
		this.DiemTinDC = diemTinDC;
		this.diemTrungBinh = diemTrungBinh;
	}
	public BangDiem( int maSinhVien, float diemjava, float diemcsdl, float diemTinDC,float diemTrungBinh) {
		this.maSinhVien = maSinhVien;
		this.Diemjava = diemjava;
		this.Diemcsdl = diemcsdl;
		this.DiemTinDC = diemTinDC;
		this.diemTrungBinh = diemTrungBinh;
	}
	

public BangDiem() {
	
	}


//	public BangDiem(int maSinhVien , float diemjava, float diemcsdl, float diemTinDC) {
//		this.maSinhVien = maSinhVien;
//		Diemjava = diemjava;
//		Diemcsdl = diemcsdl;
//		DiemTinDC = diemTinDC;
//		tinhdtb();
//	}
	
	public int getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public float getDiemjava() {
		return Diemjava;
	}
	public void setDiemjava(float diemjava) {
		Diemjava = diemjava;
	}
	public float getDiemcsdl() {
		return Diemcsdl;
	}
	public void setDiemcsdl(float diemcsdl) {
		Diemcsdl = diemcsdl;
	}
	public float getDiemTinDC() {
		return DiemTinDC;
	}
	public void setDiemTinDC(float diemTinDC) {
		DiemTinDC = diemTinDC;
	}
	public float getDiemTrungBinh() {
		return diemTrungBinh;
	}
	public void setDiemTrungBinh(float diemTrungBinh) {
		this.diemTrungBinh = diemTrungBinh;
	}
	
	public int getIDBANGDIEM() {
		return IDBANGDIEM;
	}
	public void setIDBANGDIEM(int iDBANGDIEM) {
		IDBANGDIEM = iDBANGDIEM;
	}


	public void tinhdtb()
	{
		this.diemTrungBinh = (Diemcsdl+Diemjava+DiemTinDC)/3;
	}


	@Override
	public String toString() {
		return "BangDiem [IDBANGDIEM=" + IDBANGDIEM + ", maSinhVien=" + maSinhVien + ", Diemjava=" + Diemjava
				+ ", Diemcsdl=" + Diemcsdl + ", DiemTinDC=" + DiemTinDC + ", diemTrungBinh=" + diemTrungBinh + "]";
	}
	
	
}
