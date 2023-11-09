package oblig4_h23;

public class Skjema {
	private String fornavn;
	private String fornavnFeil;
	private String etternavn;
	private String etternavnFeil;
	private String tlf;
	private String tlfFeil;
	private String passord; 
	private String passordFeil;
	private String gjentaPassord;
	private String gjentaPassordFeil;
	private String kjonn;
	private String kjonnFeil;
	private BrukerDAO userDAO;
	
	public Skjema(String fornavn, String etternavn, String tlf, String passord, String gjentaPassord, String kjonn, BrukerDAO userDAO) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.tlf = tlf;
		this.passord = passord;
		this.gjentaPassord = gjentaPassord;
		this.kjonn = kjonn;
		this.userDAO = userDAO;
	}
	
	public boolean isAllInputValid() {
		return FeltSjekk.validerInput(fornavn, etternavn, tlf, passord, gjentaPassord, kjonn, userDAO);
	}
	
	public void findError() {
		if(!FeltSjekk.validerFornavn(fornavn)) {
			fornavn = "";
			fornavnFeil = "Ugyldig fornavn";
		}
		if(!FeltSjekk.validerEtternavn(etternavn)) {
			etternavn = "";
			etternavnFeil = "Ugyldig etternavn";
		}
		if(!FeltSjekk.validerTlf(tlf, userDAO)) {
			tlf = "";
			tlfFeil = "Ugydlig tlf";
		}
		if(!FeltSjekk.validerPassord(passord)) {
			passord = "";
			passordFeil = "Ugyldig passord";
		}
		if(!FeltSjekk.validerGjentaPassord(passord, gjentaPassord)) {
			gjentaPassord = "";
			gjentaPassordFeil = "Passordet matcher ikke";
		}
		if(!FeltSjekk.validerKjonn(kjonn)) {
			
			kjonnFeil = "Velg skjonn";
		}
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getFornavnFeil() {
		return fornavnFeil;
	}

	public void setFornavnFeil(String fornavnFeil) {
		this.fornavnFeil = fornavnFeil;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getEtternavnFeil() {
		return etternavnFeil;
	}

	public void setEtternavnFeil(String etternavnFeil) {
		this.etternavnFeil = etternavnFeil;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public String getTlfFeil() {
		return tlfFeil;
	}

	public void setTlfFeil(String tlfFeil) {
		this.tlfFeil = tlfFeil;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getPassordFeil() {
		return passordFeil;
	}

	public void setPassordError(String passordFeil) {
		this.passordFeil = passordFeil;
	}

	public String getRepeatPassord() {
		return gjentaPassord;
	}

	public void setRepeatPassord(String gjentaPassord) {
		this.gjentaPassord = gjentaPassord;
	}

	public String getGjentaPassordFeil() {
		return gjentaPassordFeil;
	}

	public void setGjentaPassordFeil(String gjentaPassordFeil) {
		this.gjentaPassordFeil = gjentaPassordFeil;
	}
	public String getKjonn() {
		return kjonn;
	}
	public String getKjonnFeil() {
		return kjonnFeil;
	}
}
