package com.leonardomuniz.view;

import com.leonardomuniz.model.Item;
import com.leonardomuniz.model.Order;
import org.jetbrains.annotations.NotNull;

public class InvoicePrinter {
    public static void print(@NotNull Order order) {
        System.out.println("\nCliente: " + order.getClient().name());

        for (Item item : order.getItems()) {
            System.out.println(item.quantity() + "x " + item.name() + " R$" + item.price());
        }

        System.out.println("Subtotal: R$" + order.getSubtotal());
        System.out.println("Desconto: R$" + order.getDiscount());
        System.out.println("Total final: R$" + order.getTotal());
    }
}
