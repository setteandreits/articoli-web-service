package com.xantrix.webapp;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.xantrix.webapp.dtos.BarcodeDto;
import com.xantrix.webapp.dtos.ArticoliDto;
import com.xantrix.webapp.entities.Articoli;
import com.xantrix.webapp.entities.Barcode;

//converte entity in dto 

@Configuration
public class ModelMapperConfing {
	@Bean
    public ModelMapper modelMapper() 
    {
        ModelMapper modelMapper = new ModelMapper();
        
       //Saltare i valori a null
        modelMapper.getConfiguration().setSkipNullEnabled(true);
       //serve per mappare 
      //  modelMapper.addMappings(articoliMapping);

        
      //specifichiamo la nostra classe di partenza e arrivo
        modelMapper.addMappings(new PropertyMap<Barcode, BarcodeDto>() 
        {
        	//diciamo semplicemente che datacreazione  corrisponde a datacreaz
            @Override
            protected void configure() 
            {
                map().setIdTipoArt(source.getIdTipoArt());
            }
        });

        modelMapper.addConverter(articoliConverter);

        return modelMapper;
    }
//specifichiamo la nostra classe di partenza e arrivo 
//    PropertyMap<Articoli, ArticoliDto> articoliMapping = new PropertyMap<Articoli, ArticoliDto>() 
//    {
//    	//diciamo semplicemente che datacreazione  corrisponde a datacreaz
//        protected void configure() 
//        {
//            map().setDataCreazione(source.getDatacreaz());
//        }
//    };

    
    //va a vereificare se la sorgente è uguale a null vengono convertiti in una stringa vuota  nel 
    //caso viene trovato context.getSource().trim(); elimina tutti li spazi vuoti 
    Converter<String, String> articoliConverter = new Converter<String, String>() 
    {
        @Override
        public String convert(MappingContext<String, String> context) 
        {
            return context.getSource() == null ? "" : context.getSource().trim();
        }
    };
}