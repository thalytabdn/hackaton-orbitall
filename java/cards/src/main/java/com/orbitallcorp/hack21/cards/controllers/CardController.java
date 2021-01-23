package com.orbitallcorp.hack21.cards.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.orbitallcorp.hack21.cards.domains.Card;
import com.orbitallcorp.hack21.cards.services.CardService;

@RestController
@RequestMapping("/cards")
public class CardController {
    
    @Autowired
    private CardService cardService;

    // ------------------- Creates a new card -------------------
    @PostMapping
    public ResponseEntity<Card> save (@RequestBody Card card){
        
        Card savedCard = cardService.save(card);

        return new ResponseEntity(savedCard, HttpStatus.CREATED);
    }

    // ------------------- Returns all cards -------------------
    @GetMapping
    public ResponseEntity<List<Card>> findAll(){
        List<Card> cards = cardService.findAll();

        if(cards.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.ok(cards);
    }

    // ------------------- Return sorted cards -------------------
    @GetMapping("/paginationAndSorting")
    public ResponseEntity<List<Card>> paginationAndSorting(@RequestParam (required = false) String order){
        List<Card> cards = cardService.order(order);

        return ResponseEntity.ok(cards);
    }

    // ------------------- Update data for a specific card -------------------
    @PutMapping("/{id}")
    public ResponseEntity<Card> updateCard(@PathVariable("id") Long id, @RequestBody Card card){
        Card cardAux = cardService.findById(id);

        //Verifications that allow to change only one parameter per request
		if(card.getAddress() != null){
			cardAux.setAddress(card.getAddress());
		}

		if(card.getCardNumber() != null){
			cardAux.setCardNumber(card.getCardNumber());
		}

		if(card.getCity() != null){
			cardAux.setCity(card.getCity());
		}

		if(card.getCustomerName() != null){
			cardAux.setCustomerName(card.getCustomerName());
		}

		if(card.getDocumentNumber()!= null){
			cardAux.setDocumentNumber(card.getDocumentNumber());
        }
        
        if(card.getEmbossName()!= null){
			cardAux.setEmbossName(card.getEmbossName());
        }
        
        if(card.getMotherName()!= null){
			cardAux.setMotherName(card.getMotherName());
		}

        cardService.updateCard(cardAux);
        
		return new ResponseEntity<Card>(cardAux, HttpStatus.OK);
    }
    
    // ------------------- Delete a specific card -------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCard(@PathVariable("id") Long id) {

		Card cardAux = cardService.findById(id);

        //tratar erro caso card não exista

		cardService.deleteCardById(cardAux.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    // ------------------- Returns a specific card -------------------
    @GetMapping("/{id}")
    public ResponseEntity<?> getCard(@PathVariable("id") long id) {

        Card cardAux = cardService.findById(id);

        return new ResponseEntity<Card>(cardAux, HttpStatus.OK);

	}
        
}

