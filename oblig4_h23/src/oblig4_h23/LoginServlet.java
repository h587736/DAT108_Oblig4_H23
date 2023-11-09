package oblig4_h23;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private BrukerDAO brukerDAO;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String error = request.getParameter("error");
		request.setAttribute("error", error);
		
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
		
		}
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String tlf = request.getParameter("tlf");
		String password = request.getParameter("passord");
		
		Bruker bruker = brukerDAO.getBruker(tlf);
		
		if(bruker == null) {//Dersom bruker er null eksisterer den ikke
			
			//error 2: brukeren eksister ikke
			response.sendRedirect("LoginServlet" + "?error=1"); 
			
		} else { //Dersom bruker ikke er null eksisterer den 
			
			Passord pass = bruker.getPassord();
			String salt = pass.getPwd_salt();
			String passHash = pass.getPwd_hash();
			
			PassordService passordService = new PassordService();
			if(passordService.erKorrektPassord(password, salt, passHash)) {//dersom den matcher er det riktig passord
				
				FeltSjekk.createSession(request, 30);
				request.getSession().setAttribute("bruker", bruker);
				
				response.sendRedirect("DeltakerListeServlet");
			} else {
			
			//error 2: feil passord
			response.sendRedirect("LoginServlet" + "?error=2");
		}
		}
		
	}

}