package fr.mla.customer.service.dao;

import fr.mla.customer.service.model.EmailEntity;
import org.springframework.stereotype.Repository;

@Repository
public class EmailDao extends AbstractDao<EmailEntity, String> {

    @Override
    public EmailEntity save(EmailEntity emailEntity) {
        emailEntity.setIdfSeqAdrEml(generateNumber12());
        return super.save(emailEntity);
    }

    @Override
    public EmailEntity find(String id) {
        return null;
    }

}
