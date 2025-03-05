package module_6.halving_decreasing_carousel.test.java;


import module_6.halving_decreasing_carousel.main.DecrementingCarousel;
import module_6.halving_decreasing_carousel.main.HalvingCarousel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CodeComplianceTest {

    @Test
    void testInheritance() {
        assertEquals(DecrementingCarousel.class, HalvingCarousel.class.getSuperclass());
    }
}
