package com.mati.springshop.payments;

import java.util.UUID;

public class UUIDPaymentGenerator implements PaymentGenerator {

    @Override
    public String getNext() {
        return UUID.randomUUID().toString();
    }
}
