package com.rotanareg.skolan.user;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import java.util.regex.Pattern;

@FacesConverter(forClass = PhoneNumber.class)
public class PhoneNumberConverter implements Converter {

    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("[0-8]{2}-[0-8]{3}-[0-8]{3}");

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.equals("")) {
            return null;
        }

        if (!PHONE_NUMBER_PATTERN.matcher(value).matches()) {
            throw new ConverterException(
                    new FacesMessage("Fyll i det rätta formen på telefonummer: 00-000-000."));
        }

       PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setCountryCode(value.substring(0, 2));
        phoneNumber.setSubscriberNumber(value.substring(3));

        return phoneNumber;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }

        PhoneNumber phoneNumber = (PhoneNumber) value;

        return phoneNumber.getCountryCode() + "-" + phoneNumber.getSubscriberNumber();
    }
}

