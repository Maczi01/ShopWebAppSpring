package com.mati.springshop.payments;

public interface PaymentService {
    Payment process(PaymentRequest paymentRequest);
}
