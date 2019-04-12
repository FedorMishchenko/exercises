package part1.ex1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatter {
    private static Calendar calendar;
    private static Calendar calendar2;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Command line args must be not null");
        } else {
            Date currentDate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat();
            System.out.printf("%s%n", dateFormat.format(currentDate));
            calendar2 = Calendar.getInstance();
            calendar2.setTime(currentDate);
            System.out.printf("%n%s%n", calendar2.getTime());
            System.out.printf("%n%s: ", "Student");

            String str = args[0];
            System.out.printf("%s", str.substring(0, 1).toUpperCase());
            System.out.printf("%s ", str.substring(1).toLowerCase());

            calendar = Calendar.getInstance();
            calendar.set(Calendar.MONTH, Calendar.APRIL);
            calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(args[1]));
            System.out.printf("%n%n%s%n", calendar.getTime());
        }
    }
}
