package module_7.task_carousel.main;

public class CountDownTask implements Task {
    private int value;

    public CountDownTask(int value) {
        this.value = Math.max(0, value);
    }

    public int getValue() {
        return value;
    }


    @Override
    public void execute() {
        if (!isFinished()) { // Зменшуємо лише якщо ще не досягли 0
            value--;
        }
    }
    @Override
    public boolean isFinished() {
        return value == 0;
    }
}
