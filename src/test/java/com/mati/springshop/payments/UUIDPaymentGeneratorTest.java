package com.mati.springshop.payments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UUIDPaymentGeneratorTest {

    private final UUIDPaymentGenerator paymentIdGenerator =  new UUIDPaymentGenerator();
    private static final String ID_FORMAT = "\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12}";

    @DisplayName("Should generate valid ID")
    @Test
    public void shouldGenerateValidId(){
        String id = paymentIdGenerator.getNext();
        Assertions.assertTrue(id.matches(ID_FORMAT));
    }

}
