package fr.mla.customer.feed;

import fr.mla.customer.feed.derivatives.PhoneNumberDerivatives;
import fr.mla.customer.feed.impl.CustomerFeedImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Tests relative to the processPhoneNumberDerivatives method of CustomerFeedImpl
 */
public class TestCustomerFeedPhoneNumber {


    private CustomerFeed customerFeed = new CustomerFeedImpl();

    @Test(enabled = true)
    public void acceptCustomerFeed4PhoneNumber() {

        PhoneNumberDerivatives pnd = customerFeed.processPhoneNumberDerivatives("0201", "511491", "3", "DE");

        assertEquals(pnd.getNmlzdPhonNbr(), "+49 201 5114913");
        assertEquals(pnd.getDegCfdcNmlzdPhonNbr(), Integer.valueOf(60));
    }

}
