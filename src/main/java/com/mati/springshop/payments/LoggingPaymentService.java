package com.mati.springshop.payments;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@RequiredArgsConstructor
public class LoggingPaymentService implements PaymentService {

    private FakePaymentService paymentService;
    private static final String LOG_FORMAT = "A new payment of %s has been created";

    public LoggingPaymentService(FakePaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public Payment process(PaymentRequest paymentRequest) {
        var payment = paymentService.process(paymentRequest);
        log.info(createLogEntry(payment));
        return null;
    }

    private String createLogEntry(Payment payment) {
        return String.format(LOG_FORMAT, payment.getMoney());
    }

}
