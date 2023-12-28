package by.harlap.springdatajpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "payment_by_requisite")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class PaymentByRequisite extends Payment {

    private String unp;
    private String receiver;
    private String destination;

    public PaymentByRequisite(Long id, String paymentFrom, String paymentTo, PaymentType paymentType, String unp, String receiver, String destination) {
        super(id, paymentFrom, paymentTo, paymentType);
        this.unp = unp;
        this.receiver = receiver;
        this.destination = destination;
    }
}
