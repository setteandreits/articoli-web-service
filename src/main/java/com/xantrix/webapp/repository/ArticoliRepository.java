package com.xantrix.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.xantrix.webapp.entities.Articoli;
import org.springframework.data.domain.Pageable;
public interface ArticoliRepository extends JpaRepository <Articoli,String>{
//Ricerca un articolo dal codice Codart e te lo restituisce
	Articoli findByCodArt(String codArt);

//Ti restituisce tutti gli articoli grazie al codice cadart 
List<Articoli> findByCodStatOrderByDescrizione(String codStat);

//è come sql ma parla con le classi java qua fa la ricerca tramite id egrazie pageable non carica tutti i prodotti ma i primi 10 
// JPQL
@Query(value = "SELECT a FROM Articoli a JOIN a.famAssort b WHERE b.id = :idCat")
List<Articoli> selByIdCat(@Param("idCat") String idCat, Pageable pageable);

//cerca dentro la tabella dei codici collegati all'arrticolo
//Trova l'articolo che ha questo specifico ean dal param
// JPQL
@Query(value = "SELECT a FROM Articoli a JOIN a.barcode b WHERE b.barcode IN (:ean)")
Articoli selByEan(@Param("ean") String ean);
  
//questo codice viene passato al db cosi com'è.
// SQL
@Query(value = "SELECT * FROM ARTICOLI WHERE DESCRIZIONE LIKE :desArt", nativeQuery = true)
List<Articoli> selByDescrizioneLike(@Param("desArt") String descrizione);
}
