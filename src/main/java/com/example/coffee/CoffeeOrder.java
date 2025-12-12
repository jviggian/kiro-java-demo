package com.example.coffee;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class CoffeeOrder {
    private final String orderId;
    private final Size size;
    private final GrindType grindType;
    private final CoffeeType coffeeType;
    private final Set<Addition> additions;

    public CoffeeOrder(Size size, GrindType grindType, CoffeeType coffeeType, 
                       Set<Addition> additions) {
        this.orderId = UUID.randomUUID().toString();
        this.size = Objects.requireNonNull(size, "Size cannot be null");
        this.grindType = Objects.requireNonNull(grindType, "Grind type cannot be null");
        this.coffeeType = Objects.requireNonNull(coffeeType, "Coffee type cannot be null");
        this.additions = additions == null ? new HashSet<>() : new HashSet<>(additions);
    }

    public String getOrderId() {
        return orderId;
    }

    public Size getSize() {
        return size;
    }

    public GrindType getGrindType() {
        return grindType;
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

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
        sb.append("  Grind Type: ").append(grindType).append("\n");
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
