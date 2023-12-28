package by.harlap.springdatajpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "payment_by_erip")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class PaymentByERIP extends Payment {

    private String fieldForInsertion;
    private String valueForInsertion;

    public PaymentByERIP(Long id, String paymentFrom, String paymentTo, PaymentType paymentType, String fieldForInsertion, String valueForInsertion) {
        super(id, paymentFrom, paymentTo, paymentType);
        this.fieldForInsertion = fieldForInsertion;
        this.valueForInsertion = valueForInsertion;
    }
}
