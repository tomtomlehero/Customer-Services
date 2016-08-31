package fr.mla.customer.service.util;

import fr.mla.customer.feed.CustomerFeed;
import fr.mla.customer.feed.derivatives.CustomerDerivatives;
import fr.mla.customer.service.exception.PhoneticSearchException;
import org.apache.commons.lang3.StringUtils;

public class PhoneticSearch {

    public enum Algo {
        ALGO_SOUNDEX,
        ALGO_DOUBLE_METAPHONE
    }

    private Algo algo;

    private String srnmPhntcAlgo1;
    private String frstNmPhntcAlgo1;

    private String srnm1PhntcAlgo2;
    private String frstNm1PhntcAlgo2;
    private String srnm2PhntcAlgo2;
    private String frstNm2PhntcAlgo2;


    public PhoneticSearch(int numAlgo) {
        this.algo = Algo.values()[numAlgo - 1];
    }

    public static PhoneticSearch getInstance(SearchCustomersInputParameters searchParameters, CustomerFeed customerFeed) throws PhoneticSearchException {
        if ((searchParameters.getSoundex() == null) || ! searchParameters.getSoundex()) {
            return null;
        }

        PhoneticSearch phoneticSearch = new PhoneticSearch(searchParameters.getAlgo());

        CustomerDerivatives customerDerivatives = customerFeed.processCustomerDerivatives(
                StringCleaner.cleanName(searchParameters.getFirstName()),
                StringCleaner.cleanName(searchParameters.getLastName()),
                null);

        phoneticSearch.setSrnmPhntcAlgo1(customerDerivatives.getSrnmPhntcAlgo1());
        phoneticSearch.setFrstNmPhntcAlgo1(customerDerivatives.getFrstNmPhntcAlgo1());
        phoneticSearch.setSrnm1PhntcAlgo2(customerDerivatives.getSrnm1PhntcAlgo2());
        phoneticSearch.setFrstNm1PhntcAlgo2(customerDerivatives.getFrstNm1PhntcAlgo2());
        phoneticSearch.setSrnm2PhntcAlgo2(customerDerivatives.getSrnm2PhntcAlgo2());
        phoneticSearch.setFrstNm2PhntcAlgo2(customerDerivatives.getFrstNm2PhntcAlgo2());

        if (phoneticSearch.getAlgo() == Algo.ALGO_SOUNDEX) {
            if (StringUtils.isNotBlank(searchParameters.getLastName())) {
                if (StringUtils.isBlank(phoneticSearch.getSrnmPhntcAlgo1())) {
                    throw new PhoneticSearchException();
                }
            }
            if (StringUtils.isNotBlank(searchParameters.getFirstName())) {
                if (StringUtils.isBlank(phoneticSearch.getFrstNmPhntcAlgo1())) {
                    throw new PhoneticSearchException();
                }
            }
        } else if (phoneticSearch.getAlgo() == Algo.ALGO_DOUBLE_METAPHONE) {
            if (StringUtils.isNotBlank(searchParameters.getLastName())) {
                if (StringUtils.isBlank(phoneticSearch.getSrnm1PhntcAlgo2()) || StringUtils.isBlank(phoneticSearch.getSrnm2PhntcAlgo2())) {
                    throw new PhoneticSearchException();
                }
            }
            if (StringUtils.isNotBlank(searchParameters.getFirstName())) {
                if (StringUtils.isBlank(phoneticSearch.getFrstNm1PhntcAlgo2()) || StringUtils.isBlank(phoneticSearch.getFrstNm2PhntcAlgo2())) {
                    throw new PhoneticSearchException();
                }
            }
        }

        return phoneticSearch;
    }


    public Algo getAlgo() {
        return algo;
    }

    public String getSrnmPhntcAlgo1() {
        return srnmPhntcAlgo1;
    }

    public void setSrnmPhntcAlgo1(String srnmPhntcAlgo1) {
        this.srnmPhntcAlgo1 = srnmPhntcAlgo1;
    }

    public String getFrstNmPhntcAlgo1() {
        return frstNmPhntcAlgo1;
    }

    public void setFrstNmPhntcAlgo1(String frstNmPhntcAlgo1) {
        this.frstNmPhntcAlgo1 = frstNmPhntcAlgo1;
    }

    public String getSrnm1PhntcAlgo2() {
        return srnm1PhntcAlgo2;
    }

    public void setSrnm1PhntcAlgo2(String srnm1PhntcAlgo2) {
        this.srnm1PhntcAlgo2 = srnm1PhntcAlgo2;
    }

    public String getFrstNm1PhntcAlgo2() {
        return frstNm1PhntcAlgo2;
    }

    public void setFrstNm1PhntcAlgo2(String frstNm1PhntcAlgo2) {
        this.frstNm1PhntcAlgo2 = frstNm1PhntcAlgo2;
    }

    public String getSrnm2PhntcAlgo2() {
        return srnm2PhntcAlgo2;
    }

    public void setSrnm2PhntcAlgo2(String srnm2PhntcAlgo2) {
        this.srnm2PhntcAlgo2 = srnm2PhntcAlgo2;
    }

    public String getFrstNm2PhntcAlgo2() {
        return frstNm2PhntcAlgo2;
    }

    public void setFrstNm2PhntcAlgo2(String frstNm2PhntcAlgo2) {
        this.frstNm2PhntcAlgo2 = frstNm2PhntcAlgo2;
    }
}
