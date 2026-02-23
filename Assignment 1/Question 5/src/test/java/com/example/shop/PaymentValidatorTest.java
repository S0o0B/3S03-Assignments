package com.example.shop;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class PaymentValidatorTest {

    private PaymentValidator paymentValidator;

    @Before
    public void setUp() {
        paymentValidator = new PaymentValidator();
    }

    @Test
    public void testIsPaymentMethodValid_card_returnsTrue() {
        assertTrue("'card' should be a valid payment method", paymentValidator.isPaymentMethodValid("card"));
    }

    @Test
    public void testIsPaymentMethodValid_cardUppercase_returnsTrue() {
        assertTrue("'CARD' should be valid (case insensitive)", paymentValidator.isPaymentMethodValid("CARD"));
    }

    @Test
    public void testIsPaymentMethodValid_paypal_returnsTrue() {
        assertTrue("'paypal' should be a valid payment method", paymentValidator.isPaymentMethodValid("paypal"));
    }

    @Test
    public void testIsPaymentMethodValid_paypalUppercase_returnsTrue() {
        assertTrue("'PAYPAL' should be valid (case insensitive)", paymentValidator.isPaymentMethodValid("PAYPAL"));
    }

    @Test
    public void testIsPaymentMethodValid_crypto_returnsFalse() {
        assertFalse("'crypto' should not be a valid payment method", paymentValidator.isPaymentMethodValid("crypto"));
    }

    @Test
    public void testIsPaymentMethodValid_null_returnsFalse() {
        assertFalse("null should not be a valid payment method", paymentValidator.isPaymentMethodValid(null));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testIsPaymentMethodValid_unknown_throwsException() {
        paymentValidator.isPaymentMethodValid("bitcoin");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testIsPaymentMethodValid_emptyString_throwsException() {
        paymentValidator.isPaymentMethodValid("");
    }
}