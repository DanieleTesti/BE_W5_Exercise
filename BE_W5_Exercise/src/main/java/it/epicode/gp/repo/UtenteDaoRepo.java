package it.epicode.gp.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.epicode.gp.model.Utente;

@Repository
public interface UtenteDaoRepo extends CrudRepository<Utente, Long>{

}
