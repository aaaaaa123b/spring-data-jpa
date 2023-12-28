package by.harlap.springdatajpa.service;

import by.harlap.springdatajpa.entity.Payment;
import by.harlap.springdatajpa.exception.PaymentNotFoundException;
import by.harlap.springdatajpa.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public Payment findById(Long id) {
        return paymentRepository
                .findById(id)
                .orElseThrow(() -> new PaymentNotFoundException(id));
    }

    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

}
