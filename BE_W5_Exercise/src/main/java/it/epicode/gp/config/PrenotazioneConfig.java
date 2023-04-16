package it.epicode.gp.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.epicode.gp.model.Postazione;
import it.epicode.gp.model.Prenotazione;
import it.epicode.gp.model.Utente;

@Configuration
public class PrenotazioneConfig {
	@Bean("ParamPrenotazione")
	@Scope("prototype")
	public Prenotazione paramPrenotazione(LocalDate data, Utente u, Postazione post) {
		Prenotazione p = new Prenotazione();
		p.setDataPrenotazione(data);
		p.setUtente(u);
		p.setPostazione(post);
		return p;
	}
}
