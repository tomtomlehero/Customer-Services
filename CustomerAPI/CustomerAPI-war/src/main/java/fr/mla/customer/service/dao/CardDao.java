package fr.mla.customer.service.dao;

import fr.mla.customer.service.model.CardEntity;
import org.springframework.stereotype.Repository;

@Repository
public class CardDao extends AbstractDao<CardEntity, String> {

    @Override
    public CardEntity save(CardEntity cardEntity) {
        cardEntity.setIdfSeqCustCard(generateNumber12());
        return super.save(cardEntity);
    }

    @Override
    public CardEntity find(String id) {
        return (CardEntity) getSession().get(CardEntity.class, id);
    }

}
