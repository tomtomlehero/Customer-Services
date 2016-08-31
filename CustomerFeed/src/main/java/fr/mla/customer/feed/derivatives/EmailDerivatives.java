package fr.mla.customer.feed.derivatives;

/**
 * A basic structure meant to wrap the result of the <i>normalization</i> process
 * relative to the <b>Email</b> entity
 */
public class EmailDerivatives {

    private final String nmlzdValAdrEmail;
    private final Integer degCfdcNmlzdValAdrEmail;

    public EmailDerivatives(String nmlzdValAdrEmail, Integer degCfdcNmlzdValAdrEmail) {
        this.nmlzdValAdrEmail = nmlzdValAdrEmail;
        this.degCfdcNmlzdValAdrEmail = degCfdcNmlzdValAdrEmail;
    }


    /**
     * Value of the Email Address after normalization process
     * Email address is trimed (tail and head), lower cased and accent-striped
     */
    public String getNmlzdValAdrEmail() {
        return nmlzdValAdrEmail;
    }

    /**
     * The confidence rank given to EMail Address normalization process [0 - 99]<br/>
     * 0 - Not confident at all<br/>
     * 99 - Super confident
     */
    public Integer getDegCfdcNmlzdValAdrEmail() {
        return degCfdcNmlzdValAdrEmail;
    }

    @Override
    public String toString() {
        return "EmailDerivatives{" +
                "nmlzdValAdrEmail='" + nmlzdValAdrEmail + '\'' +
                ", degCfdcNmlzdValAdrEmail=" + degCfdcNmlzdValAdrEmail +
                '}';
    }
}
