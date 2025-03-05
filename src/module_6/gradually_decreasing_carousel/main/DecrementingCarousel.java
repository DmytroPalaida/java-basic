package module_6.gradually_decreasing_carousel.main;

import java.util.ArrayList;
import java.util.List;


/**
 * Клас, який представляє карусель, що зменшує значення елементів на 1 при кожному циклі.
 */
public class DecrementingCarousel {
    protected List<Integer> list;
    protected int capacity;
    protected boolean isRun;

    /**
     * Конструктор, що ініціалізує карусель із заданою місткістю.
     *
     * @param capacity максимальна кількість елементів у каруселі.
     */
    public DecrementingCarousel(int capacity) {
        this.capacity = capacity;
        this.isRun = false;
        this.list = new ArrayList<>(capacity);
    }

    /**
     * Додає елемент до каруселі, якщо це можливо.
     *
     * @param element значення, яке додається (має бути більше 0).
     * @return true, якщо елемент успішно додано, інакше false.
     */
    public boolean addElement(int element) {
        if (element <= 0 || list.size() >= capacity || isRun) {
            return false;
        }
        list.add(element);
        return true;
    }

    /**
     * Запускає карусель, створюючи об'єкт {@link CarouselRun}.
     * Карусель можна запустити лише один раз.
     *
     * @return об'єкт {@link CarouselRun} або null, якщо карусель вже була запущена.
     */
    public CarouselRun run() {
        if (isRun) {
            return null;
        }
        isRun = true;
        return new CarouselRun(list);
    }
}