package com.xantrix.webapp.dtos;

import java.util.Date;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IvaDto {
	private int idIva;
	private String descrizione;
	private int aliquota;
}
