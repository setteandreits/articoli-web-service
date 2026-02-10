package com.xantrix.webapp.entities;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
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

@Table(name="ingredienti")
public class Ingredienti {
	@Id
	@Column(name="CODART")
 private String codArt;
	
	@Column(name="INFO")
 private String info;
	@OneToOne
	@PrimaryKeyJoinColumn
private Articoli articolo;
}
