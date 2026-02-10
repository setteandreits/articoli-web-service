package com.xantrix.webapp.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xantrix.webapp.dtos.ArticoliDto;
import com.xantrix.webapp.entities.Articoli;
import com.xantrix.webapp.repository.ArticoliRepository;

@Service
public class ArticoliServiceImpl implements ArticoliService {
 
	private ModelMapper modelMapper;
	
	//@Autowired
ArticoliRepository articoliRepository;
	
public ArticoliServiceImpl(ArticoliRepository articoliRepository,ModelMapper modelMapper) {
	
	this.articoliRepository = articoliRepository;
	this.modelMapper=  modelMapper;
}




@Override
public ArticoliDto SelByBarcode(String barcode) {
	
		return ConvertToDto(articoliRepository.selByEan(barcode));
	}




@Override
public ArticoliDto SelByCodArt(String codart) {
	return ConvertToDto(articoliRepository.findByCodArt(codart));
	
}




@Override
public List<ArticoliDto> SelByDescrizione(String descrizione) {
	
	return ConvertToDto(articoliRepository.selByDescrizioneLike(descrizione));
}

//fa la conversione con il model mapper dice entra come articoli esce come articolidto 
private ArticoliDto ConvertToDto(Articoli articoli) {
    ArticoliDto articoliDto = null;
    if (articoli != null) {
        articoliDto = modelMapper.map(articoli, ArticoliDto.class);
    }
    return articoliDto;
}
private List <ArticoliDto> ConvertToDto(List<Articoli>articoli)
{
	List<ArticoliDto> retVal =articoli
			.stream()
			.map(souce -> modelMapper.map(souce, ArticoliDto.class))
			.collect(Collectors.toList());
	return retVal;
}
}
