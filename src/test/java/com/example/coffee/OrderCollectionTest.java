package com.example.coffee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OrderCollectionTest {

    private OrderCollection orderCollection;
    private CoffeeOrder testOrder1;
    private CoffeeOrder testOrder2;

    @BeforeEach
    void setUp() {
        orderCollection = new OrderCollection();
        testOrder1 = new CoffeeOrder(
            Size.SMALL, 
            GrindType.FINE, 
            CoffeeType.ESPRESSO, 
            new HashSet<>()
        );
        testOrder2 = new CoffeeOrder(
            Size.LARGE, 
            GrindType.COARSE, 
            CoffeeType.BLEND, 
            new HashSet<>()
        );
    }

    @Test
    @DisplayName("Should create empty order collection")
    void shouldCreateEmptyOrderCollection() {
        assertTrue(orderCollection.isEmpty());
        assertEquals(0, orderCollection.getOrderCount());
    }

    @Test
    @DisplayName("Should add order to collection")
    void shouldAddOrderToCollection() {
        orderCollection.addOrder(testOrder1);
        
        assertEquals(1, orderCollection.getOrderCount());
        assertFalse(orderCollection.isEmpty());
    }

    @Test
    @DisplayName("Should throw exception when adding null order")
    void shouldThrowExceptionWhenAddingNullOrder() {
        assertThrows(IllegalArgumentException.class, () -> {
            orderCollection.addOrder(null);
        });
    }

    @Test
    @DisplayName("Should add multiple orders to collection")
    void shouldAddMultipleOrdersToCollection() {
        orderCollection.addOrder(testOrder1);
        orderCollection.addOrder(testOrder2);
        
        assertEquals(2, orderCollection.getOrderCount());
        assertFalse(orderCollection.isEmpty());
    }

    @Test
    @DisplayName("Should return all orders")
    void shouldReturnAllOrders() {
        orderCollection.addOrder(testOrder1);
        orderCollection.addOrder(testOrder2);
        
        List<CoffeeOrder> orders = orderCollection.getAllOrders();
        
        assertEquals(2, orders.size());
        assertTrue(orders.contains(testOrder1));
        assertTrue(orders.contains(testOrder2));
    }

    @Test
    @DisplayName("Should return immutable list of orders")
    void shouldReturnImmutableListOfOrders() {
        orderCollection.addOrder(testOrder1);
        
        List<CoffeeOrder> orders = orderCollection.getAllOrders();
        
        assertThrows(UnsupportedOperationException.class, () -> {
            orders.add(testOrder2);
        });
    }

    @Test
    @DisplayName("Should find order by ID")
    void shouldFindOrderById() {
        orderCollection.addOrder(testOrder1);
        orderCollection.addOrder(testOrder2);
        
        Optional<CoffeeOrder> found = orderCollection.getOrderById(testOrder1.getOrderId());
        
        assertTrue(found.isPresent());
        assertEquals(testOrder1, found.get());
    }

    @Test
    @DisplayName("Should return empty optional when order ID not found")
    void shouldReturnEmptyOptionalWhenOrderIdNotFound() {
        orderCollection.addOrder(testOrder1);
        
        Optional<CoffeeOrder> found = orderCollection.getOrderById("non-existent-id");
        
        assertFalse(found.isPresent());
    }

    @Test
    @DisplayName("Should return empty optional when order ID is null")
    void shouldReturnEmptyOptionalWhenOrderIdIsNull() {
        orderCollection.addOrder(testOrder1);
        
        Optional<CoffeeOrder> found = orderCollection.getOrderById(null);
        
        assertFalse(found.isPresent());
    }

    @Test
    @DisplayName("Should clear all orders")
    void shouldClearAllOrders() {
        orderCollection.addOrder(testOrder1);
        orderCollection.addOrder(testOrder2);
        
        orderCollection.clear();
        
        assertTrue(orderCollection.isEmpty());
        assertEquals(0, orderCollection.getOrderCount());
    }

    @Test
    @DisplayName("Should remove order by ID")
    void shouldRemoveOrderById() {
        orderCollection.addOrder(testOrder1);
        orderCollection.addOrder(testOrder2);
        
        boolean removed = orderCollection.removeOrder(testOrder1.getOrderId());
        
        assertTrue(removed);
        assertEquals(1, orderCollection.getOrderCount());
        assertFalse(orderCollection.getOrderById(testOrder1.getOrderId()).isPresent());
        assertTrue(orderCollection.getOrderById(testOrder2.getOrderId()).isPresent());
    }

    @Test
    @DisplayName("Should return false when removing non-existent order")
    void shouldReturnFalseWhenRemovingNonExistentOrder() {
        orderCollection.addOrder(testOrder1);
        
        boolean removed = orderCollection.removeOrder("non-existent-id");
        
        assertFalse(removed);
        assertEquals(1, orderCollection.getOrderCount());
    }

    @Test
    @DisplayName("Should return false when removing with null ID")
    void shouldReturnFalseWhenRemovingWithNullId() {
        orderCollection.addOrder(testOrder1);
        
        boolean removed = orderCollection.removeOrder(null);
        
        assertFalse(removed);
        assertEquals(1, orderCollection.getOrderCount());
    }

    @Test
    @DisplayName("Should maintain order of additions")
    void shouldMaintainOrderOfAdditions() {
        orderCollection.addOrder(testOrder1);
        orderCollection.addOrder(testOrder2);
        
        List<CoffeeOrder> orders = orderCollection.getAllOrders();
        
        assertEquals(testOrder1, orders.get(0));
        assertEquals(testOrder2, orders.get(1));
    }

    @Test
    @DisplayName("Should handle large number of orders")
    void shouldHandleLargeNumberOfOrders() {
        for (int i = 0; i < 100; i++) {
            CoffeeOrder order = new CoffeeOrder(
                Size.MEDIUM, 
                GrindType.MEDIUM, 
                CoffeeType.ARABICA, 
                new HashSet<>()
            );
            orderCollection.addOrder(order);
        }
        
        assertEquals(100, orderCollection.getOrderCount());
    }

    @Test
    @DisplayName("Should return correct count after multiple operations")
    void shouldReturnCorrectCountAfterMultipleOperations() {
        orderCollection.addOrder(testOrder1);
        orderCollection.addOrder(testOrder2);
        assertEquals(2, orderCollection.getOrderCount());
        
        orderCollection.removeOrder(testOrder1.getOrderId());
        assertEquals(1, orderCollection.getOrderCount());
        
        CoffeeOrder testOrder3 = new CoffeeOrder(
            Size.MEDIUM, 
            GrindType.MEDIUM, 
            CoffeeType.ARABICA, 
            new HashSet<>()
        );
        orderCollection.addOrder(testOrder3);
        assertEquals(2, orderCollection.getOrderCount());
        
        orderCollection.clear();
        assertEquals(0, orderCollection.getOrderCount());
    }

    @Test
    @DisplayName("Should handle isEmpty correctly")
    void shouldHandleIsEmptyCorrectly() {
        assertTrue(orderCollection.isEmpty());
        
        orderCollection.addOrder(testOrder1);
        assertFalse(orderCollection.isEmpty());
        
        orderCollection.clear();
        assertTrue(orderCollection.isEmpty());
    }
}
