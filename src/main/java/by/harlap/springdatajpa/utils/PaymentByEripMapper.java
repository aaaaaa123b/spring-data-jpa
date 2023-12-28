package by.harlap.springdatajpa.utils;

import org.springframework.stereotype.Component;
import by.harlap.springdatajpa.dto.PaymentResponse;
import by.harlap.springdatajpa.entity.Payment;
import by.harlap.springdatajpa.entity.PaymentByERIP;

import java.util.Map;

@Component
public class PaymentByEripMapper implements PaymentMapper<PaymentByERIP> {

    @Override
    public PaymentResponse toResponseDto(PaymentByERIP entity) {
        Map<String, String> params = Map.of("fieldForInsertion", entity.getFieldForInsertion(),
                "valueForInsertion", entity.getValueForInsertion());
        return new PaymentResponse(entity.getId(), entity.getPaymentFrom(), entity.getPaymentTo(), entity.getPaymentType(), params);
    }

    @Override
    public PaymentByERIP toEntity(PaymentResponse dto) {
    return new PaymentByERIP(dto.id(), dto.paymentFrom(), dto.paymentTo(), dto.paymentType(),
            dto.params().get("fieldForInsertion"),
            dto.params().get("valueForInsertion"));
    }

    @Override
    public Class<? extends Payment> getHandledClass() {
        return PaymentByERIP.class;
    }
}
