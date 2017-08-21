package com.rotanareg.skolan.userManager;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("com.rotanareg.skolan.user.PhoneNumber")
public class PhoneNumberValidator implements Validator {

 @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        PhoneNumber phoneNumber = (PhoneNumber) value;
   


         if (phoneNumber != null) {
            checkCountryCode(phoneNumber.getCountryCode());
          
        }
    }

    private void checkCountryCode(String countryCode) {
        int firstDigit = Character.digit(countryCode.charAt(0), 10);
        if (firstDigit == 0 || firstDigit == 1) {
            throw new ValidatorException(
                    new FacesMessage("Första siffran i ditt tfn får inte vara 0 or 1."));
        }
    }
}