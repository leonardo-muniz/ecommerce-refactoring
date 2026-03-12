package com.leonardomuniz;

import com.leonardomuniz.model.Client;
import com.leonardomuniz.model.Item;
import com.leonardomuniz.model.Order;
import com.leonardomuniz.view.InvoicePrinter;

public class App {
    static void main() {
        // Pedido de João
        Client client = new Client("João", "joao@email.com");

        Order order = new Order(client, 0.1);

        order.addItem(new Item("Notebook", 1, 3500.0));
        order.addItem(new Item("Mouse", 2, 80.8));

        InvoicePrinter.print(order);
        order.sendConfirmationEmail();

        // Pedido da Maria
        Client clientMaria = new Client("Maria", "maria@email.com");
        Order orderMaria = new Order(clientMaria, 0.05);

        orderMaria.addItem(new Item("Memória RAM 16GB", 2, 280.0));
        orderMaria.addItem(new Item("Cabo HDMI 2m", 1, 45.50));
        orderMaria.addItem(new Item("Pendrive 16GB", 3, 25.00));

        InvoicePrinter.print(orderMaria);
        orderMaria.sendConfirmationEmail();
    }
}
