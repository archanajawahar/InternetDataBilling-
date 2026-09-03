package com.billing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class InternetDataBillingTest {

    @Test
    void testBasicWithinLimit() {
        assertEquals(399, 
            InternetDataBilling.calculateBill("basic", 40));
    }

    @Test
    void testBasicExceedsLimit() {
        assertEquals(499, 
            InternetDataBilling.calculateBill("basic", 60));
    }

    @Test
    void testStandardWithinLimit() {
        assertEquals(599, 
            InternetDataBilling.calculateBill("standard", 80));
    }

    @Test
    void testPremiumExceedsLimit() {
        assertEquals(949, 
            InternetDataBilling.calculateBill("premium", 210));
    }

    @Test
    void testInvalidPlan() {
        assertThrows(IllegalArgumentException.class, () ->
            InternetDataBilling.calculateBill("gold", 50));
    }
}
