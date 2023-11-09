package oblig4_h23;

import javax.persistence.Embeddable;

@Embeddable
public class Passord {

	private String pwd_hash;
    private String pwd_salt;
    
	private Passord(String hash, String salt) {
		pwd_hash = hash;
		pwd_salt = salt;
	}
	
	public Passord() {}

	@Override
	public String toString() {
		return "Password [pwd_hash=" + pwd_hash + ", pwd_salt=" + pwd_salt + "]";
	}
	

	public String getPwd_hash() {
		return pwd_hash;
	}


	public String getPwd_salt() {
		return pwd_salt;
	}


	public static Passord createPassword(String passwordClear) {
		PassordService passordService = new PassordService();
		String salt = passordService.genererTilfeldigSalt();
		String hash = passordService.hashMedSalt(passwordClear, salt);
		return new Passord(hash, salt);
	}
}