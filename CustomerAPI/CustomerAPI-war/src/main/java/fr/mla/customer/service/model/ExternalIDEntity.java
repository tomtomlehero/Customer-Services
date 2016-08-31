package fr.mla.customer.service.model;

import fr.mla.customer.service.model.pk.ExternalIDPK;

import javax.persistence.*;

/**

 CREATE TABLE CRMDB.CUST_EXTR_REF (
     UUID_CUST_PHYS          VARCHAR2(36 BYTE)     NOT NULL,
     OWN_APPLI               VARCHAR2(3 BYTE)      NOT NULL,
     COD_APPI                VARCHAR2(3 BYTE)      NOT NULL,
     TYP_CLSS_OBJ            VARCHAR2(3 BYTE)      NOT NULL,
     IDF_OBJ                 VARCHAR2(40 BYTE)     NOT NULL,
     IND_CUST_EXTR_REF_MAIN  INTEGER               NOT NULL
 )

 */

@Entity
@Table(name="CUST_EXTR_REF")
@IdClass(ExternalIDPK.class)
public class ExternalIDEntity {


    //     UUID_CUST_PHYS          VARCHAR2(36 BYTE)     NOT NULL,
    @Id
    @ManyToOne
    @JoinColumn(name = "UUID_CUST_PHYS")
    private CustomerEntity customer;

    //     OWN_APPLI               VARCHAR2(3 BYTE)      NOT NULL,
    @Id
    @Column(name="OWN_APPLI")
    private String ownAppli;

    //     COD_APPI                VARCHAR2(3 BYTE)      NOT NULL,
    @Id
    @Column(name="COD_APPI")
    private String codAppi;

    //     TYP_CLSS_OBJ            VARCHAR2(3 BYTE)      NOT NULL,
    @Id
    @Column(name="TYP_CLSS_OBJ")
    private String typClssObj;

    //     IDF_OBJ                 VARCHAR2(40 BYTE)     NOT NULL,
    @Id
    @Column(name="IDF_OBJ")
    private String idfObj;

    //     IND_CUST_EXTR_REF_MAIN  INTEGER               NOT NULL
    @Column(name="IND_CUST_EXTR_REF_MAIN")
    private Boolean indCustExtrRefMain;


    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public String getOwnAppli() {
        return ownAppli;
    }

    public void setOwnAppli(String ownAppli) {
        this.ownAppli = ownAppli;
    }

    public String getCodAppi() {
        return codAppi;
    }

    public void setCodAppi(String codAppi) {
        this.codAppi = codAppi;
    }

    public String getTypClssObj() {
        return typClssObj;
    }

    public void setTypClssObj(String typClssObj) {
        this.typClssObj = typClssObj;
    }

    public String getIdfObj() {
        return idfObj;
    }

    public void setIdfObj(String idfObj) {
        this.idfObj = idfObj;
    }

    public Boolean getIndCustExtrRefMain() {
        return indCustExtrRefMain;
    }

    public void setIndCustExtrRefMain(Boolean indCustExtrRefMain) {
        this.indCustExtrRefMain = indCustExtrRefMain;
    }
}
