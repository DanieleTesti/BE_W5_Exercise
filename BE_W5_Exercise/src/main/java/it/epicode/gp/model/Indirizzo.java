package it.epicode.gp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
@Table(name = "indirizzi")
public class Indirizzo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id_indirizzo;
private String citta;
private String via;
private int n_civico;
@OneToOne(mappedBy = "indirizzo")
private Edificio edificio;
}
