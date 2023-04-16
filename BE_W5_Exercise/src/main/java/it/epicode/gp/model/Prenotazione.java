package it.epicode.gp.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "prenotazioni", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "utente_id_utente", "postazione_id_postazione", "dataPrenotazione" }),
		@UniqueConstraint(columnNames = { "postazione_id_postazione", "dataPrenotazione" }),
		@UniqueConstraint(columnNames = { "utente_id_utente", "dataPrenotazione" }) })
public class Prenotazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_prenotazione;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Utente utente;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Postazione postazione;

	// da modificare
	@Column(nullable = false)
	private LocalDate dataPrenotazione;
}
