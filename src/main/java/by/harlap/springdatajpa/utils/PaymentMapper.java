package by.harlap.springdatajpa.utils;

import by.harlap.springdatajpa.dto.PaymentResponse;
import by.harlap.springdatajpa.entity.Payment;

public interface PaymentMapper<T> {

    PaymentResponse toResponseDto(T entity);

    T toEntity(PaymentResponse dto);

    Class<? extends Payment> getHandledClass();
}
