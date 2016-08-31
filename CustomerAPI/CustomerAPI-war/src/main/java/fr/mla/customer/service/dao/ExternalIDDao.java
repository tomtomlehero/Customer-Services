package fr.mla.customer.service.dao;

import fr.mla.customer.service.model.ExternalIDEntity;
import fr.mla.customer.service.model.pk.ExternalIDPK;
import org.springframework.stereotype.Repository;

@Repository
public class ExternalIDDao extends AbstractDao<ExternalIDEntity, ExternalIDPK> {


    @Override
    public ExternalIDEntity find(ExternalIDPK id) {
        return (ExternalIDEntity) getSession().get(ExternalIDEntity.class, id);
    }
}
