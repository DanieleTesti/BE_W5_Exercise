package it.epicode.gp.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;

import it.epicode.gp.enums.StatoPostazione;
import it.epicode.gp.enums.TipoPostazione;
import it.epicode.gp.model.Edificio;
import it.epicode.gp.model.Postazione;

@Configuration
public class PostazioneConfig {
	@Bean("paramPostazione")
	@Scope("prototype")
	public Postazione paramPostazione(String desc, int n, StatoPostazione statop, TipoPostazione tipop, Edificio e) {

		Postazione p = new Postazione();
		p.setDescrizione(desc);
		p.setNMaxOccupanti(n);
		p.setStatoPostazione(statop);
		p.setTipoPostazione(tipop);
		p.setEdificio(e);
		return p;
	}
	@Bean("RandomPostazione")
	@Scope("prototype")
	public Postazione randomPostazione(Edificio e) {
		Faker fake = Faker.instance(new Locale("it-IT"));
		Postazione p = new Postazione();
		p.setDescrizione("Description: "+fake.number().numberBetween(1, 50));
		p.setNMaxOccupanti(fake.number().numberBetween(5, 30));
		p.setStatoPostazione(StatoPostazione.LIBERO);
		int randN = (int) ((Math.random()*3)+1);
		switch (randN) {
		case 1: {
			p.setTipoPostazione(TipoPostazione.PRIVATO);
			break;
		}
		case 2: {
			p.setTipoPostazione(TipoPostazione.OPENSPACE);
			break;
		}
		case 3: {
			p.setTipoPostazione(TipoPostazione.SALA_RIUNIONI);
			break;
		}
		default:
			
			p.setTipoPostazione(TipoPostazione.PRIVATO);
		}
		p.setEdificio(e);
		return p;
	}
}
