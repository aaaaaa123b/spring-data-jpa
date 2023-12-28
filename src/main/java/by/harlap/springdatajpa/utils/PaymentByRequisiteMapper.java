package by.harlap.springdatajpa.utils;

import org.springframework.stereotype.Component;
import by.harlap.springdatajpa.dto.PaymentResponse;
import by.harlap.springdatajpa.entity.Payment;
import by.harlap.springdatajpa.entity.PaymentByRequisite;

import java.util.Map;

@Component
public class PaymentByRequisiteMapper implements PaymentMapper<PaymentByRequisite> {

    @Override
    public PaymentResponse toResponseDto(PaymentByRequisite entity) {
        Map<String, String> params = Map.of("unp", entity.getUnp(),
                "receiver", entity.getReceiver(),
                "destination", entity.getDestination());
        return new PaymentResponse(entity.getId(), entity.getPaymentFrom(), entity.getPaymentTo(), entity.getPaymentType(), params);
    }

    @Override
    public PaymentByRequisite toEntity(PaymentResponse dto) {
        return new PaymentByRequisite(dto.id(), dto.paymentFrom(), dto.paymentTo(), dto.paymentType(),
                dto.params().get("unp"),
                dto.params().get("receiver"),
                dto.params().get("destination"));
    }

    @Override
    public Class<? extends Payment> getHandledClass() {
        return PaymentByRequisite.class;
    }
}
