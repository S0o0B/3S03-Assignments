package com.example.shop;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class OrderTest {

    private Order order;

    @Before
    public void setUp() {
        order = new Order();
    }

    @Test
    public void testInitialStatus_isCreated() {
        assertEquals(OrderStatus.CREATED, order.getStatus());
    }

    @Test
    public void testInitialItems_isEmpty() {
        assertTrue(order.getItems().isEmpty());
    }

    @Test
    public void testAddItem_addsSuccessfully() {
        OrderItem item = new OrderItem("Hat", 1, 15.00);
        order.addItem(item);
        assertEquals(1, order.getItems().size());
        assertEquals(item, order.getItems().get(0));
    }

    @Test
    public void testAddItem_multipleItems() {
        order.addItem(new OrderItem("Hat", 1, 15.00));
        order.addItem(new OrderItem("Scarf", 2, 10.00));
        assertEquals(2, order.getItems().size());
    }

    @Test(expected = IllegalStateException.class)
    public void testAddItem_throwsWhenStatusIsPaid() {
        order.setStatus(OrderStatus.PAID);
        order.addItem(new OrderItem("Hat", 1, 15.00));
    }

    @Test(expected = IllegalStateException.class)
    public void testAddItem_throwsWhenStatusIsCancelled() {
        order.setStatus(OrderStatus.CANCELLED);
        order.addItem(new OrderItem("Hat", 1, 15.00));
    }

    @Test
    public void testSetStatus_toPaid() {
        order.setStatus(OrderStatus.PAID);
        assertEquals(OrderStatus.PAID, order.getStatus());
    }

    @Test
    public void testSetStatus_toCancelled() {
        order.setStatus(OrderStatus.CANCELLED);
        assertEquals(OrderStatus.CANCELLED, order.getStatus());
    }
}