package it.epicode.gp.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;

import it.epicode.gp.model.Edificio;
import it.epicode.gp.model.Indirizzo;

@Configuration
public class EdificioConfig {
	Faker fake = Faker.instance(new Locale("it-It"));
	@Bean("RandomIndirizzo")
	@Scope("prototype")
	public Indirizzo randomIndirizzo() {
		
		Indirizzo i = new Indirizzo();
		i.setCitta(fake.address().cityName());
		i.setVia(fake.address().streetName());
		i.setN_civico(fake.number().numberBetween(0, 100));
		return i;
	}
	@Bean("RandomEdificio")
	@Scope("prototype")
	public Edificio randomEdificio() {
		
		Edificio e = new Edificio();
		e.setNome(fake.name().fullName()+" Palace");
		e.setIndirizzo(randomIndirizzo());
		
		return e;
	}
	
}
