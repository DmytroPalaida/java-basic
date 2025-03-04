package module_2.main;

import java.time.Duration;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        /*
        ZonedDateTime nowZoned = ZonedDateTime.now();
        Instant midnight = nowZoned.toLocalDate().atStartOfDay(nowZoned.getZone()).toInstant();
        Instant currentTime = midnight.plus(seconds, ChronoUnit.SECONDS);
        Duration duration = Duration.between(midnight, currentTime);
        String hms = String.format("%d:%02d:%02d",
                duration.toHours() % 24,
                duration.toMinutesPart(),
                duration.toSecondsPart());
        System.out.println(hms);
*/

        int hours = seconds / 60 / 60;
        int minutes = (seconds / 60) - (hours * 60);
        int second = seconds % 60;

        String hms = String.format("%01d:%02d:%02d", hours%24, minutes, second);
        System.out.println(hms);

    }
}
