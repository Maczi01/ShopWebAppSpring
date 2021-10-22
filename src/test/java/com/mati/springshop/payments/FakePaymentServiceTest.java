package com.mati.springshop.payments;

import org.javamoney.moneta.FastMoney;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class FakePaymentServiceTest {

    private static final String PAYMENT_ID = "1";
    private static final FastMoney MONEY = LocalMoney.of(1_000);
    private static final PaymentRequest PAYMENT_REQUEST = PaymentRequest.builder()
            .money(MONEY)
            .build();

    @Mock
    private PaymentGenerator paymentGenerator;
    private Payment payment;

    @BeforeEach
    void setUp() {
        Mockito.when(paymentGenerator.getNext()).thenReturn(PAYMENT_ID);
        FakePaymentService fakePaymentService = new FakePaymentService(paymentGenerator);
        payment = fakePaymentService.process(PAYMENT_REQUEST);
    }

    @Test
    void shouldAssignIdToCreatedPayment() {
        Assertions.assertEquals(PAYMENT_ID, payment.getId());
    }

    @Test
    void shouldAssignMonet() {
        Assertions.assertEquals(MONEY, payment.getMoney());
    }

    @Test
    void shouldAssignCorrectTimeStamp() {
        Assertions.assertNotNull(payment.getTimestamp());
    }

    @Test
    void shouldSetStatusAsStarted() {
        Assertions.assertEquals(PaymentStatus.STARTED, payment.getStatus());
    }

}
