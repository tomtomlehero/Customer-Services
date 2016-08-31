package fr.mla.customer.feed;

import fr.mla.customer.feed.derivatives.AddressDerivatives;
import fr.mla.customer.feed.impl.CustomerFeedImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/**
 * Tests relative to the processAddressDerivatives method of CustomerFeedImpl
 */
public class TestCustomerFeedImplAddress {

    private CustomerFeed customerFeed = new CustomerFeedImpl();

    @Test(enabled = true)
    public void acceptCustomerFeed4Address() {

        AddressDerivatives ad = customerFeed.processAddressDerivatives(
                "11 av. de la République",
                "Bat 1 - étage 4",
                null,
                null,
                "45980",
                "BiduleVille",
                "FR");

        assertNotNull(ad.getValHashAdrPost());
    }


}
