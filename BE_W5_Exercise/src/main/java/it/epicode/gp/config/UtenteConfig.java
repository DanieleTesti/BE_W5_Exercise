package it.epicode.gp.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;

import it.epicode.gp.model.Utente;

@Configuration
public class UtenteConfig {
	@Bean("ParamsUser")
	@Scope("prototype")
	public Utente paramsUser(String username, String name, String lastname, String email) {
		return new Utente(username, name, lastname, email);

	}
	@Bean("FakeUser")
	@Scope("prototype")
	public Utente fakeUser() {
		Faker fake = Faker.instance(new Locale("it-It"));
		Utente u = new Utente();
		u.setName(fake.name().firstName());
		u.setLastname(fake.name().lastName());
		u.setEmail(u.getName() + "." + u.getLastname() + "@example.com");
		u.setUsername(u.getName()+"."+u.getLastname());
		return u;
	}
}
