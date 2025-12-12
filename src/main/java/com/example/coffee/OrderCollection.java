package com.example.coffee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OrderCollection {
    private final List<CoffeeOrder> orders;

    public OrderCollection() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(CoffeeOrder order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        orders.add(order);
    }

    public List<CoffeeOrder> getAllOrders() {
        return Collections.unmodifiableList(orders);
    }

    public Optional<CoffeeOrder> getOrderById(String orderId) {
        if (orderId == null) {
            return Optional.empty();
        }
        return orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .findFirst();
    }

    public int getOrderCount() {
        return orders.size();
    }

    public boolean isEmpty() {
        return orders.isEmpty();
    }

    public void clear() {
        orders.clear();
    }

    public boolean removeOrder(String orderId) {
        if (orderId == null) {
            return false;
        }
        return orders.removeIf(order -> order.getOrderId().equals(orderId));
    }
}
