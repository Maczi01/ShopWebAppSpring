package com.mati.springshop.payments;

import lombok.Getter;

public class PaymentStatusChangedEvent {

    @Getter
    private final Payment payment;

    public PaymentStatusChangedEvent(Object source, Payment payment) {
//        super(source);
        this.payment = payment;
    }
}
