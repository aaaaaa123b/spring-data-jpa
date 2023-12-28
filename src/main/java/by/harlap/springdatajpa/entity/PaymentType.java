package by.harlap.springdatajpa.entity;

public enum PaymentType {

    PHONE(Payment.class),
    ACCOUNT(Payment.class),
    CARD(Payment.class),
    REQUISITE(PaymentByRequisite.class),
    ERIP(PaymentByERIP.class);

    private final Class<? extends Payment> clazz;

    PaymentType(Class<? extends Payment> clazz) {
        this.clazz = clazz;
    }

    public Class<? extends Payment> getEntityClass(){
        return clazz;
    }
}
