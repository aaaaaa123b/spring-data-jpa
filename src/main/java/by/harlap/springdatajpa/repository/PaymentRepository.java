package by.harlap.springdatajpa.repository;

import by.harlap.springdatajpa.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
