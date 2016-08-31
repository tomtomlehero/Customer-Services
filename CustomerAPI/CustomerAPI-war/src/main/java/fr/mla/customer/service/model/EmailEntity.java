package fr.mla.customer.service.model;

import javax.persistence.*;

/**

 CREATE TABLE CRMDB.ADR_EML (
     IDF_SEQ_ADR_EML    NUMBER(12)                 NOT NULL,
     UUID_CUST          VARCHAR2(36 BYTE)          NOT NULL,
     VAL_ADR_EML        VARCHAR2(260 BYTE)         NOT NULL,
     NMLZD_VAL_ADR_EML  VARCHAR2(260 BYTE),
     IND_AUTH_OPTIN     VARCHAR2(1 BYTE),
     DEG_CFDC_ADR_EML   NUMBER(2),
     IND_MAIN           VARCHAR2(1 BYTE)           DEFAULT 'Y'                   NOT NULL,
     TYP_APP            VARCHAR2(1 BYTE),
     TYP_CNT            VARCHAR2(1 BYTE)
 )

 */

@Entity
@Table(name="ADR_EML")
public class EmailEntity {


    //     IDF_SEQ_ADR_EML    NUMBER(12)                 NOT NULL,
    @Id
    @Column(name="IDF_SEQ_ADR_EML")
    private Long idfSeqAdrEml;

    //     UUID_CUST          VARCHAR2(36 BYTE)          NOT NULL,
    @ManyToOne
    @JoinColumn(name = "UUID_CUST")
    private CustomerEntity customer;

    //     VAL_ADR_EML        VARCHAR2(260 BYTE)         NOT NULL,
    @Column(name="VAL_ADR_EML")
    private String valAdrEml;

    //     NMLZD_VAL_ADR_EML  VARCHAR2(260 BYTE),
    @Column(name="NMLZD_VAL_ADR_EML")
    private String nmlzdValAdrEml;

    //     IND_AUTH_OPTIN     VARCHAR2(1 BYTE),
    @Column(name="IND_AUTH_OPTIN")
    private String indAuthOptin;

    //     DEG_CFDC_ADR_EML   NUMBER(2),
    @Column(name="DEG_CFDC_ADR_EML")
    private Integer degCfdcAdrEml;

    //     IND_MAIN           VARCHAR2(1 BYTE)           DEFAULT 'Y'                   NOT NULL,
    @Column(name="IND_MAIN")
    private String indMain;

    //     TYP_APP            VARCHAR2(1 BYTE),
    @Column(name="TYP_APP")
    private String typApp;

    //     TYP_CNT            VARCHAR2(1 BYTE)
    @Column(name="TYP_CNT")
    private String typCnt;



    public Long getIdfSeqAdrEml() {
        return idfSeqAdrEml;
    }

    public void setIdfSeqAdrEml(Long idfSeqAdrEml) {
        this.idfSeqAdrEml = idfSeqAdrEml;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public String getValAdrEml() {
        return valAdrEml;
    }

    public void setValAdrEml(String valAdrEml) {
        this.valAdrEml = valAdrEml;
    }

    public String getNmlzdValAdrEml() {
        return nmlzdValAdrEml;
    }

    public void setNmlzdValAdrEml(String nmlzdValAdrEml) {
        this.nmlzdValAdrEml = nmlzdValAdrEml;
    }

    public String getIndAuthOptin() {
        return indAuthOptin;
    }

    public void setIndAuthOptin(String indAuthOptin) {
        this.indAuthOptin = indAuthOptin;
    }

    public Integer getDegCfdcAdrEml() {
        return degCfdcAdrEml;
    }

    public void setDegCfdcAdrEml(Integer degCfdcAdrEml) {
        this.degCfdcAdrEml = degCfdcAdrEml;
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
