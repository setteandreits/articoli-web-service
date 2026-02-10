package com.xantrix.webapp.entities;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor


@Table(name="BARCODE")
public class Barcode {
	@Id
	@Column(name="BARCODE")
	
 private String	barcode; 
	
	
	@Column(name="IDTIPOART")
 private String	idTipoArt; 
	
	@ManyToOne
	@JoinColumn(name="codart",referencedColumnName ="codart")
	
	@JsonBackReference
	private Articoli articolo;
}
