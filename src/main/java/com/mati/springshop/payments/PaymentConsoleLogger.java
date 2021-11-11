package com.mati.springshop.payments;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.context.MessageSource;

import java.util.Locale;


@Log
@RequiredArgsConstructor
public class PaymentConsoleLogger {

    private static final String MESSAGE_KEY = "paymentInfo";
    public final MessageSource messagesource;

    private String createLogEntry(Payment payment) {
        return messagesource.getMessage(MESSAGE_KEY, new String[] {payment.getMoney().toString()}, Locale.getDefault()) ;
    }

}
