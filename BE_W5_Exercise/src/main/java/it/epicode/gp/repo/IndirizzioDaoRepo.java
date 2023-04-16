package it.epicode.gp.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.epicode.gp.model.Indirizzo;
@Repository
public interface IndirizzioDaoRepo extends CrudRepository<Indirizzo,Long> {

}
