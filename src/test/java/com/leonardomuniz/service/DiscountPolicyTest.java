package com.leonardomuniz.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountPolicyTest {

    @Test
    void shouldCalculateDiscountCorrectly() {
        assertEquals(50.0, DiscountPolicy.calculateDiscount(500.0, 0.1), 0.001);
    }

    @Test
    void shouldCalculateZeroDiscount() {
        // Testa 0% de desconto
        assertEquals(0.0, DiscountPolicy.calculateDiscount(500.0, 0.0), 0.001);
    }

    @Test
    void shouldCalculateFullDiscount() {
        // Testa 100% de desconto
        assertEquals(500.0, DiscountPolicy.calculateDiscount(500.0, 1.0), 0.001);
    }
}
