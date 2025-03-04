package module_6.main;

public class HalvingCarousel extends DecrementingCarousel {
    public HalvingCarousel(final int capacity) {
        super(capacity);

    }
    @Override
    public CarouselRun run() {
        if (isRun) {
            return null;
        }
        isRun = true;
        return new HalvingRun(list);
    }
}
