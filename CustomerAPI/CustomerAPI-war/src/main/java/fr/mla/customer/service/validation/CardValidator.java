package fr.mla.customer.service.validation;

import fr.mla.customer.api.swagger.model.Card;
import fr.mla.framework.ws.validation.Validator;
import fr.mla.framework.ws.validation.datavalidator.DateValidator;
import fr.mla.framework.ws.validation.datavalidator.ObjectValidator;
import fr.mla.framework.ws.validation.datavalidator.StringValidator;
import fr.mla.framework.ws.validation.exception.ValidationException;
import fr.mla.framework.ws.validation.util.ValidationErrors;

public class CardValidator extends Validator<Card> {

    @Override
    public void validate(Card card, ValidationErrors validationErrors) throws ValidationException {

//        "cards": [
//        {
//            "id": "",


//                "typeCd": "",
        new ObjectValidator(card.getTypeCd(), validationErrors)
                .notNull("cards.typeCd is mandatory");

//                "typeLb": "ignored",

//                "number": "123ABC0000",
        new StringValidator(card.getNumber(), validationErrors)
                .notNull("cards.number is mandatory")
                .sizeMax(12, "cards.number must not exceed 12 characters");

//                "issueCountryCd": "FR",
        new StringValidator(card.getIssueCountryCd(), validationErrors)
                .matches("[A-Z]{2}", "card.issueCountryCd must be exactly 2 letters in uppercase");

//                "issueCountryLb": "ignored",

//                "issueDate": "2012-07-25",
        new DateValidator(card.getIssueDate(), validationErrors)
                .past("card.issueDate must not be latter than now");

//                "expirationDate": "2049-12-31"
        new DateValidator(card.getExpirationDate(), validationErrors)
                .future("card.expirationDate must be in the future");

//        }



    }
}
