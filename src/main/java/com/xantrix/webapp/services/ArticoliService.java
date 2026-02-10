package com.xantrix.webapp.services;

import java.util.List;

import com.xantrix.webapp.dtos.ArticoliDto;
import com.xantrix.webapp.entities.Articoli;

public interface ArticoliService {
 public ArticoliDto SelByBarcode(String barcode);
 public ArticoliDto SelByCodArt(String codart);
 public List< ArticoliDto> SelByDescrizione(String descrizione);
}
