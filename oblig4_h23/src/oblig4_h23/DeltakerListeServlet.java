package oblig4_h23;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeltakerListeServlet")
public class DeltakerListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private BrukerDAO brukerDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(!FeltSjekk.validerSesjon(request)) {
			response.sendRedirect("LoginServlet");
			
		}else {
		
		List<Bruker> list = brukerDAO.getAlleBrukere();
		list = sorterBrukere(list);

		
		request.getSession().setAttribute("list", list);
		request.getRequestDispatcher("WEB-INF/participantList.jsp").forward(request, response);
		}
	}

	private List<Bruker> sorterBrukere(List<Bruker> brukerListe){
        return brukerListe.stream().sorted(Comparator.comparing(Bruker::getFornavn).thenComparing(Bruker::getEtternavn)).collect(Collectors.toList());
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FeltSjekk.finishSession(request);
		response.sendRedirect("loggUt.html");
		
		
	
	}

}