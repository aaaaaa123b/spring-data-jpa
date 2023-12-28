package by.harlap.springdatajpa.exception;

public class PaymentNotFoundException extends RuntimeException {

    public PaymentNotFoundException() {
        super();
    }

    public PaymentNotFoundException(Long id) {
        super("Payment with id %d not found".formatted(id));
    }
}
