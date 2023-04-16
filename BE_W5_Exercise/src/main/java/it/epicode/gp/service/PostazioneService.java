package it.epicode.gp.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import it.epicode.gp.enums.StatoPostazione;
import it.epicode.gp.enums.TipoPostazione;
import it.epicode.gp.model.Edificio;
import it.epicode.gp.model.Postazione;
import it.epicode.gp.repo.EdificioDaoRepo;
import it.epicode.gp.repo.PostazioneDaoRepo;

@Service
public class PostazioneService {
	@Autowired
	PostazioneDaoRepo posRepo;
	@Autowired 
	EdificioDaoRepo edRepo;
	@Autowired
		@Qualifier("RandomPostazione")
	private ObjectProvider<Postazione> randomPostazioneProvider;
	@Autowired
	@Qualifier("ParamPostazione")
	private ObjectProvider<Postazione> paramsPostazioneProvider;
	
	public void createAndSavePostazioneParams(String desc, int n, StatoPostazione statop, TipoPostazione tipop, Edificio e) {
		savePostazione(paramsPostazioneProvider.getObject(desc,  n,  statop,  tipop,  e));
	}

	public void createAndSaveRandomPostazione() {
		List<Edificio> listaEd = (List<Edificio>) edRepo.findAll();
		for(int i = 0; i<listaEd.size(); i++) {
			int randN = (int) (Math.random()*5);
			for(int j = 0; j<=randN;j++) {
				
				savePostazione(randomPostazioneProvider.getObject(listaEd.get(i)));
				System.out.println("Postazione creata con successo");
			}
		}
		
	}
	public void savePostazione(Postazione p) {
		try {
			posRepo.save(p);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public Postazione findPostazioneById(Long id) {
		return posRepo.findById(id).get();
	}
	public List<Postazione> findAllPostazione(){
		return (List<Postazione>) posRepo.findAll();
	}
	public void removePostazione(Postazione p) {
	posRepo.delete(p);
	}
	public void removePostazioneById(Long id) {
		posRepo.deleteById(id);;
	}
	public List<Postazione> findPostazioneByTipo(TipoPostazione t) {
		return posRepo.findByTipoPostazione(t);
	}
}
