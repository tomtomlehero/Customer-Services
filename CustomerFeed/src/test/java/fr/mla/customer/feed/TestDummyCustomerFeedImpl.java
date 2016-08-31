package fr.mla.customer.feed;

import fr.mla.customer.feed.derivatives.AddressDerivatives;
import fr.mla.customer.feed.derivatives.CustomerDerivatives;
import fr.mla.customer.feed.derivatives.EmailDerivatives;
import fr.mla.customer.feed.derivatives.PhoneNumberDerivatives;
import fr.mla.customer.feed.impl.DummyCustomerFeedImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestDummyCustomerFeedImpl {


    private CustomerFeed customerFeed = new DummyCustomerFeedImpl();


    @Test(enabled = true)
    public void acceptDummyCustomerFeed4Customer() {

        CustomerDerivatives cd = customerFeed.processCustomerDerivatives("Célestine", "Duval", "FR-fr");

        assertEquals(cd.getNmlzdCodIsoLgg(), "FR-fr");
        assertEquals(cd.getCodTypCvly(), "X");
        assertEquals(cd.getSrnmPhntcAlgo1(), "FZO9BPA0");
        assertEquals(cd.getFrstNmPhntcAlgo1(), "KET6NCX9");
        assertEquals(cd.getDegCfdcPhntcAlgo1(), Integer.valueOf(50));
        assertEquals(cd.getSrnm1PhntcAlgo2(), "DAW1QQA4");
        assertEquals(cd.getFrstNm1PhntcAlgo2(), "FOE5NGJ7");
        assertEquals(cd.getSrnm2PhntcAlgo2(), "SDF9RDS7");
        assertEquals(cd.getFrstNm2PhntcAlgo2(), "POI4NJU6");
        assertEquals(cd.getDegCfdcPhntcAlgo2(), Integer.valueOf(75));
    }

    @Test(enabled = true)
    public void acceptDummyCustomerFeed4PhoneNumber() {

        PhoneNumberDerivatives pnd = customerFeed.processPhoneNumberDerivatives("33", "685857410", "1234", "FR");

        assertEquals(pnd.getNmlzdPhonNbr(), "+33 6 87 54 96 21");
        assertEquals(pnd.getDegCfdcNmlzdPhonNbr(), Integer.valueOf(25));
    }

    @Test(enabled = true)
    public void acceptDummyCustomerFeed4Address() {

        AddressDerivatives ad = customerFeed.processAddressDerivatives(
                "11 av. de la République",
                "Bat 1 - étage 4",
                null,
                null,
                "45980",
                "BiduleVille",
                "FR");

        assertEquals(ad.getValHashAdrPost(), "1472605917");
    }

    @Test(enabled = true)
    public void acceptDummyCustomerFeed4Email() {

        EmailDerivatives ed = customerFeed.processEmailDerivatives("BLABLA@FRANCE.FR");

        assertEquals(ed.getNmlzdValAdrEmail(), "celestine.duval@somedomain.fr");
    }

}
