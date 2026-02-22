package com.example.shop;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class DiscountServiceTest {

    private DiscountService discountService;

    @Before
    public void setUp() {
        discountService = new DiscountService();
    }

    @Test
    public void applyDiscount_WithNullDiscountCode_ShouldReturnSubtotal() {
        double result = discountService.applyDiscount(100.0, null);
        assertEquals(100.0, result, 0.001);
    }

    @Test
    public void applyDiscount_WithEmptyDiscountCode_ShouldReturnSubtotal() {
        double result = discountService.applyDiscount(100.0, "");
        assertEquals(100.0, result, 0.001);
    }

    @Test
    public void applyDiscount_WithBlankDiscountCode_ShouldReturnSubtotal() {
        double result = discountService.applyDiscount(100.0, "   ");
        assertEquals(100.0, result, 0.001);
    }

    @Test
    public void applyDiscount_WithStudent10Code_ShouldApply10PercentDiscount() {
        double result = discountService.applyDiscount(100.0, "STUDENT10");
        assertEquals(90.0, result, 0.001);
    }

    @Test
    public void applyDiscount_WithStudent10LowerCase_ShouldApply10PercentDiscount() {
        double result = discountService.applyDiscount(100.0, "student10");
        assertEquals(90.0, result, 0.001);
    }

    @Test
    public void applyDiscount_WithBlackFridayCode_ShouldApply30PercentDiscount() {
        double result = discountService.applyDiscount(200.0, "BLACKFRIDAY");
        assertEquals(140.0, result, 0.001);
    }

    @Test
    public void applyDiscount_WithBlackFridayLowerCase_ShouldApply30PercentDiscount() {
        double result = discountService.applyDiscount(200.0, "blackfriday");
        assertEquals(140.0, result, 0.001);
    }

    @Test
    public void applyDiscount_WithInvalidCode_ShouldThrowIllegalArgumentException() {
        try {
            discountService.applyDiscount(100.0, "INVALID");
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid discount code", e.getMessage());
        }
    }

    @Test
    public void applyDiscount_WithInvalidCodeLowerCase_ShouldThrowIllegalArgumentException() {
        try {
            discountService.applyDiscount(100.0, "invalid");
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid discount code", e.getMessage());
        }
    }

    @Test
    public void applyDiscount_WithUnknownCode_ShouldReturnSubtotal() {
        double result = discountService.applyDiscount(150.0, "SUMMER2024");
        assertEquals(150.0, result, 0.001);
    }

    @Test
    public void applyDiscount_WithZeroSubtotal_ShouldReturnZero() {
        double result = discountService.applyDiscount(0.0, "STUDENT10");
        assertEquals(0.0, result, 0.001);
    }

    @Test
    public void applyDiscount_WithNegativeSubtotal_ShouldReturnNegativeDiscountedValue() {
        double result = discountService.applyDiscount(-100.0, "STUDENT10");
        assertEquals(-90.0, result, 0.001);
    }

    @Test
    public void applyDiscount_WithDecimalSubtotalAndStudent10_ShouldCalculateCorrectly() {
        double result = discountService.applyDiscount(99.99, "STUDENT10");
        assertEquals(89.991, result, 0.001);
    }

    @Test
    public void applyDiscount_WithDecimalSubtotalAndBlackFriday_ShouldCalculateCorrectly() {
        double result = discountService.applyDiscount(99.99, "BLACKFRIDAY");
        assertEquals(69.993, result, 0.001);
    }

    @Test
    public void applyDiscount_WithLargeSubtotal_ShouldHandleCorrectly() {
        double subtotal = 1000000.0;
        double result = discountService.applyDiscount(subtotal, "BLACKFRIDAY");
        assertEquals(700000.0, result, 0.001);
    }
}