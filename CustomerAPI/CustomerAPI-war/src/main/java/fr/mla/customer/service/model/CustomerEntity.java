package fr.mla.customer.service.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**

 CREATE TABLE CRMDB.CUST (
    UUID_CUST               VARCHAR2(36 BYTE)     NOT NULL,
    TYP_CUST                VARCHAR2(1 BYTE)      NOT NULL,
    STU_CUST                VARCHAR2(1 BYTE)      NOT NULL,
    SRNM                    VARCHAR2(35 BYTE)     NOT NULL,
    FRST_NM                 VARCHAR2(35 BYTE)     NOT NULL,
    DAT_OF_BRTH             DATE                  NOT NULL,
    CIT_OF_BRTH             VARCHAR2(35 BYTE)     NOT NULL,
    COD_CRY_OF_BRTH         VARCHAR2(2 BYTE),
    TYP_GDR                 CHAR(1 BYTE)          NOT NULL,
    CVLY                    VARCHAR2(35 BYTE),
    COD_CRY_RSD             VARCHAR2(2 BYTE),
    COD_ISO_LGG             VARCHAR2(5 BYTE),
    COD_PREV_LGG            VARCHAR2(2 BYTE),
    IND_AUTH_OPTIN          VARCHAR2(1 BYTE),
    COD_FSCL                VARCHAR2(16 BYTE),
    NMLZD_COD_ISO_LGG       VARCHAR2(5 BYTE),
    COD_TYP_CVLY            VARCHAR2(3 BYTE),
    SRNM_PHNTC_ALGO_1       VARCHAR2(30 BYTE),
    FRST_NM_PHNTC_ALGO_1    VARCHAR2(30 BYTE),
    DEG_CFDC_PHNTC_ALGO_1   NUMBER(2),
    SRNM_1_PHNTC_ALGO_2     VARCHAR2(30 BYTE),
    FRST_NM_1_PHNTC_ALGO_2  VARCHAR2(30 BYTE),
    SRNM_2_PHNTC_ALGO_2     VARCHAR2(30 BYTE),
    FRST_NM_2_PHNTC_ALGO_2  VARCHAR2(30 BYTE),
    DEG_CFDC_PHNTC_ALGO_2   NUMBER(2),
    STU_DRV                 VARCHAR2(2 BYTE)      NOT NULL,
    COD_TYP_WTCH_LST        VARCHAR2(3 BYTE),
    DAT_END_VLDT            DATE,
    TMS_LST_CHNG_BY_GWYRPT  TIMESTAMP(6),
    TMS_LST_CHNG_BY_API     TIMESTAMP(6),
    COD_SRC_LST_CHNG_BY     VARCHAR2(3 BYTE)      NOT NULL
 )

 */



@Entity
@Table(name="CUST")
public class CustomerEntity {

    //    UUID_CUST               VARCHAR2(36 BYTE)     NOT NULL,
    @Id
    @Column(name="UUID_CUST")
    private String uuidCust;

    //    TYP_CUST                VARCHAR2(1 BYTE)      NOT NULL,
    @Column(name="TYP_CUST")
    private String typCust;

    //    STU_CUST                VARCHAR2(1 BYTE)      NOT NULL,
    @Column(name="STU_CUST")
    private String stuCust;

    //    SRNM                    VARCHAR2(35 BYTE)     NOT NULL,
    @Column(name="SRNM")
    private String srnm;

    //    FRST_NM                 VARCHAR2(35 BYTE)     NOT NULL,
    @Column(name="FRST_NM")
    private String frstNm;

    //    DAT_OF_BRTH             DATE                  NOT NULL,
    @Column(name="DAT_OF_BRTH")
    @Temporal(TemporalType.DATE)
    private Date datOfBrth;

    //    CIT_OF_BRTH             VARCHAR2(35 BYTE)     NOT NULL,
    @Column(name="CIT_OF_BRTH")
    private String citOfBrth;

    //    COD_CRY_OF_BRTH         VARCHAR2(2 BYTE),
    @Column(name="COD_CRY_OF_BRTH")
    private String codCryOfBrth;

    //    TYP_GDR                 CHAR(1 BYTE)          NOT NULL,
    @Column(name="TYP_GDR")
    private String typGdr;

    //    CVLY                    VARCHAR2(35 BYTE),
    @Column(name="CVLY")
    private String cvly;

    //    COD_CRY_RSD             VARCHAR2(2 BYTE),
    @Column(name="COD_CRY_RSD")
    private String codCryRsd;

    //    COD_ISO_LGG             VARCHAR2(5 BYTE),
    @Column(name="COD_ISO_LGG")
    private String codIsoLgg;

    //    COD_PREV_LGG            VARCHAR2(2 BYTE),
    @Column(name="COD_PREV_LGG")
    private String codPrevLgg;

    //    IND_AUTH_OPTIN          VARCHAR2(1 BYTE),
    @Column(name="IND_AUTH_OPTIN")
    private String indAuthOptin;

    //    COD_FSCL                VARCHAR2(16 BYTE),
    @Column(name="COD_FSCL")
    private String codFscl;

    //    NMLZD_COD_ISO_LGG       VARCHAR2(5 BYTE),
    @Column(name="NMLZD_COD_ISO_LGG")
    private String nmlzdCodIsoLgg;

    //    COD_TYP_CVLY            VARCHAR2(3 BYTE),
    @Column(name="COD_TYP_CVLY")
    private String codTypCvly;

    //    SRNM_PHNTC_ALGO_1       VARCHAR2(30 BYTE),
    @Column(name="SRNM_PHNTC_ALGO_1")
    private String srnmPhntcAlgo1;

    //    FRST_NM_PHNTC_ALGO_1    VARCHAR2(30 BYTE),
    @Column(name="FRST_NM_PHNTC_ALGO_1")
    private String frstNmPhntcAlgo1;

    //    DEG_CFDC_PHNTC_ALGO_1   NUMBER(2),
    @Column(name="DEG_CFDC_PHNTC_ALGO_1")
    private Integer degCfdcPhntcAlgo1;

    //    SRNM_1_PHNTC_ALGO_2     VARCHAR2(30 BYTE),
    @Column(name="SRNM_1_PHNTC_ALGO_2")
    private String srnm1PhntcAlgo2;

    //    FRST_NM_1_PHNTC_ALGO_2  VARCHAR2(30 BYTE),
    @Column(name="FRST_NM_1_PHNTC_ALGO_2")
    private String frstNm1PhntcAlgo2;

    //    SRNM_2_PHNTC_ALGO_2     VARCHAR2(30 BYTE),
    @Column(name="SRNM_2_PHNTC_ALGO_2")
    private String srnm2PhntcAlgo2;

    //    FRST_NM_2_PHNTC_ALGO_2  VARCHAR2(30 BYTE),
    @Column(name="FRST_NM_2_PHNTC_ALGO_2")
    private String frstNm2PhntcAlgo2;

    //    DEG_CFDC_PHNTC_ALGO_2   NUMBER(2),
    @Column(name="DEG_CFDC_PHNTC_ALGO_2")
    private Integer degCfdcPhntcAlgo2;

    //    STU_DRV                 VARCHAR2(2 BYTE)      NOT NULL,
    @Column(name="STU_DRV")
    private String stuDrv;

    //    COD_TYP_WTCH_LST        VARCHAR2(3 BYTE)
    @Column(name="COD_TYP_WTCH_LST")
    private String codTypWtchLst;

    //    DAT_END_VLDT            DATE,
    @Column(name="DAT_END_VLDT")
    @Temporal(TemporalType.DATE)
    private Date datEndVldt;

    //    TMS_LST_CHNG_BY_GWYRPT  TIMESTAMP(6),
    @Column(name="TMS_LST_CHNG_BY_GWYRPT")
    private Date tmsLstChngByGwyrpt;

    //    TMS_LST_CHNG_BY_API     TIMESTAMP(6),
    @Column(name="TMS_LST_CHNG_BY_API")
    private Date tmsLstChngByApi;

    //    COD_SRC_LST_CHNG_BY     VARCHAR2(3 BYTE)      NOT NULL,
    @Column(name="COD_SRC_LST_CHNG_BY")
    private String codSrcLstChngBy;



    @OneToMany(mappedBy = "customer")
    private List<AddressEntity> addresses = new ArrayList<AddressEntity>();

    @OneToMany(mappedBy = "customer")
    private List<PhoneEntity> phones = new ArrayList<PhoneEntity>();

    @OneToMany(mappedBy = "customer")
    private List<EmailEntity> emails = new ArrayList<EmailEntity>();

    @OneToMany(mappedBy = "customer")
    private List<CardEntity> cards = new ArrayList<CardEntity>();

    @OneToMany(mappedBy = "customer")
    private List<ExternalIDEntity> externalIDs = new ArrayList<ExternalIDEntity>();




    public String getUuidCust() {
        return uuidCust;
    }

    public void setUuidCust(String uuidCust) {
        this.uuidCust = uuidCust;
    }

    public String getTypCust() {
        return typCust;
    }

    public void setTypCust(String typCust) {
        this.typCust = typCust;
    }

    public String getStuCust() {
        return stuCust;
    }

    public void setStuCust(String stuCust) {
        this.stuCust = stuCust;
    }

    public String getSrnm() {
        return srnm;
    }

    public void setSrnm(String srnm) {
        this.srnm = srnm;
    }

    public String getFrstNm() {
        return frstNm;
    }

    public void setFrstNm(String frstNm) {
        this.frstNm = frstNm;
    }

    public Date getDatOfBrth() {
        return datOfBrth;
    }

    public void setDatOfBrth(Date datOfBrth) {
        this.datOfBrth = datOfBrth;
    }

    public String getCitOfBrth() {
        return citOfBrth;
    }

    public void setCitOfBrth(String citOfBrth) {
        this.citOfBrth = citOfBrth;
    }

    public String getCodCryOfBrth() {
        return codCryOfBrth;
    }

    public void setCodCryOfBrth(String codCryOfBrth) {
        this.codCryOfBrth = codCryOfBrth;
    }

    public String getTypGdr() {
        return typGdr;
    }

    public void setTypGdr(String typGdr) {
        this.typGdr = typGdr;
    }

    public String getCvly() {
        return cvly;
    }

    public void setCvly(String cvly) {
        this.cvly = cvly;
    }

    public String getCodCryRsd() {
        return codCryRsd;
    }

    public void setCodCryRsd(String codCryRsd) {
        this.codCryRsd = codCryRsd;
    }

    public String getCodIsoLgg() {
        return codIsoLgg;
    }

    public void setCodIsoLgg(String codIsoLgg) {
        this.codIsoLgg = codIsoLgg;
    }

    public String getCodPrevLgg() {
        return codPrevLgg;
    }

    public void setCodPrevLgg(String codPrevLgg) {
        this.codPrevLgg = codPrevLgg;
    }

    public String getIndAuthOptin() {
        return indAuthOptin;
    }

    public void setIndAuthOptin(String indAuthOptin) {
        this.indAuthOptin = indAuthOptin;
    }

    public String getCodFscl() {
        return codFscl;
    }

    public void setCodFscl(String codFscl) {
        this.codFscl = codFscl;
    }

    public String getNmlzdCodIsoLgg() {
        return nmlzdCodIsoLgg;
    }

    public void setNmlzdCodIsoLgg(String nmlzdCodIsoLgg) {
        this.nmlzdCodIsoLgg = nmlzdCodIsoLgg;
    }

    public String getCodTypCvly() {
        return codTypCvly;
    }

    public void setCodTypCvly(String codTypCvly) {
        this.codTypCvly = codTypCvly;
    }

    public String getSrnmPhntcAlgo1() {
        return srnmPhntcAlgo1;
    }

    public void setSrnmPhntcAlgo1(String srnmPhntcAlgo1) {
        this.srnmPhntcAlgo1 = srnmPhntcAlgo1;
    }

    public String getFrstNmPhntcAlgo1() {
        return frstNmPhntcAlgo1;
    }

    public void setFrstNmPhntcAlgo1(String frstNmPhntcAlgo1) {
        this.frstNmPhntcAlgo1 = frstNmPhntcAlgo1;
    }

    public Integer getDegCfdcPhntcAlgo1() {
        return degCfdcPhntcAlgo1;
    }

    public void setDegCfdcPhntcAlgo1(Integer degCfdcPhntcAlgo1) {
        this.degCfdcPhntcAlgo1 = degCfdcPhntcAlgo1;
    }

    public String getSrnm1PhntcAlgo2() {
        return srnm1PhntcAlgo2;
    }

    public void setSrnm1PhntcAlgo2(String srnm1PhntcAlgo2) {
        this.srnm1PhntcAlgo2 = srnm1PhntcAlgo2;
    }

    public String getFrstNm1PhntcAlgo2() {
        return frstNm1PhntcAlgo2;
    }

    public void setFrstNm1PhntcAlgo2(String frstNm1PhntcAlgo2) {
        this.frstNm1PhntcAlgo2 = frstNm1PhntcAlgo2;
    }

    public String getSrnm2PhntcAlgo2() {
        return srnm2PhntcAlgo2;
    }

    public void setSrnm2PhntcAlgo2(String srnm2PhntcAlgo2) {
        this.srnm2PhntcAlgo2 = srnm2PhntcAlgo2;
    }

    public String getFrstNm2PhntcAlgo2() {
        return frstNm2PhntcAlgo2;
    }

    public void setFrstNm2PhntcAlgo2(String frstNm2PhntcAlgo2) {
        this.frstNm2PhntcAlgo2 = frstNm2PhntcAlgo2;
    }

    public Integer getDegCfdcPhntcAlgo2() {
        return degCfdcPhntcAlgo2;
    }

    public void setDegCfdcPhntcAlgo2(Integer degCfdcPhntcAlgo2) {
        this.degCfdcPhntcAlgo2 = degCfdcPhntcAlgo2;
    }

    public String getStuDrv() {
        return stuDrv;
    }

    public void setStuDrv(String stuDrv) {
        this.stuDrv = stuDrv;
    }

    public String getCodTypWtchLst() {
        return codTypWtchLst;
    }

    public void setCodTypWtchLst(String codTypWtchLst) {
        this.codTypWtchLst = codTypWtchLst;
    }

    public Date getDatEndVldt() {
        return datEndVldt;
    }

    public void setDatEndVldt(Date datEndVldt) {
        this.datEndVldt = datEndVldt;
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

    public List<AddressEntity> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressEntity> addresses) {
        this.addresses = addresses;
    }

    public List<PhoneEntity> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneEntity> phones) {
        this.phones = phones;
    }

    public List<EmailEntity> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailEntity> emails) {
        this.emails = emails;
    }

    public List<CardEntity> getCards() {
        return cards;
    }

    public void setCards(List<CardEntity> cards) {
        this.cards = cards;
    }

    public List<ExternalIDEntity> getExternalIDs() {
        return externalIDs;
    }

    public void setExternalIDs(List<ExternalIDEntity> externalIDs) {
        this.externalIDs = externalIDs;
    }
}
