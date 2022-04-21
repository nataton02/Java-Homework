import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
        // 1. get today's date
        LocalDate today = LocalDate.now();
        System.out.println(today);

        // 2. get current year, month, day information
        System.out.println(" Today is " + today.getDayOfWeek() + " " + today.getDayOfMonth() + " " + today.getMonth()
                + " " + today.getYear());

        // 3. create custom date
        LocalDate customDate = LocalDate.parse("2020-02-02");
        LocalDate customDate2 = LocalDate.of(2000, 10, 5);
        System.out.println(customDate);
        System.out.println(customDate2);

        // 4. create two dates and compare if they are equal
        LocalDate someDay1 = LocalDate.of(2022, 4, 20);
        LocalDate someDay2 = LocalDate.of(2021, 4, 20);
        System.out.println(someDay1.isEqual(someDay2));//false

        // 5. get current time
        LocalTime now = LocalTime.now();
        System.out.println(now);

        // 6. calculate new time = 3 hours plus current
        LocalTime newTime = now.plusHours(3);
        System.out.println(newTime);

        // 7. calculate a date which is one week from now
        LocalDate oneWeekFromNow = today.plusWeeks(1);
        System.out.println(oneWeekFromNow);

        // 8. calculate the date a year ago using the minus() method
        LocalDate oneYearAgo = today.minusYears(1);
        System.out.println(oneYearAgo);

        // 9. calculate the date a year after using the plus() method
        LocalDate oneYearAfter = today.plusYears(1);
        System.out.println(oneYearAfter);

        // 10. create dates tomorrow and yesterday and check if they are before or after the current date
        LocalDate tomorrow = today.plusDays(1);
        LocalDate yesterday = today.minusDays(1);
        System.out.println(tomorrow.isAfter(today));
        System.out.println(yesterday.isBefore(today));

        // 11. find local time in NewYork, Berlin, Moscow
        ZonedDateTime zonedDateTimeBerlin = ZonedDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()),
                ZoneId.of("Europe/Berlin"));
        ZonedDateTime zonedDateTimeNewYork = zonedDateTimeBerlin.withZoneSameInstant(ZoneId.of("America/New_York"));
        ZonedDateTime zonedDateTimeMoscow = zonedDateTimeBerlin.withZoneSameInstant(ZoneId.of("Europe/Moscow"));

        System.out.println(zonedDateTimeBerlin);
        System.out.println(zonedDateTimeNewYork);
        System.out.println(zonedDateTimeMoscow);

        // 12. check if today is a leap year
        System.out.println(checkIfIsLeapYear(today));// false
        System.out.println(checkIfIsLeapYear(LocalDate.of(2000, 1, 1)));// true
        System.out.println(checkIfIsLeapYear(LocalDate.of(1900, 1, 1)));// false

        // 13. calculate the number of months between current date the date you joined Telran
        LocalDate joinedTelran = LocalDate.of(2021, 9, 21);
        System.out.println(ChronoUnit.MONTHS.between(joinedTelran, today));

        // 14. given is the day after tomorrow date as "20220409" string. Convert it into basic iso date
        // format 2022-04-09
        LocalDate tomorrowDate = LocalDate.now().plusDays(1);
        DateTimeFormatter nonDashFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String tomorrowStringFormat = nonDashFormatter.format(tomorrowDate);
        System.out.println(tomorrowStringFormat);

        StringBuilder sb = new StringBuilder(tomorrowStringFormat);
        sb.insert(4, "-");
        sb.insert(7, "-");

        DateTimeFormatter basicFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate tomorrowBasicFormat = LocalDate.parse(sb, basicFormatter);
        System.out.println(tomorrowBasicFormat);

        // 15. given is local DateTime now. Convert it in string in the following format "2022/04/09 11:00:22"
        LocalDateTime nowLDT = LocalDateTime.now();
        System.out.println(nowLDT);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String stringFormat = dtf.format(nowLDT);
        System.out.println(stringFormat);
        
    }

    // 12. check if today is a leap year
    public static boolean checkIfIsLeapYear (LocalDate today) {
        if (today.getYear() % 4 == 0) {
            if (today.getYear() % 100 != 0 || (today.getYear() % 100 == 0 && today.getYear() % 400 == 0))
                return true;
        }
        return false;
    }


}
