package by.harlap.springdatajpa.utils;

import by.harlap.springdatajpa.dto.PaymentResponse;
import by.harlap.springdatajpa.entity.Payment;
import org.springframework.stereotype.Component;

@Component
public class DefaultPaymentMapper implements PaymentMapper<Payment> {

    @Override
    public PaymentResponse toResponseDto(Payment entity) {
        return new PaymentResponse(entity.getId(), entity.getPaymentFrom(), entity.getPaymentTo(), entity.getPaymentType(), null);
    }

    @Override
    public Payment toEntity(PaymentResponse dto) {
        return new Payment(dto.id(), dto.paymentFrom(), dto.paymentTo(), dto.paymentType());
    }

    @Override
    public Class<? extends Payment> getHandledClass() {
        return Payment.class;
    }
}
