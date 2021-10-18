package com.mati.springshop;

import com.mati.springshop.payments.*;
import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
@Log
public class SpringShopApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringShopApplication.class, args);
        UUIDPaymentGenerator uuidPaymentGenerator = new UUIDPaymentGenerator();
        var fakePaymentService = new FakePaymentService(uuidPaymentGenerator);
        var paymentService = new LoggingPaymentService(fakePaymentService);
        var paymentRequest = PaymentRequest.builder()
                .money(LocalMoney.of(1_000))
                .build();
        var payment = paymentService.process(paymentRequest);
//        log.info(payment.toString());
    }

}
