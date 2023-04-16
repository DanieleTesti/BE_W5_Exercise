package it.epicode.gp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import it.epicode.gp.enums.StatoPostazione;
import it.epicode.gp.model.Postazione;
import it.epicode.gp.model.Prenotazione;
import it.epicode.gp.model.Utente;
import it.epicode.gp.repo.PrenotazioneDaoRepo;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PrenotazioneService {
	@Autowired
	PrenotazioneDaoRepo preRepo;
	@Autowired
	@Qualifier("ParamPrenotazione")
	private ObjectProvider<Prenotazione> paramPrenotazioneProvider;

	public void createAndSavePrenotazione(LocalDate data, Utente u, Postazione pos) {
		if (data.isAfter(LocalDate.now())) {
			if (pos.getStatoPostazione() == StatoPostazione.LIBERO) {
				if (findPrenotazioneByDataAndPostazione(data, pos) == null) {
					if (findPrenotazioneByDataAndUtente(data, u) == null) {
						savePrenotazione(paramPrenotazioneProvider.getObject(data, u, pos));
						System.out.println("Prenotazione eseguita con sucesso");
					} else {
						log.error("L'utente ha gia un prenotazione per questa data");
					}

				} else {
					log.error("Per questa data è gia prenotata questa postazione");
				}
			} else {
				log.error("Postazione non disponibile");
			}
		} else {
			log.error("Data già passata");
		}

	}

	private void savePrenotazione(Prenotazione pre) {
		preRepo.save(pre);

	}

	public Prenotazione findPrenotazioneById(Long id) {
		return preRepo.findById(id).get();
	}

	public List<Prenotazione> findAllPrenotazione() {
		return (List<Prenotazione>) preRepo.findAll();
	}

	public void removePrenotazione(Prenotazione pre) {
		preRepo.delete(pre);
	}

	public void removePrenotazioneById(Long id) {
		preRepo.deleteById(id);
	}

	public List<Prenotazione> findPrenotazioneByData(LocalDate data) {
		return (List<Prenotazione>) preRepo.findByDataPrenotazione(data);
	}

	public List<Prenotazione> findPrenotazioneByUtente(Utente u) {
		return (List<Prenotazione>) preRepo.findByUtente(u);
	}

	public List<Prenotazione> findPrenotazioneByPostazione(Postazione pos) {
		return (List<Prenotazione>) preRepo.findByPostazione(pos);
	}

	public Prenotazione findPrenotazioneByDataAndPostazione(LocalDate data, Postazione pos) {
		return preRepo.findByDataPrenotazioneAndPostazione(data, pos);
	}

	public Prenotazione findPrenotazioneByDataAndUtente(LocalDate data, Utente u) {
		return preRepo.findByDataPrenotazioneAndUtente(data, u);
	}

}
