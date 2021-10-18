package com.mati.springshop.payments;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Component
@Log
public class PaymentConsoleLogger {

    private static final String LOG_FORMAT = "A new payment of %s has been created";

    private String createLogEntry(Payment payment) {
        return String.format(LOG_FORMAT, payment.getMoney());
    }

}
