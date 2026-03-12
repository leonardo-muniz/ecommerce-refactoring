package com.leonardomuniz.model;

import com.leonardomuniz.service.DiscountPolicy;
import com.leonardomuniz.service.EmailService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private final Client client;
    private final List<Item> items;
    private final double discountRate;

    public Order(Client client, double discountRate) {
        this.client = client;
        this.items = new ArrayList<>();
        this.discountRate = discountRate;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public Client getClient() {
        return client;
    }

    // Retorna uma lista imutável para proteger a coleção interna
    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public double getSubtotal() {
        double subtotal = 0;
        for (Item item : items) {
            subtotal += item.getTotalPrice();
        }
        return subtotal;
    }

    public double getDiscount() {
        return DiscountPolicy.calculateDiscount(getSubtotal(), discountRate);
    }

    public double getTotal() {
        return getSubtotal() - getDiscount();
    }

    public void sendConfirmationEmail() {
        EmailService.sendEmail(client.email(), "Pedido recebido! Obrigado pela compra.");
    }
}
