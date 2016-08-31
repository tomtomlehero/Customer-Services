package fr.mla.customer.service.model.pk;


import fr.mla.customer.service.model.CustomerEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class ExternalIDPK implements Serializable {


    @ManyToOne
    @JoinColumn(name = "UUID_CUST_PHYS")
    private CustomerEntity customer;

    @Column(name="OWN_APPLI")
    private String ownAppli;

    @Column(name="COD_APPI")
    private String codAppi;

    @Column(name="TYP_CLSS_OBJ")
    private String typClssObj;

    @Column(name="IDF_OBJ")
    private String idfObj;


    public ExternalIDPK() {
    }


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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ExternalIDPK that = (ExternalIDPK) o;

        return new EqualsBuilder()
                .append(customer, that.customer)
                .append(ownAppli, that.ownAppli)
                .append(codAppi, that.codAppi)
                .append(typClssObj, that.typClssObj)
                .append(idfObj, that.idfObj)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(customer)
                .append(ownAppli)
                .append(codAppi)
                .append(typClssObj)
                .append(idfObj)
                .toHashCode();
    }
}
