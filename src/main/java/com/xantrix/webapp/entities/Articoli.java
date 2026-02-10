package com.xantrix.webapp.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="Articoli")
public class Articoli {
	@Id
	@Column(name="codart")
 private String	codArt; 
	@Column(name="descrizione")
	private String descrizione; 
	@Column(name="um")
	private String um ;
	@Column(name="codstat")
	private String codStat ;
	@Column(name="pzcart")
	private Integer pzCart ;
	@Column(name="pesonetto")
	private double pesoNetto ;
	@Column(name="idstatoart")
	private String idStatoArt ;
	@Temporal(TemporalType.DATE)
	@Column(name="datacreazione")
	private Date datacreazione;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "articolo",orphanRemoval = true)
	@JsonManagedReference 
	private Set<Barcode> barcode = new HashSet<>();
	@OneToOne(cascade =CascadeType.ALL,mappedBy="articolo",orphanRemoval = true)
    private Ingredienti ingredienti;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idiva",referencedColumnName ="idiva")
	private Iva iva;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idfamass",referencedColumnName ="id")
	private FamAssort famAssort;
	
}
