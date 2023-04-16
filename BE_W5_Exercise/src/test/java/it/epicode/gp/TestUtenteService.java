package it.epicode.gp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import it.epicode.gp.model.Utente;
import it.epicode.gp.service.UtenteService;


class TestUtenteService {
@Autowired
UtenteService user;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	

	@Test
	void test() {
     Utente u = new Utente();
     u.setEmail("priva@ex.com");
     u.setLastname("lastprova");
     u.setName("prova");
     u.setUsername("userprova");
     user.saveUtente(u);
    

	}

}
