package fr.mla.customer.feed.derivatives;

/**
 * A basic structure meant to wrap the result of the <i>normalization</i> process
 * relative to the <b>PhoneNumber</b> entity
 */
public class PhoneNumberDerivatives {

    private final String nmlzdPhonNbr;
    private final Integer degCfdcNmlzdPhonNbr;

    public PhoneNumberDerivatives(String nmlzdPhonNbr, Integer degCfdcNmlzdPhonNbr) {
        this.nmlzdPhonNbr = nmlzdPhonNbr;
        this.degCfdcNmlzdPhonNbr = degCfdcNmlzdPhonNbr;
    }

    /**
     * Value of the Phone Number after normalization process
     * ex : '+33 6 12 34 56 78'
     */
    public String getNmlzdPhonNbr() {
        return nmlzdPhonNbr;
    }

    /**
     * The confidence rank given after Phone Number normalization process [0 - 99]<br/>
     * 0 - Not confident at all<br/>
     * 99 - Super confident
     */
    public Integer getDegCfdcNmlzdPhonNbr() {
        return degCfdcNmlzdPhonNbr;
    }

    @Override
    public String toString() {
        return "PhoneNumberDerivatives{" +
                "nmlzdPhonNbr='" + nmlzdPhonNbr + '\'' +
                ", degCfdcNmlzdPhonNbr=" + degCfdcNmlzdPhonNbr +
                '}';
    }
}
