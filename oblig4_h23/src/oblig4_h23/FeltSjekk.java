package oblig4_h23;

import java.util.List;
import java.util.regex.*;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class FeltSjekk {
	

	

	public static boolean createSession(HttpServletRequest request, int time) {
		
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(time);
		return true;
	}
	
	public static boolean validerSesjon(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		
		if (session != null) { 
			return true;
	}
		return false;
	
	}
	
	public static void finishSession(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			session.invalidate();
		
		}
		
	}
	
	public static boolean validerInput(String fornavn, String etternavn, String tlf, String passord, String gjentaPassord, String kjonn, BrukerDAO brukerDAO) {		
		
		if(validerFornavn(fornavn) && validerEtternavn(etternavn) && validerTlf(tlf, brukerDAO)
				&& validerPassord(passord) && validerGjentaPassord(passord, gjentaPassord) && validerKjonn(kjonn)) {
			
			return true;
		}
		
		return false;
	}
	
	public static boolean validerKjonn(String kjonn) {
	
		if(kjonn!=null) {
			return true;
		}
		return false;
	}
	
	public static boolean validerGjentaPassord(String passord, String gjentaPassord) {
		if(gjentaPassord.equals(passord)) {
			return true;
		}
		return false;
	}
	
	public static boolean validerPassord(String passord) {
		int p = passord.length();
		if(p >= 8) {
			return true;
		}
		return false;
	}
	
	public static boolean validerTlf(String tlf, BrukerDAO brukerDAO) {
		int p = tlf.length();
		if(bareTall(tlf) && p == 8 && brukerDAO.checkUniquePhone(tlf)) {
			return true;
		}
		return false;
	}
	
	
	public static boolean validerFornavn(String fornavn) {
		int f = fornavn.length();
		if((f <= 20 && f>=2) && (Character.isUpperCase(fornavn.charAt(0)) && 
				(fornavn.matches("(?i)(^[a-zA-ZæøåÆØÅ -]+)[a-zA-ZæøåÆØÅ -]((?! -)$){0,26}$")))) {
			return true;
		}
		return false;
		
	}
	
	public static boolean validerEtternavn(String lastname) {
		int l = lastname.length();
		if((l <= 20 && l >= 2) && (Character.isUpperCase(lastname.charAt(0)) && 
				(lastname.matches("(?i)(^[a-zA-ZæøåÆØÅ-]+)[a-zA-ZæøåÆØÅ-]((?! -)$){0,26}$")))) {
			return true;
		}
		return false;
		

	}
	
	 public static boolean validerStreng(String str) {
		 
	      str = str.toLowerCase();
	      char[] charArray = str.toCharArray();
	      for (int i = 0; i < charArray.length; i++) {
	         char ch = charArray[i];
	         if (!(ch >= 'a' && ch <= 'z')) {
	            return false;
	         }
	      }
	      return true;
	 }
	
	
	public static boolean bareTall(String str) 
    { 
        // Regex to check string 
        // contains only digits 
        String regex = "[0-9]+"; 
  
        // Compile the ReGex 
        Pattern p = Pattern.compile(regex); 
  
        // If the string is empty 
        // return false 
        if (str == null) { 
            return false; 
        } 
  
        // Find match between given string 
        // and regular expression 
        // using Pattern.matcher() 
        Matcher m = p.matcher(str); 
  
        // Return if the string 
        // matched the ReGex 
        return m.matches(); 
    } 
	
	
	public static String escapeHtml(String s) {
		String result = s; 
		result = result.replace("<", "$lt;");
		result = result.replace(">", "$gt;");
		result = result.replace("/", "$quot;");
		result = result.replace("&", "&amp;");
		return result;
	}
	
}