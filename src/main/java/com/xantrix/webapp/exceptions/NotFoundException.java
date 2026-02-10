package com.xantrix.webapp.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class NotFoundException extends Exception {
 private static final long serialVersionUID = 872916930369924451L;
 private String messaggio ="Elemento Ricercato non Trovato";
 public NotFoundException() {
	 super();
 }
public NotFoundException(String messaggio) {
	super(messaggio);
	this.messaggio = messaggio;
}
 
}
