package com.mati.springshop.payments;

import lombok.extern.java.Log;

import java.time.Instant;

@Log
public class FakePaymentRequest {

    private final UUIDPaymentGenerator uuidPaymentGenerator = new UUIDPaymentGenerator();
    private static final String LOG_FORMAT = "A new payment of %s has been created";

    public Payment process(PaymentRequest paymentRequest) {
        var payment = Payment.builder()
                .id(uuidPaymentGenerator.getNext())
                .money(paymentRequest.getMoney())
                .timestamp(Instant.now())
                .status(PaymentStatus.STARTED)
                .build();
        log.info(createLogEntry(payment ));
        return payment;
    }

    private String createLogEntry(Payment payment) {
        return String.format(LOG_FORMAT, payment.getMoney());
    }

}
