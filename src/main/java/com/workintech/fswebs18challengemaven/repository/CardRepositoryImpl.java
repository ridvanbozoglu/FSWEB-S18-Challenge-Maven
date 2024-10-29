package com.workintech.fswebs18challengemaven.repository;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.entity.Color;
import com.workintech.fswebs18challengemaven.entity.Type;
import com.workintech.fswebs18challengemaven.exceptions.CardException;
import com.workintech.fswebs18challengemaven.util.CardValidation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardRepositoryImpl implements CardRepository{

    private EntityManager entityManager;

    @Autowired
    public CardRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public Card save(Card card) {
        entityManager.persist(card);
        return card;
    }

    @Override
    public List<Card> findByColor(String color) {
        TypedQuery<Card> result = entityManager.createQuery("select c from Card c where c.color = :color",Card.class);
        result.setParameter("color",color);
        return result.getResultList();
    }

    @Override
    public List<Card> findAll() {
        TypedQuery<Card> result = entityManager.createQuery("select c from Card c",Card.class);
        return result.getResultList();
    }

    @Override
    public List<Card> findByValue(Integer value) {
        TypedQuery<Card> result = entityManager.createQuery("select c from Card c where c.value = :value",Card.class);
        result.setParameter("value",value);
        return result.getResultList();
    }

    @Override
    public List<Card> findByType(String type) {
        TypedQuery<Card> result = entityManager.createQuery("select c from Card c where c.type = :type",Card.class);
        result.setParameter("type",type);
        return result.getResultList();
    }

    @Transactional
    @Override
    public Card update(Card card) {
        entityManager.merge(card);
        return card;
    }

    @Transactional
    @Override
    public Card remove(Long id) {
        Card card = entityManager.find(Card.class,id);
        if(card != null){
            entityManager.remove(card);
        }
        return card;
    }

    @Override
    public Card findById(Long id) {
        return entityManager.find(Card.class,id);
    }
}
