package com.example.shop;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class OrderServiceTest {

    private OrderService orderService;

    @Before
    public void setUp() {
        orderService = new OrderService();
    }

    private Order buildOrder(double price) {
        Order order = new Order();
        order.addItem(new OrderItem("Item", 1, price));
        return order;
    }

    @Test
    public void testProcessOrder_validCard_noDiscount_returnsCorrectTotal() {
        Order order = buildOrder(100.00);
        double total = orderService.processOrder(order, null, "card");
        assertEquals(120.00, total, 0.0001);
    }

    @Test
    public void testProcessOrder_validPaypal_noDiscount_returnsCorrectTotal() {
        Order order = buildOrder(50.00);
        double total = orderService.processOrder(order, null, "paypal");
        assertEquals(60.00, total, 0.0001);
    }

    @Test
    public void testProcessOrder_setsStatusToPaid_onSuccess() {
        Order order = buildOrder(100.00);
        orderService.processOrder(order, null, "card");
        assertEquals(OrderStatus.PAID, order.getStatus());
    }

    @Test
    public void testProcessOrder_withStudent10Discount() {
        Order order = buildOrder(100.00);
        double total = orderService.processOrder(order, "STUDENT10", "card");
        assertEquals(108.00, total, 0.0001);
    }

    @Test
    public void testProcessOrder_withBlackFridayDiscount() {
        Order order = buildOrder(100.00);
        double total = orderService.processOrder(order, "BLACKFRIDAY", "card");
        assertEquals(84.00, total, 0.0001);
    }

    @Test
    public void testProcessOrder_cryptoPayment_returnsZero() {
        Order order = buildOrder(100.00);
        double total = orderService.processOrder(order, null, "crypto");
        assertEquals(0.00, total, 0.0001);
    }

    @Test
    public void testProcessOrder_nullPayment_returnsZero() {
        Order order = buildOrder(100.00);
        double total = orderService.processOrder(order, null, null);
        assertEquals(0.00, total, 0.0001);
    }

    @Test
    public void testProcessOrder_invalidPayment_setsStatusToCancelled() {
        Order order = buildOrder(100.00);
        orderService.processOrder(order, null, "crypto");
        assertEquals(OrderStatus.CANCELLED, order.getStatus());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testProcessOrder_unknownPaymentMethod_throwsException() {
        Order order = buildOrder(100.00);
        orderService.processOrder(order, null, "cash");
    }

    @Test
    public void testProcessOrder_emptyOrder_returnsZeroTotal() {
        Order order = new Order();
        double total = orderService.processOrder(order, null, "card");
        assertEquals(0.00, total, 0.0001);
    }

    @Test
    public void testProcessOrder_multipleItems_correctTotal() {
        Order order = new Order();
        order.addItem(new OrderItem("Shirt", 2, 20.00));
        order.addItem(new OrderItem("Jeans", 1, 60.00));
        double total = orderService.processOrder(order, null, "card");
        assertEquals(120.00, total, 0.0001);
    }
}