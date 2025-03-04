package module_6.main;

import java.util.List;

public class CarouselRun {
    protected final int[] list;
    protected int index;

    public CarouselRun(List<Integer> element) {
        this.list = new int[element.size()];
        for (int i = 0; i < element.size(); i++) {
            list[i] = element.get(i);
        }
        this.index = 0;
    }

    public int next() {
        if (isFinished()) {
            return -1;
        }
        int startIndex = index;
        while (list[index] == 0) {
            index = (index + 1) % list.length;
            if (startIndex == index) {
                return -1;
            }
        }
        int result = list[index];
        list[index] = Math.max(0, list[index] - 1);
        index = (index + 1) % list.length;
        return result;
    }

    public boolean isFinished() {
        for (int el : list)
            if (el > 0) {
                return false;
            }
        return true;
    }
}
