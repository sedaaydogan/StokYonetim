package giris.dao;


import java.util.Date;
import java.util.List;

import giris.model.Malzeme;
import giris.model.MalzemeGiri;

public interface MalzemeGirisDAO {

	public MalzemeGiri MalzemeGirisYap(int girisAdet, Date girisTarih,String firma, int faturaNo, Date faturaTarih,String aciklama,String malzemeAdi,Malzeme malzeme);
	
	public int MalzemeGirisStokHesapla(int id);
	
	public List<MalzemeGiri> TumMalzemeGirisleriGoster();
	
	public MalzemeGiri MalzemeGirisBul(int id);
	
	public void MalzemeGirisSil(int id);
	
	public MalzemeGiri MalzemeGuncelle(int id,int girisAdet, Date girisTarih,String firma, int faturaNo, Date faturaTarih,String aciklama,String firmaAdi,String malzemeAdi,Malzeme malzeme);
	
}
