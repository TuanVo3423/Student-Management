package model;

import java.util.ArrayList;

public class BangDiemModel {
	private ArrayList<BangDiem> list_score;
	
	public BangDiemModel()
	{
		this.list_score = new ArrayList<BangDiem>();
	}

	public BangDiemModel(ArrayList<BangDiem> list_score) {
		this.list_score = list_score;
	}

	public ArrayList<BangDiem> getList_score() {
		return list_score;
	}

	public void setList_score(ArrayList<BangDiem> list_score) {
		this.list_score = list_score;
	}
	
	// add 
	public void add_new_score(BangDiem bd)
	{
		this.list_score.add(bd);
	}
	// update
	public void update_score(BangDiem bd)
	{
		int idsv = bd.getMaSinhVien();
		for (int i = 0 ; i < list_score.size() ; i++)
		{
			if(list_score.get(i).getMaSinhVien()==idsv)
			{
				this.list_score.remove(i);
			}
		}
		this.list_score.add(bd);
	}
	
	// delete
	public void deleteByIDSV(int id)
	{
		for (int i = 0 ; i < list_score.size() ; i++)
		{
			if(list_score.get(i).getMaSinhVien()==id)
			{
				this.list_score.remove(i);
			}
		}
	}
	// tim id thi sinh max
	public BangDiem findmax()
	{
		BangDiem bd = new BangDiem();
		float max = list_score.get(0).getDiemTrungBinh();
		System.out.println(max);
		for (int i = 0 ; i < list_score.size() ; i++)
		{
			if(list_score.get(i).getDiemTrungBinh()>max)
			{
				max = list_score.get(i).getDiemTrungBinh();	
			}
		}
		for (int i = 0 ; i < list_score.size() ; i++)
		{
			if(list_score.get(i).getDiemTrungBinh()==max)
			{
				bd = list_score.get(i);
			}
		}
		return bd;
		
	}
	
	
	

}
