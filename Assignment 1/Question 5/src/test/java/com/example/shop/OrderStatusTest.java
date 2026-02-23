package com.example.shop;

import org.junit.Test;
import static org.junit.Assert.*;

public class OrderStatusTest {

    @Test
    public void testEnumHasCreatedStatus() {
        assertNotNull("CREATED status should exist", OrderStatus.CREATED);
    }

    @Test
    public void testEnumHasPaidStatus() {
        assertNotNull("PAID status should exist", OrderStatus.PAID);
    }

    @Test
    public void testEnumHasCancelledStatus() {
        assertNotNull("CANCELLED status should exist", OrderStatus.CANCELLED);
    }

    @Test
    public void testEnumHasExactlyThreeValues() {
        assertEquals("OrderStatus should have exactly 3 values", 3, OrderStatus.values().length);
    }

    @Test
    public void testValueOf_created() {
        assertEquals(OrderStatus.CREATED, OrderStatus.valueOf("CREATED"));
    }

    @Test
    public void testValueOf_paid() {
        assertEquals(OrderStatus.PAID, OrderStatus.valueOf("PAID"));
    }

    @Test
    public void testValueOf_cancelled() {
        assertEquals(OrderStatus.CANCELLED, OrderStatus.valueOf("CANCELLED"));
    }

    @Test
    public void testOrderStartsWithCreatedStatus() {
        Order order = new Order();
        assertEquals(OrderStatus.CREATED, order.getStatus());
    }

    @Test
    public void testOrderStatusTransitionToPaid() {
        Order order = new Order();
        order.setStatus(OrderStatus.PAID);
        assertEquals(OrderStatus.PAID, order.getStatus());
    }

    @Test
    public void testOrderStatusTransitionToCancelled() {
        Order order = new Order();
        order.setStatus(OrderStatus.CANCELLED);
        assertEquals(OrderStatus.CANCELLED, order.getStatus());
    }
}