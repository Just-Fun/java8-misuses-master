package com.xpinjection.java8.misused.practice;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ClockPractice {

    public static void main(String[] args) {

        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();

        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);   // legacy java.util.Date


        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        List<String> sorted = availableZoneIds.stream().sorted().collect(Collectors.toList());
        sorted.forEach(System.out::println);
// prints all available timezone ids

        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());

// ZoneRules[currentStandardOffset=+01:00]
// ZoneRules[currentStandardOffset=-03:00]

//        Тип LocalTime представляет собой время с учетом часового пояса, например, 10pm или 17:30:15.
//        В следующем примере создаются два местных времени для часовых поясов, определенных выше.
//        Затем оба времени сравниваются, и вычисляется разница между ними в часах и минутах.

        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);

        System.out.println(now1.isBefore(now2));  // false

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

        System.out.println(hoursBetween);       // -3
        System.out.println(minutesBetween);
    }
}
