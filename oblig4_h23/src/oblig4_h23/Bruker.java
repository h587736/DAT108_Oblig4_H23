package oblig4_h23;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig4_h23", name= "bruker1")
public class Bruker {
	String fornavn;
	String etternavn;
    @Id
    private String tlf;
    @Embedded
    private Passord passord;
    
    private String kjonn;
    
	public Bruker(String fornavn, String etternavn, String tlf, Passord passord, String kjonn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.tlf = tlf;
		this.passord = passord;
		this.kjonn = kjonn;
	}
	
	public Bruker() {}
	
	public Bruker(String fornavn, String etternavn, String tlf, String kjonn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.tlf = tlf;
		this.kjonn = kjonn;
	}

	public String getTlf() {
		return tlf;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public Passord getPassord() {
		return passord;
	}

	@Override
	public String toString() {
		return "Brukere [Telefon=" + tlf + ", passord=" + passord + "]";
	}
}
