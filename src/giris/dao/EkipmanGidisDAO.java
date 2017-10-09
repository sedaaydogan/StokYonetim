package giris.dao;

import java.util.Date;
import java.util.List;

import giris.model.Ekipman;
import giris.model.EkipmanServisGidi;
import giris.model.User;

public interface EkipmanGidisDAO {

	public EkipmanServisGidi EkipmanServisGidisYap(Ekipman ekipman, String model, String kullaniciAdi, 
			Date gidisTarihi, String firmaAdi, String ekipmanAdi, String aciklama, User user,String seriNo);
	
	public EkipmanServisGidi EkipmanServisGidisBul(int id);
	
	public List<EkipmanServisGidi> EkipmanServisGidisListele();
	
	public void EkipmanServisGidisSil(int id);


}
