package fr.mla.customer.feed.derivatives;

/**
 * A basic structure meant to wrap the result of the <i>normalization</i> process
 * relative to the <b>Card</b> entity
 */
public class CardDerivatives {

    private final String nmlzdIdfCustCard;
    private final Integer degCfdcCustCard;

    public CardDerivatives(String nmlzdIdfCustCard, Integer degCfdcCustCard) {
        this.nmlzdIdfCustCard = nmlzdIdfCustCard;
        this.degCfdcCustCard = degCfdcCustCard;
    }


    /**
     * Value of the Card Number after normalization process
     * Card Number is trimed (tail and head)
     */
    public String getNmlzdIdfCustCard() {
        return nmlzdIdfCustCard;
    }

    /**
     * The confidence rank given to Customer Card number [0 - 99]<br/>
     * 0 - Not confident at all<br/>
     * 99 - Super confident
     */
    public Integer getDegCfdcCustCard() {
        return degCfdcCustCard;
    }

    @Override
    public String toString() {
        return "CardDerivatives{" +
                "nmlzdIdfCustCard='" + nmlzdIdfCustCard + '\'' +
                ", degCfdcCustCard=" + degCfdcCustCard +
                '}';
    }
}
