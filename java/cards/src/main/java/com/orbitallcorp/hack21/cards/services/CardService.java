package com.orbitallcorp.hack21.cards.services;

import java.util.ArrayList;
import java.util.List;

import com.orbitallcorp.hack21.cards.domains.Card;
import com.orbitallcorp.hack21.cards.repositories.CardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    
    @Autowired
    private CardRepository cardRepository;
    
    // Save a new card 
    public Card save(Card card){
        return cardRepository.save((card));
    }

    // Return all the cards
    public List<Card> findAll(){
        List<Card> cards = new ArrayList<>();
        
        cardRepository.findAll().forEach(cards :: add);
       
        return cards;

    }

    //The cards can be ordered by: embossName, customerName and city 
    public List<Card> order(String order){
        if(order == null){
            order = "";
        }

        List<Card> cards = new ArrayList<>();

        if (order.equals("embossName")){
            cardRepository.getCardByEmbossName().forEach(cards :: add);
        }
        else if(order.equals("customerName")){
            cardRepository.getCardByCustomerName().forEach(cards :: add);
        }
        else if(order.equals("city")){
           cardRepository.getCardByCity().forEach(cards :: add);
        }
        else if(order.equals("address")){
            cardRepository.getCardByAddress().forEach(cards::add);
         }
        else{
           cardRepository.findAll().forEach(cards :: add);

        }
        
        return cards;

    }

    //Update card data
    public void updateCard(Card card){
        cardRepository.save(card);
    }

    //Return a card receiving an id as parameter
    public Card findById(Long id){
        return cardRepository.findById(id).get();
    }

    //Delete a card receiving an id as parameter
	public void deleteCardById(Long id) {
        cardRepository.deleteById(id);
    }
}
