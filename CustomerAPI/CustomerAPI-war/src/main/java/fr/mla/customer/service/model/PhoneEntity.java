package fr.mla.customer.service.model;

import javax.persistence.*;

/**

 CREATE TABLE CRMDB.PHON_CNT (
    IDF_SEQ_PHON_CNT         NUMBER(12)           NOT NULL,
    UUID_CUST                VARCHAR2(36 BYTE)    NOT NULL,
    COD_AREA                 VARCHAR2(10 BYTE),
    NBR_PHON                 NUMBER(15)           NOT NULL,
    EXT_PHON                 VARCHAR2(6 BYTE),
    NMLZD_PHON_NBR           VARCHAR2(25 BYTE),
    DEG_CFDC_NMLZD_PHON_NBR  NUMBER(2),
    IND_AUTH_OPTIN           VARCHAR2(1 BYTE),
    IND_MAIN                 VARCHAR2(1 BYTE)     DEFAULT 'Y'                   NOT NULL,
    TYP_APP                  VARCHAR2(1 BYTE),
    TYP_CNT                  VARCHAR2(1 BYTE),
    TYP_PHON_CNT             VARCHAR2(20 BYTE),
    IND_MAIN_PHON_CNT        VARCHAR2(1 BYTE)     DEFAULT 'Y'                   NOT NULL
 )

 */


@Entity
@Table(name="PHON_CNT")
public class PhoneEntity {

    //    IDF_SEQ_PHON_CNT         NUMBER(12)           NOT NULL,
    @Id
    @Column(name="IDF_SEQ_PHON_CNT")
    private Long idfSeqPhonCnt;

    //    UUID_CUST                VARCHAR2(36 BYTE)    NOT NULL,
    @ManyToOne
    @JoinColumn(name = "UUID_CUST")
    private CustomerEntity customer;

    //    COD_AREA                 VARCHAR2(10 BYTE),
    @Column(name="COD_AREA")
    private String codArea;

    //    NBR_PHON                 NUMBER(15)           NOT NULL,
    @Column(name="NBR_PHON")
    private Long nbrPhon;

    //    EXT_PHON                 VARCHAR2(6 BYTE),
    @Column(name="EXT_PHON")
    private String extPhon;

    //    NMLZD_PHON_NBR           VARCHAR2(25 BYTE),
    @Column(name="NMLZD_PHON_NBR")
    private String nmlzdPhonNbr;

    //    DEG_CFDC_NMLZD_PHON_NBR  NUMBER(2),
    @Column(name="DEG_CFDC_NMLZD_PHON_NBR")
    private Integer degCfdcNmlzdPhonNbr;

    //    IND_AUTH_OPTIN           VARCHAR2(1 BYTE),
    @Column(name="IND_AUTH_OPTIN")
    private String indAuthOptin;

    //    IND_MAIN                 VARCHAR2(1 BYTE)     DEFAULT 'Y'                   NOT NULL,
    @Column(name="IND_MAIN")
    private String indMain;

    //    TYP_APP                  VARCHAR2(1 BYTE),
    @Column(name="TYP_APP")
    private String typApp;

    //    TYP_CNT                  VARCHAR2(1 BYTE),
    @Column(name="TYP_CNT")
    private String typCnt;

    //    TYP_PHON_CNT             VARCHAR2(20 BYTE),
    @Column(name="TYP_PHON_CNT")
    private String typPhonCnt;

    //    IND_MAIN_PHON_CNT        VARCHAR2(1 BYTE)     DEFAULT 'Y'                   NOT NULL
    @Column(name="IND_MAIN_PHON_CNT")
    private String indMainPhonCnt;


    public Long getIdfSeqPhonCnt() {
        return idfSeqPhonCnt;
    }

    public void setIdfSeqPhonCnt(Long idfSeqPhonCnt) {
        this.idfSeqPhonCnt = idfSeqPhonCnt;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public String getCodArea() {
        return codArea;
    }

    public void setCodArea(String codArea) {
        this.codArea = codArea;
    }

    public Long getNbrPhon() {
        return nbrPhon;
    }

    public void setNbrPhon(Long nbrPhon) {
        this.nbrPhon = nbrPhon;
    }

    public String getExtPhon() {
        return extPhon;
    }

    public void setExtPhon(String extPhon) {
        this.extPhon = extPhon;
    }

    public String getNmlzdPhonNbr() {
        return nmlzdPhonNbr;
    }

    public void setNmlzdPhonNbr(String nmlzdPhonNbr) {
        this.nmlzdPhonNbr = nmlzdPhonNbr;
    }

    public Integer getDegCfdcNmlzdPhonNbr() {
        return degCfdcNmlzdPhonNbr;
    }

    public void setDegCfdcNmlzdPhonNbr(Integer degCfdcNmlzdPhonNbr) {
        this.degCfdcNmlzdPhonNbr = degCfdcNmlzdPhonNbr;
    }

    public String getIndAuthOptin() {
        return indAuthOptin;
    }

    public void setIndAuthOptin(String indAuthOptin) {
        this.indAuthOptin = indAuthOptin;
    }

    public String getIndMain() {
        return indMain;
    }

    public void setIndMain(String indMain) {
        this.indMain = indMain;
    }

    public String getTypApp() {
        return typApp;
    }

    public void setTypApp(String typApp) {
        this.typApp = typApp;
    }

    public String getTypCnt() {
        return typCnt;
    }

    public void setTypCnt(String typCnt) {
        this.typCnt = typCnt;
    }

    public String getTypPhonCnt() {
        return typPhonCnt;
    }

    public void setTypPhonCnt(String typPhonCnt) {
        this.typPhonCnt = typPhonCnt;
    }

    public String getIndMainPhonCnt() {
        return indMainPhonCnt;
    }

    public void setIndMainPhonCnt(String indMainPhonCnt) {
        this.indMainPhonCnt = indMainPhonCnt;
    }
}
