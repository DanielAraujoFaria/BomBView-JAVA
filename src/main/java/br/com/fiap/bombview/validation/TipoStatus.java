package br.com.fiap.bombview.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TipoStatusValidator.class)
public @interface TipoStatus {

    String message() default "{review.tipo}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
}
