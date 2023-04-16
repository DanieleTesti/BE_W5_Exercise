package it.epicode.gp.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.epicode.gp.service.EdificioService;
import it.epicode.gp.service.PostazioneService;
import it.epicode.gp.service.PrenotazioneService;
import it.epicode.gp.service.UtenteService;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class GestionePrenotazioni implements CommandLineRunner {
	@Autowired
	UtenteService uService;
	@Autowired
	EdificioService edService;
	@Autowired
	PostazioneService posService;
	@Autowired
	PrenotazioneService preService;

	@Override
	public void run(String... args) throws Exception {
		log.warn("Cominxiamo");

//		edService.createAndSaveRandomEdificio();
		// INSERIRE ALL'INTERNO DI createAndSaveFakeUtente il numero di utenti che si
		// vorranno creare
		// uService.createAndSaveFakeUtente(1);
		// posService.createAndSaveRandomPostazione();
		preService.createAndSavePrenotazione(LocalDate.of(2023, 12, 12), uService.findUtenteById(2l),
				posService.findPostazioneById(2l));

	}

}
