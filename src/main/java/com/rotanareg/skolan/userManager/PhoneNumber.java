package com.rotanareg.skolan.userManager;

import java.io.Serializable;

public class PhoneNumber implements Serializable {

    private static final long serialVersionUID = 1L;

   private String countryCode;
    private String subscriberNumber;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
		
	
    public String getSubscriberNumber() {
        return subscriberNumber;
    }

    public void setSubscriberNumber(String subscriberNumber) {
        this.subscriberNumber = subscriberNumber;
    }
}
