package module_7.task_carousel.main;

public class CompleteByRequestTask implements Task {
    private boolean completeRequested = false;
    private boolean finished = false;

    @Override
    public void execute() {
        if (completeRequested) {
            finished = true;   // Завершуємо завдання тільки після complete() і наступного execute()
        }
    }

    public void complete() {
        completeRequested = true; // Позначаємо, що потрібно завершити завдання при наступному execute()
    }

    @Override
    public boolean isFinished() {
        return finished;
    }
}
