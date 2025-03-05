package module_6.gradually_decreasing_carousel.test.java.com.epam.rd.autotasks;

import module_6.gradually_decreasing_carousel.main.DecrementingCarousel;
import module_6.gradually_decreasing_carousel.main.GraduallyDecreasingCarousel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CodeComplianceTest {

    @Test
    void testInheritance() {
        assertEquals(DecrementingCarousel.class, GraduallyDecreasingCarousel.class.getSuperclass());
    }
}
