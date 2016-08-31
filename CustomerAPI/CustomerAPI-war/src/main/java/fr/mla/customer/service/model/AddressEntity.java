package fr.mla.customer.service.model;

import javax.persistence.*;


/**

 CREATE TABLE CRMDB.ADR_POST (
     IDF_SEQ_ADR_POST   NUMBER(12)                 NOT NULL,
     UUID_CUST          VARCHAR2(36 BYTE)          NOT NULL,
     ADR_POST_LN1       VARCHAR2(35 BYTE)          NOT NULL,
     ADR_POST_LN2       VARCHAR2(35 BYTE),
     ADR_POST_LN3       VARCHAR2(35 BYTE),
     ADR_POST_LN4       VARCHAR2(35 BYTE),
     COD_POST           VARCHAR2(10 BYTE),
     ST_CTY_PROV_DEPT   VARCHAR2(25 BYTE),
     NM_CITY            VARCHAR2(25 BYTE)          NOT NULL,
     COD_CRY            VARCHAR2(2 BYTE)           NOT NULL,
     VAL_HASH_ADR_POST  VARCHAR2(16 BYTE),
     IND_AUTH_OPTIN     VARCHAR2(1 BYTE),
     STU_MKT            VARCHAR2(1 BYTE),
     IND_MAIN           VARCHAR2(1 BYTE)           DEFAULT 'Y'                   NOT NULL,
     TYP_APP            VARCHAR2(1 BYTE),
     TYP_CNT            VARCHAR2(1 BYTE)
 )

 */


@Entity
@Table(name="ADR_POST")
public class AddressEntity {


    //     IDF_SEQ_ADR_POST   NUMBER(12)                 NOT NULL,
    @Id
    @Column(name="IDF_SEQ_ADR_POST")
    private Long idfSeqAdrPost;

    //     UUID_CUST          VARCHAR2(36 BYTE)          NOT NULL,
    @ManyToOne
    @JoinColumn(name = "UUID_CUST")
    private CustomerEntity customer;

    //     ADR_POST_LN1       VARCHAR2(35 BYTE)          NOT NULL,
    @Column(name="ADR_POST_LN1")
    private String adrPostLn1;

    //     ADR_POST_LN2       VARCHAR2(35 BYTE),
    @Column(name="ADR_POST_LN2")
    private String adrPostLn2;

    //     ADR_POST_LN3       VARCHAR2(35 BYTE),
    @Column(name="ADR_POST_LN3")
    private String adrPostLn3;

    //     ADR_POST_LN4       VARCHAR2(35 BYTE),
    @Column(name="ADR_POST_LN4")
    private String adrPostLn4;

    //     COD_POST           VARCHAR2(10 BYTE),
    @Column(name="COD_POST")
    private String codPost;

    //     ST_CTY_PROV_DEPT   VARCHAR2(25 BYTE),
    @Column(name="ST_CTY_PROV_DEPT")
    private String stCtyProvDept;

    //     NM_CITY            VARCHAR2(25 BYTE)          NOT NULL,
    @Column(name="NM_CITY")
    private String nmCity;

    //     COD_CRY            VARCHAR2(2 BYTE)           NOT NULL,
    @Column(name="COD_CRY")
    private String codCry;

    //     VAL_HASH_ADR_POST  VARCHAR2(16 BYTE),
    @Column(name="VAL_HASH_ADR_POST")
    private String valHashAdrPost;

    //     IND_AUTH_OPTIN     VARCHAR2(1 BYTE),
    @Column(name="IND_AUTH_OPTIN")
    private String indAuthOptin;

    //     STU_MKT            VARCHAR2(1 BYTE),
    @Column(name="STU_MKT")
    private String stuMkt;

    //     IND_MAIN           VARCHAR2(1 BYTE)           DEFAULT 'Y'                   NOT NULL,
    @Column(name="IND_MAIN")
    private String indMain;

    //     TYP_APP            VARCHAR2(1 BYTE),
    @Column(name="TYP_APP")
    private String typApp;

    //     TYP_CNT            VARCHAR2(1 BYTE)
    @Column(name="TYP_CNT")
    private String typCnt;


    public Long getIdfSeqAdrPost() {
        return idfSeqAdrPost;
    }

    public void setIdfSeqAdrPost(Long idfSeqAdrPost) {
        this.idfSeqAdrPost = idfSeqAdrPost;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public String getAdrPostLn1() {
        return adrPostLn1;
    }

    public void setAdrPostLn1(String adrPostLn1) {
        this.adrPostLn1 = adrPostLn1;
    }

    public String getAdrPostLn2() {
        return adrPostLn2;
    }

    public void setAdrPostLn2(String adrPostLn2) {
        this.adrPostLn2 = adrPostLn2;
    }

    public String getAdrPostLn3() {
        return adrPostLn3;
    }

    public void setAdrPostLn3(String adrPostLn3) {
        this.adrPostLn3 = adrPostLn3;
    }

    public String getAdrPostLn4() {
        return adrPostLn4;
    }

    public void setAdrPostLn4(String adrPostLn4) {
        this.adrPostLn4 = adrPostLn4;
    }

    public String getCodPost() {
        return codPost;
    }

    public void setCodPost(String codPost) {
        this.codPost = codPost;
    }

    public String getStCtyProvDept() {
        return stCtyProvDept;
    }

    public void setStCtyProvDept(String stCtyProvDept) {
        this.stCtyProvDept = stCtyProvDept;
    }

    public String getNmCity() {
        return nmCity;
    }

    public void setNmCity(String nmCity) {
        this.nmCity = nmCity;
    }

    public String getCodCry() {
        return codCry;
    }

    public void setCodCry(String codCry) {
        this.codCry = codCry;
    }

    public String getValHashAdrPost() {
        return valHashAdrPost;
    }

    public void setValHashAdrPost(String valHashAdrPost) {
        this.valHashAdrPost = valHashAdrPost;
    }

    public String getIndAuthOptin() {
        return indAuthOptin;
    }

    public void setIndAuthOptin(String indAuthOptin) {
        this.indAuthOptin = indAuthOptin;
    }

    public String getStuMkt() {
        return stuMkt;
    }

    public void setStuMkt(String stuMkt) {
        this.stuMkt = stuMkt;
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
}
