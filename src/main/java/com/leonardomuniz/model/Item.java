package com.leonardomuniz.model;

public record Item(String name, int quantity, double price) {
    public Item {
        if (quantity <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }
    }
    public double getTotalPrice() {
        return price * quantity;
    }
}
