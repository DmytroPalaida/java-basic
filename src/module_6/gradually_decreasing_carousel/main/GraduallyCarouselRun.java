package module_6.gradually_decreasing_carousel.main;

import java.util.List;

/**
 * Клас, що реалізує спеціальну версію {@link CarouselRun},
 * у якій кожен елемент зменшується поступово зі збільшенням зменшення.
 */
public class GraduallyCarouselRun extends CarouselRun {
    private final int[] decrements;

    /**
     * Конструктор, що ініціалізує карусель із поступовим зменшенням.
     *
     * @param element список чисел, які будуть оброблятися.
     */
    public GraduallyCarouselRun(List<Integer> element) {
        super(element);
        this.decrements = new int[element.size()];
    }

    /**
     * Повертає наступне значення в каруселі, зменшуючи його поступово
     * (кожен наступний раз елемент зменшується на одиницю більше, ніж попередній раз).
     * Якщо всі елементи дорівнюють 0, повертає -1.
     *
     * @return наступне значення або -1, якщо всі елементи 0.
     */
    @Override
    public int next() {
        if (isFinished()) {
            return -1;
        }
        int startIndex = index;
        while (list[index] == 0) {
            index = (index + 1) % list.length;
            if (index == startIndex) {
                return -1;
            }
        }
        int result = list[index];
        int decrement = ++decrements[index];
        list[index] = Math.max(0, list[index] - decrement);
        index = (index + 1) % list.length;
        return result;
    }
}
