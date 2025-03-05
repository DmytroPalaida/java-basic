package module_5.main;

import java.util.List;

public class CarouselRun {
    private int[] elements;    // масив для збереження значень елементів
    private int currentIndex;  // індекс поточного елемента

    /**
     * Конструктор приймає список елементів і копіює їх у внутрішній масив.
     * Використання масиву дозволяє змінювати значення елементів (декрементувати).
     *
     * @param elements список початкових значень елементів
     */
    public CarouselRun(List<Integer> elements) {
        this.elements = new int[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            this.elements[i] = elements.get(i);
        }
        this.currentIndex = 0;
    }

    /**
     * Повертає поточне значення елемента, потім зменшує його на один і
     * переміщує вказівник до наступного елемента за порядком вставки.
     * Пропускає елементи, значення яких дорівнює 0.
     * Якщо немає елементів для декрементування, повертає -1.
     *
     * @return поточне значення елемента або -1, якщо всі елементи вже 0.
     */
    public int next() {
        // Якщо всі елементи вже 0, повертаємо -1
        if (isFinished()) {
            return -1;
        }

        // Шукаємо наступний елемент, значення якого > 0
        int startIndex = currentIndex;
        while (elements[currentIndex] == 0) {
            currentIndex = (currentIndex + 1) % elements.length;
            // Якщо повернулися до початкової позиції, значить активного елемента немає
            if (currentIndex == startIndex) {
                return -1;
            }
        }

        // Запам'ятовуємо поточне значення, яке буде повернуте
        int result = elements[currentIndex];
        // Декрементуємо значення елемента
        elements[currentIndex] = Math.max(0, elements[currentIndex] - 1);
        // Переміщаємо вказівник до наступного елемента
        currentIndex = (currentIndex + 1) % elements.length;

        return result;
    }

    /**
     * Перевіряє, чи залишилися елементи для декрементування.
     *
     * @return true, якщо всі елементи мають значення 0; інакше false.
     */
    public boolean isFinished() {
        for (int value : elements) {
            if (value > 0) {
                return false;
            }
        }
        return true;
    }

}
