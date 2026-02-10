package com.xantrix.webapp.dtos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ArticoliDto {

	private String codArt;
	private String descrizione;
	private String um;
	private String codStat;
	private Integer pzCart;
	private double pesoNetto;
	private String idStatoArt;
	private Date dataCreazione;
	private double prezzo =0;
	 
	private Set<BarcodeDto> barcode = new HashSet<>();
	private Ingredientidto ingredienti;
	private CategoriaDto famAssort;
	private IvaDto iva;
	
	
	
	
}
