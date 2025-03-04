package module_6.main;

import java.util.ArrayList;
import java.util.List;

public class DecrementingCarousel {
    private final int capacity;
    protected boolean isRun;
    protected final List<Integer> list;

    public DecrementingCarousel(int capacity) {
        this.capacity = capacity;
        this.isRun = false;
        this.list = new ArrayList<>(capacity);
    }

    public boolean addElement(int element) {
        if (element <= 0 || list.size() >= capacity || isRun) {
            return false;
        }
        list.add(element);
        return true;
    }

    public CarouselRun run() {
        if (isRun) {
            return null;
        }
        isRun = true;
        return new CarouselRun(list);
    }
}
