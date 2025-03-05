package module_6.sprint_planning.main;


import module_6.sprint_planning.main.tickets.Bug;
import module_6.sprint_planning.main.tickets.Ticket;
import module_6.sprint_planning.main.tickets.UserStory;

public class Sprint {
    /*
    🔹 timeCapacity – максимальний сумарний час, який можна витратити на тікети.
    🔹 ticketLimit – обмеження кількості тікетів у спринті.
    🔹 tickets – масив фіксованого розміру, що зберігає тікети (UserStory і Bug).
    🔹 ticketCount – відстежує кількість доданих тікетів.
     */

    // Максимальна загальна оцінка часу (в годинах), яку може містити спринт
    private final int timeCapacity;

    // Максимальна кількість тікетів у спринті
    private final int ticketLimit;

    // Масив для збереження тікетів, доданих у спринт
    private final Ticket[] tickets;

    // Поточна кількість тікетів у спринті
    private int ticketCount;

    // Конструктор, що ініціалізує обмеження за часом та кількістю тікетів
    public Sprint(int capacity, int ticketsLimit) {
        this.timeCapacity = capacity;
        this.ticketLimit = ticketsLimit;
        this.tickets = new Ticket[ticketsLimit]; // Масив фіксованого розміру
        this.ticketCount = 0;
    }

    // Додає історію користувача (UserStory) у спринт ||
    //Чи userStory != null і не завершена.
    //Чи всі залежності вже в спринті (isDependencyAccepted()).
    //Чи є місце в спринті (canAddTicket()).
    //🔹 Якщо всі умови виконані, додає UserStory у tickets[].
    public boolean addUserStory(UserStory userStory) {
        if (userStory == null || userStory.isCompleted()) {
            return false;
        }
        for (UserStory userStory1 : userStory.getDependencies()) {
            if (!isDependencyAccepted(userStory1)) {
                return false;
            }
        }
        if (canAddTicket(userStory.getEstimate())) {
            return false;
        }
        tickets[ticketCount++] = userStory;
        return true;
    }

    // Додає баг (Bug) у спринт ||
    //🔹 Перевіряє, що bugReport != null і не завершений.
    //🔹 Перевіряє, чи можна його додати в спринт.
    //🔹 Якщо все добре – додає баг у масив tickets[].
    public boolean addBug(Bug bugReport) {
        if (bugReport == null || bugReport.isCompleted()){
            return false;
        }
        if (canAddTicket(bugReport.getEstimate())){
            return false;
        }
        tickets[ticketCount++] = bugReport;
        return true;


    }

    // Повертає копію масиву тікетів у спринті, щоб уникнути змін оригінального масиву
    //Створює копію масиву тікетів, щоб захистити оригінальні дані.
    //🔹 Використовує System.arraycopy() для копіювання
    public Ticket[] getTickets() {
        Ticket[] ticket = new Ticket[ticketCount];
        System.arraycopy(tickets, 0, ticket, 0, ticketCount);
        return ticket;
    }

    // Обчислює загальну оцінку часу для всіх тікетів у спринті
    // Підсумовує estimate всіх тікетів у tickets[].
    //🔹 Використовується для перевірки перевищення ліміту часу
    public int getTotalEstimate() {
        int totalEstimate = 0;
        for (int i = 0; i < ticketCount; i++) {
            totalEstimate += tickets[i].getEstimate();
        }
        return totalEstimate;

    }

    // Перевіряє, чи можна додати тікет, не перевищуючи обмеження спринту
    //Чи перевищується ліміт часу timeCapacity
    //Чи перевищується кількість тікетів ticketLimit.
    //🔹 Використовується перед додаванням UserStory і Bug. ||
    private boolean canAddTicket(int estimate) {
        return (getTotalEstimate() + estimate > timeCapacity || ticketCount >= ticketLimit);
    }

    //Перевіряє, чи є залежна UserStory вже в спринті.
    //🔹 Використовується в addUserStory() перед додаванням
    // Перевіряє, чи була дана залежність (UserStory) вже додана у спринт
    // Якщо залежність вже в спринті – повертаємо true
    // Інакше – false
    private boolean isDependencyAccepted(UserStory dependency) {
        for (int i = 0; i < ticketCount; i++) {
            if (tickets[i] instanceof UserStory && tickets[i].equals(dependency)) {
                return true;
            }
        }
        return false;
    }
}

//tickets[i] instanceof UserStory: Це перевіряє, чи є об'єкт tickets[i] екземпляром класу UserStory.
//Якщо так, це означає, що цей квиток є історією користувача.

//getTotalEstimate() + estimate > timeCapacity: Це перевіряє, чи сума оцінок вже
//прийнятих квитків (отримана з getTotalEstimate()) плюс оцінка нового квитка (estimate)
//перевищує максимальну ємність часу (timeCapacity). Якщо це так, то додати новий квиток не
// можна, оскільки це призведе до переповнення.