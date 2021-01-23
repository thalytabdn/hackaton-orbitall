package com.orbitallcorp.hack21.cards.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Card implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Number cardNumber;

    private String embossName;

    private String customerName;

    private Number documentNumber;

    private String motherName;

    private String address;
    
    private String city;

}
