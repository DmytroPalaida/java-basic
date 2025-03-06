package module_7.task_carousel.main;

public class Main {
    public static void main(String[] args) {

        TaskCarousel carousel = new TaskCarousel(3);

        CountDownTask task1 = new CountDownTask(2);
        CountDownTask task2 = new CountDownTask(2);
        CompleteByRequestTask task3 = new CompleteByRequestTask();

        System.out.println(carousel.addTask(task1)); //true
        System.out.println(carousel.addTask(task2)); //true
        System.out.println(carousel.addTask(task3)); //true

        System.out.println(carousel.isFull()); // true

        for (int i = 0; i < 100; i++) {
            System.out.println(carousel.execute()); // true
        }

        System.out.println(task1.isFinished()); // true
        System.out.println(task2.isFinished()); // true
        System.out.println(task3.isFinished()); // false

        task3.complete();

        System.out.println(task3.isFinished()); // false
        System.out.println(carousel.execute()); // true
        System.out.println(task3.isFinished()); // true

        System.out.println(carousel.isEmpty()); // true


    }
}
