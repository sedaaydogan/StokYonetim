package giris.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AnasayfaController {

	private String formPath;

	public AnasayfaController() {
		formPath = "ekranPage.xhtml";
	}

	public String getFormPath() {
		return formPath;
	}

	public void setFormPath(String formPath) {
		this.formPath = formPath;
	}

	public void gotoPage(int id) {

		switch (id) {

		case 1:
			formPath = "ekipman_servis_gidis.xhtml";
			break;
		case 2:
			formPath = "ekipman_servis_donus.xhtml";
			break;
		case 3:
			formPath = "malzeme_giris.xhtml";
			break;
		case 4:
			formPath = "malzeme_cikis.xhtml";
			break;
		case 5:
			formPath = "sarf_malzeme_tanimlama.xhtml";
			break;
		case 6:
			formPath = "ekipman_tanimlama.xhtml";
			break;
		case 7:
			formPath = "kullanici_tanimlama.xhtml";
			break;
		}
	}

}
