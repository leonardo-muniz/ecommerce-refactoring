package com.leonardomuniz.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ItemTest {

    @Test
    void shouldCalculateTotalPrice() {
        Item item = new Item("Teclado", 2, 150.0);
        assertEquals(300.0, item.getTotalPrice(), 0.001);
    }

    @Test
    void shouldThrowExceptionWhenQuantityIsZeroOrNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Item("Cabo", 0, 45.0));
        assertThrows(IllegalArgumentException.class, () -> new Item("Cabo", -1, 45.0));
    }

    @Test
    void shouldThrowExceptionWhenPriceIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Item("Mouse", 1, -10.0));
    }
}
