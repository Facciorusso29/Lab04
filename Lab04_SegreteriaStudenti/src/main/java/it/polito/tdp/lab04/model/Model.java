package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;



public class Model {
	private List <Corso> corsi=null;
	private List <Studente> studenti=null;

	public List<Corso> getCorsi() {
		if (this.corsi==null) {
			CorsoDAO dao = new CorsoDAO() ;
			this.corsi = dao.getTuttiICorsi() ;
		}
		return this.corsi;
	}
	public List<Studente> getStudentiByCorso(Corso c) {
		
			CorsoDAO dao = new CorsoDAO() ;
			this.studenti = dao.getStudentiIscrittiAlCorso(c) ;
		
		return this.studenti;
	}
}
