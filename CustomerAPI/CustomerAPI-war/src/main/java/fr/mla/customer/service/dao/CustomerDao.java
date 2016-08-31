package fr.mla.customer.service.dao;

import fr.mla.customer.feed.CustomerFeed;
import fr.mla.customer.feed.uuid.UUIDGenerator;
import fr.mla.customer.service.exception.CustomerServiceException;
import fr.mla.customer.service.model.CustomerEntity;
import fr.mla.customer.service.util.PhoneticSearch;
import fr.mla.customer.service.util.SearchCustomersInputParameters;
import fr.mla.customer.service.util.StringCleaner;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class CustomerDao extends AbstractDao<CustomerEntity, String> {


    @Autowired
    private CustomerFeed customerFeed;


    @Override
    public CustomerEntity save(CustomerEntity customerEntity) {
        customerEntity.setUuidCust(UUIDGenerator.generateAsString());
        return super.save(customerEntity);
    }

    @Override
    public CustomerEntity find(String id) {
        return (CustomerEntity) getSession().get(CustomerEntity.class, id);
    }

    public List<CustomerEntity> search(SearchCustomersInputParameters searchParameters) throws CustomerServiceException {

        String fromClause = "from CustomerEntity as cust ";

        String whereClause = "";

        boolean phoneticSearchOLD = false;

        PhoneticSearch phoneticSearch = PhoneticSearch.getInstance(searchParameters, customerFeed);

        HashMap<String, String> stringParameters=new HashMap<String, String>();

        /**
         * firstName
         */
        if (StringUtils.isNotBlank(searchParameters.getFirstName())) {

            if (phoneticSearch != null) {

                if (phoneticSearch.getAlgo() == PhoneticSearch.Algo.ALGO_SOUNDEX) {
                    whereClause += "and cust.frstNmPhntcAlgo1 = :frstNmPhntcAlgo1 ";
                    stringParameters.put("frstNmPhntcAlgo1", phoneticSearch.getFrstNmPhntcAlgo1());
                } else if (phoneticSearch.getAlgo() == PhoneticSearch.Algo.ALGO_DOUBLE_METAPHONE) {
                    whereClause += "and cust.frstNm1PhntcAlgo2 = :frstNm1PhntcAlgo2 ";
                    whereClause += "and cust.frstNm2PhntcAlgo2 = :frstNm2PhntcAlgo2 ";
                    stringParameters.put("frstNm1PhntcAlgo2", phoneticSearch.getFrstNm1PhntcAlgo2());
                    stringParameters.put("frstNm2PhntcAlgo2", phoneticSearch.getFrstNm2PhntcAlgo2());
                }

            } else {
                whereClause += "and upper(convert(cust.frstNm, 'US7ASCII')) = :firstName ";
                stringParameters.put("firstName", StringCleaner.cleanName(searchParameters.getFirstName()));
            }

        }

        /**
         * lastName
         */
        if (StringUtils.isNotBlank(searchParameters.getLastName())) {

            if (phoneticSearch != null) {

                if (phoneticSearch.getAlgo() == PhoneticSearch.Algo.ALGO_SOUNDEX) {
                    whereClause += "and cust.srnmPhntcAlgo1 = :srnmPhntcAlgo1 ";
                    stringParameters.put("srnmPhntcAlgo1", phoneticSearch.getSrnmPhntcAlgo1());
                } else if (phoneticSearch.getAlgo() == PhoneticSearch.Algo.ALGO_DOUBLE_METAPHONE) {
                    whereClause += "and cust.srnm1PhntcAlgo2 = :srnm1PhntcAlgo2 ";
                    whereClause += "and cust.srnm2PhntcAlgo2 = :srnm2PhntcAlgo2 ";
                    stringParameters.put("srnm1PhntcAlgo2", phoneticSearch.getSrnm1PhntcAlgo2());
                    stringParameters.put("srnm2PhntcAlgo2", phoneticSearch.getSrnm2PhntcAlgo2());
                }

            } else {
                whereClause += "and upper(convert(cust.srnm, 'US7ASCII')) = :lastName ";
                stringParameters.put("lastName", StringCleaner.cleanName(searchParameters.getLastName()));
            }
        }

        /**
         * phone
         */
        if (StringUtils.isNotBlank(searchParameters.getPhone())) {
            whereClause += "and exists (from PhoneEntity phone where phone.customer = cust and regexp_replace(phone.nmlzdPhonNbr, '\\D', '') like '%' || :phone || '%') ";

            stringParameters.put("phone", searchParameters.getPhone());
        }

        /**
         * email
         */
        if (StringUtils.isNotBlank(searchParameters.getEmail())) {
            whereClause += "and exists (from EmailEntity email where email.customer = cust and email.nmlzdValAdrEml like '%' || :email || '%') ";

            stringParameters.put("email", searchParameters.getEmail());
        }

        /**
         * extId
         */
        if (StringUtils.isNotBlank(searchParameters.getExtId())) {
            whereClause += "and exists (from ExternalIDEntity externalID " +
                    "where externalID.customer = cust and externalID.ownAppli = :ownAppli and externalID.codAppi = :codAppi " +
                    "and externalID.typClssObj = :typClssObj and externalID.idfObj = :idfObj) ";

            String uri[] = searchParameters.getExtId().split(":");
            stringParameters.put("ownAppli", uri[0]);
            stringParameters.put("codAppi", uri[1]);
            stringParameters.put("typClssObj", uri[2]);
            stringParameters.put("idfObj", uri[3]);
        }


        // Remove the first 'and' and prefix with 'where'
        if (whereClause.length() > 0) {
            whereClause = "where " + whereClause.substring(4);
        }

        String orderByClause = "order by cust.srnm, cust.frstNm";

        String hql = fromClause + whereClause + orderByClause;

        Query query = getSession().createQuery(hql);

        for (String parameterName : stringParameters.keySet()) {
            String parameterValue = stringParameters.get(parameterName);
            query.setString(parameterName, parameterValue);
        }

        return query.list();
    }


}
