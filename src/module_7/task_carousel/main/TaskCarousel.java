package module_7.task_carousel.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас TaskCarousel представляє обмежену за розміром карусель завдань,
 * у якій завдання виконуються циклічно.
 */
public class TaskCarousel {
    private final int capacity;
    private final List<Task> tasks;
    private int currentIndex;

    /**
     * Створює карусель із заданою місткістю.
     *
     * @param capacity максимальна кількість завдань у каруселі
     */
    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        this.tasks = new ArrayList<>();
        currentIndex = 0;
    }

    /**
     * Додає завдання до каруселі, якщо є вільне місце та завдання не завершене.
     *
     * @param task завдання для додавання
     * @return true, якщо завдання успішно додане, інакше false
     */
    public boolean addTask(Task task) {
        if (task == null || task.isFinished() || isFull()) {
            return false;
        }
        tasks.add(task);
        return true;
    }

    /**
     * Виконує поточне завдання у каруселі.
     * Якщо завдання завершується після виконання, воно видаляється.
     * Інакше індекс зміщується на наступне завдання у циклі.
     *
     * @return true, якщо виконання відбулося, інакше false (якщо немає завдань)
     */
    public boolean execute() {
        if (tasks.isEmpty()) {
            return false;
        }

        // Виконати поточне завдання
        Task currentTask = tasks.get(currentIndex);
        currentTask.execute();

        // Видалити, якщо завершилося
        if (currentTask.isFinished()) {
            tasks.remove(currentIndex);
            if (tasks.isEmpty()) {
                return true;
            }
            // Коригуємо індекс, якщо видалили останнє завдання
            if (currentIndex >= tasks.size()) {
                currentIndex = 0;
            }
        } else {
            // Переміщуємося до наступного завдання (циркулярно)
            currentIndex = (currentIndex + 1) % tasks.size();
        }
        return true;
    }

    /**
     * Перевіряє, чи карусель заповнена.
     *
     * @return true, якщо кількість завдань досягла місткості, інакше false
     */
    public boolean isFull() {
        return tasks.size() >= capacity;
    }

    /**
     * Перевіряє, чи карусель порожня.
     *
     * @return true, якщо в каруселі немає завдань, інакше false
     */
    public boolean isEmpty() {
        return tasks.isEmpty();
    }
}

