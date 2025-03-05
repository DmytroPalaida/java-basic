package module_6.sprint_planning.main.tickets;

import java.util.Arrays;

public class UserStory extends Ticket {

    // Масив залежностей, тобто інших UserStory, які повинні бути завершені першими
    //🔹 Bug завжди має бути прив'язаний до якоїсь UserStory.
    //🔹 Це поле final, тому його не можна змінити після створення.
    private final UserStory[] dependencies;

    // Конструктор класу, що ініціалізує ідентифікатор, назву, оцінку часу та залежності
    // Arrays.copyOf() створює новий масив тієї ж довжини та копіює значення з dependsOn.
    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        // Робимо копію переданого масиву залежностей, щоб уникнути зміни оригінального масиву
        this.dependencies = Arrays.copyOf(dependsOn, dependsOn.length);
    }

    // Перевизначений метод завершення тікету
    //Метод намагається завершити (complete) UserStory, але тільки якщо всі її залежності
    // (dependencies) вже завершені.
    //Перебирає всі залежності у for-each циклі.
    //Якщо хоча б одна залежність не завершена, метод просто return, тобто виходить без змін.
    //Якщо всі залежності завершені, змінна completed стає true.
    @Override
    public void complete() {
        // Перевіряємо, чи всі залежності завершені
        for (UserStory dependency : dependencies) {
            if (!dependency.isCompleted()) {
                return;
            }
        }
        // Якщо всі залежності завершені, позначаємо історію користувача як завершену
        completed = true;
    }

    // Повертає копію масиву залежностей, щоб захистити оригінальні дані
    //Повертає копію масиву залежностей, а не сам оригінальний масив.
    //Це потрібно для захисту від зовнішніх змін: якщо просто повернути dependencies,
    // його можна було б змінити ззовні.
    public UserStory[] getDependencies() {
        return Arrays.copyOf(dependencies, dependencies.length);
    }

    // Перевизначений метод toString(), що повертає рядкове представлення історії користувача
    @Override
    public String toString() {
        return "[US " + getId() + "] " + getName();
    }
}
