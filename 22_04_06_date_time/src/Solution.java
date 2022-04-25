import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Solution {

    public static void main(String[] args) {

        // 1. Узнать день недели, в котором вы родились
        LocalDate myBirthday = LocalDate.of(1985, 8, 2);
        System.out.println(myBirthday.getDayOfWeek());


        // 2. Узнать количество дней до нового года, при условии, что нельзя явно указывать год.
        LocalDate today = LocalDate.now();
        System.out.println(getNumbersOfDaysUntilNewYear(today));


        // 3. Узнать количество дней до дня рождения, при уловии, что дан только день рождения без года.
        System.out.println(getNumbersOfDaysUntilBirthday(today, 1, 1));
        System.out.println(getNumbersOfDaysUntilBirthday(today, 5, 1));

    }


    public static int getNumbersOfDaysUntilNewYear(LocalDate date) {
        LocalDate newYear = LocalDate.of(date.getYear(), 12, 31);
        return (int) ChronoUnit.DAYS.between(date, newYear);
    }


    public static int getNumbersOfDaysUntilBirthday(LocalDate date, int monthOfBirth, int dayOfBirth) {
        LocalDate birthday = LocalDate.of(date.getYear(), monthOfBirth, dayOfBirth);

        if (birthday.isBefore(date)) {
            LocalDate nextBirthday = birthday.withYear(birthday.getYear() + 1);
            return (int) ChronoUnit.DAYS.between(date, nextBirthday);
        }
        else return (int) ChronoUnit.DAYS.between(date, birthday);
    }

}
