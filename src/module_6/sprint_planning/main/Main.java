package module_6.sprint_planning.main;


import module_6.sprint_planning.main.tickets.Bug;
import module_6.sprint_planning.main.tickets.UserStory;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sprint sprint = new Sprint(20, 5); // Ліміт: 20 годин, 5 тікетів

        UserStory us1 = new UserStory(1, "Login Feature", 8);
        UserStory us2 = new UserStory(2, "Profile Page", 6, us1);
        UserStory us3 = new UserStory(3, "Settings Page", 7);

        us1.complete(); // Завершуємо історію, щоб перевірити додавання бага

        Bug bug1 = Bug.createBug(4, "Fix login button", 3, us1);
        Bug bug2 = Bug.createBug(5, "Fix profile picture", 2, us2);

        System.out.println(sprint.addUserStory(us1)); // true ✅ (немає залежностей)
        System.out.println(sprint.addUserStory(us2)); // false ❌ (залежність не в спринті)
        System.out.println(sprint.addUserStory(us3)); // true ✅ (немає залежностей)

        System.out.println(sprint.addBug(bug1)); // true ✅ (пов’язаний із завершеною історією)
        System.out.println(sprint.addBug(bug2)); // false ❌ (залежна історія не в спринті)

        System.out.println(Arrays.toString(sprint.getTickets()));

    }
}
