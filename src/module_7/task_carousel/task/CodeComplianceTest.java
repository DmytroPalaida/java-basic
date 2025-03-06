package module_7.task_carousel.task;

import module_7.task_carousel.main.CompleteByRequestTask;
import module_7.task_carousel.main.CountDownTask;
import module_7.task_carousel.main.Task;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CodeComplianceTest {
    @Test
    void testTaskIsInterface() {
        assertTrue(Task.class.isInterface());
    }

    @Test
    void testImplementsTask() {
        assertTrue(Arrays.asList(CountDownTask.class.getInterfaces()).contains(Task.class));
        assertTrue(Arrays.asList(CompleteByRequestTask.class.getInterfaces()).contains(Task.class));
    }
}
