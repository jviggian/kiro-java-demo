package com.example.coffee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * A collection that manages coffee orders, providing operations to add, 
 * retrieve, and manage orders.
 */
public class OrderCollection {
    private final List<CoffeeOrder> orders;

    /**
     * Creates a new empty order collection.
     */
    public OrderCollection() {
        this.orders = new ArrayList<>();
    }

    /**
     * Adds a coffee order to the collection.
     * 
     * @param order the coffee order to add
     * @throws IllegalArgumentException if order is null
     */
    public void addOrder(CoffeeOrder order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        orders.add(order);
    }

    /**
     * Gets an immutable list of all orders in the collection.
     * 
     * @return an unmodifiable list of all orders
     */
    public List<CoffeeOrder> getAllOrders() {
        return Collections.unmodifiableList(orders);
    }

    /**
     * Finds an order by its unique identifier.
     * 
     * @param orderId the order ID to search for
     * @return an Optional containing the order if found, empty otherwise
     */
    public Optional<CoffeeOrder> getOrderById(String orderId) {
        if (orderId == null) {
            return Optional.empty();
        }
        return orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .findFirst();
    }

    /**
     * Gets the total number of orders in the collection.
     * 
     * @return the number of orders
     */
    public int getOrderCount() {
        return orders.size();
    }

    /**
     * Checks if the collection is empty.
     * 
     * @return true if the collection contains no orders, false otherwise
     */
    public boolean isEmpty() {
        return orders.isEmpty();
    }

    /**
     * Removes all orders from the collection.
     */
    public void clear() {
        orders.clear();
    }

    /**
     * Removes an order from the collection by its ID.
     * 
     * @param orderId the ID of the order to remove
     * @return true if an order was removed, false otherwise
     */
    public boolean removeOrder(String orderId) {
        if (orderId == null) {
            return false;
        }
        return orders.removeIf(order -> order.getOrderId().equals(orderId));
    }
}
