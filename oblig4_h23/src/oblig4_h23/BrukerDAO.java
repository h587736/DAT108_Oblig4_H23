package oblig4_h23;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BrukerDAO {
	
	@PersistenceContext(name = "brukerPU")
    private EntityManager em;
	
	public List<Bruker> getAlleBrukere() {
		return em.createQuery("SELECT b FROM Bruker b", Bruker.class).getResultList();
	}
	
	public boolean checkUniquePhone(String tlf){
		List<Bruker> list = em.createQuery("SELECT b FROM Bruker b", Bruker.class).getResultList();
		
		for(Bruker s : list) {
			if(s.getTlf().equals(tlf)) {
				return false;
			}
		}
		return true;
			
	}
	
	public synchronized Bruker getBruker(String navn) {
		return em.find(Bruker.class, navn);
	}

	public synchronized void nyBruker(Bruker nyBruker) {
		em.persist(nyBruker);
	}
}