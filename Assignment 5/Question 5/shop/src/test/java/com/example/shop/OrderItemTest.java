package com.example.shop;

import org.junit.Test;
import static org.junit.Assert.*;

public class OrderItemTest {

    @Test
    public void testTotalPrice_normalValues() {
        OrderItem item = new OrderItem("Book", 3, 10.00);
        assertEquals(30.00, item.getTotalPrice(), 0.0001);
    }

    @Test
    public void testTotalPrice_singleItem() {
        OrderItem item = new OrderItem("Pen", 1, 2.50);
        assertEquals(2.50, item.getTotalPrice(), 0.0001);
    }

    @Test
    public void testTotalPrice_zeroPriceItem() {
        OrderItem item = new OrderItem("Freebie", 5, 0.00);
        assertEquals(0.00, item.getTotalPrice(), 0.0001);
    }

    @Test
    public void testGetQuantity_returnsCorrectQuantity() {
        OrderItem item = new OrderItem("Mug", 4, 8.00);
        assertEquals(4, item.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_throwsWhenQuantityIsZero() {
        new OrderItem("Widget", 0, 5.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_throwsWhenQuantityIsNegative() {
        new OrderItem("Widget", -1, 5.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_throwsWhenUnitPriceIsNegative() {
        new OrderItem("Widget", 1, -1.00);
    }

    @Test
    public void testTotalPrice_largeQuantity() {
        OrderItem item = new OrderItem("Bolt", 1000, 0.50);
        assertEquals(500.00, item.getTotalPrice(), 0.0001);
    }

    @Test
    public void testTotalPrice_fractionalPrice() {
        OrderItem item = new OrderItem("Screw", 3, 1.99);
        assertEquals(5.97, item.getTotalPrice(), 0.0001);
    }
}