package oblig4_h23;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	@WebServlet("/RegistrerServlett")
	public class RegistrerServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
		@EJB
		private BrukerDAO brukerDAO;

		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher("WEB-INF/registration.jsp").forward(request, response);
		}

		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
			
			String fornavn = FeltSjekk.escapeHtml(request.getParameter("fornavn"));
			String etternavn = FeltSjekk.escapeHtml(request.getParameter("etternavn"));
			String tlf = FeltSjekk.escapeHtml(request.getParameter("tlf"));
			String pass = FeltSjekk.escapeHtml(request.getParameter("passord"));
			String gjentaPassord = FeltSjekk.escapeHtml(request.getParameter("gjentaPassord"));
			String kjonnString = FeltSjekk.escapeHtml(request.getParameter("kjonn"));
			
			String kjonn = null;
			
			if(kjonnString.equals("mann")) {
				kjonn = "MANN";
			}
			
			else if(kjonnString.equals("kvinne")) {
				kjonn = "KVINNE";
			}
			
			
			Skjema skjema = new Skjema(fornavn, etternavn, tlf, pass, gjentaPassord, kjonn, brukerDAO);
			
			if(skjema.isAllInputValid()) {
				
				
				Passord passord = Passord.createPassword(pass);
				
				Bruker nyBruker = new Bruker(fornavn, etternavn, tlf, passord, kjonn);
				
				brukerDAO.nyBruker(nyBruker);
				
				FeltSjekk.finishSession(request);
				
				FeltSjekk.createSession(request, 300);
				
				request.getSession().removeAttribute("form");
				request.getSession().setAttribute("user", nyBruker);
				response.sendRedirect("RegKvittServlet");
				
			} else {
				
			skjema.findError();
			
			request.getSession().setAttribute("skjema", skjema);
			response.sendRedirect("RegistrerServlet");
				
			}
			
		}

	}

