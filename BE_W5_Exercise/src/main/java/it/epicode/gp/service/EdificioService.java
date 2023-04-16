package it.epicode.gp.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import it.epicode.gp.model.Edificio;
import it.epicode.gp.repo.EdificioDaoRepo;
import it.epicode.gp.repo.IndirizzioDaoRepo;

@Service
public class EdificioService {
	@Autowired
	private EdificioDaoRepo edificioRepo;
	@Autowired
	private IndirizzioDaoRepo inRepo;
	@Autowired
	@Qualifier("RandomEdificio")
	private ObjectProvider<Edificio> randomEdificioProvider;

	public void createAndSaveRandomEdificio() {
		saveEdificio(randomEdificioProvider.getObject());
		System.out.println("Edificio creato con successo");
	}

	public void saveEdificio(Edificio e) {
		inRepo.save(e.getIndirizzo());
		edificioRepo.save(e);
	}

	public Edificio findEdificioById(Long id) {
		return edificioRepo.findById(id).get();
	}

	public List<Edificio> findAllEdificio() {
		return (List<Edificio>) edificioRepo.findAll();
	}

	public void removeEdificio(Edificio e) {
		edificioRepo.delete(e);
	}

}
