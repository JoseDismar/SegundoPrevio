package com.mundial.selecciones.partido;

import java.sql.Date;

import com.mundial.selecciones.continente.Continente;
import com.mundial.selecciones.estadio.Estadio;

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
public class Partido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true)
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name="estadio_id")
	private Estadio estadio;

}
