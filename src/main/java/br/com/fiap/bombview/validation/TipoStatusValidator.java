package br.com.fiap.bombview.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TipoStatusValidator implements ConstraintValidator<TipoStatus, String> {
        
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.equals("ASSISTIDO") || value.equals("NÃO ASSISTIDO");
    }
    
}
