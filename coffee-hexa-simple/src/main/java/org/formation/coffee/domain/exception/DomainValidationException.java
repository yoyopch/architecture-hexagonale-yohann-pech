package org.formation.coffee.domain.exception;

public class DomainValidationException extends DomainException{
    public DomainValidationException(String message) {
        super(message);
    }
}
