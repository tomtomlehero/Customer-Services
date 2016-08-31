package fr.mla.customer.service.model;

import javax.persistence.*;
import java.util.Date;


/**

 CREATE TABLE CRMDB.CUST_CARD (
     IDF_SEQ_CUST_CARD       NUMBER(12)            NOT NULL,
     UUID_CUST               VARCHAR2(36 BYTE),
     COD_TYP_CUST_CARD       VARCHAR2(3 BYTE),
     COD_SUB_TYP_CUST_CARD   VARCHAR2(3 BYTE),
     DSC_SUB_TYP_CUST_CARD   VARCHAR2(30 BYTE),
     IDF_CUST_CARD           VARCHAR2(20 BYTE)     NOT NULL,
     COD_CRY_ISS             VARCHAR2(2 BYTE),
     CTY_OF_ISS              VARCHAR2(35 BYTE),
     DAT_EXP                 DATE,
     DAT_ISS                 DATE,
     AUTH_ISS                VARCHAR2(20 BYTE),
     DEG_CFDC_CUST_CARD      NUMBER(2),
     TMS_LST_CHNG_BY_GWYRPT  TIMESTAMP(6),
     TMS_LST_CHNG_BY_API     TIMESTAMP(6),
     COD_SRC_LST_CHNG_BY     VARCHAR2(3 BYTE)      NOT NULL
 )

 */


@Entity
@Table(name="CUST_CARD")
public class CardEntity {

    //     IDF_SEQ_CUST_CARD  NUMBER(12)                 NOT NULL,
    @Id
    @Column(name="IDF_SEQ_CUST_CARD")
    private Long idfSeqCustCard;

    //     UUID_CUST          VARCHAR2(36 BYTE),
    @ManyToOne
    @JoinColumn(name = "UUID_CUST")
    private CustomerEntity customer;

    //     COD_TYP_CUST_CARD  VARCHAR2(3 BYTE),
    @Column(name="COD_TYP_CUST_CARD")
    private String codTypCustCard;

    //     COD_SUB_TYP_CUST_CARD   VARCHAR2(3 BYTE),
    @Column(name="COD_SUB_TYP_CUST_CARD")
    private String codSubTypCustCard;

    //     DSC_SUB_TYP_CUST_CARD   VARCHAR2(30 BYTE),
    @Column(name="DSC_SUB_TYP_CUST_CARD")
    private String dscSubTypCustCard;

    //     IDF_CUST_CARD      VARCHAR2(20 BYTE)          NOT NULL,
    @Column(name="IDF_CUST_CARD")
    private String idfCustCard;

    //     COD_CRY_ISS        VARCHAR2(2 BYTE),
    @Column(name="COD_CRY_ISS")
    private String codCryIss;

    //     CTY_OF_ISS         VARCHAR2(35 BYTE),
    @Column(name="CTY_OF_ISS")
    private String ctyOfIss;

    //     DAT_EXP            DATE,
    @Column(name="DAT_EXP")
    @Temporal(TemporalType.DATE)
    private Date datExp;

    //     DAT_ISS            DATE,
    @Column(name="DAT_ISS")
    @Temporal(TemporalType.DATE)
    private Date datIss;

    //     AUTH_ISS           VARCHAR2(20 BYTE)
    @Column(name="AUTH_ISS")
    private String authIss;

    //     DEG_CFDC_CUST_CARD      NUMBER(2),
    @Column(name="DEG_CFDC_CUST_CARD")
    private Integer degCfdcCustCard;

    //     TMS_LST_CHNG_BY_GWYRPT  TIMESTAMP(6),
    @Column(name="TMS_LST_CHNG_BY_GWYRPT")
    private Date tmsLstChngByGwyrpt;

    //     TMS_LST_CHNG_BY_API     TIMESTAMP(6),
    @Column(name="TMS_LST_CHNG_BY_API")
    private Date tmsLstChngByApi;

    //     COD_SRC_LST_CHNG_BY     VARCHAR2(3 BYTE)      NOT NULL
    @Column(name="COD_SRC_LST_CHNG_BY")
    private String codSrcLstChngBy;


    public Long getIdfSeqCustCard() {
        return idfSeqCustCard;
    }

    public void setIdfSeqCustCard(Long idfSeqCustCard) {
        this.idfSeqCustCard = idfSeqCustCard;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public String getCodTypCustCard() {
        return codTypCustCard;
    }

    public void setCodTypCustCard(String codTypCustCard) {
        this.codTypCustCard = codTypCustCard;
    }

    public String getCodSubTypCustCard() {
        return codSubTypCustCard;
    }

    public void setCodSubTypCustCard(String codSubTypCustCard) {
        this.codSubTypCustCard = codSubTypCustCard;
    }

    public String getDscSubTypCustCard() {
        return dscSubTypCustCard;
    }

    public void setDscSubTypCustCard(String dscSubTypCustCard) {
        this.dscSubTypCustCard = dscSubTypCustCard;
    }

    public String getIdfCustCard() {
        return idfCustCard;
    }

    public void setIdfCustCard(String idfCustCard) {
        this.idfCustCard = idfCustCard;
    }

    public String getCodCryIss() {
        return codCryIss;
    }

    public void setCodCryIss(String codCryIss) {
        this.codCryIss = codCryIss;
    }

    public String getCtyOfIss() {
        return ctyOfIss;
    }

    public void setCtyOfIss(String ctyOfIss) {
        this.ctyOfIss = ctyOfIss;
    }

    public Date getDatExp() {
        return datExp;
    }

    public void setDatExp(Date datExp) {
        this.datExp = datExp;
    }

    public Date getDatIss() {
        return datIss;
    }

    public void setDatIss(Date datIss) {
        this.datIss = datIss;
    }

    public String getAuthIss() {
        return authIss;
    }

    public void setAuthIss(String authIss) {
        this.authIss = authIss;
    }

    public Integer getDegCfdcCustCard() {
        return degCfdcCustCard;
    }

    public void setDegCfdcCustCard(Integer degCfdcCustCard) {
        this.degCfdcCustCard = degCfdcCustCard;
    }

    public Date getTmsLstChngByGwyrpt() {
        return tmsLstChngByGwyrpt;
    }

    public void setTmsLstChngByGwyrpt(Date tmsLstChngByGwyrpt) {
        this.tmsLstChngByGwyrpt = tmsLstChngByGwyrpt;
    }

    public Date getTmsLstChngByApi() {
        return tmsLstChngByApi;
    }

    public void setTmsLstChngByApi(Date tmsLstChngByApi) {
        this.tmsLstChngByApi = tmsLstChngByApi;
    }

    public String getCodSrcLstChngBy() {
        return codSrcLstChngBy;
    }

    public void setCodSrcLstChngBy(String codSrcLstChngBy) {
        this.codSrcLstChngBy = codSrcLstChngBy;
    }
}
