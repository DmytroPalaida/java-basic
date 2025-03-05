package module_5.main;

import java.util.ArrayList;
import java.util.List;

public class DecrementingCarousel {
    private final List<Integer> elements;
    private final int capacity;
    private boolean runCalled; // прапорець, що вказує, чи було викликано run()

    public DecrementingCarousel(int capacity) {
        this.capacity = capacity;
        this.elements = new ArrayList<>(capacity);
        this.runCalled = false;
    }

    /**
     * Додає елемент до каруселі.
     * Якщо елемент ≤ 0, контейнер заповнений або метод run() вже викликано,
     * повертає false. Інакше - додає елемент і повертає true.
     */
    public boolean addElement(int element) {
        if (element <= 0 || elements.size() >= capacity || runCalled) {
            return false;
        }
        elements.add(element);
        return true;
    }

    /**
     * Повертає об’єкт CarouselRun для повторення елементів.
     * Якщо метод уже викликано, повертає null.
     */
    public CarouselRun run() {
        if (runCalled) {
            return null;
        }
        runCalled = true;
        // Створюємо новий CarouselRun, передаючи копію елементів
        return new CarouselRun(elements);
    }
}

