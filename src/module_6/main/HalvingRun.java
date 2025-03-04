package module_6.main;

import java.util.List;

public class HalvingRun extends CarouselRun {

    public HalvingRun(List<Integer> element) {
        super(element);
    }

    @Override
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
        int decrement = 2;
        list[index] = Math.max(0, list[index] / decrement);
        index = (index + 1) % list.length;
        return result;
    }


}
