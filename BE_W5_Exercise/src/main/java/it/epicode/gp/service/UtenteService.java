package it.epicode.gp.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import it.epicode.gp.model.Utente;
import it.epicode.gp.repo.UtenteDaoRepo;

@Service
public class UtenteService {
	@Autowired
	private UtenteDaoRepo uRepo;
	@Autowired
	@Qualifier("FakeUser")
	private ObjectProvider<Utente> fakeUtenteProvider;

	public void createAndSaveFakeUtente(int n) {
		for(int i=0; i<n; i++) {
	saveUtente(fakeUtenteProvider.getObject());}
System.out.println("Utente salvato con successo");
	}
	//lo stesso metodo per update
	public void saveUtente(Utente u) {
		uRepo.save(u);
	}
	public Utente findUtenteById(Long id) {
		return uRepo.findById(id).get();
	}
	public List<Utente> findAllUtente(){
		return (List<Utente>) uRepo.findAll();
	}
	public void removeUtente(Utente u) {
		uRepo.delete(u);
	}
	
}
