package fr.mla.customer.service.mapping;

import fr.mla.customer.api.swagger.model.*;
import fr.mla.customer.service.model.*;
import fr.mla.customer.service.util.MappingUtil;

import java.util.List;

public class EntityToDtoMapper {


    public void map(CustomerEntity customerEntity, Customer customer) {

        customer.setId(customerEntity.getUuidCust());

        Identity identity = new Identity();
        map(customerEntity, identity);
        customer.setIdentity(identity);

        Status status = new Status();
        map(customerEntity, status);
        customer.setStatus(status);

        for (AddressEntity addressEntity : customerEntity.getAddresses()) {
            Address address = new Address();
            map(addressEntity, address);
            customer.getAddresses().add(address);
        }

        for (CardEntity cardEntity : customerEntity.getCards()) {
            Card card = new Card();
            map(cardEntity, card);
            customer.getCards().add(card);
        }

        for (EmailEntity emailEntity : customerEntity.getEmails()) {
            Email email = new Email();
            map(emailEntity, email);
            customer.getEmails().add(email);
        }

        for (ExternalIDEntity externalIDEntity : customerEntity.getExternalIDs()) {
            ExternalID externalID = new ExternalID();
            map(externalIDEntity, externalID);
            customer.getExternalIDs().add(externalID);
        }

        for (PhoneEntity phoneEntity : customerEntity.getPhones()) {
            Phone phone = new Phone();
            map(phoneEntity, phone);
            customer.getPhones().add(phone);
        }


    }

    private void map(CustomerEntity customerEntity, Identity identity) {
        identity.setFirstName(customerEntity.getFrstNm());
        identity.setLastName(customerEntity.getSrnm());
        identity.setDateOfBirth(customerEntity.getDatOfBrth());
        identity.setGender(Identity.GenderEnum.valueOf(customerEntity.getTypGdr()));
        identity.setCivility(customerEntity.getCodTypCvly());
        identity.setCountryOfResidenceCd(customerEntity.getCodCryRsd());
        identity.setCountryOfResidenceLb("!*!*!*!*! TODO !*!*!*!*!");
        identity.setLanguageCd(customerEntity.getCodIsoLgg());
        identity.setPrevLanguageCd(customerEntity.getCodPrevLgg());
    }

    private void map(CustomerEntity customerEntity, Status status) {
        status.setStatus(Status.StatusEnum.valueOf(customerEntity.getStuCust()));
        status.setType(Status.TypeEnum.valueOf(customerEntity.getTypCust()));
        status.setDriverStatus(customerEntity.getStuDrv());
        status.setInvalidatedAt(customerEntity.getDatEndVldt());
        status.setIndAuthOptin(MappingUtil.ynToBoolean(customerEntity.getIndAuthOptin()));
        status.setWatchListed(customerEntity.getCodTypWtchLst());
    }

    public void map(AddressEntity addressEntity, Address address) {
        address.setId(String.valueOf(addressEntity.getIdfSeqAdrPost()));
        address.getLines().add(addressEntity.getAdrPostLn1());
        address.getLines().add(addressEntity.getAdrPostLn2());
        address.getLines().add(addressEntity.getAdrPostLn3());
        address.getLines().add(addressEntity.getAdrPostLn4());
        address.setZipCd(addressEntity.getCodPost());
        address.setCity(addressEntity.getNmCity());
        address.setCountryCd(addressEntity.getCodCry());
//        address.setCountryLb("");
        address.setStateCityProvDept(addressEntity.getStCtyProvDept());
        address.setIndAuthOptin(MappingUtil.ynToBoolean(addressEntity.getIndAuthOptin()));
        address.setMain(MappingUtil.ynToBoolean(addressEntity.getIndMain()));
        address.setTypeCd(Address.TypeCdEnum.valueOf(addressEntity.getTypCnt()));
        address.setApproachType(Address.ApproachTypeEnum.valueOf(addressEntity.getTypApp()));
        address.setStatus(Address.StatusEnum.valueOf(addressEntity.getStuMkt()));
    }


    public void map(CardEntity cardEntity, Card card) {
        card.setId(String.valueOf(cardEntity.getIdfSeqCustCard()));
        card.setTypeCd(Card.TypeCdEnum.valueOf(cardEntity.getCodTypCustCard()));
//        card.setTypeLb("");
        card.setSubTypeCd(cardEntity.getCodSubTypCustCard());
        card.setSubTypeDesc(cardEntity.getDscSubTypCustCard());
        card.setNumber(cardEntity.getIdfCustCard());
        card.setIssueCountryCd(cardEntity.getCodCryIss());
//        card.setIssueCountryLb("");
        card.setIssueDate(cardEntity.getDatIss());
        card.setExpirationDate(cardEntity.getDatExp());
        card.setConfidenceRank(cardEntity.getDegCfdcCustCard());
    }

    public void map(EmailEntity emailEntity, Email email) {
        email.setId(String.valueOf(emailEntity.getIdfSeqAdrEml()));
        email.setEmail(emailEntity.getValAdrEml());
        email.setNormalizedEmail(emailEntity.getNmlzdValAdrEml());
        email.setConfidenceRank(emailEntity.getDegCfdcAdrEml());
        email.setIndAuthOptin(MappingUtil.ynToBoolean(emailEntity.getIndAuthOptin()));
        email.setMain(MappingUtil.ynToBoolean(emailEntity.getIndMain()));
        email.setEmailType(Email.EmailTypeEnum.valueOf(emailEntity.getTypCnt()));
        email.setApproachType(Email.ApproachTypeEnum.valueOf(emailEntity.getTypApp()));
    }


    public void map(ExternalIDEntity externalIDEntity, ExternalID externalID) {

        String uri = externalIDEntity.getOwnAppli()
                + ":" + externalIDEntity.getCodAppi()
                + ":" + externalIDEntity.getTypClssObj()
                + ":" + externalIDEntity.getIdfObj();

        externalID.setUri(uri);
        externalID.setMain(externalIDEntity.getIndCustExtrRefMain());
    }


    public void map(PhoneEntity phoneEntity, Phone phone) {
        phone.setId(String.valueOf(phoneEntity.getIdfSeqPhonCnt()));
        phone.setAreaCd(phoneEntity.getCodArea());
        phone.setNumber(String.valueOf(phoneEntity.getNbrPhon()));
        phone.setExtension(phoneEntity.getExtPhon());
        phone.setTypeCd(Phone.TypeCdEnum.valueOf(phoneEntity.getTypCnt()));
        phone.setNormalizedNumber(phoneEntity.getNmlzdPhonNbr());
        phone.setConfidenceRank(phoneEntity.getDegCfdcNmlzdPhonNbr());
        phone.setIndAuthOptin(MappingUtil.ynToBoolean(phoneEntity.getIndAuthOptin()));
        phone.setMain(MappingUtil.ynToBoolean(phoneEntity.getIndMain()));
        phone.setPhoneType(Phone.PhoneTypeEnum.valueOf(phoneEntity.getTypPhonCnt()));
        phone.setApproachType(Phone.ApproachTypeEnum.valueOf(phoneEntity.getTypApp()));
//        phone.setStatus(Phone.StatusEnum.valueOf(phoneEntity.get???()));
        phone.setPhoneMain(MappingUtil.ynToBoolean(phoneEntity.getIndMainPhonCnt()));
    }

    public void map(List<CustomerEntity> customerEntities, List<Customer> customers) {

        for (CustomerEntity customerEntity : customerEntities) {
            Customer customer = new Customer();
            map(customerEntity, customer);
            customers.add(customer);
        }
    }

}
