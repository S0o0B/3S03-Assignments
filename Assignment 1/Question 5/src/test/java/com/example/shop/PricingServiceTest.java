package com.example.shop;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class PricingServiceTest {

    private PricingService pricingService;

    @Before
    public void setUp() {
        pricingService = new PricingService();
    }

    @Test
    public void testCalculateSubtotal_singleItem() {
        Order order = new Order();
        order.addItem(new OrderItem("Book", 2, 10.00));
        assertEquals(20.00, pricingService.calculateSubtotal(order), 0.0001);
    }

    @Test
    public void testCalculateSubtotal_multipleItems() {
        Order order = new Order();
        order.addItem(new OrderItem("Book", 2, 10.00));
        order.addItem(new OrderItem("Pen", 3, 2.00));
        assertEquals(26.00, pricingService.calculateSubtotal(order), 0.0001);
    }

    @Test
    public void testCalculateSubtotal_emptyOrder() {
        Order order = new Order();
        assertEquals(0.00, pricingService.calculateSubtotal(order), 0.0001);
    }

    @Test
    public void testCalculateSubtotal_freeItems() {
        Order order = new Order();
        order.addItem(new OrderItem("Sample", 5, 0.00));
        assertEquals(0.00, pricingService.calculateSubtotal(order), 0.0001);
    }

    @Test
    public void testCalculateTax_standardAmount() {
        assertEquals(20.00, pricingService.calculateTax(100.00), 0.0001);
    }

    @Test
    public void testCalculateTax_zeroSubtotal() {
        assertEquals(0.00, pricingService.calculateTax(0.00), 0.0001);
    }

    @Test
    public void testCalculateTax_fractionalAmount() {
        assertEquals(10.10, pricingService.calculateTax(50.50), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateTax_throwsOnNegativeSubtotal() {
        pricingService.calculateTax(-1.00);
    }

    @Test
    public void testCalculateTax_largeAmount() {
        assertEquals(200.00, pricingService.calculateTax(1000.00), 0.0001);
    }
}