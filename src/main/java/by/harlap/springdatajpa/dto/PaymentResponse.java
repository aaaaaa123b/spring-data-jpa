package by.harlap.springdatajpa.dto;

import by.harlap.springdatajpa.entity.PaymentType;

import java.util.Map;

public record PaymentResponse(Long id,
                              String paymentFrom,
                              String paymentTo,
                              PaymentType paymentType,
                              Map<String, String> params) {

}
