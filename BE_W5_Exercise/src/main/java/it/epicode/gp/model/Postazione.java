package it.epicode.gp.model;

import java.util.List;

import it.epicode.gp.enums.StatoPostazione;
import it.epicode.gp.enums.TipoPostazione;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "postazioni")
public class Postazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_postazione;
	private String descrizione;
	@Enumerated(EnumType.STRING)
	private TipoPostazione tipoPostazione;
	@Enumerated(EnumType.STRING)
	private StatoPostazione statoPostazione;
	private int nMaxOccupanti;
	@ManyToOne
	private Edificio edificio;
	@OneToMany(mappedBy = "postazione")
	private List<Prenotazione> prenotazione;
	

}
