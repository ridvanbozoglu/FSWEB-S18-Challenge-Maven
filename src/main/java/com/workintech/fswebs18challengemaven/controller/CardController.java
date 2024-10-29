package com.workintech.fswebs18challengemaven.controller;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.entity.Color;
import com.workintech.fswebs18challengemaven.entity.Type;
import com.workintech.fswebs18challengemaven.exceptions.CardException;
import com.workintech.fswebs18challengemaven.repository.CardRepository;
import com.workintech.fswebs18challengemaven.util.CardValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cards")
public class CardController {
    private CardRepository cardRepository;

    @Autowired
    public CardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @GetMapping
    public List<Card> getAllCards(){
        return cardRepository.findAll();
    }

    @PostMapping
    public Card save(@RequestBody Card card){
        return cardRepository.save(card);
    }

    @GetMapping("/byColor/{color}")
    public List<Card> getByColor(@PathVariable String color){
        return cardRepository.findByColor(color);
    }

    @GetMapping("/byType/{type}")
    public List<Card> getByType(@PathVariable String type){
        return cardRepository.findByType(type);
    }

    @GetMapping("/byValue/{value}")
    public List<Card> getByValue(@PathVariable Integer value){
        return cardRepository.findByValue(value);
    }

    @PutMapping("/")
    public Card update(@RequestBody Card card){
        if (!CardValidation.cardIsValid(card)){
            throw new CardException("Card is not valid", HttpStatus.BAD_REQUEST);
        }
        return cardRepository.update(card);
    }

    @DeleteMapping("/{id}")
    public Card remove(@PathVariable long id){
        Card card = cardRepository.remove(id);
        if (card == null){
            throw new CardException("No Card with id",HttpStatus.NOT_FOUND);
        }
        return card;
    }


}
