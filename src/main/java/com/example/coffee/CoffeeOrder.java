package com.example.coffee;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * Represents a coffee order with size, grind type, coffee type, and optional additions.
 * Each order is assigned a unique identifier upon creation.
 */
public class CoffeeOrder {
    private final String orderId;
    private final Size size;
    private final GrindType grindType;
    private final CoffeeType coffeeType;
    private final Set<Addition> additions;

    /**
     * Creates a new coffee order with the specified parameters.
     * 
     * @param size the size of the coffee order (cannot be null)
     * @param grindType the grind type for the coffee (cannot be null)
     * @param coffeeType the type of coffee (cannot be null)
     * @param additions optional set of additions; null is treated as empty set
     * @throws NullPointerException if size, grindType, or coffeeType is null
     */
    public CoffeeOrder(Size size, GrindType grindType, CoffeeType coffeeType, 
                       Set<Addition> additions) {
        this.orderId = UUID.randomUUID().toString();
        this.size = Objects.requireNonNull(size, "Size cannot be null");
        this.grindType = Objects.requireNonNull(grindType, "Grind type cannot be null");
        this.coffeeType = Objects.requireNonNull(coffeeType, "Coffee type cannot be null");
        this.additions = additions == null ? new HashSet<>() : new HashSet<>(additions);
    }

    /**
     * Gets the unique identifier for this order.
     * 
     * @return the order ID as a string
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Gets the size of this coffee order.
     * 
     * @return the size of the order
     */
    public Size getSize() {
        return size;
    }

    /**
     * Gets the grind type for this coffee order.
     * 
     * @return the grind type
     */
    public GrindType getGrindType() {
        return grindType;
    }

    /**
     * Gets the coffee type for this order.
     * 
     * @return the coffee type
     */
    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    /**
     * Gets an immutable set of additions for this order.
     * 
     * @return an unmodifiable set of additions
     */
    public Set<Addition> getAdditions() {
        return Collections.unmodifiableSet(additions);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoffeeOrder that = (CoffeeOrder) o;
        return Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(orderId).append("\n");
        sb.append("  Size: ").append(size).append("\n");
        if (grindType != GrindType.NONE) {
            sb.append("  Grind Type: ").append(grindType).append("\n");
        }
        sb.append("  Coffee Type: ").append(coffeeType).append("\n");
        if (!additions.isEmpty()) {
            sb.append("  Additions: ");
            sb.append(String.join(", ", additions.stream()
                    .map(Addition::getDisplayName)
                    .toList()));
            sb.append("\n");
        } else {
            sb.append("  Additions: None\n");
        }
        return sb.toString();
    }
}
