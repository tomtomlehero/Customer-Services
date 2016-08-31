package fr.mla.customer.feed;

import fr.mla.customer.feed.derivatives.CustomerDerivatives;
import fr.mla.customer.feed.impl.CustomerFeedImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Tests relative to the processCustomerDerivatives method of CustomerFeedImpl
 */
public class TestCustomerFeedImplCustomer {


    private CustomerFeed customerFeed = new CustomerFeedImpl();


    @Test(enabled = true)
    public void acceptCustomerFeed4Customer_01() {

        CustomerDerivatives cd = customerFeed.processCustomerDerivatives("Smith", "Schmidt", "FR-fr");

        assertEquals(cd.getNmlzdCodIsoLgg(), "FR-fr");
        assertNull(cd.getCodTypCvly());
        assertEquals(cd.getSrnmPhntcAlgo1(), "S530");
        assertEquals(cd.getFrstNmPhntcAlgo1(), "S530");
        assertEquals(cd.getDegCfdcPhntcAlgo1().intValue(), 99);
        assertEquals(cd.getSrnm1PhntcAlgo2(), "XMT");
        assertEquals(cd.getFrstNm1PhntcAlgo2(), "SM0");
        assertEquals(cd.getSrnm2PhntcAlgo2(), "SMT");
        assertEquals(cd.getFrstNm2PhntcAlgo2(), "XMT");
        assertEquals(cd.getDegCfdcPhntcAlgo2().intValue(), 99);
    }

    @Test(enabled = true)
    public void acceptCustomerFeed4Customer_02_diacritics() {

        CustomerDerivatives cd = customerFeed.processCustomerDerivatives("ÇéléstÏne", "Tĥïŝ ĩš â fůňķŷ Šťŕĭńġ", "   ");

        System.out.println("acceptCustomerFeed4Customer_02_diacritics : " + cd);

        assertNull(cd.getNmlzdCodIsoLgg());
        assertNull(cd.getCodTypCvly());
        assertEquals(cd.getSrnmPhntcAlgo1(), "T100");
        assertEquals(cd.getFrstNmPhntcAlgo1(), "A423");
        assertEquals(cd.getDegCfdcPhntcAlgo1().intValue(), 99);
        assertEquals(cd.getSrnm1PhntcAlgo2(), "TF");
        assertEquals(cd.getFrstNm1PhntcAlgo2(), "ALST");
        assertEquals(cd.getSrnm2PhntcAlgo2(), "TF");
        assertEquals(cd.getFrstNm2PhntcAlgo2(), "ALST");
        assertEquals(cd.getDegCfdcPhntcAlgo2().intValue(), 99);
    }

    /**
     * Test that soundex crashes for firstName and lastName and gives
     * a confidence rank of 0
     */
    @Test(enabled = true)
    public void acceptCustomerFeed4Customer_03_ligature() {

        CustomerDerivatives cd = customerFeed.processCustomerDerivatives("L\u00e6titia" /* Laetitia */, "Mon \u0153il" /* Mon oeil */, "FR-fr");
        System.out.println("acceptCustomerFeed4Customer_03_ligature : " + cd);
        assertEquals(cd.getDegCfdcPhntcAlgo1().intValue(), 0);
    }

    /**
     * Test that soundex crashes for firstName only and gives
     * a confidence rank of 50
     */
    @Test(enabled = true)
    public void acceptCustomerFeed4Customer_04_ligature() {
        CustomerDerivatives cd = customerFeed.processCustomerDerivatives("L\u00e6titia" /* Laetitia */, "Duval", "FR-fr");
        System.out.println("acceptCustomerFeed4Customer_04_ligature : " + cd);
        assertEquals(cd.getDegCfdcPhntcAlgo1().intValue(), 50);
    }



}
