package com.leonardomuniz.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderTest {

    @Test
    void shouldCalculateSubtotalCorrectlyForJoao() {
        Client client = new Client("João", "joao@email.com");
        Order order = new Order(client, 0.1);

        order.addItem(new Item("Notebook", 1, 3500.0));
        order.addItem(new Item("Mouse", 2, 80.8));

        // 3500.0 + 161.6 = 3661.6
        assertEquals(3661.6, order.getSubtotal(), 0.001);
    }

    @Test
    void shouldCalculateTotalWithDiscountCorrectlyForJoao() {
        Client client = new Client("João", "joao@email.com");
        Order order = new Order(client, 0.1);

        order.addItem(new Item("Notebook", 1, 3500.0));
        order.addItem(new Item("Mouse", 2, 80.8));

        // Subtotal = 3661.6 | Desconto (10%) = 366.16 | Total = 3295.44
        assertEquals(366.16, order.getDiscount(), 0.001);
        assertEquals(3295.44, order.getTotal(), 0.001);
    }

    @Test
    void shouldCalculateSubtotalCorrectlyForMaria() {
        Client client = new Client("Maria", "maria@email.com");
        Order order = new Order(client, 0.05);

        order.addItem(new Item("Memória RAM 16GB", 2, 280.0)); // 560.0
        order.addItem(new Item("Cabo HDMI 2m", 1, 45.50));     // 45.50
        order.addItem(new Item("Pendrive 16GB", 3, 25.00));    // 75.00

        // 560.0 + 45.50 + 75.00 = 680.50
        assertEquals(680.50, order.getSubtotal(), 0.001);
    }

    @Test
    void shouldCalculateTotalWithDiscountCorrectlyForMaria() {
        Client client = new Client("Maria", "maria@email.com");
        Order order = new Order(client, 0.05);

        order.addItem(new Item("Memória RAM 16GB", 2, 280.0));
        order.addItem(new Item("Cabo HDMI 2m", 1, 45.50));
        order.addItem(new Item("Pendrive 16GB", 3, 25.00));

        // Subtotal = 680.50 | Desconto (5%) = 34.025 | Total = 646.475
        assertEquals(34.025, order.getDiscount(), 0.001);
        assertEquals(646.475, order.getTotal(), 0.001);
    }

    @Test
    void shouldHandleEmptyOrder() {
        Client client = new Client("Vazio", "vazio@email.com");
        Order order = new Order(client, 0.1);

        assertEquals(0.0, order.getSubtotal(), 0.001);
        assertEquals(0.0, order.getDiscount(), 0.001);
        assertEquals(0.0, order.getTotal(), 0.001);
    }

    @Test
    void shouldCalculateZeroDiscount() {
        Client client = new Client("Sem Desconto", "sem@email.com");
        Order order = new Order(client, 0.0); // 0% de desconto
        order.addItem(new Item("Mouse", 1, 50.0));

        assertEquals(0.0, order.getDiscount(), 0.001);
        assertEquals(50.0, order.getTotal(), 0.001);
    }

    @Test
    void shouldCalculateFullDiscount() {
        Client client = new Client("Gratis", "gratis@email.com");
        Order order = new Order(client, 1.0); // 100% de desconto
        order.addItem(new Item("Mouse", 1, 50.0));

        assertEquals(50.0, order.getDiscount(), 0.001);
        assertEquals(0.0, order.getTotal(), 0.001);
    }

    @Test
    void shouldProtectInternalItemListFromModifications() {
        Client client = new Client("Teste", "teste@email.com");
        Order order = new Order(client, 0.1);
        order.addItem(new Item("Mouse", 1, 50.0));

        // Tenta adicionar um item diretamente na lista retornada, deve lançar exceção
        assertThrows(UnsupportedOperationException.class, () -> order.getItems().add(new Item("Teclado", 1, 100.0)));
    }
}
