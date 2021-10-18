package com.mati.springshop.payments;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import java.time.Instant;

@Log
@RequiredArgsConstructor
public class FakePaymentService implements PaymentService {

    private final PaymentGenerator paymentGenerator;
    private static final String LOG_FORMAT = "A new payment of %s has been created";

    @Override
    public Payment process(PaymentRequest paymentRequest) {
        var payment = Payment.builder()
                .id(paymentGenerator.getNext())
                .money(paymentRequest.getMoney())
                .timestamp(Instant.now())
                .status(PaymentStatus.STARTED)
                .build();
        return payment;
    }


}
