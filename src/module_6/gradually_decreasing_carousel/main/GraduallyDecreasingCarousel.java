package module_6.gradually_decreasing_carousel.main;

/**
 * Клас, що представляє карусель зі зменшенням значень, де кожен елемент
 * зменшується поступово з наростаючою швидкістю.
 */
public class GraduallyDecreasingCarousel extends DecrementingCarousel {
    /**
     * Конструктор, що ініціалізує карусель із заданою місткістю.
     *
     * @param capacity максимальна кількість елементів у каруселі.
     */
    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
    }

    /**
     * Запускає карусель, створюючи об'єкт {@link GraduallyCarouselRun}.
     * Карусель можна запустити лише один раз.
     *
     * @return об'єкт {@link GraduallyCarouselRun} або null, якщо карусель вже була запущена.
     */
    @Override
    public CarouselRun run() {
        if (isRun) {
            return null;
        }
        isRun = true;
        return new GraduallyCarouselRun(list);
    }
}

