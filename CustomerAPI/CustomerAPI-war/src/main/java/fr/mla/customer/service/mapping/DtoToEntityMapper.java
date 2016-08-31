package fr.mla.customer.service.mapping;

import fr.mla.customer.api.swagger.model.*;
import fr.mla.customer.feed.CustomerFeed;
import fr.mla.customer.feed.derivatives.*;
import fr.mla.customer.service.exception.UnparsableException;
import fr.mla.customer.service.model.*;
import fr.mla.customer.service.util.MappingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DtoToEntityMapper {

    @Autowired
    CustomerFeed customerFeed;

    public void map(Customer customer, CustomerEntity customerEntity) throws UnparsableException {

        mapIdentity(customer, customerEntity);
        mapStatus(customer, customerEntity);

        for (Address address : customer.getAddresses()) {
            AddressEntity addressEntity = new AddressEntity();
            map(address, addressEntity);

            customerEntity.getAddresses().add(addressEntity);
            addressEntity.setCustomer(customerEntity);
        }

        for (Card card : customer.getCards()) {
            CardEntity cardEntity = new CardEntity();
            map(card, cardEntity);

            customerEntity.getCards().add(cardEntity);
            cardEntity.setCustomer(customerEntity);
        }

        for (Email email : customer.getEmails()) {
            EmailEntity emailEntity = new EmailEntity();
            map(email, emailEntity);

            customerEntity.getEmails().add(emailEntity);
            emailEntity.setCustomer(customerEntity);
        }

        for (Phone phone : customer.getPhones()) {
            PhoneEntity phoneEntity = new PhoneEntity();
            map(phone, phoneEntity, customerEntity.getCodCryRsd());

            customerEntity.getPhones().add(phoneEntity);
            phoneEntity.setCustomer(customerEntity);
        }

        for (ExternalID externalID : customer.getExternalIDs()) {
            ExternalIDEntity externalIDEntity = new ExternalIDEntity();
            map(externalID, externalIDEntity);

            customerEntity.getExternalIDs().add(externalIDEntity);
            externalIDEntity.setCustomer(customerEntity);
        }

    }



    public void mapIdentity(Customer customer, CustomerEntity customerEntity) {

        customerEntity.setSrnm(customer.getIdentity().getLastName());
        customerEntity.setFrstNm(customer.getIdentity().getFirstName());
        customerEntity.setDatOfBrth(customer.getIdentity().getDateOfBirth());
        customerEntity.setCitOfBrth("!*!*! TODO !*!*!");
//        customerEntity.setCodCryOfBrth("");
        customerEntity.setTypGdr(customer.getIdentity().getGender().name());
        customerEntity.setCvly(customer.getIdentity().getCivility());
        customerEntity.setCodCryRsd(customer.getIdentity().getCountryOfResidenceCd());
        customerEntity.setCodIsoLgg(customer.getIdentity().getLanguageCd());
        customerEntity.setCodPrevLgg(customer.getIdentity().getPrevLanguageCd());

//        customerEntity.setCodFscl("");

        CustomerDerivatives customerDerivatives = customerFeed.processCustomerDerivatives(
                customerEntity.getFrstNm(), customerEntity.getSrnm(), customerEntity.getCodIsoLgg());

        customerEntity.setNmlzdCodIsoLgg(customerDerivatives.getNmlzdCodIsoLgg());
        customerEntity.setCodTypCvly(customerDerivatives.getCodTypCvly());

        customerEntity.setSrnmPhntcAlgo1(customerDerivatives.getSrnmPhntcAlgo1());
        customerEntity.setFrstNmPhntcAlgo1(customerDerivatives.getFrstNmPhntcAlgo1());
        customerEntity.setDegCfdcPhntcAlgo1(customerDerivatives.getDegCfdcPhntcAlgo1());

        customerEntity.setSrnm1PhntcAlgo2(customerDerivatives.getSrnm1PhntcAlgo2());
        customerEntity.setFrstNm1PhntcAlgo2(customerDerivatives.getFrstNm1PhntcAlgo2());
        customerEntity.setSrnm2PhntcAlgo2(customerDerivatives.getSrnm2PhntcAlgo2());
        customerEntity.setFrstNm2PhntcAlgo2(customerDerivatives.getFrstNm2PhntcAlgo2());
        customerEntity.setDegCfdcPhntcAlgo2(customerDerivatives.getDegCfdcPhntcAlgo2());

//        customerEntity.setTmsLstChngByGwyrpt(null);
        customerEntity.setTmsLstChngByApi(new Date());
        customerEntity.setCodSrcLstChngBy("API");
    }

    public void mapStatus(Customer customer, CustomerEntity customerEntity) {
        customerEntity.setTypCust(customer.getStatus().getType().name());
        customerEntity.setStuCust(customer.getStatus().getStatus().name());
        customerEntity.setIndAuthOptin(MappingUtil.booleanToYN(customer.getStatus().getIndAuthOptin()));
        customerEntity.setStuDrv(customer.getStatus().getDriverStatus());
        customerEntity.setCodTypWtchLst(customer.getStatus().getWatchListed());
        customerEntity.setDatEndVldt(customer.getStatus().getInvalidatedAt());
    }


    public void map(Address address, AddressEntity addressEntity) {

        if (address.getLines().size() > 0) {
            addressEntity.setAdrPostLn1(address.getLines().get(0));
        }
        if (address.getLines().size() > 1) {
            addressEntity.setAdrPostLn2(address.getLines().get(1));
        }
        if (address.getLines().size() > 2) {
            addressEntity.setAdrPostLn3(address.getLines().get(2));
        }
        if (address.getLines().size() > 3) {
            addressEntity.setAdrPostLn4(address.getLines().get(3));
        }

        addressEntity.setCodPost(address.getZipCd());
        addressEntity.setStCtyProvDept(address.getStateCityProvDept());
        addressEntity.setNmCity(address.getCity());
        addressEntity.setCodCry(address.getCountryCd());

        AddressDerivatives addressDerivatives = customerFeed.processAddressDerivatives(
                addressEntity.getAdrPostLn1(),
                addressEntity.getAdrPostLn2(),
                addressEntity.getAdrPostLn3(),
                addressEntity.getAdrPostLn4(),
                addressEntity.getCodPost(),
                addressEntity.getNmCity(),
                addressEntity.getCodCry());

        addressEntity.setValHashAdrPost(addressDerivatives.getValHashAdrPost());

        addressEntity.setIndAuthOptin(MappingUtil.booleanToYN(address.getIndAuthOptin()));

        addressEntity.setStuMkt(address.getStatus().name());
        addressEntity.setIndMain(MappingUtil.booleanToYN(address.getMain()));
        addressEntity.setTypApp(address.getApproachType().name());
        addressEntity.setTypCnt(address.getTypeCd().name());
    }

    public void map(Card card, CardEntity cardEntity) {

        cardEntity.setCodTypCustCard(card.getTypeCd().name());
        cardEntity.setCodSubTypCustCard(card.getSubTypeCd());
        cardEntity.setDscSubTypCustCard(card.getSubTypeDesc());
        cardEntity.setIdfCustCard(card.getNumber());
        cardEntity.setCodCryIss(card.getIssueCountryCd());
//        cardEntity.setCtyOfIss(card.get???);
        cardEntity.setDatExp(card.getExpirationDate());
        cardEntity.setDatIss(card.getIssueDate());
//        cardEntity.setAuthIss(card.get???);

        CardDerivatives cardDerivatives = customerFeed.processCardDerivatives(card.getNumber());
        cardEntity.setDegCfdcCustCard(cardDerivatives.getDegCfdcCustCard());

//        cardEntity.setTmsLstChngByGwyrpt(null);
        cardEntity.setTmsLstChngByApi(new Date());
        cardEntity.setCodSrcLstChngBy("API");
    }

    public void map(Email email, EmailEntity emailEntity) {

        emailEntity.setValAdrEml(email.getEmail());

        EmailDerivatives emailDerivatives = customerFeed.processEmailDerivatives(emailEntity.getValAdrEml());

        emailEntity.setNmlzdValAdrEml(emailDerivatives.getNmlzdValAdrEmail());
        emailEntity.setIndAuthOptin(MappingUtil.booleanToYN(email.getIndAuthOptin()));
        emailEntity.setDegCfdcAdrEml(emailDerivatives.getDegCfdcNmlzdValAdrEmail());
        emailEntity.setIndMain(MappingUtil.booleanToYN(email.getMain()));
        emailEntity.setTypApp(email.getApproachType().name());
        emailEntity.setTypCnt(email.getEmailType().name());
    }

    public void map(Phone phone, PhoneEntity phoneEntity, String coutryOfResidence) throws UnparsableException {

        long nbrPhone;
        try {
            nbrPhone = Long.parseLong(phone.getNumber());
        } catch (NumberFormatException e) {
            throw new UnparsableException(phone.getNumber());
        }

        phoneEntity.setCodArea(phone.getAreaCd());
        phoneEntity.setNbrPhon(nbrPhone);
        phoneEntity.setExtPhon(phone.getExtension());

        PhoneNumberDerivatives phoneNumberDerivatives = customerFeed.processPhoneNumberDerivatives(
                phoneEntity.getCodArea(), String.valueOf(phoneEntity.getNbrPhon()), phoneEntity.getExtPhon(), coutryOfResidence);

        phoneEntity.setNmlzdPhonNbr(phoneNumberDerivatives.getNmlzdPhonNbr());
        phoneEntity.setDegCfdcNmlzdPhonNbr(phoneNumberDerivatives.getDegCfdcNmlzdPhonNbr());
        phoneEntity.setIndAuthOptin(MappingUtil.booleanToYN(phone.getIndAuthOptin()));
        phoneEntity.setIndMain(MappingUtil.booleanToYN(phone.getMain()));
        phoneEntity.setTypApp(phone.getApproachType().name());
        phoneEntity.setTypCnt(phone.getTypeCd().name());
        phoneEntity.setTypPhonCnt(phone.getPhoneType().name());
        phoneEntity.setIndMainPhonCnt(MappingUtil.booleanToYN(phone.getPhoneMain()));

    }

    private void map(ExternalID externalID, ExternalIDEntity externalIDEntity) {

        String uri[] = externalID.getUri().split(":");

        externalIDEntity.setOwnAppli(uri[0]);
        externalIDEntity.setCodAppi(uri[1]);
        externalIDEntity.setTypClssObj(uri[2]);
        externalIDEntity.setIdfObj(uri[3]);
        externalIDEntity.setIndCustExtrRefMain(externalID.getMain());

    }

}
