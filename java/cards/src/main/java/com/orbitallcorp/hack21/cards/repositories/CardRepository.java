package com.orbitallcorp.hack21.cards.repositories;

import com.orbitallcorp.hack21.cards.domains.Card;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CardRepository extends PagingAndSortingRepository<Card, Long> {

}