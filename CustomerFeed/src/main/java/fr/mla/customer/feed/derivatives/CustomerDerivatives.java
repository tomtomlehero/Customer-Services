package fr.mla.customer.feed.derivatives;


/**
* A basic structure meant to wrap the result of the <i>normalization</i> process
* relative to the <b>Customer</b> entity
*/
public class CustomerDerivatives {

    private final String nmlzdCodIsoLgg;
    private final String codTypCvly;
    private final String srnmPhntcAlgo1;
    private final String frstNmPhntcAlgo1;
    private final Integer degCfdcPhntcAlgo1;
    private final String srnm1PhntcAlgo2;
    private final String frstNm1PhntcAlgo2;
    private final String srnm2PhntcAlgo2;
    private final String frstNm2PhntcAlgo2;
    private final Integer degCfdcPhntcAlgo2;


    public CustomerDerivatives(String nmlzdCodIsoLgg, String codTypCvly, String srnmPhntcAlgo1, String frstNmPhntcAlgo1, Integer degCfdcPhntcAlgo1, String srnm1PhntcAlgo2, String frstNm1PhntcAlgo2, String srnm2PhntcAlgo2, String frstNm2PhntcAlgo2, Integer degCfdcPhntcAlgo2) {
        this.nmlzdCodIsoLgg = nmlzdCodIsoLgg;
        this.codTypCvly = codTypCvly;
        this.srnmPhntcAlgo1 = srnmPhntcAlgo1;
        this.frstNmPhntcAlgo1 = frstNmPhntcAlgo1;
        this.degCfdcPhntcAlgo1 = degCfdcPhntcAlgo1;
        this.srnm1PhntcAlgo2 = srnm1PhntcAlgo2;
        this.frstNm1PhntcAlgo2 = frstNm1PhntcAlgo2;
        this.srnm2PhntcAlgo2 = srnm2PhntcAlgo2;
        this.frstNm2PhntcAlgo2 = frstNm2PhntcAlgo2;
        this.degCfdcPhntcAlgo2 = degCfdcPhntcAlgo2;
    }

    /**
     * The normalized ISO language code (ex: "FR-fr")
     */
    public String getNmlzdCodIsoLgg() {
        return nmlzdCodIsoLgg;
    }

    /**
     * The normalized civility type code
     */
    public String getCodTypCvly() {
        return codTypCvly;
    }

    /**
     * the encoded <b>Soundex</b> (algo 1) value for last name
     */
    public String getSrnmPhntcAlgo1() {
        return srnmPhntcAlgo1;
    }

    /**
     * the encoded <b>Soundex</b> (algo 1) value for first name
     */
    public String getFrstNmPhntcAlgo1() {
        return frstNmPhntcAlgo1;
    }

    /**
     * The confidence rank given after the <b>Soundex</b> (algo 1) algorithm processing [0 - 99]<br/>
     * 0 - Not confident at all<br/>
     * 99 - Super confident
     */
    public Integer getDegCfdcPhntcAlgo1() {
        return degCfdcPhntcAlgo1;
    }

    /**
     * The encoded <b>Double Metaphone</b> (algo 2) value for last name
     */
    public String getSrnm1PhntcAlgo2() {
        return srnm1PhntcAlgo2;
    }

    /**
     * The encoded <b>Double Metaphone</b> (algo 2) value for first name
     */
    public String getFrstNm1PhntcAlgo2() {
        return frstNm1PhntcAlgo2;
    }

    /**
     * The encoded <b>Double Metaphone</b> (algo 2) alternate value (value 2) for last name
     */
    public String getSrnm2PhntcAlgo2() {
        return srnm2PhntcAlgo2;
    }

    /**
     * The encoded <b>Double Metaphone</b> (algo 2) alternate value (value 2) for first name
     */
    public String getFrstNm2PhntcAlgo2() {
        return frstNm2PhntcAlgo2;
    }

    /**
     * the confidence rank given after the <b>Double Metaphone</b> (algo 2) algorithm processing [0 - 99]<br/>
     * 0 - Not confident at all<br/>
     * 99 - Super confident
     */
    public Integer getDegCfdcPhntcAlgo2() {
        return degCfdcPhntcAlgo2;
    }


    @Override
    public String toString() {
        return "CustomerDerivatives{" +
                "nmlzdCodIsoLgg='" + nmlzdCodIsoLgg + '\'' +
                ", codTypCvly='" + codTypCvly + '\'' +
                ", srnmPhntcAlgo1='" + srnmPhntcAlgo1 + '\'' +
                ", frstNmPhntcAlgo1='" + frstNmPhntcAlgo1 + '\'' +
                ", degCfdcPhntcAlgo1=" + degCfdcPhntcAlgo1 +
                ", srnm1PhntcAlgo2='" + srnm1PhntcAlgo2 + '\'' +
                ", frstNm1PhntcAlgo2='" + frstNm1PhntcAlgo2 + '\'' +
                ", srnm2PhntcAlgo2='" + srnm2PhntcAlgo2 + '\'' +
                ", frstNm2PhntcAlgo2='" + frstNm2PhntcAlgo2 + '\'' +
                ", degCfdcPhntcAlgo2=" + degCfdcPhntcAlgo2 +
                '}';
    }
}
