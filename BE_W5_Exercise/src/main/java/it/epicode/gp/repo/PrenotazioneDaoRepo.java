package it.epicode.gp.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.epicode.gp.model.Postazione;
import it.epicode.gp.model.Prenotazione;
import it.epicode.gp.model.Utente;

@Repository
public interface PrenotazioneDaoRepo extends CrudRepository<Prenotazione, Long> {
	
	public List<Prenotazione> findByDataPrenotazione(LocalDate data_prenotazione);

	public List<Prenotazione> findByPostazione(Postazione postazione);

	public List<Prenotazione> findByUtente(Utente utente);

	public Prenotazione findByDataPrenotazioneAndPostazione(LocalDate data_prenotazione, Postazione postazione);
	
	public Prenotazione findByDataPrenotazioneAndUtente(LocalDate data_prenotazione, Utente utente);
	
	
}
