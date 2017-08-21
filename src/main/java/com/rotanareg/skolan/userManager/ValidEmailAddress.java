package com.rotanareg.skolan.userManager;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmailAddressValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEmailAddress {

    String message() default "Skriv din rätta e-mail adressen.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
