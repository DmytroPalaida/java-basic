package module_6.gradually_decreasing_carousel.main;

import java.util.List;

/**
 * Клас, який реалізує виконання циклічного зменшення елементів у списку.
 */
public class CarouselRun {
    protected int[] list;
    protected int index;

    /**
     * Конструктор, який ініціалізує список чисел для виконання циклу.
     *
     * @param element список цілих чисел, які будуть оброблятися.
     */
    public CarouselRun(List<Integer> element) {
        this.list = new int[element.size()];
        for (int i = 0; i < element.size(); i++) {
            list[i] = element.get(i);
        }
        this.index = 0;
    }

    /**
     * Повертає наступне значення в каруселі, зменшуючи його на 1.
     * Якщо всі елементи дорівнюють 0, повертає -1.
     *
     * @return наступне значення або -1, якщо всі елементи 0.
     */
    public int next() {
        if (isFinished()){
            return -1;
        }
        int startIndex = index;
        while (list[index] == 0){
            index = (index + 1) % list.length;
            if (startIndex == index){
                return -1;
            }
        }
        int result = list[index];
        list[index] = Math.max(0, list[index] - 1);
        index = (index + 1) % list.length;
        return result;
    }

    /**
     * Перевіряє, чи всі елементи в списку стали рівними 0.
     *
     * @return true, якщо всі елементи 0, інакше false.
     */
    public boolean isFinished() {
        for (int el : list)
            if (el > 0) {
                return false;
            }
        return true;
    }
}

