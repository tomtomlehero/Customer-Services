package fr.mla.customer.service.dao;

import fr.mla.customer.service.model.PhoneEntity;
import org.springframework.stereotype.Repository;

@Repository
public class PhoneDao extends AbstractDao<PhoneEntity, String> {

    @Override
    public PhoneEntity save(PhoneEntity phoneEntity) {
        phoneEntity.setIdfSeqPhonCnt(generateNumber12());
        return super.save(phoneEntity);
    }

    @Override
    public PhoneEntity find(String id) {
        return (PhoneEntity) getSession().get(PhoneEntity.class, id);
    }


}
