package com.mundial.selecciones.resultado;

import com.mundial.selecciones.continente.Continente;
import com.mundial.selecciones.partido.Partido;
import com.mundial.selecciones.seleccion.Seleccion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resultado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="partido_id")
	private Partido partido;
	
	@ManyToOne
	@JoinColumn(name="partido_id")
	private Seleccion seleccion;
	
	@Column(nullable = false, unique = true)
	private Integer goles;
	
	@Column(nullable = false, unique = true)
	private Integer amarillas;
	
	@Column(nullable = false, unique = true)
	private Integer rojas;

}
