package com.cory.transactions;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Currency;

public class TransactionSystemTest {

    @Test
    public void testSomething() {
        BigDecimal total = new BigDecimal("8.6");

        total = total.add(new BigDecimal(8.6));
        total = total.add(new BigDecimal(8.6));

        total = total.round(new MathContext(4));

    }

}
