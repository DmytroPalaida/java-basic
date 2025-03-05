package module_6.sprint_planning.main.tickets;

public class Bug extends Ticket {

    // Пов'язана користувацька історія (UserStory), до якої відноситься цей баг
    private final UserStory userStory;

    // Статичний метод для створення екземпляра Bug ||
    //🔹 Це фабричний метод, який створює об'єкт Bug.
    //🔹 Перевіряє дві умови:
    //✅ userStory != null – баг не може існувати без історії користувача.
    //✅ userStory.isCompleted() – баг може бути створений тільки для завершеної історії.
    //🔹 Якщо умови не виконані, метод повертає null, тобто баг не створюється.
    //🔹 Якщо умови виконані, створюється новий Bug через приватний конструктор
    public static Bug createBug(int id, String name, int estimate, UserStory userStory) {
        // Перевіряємо, чи історія користувача не є null і чи вона завершена
        if (userStory == null || !userStory.isCompleted()) {
            return null;
        }
        // Якщо все добре, створюємо новий баг
        return new Bug(id, name, estimate, userStory);


    }

    // Приватний конструктор, доступний тільки через createBug
    //🔹 Конструктор приватний (private), щоб заборонити створення Bug напряму.
    //🔹 Його можна викликати тільки через createBug(), щоб контролювати перевірки.
    //🔹 Викликає super(...), тобто конструктор батьківського класу Ticket, ініціалізуючи:
    //
    //id – ідентифікатор бага
    //name – назва бага
    //estimate – оцінка часу на виправлення
    //🔹 Зберігає пов'язану UserStory.
    private Bug(int id, String name, int estimate, UserStory userStory) {
        super(id, name, estimate);
        this.userStory = userStory;

    }

    // Перевизначений метод toString(), що повертає текстове представлення бага
    @Override
    public String toString() {
        return "[Bug " + getId() + "] " + userStory.getName() + ": " + getName();
    }
}
