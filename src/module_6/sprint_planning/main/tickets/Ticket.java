package module_6.sprint_planning.main.tickets;

public class Ticket {
    // Унікальний ідентифікатор квитка (тікету)
    private final int id;
    // Назва тікету
    private final String name;

    // Чи завершено тікет (захищене поле, доступне для підкласів)
    protected boolean completed;

    // Оцінка часу (в годинах), необхідного для виконання тікету
    private final int estimate;

    // Конструктор класу, що ініціалізує всі поля
    public Ticket(int id, String name, int estimate) {
        this.id = id;
        this.name = name;
        this.estimate = estimate;
    }

    // Повертає ідентифікатор тікету
    public int getId() {
        return id;
    }

    // Повертає назву тікету
    public String getName() {
        return name;
    }

    // Повертає оцінку часу виконання тікету
    public int getEstimate() {
        return estimate;
    }

    // Перевіряє, чи завершено тікет
    public boolean isCompleted() {
        return completed;
    }

    // Позначає тікет як завершений
    public void complete() {
        completed = true;
    }
}
