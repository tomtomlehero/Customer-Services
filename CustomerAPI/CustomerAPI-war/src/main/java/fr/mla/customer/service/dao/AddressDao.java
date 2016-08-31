package fr.mla.customer.service.dao;

import fr.mla.customer.service.model.AddressEntity;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDao extends AbstractDao<AddressEntity, String> {

    @Override
    public AddressEntity save(AddressEntity addressEntity) {
        addressEntity.setIdfSeqAdrPost(generateNumber12());
        return super.save(addressEntity);
    }

    @Override
    public AddressEntity find(String id) {
        return (AddressEntity) getSession().get(AddressEntity.class, id);
    }

}
