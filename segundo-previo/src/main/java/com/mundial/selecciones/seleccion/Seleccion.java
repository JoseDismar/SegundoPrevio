package com.mundial.selecciones.seleccion;

import com.mundial.selecciones.continente.Continente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seleccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 100,nullable = false, unique = true)
	private String nombre;
	@Column(length = 1,nullable = false, unique = true)
	private Character grupo;
	
	@ManyToOne
	@JoinColumn(name="continente_id")
	private Continente continente;
}
