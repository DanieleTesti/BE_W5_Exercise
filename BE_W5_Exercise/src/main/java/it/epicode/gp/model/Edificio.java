package it.epicode.gp.model;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "edifici")
public class Edificio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id_edificio;
private String nome;
@OneToOne
private Indirizzo indirizzo;
@OneToMany(mappedBy = "edificio",cascade = CascadeType.REMOVE)
private List<Postazione> postazioni;
}
