package fr.mla.customer.feed.derivatives;

/**
 * A basic structure meant to wrap the result of the <i>normalization</i> process
 * relative to the <b>Address</b> entity
 */
public class AddressDerivatives {

    private final String valHashAdrPost;

    public AddressDerivatives(String valHashAdrPost) {
        this.valHashAdrPost = valHashAdrPost;
    }

    /**
     * The Hash value computed following the address lines, zip code, city and country
     */
    public String getValHashAdrPost() {
        return valHashAdrPost;
    }


    @Override
    public String toString() {
        return "AddressDerivatives{" +
                "valHashAdrPost='" + valHashAdrPost + '\'' +
                '}';
    }
}
