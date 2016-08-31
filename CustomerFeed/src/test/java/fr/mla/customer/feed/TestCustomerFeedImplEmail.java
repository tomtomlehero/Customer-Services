package fr.mla.customer.feed;

import fr.mla.customer.feed.derivatives.EmailDerivatives;
import fr.mla.customer.feed.impl.CustomerFeedImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Tests relative to the processEmailDerivatives method of CustomerFeedImpl
 */
public class TestCustomerFeedImplEmail {

    private CustomerFeed customerFeed = new CustomerFeedImpl();

    private static final String funckyString = "\u00E9\u00E7\u00F6\u00F9\u00FD\u00F1"; /* éçöùýñ */
    private static final String stripedFunckyString = "ecouyn";

    private static final String noSpaces_noAccents_emailValid_000 = "correct@domain.com";
    private static final String noSpaces_noAccents_emailValid_NORMALIZED_000 = "correct@domain.com";
    private static final int noSpaces_noAccents_emailValid_RANK_000 = 99;

    private static final String noSpaces_noAccents_emailInvalid_001 = "correct@domain";
    private static final String noSpaces_noAccents_emailInvalid_NORMALIZED_001 = null;
    private static final int noSpaces_noAccents_emailInvalid_RANK_001 = 0;

    private static final String noSpaces_accents_emailValid_010 = funckyString + "@domain.com";
    private static final String noSpaces_accents_emailValid_NORMALIZED_010 = stripedFunckyString + "@domain.com";
    private static final int noSpaces_accents_emailValid_RANK_010 = 30;

    private static final String noSpaces_accents_emailInvalid_011 = funckyString + "@domain";
    private static final String noSpaces_accents_emailInvalid_NORMALIZED_011 = null;
    private static final int noSpaces_accents_emailInvalid_RANK_011 = 0;

    private static final String spaces_noAccents_emailValid_100 = "    correct@domain.com    ";
    private static final String spaces_noAccents_emailValid_NORMALIZED_100 = "correct@domain.com";
    private static final int spaces_noAccents_emailValid_RANK_100 = 80;

    private static final String spaces_noAccents_emailInvalid_101 = "    correct@domain    ";
    private static final String spaces_noAccents_emailInvalid_NORMALIZED_101 = null;
    private static final int spaces_noAccents_emailInvalid_RANK_101 = 0;

    private static final String spaces_accents_emailValid_110 = "    " + funckyString + "@domain.com   ";
    private static final String spaces_accents_emailValid_NORMALIZED_110 = stripedFunckyString + "@domain.com";
    private static final int spaces_accents_emailValid_RANK_000 = 20;

    private static final String spaces_accents_emailInvalid_111 =  "    " + funckyString + "@domain   ";
    private static final String spaces_accents_emailInvalid_NORMALIZED_111 = null;
    private static final int spaces_accents_emailInvalid_RANK_111 = 0;


    @Test(enabled = true)
    public void acceptCustomerFeed4Email_000() {
        EmailDerivatives ed = customerFeed.processEmailDerivatives(noSpaces_noAccents_emailValid_000);
        assertEquals(ed.getNmlzdValAdrEmail(), noSpaces_noAccents_emailValid_NORMALIZED_000);
        assertEquals(ed.getDegCfdcNmlzdValAdrEmail().intValue(), noSpaces_noAccents_emailValid_RANK_000);
    }

    @Test(enabled = true)
    public void acceptCustomerFeed4Email_001() {
        EmailDerivatives ed = customerFeed.processEmailDerivatives(noSpaces_noAccents_emailInvalid_001);
        assertEquals(ed.getNmlzdValAdrEmail(), noSpaces_noAccents_emailInvalid_NORMALIZED_001);
        assertEquals(ed.getDegCfdcNmlzdValAdrEmail().intValue(), noSpaces_noAccents_emailInvalid_RANK_001);
    }

    @Test(enabled = true)
    public void acceptCustomerFeed4Email_010() {
        EmailDerivatives ed = customerFeed.processEmailDerivatives(noSpaces_accents_emailValid_010);
        assertEquals(ed.getNmlzdValAdrEmail(), noSpaces_accents_emailValid_NORMALIZED_010);
        assertEquals(ed.getDegCfdcNmlzdValAdrEmail().intValue(), noSpaces_accents_emailValid_RANK_010);
    }

    @Test(enabled = true)
    public void acceptCustomerFeed4Email_011() {
        EmailDerivatives ed = customerFeed.processEmailDerivatives(noSpaces_accents_emailInvalid_011);
        assertEquals(ed.getNmlzdValAdrEmail(), noSpaces_accents_emailInvalid_NORMALIZED_011);
        assertEquals(ed.getDegCfdcNmlzdValAdrEmail().intValue(), noSpaces_accents_emailInvalid_RANK_011);
    }

    @Test(enabled = true)
    public void acceptCustomerFeed4Email_100() {
        EmailDerivatives ed = customerFeed.processEmailDerivatives(spaces_noAccents_emailValid_100);
        assertEquals(ed.getNmlzdValAdrEmail(), spaces_noAccents_emailValid_NORMALIZED_100);
        assertEquals(ed.getDegCfdcNmlzdValAdrEmail().intValue(), spaces_noAccents_emailValid_RANK_100);
    }

    @Test(enabled = true)
    public void acceptCustomerFeed4Email_101() {
        EmailDerivatives ed = customerFeed.processEmailDerivatives(spaces_noAccents_emailInvalid_101);
        assertEquals(ed.getNmlzdValAdrEmail(), spaces_noAccents_emailInvalid_NORMALIZED_101);
        assertEquals(ed.getDegCfdcNmlzdValAdrEmail().intValue(), spaces_noAccents_emailInvalid_RANK_101);
    }

    @Test(enabled = true)
    public void acceptCustomerFeed4Email_110() {
        EmailDerivatives ed = customerFeed.processEmailDerivatives(spaces_accents_emailValid_110);
        assertEquals(ed.getNmlzdValAdrEmail(), spaces_accents_emailValid_NORMALIZED_110);
        assertEquals(ed.getDegCfdcNmlzdValAdrEmail().intValue(), spaces_accents_emailValid_RANK_000);
    }

    @Test(enabled = true)
    public void acceptCustomerFeed4Email_111() {
        EmailDerivatives ed = customerFeed.processEmailDerivatives(spaces_accents_emailInvalid_111);
        assertEquals(ed.getNmlzdValAdrEmail(), spaces_accents_emailInvalid_NORMALIZED_111);
        assertEquals(ed.getDegCfdcNmlzdValAdrEmail().intValue(), spaces_accents_emailInvalid_RANK_111);
    }

}
